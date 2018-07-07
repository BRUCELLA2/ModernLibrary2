package fr.brucella.projects.libraryws.dao.contracts.dao.books;

import fr.brucella.projects.libraryws.entity.books.model.BookBorrowed;
import fr.brucella.projects.libraryws.entity.exceptions.NotFoundException;
import fr.brucella.projects.libraryws.entity.exceptions.TechnicalException;

/**
 * Interface for bookBorrowed Data Access Object.
 *
 * @author BRUCELLA2
 */
public interface BookBorrowedDao {

  /**
   * Give the bookBorrowed with the specified user id and book id from the datastore.
   *
   * @param userId id of the user who borrow the book.
   * @param bookId id of the book borrowed by the user.
   * @return the bookBorrowed with the user id and book id specified.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and the
   *     author is not found.
   */
  BookBorrowed getBookBorrowed(final Integer userId, final Integer bookId)
      throws TechnicalException, NotFoundException;

  /**
   * Update an existing bookBorrowed in the datastore.
   *
   * @param bookBorrowed bookBorrowed with the updated informations to save in datastore.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and the
   *     author is not found.
   */
  void updateBookBorrowed(final BookBorrowed bookBorrowed)
      throws TechnicalException, NotFoundException;

  /**
   * Insert a new bookBorrowed in the datastore.
   *
   * @param bookBorrowed the bookBorrowed to insert in datastore.
   * @throws TechnicalException - wraps technical exception caused during data access.
   */
  void insertBookBorrowed(final BookBorrowed bookBorrowed) throws TechnicalException;

  /**
   * Delete the bookBorrowed with the specified user id and book id in the datastore.
   *
   * @param userId id of the user who borrow the book.
   * @param bookId id of the book borrowed by the user.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and the
   *     author is not found.
   */
  void deleteBookBorrowed(final Integer userId, final Integer bookId)
      throws TechnicalException, NotFoundException;
}
