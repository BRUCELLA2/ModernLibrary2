package fr.brucella.projects.libraryws.dao.contracts.dao.books;

import fr.brucella.projects.libraryws.entity.books.dto.BookStockDto;
import fr.brucella.projects.libraryws.entity.books.model.Stock;
import fr.brucella.projects.libraryws.entity.exceptions.NotFoundException;
import fr.brucella.projects.libraryws.entity.exceptions.TechnicalException;
import java.util.List;

/**
 * Interface for Stock Data Access Object.
 *
 * @author BRUCELLA2
 */
public interface StockDao {

  /**
   * Give the stock with the specified id from the datastore.
   *
   * @param stockId id of the stock.
   * @return the stock with the specified id.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and the
   *     stock is not found.
   */
  Stock getStock(final Integer stockId) throws TechnicalException, NotFoundException;

  /**
   * Give the stock with the book id specified from the datastore.
   *
   * @param bookId id of the book.
   * @return the stock with the book id specified.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and the
   *     stock is not found.
   */
  Stock getStockForBook(final Integer bookId) throws TechnicalException, NotFoundException;

  /**
   * Give the list of stocks for each book (include title of the book).
   *
   * @return the list of stocks for each book (include title of the book).
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and no stock is found.
   */
  List<BookStockDto> getBookStockList() throws TechnicalException, NotFoundException;

  /**
   * Update an existing stock in the datastore.
   *
   * @param stock the stock with the updated informations to save in datastore.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and the
   *     stock is not found.
   */
  void updateStock(final Stock stock) throws TechnicalException, NotFoundException;

  /**
   * Insert a new stock in the datastore.
   *
   * @param stock The stock to insert in datastore.
   * @return the id of the new stock.
   * @throws TechnicalException - wraps technical exception caused during data access.
   */
  int insertStock(final Stock stock) throws TechnicalException;

  /**
   * Delete the stock with the specified id in the datastore.
   *
   * @param stockId id of the stock.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and the
   *     stock is not found.
   */
  void deleteStock(final Integer stockId) throws TechnicalException, NotFoundException;
}
