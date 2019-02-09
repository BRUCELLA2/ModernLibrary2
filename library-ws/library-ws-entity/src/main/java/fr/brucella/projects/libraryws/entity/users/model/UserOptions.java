package fr.brucella.projects.libraryws.entity.users.model;

import javax.validation.constraints.NotNull;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Represents user's options.
 *
 * @author BRUCELLA2
 */
public class UserOptions {

  /** Id of the UserOptions. */
  private Integer userOptionsId;

  /** The value of the beforeReminder option. */
  @NotNull(message = "{UserOptions.beforeReminder.null")
  private Boolean beforeReminder;

  // ===== Getters and Setters =====

  /**
   * Give the id of the userOptions.
   *
   * @return the id of the userOptions.
   */
  public Integer getUserOptionsId() {
    return userOptionsId;
  }

  /**
   * Set the id of the userOptions.
   *
   * @param userOptionsId the id of the userOptions.
   */
  public void setUserOptionsId(final Integer userOptionsId) {
    this.userOptionsId = userOptionsId;
  }

  /**
   * Give the value of the beforeReminder option.
   *
   * @return the value of the beforeReminder option.
   */
  public Boolean getBeforeReminder() {
    return beforeReminder;
  }

  /**
   * Set the value of the beforeReminder option.
   *
   * @param beforeReminder the value of the beforeReminder option.
   */
  public void setBeforeReminder(final Boolean beforeReminder) {
    this.beforeReminder = beforeReminder;
  }

  // ===== Methods =====

  /**
   * A string representation of the UserOptions.
   *
   * @return A string representation of the UserOptions.
   */
  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("userOptionsId", userOptionsId)
        .append("beforeReminder", beforeReminder)
        .toString();
  }
}
