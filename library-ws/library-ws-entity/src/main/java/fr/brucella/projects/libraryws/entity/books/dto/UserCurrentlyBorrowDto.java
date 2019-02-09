package fr.brucella.projects.libraryws.entity.books.dto;

import fr.brucella.projects.libraryws.entity.LocalDateAdapter;
import java.time.LocalDate;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Represents a User Currently Borrow Data Transfert Object. This object contain the data about a
 * borrow for a specific user. Includes some informations on the borrowing and on the book.
 *
 * @author BRUCELLA2
 */
public class UserCurrentlyBorrowDto {

  // ===== BookBorrowed data =====
  /** id of the book borrowed. Can't be null. */
  @NotNull(message = "{bookBorrowed.bookBorrowedId.null}")
  private Integer bookBorrowedId;

  /** id of the user. Can't be null. */
  @NotNull(message = "{bookBorrowed.userId.null}")
  private Integer userId;

  /** id of the book. Can't be null. */
  @NotNull(message = "{bookBorrowed.bookId.null}")
  private Integer bookId;

  /** End date of borrowing. Can't be null. */
  @NotNull(message = "{bookBorrowed.endDate.null}")
  private LocalDate endDate;

  /** Date of borrow. Can't be null. */
  @NotNull(message = "{bookBorrowed.borrowDate.null}")
  private LocalDate borrowDate;

  /** Indicate if the borrowing has been extended. Can't be null. */
  @NotNull(message = "{bookBorrowed.extension.null}")
  private Boolean extension;

  // ===== Book data =====

  /** Title of the book. Can't be empty. */
  @NotEmpty(message = "{book.title.empty}")
  @Size(min = 1, max = 150, message = "{book.title.size}")
  private String title;

  // ===== Constructor =====

  /** Default Constructor */
  public UserCurrentlyBorrowDto() {
    // This constructor is intentionally empty. Nothing special is needed here.
  }

  // ===== Getters and Setters =====

  /**
   * Give the id of the book borrowed.
   *
   * @return the id of the book borrowed.
   */
  public Integer getBookBorrowedId() {
    return bookBorrowedId;
  }

  /**
   * Set the id of the book borrowed.
   *
   * @param bookBorrowedId the id of the book borrowed.
   */
  public void setBookBorrowedId(final Integer bookBorrowedId) {
    this.bookBorrowedId = bookBorrowedId;
  }

  /**
   * Give the id of the user.
   *
   * @return the id of the user.
   */
  public Integer getUserId() {
    return userId;
  }

  /**
   * Return the id of the user.
   *
   * @param userId the id of the user.
   */
  public void setUserId(final Integer userId) {
    this.userId = userId;
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
   * Give the end date of the borrowing.
   *
   * @return the end date of the borrowing.
   */
  @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
  public LocalDate getEndDate() {
    return endDate;
  }

  /**
   * Set the end date of the borrowing.
   *
   * @param endDate the end date of the borrowing.
   */
  public void setEndDate(final LocalDate endDate) {
    this.endDate = endDate;
  }

  /**
   * Give the borrowing date.
   *
   * @return the borrowing date.
   */
  @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
  public LocalDate getBorrowDate() {
    return borrowDate;
  }

  /**
   * Set the borrowing date
   *
   * @param borrowDate the borrowing date.
   */
  public void setBorrowDate(final LocalDate borrowDate) {
    this.borrowDate = borrowDate;
  }

  /**
   * Indicate if the borrow has been extended.
   *
   * @return true if the borrow has been extended, false otherwise.
   */
  public Boolean getExtension() {
    return extension;
  }

  /**
   * Set extension of the borrowing statut.
   *
   * @param extension true if the borrowing has been extented, false otherwise.
   */
  public void setExtension(final Boolean extension) {
    this.extension = extension;
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

  // ===== Methods =====

  /**
   * a string representation of the BookBorrowed object.
   *
   * @return a string representation of the BookBorrowed object.
   */
  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("bookId", bookId)
        .append("endDate", endDate)
        .append("borrowDate", borrowDate)
        .append("extension", extension)
        .append("title", title)
        .toString();
  }
}
