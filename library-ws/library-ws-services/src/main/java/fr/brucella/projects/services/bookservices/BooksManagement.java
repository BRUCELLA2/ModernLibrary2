package fr.brucella.projects.services.bookservices;

import fr.brucella.projects.libraryws.entity.books.Book;
import fr.brucella.projects.libraryws.entity.books.BookStock;
import fr.brucella.projects.libraryws.entity.books.Borrowing;
import fr.brucella.projects.libraryws.entity.users.User;
import java.util.List;
import java.util.Map;
import javax.jws.WebMethod;
import javax.jws.WebService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Books Management Web Service. Return various list use for books management.
 *
 * @author BRUCELLA2
 */
@WebService(serviceName = "BooksManagement")
public class BooksManagement {

  /**
   * Books Management logger.
   */
  private static final Log LOG = LogFactory.getLog(BooksManagement.class);

  /**
   * List of users.
   */
  private List<User> usersList;



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
  public List<Borrowing> borrowingHistoryList() {
    return null;
  }

  /**
   * Provides the list of number of borrowings for each book.
   *
   * @return the list of number of borrowings for each book.
   */
  @WebMethod
  public List<Map<Book,Integer>> nbBorrowingByBooks() {
    return null;
  }
}
