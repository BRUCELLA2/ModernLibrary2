package fr.brucella.projects.libraryws.entity.books.model;

import fr.brucella.projects.libraryws.entity.LocalDateAdapter;
import java.time.LocalDate;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Represents the information related to a book borrowing.
 *
 * @author BRUCELLA2
 */
public class BookBorrowed {

  /** id of the book borrowed. */
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

  /** Nb of reminder send to user for a book not returned at time. Can't be null */
  @NotNull(message = "{bookBorrowed.nbReminder.null}")
  private Integer nbReminder;

  /** Indicate if the book has been returned. Can't be null. */
  @NotNull(message = "{bookBorrowed.returned.null}")
  private Boolean returned;

  /** Date of the last reminder. Can be null. */
  private LocalDate lastReminder;

  // ===== Constructor =====

  /** Default Constructor */
  public BookBorrowed() {
    // This constructor is intentionally empty. Nothing special is needed here.
  }

  // ===== Getters and Setters =====

  /**
   * Give the id of the book borrowed
   *
   * @return the id of the book borrowed.
   */
  public Integer getBookBorrowedId() {
    return bookBorrowedId;
  }

  /**
   * Set the id of the book borrowed
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
   * Set the id of the user.
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
   * Give the number of reminder send to the user for this book.
   *
   * @return the number of reminded send to the user.
   */
  public Integer getNbReminder() {
    return nbReminder;
  }

  /**
   * Set the number of reminder send to the user for this book.
   *
   * @param nbReminder the number of reminded send to the user.
   */
  public void setNbReminder(final Integer nbReminder) {
    this.nbReminder = nbReminder;
  }

  /**
   * Indicate if the book has been returned.
   *
   * @return true if the book has been returned, false otherwise.
   */
  public Boolean getReturned() {
    return returned;
  }

  /**
   * Set the returned status of the book borrowed.
   *
   * @param returned true if the book has been returned and false otherwise.
   */
  public void setReturned(final Boolean returned) {
    this.returned = returned;
  }

  /**
   * Give the date of the last reminded send to the user for this borrowing.
   *
   * @return the date of the last reminded send to the user for this borrowing.
   */
  @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
  public LocalDate getLastReminder() {
    return lastReminder;
  }

  /**
   * Set the date of the last reminded send to the user for this borrowing.
   *
   * @param lastReminder the date of the last reminder send to the user for this borrowing.
   */
  public void setLastReminder(final LocalDate lastReminder) {
    this.lastReminder = lastReminder;
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
        .append("userId", userId)
        .append("bookId", bookId)
        .append("endDate", endDate)
        .append("borrowDate", borrowDate)
        .append("extension", extension)
        .append("nbReminder", nbReminder)
        .append("returned", returned)
        .append("lastReminder", lastReminder)
        .toString();
  }
}
