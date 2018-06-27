package fr.brucella.projects.libraryws.services.authentification;

import fr.brucella.projects.libraryws.entity.users.Role;
import fr.brucella.projects.libraryws.entity.users.User;
import javax.jws.WebMethod;
import javax.jws.WebService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Authentification Management Service.
 *
 * @author BRUCELLA2
 */
@WebService(serviceName = "AuthentificationManagementService")
public class AuthentificationManagement {

  /**
   * Authentification Management logger.
   */
  private static final Log LOG = LogFactory.getLog(AuthentificationManagement.class);


  /**
   * Check if login and password match and return the user corresponding to this login.
   *
   * @param login login of the user.
   * @param password password of the user.
   * @return the user corresponding to this login if login and password match. Return null otherwise.
   */
  @WebMethod
  public User login(String login, String password) {
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
  public Boolean modifyUser(User user, String password) {
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
  public Integer addUser(User user, String password){
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
  public Boolean addRoleToUser(Integer userId, Role role) {
    return null;
  }
}
