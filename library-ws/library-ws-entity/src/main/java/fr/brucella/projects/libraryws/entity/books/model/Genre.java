package fr.brucella.projects.libraryws.entity.books.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Represents the genre of a book.
 *
 * @author BRUCELLA2
 */
public class Genre {

  /** Id of the genre. */
  private Integer genreId;

  /** Name of the genre. Can't be empty. */
  @NotEmpty(message = "{genre.name.empty}")
  @Size(min = 1, max = 50, message = "{genre.name.size}")
  private String name;

  // ===== Constructor =====

  /** Default Constructor */
  public Genre() {
    // This constructor is intentionally empty. Nothing special is needed here.
  }

  // ===== Getters and Setters =====

  /**
   * Give the id of the genre.
   *
   * @return id of the genre.
   */
  public Integer getGenreId() {
    return genreId;
  }

  /**
   * Set the id of the genre.
   *
   * @param genreId
   */
  public void setGenreId(final Integer genreId) {
    this.genreId = genreId;
  }

  /**
   * Give the name of the genre.
   *
   * @return name of the genre.
   */
  public String getName() {
    return name;
  }

  /**
   * Set the name of the genre.
   *
   * @param name the name of the genre.
   */
  public void setName(final String name) {
    this.name = name;
  }

  // ===== Methods =====

  /**
   * a string representation of the Genre object.
   *
   * @return a string representation of the Genre object.
   */
  @Override
  public String toString() {
    return new ToStringBuilder(this).append("genreId", genreId).append("name", name).toString();
  }
}
