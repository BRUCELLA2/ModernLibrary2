package fr.brucella.projects.libraryws.dao.impl.rowmapper.books.dto;

import fr.brucella.projects.libraryws.entity.books.dto.UserCurrentlyBorrowDto;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 * This class allow to map row of ResultSet to an UserCurrentlyBorrowDto object.
 *
 * @author BRUCELLA2
 */
public class UserCurrentlyBorrowDtoRM implements RowMapper<UserCurrentlyBorrowDto> {

  /** Default Constructor */
  public UserCurrentlyBorrowDtoRM() {}

  /** {@inheritDoc} */
  @Override
  public UserCurrentlyBorrowDto mapRow(final ResultSet resultSet, int rowNum) throws SQLException {

    final UserCurrentlyBorrowDto userCurrentlyBorrowDto = new UserCurrentlyBorrowDto();

    userCurrentlyBorrowDto.setBookId(resultSet.getInt("book_id"));
    userCurrentlyBorrowDto.setBorrowDate(resultSet.getDate("borrow_date").toLocalDate());
    userCurrentlyBorrowDto.setEndDate(resultSet.getDate("end_date").toLocalDate());
    userCurrentlyBorrowDto.setExtension(resultSet.getBoolean("extension"));
    userCurrentlyBorrowDto.setTitle(resultSet.getString("title"));

    return userCurrentlyBorrowDto;
  }
}
