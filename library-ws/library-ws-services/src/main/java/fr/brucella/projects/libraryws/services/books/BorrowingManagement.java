package fr.brucella.projects.libraryws.services.books;

import javax.jws.WebMethod;
import javax.jws.WebService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Borrowing Management Web Service.
 *
 * @author BRUCELLA2
 */
@WebService(serviceName = "BorrowingManagement")
public class BorrowingManagement {

  /**
   * Borrowing Management logger.
   */
  private static final Log LOG = LogFactory.getLog(BorrowingManagement.class);



  /**
   * Add a book borrowing.
   *
   * @param bookId id of the book borrowed.
   * @param userId id of the user who borrow the book.
   *
   * @return id of the borrowing.
   */
  @WebMethod
  public Integer bookBorrow(Integer bookId, Integer userId) {
    return null;
  }

  /**
   * Extends a book borrowing.
   *
   * @param bookId id of the book borrowed.
   * @param userId id of the user who borrow the book.
   *
   * @return true if extend success. false if extend fail.
   */
  @WebMethod
  public Boolean extendBorrowing(Integer bookId, Integer userId) {
    return null;
  }

  /**
   * Finished a book borrowing.
   *
   * @param bookId id of the book borrowed.
   * @param userId id of the user who borrowed the book.
   *
   * @return true if the borrowing return if a success. False otherwise.
   */
  @WebMethod
  public Boolean borrowingReturn(Integer bookId, Integer userId) {
    return null;
  }
}
