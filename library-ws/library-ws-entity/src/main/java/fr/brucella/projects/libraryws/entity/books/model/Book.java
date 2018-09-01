package fr.brucella.projects.libraryws.entity.books.model;

import fr.brucella.projects.libraryws.entity.LocalDateAdapter;
import java.time.LocalDate;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Represents a Book.
 *
 * @author BRUCELLA2
 */
public class Book {

  /** id of the book. */
  private Integer bookId;

  /** Title of the book. Can't be empty. */
  @NotEmpty(message = "{book.title.empty}")
  @Size(min = 1, max = 150, message = "{book.title.size}")
  private String title;

  /** isbn13 of the book. Can't be empty. */
  @NotEmpty(message = "{book.isbn13.empty}")
  @Size(min = 17, max = 17, message = "{book.isbn13.size}")
  private String isbn13;

  /** ean13 of the book. Can't be empty. */
  @NotEmpty(message = "{book.ean13.empty}")
  @Size(min = 13, max = 13, message = "{book.ean13.size}")
  private String ean13;

  /** Publishing date of the book. Can't be null. */
  @NotNull(message = "{book.publishingDate.null}")
  private LocalDate publishingDate;

  /** Resume of the book. Can't be empty. */
  @NotEmpty(message = "{book.resume.empty}")
  @Size(min = 1, max = 5000, message = "{book.resume.size}")
  private String resume;

  /** Genre id of the book. Can't be null. */
  @NotNull(message = "{book.genreId.null}")
  private Integer genreId;

  /** Id of the publisher who publish the book. */
  @NotNull(message = "{book.publisherId.null}")
  private Integer publisherId;

  // ===== Getters and Setters =====

  /**
   * Give the book id.
   *
   * @return the book id.
   */
  public Integer getBookId() {
    return bookId;
  }

  /**
   * Set the book id.
   *
   * @param bookId the book id.
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
   * Give the ISBN13 of the book.
   *
   * @return the ISBN13 of the book.
   */
  public String getIsbn13() {
    return isbn13;
  }

  /**
   * Set the ISBN13 of the book.
   *
   * @param isbn13 the ISBN13 of the book.
   */
  public void setIsbn13(final String isbn13) {
    this.isbn13 = isbn13;
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
   * Give the publishing date of the book.
   *
   * @return the publishing date of the book.
   */
  @XmlJavaTypeAdapter(value = LocalDateAdapter.class)
  public LocalDate getPublishingDate() {
    return publishingDate;
  }

  /**
   * Set the publishing date of the book.
   *
   * @param publishingDate the publishing date of the book.
   */
  public void setPublishingDate(final LocalDate publishingDate) {
    this.publishingDate = publishingDate;
  }

  /**
   * Give the resume of the book.
   *
   * @return the resume of the book.
   */
  public String getResume() {
    return resume;
  }

  /**
   * Set the resume of the book.
   *
   * @param resume the resume of the book.
   */
  public void setResume(final String resume) {
    this.resume = resume;
  }

  /**
   * Give the genre id of the book.
   *
   * @return the genre id of the book.
   */
  public Integer getGenreId() {
    return genreId;
  }

  /**
   * Set the genre id of the book.
   *
   * @param genreId the genre id of the book.
   */
  public void setGenreId(final Integer genreId) {
    this.genreId = genreId;
  }

  /**
   * Give the publisher id of the book.
   *
   * @return the publisher id of the book.
   */
  public Integer getPublisherId() {
    return publisherId;
  }

  /**
   * Set the publisher id of the book.
   *
   * @param publisherId the publisher id of the book.
   */
  public void setPublisherId(final Integer publisherId) {
    this.publisherId = publisherId;
  }

  // ===== Constructor =====

  /** Default Constructor */
  public Book() {}

  // ===== Methods =====

  /**
   * a string representation of the Book object.
   *
   * @return a string representation of the Book object.
   */
  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("bookId", bookId)
        .append("title", title)
        .append("isbn13", isbn13)
        .append("ean13", ean13)
        .append("publishingDate", publishingDate)
        .append("resume", resume)
        .append("genreId", genreId)
        .append("publisherId", publisherId)
        .toString();
  }
}
