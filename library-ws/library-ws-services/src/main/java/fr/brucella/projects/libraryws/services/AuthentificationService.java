package fr.brucella.projects.libraryws.services;

import fr.brucella.projects.libraryws.entity.users.model.Role;
import fr.brucella.projects.libraryws.entity.users.model.User;
import javax.jws.WebMethod;
import javax.jws.WebService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

/**
 * Authentification Management Service.
 *
 * @author BRUCELLA2
 */
@WebService(serviceName = "AuthentificationService")
@Component
public class AuthentificationService {

  /** Authentification Management logger. */
  private static final Log LOG = LogFactory.getLog(AuthentificationService.class);

  /**
   * Check if login and password match and return the user corresponding to this login.
   *
   * @param login login of the user.
   * @param password password of the user.
   * @return the user corresponding to this login if login and password match. Return null
   *     otherwise.
   */
  @WebMethod
  public User login(final String login, final String password) {
    return null;
  }

  /**
   * Modify a user.
   *
   * @param user user to modify updated with modification.
   * @param password password of the user
   * @return true if password is correct and modification is done without problem, false otherwise.
   */
  @WebMethod
  public Boolean modifyUser(final User user, final String password) {
    return null;
  }

  /**
   * Add a new user.
   *
   * @param user user to add.
   * @param password password for this user to encrypt and add.
   * @return id of the new user added.
   */
  @WebMethod
  public Integer addUser(final User user, final String password) {
    return null;
  }

  /**
   * Add a role to user.
   *
   * @param userId id of the user.
   * @param role role to add to the user.
   * @return true if add is success, false otherwise.
   */
  @WebMethod
  public Boolean addRoleToUser(final Integer userId, final Role role) {
    return null;
  }
}
