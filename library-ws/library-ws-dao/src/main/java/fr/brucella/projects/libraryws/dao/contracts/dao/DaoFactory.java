package fr.brucella.projects.libraryws.dao.contracts.dao;

import fr.brucella.projects.libraryws.dao.contracts.dao.books.AuthorDao;
import fr.brucella.projects.libraryws.dao.contracts.dao.books.BookBorrowedDao;
import fr.brucella.projects.libraryws.dao.contracts.dao.books.BookDao;
import fr.brucella.projects.libraryws.dao.contracts.dao.books.GenreDao;
import fr.brucella.projects.libraryws.dao.contracts.dao.books.PublisherDao;
import fr.brucella.projects.libraryws.dao.contracts.dao.books.StockDao;

/**
 * Interface for the Data Access Object Factory.
 *
 * @author BRUCELLA2
 */
public interface DaoFactory {

  // ===== Getters =====

  /**
   * Give the Author Data Access Object.
   *
   * @return the Author Data Access Object.
   */
  AuthorDao getAuthorDao();

  /**
   * Give the Book Data Access Object.
   *
   * @return the Book Data Access Object.
   */
  BookDao getBookDao();

  /**
   * Give the BookBorrowed Data Access Object.
   *
   * @return the BookBorrowed Data Access Object.
   */
  BookBorrowedDao getBookBorrowedDao();

  /**
   * Give the Genre Data Access Object.
   *
   * @return the Genre Data Access Object.
   */
  GenreDao getGenreDao();

  /**
   * Give the Publisher Data Access Object.
   *
   * @return the Publisher Data Access Object.
   */
  PublisherDao getPublisherDao();

  /**
   * Give the Stock Data Access Object.
   *
   * @return the Stock Data Access Object.
   */
  StockDao getStockDao();


  // ===== Setters =====

  /**
   * Set the Author Data Access Object.
   *
   * @param authorDao the Author Data Access Object.
   */
  void setAuthorDao(final AuthorDao authorDao);

  /**
   * Set the Book Data Access Object.
   *
   * @param bookDao the Book Data Access Object.
   */
  void setBookDao(final BookDao bookDao);

  /**
   * Set the BookBorrowed Data Access Object.
   *
   * @param bookBorrowedDao the BookBorrowed Data Access Object.
   */
  void setBookBorrowedDao(final BookBorrowedDao bookBorrowedDao);

  /**
   * Set the Genre Data Access Object.
   *
   * @param genreDao the Genre Data Access Object.
   */
  void setGenreDao(final GenreDao genreDao);

  /**
   * Set the Publisher Data Access Object.
   *
   * @param publisherDao the Publisher Data Access Object.
   */
  void setPublisherDao(final PublisherDao publisherDao);

  /**
   * Set the Stock Data Access Object.
   *
   * @param stockDao the Stock Data Access Object.
   */
  void setStockDao(final StockDao stockDao);
}
