package fr.brucella.projects.libraryws.entity.exceptions;

/**
 * Exception class raised when an Functional erreur occured.
 *
 * @author BRUCELLA2
 */
public class FunctionalException extends Exception {

  /**
   * Serial ID.
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constructs a new FunctionalException with the specified detail message.
   *
   * @param message the detail message.
   */
  public FunctionalException(final String message) {
    super(message);
  }

  /**
   * Constructs a new FunctionalException with the specified detail message and cause.
   *
   * @param message the detail message.
   * @param cause the cause
   */
  public FunctionalException(final String message, final Throwable cause) {
    super(message, cause);
  }
}
