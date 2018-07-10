package fr.brucella.projects.libraryws.dao.contracts.dao.books;

import fr.brucella.projects.libraryws.entity.books.model.Publisher;
import fr.brucella.projects.libraryws.entity.exceptions.NotFoundException;
import fr.brucella.projects.libraryws.entity.exceptions.TechnicalException;

/**
 * Interface for Author Data Access Object.
 *
 * @author BRUCELLA2
 */
public interface PublisherDao {

  /**
   * Give the publisher with the specified id from the datastore.
   *
   * @param publisherId id of the publisher.
   * @return the publisher with the specified id.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and the
   *     author is not found.
   */
  Publisher getPublisher(final Integer publisherId) throws TechnicalException, NotFoundException;

  /**
   * Update an existing publisher in the datastore.
   *
   * @param publisher the publisher with the updated informations to save in datastore.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and the
   *     author is not found.
   */
  void updatePublisher(final Publisher publisher) throws TechnicalException, NotFoundException;

  /**
   * Insert a new publisher in the datastore.
   *
   * @param publisher the publisher to insert in datastore.
   * @return the id of the new publisher.
   * @throws TechnicalException - wraps technical exception caused during data access.
   */
  int insertPublisher(final Publisher publisher) throws TechnicalException;

  /**
   * Delete the publisher with the specified id in the datastore.
   *
   * @param publisherId id of the publisher.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and the
   *     author is not foun
   */
  void deletePublisher(final Integer publisherId) throws TechnicalException, NotFoundException;
}
