package fr.brucella.projects.libraryws.dao.contracts.dao.users;

import fr.brucella.projects.libraryws.entity.exceptions.NotFoundException;
import fr.brucella.projects.libraryws.entity.exceptions.TechnicalException;
import fr.brucella.projects.libraryws.entity.users.model.Role;
import java.util.List;

/**
 * Interface for Role Data Access Object.
 *
 * @author BRUCELLA2
 */
public interface RoleDao {

  /**
   * Give the role with the specified id from the datastore.
   *
   * @param roleId id of the role.
   * @return the role with the specified id.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and the
   *     author is not found.
   */
  Role getRole(final Integer roleId) throws TechnicalException, NotFoundException;

  /**
   * Give the list of the roles for an user.
   *
   * @param userId id of the user.
   * @return the list of the roles.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and no
   *     author is found.
   */
  List<Role> getRolesForUser(final Integer userId) throws TechnicalException, NotFoundException;

  /**
   * Update an existing role in the datastore.
   *
   * @param role the role with the updated informations to save in datastore.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and the
   *     author is not found.
   */
  void updateRole(final Role role) throws TechnicalException, NotFoundException;

  /**
   * Insert a new role in the datastore.
   *
   * @param role the role to insert in datastore.
   * @return the id of the new role.
   * @throws TechnicalException - wraps technical exception caused during data access.
   */
  int insertRole(final Role role) throws TechnicalException;

  /**
   * Delete the role with the specified id in the datastore.
   *
   * @param roleId id of the role.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and the
   *     author is not found.
   */
  void deleteRole(final Integer roleId) throws TechnicalException, NotFoundException;
}
