package fr.brucella.projects.libraryws.entity.books.dto;

import fr.brucella.projects.libraryws.entity.books.model.Stock;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Represents the stock for a book.
 * Includes the title of the book.
 *
 * @author BRUCELLA2
 */
public class BookStockDto extends Stock {

  // ===== Book data =====
  /** Title of the book. Can't be empty. */
  @NotEmpty(message = "{book.title.empty}")
  @Size(min = 1, max = 150, message = "{book.title.size}")
  private String title;


  // ===== Getters and Setters =====

  /**
   * Give the title of the book.
   *
   * @return the title of the book.
   */
  public String getTitle() {
    return title;
  }

  /**
   * Set the title of the book.
   *
   * @param title the title of the book.
   */
  public void setTitle(final String title) {
    this.title = title;
  }


  // ===== Constructor =====

  /** Default Constructor */
  public BookStockDto() {
  }

  // ===== Methods =====

  /**
   * a string representation of the BookStockDto object.
   *
   * @return a string representation of the BookStockDto object.
   */
  @Override
  public String toString() {
    return new ToStringBuilder(this).append("title", title).toString();
  }
}
