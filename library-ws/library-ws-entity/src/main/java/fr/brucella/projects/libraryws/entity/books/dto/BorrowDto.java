package fr.brucella.projects.libraryws.entity.books.dto;

import fr.brucella.projects.libraryws.entity.books.model.BookBorrowed;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * Represents a Borrow Data Transfert Object. Includes some informations on book (title) and on user
 * (login) who borrow the book. Includes informations on the borrowing.
 *
 * @author BRUCELLA2
 */
public class BorrowDto extends BookBorrowed {

  /** Title of the book. Can't be empty. */
  @NotEmpty(message = "{book.title.empty}")
  @Size(min = 1, max = 150, message = "{book.title.size}")
  private String title;

  /** login of the user. Can't be empty. Max size is 30 characters. */
  @NotEmpty(message = "{user.login.empty}")
  @Size(min = 1, max = 30, message = "{user.login.size}")
  private String login;

  // ===== Constructor =====

  /** Defaut Constructor */
  public BorrowDto() {
    super();
  }

  // ===== Getters and Setters =====

  /**
   * Give the title of the book.
   *
   * @return the title of the book.
   */
  public String getTitle() {
    return title;
  }

  /**
   * Set the title of the book.
   *
   * @param title the title of the book.
   */
  public void setTitle(final String title) {
    this.title = title;
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
  public void setLogin(final String login) {
    this.login = login;
  }
}
