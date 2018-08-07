package fr.brucella.projects.libraryws.business.contracts.managers.books;

import fr.brucella.projects.libraryws.entity.books.dto.BookDetailsDto;
import fr.brucella.projects.libraryws.entity.exceptions.FunctionalException;
import fr.brucella.projects.libraryws.entity.exceptions.TechnicalException;
import fr.brucella.projects.libraryws.entity.searchcriteria.dto.BooksSearchClientCriteriaDto;
import java.util.List;

/**
 * Interface for Books Listing Manager
 *
 * @author BRUCELLA2
 */
public interface BooksListingManager {

  /**
   * Provides the list of all books detailed.
   *
   * @return the list of all books detailed.
   * @throws TechnicalException - wraps technical exception caused during data access.
   */
  List<BookDetailsDto> getAllBooks() throws TechnicalException;

  /**
   * Provides the list of books detailed corresponding to the search criteria provided by the user
   * client. If search criteria is empty or null, the list of all books detailed will be returned.
   *
   * @param booksSearchClientCriteriaDto the searching criteria.
   * @return the list of books detailed corresponding to the search criteria
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws FunctionalException - This exception is throw if the data of
   *     booksSearchClientCriteriaDto are not valid.
   */
  List<BookDetailsDto> getSearchBooks(BooksSearchClientCriteriaDto booksSearchClientCriteriaDto)
      throws TechnicalException, FunctionalException;

  /**
   * Provides the list of books detailed which can be borrowed.
   *
   * @return the list of books detailed which can be borrowed.
   * @throws TechnicalException - wraps technical exception caused during data access.
   */
  List<BookDetailsDto> getBooksAvailable() throws TechnicalException;
}
