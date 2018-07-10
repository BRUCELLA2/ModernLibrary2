package fr.brucella.projects.libraryws.entity.users.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Represents the address of a user.
 *
 * @author BRUCELLA2
 */
public class Address {

  /** Id of the address. */
  private Integer addressId;

  /** First line of the address. Can't be empty. */
  @NotEmpty(message = "{address.line1.empty}")
  @Size(min = 1, max = 200, message = "{address.line1.size}")
  private String line1;

  /** Second line of the address. Can be empty. */
  @Size(max = 200, message = "{address.line2.size}")
  private String line2;

  /** Third line of the address. Can be empty. */
  @Size(max = 200, message = "{address.line3.size}")
  private String line3;

  /** City of the address. Can't be empty. */
  @NotEmpty(message = "{address.city.empty}")
  @Size(min = 1, max = 100, message = "{address.city.size}")
  private String city;

  /** Zip Code of the address city. Can't be empty. */
  @NotEmpty(message = "{address.zipCode.empty}")
  @Size(min = 5, max = 5, message = "{address.zipCode.size}")
  private String zipCode;

  // ===== Getters and Setters =====

  /**
   * Give the id of the address.
   *
   * @return the id of the address.
   */
  public Integer getAddressId() {
    return addressId;
  }

  /**
   * Set the id of the address.
   *
   * @param addressId the id of the address.
   */
  public void setAddressId(final Integer addressId) {
    this.addressId = addressId;
  }

  /**
   * Give the first line of the address.
   *
   * @return the first line of the address.
   */
  public String getLine1() {
    return line1;
  }

  /**
   * Set the first line of the address.
   *
   * @param line1 the first line of the address.
   */
  public void setLine1(final String line1) {
    this.line1 = line1;
  }

  /**
   * Give the second line of the address.
   *
   * @return the second line of the address.
   */
  public String getLine2() {
    return line2;
  }

  /**
   * Set the second line of the address.
   *
   * @param line2 the second line of the address.
   */
  public void setLine2(final String line2) {
    this.line2 = line2;
  }

  /**
   * Give the third line of the address.
   *
   * @return the third line of the address.
   */
  public String getLine3() {
    return line3;
  }

  /**
   * Set the third line of the address.
   *
   * @param line3 the third line of the address.
   */
  public void setLine3(final String line3) {
    this.line3 = line3;
  }

  /**
   * Give the city of the address.
   *
   * @return the city of the address.
   */
  public String getCity() {
    return city;
  }

  /**
   * Set the city of the address.
   *
   * @param city the city of the address.
   */
  public void setCity(final String city) {
    this.city = city;
  }

  /**
   * Give the zip code of the city.
   *
   * @return the zip code of the city.
   */
  public String getZipCode() {
    return zipCode;
  }

  /**
   * Set the zip code of the city.
   *
   * @param zipCode the zip code of the city.
   */
  public void setZipCode(final String zipCode) {
    this.zipCode = zipCode;
  }

  // ===== Constructors =====

  /** Default Constructor */
  public Address() {}

  // ===== Methods =====

  /**
   * a string representation of the Address object.
   *
   * @return a string representation of the Address object.
   */
  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("addressId", addressId)
        .append("line1", line1)
        .append("line2", line2)
        .append("line3", line3)
        .append("city", city)
        .append("zipCode", zipCode)
        .toString();
  }
}
