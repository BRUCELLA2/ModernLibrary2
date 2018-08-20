package fr.brucella.projects.libraryws.business.contracts.managers.authentification;

import fr.brucella.projects.libraryws.entity.exceptions.FunctionalException;
import fr.brucella.projects.libraryws.entity.exceptions.TechnicalException;
import fr.brucella.projects.libraryws.entity.users.dto.FullUserDto;

/**
 * Interface for Authentification Manager
 *
 * @author BRUCELLA2
 */
public interface AuthentificationManager {

  /**
   * Get a Full user dto authentified by login and password. If login and password don't match, this
   * method return null.
   *
   * @param login the login of the user.
   * @param password password of the user.
   * @return the Full user dto.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws FunctionalException - This exception is throw if the login or the password are not
   *     valid.
   */
  FullUserDto getConnectUser(final String login, final String password)
      throws TechnicalException, FunctionalException;

  /**
   * Modify the user with the user provide in parameter. If password don't match with the user
   * password store in datastore, this method throws a Functional exception.
   *
   * @param fullUserDto The full user dto with the modification.
   * @return true if the password match with the user password store in datastore and modification
   *     success.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws FunctionalException - This exception is throw if the fullUserDto are not valid (null or
   *     with invalid data). This exception is throw if the password don't match with the user
   *     password store in the datastore.
   */
  Boolean userModification(final FullUserDto fullUserDto)
      throws TechnicalException, FunctionalException;

  /**
   * Add a new user (with new address).
   *
   * @param fullUserDto full user informations to add.
   * @return id of the new user added.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws FunctionalException - This exception is throw if the fullUserDto are not valid (null or
   *     with invalid data).
   */
  Integer addNewUser(final FullUserDto fullUserDto) throws TechnicalException, FunctionalException;

  /**
   * Give the role with the role id to the user with the user id.
   *
   * @param userId id of the user.
   * @param roleId id of the role.
   * @return true if the role is add to user correctly.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws FunctionalException - This exception is throw if the id of the user or the id of the
   *     role are null.
   */
  Boolean giveRole(final Integer userId, final Integer roleId)
      throws TechnicalException, FunctionalException;
}
