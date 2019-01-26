package fr.brucella.projects.libraryws.dao.impl.rowmapper.books.model;

import fr.brucella.projects.libraryws.entity.books.model.BookReservation;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 * This class allow to map row of ResultSet to an ReservationDetailsDto object.
 *
 * @author BRUCELLA2
 */
public class BookReservationRM implements RowMapper<BookReservation> {

  /** Default Constructor. */
  public BookReservationRM() {}

  @Override
  public BookReservation mapRow(final ResultSet resultSet, final int rowNum) throws SQLException {

    final BookReservation bookReservation = new BookReservation();

    bookReservation.setBookReservationId(resultSet.getInt("book_reservation_id"));
    bookReservation.setBookId(resultSet.getInt("book_id"));
    bookReservation.setUserId(resultSet.getInt("user_id"));
    if (resultSet.getDate("date_reservation") != null) {
      bookReservation.setDateReservation(resultSet.getTimestamp("date_reservation").toLocalDateTime());
    } else {
      bookReservation.setDateReservation(null);
    }
    if (resultSet.getDate("date_reservation_email_send") != null) {
      bookReservation.setDateReservationEmailSend(resultSet.getTimestamp("date_reservation_email_send").toLocalDateTime());
    } else {
      bookReservation.setDateReservationEmailSend(null);
    }
    bookReservation.setActiveReservation(resultSet.getBoolean("active_reservation"));

    return bookReservation;
  }
}
