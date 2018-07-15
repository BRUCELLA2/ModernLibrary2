package fr.brucella.projects.libraryws.services;

import fr.brucella.projects.libraryws.entity.books.model.Author;
import fr.brucella.projects.libraryws.entity.books.model.Book;
import fr.brucella.projects.libraryws.entity.books.model.Genre;
import fr.brucella.projects.libraryws.entity.books.model.Publisher;
import fr.brucella.projects.libraryws.entity.users.model.Role;
import javax.jws.WebMethod;
import javax.jws.WebService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

/**
 * Administration Management Web Service. Allow to add and modify various elements of the Modern
 * Library (Book, Author, Genre, Publisher, UserRole).
 *
 * @author BRUCELLA2
 */
@WebService(serviceName = "AdministrationService")
@Component
public class AdministrationService {

  /** Administration Management logger. */
  private static final Log LOG = LogFactory.getLog(AdministrationService.class);

  /**
   * Add a book.
   *
   * @param book book to add.
   * @return id of the new book added.
   */
  @WebMethod
  public Integer addBook(final Book book) {
    // TODO implementation
    return null;
  }

  /**
   * Add an author.
   *
   * @param author author to add.
   * @return id of the new author added.
   */
  @WebMethod
  public Integer addAuthor(final Author author) {
    // TODO implementation
    return null;
  }

  /**
   * Add a genre of book.
   *
   * @param genre genre to add.
   * @return id of the new genre added.
   */
  @WebMethod
  public Integer addGenre(final Genre genre) {
    // TODO implementation
    return null;
  }

  /**
   * Add a publisher.
   *
   * @param publisher publisher to add.
   * @return id of the new publisher added.
   */
  @WebMethod
  public Integer addPublisher(final Publisher publisher) {
    // TODO implementation
    return null;
  }

  /**
   * Add a role which can be give to an user.
   *
   * @param role role to add.
   * @return id of the role.
   */
  @WebMethod
  public Integer addRole(final Role role) {
    // TODO implementation
    return null;
  }

  /**
   * Modify a book.
   *
   * @param book book to modify (with data modified).
   * @return true if modification is a success, false otherwise.
   */
  @WebMethod
  public Boolean modifyBook(final Book book) {
    // TODO implementation
    return null;
  }

  /**
   * Modify an author.
   *
   * @param author author to modify (with data modified).
   * @return true if modification is a success, false otherwise.
   */
  @WebMethod
  public Boolean modifyAuthor(final Author author) {
    // TODO implementation
    return null;
  }

  /**
   * Modify a genre.
   *
   * @param genre genre to modify (with data modified).
   * @return true if modification is a success, false otherwise.
   */
  @WebMethod
  public Boolean modifyGenre(final Genre genre) {
    // TODO implementation
    return null;
  }

  /**
   * Modify a publisher.
   *
   * @param publisher publisher to modify (with data modified).
   * @return true if modification is a success, false otherwise.
   */
  @WebMethod
  public Boolean modifyPublisher(final Publisher publisher) {
    // TODO implementation
    return null;
  }

  /**
   * Modify a role.
   *
   * @param role role to modify (with data modified).
   * @return true if modification is a success, false otherwise.
   */
  @WebMethod
  public Boolean modifyRole(final Role role) {
    // TODO implementation
    return null;
  }
}
