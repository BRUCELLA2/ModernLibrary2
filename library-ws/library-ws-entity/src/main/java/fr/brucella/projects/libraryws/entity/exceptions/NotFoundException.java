package fr.brucella.projects.libraryws.entity.exceptions;

/**
 * Exception class raised when an business object is not found.
 *
 * @author BRUCELLA2
 */
public class NotFoundException extends Exception {

  /** Serial ID. */
  private static final long serialVersionUID = 1L;

  /**
   * Constructs a new NotFoundException with the specified detail message.
   *
   * @param message the detail message.
   */
  public NotFoundException(final String message) {
    super(message);
  }

  /**
   * Constructs a new NotFoundException with the specified detail message and cause.
   *
   * @param message the detail message.
   * @param cause the cause
   */
  public NotFoundException(final String message, final Throwable cause) {
    super(message, cause);
  }
}
