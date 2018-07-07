package fr.brucella.projects.libraryws.dao.contracts.dao.books;

import fr.brucella.projects.libraryws.entity.books.model.Genre;
import fr.brucella.projects.libraryws.entity.exceptions.NotFoundException;
import fr.brucella.projects.libraryws.entity.exceptions.TechnicalException;

/**
 * Interface for Genre Data Access Object.
 *
 * @author BRUCELLA2
 */
public interface GenreDao {

  /**
   * Give the genre with the specified id from datastore.
   *
   * @param genreId id of the genre.
   * @return the genre with the specified id.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and the
   *     author is not found.
   */
  Genre getGenre(final Integer genreId) throws TechnicalException, NotFoundException;

  /**
   * Update an existing genre in the datastore.
   *
   * @param genre the genre with the updated informations to save in datastore.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and the
   *     author is not found.
   */
  void updateGenre(final Genre genre) throws TechnicalException, NotFoundException;

  /**
   * Insert a new genre in the datastore.
   *
   * @param genre the genre to insert in datastore.
   * @return the id of the new genre.
   * @throws TechnicalException - wraps technical exception caused during data access.
   */
  int insertGenre(final Genre genre) throws TechnicalException;

  /**
   * Delete the genre with the specified id in the datastore.
   *
   * @param genreId id of the genre.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and the
   *     author is not found.
   */
  void deleteGenre(final Integer genreId) throws TechnicalException, NotFoundException;
}
