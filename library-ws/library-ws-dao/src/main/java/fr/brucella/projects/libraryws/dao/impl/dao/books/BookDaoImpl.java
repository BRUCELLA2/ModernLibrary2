package fr.brucella.projects.libraryws.dao.impl.dao.books;

import fr.brucella.projects.libraryws.dao.contracts.dao.books.BookDao;
import fr.brucella.projects.libraryws.dao.impl.dao.AbstractDao;
import fr.brucella.projects.libraryws.dao.impl.rowmapper.books.dto.BookDetailsDtoRM;
import fr.brucella.projects.libraryws.dao.impl.rowmapper.books.model.AuthorRM;
import fr.brucella.projects.libraryws.dao.impl.rowmapper.books.model.BookBorrowedRM;
import fr.brucella.projects.libraryws.dao.impl.rowmapper.books.model.BookRM;
import fr.brucella.projects.libraryws.entity.books.dto.BookDetailsDto;
import fr.brucella.projects.libraryws.entity.books.model.Author;
import fr.brucella.projects.libraryws.entity.books.model.Book;
import fr.brucella.projects.libraryws.entity.books.model.BookBorrowed;
import fr.brucella.projects.libraryws.entity.exceptions.NotFoundException;
import fr.brucella.projects.libraryws.entity.exceptions.TechnicalException;
import fr.brucella.projects.libraryws.entity.searchcriteria.dto.BooksSearchClientCriteriaDto;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
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
  public BookDaoImpl() {
    super();
  }

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
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("dataAccess"), exception);
    }
  }

  /** {@inheritDoc} */
  @Override
  public BookDetailsDto getBookDetails(Integer bookId)
      throws NotFoundException, TechnicalException {

    sql =
        "SELECT book.book_id, book.title, book.isbn13, book.ean13, book.publishing_date, book.resume, book.genre_id, book.publisher_id, publisher.name as publisher_name, genre.name as genre_name, stock.amount_available as amount_available FROM book INNER JOIN publisher ON publisher.publisher_id = book.publisher_id INNER JOIN genre ON genre.genre_id = book.genre_id INNER JOIN stock ON stock.book_id = book.book_id WHERE book.book_id = :bookId";

    final MapSqlParameterSource parameterSourceBook = new MapSqlParameterSource();
    parameterSourceBook.addValue("bookId", bookId);

    final RowMapper<BookDetailsDto> bookDetailsDtoRowMapper = new BookDetailsDtoRM();
    BookDetailsDto bookDetails;

    try {
      bookDetails =
          this.getNamedJdbcTemplate()
              .queryForObject(sql, parameterSourceBook, bookDetailsDtoRowMapper);
    } catch (EmptyResultDataAccessException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("bookId = " + bookId);
      }
      LOG.error(exception.getMessage());
      throw new NotFoundException(messages.getString("bookDao.getBookDetails.notFound"), exception);
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

    // Get authors informations

    sql =
        "SELECT * from author INNER JOIN book_authors ON author.author_id = book_authors.author_id WHERE book_authors.book_id = :bookId";

    final MapSqlParameterSource parameterSourceAuthors = new MapSqlParameterSource();
    parameterSourceAuthors.addValue("bookId", bookId);

    final RowMapper<Author> authorRowMapper = new AuthorRM();

    try {
      List<Author> authorsList =
          getNamedJdbcTemplate().query(sql, parameterSourceAuthors, authorRowMapper);
      if (authorsList.isEmpty()) {
        authorsList = new ArrayList<>();
      }
      bookDetails.setAuthors(authorsList);
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

    // Get the end date of borrow if quantity of book is = 0
    if (bookDetails.getAmountAvailable() == 0) {
      sql = "SELECT * from book_borrowed WHERE book_id = :bookId ORDER BY end_date ASC";

      final MapSqlParameterSource parameterSourceBorrow = new MapSqlParameterSource();
      parameterSourceBorrow.addValue("bookId", bookId);

      final RowMapper<BookBorrowed> bookBorrowedRowMapper = new BookBorrowedRM();

      try {
        List<BookBorrowed> bookBorrowedList = getNamedJdbcTemplate().query(sql, parameterSourceBorrow, bookBorrowedRowMapper);
        if (!bookBorrowedList.isEmpty()) {
          bookDetails.setEndBorrowDate(bookBorrowedList.get(0).getEndDate());
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

    // Get the amount of reservation for this book if quantity of book is = 0
    if (bookDetails.getAmountAvailable() == 0) {
      sql = "SELECT COUNT(*) from book_reservation WHERE book_id = :bookId AND active_reservation = true";

      final MapSqlParameterSource parameterSourceCount = new MapSqlParameterSource();
      parameterSourceCount.addValue("bookId", bookId);

      try {
        int count = getNamedJdbcTemplate().queryForObject(sql, parameterSourceCount, Integer.class);
        bookDetails.setNbActiveReservations(count);
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

    return bookDetails;
  }

  /** {@inheritDoc} */
  @Override
  public List<BookDetailsDto> getBookDetailsList() throws TechnicalException, NotFoundException {

    sql =
        "SELECT book.book_id, book.title, book.isbn13, book.ean13, book.publishing_date, book.resume, book.genre_id, book.publisher_id, publisher.name as publisher_name, genre.name as genre_name, stock.amount_available as amount_available FROM book INNER JOIN publisher ON publisher.publisher_id = book.publisher_id INNER JOIN genre ON genre.genre_id = book.genre_id INNER JOIN stock ON stock.book_id = book.book_id";

    final RowMapper<BookDetailsDto> bookDetailsDtoRowMapper = new BookDetailsDtoRM();

    List<BookDetailsDto> bookDetailsDtoList;

    try {
      bookDetailsDtoList = this.getJdbcTemplate().query(sql, bookDetailsDtoRowMapper);
      if (bookDetailsDtoList.isEmpty()) {
        if (LOG.isDebugEnabled()) {
          LOG.debug("SQL : " + sql);
        }
        throw new NotFoundException(messages.getString("bookDao.getBookDetailsList.notFound"));
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

    for (BookDetailsDto bookDetails : bookDetailsDtoList) {
      sql =
          "SELECT * from author INNER JOIN book_authors ON author.author_id = book_authors.author_id WHERE book_authors.book_id = :book_id";

      final MapSqlParameterSource parameterSource = new MapSqlParameterSource();
      parameterSource.addValue("book_id", bookDetails.getBookId());

      final RowMapper<Author> authorRowMapper = new AuthorRM();

      try {
        List<Author> authorList =
            getNamedJdbcTemplate().query(sql, parameterSource, authorRowMapper);
        if (authorList.isEmpty()) {
          authorList = new ArrayList<>();
        }
        bookDetails.setAuthors(authorList);
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

      // Get the end date of borrow if quantity of book is = 0
      if (bookDetails.getAmountAvailable() == 0) {
        sql = "SELECT * from book_borrowed WHERE book_id = :bookId ORDER BY end_date ASC";

        final MapSqlParameterSource parameterSourceBorrow = new MapSqlParameterSource();
        parameterSourceBorrow.addValue("bookId", bookDetails.getBookId());

        final RowMapper<BookBorrowed> bookBorrowedRowMapper = new BookBorrowedRM();

        try {
          List<BookBorrowed> bookBorrowedList = getNamedJdbcTemplate().query(sql, parameterSourceBorrow, bookBorrowedRowMapper);
          if (!bookBorrowedList.isEmpty()) {
            bookDetails.setEndBorrowDate(bookBorrowedList.get(0).getEndDate());
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

      // Get the amount of reservation for this book if quantity of book is = 0
      if (bookDetails.getAmountAvailable() == 0) {
        sql = "SELECT COUNT(*) from book_reservation WHERE book_id = :bookId AND active_reservation = true";

        final MapSqlParameterSource parameterSourceCount = new MapSqlParameterSource();
        parameterSourceCount.addValue("bookId", bookDetails.getBookId());

        try {
          int count = getNamedJdbcTemplate().queryForObject(sql, parameterSourceCount, Integer.class);
          bookDetails.setNbActiveReservations(count);
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
    }

    return bookDetailsDtoList;
  }

  /** {@inheritDoc} */
  @Override
  public List<BookDetailsDto> getSearchBookDetailsList(
      final BooksSearchClientCriteriaDto booksSearchClientCriteriaDto)
      throws TechnicalException, NotFoundException {

    if (LOG.isDebugEnabled()) {
      LOG.debug("SEARCH : " + booksSearchClientCriteriaDto.toString());
    }

    final MapSqlParameterSource parameterSource = new MapSqlParameterSource();

    sql =
        "SELECT book.book_id, book.title, book.isbn13, book.ean13, book.publishing_date, book.resume, book.genre_id, book.publisher_id, publisher.name as publisher_name, genre.name as genre_name, stock.amount_available as amount_available FROM book INNER JOIN publisher ON publisher.publisher_id = book.publisher_id INNER JOIN genre ON genre.genre_id = book.genre_id INNER JOIN stock ON book.book_id = stock.book_id";

    if (booksSearchClientCriteriaDto != null) {

      if (!StringUtils.isEmpty(booksSearchClientCriteriaDto.getAuthorLastName())) {
        sql =
            sql
                + " INNER JOIN book_authors ON book_authors.book_id = book.book_id INNER JOIN author ON author.author_id = book_authors.author_id WHERE UPPER(author.last_name) LIKE UPPER(:lastName)";
        final String lastName = "%" + booksSearchClientCriteriaDto.getAuthorLastName() + "%";
        parameterSource.addValue("lastName", lastName);
      } else {
        sql = sql + " WHERE 1=1";
      }

      if (!StringUtils.isEmpty(booksSearchClientCriteriaDto.getTitle())) {
        sql = sql + " AND UPPER(book.title) LIKE UPPER(:title)";
        final String title = "%" + booksSearchClientCriteriaDto.getTitle() + "%";
        parameterSource.addValue("title", title);
      }

      if (!StringUtils.isEmpty(booksSearchClientCriteriaDto.getEan13())) {
        sql = sql + " AND book.ean13 = :ean13";
        parameterSource.addValue("ean13", booksSearchClientCriteriaDto.getEan13());
      }

      if (!StringUtils.isEmpty(booksSearchClientCriteriaDto.getGenreName())) {
        sql = sql + " AND UPPER(genre.name) LIKE UPPER(:genreName)";
        final String genreName = "%" + booksSearchClientCriteriaDto.getGenreName() + "%";
        parameterSource.addValue("genreName", genreName);
      }

      if (!StringUtils.isEmpty(booksSearchClientCriteriaDto.getPublisherName())) {
        sql = sql + " AND UPPER(publisher.name) LIKE UPPER(:publisherName)";
        final String publisherName = "%" + booksSearchClientCriteriaDto.getPublisherName() + "%";
        parameterSource.addValue("publisherName", publisherName);
      }

      if (booksSearchClientCriteriaDto.getBookAvailable() != null
          && booksSearchClientCriteriaDto.getBookAvailable() == true) {
        sql = sql + " AND stock.amount_available > 0";
      }
    }

    final RowMapper<BookDetailsDto> rowMapper = new BookDetailsDtoRM();

    List<BookDetailsDto> bookDetailsDtoList;

    try {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("search = " + booksSearchClientCriteriaDto.toString());
      }
      bookDetailsDtoList = this.getNamedJdbcTemplate().query(sql, parameterSource, rowMapper);
      if (bookDetailsDtoList.isEmpty()) {
        throw new NotFoundException(
            messages.getString("bookDao.getSearchBookDetailsList.notFound"));
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

    for (BookDetailsDto bookDetails : bookDetailsDtoList) {
      sql =
          "SELECT * from author INNER JOIN book_authors ON author.author_id = book_authors.author_id WHERE book_authors.book_id = :book_id";

      final MapSqlParameterSource parameterSourceAuthor = new MapSqlParameterSource();
      parameterSourceAuthor.addValue("book_id", bookDetails.getBookId());

      final RowMapper<Author> authorRowMapper = new AuthorRM();

      try {
        if (LOG.isDebugEnabled()) {
          LOG.debug("SQL author: " + sql);
        }
        List<Author> authorList =
            getNamedJdbcTemplate().query(sql, parameterSourceAuthor, authorRowMapper);
        if (authorList.isEmpty()) {
          authorList = new ArrayList<>();
        }
        bookDetails.setAuthors(authorList);
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

      // Get the end date of borrow if quantity of book is = 0
      if (bookDetails.getAmountAvailable() == 0) {
        sql = "SELECT * from book_borrowed WHERE book_id = :bookId ORDER BY end_date ASC";

        final MapSqlParameterSource parameterSourceBorrow = new MapSqlParameterSource();
        parameterSourceBorrow.addValue("bookId", bookDetails.getBookId());

        final RowMapper<BookBorrowed> bookBorrowedRowMapper = new BookBorrowedRM();

        try {
          List<BookBorrowed> bookBorrowedList = getNamedJdbcTemplate().query(sql, parameterSourceBorrow, bookBorrowedRowMapper);
          if (!bookBorrowedList.isEmpty()) {
            bookDetails.setEndBorrowDate(bookBorrowedList.get(0).getEndDate());
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

      // Get the amount of reservation for this book if quantity of book is = 0
      if (bookDetails.getAmountAvailable() == 0) {
        sql = "SELECT COUNT(*) from book_reservation WHERE book_id = :bookId AND active_reservation = true";

        final MapSqlParameterSource parameterSourceCount = new MapSqlParameterSource();
        parameterSourceCount.addValue("bookId", bookDetails.getBookId());

        try {
          int count = getNamedJdbcTemplate().queryForObject(sql, parameterSourceCount, Integer.class);
          bookDetails.setNbActiveReservations(count);
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
    }
    return bookDetailsDtoList;
  }

  /** {@inheritDoc} */
  @Override
  public void updateBook(final Book book) throws TechnicalException, NotFoundException {

    sql =
        "UPDATE book SET book_id = :bookId, title = :title, isbn13 = :isbn13, ean13 = :ean13, publishing_date = :publishingDate, resume = :resume, genre_id = :genreId, publisher_id = :publisherId WHERE book_id = :bookId";

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
