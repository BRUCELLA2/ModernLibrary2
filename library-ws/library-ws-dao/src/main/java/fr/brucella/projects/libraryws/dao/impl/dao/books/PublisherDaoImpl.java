package fr.brucella.projects.libraryws.dao.impl.dao.books;

import fr.brucella.projects.libraryws.dao.contracts.dao.books.PublisherDao;
import fr.brucella.projects.libraryws.dao.impl.dao.AbstractDao;
import fr.brucella.projects.libraryws.dao.impl.rowmapper.books.model.PublisherRM;
import fr.brucella.projects.libraryws.entity.books.model.Publisher;
import fr.brucella.projects.libraryws.entity.exceptions.NotFoundException;
import fr.brucella.projects.libraryws.entity.exceptions.TechnicalException;
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
 * Publisher Data Access Object.
 *
 * @author BRUCELLA2
 */
@Component
public class PublisherDaoImpl extends AbstractDao implements PublisherDao {

  /** Author DAO logger. */
  private static final Log LOG = LogFactory.getLog(PublisherDaoImpl.class);

  /** Default Constructor */
  public PublisherDaoImpl() {
    super();
  }

  /** {@inheritDoc} */
  @Override
  public Publisher getPublisher(final Integer publisherId)
      throws TechnicalException, NotFoundException {

    sql = "SELECT * FROM publisher WHERE publisher_id = publisherId";

    final MapSqlParameterSource parameterSource = new MapSqlParameterSource();
    parameterSource.addValue("publisherId", publisherId);

    final RowMapper<Publisher> rowMapper = new PublisherRM();

    try {
      return this.getNamedJdbcTemplate().queryForObject(sql, parameterSource, rowMapper);
    } catch (EmptyResultDataAccessException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("publisherId = " + publisherId);
      }
      LOG.error(exception.getMessage());
      throw new NotFoundException(
          messages.getString("publisherDao.getPublisher.notFound"), exception);
    } catch (PermissionDeniedDataAccessException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString(PERMISSION_DENIED), exception);
    } catch (DataAccessResourceFailureException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString(DATA_ACCESS_RESOURCE_FAILURE), exception);
    } catch (DataAccessException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug(("publisherId = " + publisherId));
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString(DATA_ACCESS), exception);
    }
  }

  /** {@inheritDoc} */
  @Override
  public void updatePublisher(final Publisher publisher)
      throws TechnicalException, NotFoundException {

    sql = "UPDATE publisher SET name = :name WHERE publisher_id = :publisherId";

    final SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(publisher);

    try {
      final int result = this.getNamedJdbcTemplate().update(sql, parameterSource);
      if (result == 0) {
        if (LOG.isDebugEnabled()) {
          LOG.debug("SQL : " + sql);
          LOG.debug("Publisher = " + publisher.toString());
        }
        throw new NotFoundException(messages.getString("publisherDao.updatePublisher.notFound"));
      }
    } catch (DataIntegrityViolationException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("Publisher : " + publisher.toString());
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(
          messages.getString("publisherDao.updatePublisher.integrityViolation"), exception);
    } catch (PermissionDeniedDataAccessException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString(PERMISSION_DENIED), exception);
    } catch (DataAccessResourceFailureException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString(DATA_ACCESS_RESOURCE_FAILURE), exception);
    } catch (DataAccessException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("Publisher = " + publisher.toString());
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString(DATA_ACCESS), exception);
    }
  }

  /** {@inheritDoc} */
  @Override
  public int insertPublisher(final Publisher publisher) throws TechnicalException {

    sql = "INSERT INTO publisher (publisher_id, name) VALUES (DEFAULT, :name)";

    final SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(publisher);
    final KeyHolder keyHolder = new GeneratedKeyHolder();

    try {
      this.getNamedJdbcTemplate()
          .update(sql, parameterSource, keyHolder, new String[] {"publisher_id"});
      return keyHolder.getKey().intValue();
    } catch (DuplicateKeyException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("Publisher : " + publisher.toString());
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(
          messages.getString("publisherDao.insertPublisher.duplicate"), exception);
    } catch (DataIntegrityViolationException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("Publisher : " + publisher.toString());
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(
          messages.getString("publisherDao.insertPublisher.integrityViolation"), exception);
    } catch (PermissionDeniedDataAccessException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString(PERMISSION_DENIED), exception);
    } catch (DataAccessResourceFailureException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString(DATA_ACCESS_RESOURCE_FAILURE), exception);
    } catch (DataAccessException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("Publisher = " + publisher.toString());
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString(DATA_ACCESS), exception);
    }
  }

  /** {@inheritDoc} */
  @Override
  public void deletePublisher(final Integer publisherId)
      throws TechnicalException, NotFoundException {

    sql = "DELETE FROM publisher WHERE publisher_id = :publisherId";

    final MapSqlParameterSource parameterSource = new MapSqlParameterSource();
    parameterSource.addValue("publisherId", publisherId);

    try {
      final int result = this.getNamedJdbcTemplate().update(sql, parameterSource);
      if (result == 0) {
        if (LOG.isDebugEnabled()) {
          LOG.debug("SQL : " + sql);
          LOG.debug("publisherID = " + publisherId);
        }
        throw new NotFoundException(messages.getString("publisherDao.deletePublisher.notFound"));
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
        LOG.debug("publisherID = " + publisherId);
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString(DATA_ACCESS), exception);
    }
  }
}
