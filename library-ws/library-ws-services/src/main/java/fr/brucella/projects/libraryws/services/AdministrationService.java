package fr.brucella.projects.libraryws.services;

import fr.brucella.projects.libraryws.business.contracts.ManagerFactory;
import fr.brucella.projects.libraryws.entity.books.model.Author;
import fr.brucella.projects.libraryws.entity.books.model.Book;
import fr.brucella.projects.libraryws.entity.books.model.Genre;
import fr.brucella.projects.libraryws.entity.books.model.Publisher;
import fr.brucella.projects.libraryws.entity.exceptions.FunctionalException;
import fr.brucella.projects.libraryws.entity.exceptions.LibraryWsException;
import fr.brucella.projects.libraryws.entity.exceptions.LibraryWsFault;
import fr.brucella.projects.libraryws.entity.exceptions.TechnicalException;
import fr.brucella.projects.libraryws.entity.users.model.Role;
import javax.jws.WebMethod;
import javax.jws.WebService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

  /** String message give to user for technical problem in LibraryWsException */
  private static final String TECH_ERROR = "Problème technique";

  /** String message give to user for functional problem in LibraryWsException */
  private static final String FUNC_ERROR = "Erreur fonctionnelle";

  /** Fault Code for server fault */
  private static final String SERVER = "soap:Server";

  /** Fault Code for client fault */
  private static final String CLIENT = "soap:Client";

  // ----- Manager
  /** The Manager Factory Manager Factory allow to get and set business managers. */
  @Autowired private ManagerFactory managerFactory;

  // ===== Constructor =====

  /** Default constructor. */
  public AdministrationService() {
    // This constructor is intentionally empty. Nothing special is needed here.
  }

  // ===== WebMethods ===== //

  // ===== Add Book
  /**
   * Add a book.
   *
   * @param book book to add.
   * @return id of the new book added.
   */
  @WebMethod
  public Integer addBook(final Book book) throws LibraryWsException {

    try {
      return this.managerFactory.getAdministrationManager().addBook(book);
    } catch (FunctionalException exception) {
      LOG.error(exception.getMessage());
      throw new LibraryWsException(
          FUNC_ERROR, exception, new LibraryWsFault(CLIENT, exception.getMessage()));
    } catch (TechnicalException exception) {
      LOG.error(exception.getMessage());
      throw new LibraryWsException(
          TECH_ERROR, exception, new LibraryWsFault(SERVER, exception.getMessage()));
    }
  }

  /**
   * Add an author.
   *
   * @param author author to add.
   * @return id of the new author added.
   */
  @WebMethod
  public Integer addAuthor(final Author author) throws LibraryWsException {

    try {
      return this.managerFactory.getAdministrationManager().addAuthor(author);
    } catch (FunctionalException exception) {
      LOG.error(exception.getMessage());
      throw new LibraryWsException(
          FUNC_ERROR, exception, new LibraryWsFault(CLIENT, exception.getMessage()));
    } catch (TechnicalException exception) {
      LOG.error(exception.getMessage());
      throw new LibraryWsException(
          TECH_ERROR, exception, new LibraryWsFault(SERVER, exception.getMessage()));
    }
  }

  /**
   * Add a genre of book.
   *
   * @param genre genre to add.
   * @return id of the new genre added.
   */
  @WebMethod
  public Integer addGenre(final Genre genre) throws LibraryWsException {

    try {
      return this.managerFactory.getAdministrationManager().addGenre(genre);
    } catch (FunctionalException exception) {
      LOG.error(exception.getMessage());
      throw new LibraryWsException(
          FUNC_ERROR, exception, new LibraryWsFault(CLIENT, exception.getMessage()));
    } catch (TechnicalException exception) {
      LOG.error(exception.getMessage());
      throw new LibraryWsException(
          TECH_ERROR, exception, new LibraryWsFault(SERVER, exception.getMessage()));
    }
  }

  /**
   * Add a publisher.
   *
   * @param publisher publisher to add.
   * @return id of the new publisher added.
   */
  @WebMethod
  public Integer addPublisher(final Publisher publisher) throws LibraryWsException {

    try {
      return this.managerFactory.getAdministrationManager().addPublisher(publisher);
    } catch (FunctionalException exception) {
      LOG.error(exception.getMessage());
      throw new LibraryWsException(
          FUNC_ERROR, exception, new LibraryWsFault(CLIENT, exception.getMessage()));
    } catch (TechnicalException exception) {
      LOG.error(exception.getMessage());
      throw new LibraryWsException(
          TECH_ERROR, exception, new LibraryWsFault(SERVER, exception.getMessage()));
    }
  }

  /**
   * Add a role which can be give to an user.
   *
   * @param role role to add.
   * @return id of the role.
   */
  @WebMethod
  public Integer addRole(final Role role) throws LibraryWsException {

    try {
      return this.managerFactory.getAdministrationManager().addRole(role);
    } catch (FunctionalException exception) {
      LOG.error(exception.getMessage());
      throw new LibraryWsException(
          FUNC_ERROR, exception, new LibraryWsFault(CLIENT, exception.getMessage()));
    } catch (TechnicalException exception) {
      LOG.error(exception.getMessage());
      throw new LibraryWsException(
          TECH_ERROR, exception, new LibraryWsFault(SERVER, exception.getMessage()));
    }
  }

  /**
   * Modify a book.
   *
   * @param book book to modify (with data modified).
   * @return true if modification is a success. Throw exception if not.
   * @throws LibraryWsException Throw this exception if there is a technical problem. Throw this
   *     exception if there is a functional problem : - if the id of the book is not valid - if the
   *     book is not found.
   */
  @WebMethod
  public Boolean modifyBook(final Book book) throws LibraryWsException {

    try {
      return this.managerFactory.getAdministrationManager().modifyBook(book);
    } catch (FunctionalException exception) {
      LOG.error(exception.getMessage());
      throw new LibraryWsException(
          FUNC_ERROR, exception, new LibraryWsFault(CLIENT, exception.getMessage()));
    } catch (TechnicalException exception) {
      LOG.error(exception.getMessage());
      throw new LibraryWsException(
          TECH_ERROR, exception, new LibraryWsFault(SERVER, exception.getMessage()));
    }
  }

  /**
   * Modify an author.
   *
   * @param author author to modify (with data modified).
   * @return true if modification is a success. Throw exception if not.
   * @throws LibraryWsException Throw this exception if there is a technical problem. Throw this
   *     exception if there is a functional problem : - if the id of the author is not valid - if
   *     the author is not found.
   */
  @WebMethod
  public Boolean modifyAuthor(final Author author) throws LibraryWsException {

    try {
      return this.managerFactory.getAdministrationManager().modifyAuthor(author);
    } catch (FunctionalException exception) {
      LOG.error(exception.getMessage());
      throw new LibraryWsException(
          FUNC_ERROR, exception, new LibraryWsFault(CLIENT, exception.getMessage()));
    } catch (TechnicalException exception) {
      LOG.error(exception.getMessage());
      throw new LibraryWsException(
          TECH_ERROR, exception, new LibraryWsFault(SERVER, exception.getMessage()));
    }
  }

  /**
   * Modify a genre.
   *
   * @param genre genre to modify (with data modified).
   * @return true if modification is a success. Throw exception if not.
   * @throws LibraryWsException Throw this exception if there is a technical problem. Throw this
   *     exception if there is a functional problem : - if the id of the genre is not valid - if the
   *     genre is not found.
   */
  @WebMethod
  public Boolean modifyGenre(final Genre genre) throws LibraryWsException {

    try {
      return this.managerFactory.getAdministrationManager().modifyGenre(genre);
    } catch (FunctionalException exception) {
      LOG.error(exception.getMessage());
      throw new LibraryWsException(
          FUNC_ERROR, exception, new LibraryWsFault(CLIENT, exception.getMessage()));
    } catch (TechnicalException exception) {
      LOG.error(exception.getMessage());
      throw new LibraryWsException(
          TECH_ERROR, exception, new LibraryWsFault(SERVER, exception.getMessage()));
    }
  }

  /**
   * Modify a publisher.
   *
   * @param publisher publisher to modify (with data modified).
   * @return true if modification is a success. Throw exception if not.
   * @throws LibraryWsException Throw this exception if there is a technical problem. Throw this
   *     exception if there is a functional problem : - if the id of the publisher is not valid - if
   *     the publisher is not found.
   */
  @WebMethod
  public Boolean modifyPublisher(final Publisher publisher) throws LibraryWsException {

    try {
      return this.managerFactory.getAdministrationManager().modifyPublisher(publisher);
    } catch (FunctionalException exception) {
      LOG.error(exception.getMessage());
      throw new LibraryWsException(
          FUNC_ERROR, exception, new LibraryWsFault(CLIENT, exception.getMessage()));
    } catch (TechnicalException exception) {
      LOG.error(exception.getMessage());
      throw new LibraryWsException(
          TECH_ERROR, exception, new LibraryWsFault(SERVER, exception.getMessage()));
    }
  }

  /**
   * Modify a role.
   *
   * @param role role to modify (with data modified).
   * @return true if modification is a success. Throw exception if not.
   * @throws LibraryWsException Throw this exception if there is a technical problem. Throw this
   *     exception if there is a functional problem : - if the id of the role is not valid - if the
   *     role is not found.
   */
  @WebMethod
  public Boolean modifyRole(final Role role) throws LibraryWsException {

    try {
      return this.managerFactory.getAdministrationManager().modifyRole(role);
    } catch (FunctionalException exception) {
      LOG.error(exception.getMessage());
      throw new LibraryWsException(
          FUNC_ERROR, exception, new LibraryWsFault(CLIENT, exception.getMessage()));
    } catch (TechnicalException exception) {
      LOG.error(exception.getMessage());
      throw new LibraryWsException(
          TECH_ERROR, exception, new LibraryWsFault(SERVER, exception.getMessage()));
    }
  }
}
