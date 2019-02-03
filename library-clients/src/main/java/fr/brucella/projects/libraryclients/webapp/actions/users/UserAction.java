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
   * Login of the user. Max size is 30 characters.
   */
  private String userLogin;

  /**
   * Password of the user. Max size is 100 characters.
   */
  private String userPass;

  /**
   * the user password confirmation. Max size is 100 characters.
   */
  private String userPassConf;

  /**
   * Email of the user. Max size is 100 characters.
   */
  private String userEmail;

  /**
   * Phone number of the user. Size need to be 10 characters.
   */
  private String userPhone;

  /**
   * City of the user. Max size is 100 characters.
   */
  private String userCity;

  /**
   * Line 1 of the address of the user. Max size is 200 characters.
   */
  private String userLine1;

  /**
   * Line 2 of the address of the user. Max size is 200 characters.
   */
  private String userLine2;

  /**
   * Line 3 of the address of the user. Max size is 200 characters.
   */
  private String userLine3;

  /**
   * Zip code of the address of the user. Size is 5 characters.
   */
  private String userZipCode;

  /**
   * String indicating if the option "before reminder" is active. "true" or "false".
   */
  private String beforeReminder;

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
   * Give the login of the user. Max size is 30 characters.
   *
   * @return the login of the user.
   */
  public String getUserLogin() {
    return userLogin;
  }

  /**
   * Set the login of the user. Max size is 30 characters.
   *
   * @param userLogin
   *     the login of the user.
   */
  public void setUserLogin(final String userLogin) {
    this.userLogin = userLogin;
  }

  /**
   * Give the user password. Max size is 100 characters.
   *
   * @return the password of the user.
   */
  public String getUserPass() {
    return userPass;
  }

  /**
   * Set the user password. Max size is 100 characters.
   *
   * @param userPass
   *     the password of the user.
   */
  public void setUserPass(final String userPass) {
    this.userPass = userPass;
  }

  /**
   * Give the user password confirmation. Max size is 100 characters.
   *
   * @return the user password confirmation. Max size is 100 characters.
   */
  public String getUserPassConf() {
    return userPassConf;
  }


  /**
   * Set the user password confirmation. Max size is 100 characters.
   *
   * @param userPassConf
   *     the user password confirmation. Max size is 100 characters.
   */
  public void setUserPassConf(String userPassConf) {
    this.userPassConf = userPassConf;
  }

  /**
   * Give the user email. Max size is 100 characters.
   *
   * @return the user email.
   */
  public String getUserEmail() {
    return userEmail;
  }

  /**
   * Set the user email. Max size is 100 characters.
   *
   * @param userEmail
   *     the user email.
   */
  public void setUserEmail(final String userEmail) {
    this.userEmail = userEmail;
  }

  /**
   * Give the phone number of the user. Size need to be 10 characters.
   *
   * @return the phone number of the user.
   */
  public String getUserPhone() {
    return userPhone;
  }

  /**
   * Set the phone number of the user. Size need to be 10 characters.
   *
   * @param userPhone
   *     the phone number of the user.
   */
  public void setUserPhone(final String userPhone) {
    this.userPhone = userPhone;
  }

  /**
   * Give the city of the user. Max size is 100 characters.
   *
   * @return the city of the user.
   */
  public String getUserCity() {
    return userCity;
  }

  /**
   * Set the city of the user. Max size is 100 characters.
   *
   * @param userCity
   *     the city of the user.
   */
  public void setUserCity(final String userCity) {
    this.userCity = userCity;
  }

  /**
   * Give the line 1 of the address of the user. Max size is 200 characters.
   *
   * @return the line 1 of the address of the user.
   */
  public String getUserLine1() {
    return userLine1;
  }

  /**
   * Set the line 1 of the address of the user. Max size is 200 characters.
   *
   * @param userLine1
   *     the line 1 of the address of the user.
   */
  public void setUserLine1(final String userLine1) {
    this.userLine1 = userLine1;
  }

  /**
   * Give the line 2 of the address of the user. Max size is 200 characters.
   *
   * @return the line 2 of the address of the user. Max size is 200 characters.
   */
  public String getUserLine2() {
    return userLine2;
  }

  /**
   * Set the line 2 of the address of the user. Max size is 200 characters.
   *
   * @param userLine2
   *     the line 2 of the address of the user. Max size is 200 characters.
   */
  public void setUserLine2(final String userLine2) {
    this.userLine2 = userLine2;
  }

  /**
   * Give the line 3 of the address of the user. Max size is 200 characters.
   *
   * @return the line 3 of the address of the user. Max size is 200 characters.
   */
  public String getUserLine3() {
    return userLine3;
  }

  /**
   * Set the line 3 of the address of the user. Max size is 200 characters.
   *
   * @param userLine3
   *     the line 3 of the address of the user. Max size is 200 characters.
   */
  public void setUserLine3(final String userLine3) {
    this.userLine3 = userLine3;
  }

  /**
   * Give the zip code of the address of the user. Size is 5 characters.
   *
   * @return the zip code of the address of the user. Size is 5 characters.
   */
  public String getUserZipCode() {
    return userZipCode;
  }

  /**
   * Set the zip code of the address of the user. Size is 5 characters.
   */
  public void setUserZipCode(final String userZipCode) {
    this.userZipCode = userZipCode;
  }

  /**
   * Indicate if the option "before reminder" is active. "true" or "false".
   *
   * @return the string "true" if the option "before reminder" is active, "false" otherwise.
   */
  public String getBeforeReminder() {
    return beforeReminder;
  }

  /**
   * Indicate if the option "before reminder" is active. "true" or "false".
   *
   * @param beforeReminder the string "true" if the option "before reminder" is active, "false" otherwise.
   */
  public void setBeforeReminder(final String beforeReminder) {
    this.beforeReminder = beforeReminder;
  }

  /**
   * Set the Http Servlet Request.
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

    if (this.hasFieldErrors()) {
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
      this.addActionError(exception.getFaultInfo().getFaultString());
      return Action.ERROR;
    }

    return Action.SUCCESS;
  }


  /**
   * Log out the user. Session is invalidate.
   *
   * @return SUCCESS
   */
  public String doLogout() {
    this.servletRequest.getSession().invalidate();
    ;
    return Action.SUCCESS;
  }

  /**
   * Register a user. After registration, user is add to session.
   *
   * @return ERROR if error occurred INPUT if the input information needed are empty or null if login is already used by
   * another user. SUCCESS otherwise
   */
  public String doRegister() {

    if (StringUtils
        .isAllEmpty(this.userLogin, this.userCity, this.userEmail, this.userLine1, this.userLine2, this.userLine3,
            this.userPass, this.userPassConf, this.userPhone, this.userZipCode, this.beforeReminder)) {
      return Action.INPUT;
    }

    if (StringUtils.isEmpty(this.userLogin)) {
      this.addFieldError("userLogin", "L'identifiant doit être renseigné");
    }

    if (StringUtils.isEmpty(this.userPass)) {
      this.addFieldError("userPass", "Le mot de passe doit être renseigné");
    }

    if (StringUtils.isEmpty(this.userPassConf)) {
      this.addFieldError("userPassConf", "La confirmation du mot de passe doit être renseignée");
    }

    if (StringUtils.isEmpty(this.userEmail)) {
      this.addFieldError("userEmail", "L'email doit être renseigné");
    }

    if (StringUtils.isEmpty(this.userPhone)) {
      this.addFieldError("userPhone", "Le numéro de téléphone doit être renseigné");
    }

    if (StringUtils.isEmpty(this.userCity)) {
      this.addFieldError("userCity", "La ville doit être renseignée");
    }

    if (StringUtils.isEmpty(this.userLine1)) {
      this.addFieldError("userLine1", "La première ligne de l'adresse doit être renseignée");
    }

    if (StringUtils.isEmpty(this.userZipCode)) {
      this.addFieldError("userZipCode", "Le code postal doit être renseigné");
    }

    if (!StringUtils.equals(this.userPass, this.userPassConf)) {
      this.addFieldError("userPassConf", "la confirmation du mot de passe ne correspond pas au mot de passe");
    }

    if (this.hasFieldErrors()) {
      return Action.INPUT;
    }

    FullUserDto fullUserDto = new FullUserDto();
    fullUserDto.setCity(this.userCity);
    fullUserDto.setLine1(this.userLine1);
    fullUserDto.setLine2(this.userLine2);
    fullUserDto.setLine3(this.userLine3);
    fullUserDto.setZipCode(this.userZipCode);
    fullUserDto.setEmail(this.userEmail);
    fullUserDto.setLogin(this.userLogin);
    fullUserDto.setPassword(this.userPass);
    fullUserDto.setPhone(this.userPhone);
    if (StringUtils.equals(this.beforeReminder, "true")) {
      fullUserDto.setBeforeReminder(true);
    } else {
      fullUserDto.setBeforeReminder(false);
    }

    AuthentificationService_Service authentificationService = new AuthentificationService_Service();
    AuthentificationService authentificationServicePort = authentificationService.getAuthentificationServicePort();

    try {
      Integer userId = authentificationServicePort.addUser(fullUserDto);
    } catch (LibraryWsException exception) {
      LOG.error(exception.getMessage());
      LOG.error(exception.getFaultInfo().getFaultString());
      this.addActionError(exception.getFaultInfo().getFaultString());
      return Action.ERROR;
    }

    return Action.SUCCESS;
  }


  public String doModification() {

    FullUserDto fullUserDto = (FullUserDto) this.session.get("userLog");

    if (StringUtils
        .isAllEmpty(this.userCity, this.userEmail, this.userLine1, this.userLine2, this.userLine3, this.userPass,
            this.userPassConf, this.userPhone, this.userZipCode, this.beforeReminder)) {

      this.userCity = fullUserDto.getCity();
      this.userLine1 = fullUserDto.getLine1();
      this.userLine2 = fullUserDto.getLine2();
      this.userLine3 = fullUserDto.getLine3();
      this.userZipCode = fullUserDto.getZipCode();
      this.userPhone = fullUserDto.getPhone();
      this.userEmail = fullUserDto.getEmail();
      if(fullUserDto.isBeforeReminder()) {
        this.beforeReminder = "true";
      } else {
        this.beforeReminder = "false";
      }

    }

    if (StringUtils.isEmpty(this.userPass)) {
      this.addFieldError("userPass", "Le mot de passe doit être renseigné");
    }

    if (StringUtils.isEmpty(this.userPassConf)) {
      this.addFieldError("userPassConf", "La confirmation du mot de passe doit être renseignée");
    }

    if (StringUtils.isEmpty(this.userEmail)) {
      this.addFieldError("userEmail", "L'email doit être renseigné");
    }

    if (StringUtils.isEmpty(this.userPhone)) {
      this.addFieldError("userPhone", "Le numéro de téléphone doit être renseigné");
    }

    if (StringUtils.isEmpty(this.userCity)) {
      this.addFieldError("userCity", "La ville doit être renseignée");
    }

    if (StringUtils.isEmpty(this.userLine1)) {
      this.addFieldError("userLine1", "La première ligne de l'adresse doit être renseignée");
    }

    if (StringUtils.isEmpty(this.userZipCode)) {
      this.addFieldError("userZipCode", "Le code postal doit être renseigné");
    }

    if (!StringUtils.equals(this.userPass, this.userPassConf)) {
      this.addFieldError("userPassConf", "la confirmation du mot de passe ne correspond pas au mot de passe");
    }

    if (this.hasFieldErrors()) {
      return Action.INPUT;
    }

    fullUserDto.setCity(this.userCity);
    fullUserDto.setLine1(this.userLine1);
    fullUserDto.setLine2(this.userLine2);
    fullUserDto.setLine3(this.userLine3);
    fullUserDto.setZipCode(this.userZipCode);
    fullUserDto.setEmail(this.userEmail);
    fullUserDto.setPassword(this.userPass);
    fullUserDto.setPhone(this.userPhone);
    LOG.error("**** before : " + this.beforeReminder);
    if (StringUtils.equals(this.beforeReminder, "true")) {
      fullUserDto.setBeforeReminder(true);
    } else {
      fullUserDto.setBeforeReminder(false);
    }

    AuthentificationService_Service authentificationService = new AuthentificationService_Service();
    AuthentificationService authentificationServicePort = authentificationService.getAuthentificationServicePort();

    try {
      authentificationServicePort.modifyUser(fullUserDto);
    } catch (LibraryWsException exception) {
      LOG.error(exception.getMessage());
      LOG.error(exception.getFaultInfo().getFaultString());
      this.addActionError(exception.getFaultInfo().getFaultString());
      return Action.ERROR;
    }

    return Action.SUCCESS;
  }
}
