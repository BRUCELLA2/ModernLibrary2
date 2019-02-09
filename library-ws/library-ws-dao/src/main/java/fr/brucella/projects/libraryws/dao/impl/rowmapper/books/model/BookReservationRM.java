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
  public BookReservationRM() {
    // This constructor is intentionally empty.
  }

  /** {@inheritDoc} */
  @Override
  public BookReservation mapRow(final ResultSet resultSet, final int rowNum) throws SQLException {

    final BookReservation bookReservation = new BookReservation();

    bookReservation.setBookReservationId(resultSet.getInt("book_reservation_id"));
    bookReservation.setBookId(resultSet.getInt("book_id"));
    bookReservation.setUserId(resultSet.getInt("user_id"));
    if (resultSet.getDate("date_reservation") == null) {
      bookReservation.setDateReservation(null);
    } else {
      bookReservation.setDateReservation(
          resultSet.getTimestamp("date_reservation").toLocalDateTime());
    }
    if (resultSet.getDate("date_reservation_email_send") == null) {
      bookReservation.setDateReservationEmailSend(null);
    } else {
      bookReservation.setDateReservationEmailSend(
          resultSet.getTimestamp("date_reservation_email_send").toLocalDateTime());
    }
    bookReservation.setActiveReservation(resultSet.getBoolean("active_reservation"));

    return bookReservation;
  }
}
