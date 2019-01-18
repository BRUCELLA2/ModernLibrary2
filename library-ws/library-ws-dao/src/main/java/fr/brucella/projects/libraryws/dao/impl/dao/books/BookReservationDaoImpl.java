package fr.brucella.projects.libraryws.dao.impl.dao.books;

import fr.brucella.projects.libraryws.dao.contracts.dao.books.BookReservationDao;
import fr.brucella.projects.libraryws.dao.impl.dao.AbstractDao;
import fr.brucella.projects.libraryws.dao.impl.rowmapper.books.model.BookReservationRM;
import fr.brucella.projects.libraryws.entity.books.model.BookReservation;
import fr.brucella.projects.libraryws.entity.exceptions.NotFoundException;
import fr.brucella.projects.libraryws.entity.exceptions.TechnicalException;
import java.time.LocalDate;
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
 * BookReservation Data Access Object.
 *
 * @author BRUCELLA2
 */
@Component
public class BookReservationDaoImpl extends AbstractDao implements BookReservationDao {

  /** BookReservation DAO Logger. */
  private static final Log LOG = LogFactory.getLog(BookReservationDaoImpl.class);

  public BookReservationDaoImpl() {
    super();
  }

  /** {@inheritDoc} */
  @Override
  public BookReservation getBookReservation(final Integer bookReservationId) throws TechnicalException, NotFoundException {
    sql = "SELECT * FROM book_reservation WHERE book_reservation_id = :bookReservationId";

    final MapSqlParameterSource parameterSource = new MapSqlParameterSource();
    parameterSource.addValue("bookReservationId", bookReservationId);

    final RowMapper<BookReservation> rowMapper = new BookReservationRM();

    try {
      return this.getNamedJdbcTemplate().queryForObject(sql, parameterSource, rowMapper);
    } catch (EmptyResultDataAccessException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("bookReservationId = " + bookReservationId);
      }
      LOG.error(exception.getMessage());
      throw new NotFoundException(messages.getString("bookReservationDao.getBookReservation.notFound"), exception);
    } catch (PermissionDeniedDataAccessException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("permissionDenied"), exception);
    } catch (DataAccessResourceFailureException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("dataAccessResourceFailure"), exception);
    } catch (DataAccessException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("bookReservationId = " + bookReservationId);
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("dataAccess"), exception);
    }
  }

  /** {@inheritDoc} */
  @Override
  public BookReservation getBookReservation(final Integer bookId, final Integer userId)
      throws TechnicalException, NotFoundException {

    sql = "SELECT * FROM book_reservation WHERE book_id = :bookId AND user_id = :userId AND active_reservation = TRUE";

    final MapSqlParameterSource parameterSource = new MapSqlParameterSource();
    parameterSource.addValue("bookId", bookId);
    parameterSource.addValue("userId", userId);

    final RowMapper<BookReservation> rowMapper = new BookReservationRM();

    try {
      return this.getNamedJdbcTemplate().queryForObject(sql, parameterSource, rowMapper);
    } catch (EmptyResultDataAccessException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("bookId = " + bookId);
        LOG.debug("userId = " + userId);
      }
      LOG.error(exception.getMessage());
      throw new NotFoundException(messages.getString("bookReservationDao.getBookReservation.notFound"), exception);
    } catch (PermissionDeniedDataAccessException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("permissionDenied"), exception);
    } catch (DataAccessResourceFailureException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("dataAccessResourceFailure"), exception);
    } catch (DataAccessException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("bookId = " + bookId);
        LOG.debug("userId = " + userId);
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("dataAccess"), exception);
    }
  }

  /** {@inheritDoc} */
  @Override
  public List<BookReservation> getReservationsList() throws TechnicalException, NotFoundException {

    sql = "SELECT * from book_reservation ORDER BY date_reservation DESC";

    final RowMapper<BookReservation> rowMapper = new BookReservationRM();

    try {
      final List<BookReservation> reservationsList = this.getJdbcTemplate().query(sql, rowMapper);
      if(reservationsList.isEmpty()) {
        if (LOG.isDebugEnabled()) {
          LOG.debug("SQL : " + sql);
        }
        throw new NotFoundException(messages.getString("bookReservationDao.getReservationsList.notFound"));
      } else {
        return reservationsList;
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
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("dataAccess"), exception);
    }
  }

  /** {@inheritDoc} */
  @Override
  public List<BookReservation> getActiveReservationsList() throws TechnicalException, NotFoundException {

    sql = "SELECT * FROM book_reservation WHERE active_reservation = true ORDER BY date_reservation DESC";

    final RowMapper<BookReservation> rowMapper = new BookReservationRM();

    try {
      final List<BookReservation> reservationsList = this.getJdbcTemplate().query(sql, rowMapper);
      if(reservationsList.isEmpty()) {
        if (LOG.isDebugEnabled()) {
          LOG.debug("SQL : " + sql);
        }
        throw new NotFoundException(messages.getString("bookReservationDao.getActiveReservationsList.notFound"));
      } else {
        return reservationsList;
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
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("dataAccess"), exception);
    }
  }

  /** {@inheritDoc} */
  @Override
  public List<BookReservation> getActiveReservationListForBook(Integer bookId)
      throws TechnicalException, NotFoundException {
    sql = "SELECT * FROM book_reservation WHERE active_reservation = true AND book_id = :bookId ORDER BY date_reservation DESC";

    final MapSqlParameterSource parameterSource = new MapSqlParameterSource();
    parameterSource.addValue("bookId", bookId);

    final RowMapper<BookReservation> rowMapper = new BookReservationRM();

    try {
      final List<BookReservation> reservationsList = this.getNamedJdbcTemplate().query(sql, parameterSource, rowMapper);
      if (reservationsList.isEmpty()) {
        if (LOG.isDebugEnabled()) {
          LOG.debug("SQL : " + sql);
          LOG.debug("bookId = " + bookId);
        }
        throw new NotFoundException(messages.getString("bookReservationDao.getActiveReservationListForBook.notFound"));
      } else {
        return reservationsList;
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
        LOG.debug("bookId = " + bookId);
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("dataAccess"), exception);
    }
  }

  @Override
  public List<BookReservation> getActiveReservationWithoutBorrowInTime(LocalDate dateDepassed)
      throws TechnicalException, NotFoundException {
    sql = "SELECT * FROM book_reservation WHERE active_reservation = true AND date_reservation_email_send < :dateDepassed ORDER BY date_reservation_email_send DESC";

    final MapSqlParameterSource parameterSource = new MapSqlParameterSource();
    parameterSource.addValue("dateDepassed", dateDepassed);

    final RowMapper<BookReservation> rowMapper = new BookReservationRM();

    try {
      final List<BookReservation> reservationsList = this.getNamedJdbcTemplate().query(sql, parameterSource, rowMapper);
      if (reservationsList.isEmpty()) {
        if (LOG.isDebugEnabled()) {
          LOG.debug("SQL : " + sql);
          LOG.debug("dateDepassed : " + dateDepassed.toString());
        }
        throw new NotFoundException(messages.getString("bookReservationDao.getActiveReservationWithoutBorrowInTime.notFound"));
      } else {
        return reservationsList;
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
        LOG.debug("dateDepassed : " + dateDepassed.toString());
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("dataAccess"), exception);
    }
  }


  /** {@inheritDoc} */
  @Override
  public List<BookReservation> getActiveReservationsListForUser(Integer userId)
      throws TechnicalException, NotFoundException {
    return getReservationsListForUser(userId, true);
  }

  /** {@inheritDoc} */
  @Override
  public List<BookReservation> getInactiveReservationsListForUser(Integer userId)
      throws TechnicalException, NotFoundException {
    return getReservationsListForUser(userId, false);
  }

  /** {@inheritDoc} */
  @Override
  public void updateBookReservation(final BookReservation bookReservation) throws TechnicalException, NotFoundException {

    sql = "UPDATE book_reservation SET book_id = :bookId, user_id = :userId, date_reservation = :dateReservation, date_reservation_email_send = :dateReservationEmailSend, active_reservation = :activeReservation WHERE book_reservation_id = :bookReservationId";

    final SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(bookReservation);

    try {
      final int result = this.getNamedJdbcTemplate().update(sql, parameterSource);
      if (result == 0) {
        if (LOG.isDebugEnabled()) {
          LOG.debug("SQL : " + sql);
          LOG.debug("bookReservation = " + bookReservation.toString());
        }
        throw new NotFoundException(messages.getString("bookReservationDao.updateBookReservation.notFound"));
      }
    } catch (DataIntegrityViolationException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("bookReservation : " + bookReservation.toString());
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("bookReservation.updateBookReservation.integrityViolation"), exception);
    } catch (PermissionDeniedDataAccessException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("permissionDenied"), exception);
    } catch (DataAccessResourceFailureException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("dataAccessResourceFailure"), exception);
    } catch (DataAccessException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("bookReservation = " + bookReservation.toString());
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("dataAccess"), exception);
    }

  }

  /** {@inheritDoc} */
  @Override
  public Integer insertBookReservation(final BookReservation bookReservation) throws TechnicalException {

    sql = "INSERT INTO book_reservation (book_reservation_id, book_id, user_id, date_reservation, date_reservation_email_send, active_reservation) VALUES (DEFAULT, :bookId, :userId, :dateReservation, :dateReservationEmailSend, :activeReservation)";

    final KeyHolder keyHolder = new GeneratedKeyHolder();
    final SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(bookReservation);

    try {
      this.getNamedJdbcTemplate().update(sql, parameterSource, keyHolder, new String[] {"book_reservation_id"});
      return keyHolder.getKey().intValue();
    } catch (DuplicateKeyException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("bookReservation : " + bookReservation.toString());
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("bookReservationDao.insertBookReservation.duplicate"), exception);
    } catch (DataIntegrityViolationException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("bookReservation : " + bookReservation.toString());
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("bookReservationDao.insertBookReservation.integrityViolation"), exception);
    } catch (PermissionDeniedDataAccessException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("permissionDenied"), exception);
    } catch (DataAccessResourceFailureException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("dataAccessResourceFailure"), exception);
    } catch (DataAccessException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("bookReservation = " + bookReservation.toString());
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("dataAccess"), exception);
    }
  }

  /** {@inheritDoc} */
  @Override
  public void deleteBookReservation(final Integer bookReservationId) throws TechnicalException, NotFoundException {

    sql = "DELETE FROM book_reservation WHERE book_reservation_id = :bookReservationId";

    final MapSqlParameterSource parameterSource = new MapSqlParameterSource();
    parameterSource.addValue("bookReservationId", bookReservationId);

    try {
      final int result = this.getNamedJdbcTemplate().update(sql, parameterSource);
      if (result == 0) {
        if (LOG.isDebugEnabled()) {
          LOG.debug("SQL : " + sql);
          LOG.debug("bookReservationId = " + bookReservationId);
        }
        throw new NotFoundException(messages.getString("bookReservationDao.deleteBookReservation.notFound"));
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
        LOG.debug("bookReservation = " + bookReservationId);
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("dataAccess"), exception);
    }
  }

  /**
   * Give the list of reservation for the userId and with the activeStatut.
   *
   * @param userId id of the user.
   * @param activeStatut status of the reservation.
   * @return the list of reservation for the userId and with the activeStatut.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and no
   *     reservation is found.
   */
  private List<BookReservation> getReservationsListForUser(Integer userId, Boolean activeStatut)
      throws NotFoundException, TechnicalException {

    sql = "SELECT * FROM book_reservation WHERE user_id = :userId AND active_reservation = :activeReservation ORDER BY date_reservation DESC";

    final MapSqlParameterSource parameterSource = new MapSqlParameterSource();
    parameterSource.addValue("userId", userId);
    parameterSource.addValue("activeReservation", activeStatut);

    final RowMapper<BookReservation> rowMapper = new BookReservationRM();

    try {
      final List<BookReservation> reservationsList = this.getNamedJdbcTemplate().query(sql, parameterSource, rowMapper);
      if (reservationsList.isEmpty()) {
        if (LOG.isDebugEnabled()) {
          LOG.debug("SQL : " + sql);
          LOG.debug("User Id : " + userId);
          LOG.debug("Active Statut : " + activeStatut);
        }
        throw new NotFoundException(messages.getString("bookReservationDao.getReservationsList.notFound"));
      } else {
        return reservationsList;
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
        LOG.debug("User Id : " + userId);
        LOG.debug("Active Statut : " + activeStatut);
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("dataAccess"), exception);
    }
  }
}
