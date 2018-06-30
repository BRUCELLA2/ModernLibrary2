package fr.brucella.projects.libraryws.entity.users.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Represents the role which can be give to a user.
 *
 * @author BRUCELLA2
 */
public class Role {

  /** Id of the role. */
  private Integer roleId;

  /** Name of the role. Can't be empty. */
  @NotEmpty(message = "{role.roleName.empty}")
  @Size(min = 1, max = 25, message = "{role.roleName.size}")
  private String roleName;

  // ===== Getters and Setters =====

  /**
   * Get the role id of the role.
   *
   * @return the role id of the role.
   */
  public Integer getRoleId() {
    return roleId;
  }

  /**
   * Set the role id of the role.
   *
   * @param roleId role id of the role.
   */
  public void setRoleId(Integer roleId) {
    this.roleId = roleId;
  }

  /**
   * Get the name of the role.
   *
   * @return the name of the role.
   */
  public String getRoleName() {
    return roleName;
  }

  /**
   * Set the name of the role.
   *
   * @param roleName the name of the role.
   */
  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }

  // ===== Methods =====

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("roleId", roleId)
        .append("roleName", roleName)
        .toString();
  }
}
