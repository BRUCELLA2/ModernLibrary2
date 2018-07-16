package fr.brucella.projects.libraryws.dao.impl.rowmapper.books.dto;

import fr.brucella.projects.libraryws.entity.books.dto.BookStockDto;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 * This class allow to map row of ResultSet to an BookStockDto object.
 *
 * @author BRUCELLA2
 */
public class BookStockDtoRM implements RowMapper<BookStockDto> {

  /** Default Constructor */
  public BookStockDtoRM() {
  }


  @Override
  public BookStockDto mapRow(final ResultSet resultSet, final int rowNum) throws SQLException {

    final BookStockDto bookStockDto = new BookStockDto();

    bookStockDto.setTitle(resultSet.getString("title"));
    bookStockDto.setAmount(resultSet.getInt("amount"));
    bookStockDto.setAmountAvailable(resultSet.getInt("amount_available"));
    bookStockDto.setBookId(resultSet.getInt("book_id"));
    bookStockDto.setStockId(resultSet.getInt("stock_id"));

    return bookStockDto;
  }
}
