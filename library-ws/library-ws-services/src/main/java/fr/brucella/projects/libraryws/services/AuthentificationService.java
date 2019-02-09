package fr.brucella.projects.libraryws.services;

import fr.brucella.projects.libraryws.business.contracts.ManagerFactory;
import fr.brucella.projects.libraryws.entity.exceptions.FunctionalException;
import fr.brucella.projects.libraryws.entity.exceptions.LibraryWsException;
import fr.brucella.projects.libraryws.entity.exceptions.LibraryWsFault;
import fr.brucella.projects.libraryws.entity.exceptions.TechnicalException;
import fr.brucella.projects.libraryws.entity.users.dto.FullUserDto;
import javax.jws.WebMethod;
import javax.jws.WebService;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

  /** String message give to user for technical problem in LibraryWsException */
  private static final String TECH_ERROR = "Problème technique";

  /** String message give to user for functional problem in LibraryWsException */
  private static final String FUNC_ERROR = "Erreur fonctionnelle";

  /** Fault Code for server fault */
  private static final String SERVER = "soap:Server";

  /** Fault Code for client fault */
  private static final String CLIENT = "soap:Client";

  // ----- Manager
  /** The Manager Factory Manager Factory allow to get and set business managers. */
  @Autowired private ManagerFactory managerFactory;

  /** Default constructor. */
  public AuthentificationService() {
    // This constructor is intentionally empty.
  }

  // ===== WebMethods ===== //

  /**
   * Check if login and password match and return the full user dto corresponding to this login.
   *
   * @param login login of the user.
   * @param password password of the user.
   * @return the full user dto corresponding to this login if login and password match. Return null
   *     otherwise.
   * @throws LibraryWsException Throw this exception if there is a technical problem or if login or
   *     password is null or if password don't match with the login.
   */
  @WebMethod
  public FullUserDto login(final String login, final String password) throws LibraryWsException {

    if (StringUtils.isEmpty(login) || StringUtils.isEmpty(password)) {
      LOG.error("Login ou password empty");
      throw new LibraryWsException(
          FUNC_ERROR,
          new LibraryWsFault(
              CLIENT, "Le login ou le mot de passe est vide. Connection impossible"));
    }

    try {
      return this.managerFactory.getAuthentificationManager().getConnectUser(login, password);
    } catch (TechnicalException exception) {
      LOG.error(exception.getMessage());
      throw new LibraryWsException(
          TECH_ERROR, exception, new LibraryWsFault(SERVER, exception.getMessage()));
    } catch (FunctionalException exception) {
      LOG.error(exception.getMessage());
      throw new LibraryWsException(
          FUNC_ERROR, exception, new LibraryWsFault(CLIENT, exception.getMessage()));
    }
  }

  /**
   * Modify a user.
   *
   * @param fullUserDto the full user dto with the modification.
   * @return true if password is correct and modification is done without problem, throw exception
   *     if not.
   * @throws LibraryWsException Throw this exception if there is a technical problem. This exception
   *     is throw if the fullUserDto are not valid (null or with invalid data) This exception is
   *     throw if the password don't match with the user password store in the datastore.
   */
  @WebMethod
  public Boolean modifyUser(final FullUserDto fullUserDto) throws LibraryWsException {

    if (fullUserDto == null) {
      LOG.error("fullUserDto null");
      throw new LibraryWsException(
          FUNC_ERROR,
          new LibraryWsFault(
              CLIENT, "L'utilisateur à modifier est vide. La modification n'a pu être faite"));
    }

    try {
      return this.managerFactory.getAuthentificationManager().userModification(fullUserDto);
    } catch (TechnicalException exception) {
      LOG.error(exception.getMessage());
      throw new LibraryWsException(
          TECH_ERROR, exception, new LibraryWsFault(SERVER, exception.getMessage()));
    } catch (FunctionalException exception) {
      LOG.error(exception.getMessage());
      throw new LibraryWsException(
          FUNC_ERROR, exception, new LibraryWsFault(CLIENT, exception.getMessage()));
    }
  }

  /**
   * Add a new user (with new address).
   *
   * @param fullUserDto full user information to add.
   * @return id of the new user added.
   * @throws LibraryWsException Throw this exception if there is a technical problem. This exception
   *     is throw if the fullUserDto are not valid (null or with invalid data)
   */
  @WebMethod
  public Integer addUser(final FullUserDto fullUserDto) throws LibraryWsException {

    if (fullUserDto == null) {
      LOG.error("fullUserDto null");
      throw new LibraryWsException(
          FUNC_ERROR,
          new LibraryWsFault(CLIENT, "L'utilisateur à ajouter est vide. L'ajout n'a pu être fait"));
    }

    try {
      return this.managerFactory.getAuthentificationManager().addNewUser(fullUserDto);
    } catch (TechnicalException exception) {
      LOG.error(exception.getMessage());
      throw new LibraryWsException(
          TECH_ERROR, exception, new LibraryWsFault(SERVER, exception.getMessage()));
    } catch (FunctionalException exception) {
      LOG.error(exception.getMessage());
      throw new LibraryWsException(
          FUNC_ERROR, exception, new LibraryWsFault(CLIENT, exception.getMessage()));
    }
  }

  /**
   * Add a role to user.
   *
   * @param userId id of the user.
   * @param roleId id of the role to add to the user.
   * @return true if add is success.
   * @throws LibraryWsException Throw this exception if there is a technical problem. This exception
   *     is throw if the role or the user is not found. This exception is throw if the role id or
   *     the user id is null.
   */
  @WebMethod
  public Boolean addRoleToUser(final Integer userId, final Integer roleId)
      throws LibraryWsException {

    if (userId == null) {
      LOG.error(
          "L'identifiant de l'utilisateur est incorrect (identifiant null) - Echec de l'ajout du role à l'utilisateur");
      throw new LibraryWsException(
          FUNC_ERROR,
          new LibraryWsFault(
              CLIENT,
              "L'identifiant de l'utilisateur est incorrect (identifiant null) - Echec de l'ajout du role à l'utilisateur"));
    }

    if (roleId == null) {
      LOG.error(
          "L'identifiant du role est incorrect (role null) - Echec de l'ajout du role à l'utilisateur");
      throw new LibraryWsException(
          FUNC_ERROR,
          new LibraryWsFault(
              CLIENT,
              "L'identifiant du role est incorrect (role null) - Echec de l'ajout du role à l'utilisateur"));
    }

    try {
      return this.managerFactory.getAuthentificationManager().giveRole(userId, roleId);
    } catch (TechnicalException exception) {
      LOG.error(exception.getMessage());
      throw new LibraryWsException(
          TECH_ERROR, exception, new LibraryWsFault(SERVER, exception.getMessage()));
    } catch (FunctionalException exception) {
      LOG.error(exception.getMessage());
      throw new LibraryWsException(
          FUNC_ERROR, exception, new LibraryWsFault(CLIENT, exception.getMessage()));
    }
  }

  /**
   * Check if the login is available. Return true if login can be used, false is the login is
   * already used.
   *
   * @param login login wanted for the user.
   * @return true if the login can be used, false is the login is already used.
   * @throws LibraryWsException Throw this exception if there is a technical problem. This exception
   *     is throw if the login is null.
   */
  @WebMethod
  public Boolean loginAvailable(final String login) throws LibraryWsException {

    if (StringUtils.isEmpty(login)) {
      LOG.error("Le login est vide, la vérification du login est donc impossible.");
      throw new LibraryWsException(
          FUNC_ERROR,
          new LibraryWsFault(
              CLIENT, "Le login est incorrect (login null) - Echec de la vérification"));
    }

    try {
      return this.managerFactory.getAuthentificationManager().checkLoginAvailability(login);
    } catch (TechnicalException exception) {
      LOG.error(exception.getMessage());
      throw new LibraryWsException(
          TECH_ERROR, exception, new LibraryWsFault(SERVER, exception.getMessage()));
    } catch (FunctionalException exception) {
      LOG.error(exception.getMessage());
      throw new LibraryWsException(
          FUNC_ERROR, exception, new LibraryWsFault(CLIENT, exception.getMessage()));
    }
  }
}
