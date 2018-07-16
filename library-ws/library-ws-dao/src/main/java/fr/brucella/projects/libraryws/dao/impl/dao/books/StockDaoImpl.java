package fr.brucella.projects.libraryws.dao.impl.dao.books;

import fr.brucella.projects.libraryws.dao.contracts.dao.books.StockDao;
import fr.brucella.projects.libraryws.dao.impl.dao.AbstractDao;
import fr.brucella.projects.libraryws.dao.impl.rowmapper.books.dto.BookStockDtoRM;
import fr.brucella.projects.libraryws.dao.impl.rowmapper.books.model.StockRM;
import fr.brucella.projects.libraryws.entity.books.dto.BookStockDto;
import fr.brucella.projects.libraryws.entity.books.model.Stock;
import fr.brucella.projects.libraryws.entity.exceptions.NotFoundException;
import fr.brucella.projects.libraryws.entity.exceptions.TechnicalException;
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
 * Stock Data Access Object.
 *
 * @author BRUCELLA2
 */
@Component
public class StockDaoImpl extends AbstractDao implements StockDao {

  /** Stock DAO logger. */
  private static final Log LOG = LogFactory.getLog(StockDaoImpl.class);

  /** Default Constructor */
  public StockDaoImpl() {}

  /** {@inheritDoc} */
  @Override
  public Stock getStock(final Integer stockId) throws TechnicalException, NotFoundException {

    sql = "SELECT * FROM stock WHERE stock_id = :stockId";

    final MapSqlParameterSource parameterSource = new MapSqlParameterSource();
    parameterSource.addValue("stockId", stockId);

    final RowMapper<Stock> rowMapper = new StockRM();

    try {
      return this.getNamedJdbcTemplate().queryForObject(sql, parameterSource, rowMapper);
    } catch (EmptyResultDataAccessException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("stockId = " + stockId);
      }
      LOG.error(exception.getMessage());
      throw new NotFoundException(messages.getString("stockDao.getStock.notFound"), exception);
    } catch (PermissionDeniedDataAccessException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("permissionDenied"), exception);
    } catch (DataAccessResourceFailureException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("dataAccessResourceFailure"), exception);
    } catch (DataAccessException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug(("stockId = " + stockId));
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("dataAccess"), exception);
    }
  }

  /** {@inheritDoc} */
  @Override
  public Stock getStockForBook(final Integer bookId) throws TechnicalException, NotFoundException {

    sql = "SELECT * FROM stock WHERE book_id = :bookId";

    final MapSqlParameterSource parameterSource = new MapSqlParameterSource();
    parameterSource.addValue("bookId", bookId);

    final RowMapper<Stock> rowMapper = new StockRM();

    try {
      return this.getNamedJdbcTemplate().queryForObject(sql, parameterSource, rowMapper);
    } catch (EmptyResultDataAccessException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("bookId = " + bookId);
      }
      LOG.error(exception.getMessage());
      throw new NotFoundException(
          messages.getString("stockDao.getStockForBook.notFound"), exception);
    } catch (PermissionDeniedDataAccessException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("permissionDenied"));
    } catch (DataAccessResourceFailureException exception) {
      LOG.error((exception.getMessage()));
      throw new TechnicalException(messages.getString("dataAccessResourceFailure"), exception);
    } catch (DataAccessException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("dataAccess"), exception);
    }
  }

  @Override
  public List<BookStockDto> getBookStockList() throws TechnicalException, NotFoundException {

    sql = "SELECT stock.stock_id, stock.book_id, stock.amount_available, stock.amount, book.title FROM stock INNER JOIN book ON book.book_id = stock.book_id";

    final RowMapper<BookStockDto> rowMapper = new BookStockDtoRM();

    try {
      List<BookStockDto> bookStockDtoList = this.getJdbcTemplate().query(sql, rowMapper);
      if(bookStockDtoList.isEmpty()){
        if(LOG.isDebugEnabled()){
          LOG.debug("SQL : " + sql);
        }
        throw new NotFoundException(messages.getString("stockDao.getBookStockList.notFound"));
      } else {
        return bookStockDtoList;
      }
    } catch (PermissionDeniedDataAccessException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("permissionDenied"));
    } catch (DataAccessResourceFailureException exception) {
      LOG.error((exception.getMessage()));
      throw new TechnicalException(messages.getString("dataAccessResourceFailure"), exception);
    } catch (DataAccessException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("dataAccess"), exception);
    }
  }

  /** {@inheritDoc} */
  @Override
  public void updateStock(final Stock stock) throws TechnicalException, NotFoundException {

    sql =
        "UPDATE stock SET book_id = :bookId, amount_available = :amountAvailable, amount = :amount WHERE stock_id = :stockId";

    final SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(stock);

    try {
      final int result = this.getNamedJdbcTemplate().update(sql, parameterSource);
      if (result == 0) {
        if (LOG.isDebugEnabled()) {
          LOG.debug("SQL : " + sql);
          LOG.debug("Stock = " + stock.toString());
        }
        throw new NotFoundException(messages.getString("stockDao.updateStock.notFound"));
      }
    } catch (DataIntegrityViolationException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("Stock : " + stock.toString());
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(
          messages.getString("stockDao.updateStock.integrityViolation"), exception);
    } catch (PermissionDeniedDataAccessException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("permissionDenied"), exception);
    } catch (DataAccessResourceFailureException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("dataAccessResourceFailure"), exception);
    } catch (DataAccessException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("Stock = " + stock.toString());
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("dataAccess"), exception);
    }
  }

  /** {@inheritDoc} */
  @Override
  public int insertStock(final Stock stock) throws TechnicalException {

    sql =
        "INSERT INTO stock (stock_id, book_id, amount_available, amount) VALUES (DEFAULT, :bookId, :amountAvailable, :amount)";

    final KeyHolder keyHolder = new GeneratedKeyHolder();
    final SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(stock);

    try {
      this.getNamedJdbcTemplate()
          .update(sql, parameterSource, keyHolder, new String[] {"stock_id"});
      return keyHolder.getKey().intValue();

    } catch (DuplicateKeyException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("Stock : " + stock.toString());
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("stockDao.insertStock.duplicate"), exception);
    } catch (DataIntegrityViolationException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("Stock : " + stock.toString());
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(
          messages.getString("stockDao.insertStock.integrityViolation"), exception);
    } catch (PermissionDeniedDataAccessException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("permissionDenied"), exception);
    } catch (DataAccessResourceFailureException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("dataAccessResourceFailure"), exception);
    } catch (DataAccessException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("Stock = " + stock.toString());
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("dataAccess"), exception);
    }
  }

  /** {@inheritDoc} */
  @Override
  public void deleteStock(final Integer stockId) throws TechnicalException, NotFoundException {

    sql = "DELETE FROM stock WHERE stock_id = :stockId";

    final MapSqlParameterSource parameterSource = new MapSqlParameterSource();
    parameterSource.addValue("stockId", stockId);

    try {
      final int result = this.getNamedJdbcTemplate().update(sql, parameterSource);
      if (result == 0) {
        if (LOG.isDebugEnabled()) {
          LOG.debug("SQL : " + sql);
          LOG.debug("stockId = " + stockId);
        }
        throw new NotFoundException(messages.getString("stockDao.deleteStock.notFound"));
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
        LOG.debug("stockId = " + stockId);
      }
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("dataAccess"), exception);
    }
  }
}
