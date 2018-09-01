package fr.brucella.projects.libraryws.business.contracts.managers.books;

import fr.brucella.projects.libraryws.entity.books.dto.BorrowDto;
import fr.brucella.projects.libraryws.entity.books.dto.CurrentlyBorrowExpiredDto;
import fr.brucella.projects.libraryws.entity.books.dto.UserCurrentlyBorrowDto;
import fr.brucella.projects.libraryws.entity.exceptions.FunctionalException;
import fr.brucella.projects.libraryws.entity.exceptions.TechnicalException;
import java.util.List;

/**
 * Interface for Books Borrowed Listing Manager.
 *
 * @author BRUCELLA2
 */
public interface BooksBorrowedListingManager {

  /**
   * Provides the list of currently borrows with login of the user and title of the book.
   *
   * @return the list of currently borrows with login of the user and title of the book.
   * @throws TechnicalException - wraps technical exception caused during data access.
   */
  List<BorrowDto> currentlyBooksBorrow() throws TechnicalException;

  /**
   * Provides the list of informations about currently borrows by the user.
   *
   * @param userId id of the user.
   * @return the list of informations about currently borrows by the user.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws FunctionalException - This exception is throw if the id of the user is null.
   */
  List<BorrowDto> userCurrentlyBorrow(final Integer userId)
      throws TechnicalException, FunctionalException;

  /**
   * Provides the list of informations about the borrows returned by the user.
   *
   * @param userId id
   * @return the list of informations about currently borrows by the user.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws FunctionalException - This exception is throw if the id of the user is null.
   */
  List<BorrowDto> userReturnBorrow(final Integer userId)
      throws TechnicalException, FunctionalException;

  /**
   * Provides the list of informations about currently borrowed books which have an expired deadline
   * and the user who borrow the book.
   *
   * @return the list of informations about currently borrowed books which have an expired deadline
   *     and the user who borrow the book.
   * @throws TechnicalException - wraps technical exception caused during data access.
   */
  List<CurrentlyBorrowExpiredDto> currentlyBorrowExpired() throws TechnicalException;

  /**
   * Provides the list of informations avout currently borrows expired for the user.
   *
   * @param userId id of the user.
   * @return the list of informations avout currently borrows expired for the user.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws FunctionalException - This exception is throw if the id of the user is null.
   */
  List<UserCurrentlyBorrowDto> userCurrentlyBorrowExpired(final Integer userId)
      throws TechnicalException, FunctionalException;
}
