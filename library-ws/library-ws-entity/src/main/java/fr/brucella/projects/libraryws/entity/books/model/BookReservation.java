package fr.brucella.projects.libraryws.entity.books.model;

import fr.brucella.projects.libraryws.entity.LocalDateWithTimeAdapter;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Represents the information related to a book reservation.
 *
 * @author BRUCELLA2
 */
public class BookReservation {

  /** id of the book reservation. */
  private Integer bookReservationId;

  /** id of the book. Can't be null. */
  @NotNull(message = "{bookReservation.bookId.null}")
  private Integer bookId;

  /** id of the user. Can't be null. */
  @NotNull(message = "{bookReservation.userId.null}")
  private Integer userId;

  /** Date of the reservation. Can't be null. */
  @NotNull(message = "{bookReservation.dateReservation.null}")
  private LocalDateTime dateReservation;

  /** Date of the email send to the user. */
  private LocalDateTime dateReservationEmailSend;

  /** Indicate if the reservation is active or not. */
  @NotNull(message = "{bookReservation.activeReservation.null}")
  private Boolean activeReservation;

  // ===== Getters and Setters =====

  /**
   * Give the id of the book reservation.
   *
   * @return the id of the book reservation.
   */
  public Integer getBookReservationId() {
    return bookReservationId;
  }

  /**
   * Set the id of the book reservation.
   *
   * @param bookReservationId the id of the book reservation.
   */
  public void setBookReservationId(final Integer bookReservationId) {
    this.bookReservationId = bookReservationId;
  }

  /**
   * Give the id of the id of the book.
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
   * Give the date of the reservation
   *
   * @return the date of the reservation.
   */
  @XmlJavaTypeAdapter(value = LocalDateWithTimeAdapter.class)
  public LocalDateTime getDateReservation() {
    return dateReservation;
  }

  /**
   * Set the date of the reservation.
   *
   * @param dateReservation the date of the reservation.
   */
  public void setDateReservation(final LocalDateTime dateReservation) {
    this.dateReservation = dateReservation;
  }

  /**
   * Give the date of the email send.
   *
   * @return the date of the email send.
   */
  @XmlJavaTypeAdapter(value = LocalDateWithTimeAdapter.class)
  public LocalDateTime getDateReservationEmailSend() {
    return dateReservationEmailSend;
  }

  /**
   * Set the date of the email send.
   *
   * @param dateReservationEmailSend the date of the email send.
   */
  public void setDateReservationEmailSend(final LocalDateTime dateReservationEmailSend) {
    this.dateReservationEmailSend = dateReservationEmailSend;
  }

  /**
   * Indicate if the reservation is active.
   *
   * @return the reservation is active.
   */
  public Boolean getActiveReservation() {
    return activeReservation;
  }

  /**
   * Set the reservation statut.
   *
   * @param activeReservation true if the reservation is active, false otherwise.
   */
  public void setActiveReservation(final Boolean activeReservation) {
    this.activeReservation = activeReservation;
  }

  // ===== Constructor =====

  /** Default Constructor. */
  public BookReservation() {
    // This constructor is intentionally empty. Nothing special is needed here.
  }

  // ===== Methods =====

  /** {@inheritDoc} */
  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("bookReservationId", bookReservationId)
        .append("bookId", bookId)
        .append("userId", userId)
        .append("dateReservation", dateReservation)
        .append("dateReservationEmailSend", dateReservationEmailSend)
        .append("activeReservation", activeReservation)
        .toString();
  }
}
