package fr.brucella.projects.libraryws.entity.exceptions;

import javax.xml.ws.WebFault;

@WebFault(name = "LibraryWsException")
public class LibraryWsException extends Exception {

  /** LibraryWs fault, hold fault code and fault message. */
  private LibraryWsFault fault;

  // ===== Constructors =====

  /**
   * Constructor without throwable cause.
   *
   * @param message message of the exception.
   * @param fault fault associated to the exception.
   */
  public LibraryWsException(final String message, final LibraryWsFault fault) {
    super(message);
    this.fault = fault;
  }

  /**
   * Constructor with throwable cause.
   *
   * @param message message of the exception.
   * @param cause Throwable cause of the exception.
   * @param fault fault associated to the exception.
   */
  public LibraryWsException(
      final String message, final Throwable cause, final LibraryWsFault fault) {
    super(message, cause);
    this.fault = fault;
  }

  // ===== Getters and Setters =====

  /**
   * Give the fault associated to the exception.
   *
   * @return the fault associated to the exception.
   */
  public LibraryWsFault getFaultInfo() {
    return fault;
  }
}
