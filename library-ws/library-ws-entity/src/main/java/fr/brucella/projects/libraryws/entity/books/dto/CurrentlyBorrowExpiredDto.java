package fr.brucella.projects.libraryws.entity.books.dto;

import fr.brucella.projects.libraryws.entity.LocalDateAdapter;
import java.time.LocalDate;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Represents a Currently Borrow Expired Data Transfert Object. This object contain the data about a
 * borrow expired and not returned. Includes some informations on the borrowing, the book and the
 * user who borrow the book.
 */
public class CurrentlyBorrowExpiredDto {

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

  /** Date of the last reminder. Can't be null. */
  @NotNull(message = "{bookBorrowed.lastReminder.null}")
  private LocalDate lastReminder;

  /** Nb of reminder send to user for a book not returned at time. Can't be null */
  @NotNull(message = "{bookBorrowed.nbReminder.null}")
  private Integer nbReminder;

  // ===== Book data =====
  /** Title of the book. Can't be empty. */
  @NotEmpty(message = "{book.title.empty}")
  @Size(min = 1, max = 150, message = "{book.title.size}")
  private String title;

  // ===== User data =====
  /** login of the user. Can't be empty. Max size is 30 characters. */
  @NotEmpty(message = "{user.login.empty}")
  @Size(min = 1, max = 30, message = "{user.login.size}")
  private String login;

  /** Email of the user. Can't be empty. Max size is 100 characters. */
  @NotEmpty(message = "{user.email.empty}")
  @Size(max = 100, message = "{user.email.size}")
  @Email(message = "{user.email.format}")
  private String email;

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
   * Give the email of the user.
   *
   * @return the email of the user.
   */
  public String getEmail() {
    return email;
  }

  /**
   * Set the email of the user.
   *
   * @param email the email of the user.
   */
  public void setEmail(final String email) {
    this.email = email;
  }

  /**
   * Give the login of the user.
   *
   * @return the login of the user.
   */
  public String getLogin() {
    return login;
  }

  /**
   * Set the login of the user.
   *
   * @param login the login of the user.
   */
  public void setLogin(final String login) {
    this.login = login;
  }

  // ===== Constructor =====

  /** Default Constructor */
  public CurrentlyBorrowExpiredDto() {}

  // ===== Methods =====

  /**
   * a string representation of the CurrentlyBorrowExpiredDto object.
   *
   * @return a string representation of the CurrentlyBorrowExpiredDto object.
   */
  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("userId", userId)
        .append("bookId", bookId)
        .append("endDate", endDate)
        .append("borrowDate", borrowDate)
        .append("lastReminder", lastReminder)
        .append("nbReminder", nbReminder)
        .append("title", title)
        .append("login", login)
        .append("email", email)
        .toString();
  }

}
