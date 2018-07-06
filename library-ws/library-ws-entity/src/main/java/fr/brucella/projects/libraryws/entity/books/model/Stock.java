package fr.brucella.projects.libraryws.entity.books.model;

import javax.validation.constraints.NotNull;
import org.apache.commons.lang3.builder.ToStringBuilder;

/** Represents a stock of a book. */
public class Stock {

  /** Id of the stock. */
  private Integer stockId;

  /** Id of the book. Can't be null. */
  @NotNull(message = "{stock.bookId.null}")
  private Integer bookId;

  /** Amount of copy of the book available for a borrowing. Can't be null. */
  @NotNull(message = "{stock.amountAvailable.null}")
  private Integer amountAvailable;

  /** Total amount of the book. Can't be null. */
  @NotNull(message = "{stock.amount.null}")
  private Integer amount;

  // ===== Getters and Setters =====

  /**
   * Give the id of the stock.
   *
   * @return the id of the stock.
   */
  public Integer getStockId() {
    return stockId;
  }

  /**
   * Set the id of the stock.
   *
   * @param stockId the id of the stock.
   */
  public void setStockId(final Integer stockId) {
    this.stockId = stockId;
  }

  /**
   * Give the id of the book.
   *
   * @return the id of the book.
   */
  public Integer getBookId() {
    return bookId;
  }

  /**
   * Set the id of the book.
   *
   * @param bookId the id of the book.
   */
  public void setBookId(final Integer bookId) {
    this.bookId = bookId;
  }

  /**
   * Give the amount of the book available.
   *
   * @return the amount of the book available.
   */
  public Integer getAmountAvailable() {
    return amountAvailable;
  }

  /**
   * Set the amount of the book available.
   *
   * @param amountAvailable the amount of the book available.
   */
  public void setAmountAvailable(final Integer amountAvailable) {
    this.amountAvailable = amountAvailable;
  }

  /**
   * Give the total amount of the book.
   *
   * @return the total amount of the book.
   */
  public Integer getAmount() {
    return amount;
  }

  /**
   * Set the total amount of the book.
   *
   * @param amount
   */
  public void setAmount(final Integer amount) {
    this.amount = amount;
  }

  // ===== Methods =====

  /**
   * a string representation of the Stock object.
   *
   * @return a string representation of the Stock object.
   */
  @Override
  public String toString() {
    return new ToStringBuilder(this)
        .append("stockId", stockId)
        .append("bookId", bookId)
        .append("amountAvailable", amountAvailable)
        .append("amount", amount)
        .toString();
  }
}
