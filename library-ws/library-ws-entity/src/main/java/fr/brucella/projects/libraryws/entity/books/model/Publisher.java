package fr.brucella.projects.libraryws.entity.books.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Represents a publisher.
 *
 * @author BRUCELLA2
 */
public class Publisher {

  /** id of the publisher. */
  private Integer publisherId;

  /** Name of the publisher. Can't be empty. */
  @NotEmpty(message = "{publisher.name.empty}")
  @Size(min = 1, max = 100, message = "{publisher.name.size}")
  private String name;

  // ===== Constructor =====

  /** Default Constructor */
  public Publisher() {
    // This constructor is intentionally empty. Nothing special is needed here.
  }

  // ===== Getters and Setters =====

  /**
   * Give the publisher id.
   *
   * @return the publisher id.
   */
  public Integer getPublisherId() {
    return publisherId;
  }

  /**
   * Set the publisher id.
   *
   * @param publisherId the publisher id.
   */
  public void setPublisherId(final Integer publisherId) {
    this.publisherId = publisherId;
  }

  /**
   * Give the name of the publisher.
   *
   * @return the name of the publisher.
   */
  public String getName() {
    return name;
  }

  /**
   * Set the name of the publisher.
   *
   * @param name the name of the publisher.
   */
  public void setName(final String name) {
    this.name = name;
  }

  // ===== Methods =====

  /**
   * a string representation of the Publisher object.
   *
   * @return a string representation of the Publisher object.
   */
  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("publisherId", publisherId)
        .append("name", name)
        .toString();
  }
}
