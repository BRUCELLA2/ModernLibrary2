package fr.brucella.projects.libraryws.services;

import fr.brucella.projects.libraryws.business.contracts.ManagerFactory;
import fr.brucella.projects.libraryws.entity.books.dto.BookBorrowsCountDto;
import fr.brucella.projects.libraryws.entity.books.dto.BookDetailsDto;
import fr.brucella.projects.libraryws.entity.books.dto.BookStockDto;
import fr.brucella.projects.libraryws.entity.books.dto.BorrowDto;
import fr.brucella.projects.libraryws.entity.books.dto.CurrentlyBorrowExpiredDto;
import fr.brucella.projects.libraryws.entity.books.dto.ReservationDetailsDto;
import fr.brucella.projects.libraryws.entity.books.dto.UserCurrentlyBorrowDto;
import fr.brucella.projects.libraryws.entity.books.model.BookReservation;
import fr.brucella.projects.libraryws.entity.exceptions.FunctionalException;
import fr.brucella.projects.libraryws.entity.exceptions.LibraryWsException;
import fr.brucella.projects.libraryws.entity.exceptions.LibraryWsFault;
import fr.brucella.projects.libraryws.entity.exceptions.TechnicalException;
import fr.brucella.projects.libraryws.entity.searchcriteria.dto.BooksSearchClientCriteriaDto;
import fr.brucella.projects.libraryws.entity.users.model.User;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 * Book Web Service (related to book details, books listing, books management).
 *
 * @author BRUCELLA2
 */
@WebService(serviceName = "BookService")
@Component
public class BookService extends SpringBeanAutowiringSupport {

  /** Book Service Logger */
  private static final Log LOG = LogFactory.getLog(BookService.class);

  /** String message give to user for technical problem in LibraryWsException */
  private static final String TECH_ERROR = "Problème technique";

  /** String message give to user for functional problem in LibraryWsException */
  private static final String FUNC_ERROR = "Erreur fonctionnelle";

  /** Fault Code for server fault */
  private static final String SERVER = "soap:Server";

  /** Fault Code for client fault */
  private static final String CLIENT = "soap:Client";

  // ----- Manager
  /** The Manager Factory Manager Factory allow to get and set business managers. */
  @Autowired private ManagerFactory managerFactory;

  /** Default constructor. */
  public BookService() {
    // This constructor is intentionally empty.
  }

  // ===== WebMethods ===== //

  // ===== Books borrowed

  /**
   * Provides the list of currently borrows with login of the user and title of the book.
   *
   * @return the list of currently borrows with login of the user and title of the book.
   * @throws LibraryWsException Throw this exception if there is a technical problem.
   */
  @WebMethod
  public List<BorrowDto> currentlyBooksBorrowedList() throws LibraryWsException {

    try {

      return this.managerFactory.getBooksBorrowedListingManager().currentlyBooksBorrow();

    } catch (TechnicalException exception) {
      LOG.error(exception.getMessage());
      throw new LibraryWsException(
          TECH_ERROR, exception, new LibraryWsFault(SERVER, exception.getMessage()));
    }
  }

  /**
   * Provides the list of books currently borrowed by the user.
   *
   * @param userId id of the user.
   * @return the list of books currently borrowed by the user.
   * @throws LibraryWsException Throw this exception if there is a technical problem or a null
   *     userId.
   */
  @WebMethod
  public List<BorrowDto> currentlyBorrowForUser(final Integer userId) throws LibraryWsException {

    try {
      return this.managerFactory.getBooksBorrowedListingManager().userCurrentlyBorrow(userId);
    } catch (FunctionalException exception) {
      LOG.error(exception.getMessage());
      throw new LibraryWsException(
          FUNC_ERROR, exception, new LibraryWsFault(CLIENT, exception.getMessage()));
    } catch (TechnicalException exception) {
      LOG.error(exception.getMessage());
      throw new LibraryWsException(
          TECH_ERROR, exception, new LibraryWsFault(SERVER, exception.getMessage()));
    }
  }

  /**
   * Provides the list of books borrowed returned by the user.
   *
   * @param userId id of the user.
   * @return the list of books borrowed returned by the user.
   * @throws LibraryWsException Throw this exception if there is a technical problem or a null
   *     userId.
   */
  @WebMethod
  public List<BorrowDto> returnedBorrowsForUser(final Integer userId) throws LibraryWsException {

    try {
      return this.managerFactory.getBooksBorrowedListingManager().userReturnBorrow(userId);
    } catch (FunctionalException exception) {
      LOG.error(exception.getMessage());
      throw new LibraryWsException(
          FUNC_ERROR, exception, new LibraryWsFault(CLIENT, exception.getMessage()));
    } catch (TechnicalException exception) {
      LOG.error(exception.getMessage());
      throw new LibraryWsException(
          TECH_ERROR, exception, new LibraryWsFault(SERVER, exception.getMessage()));
    }
  }

  /**
   * Provides the list of currently borrowed books which have an expired deadline.
   *
   * @return the list of currently borrowed books which have an expired deadline.
   * @throws LibraryWsException Throw this exception if there is a technical problem.
   */
  @WebMethod
  public List<CurrentlyBorrowExpiredDto> currentlyDeadlineExpired() throws LibraryWsException {

    try {
      return this.managerFactory.getBooksBorrowedListingManager().currentlyBorrowExpired();
    } catch (TechnicalException exception) {
      LOG.error(exception.getMessage());
      throw new LibraryWsException(
          TECH_ERROR, exception, new LibraryWsFault(SERVER, exception.getMessage()));
    }
  }

  /**
   * Provides the list of currently borrowed books which have an expired deadline for the user.
   *
   * @param userId id of the user.
   * @return the list of currently borrowed books which have an expired deadline for the user.
   * @throws LibraryWsException Throw this exception if there is a technical problem or a null
   *     userId.
   */
  @WebMethod
  public List<UserCurrentlyBorrowDto> currentlyDeadLineExpiredForUser(final Integer userId)
      throws LibraryWsException {

    try {
      return this.managerFactory
          .getBooksBorrowedListingManager()
          .userCurrentlyBorrowExpired(userId);
    } catch (FunctionalException exception) {
      LOG.error(exception.getMessage());
      throw new LibraryWsException(
          FUNC_ERROR, exception, new LibraryWsFault(CLIENT, exception.getMessage()));
    } catch (TechnicalException exception) {
      LOG.error(exception.getMessage());
      throw new LibraryWsException(
          TECH_ERROR, exception, new LibraryWsFault(SERVER, exception.getMessage()));
    }
  }

  // ===== Books Listing

  /**
   * Provides the list of all books.
   *
   * @return the list of all books.
   * @throws LibraryWsException Throw this exception if there is a technical problem.
   */
  @WebMethod
  public List<BookDetailsDto> allBooks() throws LibraryWsException {

    try {
      return this.managerFactory.getBooksListingManager().getAllBooks();
    } catch (TechnicalException exception) {
      LOG.error(exception.getMessage());
      throw new LibraryWsException(
          TECH_ERROR, exception, new LibraryWsFault(SERVER, exception.getMessage()));
    }
  }

  /**
   * Provides the list of books that meet the searching criteria.
   *
   * @param booksSearchClientCriteriaDto the book searching client criteria.
   * @return the list of books that meet the searching criteria.
   * @throws LibraryWsException Throw this exception if there is a technical problem or if the
   *     search criteria are null.
   */
  @WebMethod
  public List<BookDetailsDto> booksSearchedList(
      final BooksSearchClientCriteriaDto booksSearchClientCriteriaDto) throws LibraryWsException {

    try {
      return this.managerFactory
          .getBooksListingManager()
          .getSearchBooks(booksSearchClientCriteriaDto);
    } catch (FunctionalException exception) {
      LOG.error(exception.getMessage());
      throw new LibraryWsException(
          FUNC_ERROR, exception, new LibraryWsFault(CLIENT, exception.getMessage()));
    } catch (TechnicalException exception) {
      LOG.error(exception.getMessage());
      throw new LibraryWsException(
          TECH_ERROR, exception, new LibraryWsFault(SERVER, exception.getMessage()));
    }
  }

  /**
   * Provides the list of books which can be borrowed.
   *
   * @return the list of books which can be borrowed.
   * @throws LibraryWsException Throw this exception if there is a technical problem.
   */
  @WebMethod
  public List<BookDetailsDto> availableBooksList() throws LibraryWsException {

    try {
      return this.managerFactory.getBooksListingManager().getBooksAvailable();
    } catch (TechnicalException exception) {
      LOG.error(exception.getMessage());
      throw new LibraryWsException(
          TECH_ERROR, exception, new LibraryWsFault(SERVER, exception.getMessage()));
    }
  }

  // ===== Books Management

  /**
   * Provides the list of users with currently borrow and deadline expired.
   *
   * @return the list of users with currently borrow and deadline expired.
   * @throws LibraryWsException Throw this exception if there is a technical problem.
   */
  @WebMethod
  public List<User> currentlyDeadlineExpiredUsers() throws LibraryWsException {

    try {
      return this.managerFactory.getBooksManagementManager().getUsersDeadlineExpired();
    } catch (TechnicalException exception) {
      LOG.error(exception.getMessage());
      throw new LibraryWsException(
          TECH_ERROR, exception, new LibraryWsFault(SERVER, exception.getMessage()));
    }
  }

  /**
   * Send a reminder email to all users with a borrow not returned with deadline expired.
   *
   * @throws LibraryWsException Throw this exception if there is a technical problem.
   */
  @WebMethod
  public void sendReminderToUsers() throws LibraryWsException {

    try {
      this.managerFactory.getBooksManagementManager().reminderToUsers();
    } catch (TechnicalException exception) {
      LOG.error(exception.getMessage());
      throw new LibraryWsException(
          TECH_ERROR, exception, new LibraryWsFault(SERVER, exception.getMessage()));
    }
  }

  /**
   * Send a mail to all users few days before borrow expire if they activate the options.
   *
   * @throws LibraryWsException
   */
  @WebMethod
  public void sendReminderBeforeExpirationToUsers() throws LibraryWsException {

    try {
      this.managerFactory.getBooksManagementManager().beforeReminderToUsers();
    } catch (TechnicalException exception) {
      LOG.error(exception.getMessage());
      throw new LibraryWsException(
          TECH_ERROR, exception, new LibraryWsFault(SERVER, exception.getMessage()));
    }
  }

  /**
   * Check reservation not picked up in the time allowed
   *
   * @throws LibraryWsException Throw this exception if there is a technical problem.
   */
  @WebMethod
  public void checkReservationNotPickedUp() throws LibraryWsException {

    try {
      this.managerFactory.getBooksManagementManager().reservationNotBorrowInTime();
    } catch (TechnicalException exception) {
      LOG.error(exception.getMessage());
      throw new LibraryWsException(
          TECH_ERROR, exception, new LibraryWsFault(SERVER, exception.getMessage()));
    }
  }

  /**
   * Provides the list of stocks for each book.
   *
   * @return the list of stocks for each book.
   * @throws LibraryWsException Throw this exception if there is a technical problem.
   */
  @WebMethod
  public List<BookStockDto> bookStocksList() throws LibraryWsException {

    try {
      return this.managerFactory.getBooksManagementManager().getStocksList();
    } catch (TechnicalException exception) {
      LOG.error(exception.getMessage());
      throw new LibraryWsException(
          TECH_ERROR, exception, new LibraryWsFault(SERVER, exception.getMessage()));
    }
  }

  /**
   * Provides the list of all borrow past and present.
   *
   * @return the borrows history sorted by date of borrow.
   * @throws LibraryWsException Throw this exception if there is a technical problem.
   */
  @WebMethod
  public List<BorrowDto> borrowingHistoryList() throws LibraryWsException {

    try {
      return this.managerFactory.getBooksManagementManager().getBorrowsHistory();
    } catch (TechnicalException exception) {
      LOG.error(exception.getMessage());
      throw new LibraryWsException(
          TECH_ERROR, exception, new LibraryWsFault(SERVER, exception.getMessage()));
    }
  }

  /**
   * Provides the list of number of borrowings for each book.
   *
   * @return the list of number of borrowings for each book.
   * @throws LibraryWsException Throw this exception if there is a technical problem.
   */
  @WebMethod
  public List<BookBorrowsCountDto> nbBorrowingByBooks() throws LibraryWsException {

    try {
      return this.managerFactory.getBooksManagementManager().getNbBorrowsByBooks();
    } catch (TechnicalException exception) {
      LOG.error(exception.getMessage());
      throw new LibraryWsException(
          TECH_ERROR, exception, new LibraryWsFault(SERVER, exception.getMessage()));
    }
  }

  // ===== Borrowings Management

  /**
   * Add a book borrowing.
   *
   * @param bookId id of the book borrowed.
   * @param userId id of the user who borrow the book.
   * @return id of the borrowing.
   * @throws LibraryWsException Throw this exception if there is a technical or functional problem.
   */
  @WebMethod
  public Integer bookBorrow(final Integer bookId, final Integer userId) throws LibraryWsException {

    if (bookId == null || userId == null) {
      LOG.error("bookId = " + bookId);
      LOG.error("userId = " + userId);
      throw new LibraryWsException(
          "Paramètre(s) incorrect(s). L'identifiant du livre et de l'utilisateur ne peuvent être vides",
          new LibraryWsFault(
              CLIENT,
              "Paramètre(s) incorrect(s). L'identifiant du livre et de l'utilisateur ne peuvent être vides"));
    }

    try {
      return this.managerFactory.getBooksManagementManager().bookBorrowing(bookId, userId);
    } catch (TechnicalException exception) {
      LOG.error(exception.getMessage());
      throw new LibraryWsException(
          TECH_ERROR, exception, new LibraryWsFault(SERVER, exception.getMessage()));
    } catch (FunctionalException exception) {
      LOG.error(exception.getMessage());
      throw new LibraryWsException(
          FUNC_ERROR, exception, new LibraryWsFault(CLIENT, exception.getMessage()));
    }
  }

  /**
   * Extends a book borrowing.
   *
   * @param bookBorrowedId id of the bookBorrowed.
   * @return true if extend success. Throw exception if not.
   * @throws LibraryWsException Throw this exception if there is a technical problem. Throw this
   *     exception if there is a functional problem : - if the id of the bookBorrowed is not valid -
   *     if the bookBorrowed is not found - if the book is already returned - if end date of borrow
   *     is passed - if the bookBorrowed is already extended
   */
  /*
   @TICKET #2
   if the end date of the borrow is passed, the functionalException is caught and the message is send to client
   with a LibraryWsException
  */
  @WebMethod
  public Boolean extendBorrowing(final Integer bookBorrowedId) throws LibraryWsException {

    if (bookBorrowedId == null) {
      LOG.error("bookBorrowedId = " + bookBorrowedId);
      throw new LibraryWsException(
          "Paramètre incorrect. L'identifiant de l'emprunt ne peut être vide.",
          new LibraryWsFault(
              CLIENT, "Paramètre incorrect. L'identifiant de l'emprunt ne peut être vide."));
    }

    try {
      return this.managerFactory.getBooksManagementManager().extendBorrow(bookBorrowedId);
    } catch (TechnicalException exception) {
      LOG.error(exception.getMessage());
      throw new LibraryWsException(
          TECH_ERROR, exception, new LibraryWsFault(SERVER, exception.getMessage()));
    } catch (FunctionalException exception) {
      LOG.error(exception.getMessage());
      throw new LibraryWsException(
          FUNC_ERROR, exception, new LibraryWsFault(CLIENT, exception.getMessage()));
    }
  }

  /**
   * Finished a book borrowing (Tag the bookBorrowed as return).
   *
   * @param bookBorrowedId id of the bookBorrowed.
   * @return true if the borrowing return if a success. Throw exception if not.
   * @throws LibraryWsException Throw this exception if there is a technical problem. Throw this
   *     exception if there is a functional problem : - if the id of the bookBorrowed is not valid -
   *     if the bookBorrowed is not found - if the book is already returned
   */
  @WebMethod
  public Boolean borrowingReturn(final Integer bookBorrowedId) throws LibraryWsException {

    if (bookBorrowedId == null) {
      LOG.error("bookBorrowedId = " + bookBorrowedId);
      throw new LibraryWsException(
          "Paramètre incorrect. L'identifiant de l'emprunt ne peut être vide.",
          new LibraryWsFault(
              CLIENT, "Paramètre incorrect. L'identifiant de l'emprunt ne peut être vide."));
    }

    try {
      return this.managerFactory.getBooksManagementManager().returnBorrow(bookBorrowedId);
    } catch (TechnicalException exception) {
      LOG.error(exception.getMessage());
      throw new LibraryWsException(
          TECH_ERROR, exception, new LibraryWsFault(SERVER, exception.getMessage()));
    } catch (FunctionalException exception) {
      LOG.error(exception.getMessage());
      throw new LibraryWsException(
          FUNC_ERROR, exception, new LibraryWsFault(CLIENT, exception.getMessage()));
    }
  }

  // ===== Book Details

  /**
   * Return the book details.
   *
   * @param bookId id of the book.
   * @return the book details DTO.
   * @throws LibraryWsException Throw this exception if there is a technical problem. Throw this
   *     exception if there is a functional problem : - if the id of the book is not valid - if the
   *     book is not found
   */
  public BookDetailsDto bookDetails(final Integer bookId) throws LibraryWsException {

    if (bookId == null) {
      LOG.error("bookId = " + bookId);
      throw new LibraryWsException(
          "Paramètre incorrect. L'identifiant du livre ne peut être vide.",
          new LibraryWsFault(
              CLIENT, "Paramètre incorrect. L'identifiant du livre ne peut être vide."));
    }

    try {
      return this.managerFactory.getBooksManagementManager().getBookWithDetails(bookId);
    } catch (TechnicalException exception) {
      LOG.error(exception.getMessage());
      throw new LibraryWsException(
          TECH_ERROR, exception, new LibraryWsFault(SERVER, exception.getMessage()));
    } catch (FunctionalException exception) {
      LOG.error(exception.getMessage());
      final LibraryWsException libraryWsException =
          new LibraryWsException(
              FUNC_ERROR, exception, new LibraryWsFault(CLIENT, exception.getMessage()));
      LOG.error(libraryWsException.toString());
      throw libraryWsException;
    }
  }

  // ===== Reservation Management

  /**
   * Return the id of the reservation.
   *
   * @param bookId id of the book.
   * @param userId id of the user.
   * @return the id of the reservation
   * @throws LibraryWsException Throw this exception if there is a technical or functional problem.
   */
  @WebMethod
  public Integer makeReservation(final Integer bookId, final Integer userId)
      throws LibraryWsException {

    if (bookId == null || userId == null) {
      LOG.error("bookId = " + bookId);
      LOG.error("userId = " + userId);
      throw new LibraryWsException(
          "Paramètre(s) incorrect(s). L'identifiant du livre et de l'utilisateur ne peuvent être vides",
          new LibraryWsFault(
              CLIENT,
              "Paramètre(s) incorrect(s). L'identifiant du livre et de l'utilisateur ne peuvent être vides"));
    }

    try {
      return this.managerFactory.getBooksManagementManager().bookReservation(bookId, userId);
    } catch (TechnicalException exception) {
      LOG.error(exception.getMessage());
      throw new LibraryWsException(
          TECH_ERROR, exception, new LibraryWsFault(SERVER, exception.getMessage()));
    } catch (FunctionalException exception) {
      LOG.error(exception.getMessage());
      throw new LibraryWsException(
          FUNC_ERROR, exception, new LibraryWsFault(CLIENT, exception.getMessage()));
    }
  }

  /**
   * Cancel a reservation (set the activeReservation attribut to false)
   *
   * @param reservationId id of the reservation.
   * @throws LibraryWsException Throw this exception if there is a technical or functional problem.
   */
  @WebMethod
  public void cancelAreservation(final Integer reservationId) throws LibraryWsException {

    if (reservationId == null) {
      LOG.error("reservationId = " + reservationId);
      throw new LibraryWsException(
          "Paramètre incorrect. L'identifiant de la réservation ne peut être vide",
          new LibraryWsFault(
              CLIENT, "Paramètre incorrect. L'identifiant de la réservation ne peut être vide"));
    }

    try {
      this.managerFactory.getBooksManagementManager().cancelReservation(reservationId);
    } catch (TechnicalException exception) {
      LOG.error(exception.getMessage());
      throw new LibraryWsException(
          TECH_ERROR, exception, new LibraryWsFault(SERVER, exception.getMessage()));
    } catch (FunctionalException exception) {
      LOG.error(exception.getMessage());
      throw new LibraryWsException(
          FUNC_ERROR, exception, new LibraryWsFault(CLIENT, exception.getMessage()));
    }
  }

  /**
   * Return the list of active reservations for the user.
   *
   * @param userId id of the user.
   * @return the list of active reservations for the user.
   * @throws LibraryWsException Throw this exception if there is a technical or functional problem.
   */
  @WebMethod
  public List<ReservationDetailsDto> userReservations(final Integer userId)
      throws LibraryWsException {

    if (userId == null) {
      LOG.error("userId = " + userId);
      throw new LibraryWsException(
          "Paramètre incorrect. L'identifiant de l'utilisateur ne peut être vide.",
          new LibraryWsFault(
              CLIENT, "Paramètre incorrect. L'identifiant de l'utilisateur ne peut être vide."));
    }

    try {
      return this.managerFactory.getBooksManagementManager().userReservationsList(userId);
    } catch (TechnicalException exception) {
      LOG.error(exception.getMessage());
      throw new LibraryWsException(
          TECH_ERROR, exception, new LibraryWsFault(SERVER, exception.getMessage()));
    } catch (FunctionalException exception) {
      LOG.error(exception.getMessage());
      throw new LibraryWsException(
          FUNC_ERROR, exception, new LibraryWsFault(CLIENT, exception.getMessage()));
    }
  }

  /**
   * Return the list of active reservations for the book.
   *
   * @param bookId id of the book.
   * @return the list of active reservations for the book.
   * @throws LibraryWsException Throw this exception if there is a technical or functional problem.
   */
  @WebMethod
  public List<BookReservation> bookReservations(final Integer bookId) throws LibraryWsException {

    if (bookId == null) {
      LOG.error("bookId = " + bookId);
      throw new LibraryWsException(
          "Paramètre incorrect. L'identifiant du livre ne peut être vide.",
          new LibraryWsFault(
              CLIENT, "Paramètre incorrect. L'identifiant du livre ne peut être vide."));
    }

    try {
      return this.managerFactory.getBooksManagementManager().activeReservationsListForBook(bookId);
    } catch (TechnicalException exception) {
      LOG.error(exception.getMessage());
      throw new LibraryWsException(
          TECH_ERROR, exception, new LibraryWsFault(SERVER, exception.getMessage()));
    } catch (FunctionalException exception) {
      LOG.error(exception.getMessage());
      throw new LibraryWsException(
          FUNC_ERROR, exception, new LibraryWsFault(CLIENT, exception.getMessage()));
    }
  }
}
