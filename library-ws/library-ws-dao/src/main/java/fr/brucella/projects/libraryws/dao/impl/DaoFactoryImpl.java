package fr.brucella.projects.libraryws.dao.impl;

import fr.brucella.projects.libraryws.dao.contracts.dao.DaoFactory;
import fr.brucella.projects.libraryws.dao.contracts.dao.books.AuthorDao;
import fr.brucella.projects.libraryws.dao.contracts.dao.books.BookBorrowedDao;
import fr.brucella.projects.libraryws.dao.contracts.dao.books.BookDao;
import fr.brucella.projects.libraryws.dao.contracts.dao.books.GenreDao;
import fr.brucella.projects.libraryws.dao.contracts.dao.books.PublisherDao;
import fr.brucella.projects.libraryws.dao.contracts.dao.books.StockDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * The Data Access Object Factory.
 *
 * @author BRUCELLA2
 */
@Component
public class DaoFactoryImpl implements DaoFactory {

  /** Author Data Access Object. */
  @Autowired private AuthorDao authorDao;

  /** Book Data Access Object. */
  @Autowired private BookDao bookDao;

  /** BookBorrowed Data Access Object. */
  @Autowired private BookBorrowedDao bookBorrowedDao;

  /**
   * Genre Data Access Object.
   */
  @Autowired private GenreDao genreDao;

  /**
   * Genre Data Access Object.
   */
  @Autowired private PublisherDao publisherDao;

  /**
   * Stock Data Access Object.
   */
  @Autowired private StockDao stockDao;

  // ===== Getters and Setters =====

  @Override
  public AuthorDao getAuthorDao() {
    return this.authorDao;
  }

  @Override
  public BookDao getBookDao() {
    return this.bookDao;
  }

  @Override
  public BookBorrowedDao getBookBorrowedDao() {
    return this.bookBorrowedDao;
  }

  @Override
  public GenreDao getGenreDao() {
    return this.genreDao;
  }

  @Override
  public PublisherDao getPublisherDao() {
    return this.publisherDao;
  }

  @Override
  public StockDao getStockDao() {
    return this.stockDao;
  }

  @Override
  public void setAuthorDao(final AuthorDao authorDao) {
    this.authorDao = authorDao;
  }

  @Override
  public void setBookDao(final BookDao bookDao) {
    this.bookDao = bookDao;
  }

  @Override
  public void setBookBorrowedDao(final BookBorrowedDao bookBorrowedDao) {
    this.bookBorrowedDao = bookBorrowedDao;
  }

  @Override
  public void setGenreDao(final GenreDao genreDao) {
    this.genreDao = genreDao;
  }

  @Override
  public void setPublisherDao(final PublisherDao publisherDao) {
    this.publisherDao = publisherDao;
  }

  @Override
  public void setStockDao(final StockDao stockDao) {
    this.stockDao = stockDao;
  }
}
