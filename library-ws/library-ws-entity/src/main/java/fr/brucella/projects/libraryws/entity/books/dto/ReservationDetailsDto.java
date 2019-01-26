package fr.brucella.projects.libraryws.entity.books.dto;

import fr.brucella.projects.libraryws.entity.LocalDateAdapter;
import fr.brucella.projects.libraryws.entity.books.model.BookReservation;
import java.time.LocalDate;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Represents a ReservationDetails Data Transfert Object. Includes all the informations about the book.
 * Includes some information about the book (title and first end date of borrow return.)
 *
 * @author BRUCELLA2
 */
public class ReservationDetailsDto extends BookReservation {

  /** Title of the book. Can't be empty. */
  @NotEmpty(message = "{book.title.empty}")
  @Size(min = 1, max = 150, message = "{book.title.size}")
  private String title;

  /** First end date of borrowing. Can be null. */
  private LocalDate firstEndBorrowDate;

  // ===== Constructor =====

  public ReservationDetailsDto() {
    super();
  }

  // ===== Getters and Setters =====

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
   * Get the first end date of borrow.
   *
   * @return the end date of borrow.
   */
  @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
  public LocalDate getFirstEndBorrowDate() {
    return firstEndBorrowDate;
  }

  /**
   * Set the first end date of borrow.
   *
   * @param firstEndBorrowDate the end date of borrow.
   */
  public void setFirstEndBorrowDate(LocalDate firstEndBorrowDate) {
    this.firstEndBorrowDate = firstEndBorrowDate;
  }


  // ===== Methods =====


  @Override
  public String toString() {
    return new ToStringBuilder(this).append("title", title).append("firstEndBorrowDate", firstEndBorrowDate).toString();
  }
}
