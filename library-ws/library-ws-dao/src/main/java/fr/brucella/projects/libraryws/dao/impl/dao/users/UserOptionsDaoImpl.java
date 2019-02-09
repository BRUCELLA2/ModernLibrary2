package fr.brucella.projects.libraryws.dao.impl.dao.users;

import fr.brucella.projects.libraryws.dao.contracts.dao.users.UserOptionsDao;
import fr.brucella.projects.libraryws.dao.impl.dao.AbstractDao;
import fr.brucella.projects.libraryws.dao.impl.rowmapper.users.model.UserOptionsRM;
import fr.brucella.projects.libraryws.entity.exceptions.NotFoundException;
import fr.brucella.projects.libraryws.entity.exceptions.TechnicalException;
import fr.brucella.projects.libraryws.entity.users.model.UserOptions;
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
 * UserOptions Data Access Object.
 *
 * @author BRUCELLA2
 */
@Component
public class UserOptionsDaoImpl extends AbstractDao implements UserOptionsDao {

  /** UserOptions DAO logger. */
  private static final Log LOG = LogFactory.getLog(UserOptionsDaoImpl.class);

  // ===== Constructor =====

  /** Default Constructor */
  public UserOptionsDaoImpl() {
    super();
  }

  // ===== Methods =====

  /** {@inheritDoc} */
  @Override
  public UserOptions getUserOptions(final Integer userOptionsId)
      throws TechnicalException, NotFoundException {

    sql = "SELECT * FROM user_options WHERE user_options_id = :userOptionsId";

    final MapSqlParameterSource parameterSource = new MapSqlParameterSource();
    parameterSource.addValue("userOptionsId", userOptionsId);

    final RowMapper<UserOptions> rowMapper = new UserOptionsRM();

    try {
      return this.getNamedJdbcTemplate().queryForObject(sql, parameterSource, rowMapper);
    } catch (EmptyResultDataAccessException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("userOptionsId = " + userOptionsId);
      }
      LOG.error(exception.getMessage());
      throw new NotFoundException(
          messages.getString("UserOptionsDao.getUserOptions.notFound"), exception);
    } catch (PermissionDeniedDataAccessException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString(PERMISSION_DENIED), exception);
    } catch (DataAccessResourceFailureException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString(DATA_ACCESS_RESOURCE_FAILURE), exception);
    } catch (DataAccessException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug(("userOptionsId = " + userOptionsId));
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString(DATA_ACCESS), exception);
    }
  }

  /** {@inheritDoc} */
  @Override
  public void updateUserOptions(final UserOptions userOptions)
      throws TechnicalException, NotFoundException {

    sql =
        "UPDATE user_options SET before_reminder = :beforeReminder WHERE user_options_id = :userOptionsId";

    final SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(userOptions);

    try {
      final int result = this.getNamedJdbcTemplate().update(sql, parameterSource);
      if (result == 0) {
        if (LOG.isDebugEnabled()) {
          LOG.debug("SQL : " + sql);
          LOG.debug("userOptions = " + userOptions.toString());
        }
        throw new NotFoundException(
            messages.getString("UserOptionsDao.updateUserOptions.notFound"));
      }
    } catch (DataIntegrityViolationException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("userOptions : " + userOptions.toString());
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(
          messages.getString("UserOptionsDao.updateUserOptions.integrityViolation"), exception);
    } catch (PermissionDeniedDataAccessException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString(PERMISSION_DENIED), exception);
    } catch (DataAccessResourceFailureException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString(DATA_ACCESS_RESOURCE_FAILURE), exception);
    } catch (DataAccessException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("userOptions = " + userOptions.toString());
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString(DATA_ACCESS), exception);
    }
  }

  /** {@inheritDoc} */
  @Override
  public int insertUserOptions(final UserOptions userOptions) throws TechnicalException {
    sql =
        "INSERT INTO user_options (user_options_id, before_reminder) VALUES (DEFAULT, :beforeReminder)";

    final KeyHolder keyHolder = new GeneratedKeyHolder();
    final SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(userOptions);

    try {
      this.getNamedJdbcTemplate()
          .update(sql, parameterSource, keyHolder, new String[] {"user_options_id"});
      return keyHolder.getKey().intValue();
    } catch (DuplicateKeyException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("userOptions : " + userOptions.toString());
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(
          messages.getString("UserOptionsDao.insertUserOptions.duplicate"), exception);
    } catch (DataIntegrityViolationException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("userOptions : " + userOptions.toString());
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(
          messages.getString("UserOptionsDao.insertUserOptions.integrityViolation"), exception);
    } catch (PermissionDeniedDataAccessException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString(PERMISSION_DENIED), exception);
    } catch (DataAccessResourceFailureException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString(DATA_ACCESS_RESOURCE_FAILURE), exception);
    } catch (DataAccessException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("userOptions = " + userOptions.toString());
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString(DATA_ACCESS), exception);
    }
  }

  /** {@inheritDoc} */
  @Override
  public void deleteUserOptions(final Integer userOptionsId)
      throws TechnicalException, NotFoundException {

    sql = "DELETE FROM user_options WHERE user_options_id = :userOptionsId";

    final MapSqlParameterSource parameterSource = new MapSqlParameterSource();
    parameterSource.addValue("userOptionsId", userOptionsId);

    try {
      final int result = this.getNamedJdbcTemplate().update(sql, parameterSource);
      if (result == 0) {
        if (LOG.isDebugEnabled()) {
          LOG.debug("SQL : " + sql);
          LOG.debug("userOptionsId = " + userOptionsId);
        }
        throw new NotFoundException(
            messages.getString("UserOptionsDao.deleteUserOptions.notFound"));
      }
    } catch (PermissionDeniedDataAccessException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString(PERMISSION_DENIED), exception);
    } catch (DataAccessResourceFailureException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString(DATA_ACCESS_RESOURCE_FAILURE), exception);
    } catch (DataAccessException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("userOptionsId = " + userOptionsId);
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString(DATA_ACCESS), exception);
    }
  }
}
