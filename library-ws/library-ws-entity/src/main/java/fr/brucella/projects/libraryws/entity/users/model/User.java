package fr.brucella.projects.libraryws.entity.users.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Represents a User.
 *
 * @author BRUCELLA2
 */
public class User {

  /** id of the user. */
  private Integer userId;

  /** login of the user. Can't be empty. Max size is 30 characters. */
  @NotEmpty(message = "{user.login.empty}")
  @Size(min = 1, max = 30, message = "{user.login.size}")
  private String login;

  /** password of the user. Can't be empty. Max size is 60 characters. */
  @NotEmpty(message = "{user.password.empty}")
  @Size(max = 100, message = "{user.password.size}")
  private String password;

  /** Email of the user. Can't be empty. Max size is 100 characters. */
  @NotEmpty(message = "{user.email.empty}")
  @Size(max = 100, message = "{user.email.size}")
  @Email(message = "{user.email.format}")
  private String email;

  /** Phone of the user. Can be empty. Max size is 10 characters. */
  @Size(min = 10, max = 10, message = "{user.phone.size}")
  private String phone;

  /** id of the {@link Address} of the user. Can't be null. */
  @NotNull(message = "{user.address.null}")
  private Integer addressId;

  // ===== Getters and Setters =====

  /**
   * Give the id of the user.
   *
   * @return id of the user.
   */
  public Integer getUserId() {
    return userId;
  }

  /**
   * Set the id of the user.
   *
   * @param userId id of the user.
   */
  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  /**
   * Give the login of the user.
   *
   * @return the login of the user.
   */
  public String getLogin() {
    return login;
  }

  /**
   * Set the login of the user.
   *
   * @param login the login of the user.
   */
  public void setLogin(String login) {
    this.login = login;
  }

  /**
   * Give the password of the user.
   *
   * @return the password of the user.
   */
  public String getPassword() {
    return password;
  }

  /**
   * Set the password of the user.
   *
   * @param password the password of the user.
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * Give the email of the user.
   *
   * @return the email of the user.
   */
  public String getEmail() {
    return email;
  }

  /**
   * Set the email of the user.
   *
   * @param email the email of the user.
   */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Give the phone of the user.
   *
   * @return the phone of the user.
   */
  public String getPhone() {
    return phone;
  }

  /**
   * Set the phone of the user.
   *
   * @param phone the phone of the user.
   */
  public void setPhone(String phone) {
    this.phone = phone;
  }

  /**
   * Give the address id of the user.
   *
   * @return the address id of the user.
   */
  public Integer getAddressId() {
    return addressId;
  }

  /**
   * Set the address id of the user.
   *
   * @param addressId the address id of the user.
   */
  public void setAddressId(Integer addressId) {
    this.addressId = addressId;
  }

  // ===== Methods =====

  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("userId", userId)
        .append("login", login)
        .append("password", password)
        .append("email", email)
        .append("phone", phone)
        .append("addressId", addressId)
        .toString();
  }
}
