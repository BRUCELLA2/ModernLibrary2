package fr.brucella.projects.libraryws.dao.contracts.dao.users;

import fr.brucella.projects.libraryws.entity.exceptions.NotFoundException;
import fr.brucella.projects.libraryws.entity.exceptions.TechnicalException;
import fr.brucella.projects.libraryws.entity.users.model.UserOptions;

/**
 * Interface for UserOptions Data Access Object.
 *
 * @author BRUCELLA2
 */
public interface UserOptionsDao {

  /**
   * Give the userOptions with the specified id from the datastore.
   *
   * @param userOptionsId id of the userOptions.
   * @return the userOptions with the specified id.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and the
   *     userOptions is not found.
   */
  UserOptions getUserOptions(final Integer userOptionsId)
      throws TechnicalException, NotFoundException;

  /**
   * Update existing user options in the datastore.
   *
   * @param userOptions the userOptions with the updated informations to save in datastore.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and the
   *     userOptions is not found.
   */
  void updateUserOptions(final UserOptions userOptions)
      throws TechnicalException, NotFoundException;

  /**
   * Insert a new userOptions in the datastore.
   *
   * @param userOptions the userOptions to insert in datastore.
   * @return the id of the new userOptions.
   * @throws TechnicalException - wraps technical exception caused during data access.
   */
  int insertUserOptions(final UserOptions userOptions) throws TechnicalException;

  /**
   * Delete the userOptions in the datastore.
   *
   * @param userOptionsId id of the userOptions.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and the
   *     userOptions is not found.
   */
  void deleteUserOptions(final Integer userOptionsId) throws TechnicalException, NotFoundException;
}
