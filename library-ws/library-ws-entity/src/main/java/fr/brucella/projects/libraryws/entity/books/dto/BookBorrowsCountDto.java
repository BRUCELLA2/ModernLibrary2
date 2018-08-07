package fr.brucella.projects.libraryws.entity.books.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Represents the number of borrows for a book. Includes some informations about the book (title,
 * id).
 *
 * @author BRUCELLA2
 */
public class BookBorrowsCountDto {

  /** id of the book. Can't be null. */
  @NotNull(message = "{bookBorrowed.bookId.null}")
  private Integer bookId;

  /** Title of the book. Can't be empty. */
  @NotEmpty(message = "{book.title.empty}")
  @Size(min = 1, max = 150, message = "{book.title.size}")
  private String title;

  /** Nb of borrows for the book. Can't be null */
  @NotNull(message = "{bookBorrowsCountDto.nbBorrow.null}")
  private Integer nbBorrows;

  // ===== Constructor =====

  /** Defaut Constructor */
  public BookBorrowsCountDto() {}

  // ===== Getters and Setters =====

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
   * Give the title of the book.
   *
   * @return the title of the book.
   */
  public String getTitle() {
    return title;
  }

  /**
   * Set the title of the book.
   *
   * @param title the title of the book.
   */
  public void setTitle(final String title) {
    this.title = title;
  }

  /**
   * Give the number of borrows for the book.
   *
   * @return the number of borrows for the book.
   */
  public Integer getNbBorrows() {
    return nbBorrows;
  }

  /**
   * Set the number of borrows for the book.
   *
   * @param nbBorrows the number of borrows for the book.
   */
  public void setNbBorrows(final Integer nbBorrows) {
    this.nbBorrows = nbBorrows;
  }
}
