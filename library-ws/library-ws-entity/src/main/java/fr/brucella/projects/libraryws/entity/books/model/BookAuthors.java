package fr.brucella.projects.libraryws.entity.books.model;

import javax.validation.constraints.NotNull;
import org.apache.commons.lang3.builder.ToStringBuilder;

/** @author BRUCELLA2 */
public class BookAuthors {

  /** id of the book. Can't be null. */
  @NotNull(message = "{bookAuthors.bookId.null}")
  private Integer bookId;

  /** id of the author. Can't be null. */
  @NotNull(message = "{bookAuthors.authorId.null}")
  private Integer authorId;

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
   * Give the id of the author.
   *
   * @return the id of the author.
   */
  public Integer getAuthorId() {
    return authorId;
  }

  /**
   * Set the id of the author.
   *
   * @param authorId the id of the author.
   */
  public void setAuthorId(final Integer authorId) {
    this.authorId = authorId;
  }

  // ===== Constructor =====

  /** Default Constructor */
  public BookAuthors() {}

  // ===== Methods =====

  /**
   * a string representation of the BookAuthors object.
   *
   * @return a string representation of the BookAuthors object.
   */
  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("bookId", bookId)
        .append("authorId", authorId)
        .toString();
  }
}
