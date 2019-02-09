package fr.brucella.projects.libraryws.dao.contracts.dao.books;

import fr.brucella.projects.libraryws.entity.books.dto.BookBorrowsCountDto;
import fr.brucella.projects.libraryws.entity.books.dto.BorrowDto;
import fr.brucella.projects.libraryws.entity.books.dto.CurrentlyBorrowExpiredDto;
import fr.brucella.projects.libraryws.entity.books.dto.UserCurrentlyBorrowDto;
import fr.brucella.projects.libraryws.entity.books.model.BookBorrowed;
import fr.brucella.projects.libraryws.entity.exceptions.NotFoundException;
import fr.brucella.projects.libraryws.entity.exceptions.TechnicalException;
import java.util.List;

/**
 * Interface for bookBorrowed Data Access Object.
 *
 * @author BRUCELLA2
 */
public interface BookBorrowedDao {

  /**
   * Give the bookBorrowed with the specified id from the datastore.
   *
   * @param bookBorrowedId id of the book borrowed.
   * @return the bookBorrowed with the user id and book id specified.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and the
   *     book borrowed is not found.
   */
  BookBorrowed getBookBorrowed(final Integer bookBorrowedId)
      throws TechnicalException, NotFoundException;

  /**
   * Give the list of borrow with for each borrow the login of the user and the title of the book.
   *
   * @param currently true if need only currently borrow.
   * @return A list of Borrow Data Transfert Object.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and no
   *     borrow is found.
   */
  List<BorrowDto> getBorrowListWithUserLoginAndTitle(final Boolean currently)
      throws TechnicalException, NotFoundException;

  /**
   * Give the list of informations about currently borrows by the user.
   *
   * @param userId id of the user.
   * @param currently true if need only currently borrow.
   * @return A list of Borrow Data Transfert Object.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and no
   *     borrows is found.
   */
  List<BorrowDto> getUserBorrows(final Integer userId, final Boolean currently)
      throws TechnicalException, NotFoundException;

  /**
   * Give the list of informations about borrow expired, book borrowed and user who make the borrow.
   *
   * @return the list of informations about borrow expired, book borrowed and user who make the
   *     borrow.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and no
   *     borrow is found.
   */
  List<CurrentlyBorrowExpiredDto> getBorrowExpired() throws TechnicalException, NotFoundException;

  /**
   * Give the list of informations about currently borrow expired for the user.
   *
   * @param userId id of the user.
   * @return the list of informations about currently borrow expired for the user.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and no
   *     borrows is found.
   */
  List<UserCurrentlyBorrowDto> getUserBorrowsExpired(final Integer userId)
      throws TechnicalException, NotFoundException;

  /**
   * Give the list of informations about borrows by the user almost expired.
   *
   * @param userId id of the user.
   * @param nbDaysBeforeReminder the number of days before the end of borrows.
   * @return The list of Borrow Data Transfert Object.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and no
   *     borrows is found.
   */
  List<BorrowDto> getBorrowsAlmostExpiredForUser(
      final Integer userId, final Integer nbDaysBeforeReminder)
      throws TechnicalException, NotFoundException;

  /**
   * Give the list of borrows pas and present.
   *
   * @return the list of borrows pas and present.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and no
   *     borrows is found.
   */
  List<BorrowDto> getAllBorrows() throws TechnicalException, NotFoundException;

  /**
   * Give the list of number of borrowings for each book (with some informations about the book).
   *
   * @return the list of number of borrowings for each book (with some informations about the book).
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and no
   *     borrows is found.
   */
  List<BookBorrowsCountDto> countBorrowsByBook() throws TechnicalException, NotFoundException;

  /**
   * Update an existing bookBorrowed in the datastore.
   *
   * @param bookBorrowed bookBorrowed with the updated informations to save in datastore.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and the
   *     bookBorrowed is not found.
   */
  void updateBookBorrowed(final BookBorrowed bookBorrowed)
      throws TechnicalException, NotFoundException;

  /**
   * Insert a new bookBorrowed in the datastore.
   *
   * @param bookBorrowed the bookBorrowed to insert in datastore.
   * @return the id of the new book Borrowed added.
   * @throws TechnicalException - wraps technical exception caused during data access.
   */
  Integer insertBookBorrowed(final BookBorrowed bookBorrowed) throws TechnicalException;

  /**
   * Delete the bookBorrowed with the specified id in the datastore.
   *
   * @param bookBorrowedId id of the book borrowed.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and the
   *     bookBorrowed is not found.
   */
  void deleteBookBorrowed(final Integer bookBorrowedId)
      throws TechnicalException, NotFoundException;
}
