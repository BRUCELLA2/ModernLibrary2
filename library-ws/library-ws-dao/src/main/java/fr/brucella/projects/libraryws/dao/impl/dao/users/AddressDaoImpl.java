package fr.brucella.projects.libraryws.dao.impl.dao.users;

import fr.brucella.projects.libraryws.dao.contracts.dao.users.AddressDao;
import fr.brucella.projects.libraryws.dao.impl.dao.AbstractDao;
import fr.brucella.projects.libraryws.dao.impl.rowmapper.users.model.AddressRM;
import fr.brucella.projects.libraryws.entity.exceptions.NotFoundException;
import fr.brucella.projects.libraryws.entity.exceptions.TechnicalException;
import fr.brucella.projects.libraryws.entity.users.model.Address;
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
 * Address Data Access Object.
 *
 * @author BRUCELLA2
 */
@Component
public class AddressDaoImpl extends AbstractDao implements AddressDao {

  /** Address DAO logger. */
  private static final Log LOG = LogFactory.getLog(AddressDaoImpl.class);

  // ===== Constructor =====

  /** Default Constructor */
  public AddressDaoImpl() {}

  // ===== Methods =====

  /** {@inheritDoc} */
  @Override
  public Address getAddress(final Integer addressId) throws TechnicalException, NotFoundException {

    sql = "SELECT * FROM address WHERE address_id = :addressId";

    final MapSqlParameterSource parameterSource = new MapSqlParameterSource();
    parameterSource.addValue("addressId", addressId);

    final RowMapper<Address> rowMapper = new AddressRM();

    try {
      return this.getNamedJdbcTemplate().queryForObject(sql, parameterSource, rowMapper);
    } catch (EmptyResultDataAccessException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("addressId = " + addressId);
      }
      LOG.error(exception.getMessage());
      throw new NotFoundException(messages.getString("addressDao.getAddress.notFound"), exception);
    } catch (PermissionDeniedDataAccessException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("permissionDenied"), exception);
    } catch (DataAccessResourceFailureException exception) {
      LOG.error((exception.getMessage()));
      throw new TechnicalException(messages.getString("dataAccessResourceFailure"), exception);
    } catch (DataAccessException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug(("addressId = " + addressId));
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("dataAccess"), exception);
    }
  }

  /** {@inheritDoc} */
  @Override
  public void updateAddress(final Address address) throws TechnicalException, NotFoundException {

    sql =
        "UPDATE address SET line1 = :line1, line2 = :line2, line3 = :line3, city = :city, zip_code = :zipCode WHERE address_id = :addressId";

    final SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(address);

    try {
      final int result = this.getNamedJdbcTemplate().update(sql, parameterSource);
      if (result == 0) {
        if (LOG.isDebugEnabled()) {
          LOG.debug("SQL : " + sql);
          LOG.debug("address = " + address.toString());
        }
        throw new NotFoundException(messages.getString("addressDao.updateAddress.notFound"));
      }
    } catch (DataIntegrityViolationException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("address : " + address.toString());
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(
          messages.getString("addressDao.updateAddress.integrityViolation"), exception);
    } catch (PermissionDeniedDataAccessException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("permissionDenied"), exception);
    } catch (DataAccessResourceFailureException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("dataAccessResourceFailure"), exception);
    } catch (DataAccessException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("address = " + address.toString());
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("dataAccess"), exception);
    }
  }

  /** {@inheritDoc} */
  @Override
  public int insertAddress(final Address address) throws TechnicalException {

    sql =
        "INSERT INTO address (address_id, line1, line2, line3, city, zip_code) VALUES (DEFAULT, :line1, :line2, :line3, :city, :zipCode)";

    final KeyHolder keyHolder = new GeneratedKeyHolder();
    final SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(address);

    try {
      this.getNamedJdbcTemplate()
          .update(sql, parameterSource, keyHolder, new String[] {"address_id"});
      return keyHolder.getKey().intValue();

    } catch (DuplicateKeyException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("address : " + address.toString());
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(
          messages.getString("addressDao.insertAddress.duplicate"), exception);
    } catch (DataIntegrityViolationException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("address : " + address.toString());
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(
          messages.getString("addressDao.insertAddress.integrityViolation"), exception);
    } catch (PermissionDeniedDataAccessException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("permissionDenied"), exception);
    } catch (DataAccessResourceFailureException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("dataAccessResourceFailure"), exception);
    } catch (DataAccessException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("address = " + address.toString());
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("dataAccess"), exception);
    }
  }

  /** {@inheritDoc} */
  @Override
  public void deleteAddress(final Integer addressId) throws TechnicalException, NotFoundException {

    sql = "DELETE FROM address WHERE address_id = :addressId";

    final MapSqlParameterSource parameterSource = new MapSqlParameterSource();
    parameterSource.addValue("addressId", addressId);

    try {
      final int result = this.getNamedJdbcTemplate().update(sql, parameterSource);
      if (result == 0) {
        if (LOG.isDebugEnabled()) {
          LOG.debug("SQL : " + sql);
          LOG.debug("addressId = " + addressId);
        }
        throw new NotFoundException(messages.getString("addressDao.deleteAddress.notFound"));
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
        LOG.debug("addressId = " + addressId);
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("dataAccess"), exception);
    }
  }
}
