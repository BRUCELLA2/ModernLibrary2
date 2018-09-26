package fr.brucella.projects.libraryws.entity.users.model;

import javax.validation.constraints.NotNull;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 *
 * @author BRUCELLA2
 */
public class UserRoles {

  /** Id of the user. Can't be null. */
  @NotNull(message = "{userRoles.userId.null}")
  private Integer userId;

  /** id of the role. Can't be null. */
  @NotNull(message = "{userRoles.roleId.null}")
  private Integer roleId;

  // ===== Getters and Setters =====

  /**
   * Give the user id.
   *
   * @return the user id.
   */
  public Integer getUserId() {
    return userId;
  }

  /**
   * Set the user id.
   *
   * @param userId the user id.
   */
  public void setUserId(final Integer userId) {
    this.userId = userId;
  }

  /**
   * Give the role id.
   *
   * @return the role id.
   */
  public Integer getRoleId() {
    return roleId;
  }

  /**
   * Set the role id.
   *
   * @param roleId the role id.
   */
  public void setRoleId(final Integer roleId) {
    this.roleId = roleId;
  }

  // ===== Constructor =====

  /** Default Constructor */
  public UserRoles() {}

  // ===== Methods =====

  /**
   * a string representation of the UserRoles object.
   *
   * @return a string representation of the UserRoles object.
   */
  @Override
  public String toString() {
    return new ToStringBuilder(this).append("userId", userId).append("roleId", roleId).toString();
  }
}
