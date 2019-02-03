package fr.brucella.projects.libraryws.dao.impl.rowmapper.books.dto;

import fr.brucella.projects.libraryws.entity.books.dto.ReservationDetailsDto;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;


/**
 * This class allow to map row of ResultSet to an ReservationDetailsDto object.
 *
 * @author BRUCELLA2
 */
public class ReservationDetailsDtoRM implements RowMapper<ReservationDetailsDto> {


  public ReservationDetailsDtoRM() {}


  @Override
  public ReservationDetailsDto mapRow(final ResultSet resultSet, int rowNum) throws SQLException {

    final ReservationDetailsDto reservationDetailsDto = new ReservationDetailsDto();

    reservationDetailsDto.setBookReservationId(resultSet.getInt("book_reservation_id"));
    reservationDetailsDto.setBookId(resultSet.getInt("book_id"));
    reservationDetailsDto.setUserId(resultSet.getInt("user_id"));
    if (resultSet.getDate("date_reservation") != null) {
      reservationDetailsDto.setDateReservation(resultSet.getTimestamp("date_reservation").toLocalDateTime());
    } else {
      reservationDetailsDto.setDateReservation(null);
    }
    if (resultSet.getDate("date_reservation_email_send") != null) {
      reservationDetailsDto.setDateReservationEmailSend(resultSet.getTimestamp("date_reservation_email_send").toLocalDateTime());
    } else {
      reservationDetailsDto.setDateReservationEmailSend(null);
    }
    reservationDetailsDto.setActiveReservation(resultSet.getBoolean("active_reservation"));
    reservationDetailsDto.setTitle(resultSet.getString("title"));

    return reservationDetailsDto;
  }
}
