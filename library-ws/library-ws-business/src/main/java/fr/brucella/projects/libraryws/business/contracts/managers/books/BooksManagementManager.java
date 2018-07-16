package fr.brucella.projects.libraryws.business.contracts.managers.books;

import fr.brucella.projects.libraryws.entity.books.dto.BookBorrowsCountDto;
import fr.brucella.projects.libraryws.entity.books.dto.BookStockDto;
import fr.brucella.projects.libraryws.entity.books.dto.BorrowDto;
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
}
