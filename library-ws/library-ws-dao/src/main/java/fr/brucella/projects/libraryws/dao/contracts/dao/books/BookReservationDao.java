package fr.brucella.projects.libraryws.dao.contracts.dao.books;

import fr.brucella.projects.libraryws.entity.books.dto.ReservationDetailsDto;
import fr.brucella.projects.libraryws.entity.books.model.BookReservation;
import fr.brucella.projects.libraryws.entity.exceptions.NotFoundException;
import fr.brucella.projects.libraryws.entity.exceptions.TechnicalException;
import java.time.LocalDate;
import java.util.List;

/**
 * Interface for bookReservation Data Access Object.
 *
 * @author BRUCELLA2
 */
public interface BookReservationDao {

  /**
   * Give the bookReservation with the specified id from the datastore.
   *
   * @param bookReservationId id of the book reservation.
   * @return the bookReservation with the id of the book reservation.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and the
   *     book reservation is not found.
   */
  BookReservation getBookReservation(final Integer bookReservationId)
      throws TechnicalException, NotFoundException;

  /**
   * Give the active bookReservation for the user with userId and the book with bookId from the
   * datastore.
   *
   * @param bookId id of the book reservation.
   * @param userId id of the user reservation.
   * @return the active bookReservation for the user with userId and the book with bookId
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and the
   *     book reservation is not found.
   */
  BookReservation getBookReservation(final Integer bookId, final Integer userId)
      throws TechnicalException, NotFoundException;

  /**
   * Give the list of all reservations (active or not) from the datastore. ORDER BY date_reservation
   * ASC.
   *
   * @return the list of all reservations (active or not) from the datastore.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and no
   *     reservation is found.
   */
  List<BookReservation> getReservationsList() throws TechnicalException, NotFoundException;

  /**
   * Give the list of active reservations from the datastore. ORDER BY date_reservation ASC.
   *
   * @return the list of active reservations from the datastore.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and no
   *     reservation is found.
   */
  List<BookReservation> getActiveReservationsList() throws TechnicalException, NotFoundException;

  /**
   * Give the list of active reservations for the book specified with the bookId from the datastore.
   * ORDER BY date_reservation ASC.
   *
   * @param bookId id of the book.
   * @return The list of active BookReservation for a specific book.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and no
   *     reservation is found.
   */
  List<BookReservation> getActiveReservationListForBook(final Integer bookId)
      throws TechnicalException, NotFoundException;

  /**
   * Give the list of active reservations without borrow in time (Afer sending email, user have a
   * delay to borrow the book). Order by date_reservation_email_send ASC
   *
   * @param dateDepassed before this date, an active reservation is out of time.
   * @return the list of active reservations without borrow in time
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and no
   *     reservation is found.
   */
  List<BookReservation> getActiveReservationWithoutBorrowInTime(final LocalDate dateDepassed)
      throws TechnicalException, NotFoundException;

  /**
   * Give the list of active reservations for the user. ORDER BY date_reservation ASC.
   *
   * @param userId id of the user.
   * @return A list of active ReservationDetailsDto for a specific user.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and no
   *     reservation is found.
   */
  List<ReservationDetailsDto> getActiveReservationsListForUser(final Integer userId)
      throws TechnicalException, NotFoundException;

  /**
   * Give the list of inactive reservations for the user. ORDER BY date_reservation ASC.
   *
   * @param userId id of the user.
   * @return A list of inactive ReservationDetailsDto for a specific user.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and no
   *     reservation is found.
   */
  List<ReservationDetailsDto> getInactiveReservationsListForUser(final Integer userId)
      throws TechnicalException, NotFoundException;

  /**
   * Update an existing bookReservation in the datastore.
   *
   * @param bookReservation bookReservation with the updated informations to save ub datastore.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and the
   *     book reservation is not found.
   */
  void updateBookReservation(final BookReservation bookReservation)
      throws TechnicalException, NotFoundException;

  /**
   * Insert a new bookReservation in the datastore.
   *
   * @param bookReservation the bookReservation to insert in datastore.
   * @return the id of the new bookReservation added.
   * @throws TechnicalException - wraps technical exception caused during data access.
   */
  Integer insertBookReservation(final BookReservation bookReservation) throws TechnicalException;

  /**
   * Delete the bookReservation with the specified id in the datastore.
   *
   * @param bookReservationId id of the book reservation.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and the
   *     bookReservation is not found.
   */
  void deleteBookReservation(final Integer bookReservationId)
      throws TechnicalException, NotFoundException;
}
