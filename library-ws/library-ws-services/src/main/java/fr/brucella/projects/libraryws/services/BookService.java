package fr.brucella.projects.libraryws.services;

import fr.brucella.projects.libraryws.business.contracts.ManagerFactory;
import fr.brucella.projects.libraryws.entity.books.dto.BookStock;
import fr.brucella.projects.libraryws.entity.books.dto.BorrowDto;
import fr.brucella.projects.libraryws.entity.books.dto.UserCurrentlyBorrowDto;
import fr.brucella.projects.libraryws.entity.books.model.Book;
import fr.brucella.projects.libraryws.entity.exceptions.FunctionalException;
import fr.brucella.projects.libraryws.entity.exceptions.LibraryWsException;
import fr.brucella.projects.libraryws.entity.exceptions.LibraryWsFault;
import fr.brucella.projects.libraryws.entity.exceptions.TechnicalException;
import fr.brucella.projects.libraryws.entity.searchcriteria.dto.BooksSearchingClientCriteria;
import fr.brucella.projects.libraryws.entity.users.model.User;
import java.util.HashMap;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 * Book Web Service (related to book details, books listing, books management).
 *
 * @author BRUCELLA2
 */
@WebService(serviceName = "BookService")
@Component
public class BookService extends SpringBeanAutowiringSupport {

  /** Book Service Logger */
  private static final Log LOG = LogFactory.getLog(BookService.class);

  // ----- Manager
  /** The Manager Factory Manager Factory allow to get and set business managers. */
  @Autowired private ManagerFactory managerFactory;

  // ===== WebMethods ===== //

  // ===== Books borrowed

  /**
   * Provides the list of currently borrows with login of the user and title of the book.
   *
   * @return the list of currently borrows with login of the user and title of the book.
   */
  @WebMethod
  public List<BorrowDto> currentlyBooksBorrowedList() throws LibraryWsException {

    try {

      return this.managerFactory.getBooksBorrowedListingManager().currentlyBooksBorrow();

    } catch (TechnicalException exception) {
      LOG.error(exception.getMessage());
      throw new LibraryWsException(
          "Problème technique", new LibraryWsFault("Server", exception.getMessage()));
    }
  }

  /**
   * Provides the list of books currently borrowed by the user.
   *
   * @param userId id of the user.
   * @return the list of books currently borrowed by the user.
   */
  @WebMethod
  public List<UserCurrentlyBorrowDto> currentlyBorrowForUser(final Integer userId)
      throws LibraryWsException {

    try {
      return this.managerFactory.getBooksBorrowedListingManager().userCurrentlyBorrow(userId);
    } catch (FunctionalException exception) {
      LOG.error(exception.getMessage());
      throw new LibraryWsException(
          "Erreur Fonctionnelle", new LibraryWsFault("Client", exception.getMessage()));
    } catch (TechnicalException exception) {
      LOG.error(exception.getMessage());
      throw new LibraryWsException(
          "Problème technique", new LibraryWsFault("Server", exception.getMessage()));
    }
  }

  /**
   * Provides the list of currently borrowed books which have an expired deadline.
   *
   * @return the list of currently borrowed books which have an expired deadline.
   */
  @WebMethod
  public List<Book> currentlyDeadlineExpired() {
    return null;
  }

  /**
   * Provides the list of currently borrowed books which have an expired deadline for the user.
   *
   * @param userId id of the user.
   * @return the list of currently borrowed books which have an expired deadline for the user.
   */
  @WebMethod
  public List<Book> currentlyDeadLineExpiredForUser(final User userId) {
    return null;
  }

  // ===== Books Listing

  /**
   * Provides the list of all books.
   *
   * @return the list of all books.
   */
  @WebMethod
  public List<Book> allBooks() {
    return null;
  }

  /**
   * Provides the list of books that meet the searching criteria.
   *
   * @param booksSearchingClientCriteria the book searching client criteria.
   * @return the list of books that meet the searching criteria.
   */
  @WebMethod
  public List<Book> booksSearchedList(
      final BooksSearchingClientCriteria booksSearchingClientCriteria) {
    return null;
  }

  /**
   * Provides the list of books which can be borrowed.
   *
   * @return the list of books which can be borrowed.
   */
  @WebMethod
  public List<Book> availableBooksList() {
    return null;
  }

  // ===== Books Management

  /**
   * Provides the list of users with currently borrow and deadline expired.
   *
   * @return the list of users with currently borrow and deadline expired.
   */
  @WebMethod
  public List<User> currentlyDeadlineExpiredUsers() {
    return null;
  }

  /**
   * Provides the list of stocks for each book.
   *
   * @return the list of stocks for each book.
   */
  @WebMethod
  public List<BookStock> bookStocksList() {
    return null;
  }

  /**
   * Provides the list of all borrow past and present.
   *
   * @return the list of all borrow past and present.
   */
  @WebMethod
  public List<BorrowDto> borrowingHistoryList() {
    return null;
  }

  /**
   * Provides the list of number of borrowings for each book.
   *
   * @return the list of number of borrowings for each book.
   */
  @WebMethod
  public List<HashMap<Book, Integer>> nbBorrowingByBooks() {
    return null;
  }

  // ===== Borrowings Management

  /**
   * Add a book borrowing.
   *
   * @param bookId id of the book borrowed.
   * @param userId id of the user who borrow the book.
   * @return id of the borrowing.
   */
  @WebMethod
  public Integer bookBorrow(final Integer bookId, final Integer userId) {
    return null;
  }

  /**
   * Extends a book borrowing.
   *
   * @param bookId id of the book borrowed.
   * @param userId id of the user who borrow the book.
   * @return true if extend success. false if extend fail.
   */
  @WebMethod
  public Boolean extendBorrowing(final Integer bookId, final Integer userId) {
    return null;
  }

  /**
   * Finished a book borrowing.
   *
   * @param bookId id of the book borrowed.
   * @param userId id of the user who borrowed the book.
   * @return true if the borrowing return if a success. False otherwise.
   */
  @WebMethod
  public Boolean borrowingReturn(final Integer bookId, final Integer userId) {
    return null;
  }

  // ===== Book Details

  /**
   * Return the book details.
   *
   * @param bookId id of the book.
   * @return the book details.
   */
  public Book bookDetails(final Integer bookId) {
    return null;
  }
}
