package fr.brucella.projects.libraryws.dao.contracts.dao.books;

import fr.brucella.projects.libraryws.entity.books.model.Author;
import fr.brucella.projects.libraryws.entity.exceptions.NotFoundException;
import fr.brucella.projects.libraryws.entity.exceptions.TechnicalException;
import java.util.List;

/**
 * Interface for Author Data Access Object.
 *
 * @author BRUCELLA2
 */
public interface AuthorDao {

  /**
   * Give the author with the specified id from the datastore.
   *
   * @param authorId id of the author.
   * @return the author with the specified id.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and the
   *     author is not found.
   */
  Author getAuthor(final Integer authorId) throws TechnicalException, NotFoundException;

  /**
   * Give the list of authors of a book. Sorted by author name.
   *
   * @param bookId id of the book
   * @return the list of authors of the book sorted by author name.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and no
   *     author is found.
   */
  List<Author> getBookAuthors(final Integer bookId) throws TechnicalException, NotFoundException;

  /**
   * Update an existing author in the datastore.
   *
   * @param author the author with the updated informations to save in datastore.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and the
   *     author is not found.
   */
  void updateAuthor(final Author author) throws TechnicalException, NotFoundException;

  /**
   * Insert a new author in the datastore.
   *
   * @param author The author to insert in datastore.
   * @return the id of the new author.
   * @throws TechnicalException - wraps technical exception caused during data access.
   */
  int insertAuthor(final Author author) throws TechnicalException;

  /**
   * Delete the author with the specified id in the datastore.
   *
   * @param authorId id of the author.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and the
   *     author is not found.
   */
  void deleteAuthor(final Integer authorId) throws TechnicalException, NotFoundException;
}
