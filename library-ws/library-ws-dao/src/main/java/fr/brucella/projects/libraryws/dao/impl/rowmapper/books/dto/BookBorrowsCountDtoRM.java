package fr.brucella.projects.libraryws.dao.impl.rowmapper.books.dto;

import fr.brucella.projects.libraryws.entity.books.dto.BookBorrowsCountDto;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 * This class allow to map row of ResultSet to an BookBorrowsCountDto object.
 *
 * @author BRUCELLA2
 */
public class BookBorrowsCountDtoRM implements RowMapper<BookBorrowsCountDto> {

  /** Default Constructor */
  public BookBorrowsCountDtoRM() {
    // This constructor is intentionally empty. Nothing special is needed here.
  }

  /** {@inheritDoc} */
  @Override
  public BookBorrowsCountDto mapRow(final ResultSet resultSet, final int rowNum)
      throws SQLException {

    final BookBorrowsCountDto bookBorrowsCountDto = new BookBorrowsCountDto();

    bookBorrowsCountDto.setBookId(resultSet.getInt("book_id"));
    bookBorrowsCountDto.setNbBorrows(resultSet.getInt("nb_borrows"));
    bookBorrowsCountDto.setTitle(resultSet.getString("title"));

    return bookBorrowsCountDto;
  }
}
