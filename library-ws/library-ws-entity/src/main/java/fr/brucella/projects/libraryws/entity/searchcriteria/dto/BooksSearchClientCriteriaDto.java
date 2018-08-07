package fr.brucella.projects.libraryws.entity.searchcriteria.dto;

import javax.validation.constraints.Size;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Represents the book searching criteria used by client users.
 *
 * @author BRUCELLA2
 */
public class BooksSearchClientCriteriaDto {

  /** Title of the book. Can be empty. */
  @Size(min = 0, max = 150, message = "{book.title.size}")
  private String title;

  /** Name of the genre. Can be empty. */
  @Size(min = 0, max = 50, message = "{genre.name.size}")
  private String genreName;

  /** Name of the publisher. Can be empty. */
  @Size(min = 0, max = 100, message = "{publisher.name.size}")
  private String publisherName;

  /** ean13 of the book. Can be empty. */
  @Size(min = 0, max = 13, message = "{book.ean13.size}")
  private String ean13;

  /** Last name of the author. Can be empty. */
  @Size(min = 0, max = 50, message = "{author.lastName.size}")
  private String authorLastName;

  /** Indicate if the book need to be available for a borrow. */
  private Boolean bookAvailable;

  // ===== Constructor =====

  /** Defaut Constructor */
  public BooksSearchClientCriteriaDto() {}

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
   * @param genreName the name of the genre.
   */
  public void setGenreName(final String genreName) {
    this.genreName = genreName;
  }

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
   * Give the EAN13 of the book.
   *
   * @return the EAN13 of the book.
   */
  public String getEan13() {
    return ean13;
  }

  /**
   * Set the EAN13 of the book.
   *
   * @param ean13 the EAN13 of the book.
   */
  public void setEan13(final String ean13) {
    this.ean13 = ean13;
  }

  /**
   * Give the last name of the author.
   *
   * @return the last name of the author.
   */
  public String getAuthorLastName() {
    return authorLastName;
  }

  /**
   * Set the last name of the author.
   *
   * @param authorLastName the last name of the author.
   */
  public void setAuthorLastName(final String authorLastName) {
    this.authorLastName = authorLastName;
  }

  /**
   * Indicate if the book need to be available for a borrow.
   *
   * @return true if the book need to be available, false otherwise.
   */
  public Boolean getBookAvailable() {
    return bookAvailable;
  }

  /**
   * Indicate if the book need to be available for a borrow.
   *
   * @param bookAvailable true if the book need to be available, false otherwise.
   */
  public void setBookAvailable(Boolean bookAvailable) {
    this.bookAvailable = bookAvailable;
  }

  // ===== Methods =====

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("title", title)
        .append("genreName", genreName)
        .append("publisherName", publisherName)
        .append("ean13", ean13)
        .append("authorLastName", authorLastName)
        .append("bookAvailable", bookAvailable)
        .toString();
  }
}
