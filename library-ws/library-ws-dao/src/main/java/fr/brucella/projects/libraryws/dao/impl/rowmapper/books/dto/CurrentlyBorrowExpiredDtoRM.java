package fr.brucella.projects.libraryws.dao.impl.rowmapper.books.dto;

import fr.brucella.projects.libraryws.entity.books.dto.CurrentlyBorrowExpiredDto;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 * This class allow to map row of ResultSet to an CurrentlyBorrowExpiredDto object.
 *
 * @author BRUCELLA2
 */
public class CurrentlyBorrowExpiredDtoRM implements RowMapper<CurrentlyBorrowExpiredDto> {

  /** Default Constructor */
  public CurrentlyBorrowExpiredDtoRM() {
  }


  @Override
  public CurrentlyBorrowExpiredDto mapRow(ResultSet resultSet, int i) throws SQLException {

    final CurrentlyBorrowExpiredDto currentlyBorrowExpiredDto = new CurrentlyBorrowExpiredDto();

    currentlyBorrowExpiredDto.setBookId(resultSet.getInt("book_id"));
    currentlyBorrowExpiredDto.setBorrowDate(resultSet.getDate("borrow_date").toLocalDate());
    currentlyBorrowExpiredDto.setEmail(resultSet.getString("email"));
    currentlyBorrowExpiredDto.setEndDate(resultSet.getDate("end_date").toLocalDate());
    if (resultSet.getDate("last_reminder") == null) {
      currentlyBorrowExpiredDto.setLastReminder(null);
    } else {
      currentlyBorrowExpiredDto.setLastReminder(resultSet.getDate("last_reminder").toLocalDate());
    }
    currentlyBorrowExpiredDto.setLogin(resultSet.getString("login"));
    currentlyBorrowExpiredDto.setNbReminder(resultSet.getInt("nb_reminder"));
    currentlyBorrowExpiredDto.setTitle(resultSet.getString("title"));
    currentlyBorrowExpiredDto.setUserId(resultSet.getInt("user_id"));

    return currentlyBorrowExpiredDto;
  }
}
