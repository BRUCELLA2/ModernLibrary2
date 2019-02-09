package fr.brucella.projects.libraryclients.webapp.actions.book;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import generated.bookserviceclient.BookDetailsDto;
import generated.bookserviceclient.BookService;
import generated.bookserviceclient.BookService_Service;
import generated.bookserviceclient.LibraryWsException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Book actions
 *
 * @author BRUCELLA2
 */
public class BookAction extends ActionSupport {

  // ----- Logger
  /** Book Listing Action logger. */
  private static final Log LOG = LogFactory.getLog(BookAction.class);

  // ----- Input
  /** id of the bookBorrowed. */
  private Integer bookBorrowedId;

  /** id of the book. */
  private Integer bookId;

  /** id of the reservation */
  private Integer bookReservationId;

  // ----- Output
  /** Book Details Dto. */
  private BookDetailsDto bookDetailsDto;

  // ----- Constructors

  /** Default constructor. */
  public BookAction() {
    // This constructor is intentionally empty. Nothing special is needed here.
  }

  // ----- Getters and Setters

  /**
   * Give the id of the bookBorrowed.
   *
   * @return the id of the bookBorrowed.
   */
  public Integer getBookBorrowedId() {
    return bookBorrowedId;
  }

  /**
   * Set the the id of the bookBorrowed.
   *
   * @param bookBorrowedId the id of the bookBorrowed.
   */
  public void setBookBorrowedId(final Integer bookBorrowedId) {
    this.bookBorrowedId = bookBorrowedId;
  }

  /**
   * Give the id of the book.
   *
   * @return the id of the book.
   */
  public Integer getBookId() {
    return bookId;
  }

  /**
   * Set the id of the book.
   *
   * @param bookId the id of the book.
   */
  public void setBookId(final Integer bookId) {
    this.bookId = bookId;
  }

  /**
   * Give the id of the reservation.
   *
   * @return the id of the reservation.
   */
  public Integer getBookReservationId() {
    return bookReservationId;
  }

  /**
   * Set the id of the reservation.
   *
   * @param bookReservationId the id of the reservation.
   */
  public void setBookReservationId(final Integer bookReservationId) {
    this.bookReservationId = bookReservationId;
  }

  /**
   * Give the Book Details Dto.
   *
   * @return the Book Details Dto.
   */
  public BookDetailsDto getBookDetailsDto() {
    return bookDetailsDto;
  }

  /**
   * Set the Book Details Dto.
   *
   * @param bookDetailsDto the Book Details Dto.
   */
  public void setBookDetailsDto(final BookDetailsDto bookDetailsDto) {
    this.bookDetailsDto = bookDetailsDto;
  }

  // ===== Methods =====

  /**
   * Extend a borrow for the user.
   *
   * @return Action.SUCCESS or Action.ERROR if errors occurred.
   */
  public String borrowExtend() {

    if (this.bookBorrowedId == null) {
      LOG.error("bookBorrowedId NULL - BorrowExtend failure");
      this.addActionError(
          "L'identifiant de l'emprunt est incorrect (Identifiant vide) - Echec de la prolongation");
      return Action.ERROR;
    }

    final BookService_Service bookService = new BookService_Service();
    final BookService bookServicePort = bookService.getBookServicePort();

    try {
      bookServicePort.extendBorrowing(this.bookBorrowedId);
    } catch (LibraryWsException exception) {
      LOG.error(exception.getMessage());
      LOG.error(exception.getFaultInfo().getFaultString());
      this.addActionError(exception.getFaultInfo().getFaultString());
      return Action.ERROR;
    }

    return Action.SUCCESS;
  }

  /**
   * Action that provides book details.
   *
   * @return Action.SUCCESS or Action.ERROR if errors occurred.
   */
  public String bookDetails() {

    if (this.bookId == null) {
      LOG.error("bookId NULL - Book Details failure");
      this.addActionError(
          "L'identifiant du livre est incorrect (Identifiant vide) - Echec de l'affichage du détail du livre.");
      return Action.ERROR;
    }

    final BookService_Service bookservice = new BookService_Service();
    final BookService bookServicePort = bookservice.getBookServicePort();

    try {
      this.setBookDetailsDto(bookServicePort.bookDetails(bookId));
    } catch (LibraryWsException exception) {
      LOG.error(exception.getMessage());
      LOG.error(exception.getFaultInfo().getFaultString());
      this.addActionError(exception.getFaultInfo().getFaultString());
      return Action.ERROR;
    }

    return Action.SUCCESS;
  }

  /**
   * Cancel a reservation for the user.
   *
   * @return Action.SUCCESS or Action.ERROR if errors occurred.
   */
  public String cancelReservations() {

    if (this.bookReservationId == null) {
      LOG.error("bookReservationId NULL - cancel reservation failure");
      this.addActionError(
          "L'identifiant de la réservation est incorrect (Identifiant vide) - Echec de l'annulation de la réservation.");
      return Action.ERROR;
    }

    final BookService_Service bookService = new BookService_Service();
    final BookService bookServicePort = bookService.getBookServicePort();

    try {
      bookServicePort.cancelAreservation(bookReservationId);
    } catch (LibraryWsException exception) {
      LOG.error(exception.getMessage());
      LOG.error(exception.getFaultInfo().getFaultString());
      this.addActionError(exception.getFaultInfo().getFaultString());
      return Action.ERROR;
    }

    return Action.SUCCESS;
  }
}
