package fr.brucella.projects.libraryws.dao.impl.rowmapper.books;

import fr.brucella.projects.libraryws.entity.books.model.Stock;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 * This class allow to map row of ResultSet to an Stock object.
 *
 * @author BRUCELLA2
 */
public class StockRM implements RowMapper<Stock> {

  /** Default Constructor */
  public StockRM() {}

  /** {@inheritDoc} */
  @Override
  public Stock mapRow(ResultSet resultSet, int rowNum) throws SQLException {

    final Stock stock = new Stock();

    stock.setAmount(resultSet.getInt("amount"));
    stock.setAmountAvailable(resultSet.getInt("amount_available"));
    stock.setBookId(resultSet.getInt("book_id"));
    stock.setStockId(resultSet.getInt("stock_id"));

    return stock;
  }
}
