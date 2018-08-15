package fr.brucella.projects.libraryws.dao.impl.rowmapper.books.dto;

import fr.brucella.projects.libraryws.entity.books.dto.BorrowDto;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 * This class allow to map row of ResultSet to an BorrowDto object.
 *
 * @author BRUCELLA2
 */
public class BorrowDtoRM implements RowMapper<BorrowDto> {

  /** Default Constructor */
  public BorrowDtoRM() {}

  /** {@inheritDoc} */
  @Override
  public BorrowDto mapRow(final ResultSet resultSet, final int rowNum) throws SQLException {

    final BorrowDto borrowDto = new BorrowDto();

    borrowDto.setBookBorrowedId(resultSet.getInt("book_borrowed_id"));
    borrowDto.setBorrowDate(resultSet.getDate("borrow_date").toLocalDate());
    borrowDto.setTitle(resultSet.getString("title"));
    borrowDto.setBookId(resultSet.getInt("book_id"));
    borrowDto.setLogin(resultSet.getString("login"));
    borrowDto.setEndDate(resultSet.getDate("end_date").toLocalDate());
    borrowDto.setExtension(resultSet.getBoolean("extension"));
    if (resultSet.getDate("last_reminder") == null) {
      borrowDto.setLastReminder(null);
    } else {
      borrowDto.setLastReminder(resultSet.getDate("last_reminder").toLocalDate());
    }
    borrowDto.setNbReminder(resultSet.getInt("nb_reminder"));
    borrowDto.setReturned(resultSet.getBoolean("returned"));
    borrowDto.setUserId(resultSet.getInt("user_id"));

    return borrowDto;
  }
}
