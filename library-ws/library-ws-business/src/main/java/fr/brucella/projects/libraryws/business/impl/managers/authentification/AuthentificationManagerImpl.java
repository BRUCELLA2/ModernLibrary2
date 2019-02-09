package fr.brucella.projects.libraryws.business.impl.managers.authentification;

import fr.brucella.projects.libraryws.business.contracts.managers.authentification.AuthentificationManager;
import fr.brucella.projects.libraryws.business.impl.managers.AbstractManager;
import fr.brucella.projects.libraryws.entity.exceptions.FunctionalException;
import fr.brucella.projects.libraryws.entity.exceptions.NotFoundException;
import fr.brucella.projects.libraryws.entity.exceptions.TechnicalException;
import fr.brucella.projects.libraryws.entity.users.dto.FullUserDto;
import fr.brucella.projects.libraryws.entity.users.model.Address;
import fr.brucella.projects.libraryws.entity.users.model.User;
import fr.brucella.projects.libraryws.entity.users.model.UserOptions;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * The Authentification Manager.
 *
 * @author BRUCELLA2
 */
@Component
public class AuthentificationManagerImpl extends AbstractManager
    implements AuthentificationManager {

  /** Authentification Manager Logger. */
  private static final Log LOG = LogFactory.getLog(AuthentificationManagerImpl.class);

  /** Password encoder. */
  private final transient BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

  /** Default Constructor. */
  public AuthentificationManagerImpl() {
    super();
  }

  /** {@inheritDoc} */
  @Override
  public FullUserDto getConnectUser(final String login, final String password)
      throws TechnicalException, FunctionalException {

    if (StringUtils.isEmpty(login) || StringUtils.isEmpty(password)) {
      LOG.error(messages.getString("authentificationManager.getConnectUser.loginPasswordNull"));
      throw new FunctionalException(
          messages.getString("authentificationManager.getConnectUser.loginPasswordNull"));
    }
    FullUserDto user = null;
    try {
      user = this.getDaoFactory().getUserDao().getUserByLogin(login);
      if (this.NotCheckedPassword(password, user.getPassword())) {
        if (LOG.isDebugEnabled()) {
          LOG.debug("login : " + login);
          LOG.debug("password = wrong");
        }
        throw new FunctionalException(
            messages.getString("authentificationManager.getConnectUser.passDontMatch"));
      }
    } catch (NotFoundException exception) {
      LOG.error(exception.getMessage());
    }

    return user;
  }

  /** {@inheritDoc} */
  @Override
  public Boolean userModification(final FullUserDto fullUserDto)
      throws TechnicalException, FunctionalException {

    if (fullUserDto == null) {
      LOG.error(messages.getString("authentificationManager.userModification.fullUserDtoNull"));
      throw new FunctionalException(
          messages.getString("authentificationManager.userModification.fullUserDtoNull"));
    }

    final Set<ConstraintViolation<FullUserDto>> violations =
        this.getConstraintValidator().validate(fullUserDto);
    if (!violations.isEmpty()) {
      if (LOG.isDebugEnabled()) {
        for (final ConstraintViolation<FullUserDto> violation : violations) {
          LOG.debug(violation.getMessage());
        }
      }
      LOG.error(messages.getString("authentificationManager.userModification.constraints"));
      throw new FunctionalException(
          messages.getString("authentificationManager.userModification.constraints"),
          new ConstraintViolationException(violations));
    }

    try {
      final User oldUser = this.getDaoFactory().getUserDao().getUser(fullUserDto.getUserId());

      if (this.NotCheckedPassword(fullUserDto.getPassword(), oldUser.getPassword())) {
        LOG.error("password wrong");
        throw new FunctionalException(
            messages.getString("authentificationManager.userModification.passDontMatch"));
      }

      final Address modifyAddress = new Address();
      modifyAddress.setAddressId(fullUserDto.getAddressId());
      modifyAddress.setCity(fullUserDto.getCity());
      modifyAddress.setLine1(fullUserDto.getLine1());
      modifyAddress.setLine2(fullUserDto.getLine2());
      modifyAddress.setLine3(fullUserDto.getLine3());
      modifyAddress.setZipCode(fullUserDto.getZipCode());

      this.getDaoFactory().getAddressDao().updateAddress(modifyAddress);

      final UserOptions modifyUserOptions = new UserOptions();
      modifyUserOptions.setUserOptionsId(fullUserDto.getUserOptionsId());
      modifyUserOptions.setBeforeReminder(fullUserDto.getBeforeReminder());

      this.getDaoFactory().getUserOptionsDao().updateUserOptions(modifyUserOptions);

      final User modifyUser = new User();
      modifyUser.setUserId(fullUserDto.getUserId());
      modifyUser.setPassword(this.encodePassword(fullUserDto.getPassword()));
      modifyUser.setPhone(fullUserDto.getPhone());
      modifyUser.setLogin(fullUserDto.getLogin());
      modifyUser.setAddressId(fullUserDto.getAddressId());
      modifyUser.setEmail(fullUserDto.getEmail());
      modifyUser.setUserOptionsId(modifyUserOptions.getUserOptionsId());

      this.getDaoFactory().getUserDao().updateUser(modifyUser);

    } catch (NotFoundException exception) {
      LOG.error(exception.getMessage());
      throw new FunctionalException(exception.getMessage(), exception);
    }

    return true;
  }

  /** {@inheritDoc} */
  @Override
  public Integer addNewUser(final FullUserDto fullUserDto)
      throws TechnicalException, FunctionalException {

    if (fullUserDto == null) {
      LOG.error(messages.getString("authentificationManager.userModification.fullUserDtoNull"));
      throw new FunctionalException(
          messages.getString("authentificationManager.userModification.fullUserDtoNull"));
    }

    final Address newAddress = new Address();
    newAddress.setAddressId(fullUserDto.getAddressId());
    newAddress.setCity(fullUserDto.getCity());
    newAddress.setLine1(fullUserDto.getLine1());
    newAddress.setLine2(fullUserDto.getLine2());
    newAddress.setLine3(fullUserDto.getLine3());
    newAddress.setZipCode(fullUserDto.getZipCode());

    final Set<ConstraintViolation<Address>> addressViolations =
        this.getConstraintValidator().validate(newAddress);
    if (!addressViolations.isEmpty()) {
      if (LOG.isDebugEnabled()) {
        for (final ConstraintViolation<Address> violation : addressViolations) {
          LOG.debug(violation.getMessage());
        }
      }
      LOG.error(messages.getString("authentificationManager.addNewUser.addressConstraints"));
      throw new FunctionalException(
          messages.getString("authentificationManager.addNewUser.addressConstraints"),
          new ConstraintViolationException(addressViolations));
    }

    final Integer addressId = this.getDaoFactory().getAddressDao().insertAddress(newAddress);
    newAddress.setAddressId(addressId);

    final UserOptions newUserOptions = new UserOptions();
    newUserOptions.setBeforeReminder(fullUserDto.getBeforeReminder());

    final Set<ConstraintViolation<UserOptions>> userOptionsViolations =
        this.getConstraintValidator().validate(newUserOptions);
    if (!userOptionsViolations.isEmpty()) {
      if (LOG.isDebugEnabled()) {
        for (final ConstraintViolation<UserOptions> violation : userOptionsViolations) {
          LOG.debug(violation.getMessage());
        }
      }
      LOG.error(messages.getString("authentificationManager.addNewUser.userOptionsConstraints"));
      throw new FunctionalException(
          messages.getString("authentificationManager.addNewUser.userOptionsConstraints"),
          new ConstraintViolationException(userOptionsViolations));
    }

    final Integer userOptionsId =
        this.getDaoFactory().getUserOptionsDao().insertUserOptions(newUserOptions);
    newUserOptions.setUserOptionsId(userOptionsId);

    final User newUser = new User();
    newUser.setUserId(fullUserDto.getUserId());
    newUser.setPassword(this.encodePassword(fullUserDto.getPassword()));
    newUser.setPhone(fullUserDto.getPhone());
    newUser.setLogin(fullUserDto.getLogin());
    newUser.setAddressId(newAddress.getAddressId());
    newUser.setEmail(fullUserDto.getEmail());
    newUser.setUserOptionsId(newUserOptions.getUserOptionsId());

    final Set<ConstraintViolation<User>> userViolations =
        this.getConstraintValidator().validate(newUser);
    if (!userViolations.isEmpty()) {
      if (LOG.isDebugEnabled()) {
        for (final ConstraintViolation<User> violation : userViolations) {
          LOG.debug(violation.getMessage());
        }
      }
      LOG.error(messages.getString("authentificationManager.addNewUser.userConstraints"));
      try {
        this.getDaoFactory().getAddressDao().deleteAddress(addressId);
        this.getDaoFactory().getUserOptionsDao().deleteUserOptions(userOptionsId);
      } catch (NotFoundException exception) {
        LOG.error(exception.getMessage());
      }
      throw new FunctionalException(
          messages.getString("authentificationManager.addNewUser.userConstraints"),
          new ConstraintViolationException(userViolations));
    }

    return this.getDaoFactory().getUserDao().insertUser(newUser);
  }

  /** {@inheritDoc} */
  @Override
  public Boolean giveRole(final Integer userId, final Integer roleId)
      throws TechnicalException, FunctionalException {

    if (userId == null) {
      LOG.error(messages.getString("authentificationManager.giveRole.userIdNull"));
      throw new FunctionalException(
          messages.getString("authentificationManager.giveRole.userIdNull"));
    }
    if (roleId == null) {
      LOG.error(messages.getString("authentificationManager.giveRole.roleIdNull"));
      throw new FunctionalException(
          messages.getString("authentificationManager.giveRole.roleIdNull"));
    }

    this.getDaoFactory().getRoleDao().insertUserRole(userId, roleId);

    return true;
  }

  /** {@inheritDoc} */
  @Override
  public Boolean checkLoginAvailability(final String login)
      throws TechnicalException, FunctionalException {

    if (StringUtils.isEmpty(login)) {
      LOG.error(messages.getString("authentificationManager.checkLoginAvailability.loginNull"));
      throw new FunctionalException(
          messages.getString("authentificationManager.checkLoginAvailability.loginNull"));
    }

    return this.getDaoFactory().getUserDao().loginAvailable(login);
  }

  /**
   * This method encrypte a raw password with the password encoder {@link #passwordEncoder}.
   *
   * @param rawPassword the raw password to encrypt
   * @return the password encrypted
   */
  private String encodePassword(final String rawPassword) {

    return this.passwordEncoder.encode(rawPassword);
  }

  /**
   * This method check if a raw password is the same than the encrypted password. This method use
   * the password encoder {@link #passwordEncoder}
   *
   * @param rawPassword The raw password
   * @param encodePassword the encrypted password
   * @return false if the raw password and the encrypted password match, true otherwise.
   */
  private boolean NotCheckedPassword(final String rawPassword, final String encodePassword) {

    return !this.passwordEncoder.matches(rawPassword, encodePassword);
  }
}
