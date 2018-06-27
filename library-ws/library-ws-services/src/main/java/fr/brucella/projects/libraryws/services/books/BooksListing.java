package fr.brucella.projects.libraryws.services.books;

import fr.brucella.projects.libraryws.entity.books.Book;
import fr.brucella.projects.libraryws.entity.searchCriteria.BooksSearchingClientCriteria;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * General Books Listing Web Service. Not focused on borrowed books.
 *
 * @author BRUCELLA2
 */
@WebService(serviceName = "BooksListing")
public class BooksListing {

  /**
   * Books Listing logger.
   */
  private static final Log LOG = LogFactory.getLog(BooksListing.class);

  /**
   * List of books returned by the Web Service.
   */
  private List<Book> bookList;



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
   *
   * @return the list of books that meet the searching criteria.
   */
  @WebMethod
  public List<Book> booksSearchedList(BooksSearchingClientCriteria booksSearchingClientCriteria) {
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


}
