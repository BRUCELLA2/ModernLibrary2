package fr.brucella.projects.libraryclients.webapp.actions.users;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import generated.authentificationserviceclient.AuthentificationService;
import generated.authentificationserviceclient.AuthentificationService_Service;
import generated.authentificationserviceclient.FullUserDto;
import generated.authentificationserviceclient.LibraryWsException;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;


public class UserAction extends ActionSupport implements SessionAware, ServletRequestAware {

  // ----- Logger
  /**
   * User Action logger
   */
  private static final Log LOG = LogFactory.getLog(UserAction.class);

  // ----- Input
  /**
   * Login of the user. Can't be empty and max size is 30 characters.
   */
  private String userLogin;

  /**
   * Password of the user. Can't be empty and max size is 100 characters.
   */
  private String userPass;

  /**
   * the user's HTTP session attributes.
   */
  private Map<String, Object> session;

  /**
   * The Http Servlet Request. Used to get session informations.
   */
  private HttpServletRequest servletRequest;

  // ----- Getters and Setters

  /**
   * Give the login of the user. Can't be empty and max size is 30 characters.
   *
   * @return the login of the user.
   */
  public String getUserLogin() {
    return userLogin;
  }

  /**
   * Set the login of the user. Can't be empty and max size is 30 characters.
   *
   * @param userLogin
   *     the login of the user.
   */
  public void setUserLogin(final String userLogin) {
    this.userLogin = userLogin;
  }

  /**
   * Give the user password. Can't be empty and max size is 100 characters.
   *
   * @return the password of the user.
   */
  public String getUserPass() {
    return userPass;
  }

  /**
   * Set the user password. Can't be empty and max size is 100 characters.
   *
   * @param userPass
   *     the password of the user.
   */
  public void setUserPass(final String userPass) {
    this.userPass = userPass;
  }

  /**
   *
   *
   * @param request
   */
  @Override
  public void setServletRequest(final HttpServletRequest request) {
    this.servletRequest = request;
  }

  /**
   * Set the user's HTTP session attributes.
   */
  @Override
  public void setSession(final Map<String, Object> session) {
    this.session = session;
  }

  // ===== Methods =====

  /**
   * Log a user. After login, user is add to session.
   *
   * @return ERROR if error occurred INPUT if the login, password are null or empty. if the login and *         password
   * don't match. SUCCESS otherwise.
   */
  public String doLogin() {

    if (StringUtils.isAllEmpty(this.userLogin, this.userPass)) {
      return Action.INPUT;
    }

    if (StringUtils.isEmpty(this.userLogin)) {
      this.addFieldError("userLogin", "L'identifiant doit être renseigné");
    }

    if (StringUtils.isEmpty(this.userPass)) {
      this.addFieldError("userPass", "Le mot de passe doit être renseigné");
    }

    if (this.hasActionErrors()) {
      return Action.INPUT;
    }

    AuthentificationService_Service authentificationService = new AuthentificationService_Service();
    AuthentificationService authentificationServicePort = authentificationService.getAuthentificationServicePort();

    try {
      FullUserDto user = authentificationServicePort.login(userLogin, userPass);
      if (user == null) {
        this.addFieldError("userLogin",
            "L'identifiant et/ou le mot de passe sont incorrects - La connexion n'a pu être réalisée");
        this.addFieldError("userPass",
            "L'identifiant et/ou le mot de passe sont incorrects - La connexion n'a pu être réalisée");
        return Action.INPUT;
      } else {
        this.session.put("userLog", user);
      }
    } catch (LibraryWsException exception) {
      LOG.error(exception.getMessage());
      LOG.error(exception.getFaultInfo().getFaultString());
      this.addActionError(exception.getMessage());
      return Action.ERROR;
    }

    return Action.SUCCESS;
  }


  public String doLogout() {
    this.servletRequest.getSession().invalidate();
    ;
    return Action.SUCCESS;
  }
}
