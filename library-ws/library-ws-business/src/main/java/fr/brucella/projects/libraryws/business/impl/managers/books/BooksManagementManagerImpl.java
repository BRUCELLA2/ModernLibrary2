package fr.brucella.projects.libraryws.business.impl.managers.books;

import fr.brucella.projects.libraryws.business.contracts.managers.books.BooksManagementManager;
import fr.brucella.projects.libraryws.business.impl.managers.AbstractManager;
import fr.brucella.projects.libraryws.entity.books.dto.BookBorrowsCountDto;
import fr.brucella.projects.libraryws.entity.books.dto.BookStockDto;
import fr.brucella.projects.libraryws.entity.books.dto.BorrowDto;
import fr.brucella.projects.libraryws.entity.books.model.BookBorrowed;
import fr.brucella.projects.libraryws.entity.exceptions.FunctionalException;
import fr.brucella.projects.libraryws.entity.exceptions.NotFoundException;
import fr.brucella.projects.libraryws.entity.exceptions.TechnicalException;
import fr.brucella.projects.libraryws.entity.users.model.User;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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

  private static final Integer NB_DAYS_BORROW = 15;

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
  public Integer bookBorrowing(Integer bookId, Integer userId) throws TechnicalException, FunctionalException {

    // TODO if user have an active borrow for this book, a new borrow should not be possible.
    if(bookId == null || userId == null) {
      LOG.error("bookId = " + bookId);
      LOG.error("userId = " + userId);
      throw new FunctionalException(messages.getString("booksManagementManager.bookBorrowing.userOrBookNull"));
    }

    BookBorrowed bookBorrowed = new BookBorrowed();
    bookBorrowed.setBookId(bookId);
    bookBorrowed.setUserId(userId);
    bookBorrowed.setBorrowDate(LocalDate.now());
    bookBorrowed.setEndDate(LocalDate.now().plusDays(NB_DAYS_BORROW));
    bookBorrowed.setExtension(false);
    bookBorrowed.setNbReminder(0);
    bookBorrowed.setReturned(false);

    return this.getDaoFactory().getBookBorrowedDao().insertBookBorrowed(bookBorrowed);
  }

  /** {@inheritDoc} */
  @Override
  public Boolean extendBorrow(Integer bookBorrowedId) throws TechnicalException, FunctionalException {

    // TODO add transaction management

    if(bookBorrowedId == null) {
      LOG.error("bookBorrowedId = " + bookBorrowedId);
      throw new FunctionalException(messages.getString("booksManagementManager.extendBorrow.idNull"));
    }

    final BookBorrowed bookBorrowed;

    try {
      bookBorrowed = this.getDaoFactory().getBookBorrowedDao().getBookBorrowed(bookBorrowedId);
    } catch (NotFoundException exception) {
      LOG.error(messages.getString("booksManagementManager.extendBorrow.notFound"));
      throw new FunctionalException(messages.getString("booksManagementManager.extendBorrow.notFound"));
    }

    if (bookBorrowed.getExtension()) {
      LOG.error(messages.getString("booksManagementManager.extendBorrow.extensionTrue"));
      throw new FunctionalException(messages.getString("booksManagementManager.extendBorrow.extensionTrue"));
    }

    if(bookBorrowed.getReturned()) {
      LOG.error(messages.getString("booksManagementManager.extendBorrow.returned"));
      throw new FunctionalException(messages.getString("booksManagementManager.extendBorrow.returned"));
    }

    if (bookBorrowed.getEndDate().isBefore(LocalDate.now())){
      LOG.error(messages.getString("booksManagementManager.extendBorrow.endPassed"));
      throw new FunctionalException(messages.getString("booksManagementManager.extendBorrow.endPassed"));
    }

    BookBorrowed bookBorrowedupgraded = bookBorrowed;
    bookBorrowedupgraded.setEndDate(bookBorrowedupgraded.getEndDate().plusDays(NB_DAYS_BORROW));
    bookBorrowedupgraded.setNbReminder(0);
    bookBorrowedupgraded.setExtension(true);
    bookBorrowedupgraded.setLastReminder(null);

    try {
      this.getDaoFactory().getBookBorrowedDao().updateBookBorrowed(bookBorrowedupgraded);
    } catch (NotFoundException exception) {
      LOG.error(messages.getString("booksManagementManager.extendBorrow.notFound"));
      throw new FunctionalException(messages.getString("booksManagementManager.extendBorrow.notFound"));
    }

    return true;
  }


}
