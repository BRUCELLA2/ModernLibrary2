package fr.brucella.projects.libraryws.entity.exceptions;

/**
 * Exception class raised when an technical erreur occured.
 *
 * @author BRUCELLA2
 */
public class TechnicalException extends Exception {

  /** Serial ID. */
  private static final long serialVersionUID = 1L;

  /**
   * Constructs a new TechnicalException with the specified detail message.
   *
   * @param message the detail message.
   */
  public TechnicalException(final String message) {
    super(message);
  }

  /**
   * Constructs a new TechnicalException with the specified detail message and cause.
   *
   * @param message the detail message.
   * @param cause the cause
   */
  public TechnicalException(final String message, final Throwable cause) {
    super(message, cause);
  }
}
