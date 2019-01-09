package fr.brucella.projects.libraryws.business.impl.managers.books;

import fr.brucella.projects.libraryws.business.contracts.managers.books.BooksManagementManager;
import fr.brucella.projects.libraryws.business.impl.managers.AbstractManager;
import fr.brucella.projects.libraryws.entity.books.dto.BookBorrowsCountDto;
import fr.brucella.projects.libraryws.entity.books.dto.BookDetailsDto;
import fr.brucella.projects.libraryws.entity.books.dto.BookStockDto;
import fr.brucella.projects.libraryws.entity.books.dto.BorrowDto;
import fr.brucella.projects.libraryws.entity.books.model.BookBorrowed;
import fr.brucella.projects.libraryws.entity.books.model.BookReservation;
import fr.brucella.projects.libraryws.entity.books.model.Stock;
import fr.brucella.projects.libraryws.entity.exceptions.FunctionalException;
import fr.brucella.projects.libraryws.entity.exceptions.NotFoundException;
import fr.brucella.projects.libraryws.entity.exceptions.TechnicalException;
import fr.brucella.projects.libraryws.entity.users.model.User;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

/**
 * The Books Management Manager.
 *
 * @author BRUCELLA2
 */
@Component
public class BooksManagementManagerImpl extends AbstractManager implements BooksManagementManager {

  /** Books Borrowed Listing Manager logger */
  private static final Log LOG = LogFactory.getLog(BooksManagementManagerImpl.class);

  /** Number of days for a borrow or an extension of a borrow. */
  private static final Integer NB_DAYS_BORROW = Integer.parseInt(config.getString("nbDaysBorrow"));

  /** Default Constructor */
  public BooksManagementManagerImpl() {
    super();
  }

  /** {@inheritDoc} */
  @Override
  public List<User> getUsersDeadlineExpired() throws TechnicalException {

    try {
      return this.getDaoFactory().getUserDao().getUserWithBorrowsExpired();
    } catch (NotFoundException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug(exception.getMessage());
      }
      return new ArrayList<>();
    }
  }

  /** {@inheritDoc} */
  @Override
  public void reminderToUsers() throws TechnicalException {

    List<User> users = new ArrayList<>();

    try {
      users = this.getDaoFactory().getUserDao().getUserWithBorrowsExpired();
    } catch (NotFoundException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug(exception.getMessage());
      }
    }

    sendReminderMails(config.getString("mail.host"), Integer.valueOf(config.getString("mail.port")), config.getString("mail.username"), config.getString("mail.password"), users);
  }

  /** {@inheritDoc} */
  @Override
  public List<BookStockDto> getStocksList() throws TechnicalException {

    try {
      return this.getDaoFactory().getStockDao().getBookStockList();
    } catch (NotFoundException exception) {
      LOG.error(exception.getMessage());
    }
    return new ArrayList<>();
  }

  /** {@inheritDoc} */
  @Override
  public List<BorrowDto> getBorrowsHistory() throws TechnicalException {

    try {
      return this.getDaoFactory().getBookBorrowedDao().getAllBorrows();
    } catch (NotFoundException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug(exception.getMessage());
      }
      return new ArrayList<>();
    }
  }

  /** {@inheritDoc} */
  @Override
  public List<BookBorrowsCountDto> getNbBorrowsByBooks() throws TechnicalException {

    try {
      return this.getDaoFactory().getBookBorrowedDao().countBorrowsByBook();
    } catch (NotFoundException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug(exception.getMessage());
      }
      return new ArrayList<>();
    }
  }

  /** {@inheritDoc} */
  @Override
  public Integer bookBorrowing(final Integer bookId, final Integer userId)
      throws TechnicalException, FunctionalException {

    if (bookId == null || userId == null) {
      LOG.error("bookId = " + bookId);
      LOG.error("userId = " + userId);
      throw new FunctionalException(
          messages.getString("booksManagementManager.bookBorrowing.userOrBookNull"));
    }

    final BookBorrowed bookBorrowed = new BookBorrowed();
    bookBorrowed.setBookId(bookId);
    bookBorrowed.setUserId(userId);
    bookBorrowed.setBorrowDate(LocalDate.now());
    bookBorrowed.setEndDate(LocalDate.now().plusDays(NB_DAYS_BORROW));
    bookBorrowed.setExtension(false);
    bookBorrowed.setNbReminder(0);
    bookBorrowed.setReturned(false);

    Stock stock = new Stock();
    Stock newStock = new Stock();
    try {
      stock = this.getDaoFactory().getStockDao().getStockForBook(bookId);
      if(stock.getAmount() < 1) {
        LOG.error(messages.getString("booksManagementManager.bookBorrowing.noEnoughStock"));
        throw new FunctionalException(messages.getString("booksManagementManager.bookBorrowing.noEnoughStock"));
      }
      newStock = stock;
      newStock.setAmountAvailable(stock.getAmountAvailable()-1);
      this.getDaoFactory().getStockDao().updateStock(newStock);
      return this.getDaoFactory().getBookBorrowedDao().insertBookBorrowed(bookBorrowed);
    } catch (NotFoundException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug(exception.getMessage());
      }
      throw new FunctionalException(exception.getMessage(), exception);
    }
  }

  /** {@inheritDoc} */
  @Override
  public Boolean extendBorrow(final Integer bookBorrowedId)
      throws TechnicalException, FunctionalException {

    if (bookBorrowedId == null) {
      LOG.error("bookBorrowedId = " + bookBorrowedId);
      throw new FunctionalException(
          messages.getString("booksManagementManager.extendBorrow.idNull"));
    }

    final BookBorrowed bookBorrowed;

    try {
      bookBorrowed = this.getDaoFactory().getBookBorrowedDao().getBookBorrowed(bookBorrowedId);
    } catch (NotFoundException exception) {
      LOG.error(exception.getMessage());
      throw new FunctionalException(exception.getMessage(), exception);
    }

    if (bookBorrowed.getExtension()) {
      LOG.error(messages.getString("booksManagementManager.extendBorrow.extensionTrue"));
      throw new FunctionalException(
          messages.getString("booksManagementManager.extendBorrow.extensionTrue"));
    }

    if (bookBorrowed.getReturned()) {
      LOG.error(messages.getString("booksManagementManager.extendBorrow.returned"));
      throw new FunctionalException(
          messages.getString("booksManagementManager.extendBorrow.returned"));
    }

    if (bookBorrowed.getEndDate().isBefore(LocalDate.now())) {
      LOG.error(messages.getString("booksManagementManager.extendBorrow.endPassed"));
      throw new FunctionalException(
          messages.getString("booksManagementManager.extendBorrow.endPassed"));
    }

    final BookBorrowed bookBorrowedUpdated = bookBorrowed;
    bookBorrowedUpdated.setEndDate(bookBorrowedUpdated.getEndDate().plusDays(NB_DAYS_BORROW));
    bookBorrowedUpdated.setNbReminder(0);
    bookBorrowedUpdated.setExtension(true);
    bookBorrowedUpdated.setLastReminder(null);

    try {
      this.getDaoFactory().getBookBorrowedDao().updateBookBorrowed(bookBorrowedUpdated);
    } catch (NotFoundException exception) {
      LOG.error(exception.getMessage());
      throw new FunctionalException(exception.getMessage(), exception);
    }

    return true;
  }

  /** {@inheritDoc} */
  @Override
  public Boolean returnBorrow(final Integer bookBorrowedId)
      throws TechnicalException, FunctionalException {

    if (bookBorrowedId == null) {
      LOG.error("bookBorrowedId = " + bookBorrowedId);
      throw new FunctionalException(
          messages.getString("booksManagementManager.returnBorrow.idNull"));
    }

    final BookBorrowed bookBorrowed;

    try {
      bookBorrowed = this.getDaoFactory().getBookBorrowedDao().getBookBorrowed(bookBorrowedId);
    } catch (NotFoundException exception) {
      LOG.error(exception.getMessage());
      throw new FunctionalException(exception.getMessage(), exception);
    }

    if (bookBorrowed.getReturned()) {
      LOG.error(messages.getString("booksManagementManager.returnBorrow.returned"));
      throw new FunctionalException(
          messages.getString("booksManagementManager.returnBorrow.returned"));
    }

    BookBorrowed bookBorrowedUpdated = bookBorrowed;
    bookBorrowed.setReturned(true);

    try {
      this.getDaoFactory().getBookBorrowedDao().updateBookBorrowed(bookBorrowedUpdated);
    } catch (NotFoundException exception) {
      LOG.error(exception.getMessage());
      throw new FunctionalException(exception.getMessage());
    }

    return true;
  }

  /** {@inheritDoc} */
  @Override
  public BookDetailsDto getBookWithDetails(final Integer bookId)
      throws TechnicalException, FunctionalException {

    if (bookId == null) {
      LOG.error("bookId = " + bookId);
      throw new FunctionalException(
          messages.getString("booksManagementManager.getBookWithDetails.idNull"));
    }

    try {
      return this.getDaoFactory().getBookDao().getBookDetails(bookId);
    } catch (NotFoundException exception) {
      LOG.error(exception.getMessage());
      throw new FunctionalException(exception.getMessage(), exception);
    }
  }

  /** {@inheritDoc} */
  @Override
  public Integer bookReservation(Integer bookId, Integer userId)
      throws TechnicalException, FunctionalException {

    if (bookId == null || userId == null) {
      LOG.error("bookId = " + bookId);
      LOG.error("userId = " + userId);
      throw new FunctionalException(
          messages.getString("booksManagementManager.bookReservation.userOrBookNull"));
    }

    try {
      List<BookReservation> listActiveReservation = getDaoFactory().getBookReservationDao().getActiveReservationListForBook(bookId);
      Stock stock = getDaoFactory().getStockDao().getStockForBook(bookId);

      // Check if number of reservation is not 2 * the amount of book.
      if (listActiveReservation.size() > (2 * stock.getAmount())) {
        throw new FunctionalException(messages.getString("booksManagementManager.bookReservation.reservationfull"));
      }

      // Check if the book is already borrow by the user.
      List<BorrowDto> listBookBorrowed = getDaoFactory().getBookBorrowedDao().getUserBorrows(userId, true);
      for (BorrowDto borrow : listBookBorrowed) {
        if (borrow.getBookId().equals(bookId)) {
          throw new FunctionalException(messages.getString("booksManagementManager.bookReservation.alreadyBorrow"));
        }
      }

      // If all checks are ok, reservation is done
      BookReservation bookReservation = new BookReservation();
      bookReservation.setBookId(bookId);
      bookReservation.setUserId(userId);
      bookReservation.setActiveReservation(true);
      bookReservation.setDateReservation(LocalDate.now());

      return getDaoFactory().getBookReservationDao().insertBookReservation(bookReservation);

    } catch (NotFoundException exception) {
      LOG.error(exception.getMessage());
      throw new FunctionalException(exception.getMessage(), exception);
    }
  }

  /** {@inheritDoc} */
  @Override
  public void cancelReservation(Integer bookReservationId) throws TechnicalException, FunctionalException {
    if (bookReservationId == null) {
      LOG.error("bookReservationId = " + bookReservationId);
      throw new FunctionalException(
          messages.getString("booksManagementManager.cancelReservation.idNull"));
    }

    try {
      BookReservation bookReservation = getDaoFactory().getBookReservationDao().getBookReservation(bookReservationId);
      bookReservation.setActiveReservation(false);
      getDaoFactory().getBookReservationDao().updateBookReservation(bookReservation);
    } catch (NotFoundException exception) {
      LOG.error(exception.getMessage());
      throw new FunctionalException(exception.getMessage(), exception);
    }
  }

  /**
   * Send reminder emails.
   *
   * @param host smtp host.
   * @param port smtp host port.
   * @param username username for smtp authentication.
   * @param password password for smtp authentication.
   * @param users list of User to send the reminder mails.
   * @throws TechnicalException
   */
  private void sendReminderMails(
      String host, Integer port, String username, String password, List<User> users)
      throws TechnicalException {

    Properties prop = new Properties();
    prop.put("mail.smtp.auth", true);
    prop.put("mail.smtp.starttls.enable", "true");
    prop.put("mail.smtp.host", host);
    prop.put("mail.smtp.port", port);
    prop.put("mail.smtp.ssl.trust", host);

    LOG.error(prop.stringPropertyNames());
    LOG.error("Prop text :" + prop.toString());

    Session session =
        Session.getInstance(
            prop,
            new Authenticator() {
              @Override
              protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
              }
            });
    session.setDebug(true);
    for (User user : users) {
      try {

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(config.getString("mail.sender")));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(user.getEmail()));
        message.setSubject(messages.getString("booksManagementManager.sendReminderMails.object"));

        String msg = messages.getString("booksManagementManager.sendReminderMails.mail");

        LOG.error("Message : " + msg);

        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setContent(msg, "text/html");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(mimeBodyPart);

        message.setContent(multipart);

        Transport.send(message);
      } catch (Exception exception) {
        LOG.error("Email error : " + exception.getMessage());
        throw new TechnicalException(exception.getMessage(), exception);
      }
    }
  }
}
