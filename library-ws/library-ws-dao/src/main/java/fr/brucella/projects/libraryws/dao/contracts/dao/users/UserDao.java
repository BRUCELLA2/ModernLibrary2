package fr.brucella.projects.libraryws.dao.contracts.dao.users;

import fr.brucella.projects.libraryws.entity.exceptions.NotFoundException;
import fr.brucella.projects.libraryws.entity.exceptions.TechnicalException;
import fr.brucella.projects.libraryws.entity.users.dto.FullUserDto;
import fr.brucella.projects.libraryws.entity.users.model.User;
import java.util.List;

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
   *     user is not found.
   */
  User getUser(final Integer userId) throws TechnicalException, NotFoundException;

  /**
   * Give the full user dto with the specified login from the datastore.
   *
   * @param login login of the user.
   * @return the full user dto with the specified login.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and the
   *     user is not found.
   */
  FullUserDto getUserByLogin(final String login) throws TechnicalException, NotFoundException;

  /**
   * Check if the login is not used.
   *
   * @param login the login.
   * @return true if the login is not used. False, if the login is already used.
   * @throws TechnicalException - wraps technical exception caused during data access.
   */
  Boolean loginAvailable(final String login) throws TechnicalException;

  /**
   * Give the list of users with a borrows not returned expired.
   *
   * @return the list of users with a borrows not returned expired.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and the
   *     user is not found.
   */
  List<User> getUserWithBorrowsExpired() throws TechnicalException, NotFoundException;

  /**
   * Give the list of users with before reminder options actived and a borrows not returned ended in
   * less than the number of days specified.
   *
   * @param nbDaysBeforeReminder the number of days before the end of borrows.
   * @return with before reminder options actived and a borrows not returned ended in less than the
   *     number of days specified.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and the
   *     user is not found.
   */
  List<User> getUserBeforeReminder(final Integer nbDaysBeforeReminder)
      throws TechnicalException, NotFoundException;

  /**
   * Update an existing user in the database.
   *
   * @param user the user with the updated informations to save in datastore.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and the
   *     user is not found.
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
   *     user is not found.
   */
  void deleteUser(final Integer userId) throws TechnicalException, NotFoundException;
}
