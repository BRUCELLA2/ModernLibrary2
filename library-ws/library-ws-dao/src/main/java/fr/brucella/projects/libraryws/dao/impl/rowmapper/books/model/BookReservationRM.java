package fr.brucella.projects.libraryws.dao.impl.rowmapper.books.model;

import fr.brucella.projects.libraryws.entity.books.model.BookReservation;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

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
      bookReservation.setDateReservation(resultSet.getDate("date_reservation").toLocalDate());
    } else {
      bookReservation.setDateReservation(null);
    }
    if (resultSet.getDate("date_reservation_email_send") != null) {
      bookReservation.setDateReservationEmailSend(resultSet.getDate("date_reservation_email_send").toLocalDate());
    } else {
      bookReservation.setDateReservationEmailSend(null);
    }
    bookReservation.setActiveReservation(resultSet.getBoolean("active_reservation"));

    return bookReservation;
  }
}
