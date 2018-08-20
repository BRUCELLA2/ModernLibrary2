package fr.brucella.projects.libraryws.entity.books.dto;

import fr.brucella.projects.libraryws.entity.books.model.Author;
import fr.brucella.projects.libraryws.entity.books.model.Book;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
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
  @NotEmpty(message = "{bookDetailsDto.authors.empty")
  private List<Author> authors;

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

  // ===== Methods =====

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("publisherName", publisherName)
        .append("genreName", genreName)
        .append("authors", authors)
        .toString();
  }
}
