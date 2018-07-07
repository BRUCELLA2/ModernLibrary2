package fr.brucella.projects.libraryws.dao.impl.rowmapper.books;

import fr.brucella.projects.libraryws.entity.books.model.Book;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 * This class allow to map row of ResultSet to an Book object.
 *
 * @author BRUCELLA2
 */
public class BookRM implements RowMapper<Book> {

  @Override
  public Book mapRow(final ResultSet resultSet, final int rowNum) throws SQLException {

    final Book book = new Book();

    book.setBookId(resultSet.getInt("book_id"));
    book.setEan13(resultSet.getString("ean13"));
    book.setGenreId(resultSet.getInt("genre_id"));
    book.setIsbn13(resultSet.getString("isbn13"));
    book.setPublisherId(resultSet.getInt("publisher_id"));
    book.setPublishingDate(resultSet.getDate("publishind_date").toLocalDate());
    book.setResume(resultSet.getString("resume"));
    book.setTitle(resultSet.getString("title"));

    return book;
  }
}
