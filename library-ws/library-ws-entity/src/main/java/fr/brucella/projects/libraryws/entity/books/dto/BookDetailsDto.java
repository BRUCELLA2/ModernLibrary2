package fr.brucella.projects.libraryws.entity.books.dto;

import fr.brucella.projects.libraryws.entity.LocalDateAdapter;
import fr.brucella.projects.libraryws.entity.books.model.Author;
import fr.brucella.projects.libraryws.entity.books.model.Book;
import java.time.LocalDate;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Represents a BookDetails Data Transfert Object. Includes all the informations about the book.
 * Includes author, genre and publisher informations.
 *
 * @author BRUCELLA2
 */
public class BookDetailsDto extends Book {

  /** Name of the publisher. Can't be empty. */
  @NotEmpty(message = "{publisher.name.empty}")
  @Size(min = 1, max = 100, message = "{publisher.name.size}")
  private String publisherName;

  /** Name of the genre. Can't be empty. */
  @NotEmpty(message = "{genre.name.empty}")
  @Size(min = 1, max = 50, message = "{genre.name.size}")
  private String genreName;

  /** List of authors who write the book */
  @NotEmpty(message = "{bookDetailsDto.authors.empty}")
  private List<Author> authors;

  /** Amount of copy of the book available for a borrowing. Can't be null. */
  @NotNull(message = "{stock.amountAvailable.null}")
  private Integer amountAvailable;

  /** End date of borrowing. Can be null. */
  private LocalDate endBorrowDate;

  /** Nb of active reservations for this book. Can be null. */
  private Integer nbActiveReservations;

  // ===== Constructor =====

  /** Defaut Constructor */
  public BookDetailsDto() {
    super();
  }

  // ===== Getters and Setters =====

  /**
   * Give the name of the publisher.
   *
   * @return the name of the publisher.
   */
  public String getPublisherName() {
    return publisherName;
  }

  /**
   * Set the name of the publisher.
   *
   * @param publisherName the name of the publisher.
   */
  public void setPublisherName(final String publisherName) {
    this.publisherName = publisherName;
  }

  /**
   * Give the name of the genre.
   *
   * @return name of the genre.
   */
  public String getGenreName() {
    return genreName;
  }

  /**
   * Set the name of the genre.
   *
   * @param genreName name of the genre.
   */
  public void setGenreName(final String genreName) {
    this.genreName = genreName;
  }

  /**
   * Give the list of authors.
   *
   * @return the list of authors.
   */
  public List<Author> getAuthors() {
    return authors;
  }

  /**
   * Set the list of authors.
   *
   * @param authors the list of authors.
   */
  public void setAuthors(final List<Author> authors) {
    this.authors = authors;
  }

  /**
   * Give the amount available.
   *
   * @return the amount available.
   */
  public Integer getAmountAvailable() {
    return amountAvailable;
  }

  /**
   * Set the amount available.
   *
   * @param amountAvailable the amount available.
   */
  public void setAmountAvailable(final Integer amountAvailable) {
    this.amountAvailable = amountAvailable;
  }

  /**
   * Get the end date of borrow.
   *
   * @return the end date of borrow.
   */
  @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
  public LocalDate getEndBorrowDate() {
    return endBorrowDate;
  }

  /**
   * Set the end date of borrow.
   *
   * @param endBorrowDate the end date of borrow.
   */
  public void setEndBorrowDate(final LocalDate endBorrowDate) {
    this.endBorrowDate = endBorrowDate;
  }

  /**
   * Get the number of active reservations.
   *
   * @return the number of active reservations.
   */
  public Integer getNbActiveReservations() {
    return nbActiveReservations;
  }

  /**
   * Set the number of active reservations.
   *
   * @param nbActiveReservations the number of active reservations.
   */
  public void setNbActiveReservations(final Integer nbActiveReservations) {
    this.nbActiveReservations = nbActiveReservations;
  }

  // ===== Methods =====

  /** {@inheritDoc} */
  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("publisherName", publisherName)
        .append("genreName", genreName)
        .append("authors", authors)
        .append("amountAvailable", amountAvailable)
        .append("endBorrowDate", endBorrowDate)
        .append("nbActiveReservations", nbActiveReservations)
        .toString();
  }
}
