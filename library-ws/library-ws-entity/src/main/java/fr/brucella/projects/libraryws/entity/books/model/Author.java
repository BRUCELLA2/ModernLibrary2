package fr.brucella.projects.libraryws.entity.books.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Represents an Author.
 *
 * @author BRUCELLA2
 */
public class Author {

  /** Id of the author. */
  private Integer authorId;

  /** First name of the author. Can't be empty. */
  @NotEmpty(message = "{author.firstName.empty}")
  @Size(min = 1, max = 50, message = "{author.firstName.size}")
  private String firstName;

  /** Last name of the author. Can't be empty. */
  @NotEmpty(message = "{author.lastName.empty}")
  @Size(min = 1, max = 50, message = "{author.lastName.size}")
  private String lastName;

  // ===== Constructor =====

  /** Default Constructor */
  public Author() {
    // This constructor is intentionally empty. Nothing special is needed here.
  }

  // ===== Getters and Setters =====

  /**
   * Give the id of the author.
   *
   * @return the id of the author.
   */
  public Integer getAuthorId() {
    return authorId;
  }

  /**
   * Set the id of the author.
   *
   * @param authorId the id of the author.
   */
  public void setAuthorId(final Integer authorId) {
    this.authorId = authorId;
  }

  /**
   * Give the first name of the author.
   *
   * @return the first name of the author.
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Set the first name of the author.
   *
   * @param firstName the first name of the author.
   */
  public void setFirstName(final String firstName) {
    this.firstName = firstName;
  }

  /**
   * Give the last name of the author.
   *
   * @return the last name of the author.
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Set the last name of the author.
   *
   * @param lastName the last name of the author.
   */
  public void setLastName(final String lastName) {
    this.lastName = lastName;
  }

  // ===== Methods =====

  /**
   * a string representation of the Author object.
   *
   * @return a string representation of the Author object.
   */
  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("authorId", authorId)
        .append("firstName", firstName)
        .append("lastName", lastName)
        .toString();
  }
}
