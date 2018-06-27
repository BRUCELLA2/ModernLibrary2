package fr.brucella.projects.services.administrationservices;

import fr.brucella.projects.libraryws.entity.books.Author;
import fr.brucella.projects.libraryws.entity.books.Book;
import fr.brucella.projects.libraryws.entity.books.Genre;
import fr.brucella.projects.libraryws.entity.books.Publisher;
import fr.brucella.projects.libraryws.entity.users.Role;
import javax.jws.WebMethod;
import javax.jws.WebService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Administration Management Web Service.
 * Allow to add and modify various elements of the Modern Library (Book, Author, Genre, Publisher, UserRole).
 *
 * @author BRUCELLA2
 */
@WebService(serviceName = "AdministrationManagement")
public class AdministrationManagement {


  /**
   * Administration Management logger.
   */
  private static final Log LOG = LogFactory.getLog(AdministrationManagement.class);



  /**
   * Add a book.
   *
   * @param book book to add.
   * @return id of the new book added.
   */
  @WebMethod
  public Integer addBook(Book book) {
    return null;
  }

  /**
   * Add an author.
   *
   * @param author author to add.
   * @return id of the new author added.
   */
  @WebMethod
  public Integer addAuthor(Author author) {
    return null;
  }

  /**
   * Add a genre of book.
   *
   * @param genre genre to add.
   * @return id of the new genre added.
   */
  @WebMethod
  public Integer addGenre(Genre genre) {
    return null;
  }

  /**
   * Add a publisher.
   *
   * @param publisher publisher to add.
   * @return id of the new publisher added.
   */
  @WebMethod
  public Integer addPublisher(Publisher publisher) {
    return null;
  }

  /**
   * Add a role which can be give to an user.
   *
   * @param role role to add.
   * @return id of the role.
   */
  @WebMethod
  public Integer addRole(Role role) {
    return null;
  }

  /**
   * Modify a book.
   *
   * @param book book to modify (with data modified).
   * @return true if modification is a success, false otherwise.
   */
  @WebMethod
  public Boolean modifyBook(Book book) {
    return null;
  }

  /**
   * Modify an author.
   *
   * @param author author to modify (with data modified).
   * @return true if modification is a success, false otherwise.
   */
  @WebMethod
  public Boolean modifyAuthor(Author author) {
    return null;
  }

  /**
   * Modify a genre.
   *
   * @param genre genre to modify (with data modified).
   * @return true if modification is a success, false otherwise.
   */
  @WebMethod
  public Boolean modifyGenre(Genre genre) {
    return null;
  }

  /**
   * Modify a publisher.
   *
   * @param publisher publisher to modify (with data modified).
   * @return true if modification is a success, false otherwise.
   */
  @WebMethod
  public Boolean modifyPublisher(Publisher publisher) {
    return null;
  }

  /**
   * Modify a role.
   *
   * @param role role to modify (with data modified).
   * @return true if modification is a success, false otherwise.
   */
  @WebMethod
  public Boolean modifyRole(Role role) {
    return null;
  }
}
