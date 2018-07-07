package fr.brucella.projects.libraryws.dao.impl.dao.books;

import fr.brucella.projects.libraryws.dao.contracts.dao.books.BookBorrowedDao;
import fr.brucella.projects.libraryws.dao.impl.dao.AbstractDao;
import fr.brucella.projects.libraryws.dao.impl.rowmapper.books.BookBorrowedRM;
import fr.brucella.projects.libraryws.entity.books.model.BookBorrowed;
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
import org.springframework.stereotype.Component;

/**
 * BookBorrowed Data Access Object.
 *
 * @author BRUCELLA2
 */
@Component
public class BookBorrowedDaoImpl extends AbstractDao implements BookBorrowedDao {

  /** BookBorrowed Data Access Object. */
  private static final Log LOG = LogFactory.getLog(BookBorrowedDaoImpl.class);

  /** sql string used in database request. */
  private String sql;

  /** {@inheritDoc} */
  @Override
  public BookBorrowed getBookBorrowed(final Integer userId, final Integer bookId)
      throws TechnicalException, NotFoundException {

    sql = "SELECT * FROM book_borrowed WHERE user_id = :userId AND book_id = :bookId";

    final MapSqlParameterSource parameterSource = new MapSqlParameterSource();
    parameterSource.addValue("userId", userId);
    parameterSource.addValue("bookId", bookId);

    final RowMapper<BookBorrowed> rowMapper = new BookBorrowedRM();

    try {
      return this.getNamedJdbcTemplate().queryForObject(sql, parameterSource, rowMapper);
    } catch (EmptyResultDataAccessException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("userId = " + userId + " -- " + "bookId = " + bookId);
      }
      LOG.error(exception.getMessage());
      throw new NotFoundException(
          messages.getString("bookBorrowedDao.getBookBorrowed.notFound"), exception);
    } catch (PermissionDeniedDataAccessException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("permissionDenied"));
    } catch (DataAccessResourceFailureException exception) {
      LOG.error((exception.getMessage()));
      throw new TechnicalException(messages.getString("dataAccessResourceFailure"), exception);
    } catch (DataAccessException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("userId = " + userId + " -- " + "bookId = " + bookId);
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("dataAccess"), exception);
    }
  }

  /** {@inheritDoc} */
  @Override
  public void updateBookBorrowed(final BookBorrowed bookBorrowed)
      throws TechnicalException, NotFoundException {

    sql =
        "UPDATE book_borrowed SET end_date = :endDate, borrow_date = :borrowDate, extension = :extension, nb_reminder = :nbReminder, returned = :returned, last_reminder = :lastReminder WHERE user_id = :userId AND book_id = :bookId";

    final SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(bookBorrowed);

    try {
      final int result = this.getNamedJdbcTemplate().update(sql, parameterSource);
      if (result == 0) {
        if (LOG.isDebugEnabled()) {
          LOG.debug("SQL : " + sql);
          LOG.debug("bookBorrowed = " + bookBorrowed.toString());
        }
        throw new NotFoundException(
            messages.getString("bookBorrowedDao.updateBookBorrowed.notFound"));
      }
    } catch (DataIntegrityViolationException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("bookBorrowed : " + bookBorrowed.toString());
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(
          messages.getString("bookBorrowedDao.updateBookBorrowed.integrityViolation"), exception);
    } catch (PermissionDeniedDataAccessException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("permissionDenied"), exception);
    } catch (DataAccessResourceFailureException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("dataAccessResourceFailure"), exception);
    } catch (DataAccessException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("bookBorrowed = " + bookBorrowed.toString());
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("dataAccess"), exception);
    }
  }

  /** {@inheritDoc} */
  @Override
  public void insertBookBorrowed(final BookBorrowed bookBorrowed) throws TechnicalException {

    sql =
        "INSERT INTO book_borrowed (user_id, book_id, end_date, borrow_date, extension, nb_reminder, returned, last_reminder) VALUES (userId, bookId, endDate, borrowDate, extension, nbReminder, returned, lastReminder)";

    final SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(bookBorrowed);

    try {

      this.getNamedJdbcTemplate().update(sql, parameterSource);

    } catch (DuplicateKeyException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("bookBorrowed : " + bookBorrowed.toString());
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(
          messages.getString("bookBorrowedDao.insertBookBorrowed.duplicate"), exception);
    } catch (DataIntegrityViolationException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("bookBorrowed : " + bookBorrowed.toString());
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(
          messages.getString("bookBorrowedDao.insertBookBorrowed.integrityViolation"), exception);
    } catch (PermissionDeniedDataAccessException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("permissionDenied"), exception);
    } catch (DataAccessResourceFailureException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("dataAccessResourceFailure"), exception);
    } catch (DataAccessException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("bookBorrowed = " + bookBorrowed.toString());
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("dataAccess"), exception);
    }
  }

  /** {@inheritDoc} */
  @Override
  public void deleteBookBorrowed(final Integer userId, final Integer bookId)
      throws TechnicalException, NotFoundException {

    sql = "DELETE FROM book_borrowed WHERE user_id = :userId, book_id = :bookId";

    final MapSqlParameterSource parameterSource = new MapSqlParameterSource();
    parameterSource.addValue("userId", userId);
    parameterSource.addValue("bookId", bookId);

    try {
      final int result = this.getNamedJdbcTemplate().update(sql, parameterSource);
      if (result == 0) {
        if (LOG.isDebugEnabled()) {
          LOG.debug("SQL : " + sql);
          LOG.debug("userId = " + userId + " -- " + "bookId = " + bookId);
        }
        throw new NotFoundException(
            messages.getString("bookBorrowedDao.deleteBookBorrowed.notFound"));
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
        LOG.debug("userId = " + userId + " -- " + "bookId = " + bookId);
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("dataAccess"), exception);
    }
  }
}
