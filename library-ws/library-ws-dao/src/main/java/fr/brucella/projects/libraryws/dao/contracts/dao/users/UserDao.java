package fr.brucella.projects.libraryws.dao.contracts.dao.users;

import fr.brucella.projects.libraryws.entity.exceptions.NotFoundException;
import fr.brucella.projects.libraryws.entity.exceptions.TechnicalException;
import fr.brucella.projects.libraryws.entity.users.model.User;

/**
 * Interface for User Data Access Object.
 *
 * @author BRUCELLA2
 */
public interface UserDao {

  /**
   * Give the user with the specified id from the datastore.
   *
   * @param userId id of the user.
   * @return the user with the specified id.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and the
   *     author is not found.
   */
  User getUser(final Integer userId) throws TechnicalException, NotFoundException;

  /**
   * Update an existing user in the database.
   *
   * @param user the user with the updated informations to save in datastore.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and the
   *     author is not found.
   */
  void updateUser(final User user) throws TechnicalException, NotFoundException;

  /**
   * Insert a new user in the datastore.
   *
   * @param user the user to insert in datastore.
   * @return the id of the new user.
   * @throws TechnicalException - wraps technical exception caused during data access.
   */
  int insertUser(final User user) throws TechnicalException;

  /**
   * Delete the user with the specified id in the datastore.
   *
   * @param userId id of the user.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and the
   *     author is not found.
   */
  void deleteUser(final Integer userId) throws TechnicalException, NotFoundException;
}
