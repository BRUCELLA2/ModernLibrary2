package fr.brucella.projects.libraryws.dao.impl;

import fr.brucella.projects.libraryws.dao.contracts.dao.DaoFactory;
import fr.brucella.projects.libraryws.dao.contracts.dao.books.AuthorDao;
import fr.brucella.projects.libraryws.dao.contracts.dao.books.BookBorrowedDao;
import fr.brucella.projects.libraryws.dao.contracts.dao.books.BookDao;
import fr.brucella.projects.libraryws.dao.contracts.dao.books.GenreDao;
import fr.brucella.projects.libraryws.dao.contracts.dao.books.PublisherDao;
import fr.brucella.projects.libraryws.dao.contracts.dao.books.StockDao;
import fr.brucella.projects.libraryws.dao.contracts.dao.users.AddressDao;
import fr.brucella.projects.libraryws.dao.contracts.dao.users.RoleDao;
import fr.brucella.projects.libraryws.dao.contracts.dao.users.UserDao;
import fr.brucella.projects.libraryws.dao.contracts.dao.users.UserOptionsDao;
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

  /** Genre Data Access Object. */
  @Autowired private GenreDao genreDao;

  /** Genre Data Access Object. */
  @Autowired private PublisherDao publisherDao;

  /** Stock Data Access Object. */
  @Autowired private StockDao stockDao;

  /** Address Data Access Object. */
  @Autowired private AddressDao addressDao;

  /** Role Data Access Object. */
  @Autowired private RoleDao roleDao;

  /** User Data Access Object. */
  @Autowired private UserDao userDao;

  /** UserOptions Data Access Object. */
  @Autowired private UserOptionsDao userOptionsDao;

  // ===== Constructor =====

  /** Default Constructor */
  public DaoFactoryImpl() {}

  // ===== Getters and Setters =====

  /** {@inheritDoc} */
  @Override
  public AuthorDao getAuthorDao() {
    return this.authorDao;
  }

  /** {@inheritDoc} */
  @Override
  public BookDao getBookDao() {
    return this.bookDao;
  }

  /** {@inheritDoc} */
  @Override
  public BookBorrowedDao getBookBorrowedDao() {
    return this.bookBorrowedDao;
  }

  /** {@inheritDoc} */
  @Override
  public GenreDao getGenreDao() {
    return this.genreDao;
  }

  /** {@inheritDoc} */
  @Override
  public PublisherDao getPublisherDao() {
    return this.publisherDao;
  }

  /** {@inheritDoc} */
  @Override
  public StockDao getStockDao() {
    return this.stockDao;
  }

  /** {@inheritDoc} */
  @Override
  public AddressDao getAddressDao() {
    return addressDao;
  }

  /** {@inheritDoc} */
  @Override
  public RoleDao getRoleDao() {
    return roleDao;
  }

  /** {@inheritDoc} */
  @Override
  public UserDao getUserDao() {
    return userDao;
  }

  /** {@inheritDoc} */
  @Override
  public  UserOptionsDao getUserOptionsDao() {
    return userOptionsDao;
  }

  /** {@inheritDoc} */
  @Override
  public void setAuthorDao(final AuthorDao authorDao) {
    this.authorDao = authorDao;
  }

  /** {@inheritDoc} */
  @Override
  public void setBookDao(final BookDao bookDao) {
    this.bookDao = bookDao;
  }

  /** {@inheritDoc} */
  @Override
  public void setBookBorrowedDao(final BookBorrowedDao bookBorrowedDao) {
    this.bookBorrowedDao = bookBorrowedDao;
  }

  /** {@inheritDoc} */
  @Override
  public void setGenreDao(final GenreDao genreDao) {
    this.genreDao = genreDao;
  }

  /** {@inheritDoc} */
  @Override
  public void setPublisherDao(final PublisherDao publisherDao) {
    this.publisherDao = publisherDao;
  }

  /** {@inheritDoc} */
  @Override
  public void setStockDao(final StockDao stockDao) {
    this.stockDao = stockDao;
  }

  /** {@inheritDoc} */
  @Override
  public void setAddressDao(final AddressDao addressDao) {
    this.addressDao = addressDao;
  }

  /** {@inheritDoc} */
  @Override
  public void setRoleDao(final RoleDao roleDao) {
    this.roleDao = roleDao;
  }

  /** {@inheritDoc} */
  @Override
  public void setUserDao(final UserDao userDao) {
    this.userDao = userDao;
  }

  /** {@inheritDoc} */
  @Override
  public void setUserOptionsDao(final UserOptionsDao userOptionsDao) {
    this.userOptionsDao = userOptionsDao;
  }
}
