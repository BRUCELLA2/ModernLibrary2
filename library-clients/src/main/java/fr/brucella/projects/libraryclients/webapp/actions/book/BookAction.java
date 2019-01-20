package fr.brucella.projects.libraryclients.webapp.actions.book;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import generated.bookserviceclient.BookDetailsDto;
import generated.bookserviceclient.BookService;
import generated.bookserviceclient.BookService_Service;
import generated.bookserviceclient.LibraryWsException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BookAction extends ActionSupport {

  // ----- Logger
  /**
   * Book Listing Action logger.
   */
  private static final Log LOG = LogFactory.getLog(BookAction.class);

  // ----- Input
  /**
   * id of the bookBorrowed.
   */
  private Integer bookBorrowedId;

  /**
   * id of the book.
   */
  private Integer bookId;

  // ----- Output
  /**
   * Book Details Dto.
   */
  private BookDetailsDto bookDetailsDto;

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
   * @param bookBorrowedId
   *     the id of the bookBorrowed.
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
   * @param bookId
   *     the id of the book.
   */
  public void setBookId(final Integer bookId) {
    this.bookId = bookId;
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
   * @param bookDetailsDto
   *     the Book Details Dto.
   */
  public void setBookDetailsDto(BookDetailsDto bookDetailsDto) {
    this.bookDetailsDto = bookDetailsDto;
  }

  // ===== Methods =====

  public String borrowExtend() {

    if (this.bookBorrowedId == null) {
      LOG.error("bookBorrowedId NULL - BorrowExtend failure");
      this.addActionError("L'identifiant de l'emprunt est incorrect (Identifiant vide) - Echec de la prolongation");
      return Action.ERROR;
    }

    BookService_Service bookService = new BookService_Service();
    BookService bookServicePort = bookService.getBookServicePort();

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

  public String bookDetails() {

    if (this.bookId == null) {
      LOG.error("bookId NULL - Book Details failure");
      this.addActionError(
          "L'identifiant du livre est incorrect (Identifiant vide) - Echec de l'affichage du détail du livre.");
      return Action.ERROR;
    }

    BookService_Service bookservice = new BookService_Service();
    BookService bookServicePort = bookservice.getBookServicePort();

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
}
