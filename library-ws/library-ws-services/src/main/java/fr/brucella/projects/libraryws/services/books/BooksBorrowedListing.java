package fr.brucella.projects.libraryws.services.books;

import fr.brucella.projects.libraryws.business.contracts.ManagerFactory;
import fr.brucella.projects.libraryws.entity.books.Book;
import fr.brucella.projects.libraryws.entity.users.User;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 * Books Listing Web Service focused on currently borrowed books.
 *
 * @author BRUCELLA2
 */
@WebService(serviceName = "BooksBorrowedListing")
public class BooksBorrowedListing extends SpringBeanAutowiringSupport {

  /**
   * Books Borrowed Listing logger.
   */
  private static final Log LOG = LogFactory.getLog(BooksBorrowedListing.class);

  /**
   * List of books returned by the Web Service.
   */
  private List<Book> bookList;

  // ----- Manager
  /**
   * The Manager Factory Manager Factory allow to get and set business managers.
   */
  @Autowired
  private ManagerFactory managerFactory;



  // ===== Methods =====


  /**
   * Provides the list of books currently borrowed.
   *
   * @return the list of books currently borrowed.
   */
  @WebMethod
  public List<Book> currentlyBooksBorrowedList() {
    return null;
  }

  /**
   * Provides the list of books currently borrowed by the user.
   *
   * @param userId id of the user.
   * @return the list of books currently borrowed by the user.
   */
  @WebMethod
  public List<Book> currentlyBorrowForUser(User userId) {
    return null;
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
  public List<Book> currentlyDeadLineExpiredForUser(User userId) {
    return null;
  }

  /*
  @WebMethod
  public String testInjection() {
    String test = managerFactory.getBooksBorrowedListingManager().test();
    //String test = "test";
    return test;
  }*/
}
