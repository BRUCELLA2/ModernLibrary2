package fr.brucella.projects.libraryws.entity.exceptions;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Represents a library webservice fault.
 *
 * @author BRUCELLA2
 */
public class LibraryWsFault {

  /** Code of the fault. */
  private String faultCode;

  /** Message of the fault. */
  private String faultString;

  // ===== Constructors =====

  /** Default Constructor. */
  public LibraryWsFault() {
    // This constructor is intentionally empty. Nothing special is needed here.
  }

  /**
   * Full Constructor.
   *
   * @param faultCode the fault code.
   * @param faultString the fault message.
   */
  public LibraryWsFault(final String faultCode, final String faultString) {
    this.faultCode = faultCode;
    this.faultString = faultString;
  }

  // ===== Getters and Setters =====

  /**
   * Give the fault code.
   *
   * @return the fault code.
   */
  public String getFaultCode() {
    return faultCode;
  }

  /**
   * Set the fault code.
   *
   * @param faultCode the fault code.
   */
  public void setFaultCode(final String faultCode) {
    this.faultCode = faultCode;
  }

  /**
   * Give the fault message.
   *
   * @return the fault message.
   */
  public String getFaultString() {
    return faultString;
  }

  /**
   * Set the fault message.
   *
   * @param faultString the fault message.
   */
  public void setFaultString(final String faultString) {
    this.faultString = faultString;
  }

  // ===== Methods =====

  /**
   * a string representation of the LibraryWsFault object.
   *
   * @return a string representation of the LibraryWsFault object.
   */
  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("faultCode", faultCode)
        .append("faultString", faultString)
        .toString();
  }
}
