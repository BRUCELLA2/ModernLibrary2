package fr.brucella.projects.libraryws.business.contracts.managers.books;

import fr.brucella.projects.libraryws.entity.books.dto.BookBorrowsCountDto;
import fr.brucella.projects.libraryws.entity.books.dto.BookDetailsDto;
import fr.brucella.projects.libraryws.entity.books.dto.BookStockDto;
import fr.brucella.projects.libraryws.entity.books.dto.BorrowDto;
import fr.brucella.projects.libraryws.entity.books.model.Book;
import fr.brucella.projects.libraryws.entity.exceptions.FunctionalException;
import fr.brucella.projects.libraryws.entity.exceptions.TechnicalException;
import fr.brucella.projects.libraryws.entity.users.model.User;
import java.util.List;

/**
 * Inferface for Books Management Manager
 *
 * @author BRUCELLA2
 */
public interface BooksManagementManager {

  /**
   * Provides the list of all users with a borrow not returned with deadline expired.
   *
   * @return the list of all users with a borrow not returned with deadline expired.
   * @throws TechnicalException - wraps technical exception caused during data access.
   */
  List<User> getUsersDeadlineExpired() throws TechnicalException;

  /**
   * Send a reminder email to all users with a borrow not returned with deadline expired.
   *
   * @throws TechnicalException - wraps technical exception caused during data access.
   */
  void reminderToUsers() throws TechnicalException;

  /**
   * Get the list of reservation without borrow in the time allowed.
   * Cancel the reservation in this list and send an email to the next user in the active reservation list for the book.
   *
   * @Return the nb of error - 0 if they is no problem.
   * @throws TechnicalException
   */
  int reservationNotBorrowInTime() throws TechnicalException;

  /**
   * Provides the list of stocks and title of book.
   *
   * @return the list of stocks and title of book.
   * @throws TechnicalException - wraps technical exception caused during data access.
   */
  List<BookStockDto> getStocksList() throws TechnicalException;

  /**
   * Provides the borrows history.
   *
   * @return the borrows history sorted by date of borrow.
   * @throws TechnicalException - wraps technical exception caused during data access.
   */
  List<BorrowDto> getBorrowsHistory() throws TechnicalException;

  /**
   * Provides the list of number of borrowings for each book.
   *
   * @return the list of number of borrowings for each book.
   * @throws TechnicalException - wraps technical exception caused during data access.
   */
  List<BookBorrowsCountDto> getNbBorrowsByBooks() throws TechnicalException;

  /**
   * Add the borrow of the book with the book id for the user with the user id.
   *
   * @param bookId id of the book.
   * @param userId id of the user who borrow the book.
   * @return the id of the BookBorrowed.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws FunctionalException - This exception is throw if the id of the user or the id of the
   *     book are not valid or if the stock for this book is not found or not < 1.
   */
  Integer bookBorrowing(final Integer bookId, final Integer userId)
      throws TechnicalException, FunctionalException;

  /**
   * Extends a book borrowing.
   *
   * @param bookBorrowedId id of the bookBorrowed.
   * @return true if extend success. Throw exception if extend fail.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws FunctionalException - This exception is throw if the id of the bookBorrowed is not
   *     valid. This exception is throw if the bookBorrowed is not found. This exception is throw if
   *     the book is already returned, if end date of borrow is passed and if the bookBorrowed is
   *     already extended
   */
  Boolean extendBorrow(final Integer bookBorrowedId) throws TechnicalException, FunctionalException;

  /**
   * Tag the bookBorrowed as return.
   *
   * @param bookBorrowedId id of the bookBorrowed.
   * @return true if return success. Throw exception if return fail.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws FunctionalException - This exception is throw if the id of the bookBorrowed is not
   *     valid. This exception is throw if the bookBorrowed is not found. This exception is throw if
   *     the book is already returned.
   */
  Boolean returnBorrow(final Integer bookBorrowedId) throws TechnicalException, FunctionalException;

  /**
   * Provides the book details.
   *
   * @param bookId id of the book
   * @return the book with details (BookDetailsDTO)
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws FunctionalException - This exception is throw if the id of the book is not valid. This
   *     exception is throw if the book is not found.
   */
  BookDetailsDto getBookWithDetails(final Integer bookId)
      throws TechnicalException, FunctionalException;

  /**
   * Add a reservation of a book with the book id for the user with the user id.
   *
   * @param bookId id of the book.
   * @param userId id of the user who borrow the book.
   * @return the id of the BookReservation.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws FunctionalException - This exception is throw if the id of the user or the id of the
   *     book are not valid or if the maximum number of reservations has been reached or that the user has already reserved the book..
   */
  Integer bookReservation(final Integer bookId, final Integer userId) throws TechnicalException, FunctionalException;

  /**
   * Cancel the reservation of the book with the bookReservation Id. Set activeReservation property to false.
   *
   * @param bookReservationId the bookReservation Id
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws FunctionalException - This exception is throw if the id of the bookReservation is not valid. This
   *     exception is throw if the bookReservation is not found.
   */
  void cancelReservation(final Integer bookReservationId) throws TechnicalException, FunctionalException;

  /**
   * Send email to the first user of the reservation list to tell him book is available. Book reservation is updated with date of email sending.
   *
   * @param book Book reserved and available.
   * @throws TechnicalException - wraps technical exception.
   * @throws FunctionalException - This exception is throw if the book is null or if the bookReservation is not found.
   */
  void sendMailBookAvailable(Book book) throws TechnicalException, FunctionalException;

}
