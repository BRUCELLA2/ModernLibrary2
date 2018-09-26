package fr.brucella.projects.libraryws.business.contracts.managers.administration;

import fr.brucella.projects.libraryws.entity.books.model.Author;
import fr.brucella.projects.libraryws.entity.books.model.Book;
import fr.brucella.projects.libraryws.entity.books.model.Genre;
import fr.brucella.projects.libraryws.entity.books.model.Publisher;
import fr.brucella.projects.libraryws.entity.exceptions.FunctionalException;
import fr.brucella.projects.libraryws.entity.exceptions.TechnicalException;
import fr.brucella.projects.libraryws.entity.users.model.Role;

/**
 * Interface for Administration Manager
 *
 * @author BRUCELLA2
 */
public interface AdministrationManager {

  /**
   * Add a book.
   *
   * @param book book to add.
   * @return id of the new book.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws FunctionalException - This exception is throw if the book is not valid (null or with
   *     invalid data).
   */
  Integer addBook(final Book book) throws TechnicalException, FunctionalException;

  /**
   * Add an author.
   *
   * @param author an author.
   * @return id of the author.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws FunctionalException - This exception is throw if the author is not valid (null or with
   *     invalid data).
   */
  Integer addAuthor(final Author author) throws TechnicalException, FunctionalException;

  /**
   * Add a genre.
   *
   * @param genre a genre.
   * @return id of the genre.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws FunctionalException - This exception is throw if the genre is not valid (null or with
   *     invalid data).
   */
  Integer addGenre(final Genre genre) throws TechnicalException, FunctionalException;

  /**
   * Add a publisher.
   *
   * @param publisher a publisher.
   * @return id of the publisher.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws FunctionalException - This exception is throw if the publisher is not valid (null or
   *     with invalid data).
   */
  Integer addPublisher(final Publisher publisher) throws TechnicalException, FunctionalException;

  /**
   * Add a role.
   *
   * @param role a role.
   * @return id of the role.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws FunctionalException - This exception is throw if the role is not valid (null or with
   *     invalid data).
   */
  Integer addRole(final Role role) throws TechnicalException, FunctionalException;

  /**
   * Modify a book.
   *
   * @param book book to modify (with data modified).
   * @return true if modification is a success. Throw exception if extend fail.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws FunctionalException Throw this exception if there is a functional problem : - if the id
   *     of the book is not valid - if the book is not found.
   */
  Boolean modifyBook(final Book book) throws TechnicalException, FunctionalException;

  /**
   * Modify an author.
   *
   * @param author author to modify (with data modified).
   * @return true if modification is a success. Throw exception if extend fail.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws FunctionalException Throw this exception if there is a functional problem : - if the id
   *     of the author is not valid - if the author is not found.
   */
  Boolean modifyAuthor(final Author author) throws TechnicalException, FunctionalException;

  /**
   * Modify a genre.
   *
   * @param genre genre to modify (with data modified).
   * @return true if modification is a success. Throw exception if extend fail.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws FunctionalException Throw this exception if there is a functional problem : - if the id
   *     of the genre is not valid - if the genre is not found.
   */
  Boolean modifyGenre(final Genre genre) throws TechnicalException, FunctionalException;

  /**
   * Modify a publisher.
   *
   * @param publisher publisher to modify (with data modified).
   * @return true if modification is a success. Throw exception if extend fail.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws FunctionalException Throw this exception if there is a functional problem : - if the id
   *     of the publisher is not valid - if the publisher is not found.
   */
  Boolean modifyPublisher(final Publisher publisher) throws TechnicalException, FunctionalException;

  /**
   * Modify a role.
   *
   * @param role role to modify (with data modified).
   * @return true if modification is a success. Throw exception if extend fail.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws FunctionalException Throw this exception if there is a functional problem : - if the id
   *     of the role is not valid - if the role is not found.
   */
  Boolean modifyRole(final Role role) throws TechnicalException, FunctionalException;
}
