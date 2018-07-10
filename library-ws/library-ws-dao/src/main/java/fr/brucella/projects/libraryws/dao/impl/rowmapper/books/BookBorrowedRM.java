package fr.brucella.projects.libraryws.dao.impl.rowmapper.books;

import fr.brucella.projects.libraryws.entity.books.model.BookBorrowed;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 * This class allow to map row of ResultSet to an BookBorrowed object.
 *
 * @author BRUCELLA2
 */
public class BookBorrowedRM implements RowMapper<BookBorrowed> {

  /** Default Constructor */
  public BookBorrowedRM() {}

  /** {@inheritDoc} */
  @Override
  public BookBorrowed mapRow(final ResultSet resultSet, int rowNum) throws SQLException {

    final BookBorrowed bookBorrowed = new BookBorrowed();

    bookBorrowed.setBookId(resultSet.getInt("book_id"));
    bookBorrowed.setBorrowDate(resultSet.getDate("borrow_date").toLocalDate());
    bookBorrowed.setEndDate(resultSet.getDate("end_date").toLocalDate());
    bookBorrowed.setExtension(resultSet.getBoolean("extension"));
    bookBorrowed.setLastReminder(resultSet.getDate("last_reminder").toLocalDate());
    bookBorrowed.setNbReminder(resultSet.getInt("nb_reminder"));
    bookBorrowed.setReturned(resultSet.getBoolean("returned"));
    bookBorrowed.setUserId(resultSet.getInt("user_id"));

    return bookBorrowed;
  }
}
