package fr.brucella.projects.libraryws.dao.impl.dao.books;

import fr.brucella.projects.libraryws.dao.contracts.dao.books.BookDao;
import fr.brucella.projects.libraryws.dao.impl.dao.AbstractDao;
import fr.brucella.projects.libraryws.dao.impl.rowmapper.books.BookRM;
import fr.brucella.projects.libraryws.entity.books.model.Book;
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
 * Book Data Access Object.
 *
 * @author BRUCELLA2
 */
@Component
public class BookDaoImpl extends AbstractDao implements BookDao {

  /** Book DAO logger. */
  private static final Log LOG = LogFactory.getLog(BookDaoImpl.class);

  /** Default Constructor */
  public BookDaoImpl() {}

  /** {@inheritDoc} */
  @Override
  public Book getBook(final Integer bookId) throws TechnicalException, NotFoundException {

    sql = "SELECT * FROM book WHERE book_id = :bookId";

    final MapSqlParameterSource parameterSource = new MapSqlParameterSource();
    parameterSource.addValue("bookId", bookId);

    final RowMapper<Book> rowMapper = new BookRM();

    try {
      return this.getNamedJdbcTemplate().queryForObject(sql, parameterSource, rowMapper);
    } catch (EmptyResultDataAccessException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("bookId = " + bookId);
      }
      LOG.error(exception.getMessage());
      throw new NotFoundException(messages.getString("bookDao.getBook.notFound"), exception);
    } catch (PermissionDeniedDataAccessException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("permissionDenied"), exception);
    } catch (DataAccessResourceFailureException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("dataAccessResourceFailure"), exception);
    } catch (DataAccessException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug(("bookId = " + bookId));
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("dataAccess"), exception);
    }
  }

  /** {@inheritDoc} */
  @Override
  public void updateBook(final Book book) throws TechnicalException, NotFoundException {

    sql =
        "UPDATE book SET book_id = :bookId, title = :title, isbn13 = :isbn13, ean13 = :ean13, publishing_date = :publishingDate, resume = :resume, genre_id = :genreId, publisher_id = :publisherId WHERE book_id = bookId";

    final SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(book);

    try {
      final int result = this.getNamedJdbcTemplate().update(sql, parameterSource);
      if (result == 0) {
        if (LOG.isDebugEnabled()) {
          LOG.debug("SQL : " + sql);
          LOG.debug("Book = " + book.toString());
        }
        throw new NotFoundException(messages.getString("bookDao.updateBook.notFound"));
      }
    } catch (DataIntegrityViolationException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("Book : " + book.toString());
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(
          messages.getString("bookDao.updateBook.integrityViolation"), exception);
    } catch (PermissionDeniedDataAccessException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("permissionDenied"), exception);
    } catch (DataAccessResourceFailureException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("dataAccessResourceFailure"), exception);
    } catch (DataAccessException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("Book = " + book.toString());
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("dataAccess"), exception);
    }
  }

  /** {@inheritDoc} */
  @Override
  public int insertBook(final Book book) throws TechnicalException {

    sql =
        "INSERT INTO book (book_id, title, isbn13, ean13, publishing_date, resume, genre_id, publisher_id) VALUES (DEFAULT, :title, :isbn13, :ean13, :publishingDate, :resume, :genreId, :publisherId)";

    final KeyHolder keyHolder = new GeneratedKeyHolder();
    final SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(book);

    try {
      this.getNamedJdbcTemplate().update(sql, parameterSource, keyHolder, new String[] {"book_id"});
      return keyHolder.getKey().intValue();
    } catch (DuplicateKeyException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("Book : " + book.toString());
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("bookDao.insertBook.duplicate"), exception);
    } catch (DataIntegrityViolationException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("Book : " + book.toString());
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(
          messages.getString("bookDao.insertBook.integrityViolation"), exception);
    } catch (PermissionDeniedDataAccessException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("permissionDenied"), exception);
    } catch (DataAccessResourceFailureException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("dataAccessResourceFailure"), exception);
    } catch (DataAccessException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("Book = " + book.toString());
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("dataAccess"), exception);
    }
  }

  /** {@inheritDoc} */
  @Override
  public void deleteBook(final Integer bookId) throws TechnicalException, NotFoundException {

    sql = "DELETE FROM book WHERE book_id = :bookId";

    final MapSqlParameterSource parameterSource = new MapSqlParameterSource();
    parameterSource.addValue("bookId", bookId);

    try {
      final int result = this.getNamedJdbcTemplate().update(sql, parameterSource);
      if (result == 0) {
        if (LOG.isDebugEnabled()) {
          LOG.debug("SQL : " + sql);
          LOG.debug("bookID = " + bookId);
        }
        throw new NotFoundException(messages.getString("bookDao.deleteBook.notFound"));
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
}
