package fr.brucella.projects.libraryws.dao.impl.rowmapper.books.dto;

import fr.brucella.projects.libraryws.entity.books.dto.BookDetailsDto;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 * This class allow to map row of ResultSet to an BookDetailsDto object. The list of authors of the
 * BookDetailsDto is set to null. An update of the BookDetailsDto is necessary after row mapping to
 * set the list of authors.
 *
 * @author BRUCELLA2
 */
public class BookDetailsDtoRM implements RowMapper<BookDetailsDto> {

  /** Default Constructor */
  public BookDetailsDtoRM() {}

  @Override
  public BookDetailsDto mapRow(final ResultSet resultSet, final int rowNum) throws SQLException {

    final BookDetailsDto bookDetailsDto = new BookDetailsDto();

    bookDetailsDto.setAuthors(null);
    bookDetailsDto.setGenreName(resultSet.getString("genre_name"));
    bookDetailsDto.setPublisherName(resultSet.getString("publisher_name"));
    bookDetailsDto.setBookId(resultSet.getInt("book_id"));
    bookDetailsDto.setEan13(resultSet.getString("ean13"));
    bookDetailsDto.setGenreId(resultSet.getInt("genre_id"));
    bookDetailsDto.setIsbn13(resultSet.getString("isbn13"));
    bookDetailsDto.setPublisherId(resultSet.getInt("publisher_id"));
    bookDetailsDto.setPublishingDate(resultSet.getDate("publishing_date").toLocalDate());
    bookDetailsDto.setResume(resultSet.getString("resume"));
    bookDetailsDto.setTitle(resultSet.getString("title"));

    return bookDetailsDto;
  }
}
