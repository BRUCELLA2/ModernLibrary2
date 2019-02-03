package fr.brucella.projects.libraryws.dao.impl.dao.users;

import fr.brucella.projects.libraryws.dao.contracts.dao.users.UserDao;
import fr.brucella.projects.libraryws.dao.impl.dao.AbstractDao;
import fr.brucella.projects.libraryws.dao.impl.rowmapper.users.dto.FullUserDtoRM;
import fr.brucella.projects.libraryws.dao.impl.rowmapper.users.model.RoleRM;
import fr.brucella.projects.libraryws.dao.impl.rowmapper.users.model.UserRM;
import fr.brucella.projects.libraryws.entity.exceptions.NotFoundException;
import fr.brucella.projects.libraryws.entity.exceptions.TechnicalException;
import fr.brucella.projects.libraryws.entity.users.dto.FullUserDto;
import fr.brucella.projects.libraryws.entity.users.model.Role;
import fr.brucella.projects.libraryws.entity.users.model.User;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.PermissionDeniedDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

/**
 * User Data Access Object.
 *
 * @author BRUCELLA2
 */
@Component
public class UserDaoImpl extends AbstractDao implements UserDao {

  /** Author DAO logger. */
  private static final Log LOG = LogFactory.getLog(UserDaoImpl.class);

  // ===== Constructor =====
  /** Default Constructor */
  public UserDaoImpl() {
    super();
  }

  // ===== Methods =====

  /** {@inheritDoc} */
  @Override
  public User getUser(final Integer userId) throws TechnicalException, NotFoundException {

    sql = "SELECT * FROM users WHERE user_id = :userId";

    final MapSqlParameterSource parameterSource = new MapSqlParameterSource();
    parameterSource.addValue("userId", userId);

    final RowMapper<User> rowMapper = new UserRM();

    try {
      return this.getNamedJdbcTemplate().queryForObject(sql, parameterSource, rowMapper);
    } catch (EmptyResultDataAccessException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("userId = " + userId);
      }
      LOG.error(exception.getMessage());
      throw new NotFoundException(messages.getString("UserDao.getUser.notFound"), exception);
    } catch (PermissionDeniedDataAccessException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("permissionDenied"), exception);
    } catch (DataAccessResourceFailureException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("dataAccessResourceFailure"), exception);
    } catch (DataAccessException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("dataAccess"), exception);
    }
  }

  @Override
  public FullUserDto getUserByLogin(final String login)
      throws TechnicalException, NotFoundException {

    sql =
        "SELECT users.user_id, users.password, users.email, users.login, users.phone, users.address_id, users.user_options_id, address.city, address.line1, address.line2, address.line3, address.zip_code, user_options.before_reminder FROM users INNER JOIN address ON users.address_id = address.address_id INNER JOIN user_options ON user_options.user_options_id = users.user_options_id WHERE users.login = :login";

    final MapSqlParameterSource userParameterSource = new MapSqlParameterSource();
    userParameterSource.addValue("login", login);

    final RowMapper<FullUserDto> fullUserDtoRowMapper = new FullUserDtoRM();
    FullUserDto fullUserDto;

    try {
      fullUserDto =
          this.getNamedJdbcTemplate()
              .queryForObject(sql, userParameterSource, fullUserDtoRowMapper);
    } catch (EmptyResultDataAccessException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("login = " + login);
      }
      LOG.error(exception.getMessage());
      throw new NotFoundException(messages.getString("UserDao.getUserByLogin.notFound"), exception);
    } catch (PermissionDeniedDataAccessException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("permissionDenied"), exception);
    } catch (DataAccessResourceFailureException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("dataAccessResourceFailure"), exception);
    } catch (DataAccessException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("dataAccess"), exception);
    }

    // Get roles informations

    sql =
        "SELECT * from user_roles INNER JOIN users ON user_roles.user_id = users.user_id INNER JOIN role ON user_roles.role_id = role.role_id WHERE users.user_id = :userId";

    final MapSqlParameterSource rolesParameterSource = new MapSqlParameterSource();
    rolesParameterSource.addValue("userId", fullUserDto.getUserId());

    final RowMapper<Role> roleRowMapper = new RoleRM();

    try {
      List<Role> rolesList = getNamedJdbcTemplate().query(sql, rolesParameterSource, roleRowMapper);
      if (rolesList.isEmpty()) {
        rolesList = new ArrayList<>();
      }
      fullUserDto.setRoles(rolesList);
    } catch (PermissionDeniedDataAccessException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("permissionDenied"), exception);
    } catch (DataAccessResourceFailureException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("dataAccessResourceFailure"), exception);
    } catch (DataAccessException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("dataAccess"), exception);
    }

    return fullUserDto;
  }

  /** {@inheritDoc} */
  @Override
  public Boolean loginAvailable(String login) throws TechnicalException {

    sql = "SELECT COUNT(login) FROM users WHERE login = :login";

    final MapSqlParameterSource parameterSource = new MapSqlParameterSource();
    parameterSource.addValue("login", login);

    int count = 0;
    try {
      count = getNamedJdbcTemplate().queryForObject(sql, parameterSource, Integer.class);
    } catch (PermissionDeniedDataAccessException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("permissionDenied"), exception);
    } catch (DataAccessResourceFailureException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("dataAccessResourceFailure"), exception);
    } catch (DataAccessException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("dataAccess"), exception);
    }

    return (count == 0);
  }

  /** {@inheritDoc} */
  @Override
  public List<User> getUserWithBorrowsExpired() throws TechnicalException, NotFoundException {

    sql =
        "SELECT users.user_id, users.password, users.email, users.login, users.phone, users.address_id, users.user_options_id FROM users INNER JOIN book_borrowed ON users.user_id = book_borrowed.user_id WHERE book_borrowed.returned = false AND book_borrowed.end_date < CURRENT_DATE GROUP BY users.user_id";

    final RowMapper<User> rowMapper = new UserRM();

    try {
      final List<User> usersList = this.getNamedJdbcTemplate().query(sql, rowMapper);
      if (usersList.isEmpty()) {
        if (LOG.isDebugEnabled()) {
          LOG.debug("SQL : " + sql);
        }
        throw new NotFoundException(
            messages.getString("UserDao.getUserWithBorrowsExpired.notFound"));
      } else {
        return usersList;
      }
    } catch (PermissionDeniedDataAccessException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("permissionDenied"), exception);
    } catch (DataAccessResourceFailureException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("dataAccessResourceFailure"), exception);
    } catch (DataAccessException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("dataAccess"), exception);
    }
  }

  @Override
  public List<User> getUserBeforeReminder(Integer nbDaysBeforeReminder) throws TechnicalException, NotFoundException {

    sql ="SELECT users.user_id, users.password, users.email, users.login, users.phone, users.address_id, users.user_options_id FROM users INNER JOIN book_borrowed ON users.user_id = book_borrowed.user_id INNER JOIN user_options ON users.user_options_id = user_options.user_options_id WHERE book_borrowed.returned = false AND user_options.before_reminder = true AND (book_borrowed.end_date - :nbDaysBeforeReminder -1) < CURRENT_DATE GROUP BY users.user_id";

    final MapSqlParameterSource parameterSource = new MapSqlParameterSource();
    parameterSource.addValue("nbDaysBeforeReminder", nbDaysBeforeReminder);

    final RowMapper<User> rowMapper = new UserRM();

    try {
      final List<User> usersList = this.getNamedJdbcTemplate().query(sql, parameterSource, rowMapper);
      if (usersList.isEmpty()) {
        if (LOG.isDebugEnabled()) {
          LOG.debug("SQL : " + sql);
        }
        throw new NotFoundException(messages.getString("UserDao.getUserBeforeReminder.notFound"));
      } else {
        return usersList;
      }
    } catch (PermissionDeniedDataAccessException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("permissionDenied"), exception);
    } catch (DataAccessResourceFailureException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("dataAccessResourceFailure"), exception);
    } catch (DataAccessException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("dataAccess"), exception);
    }
  }

  /** {@inheritDoc} */
  @Override
  public void updateUser(final User user) throws TechnicalException, NotFoundException {

    sql =
        "UPDATE users SET password = :password, email = :email, login = :login, phone = :phone, address_id = :addressId, user_options_id = :userOptionsId WHERE user_id = :userId";

    final SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(user);

    try {
      final int result = this.getNamedJdbcTemplate().update(sql, parameterSource);
      if (result == 0) {
        if (LOG.isDebugEnabled()) {
          LOG.debug("SQL : " + sql);
          LOG.debug("user = " + user.toString());
        }
        throw new NotFoundException(messages.getString("UserDao.updateUser.notFound"));
      }
    } catch (DataIntegrityViolationException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("user : " + user.toString());
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(
          messages.getString("UserDao.updateUser.integrityViolation"), exception);
    } catch (PermissionDeniedDataAccessException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("permissionDenied"), exception);
    } catch (DataAccessResourceFailureException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("dataAccessResourceFailure"), exception);
    } catch (DataAccessException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("dataAccess"), exception);
    }
  }

  /** {@inheritDoc} */
  @Override
  public int insertUser(final User user) throws TechnicalException {

    sql =
        "INSERT INTO users (user_id, password, email, login, phone, address_id, user_options_id) VALUES (DEFAULT, :password, :email, :login, :phone, :addressId, :userOptionsId)";

    final KeyHolder keyHolder = new GeneratedKeyHolder();
    final SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(user);

    try {
      this.getNamedJdbcTemplate().update(sql, parameterSource, keyHolder, new String[] {"user_id"});
      return keyHolder.getKey().intValue();

    } catch (DuplicateKeyException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("user : " + user.toString());
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("userDao.insertUser.duplicate"), exception);
    } catch (DataIntegrityViolationException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("user : " + user.toString());
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(
          messages.getString("userDao.insertUser.integrityViolation"), exception);
    } catch (PermissionDeniedDataAccessException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("permissionDenied"), exception);
    } catch (DataAccessResourceFailureException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("dataAccessResourceFailure"), exception);
    } catch (DataAccessException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("dataAccess"), exception);
    }
  }

  /** {@inheritDoc} */
  @Override
  public void deleteUser(final Integer userId) throws TechnicalException, NotFoundException {

    sql = "DELETE FROM users WHERE user_id = :userId";

    final MapSqlParameterSource parameterSource = new MapSqlParameterSource();
    parameterSource.addValue("userId", userId);

    try {
      final int result = this.getNamedJdbcTemplate().update(sql, parameterSource);
      if (result == 0) {
        if (LOG.isDebugEnabled()) {
          LOG.debug("SQL : " + sql);
          LOG.debug("userId = " + userId);
        }
        throw new NotFoundException(messages.getString("userDao.deleteUser.notFound"));
      }
    } catch (PermissionDeniedDataAccessException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("permissionDenied"), exception);
    } catch (DataAccessResourceFailureException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("dataAccessResourceFailure"), exception);
    } catch (DataAccessException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("userId = " + userId);
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("dataAccess"), exception);
    }
  }
}
