package fr.brucella.projects.libraryws.business.impl;

import fr.brucella.projects.libraryws.business.contracts.ManagerFactory;
import fr.brucella.projects.libraryws.business.contracts.managers.books.BooksBorrowedListingManager;
import fr.brucella.projects.libraryws.business.contracts.managers.books.BooksListingManager;
import fr.brucella.projects.libraryws.business.contracts.managers.books.BooksManagementManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Manager Factory allow to get and set business managers.
 *
 * @author BRUCELLA2
 */
@Component
public class ManagerFactoryImpl implements ManagerFactory {

  /** Books Borrowed Listing Manager */
  @Autowired private BooksBorrowedListingManager booksBorrowedListingManager;

  /**
   * Books Listing Manager
   */
  @Autowired private BooksListingManager booksListingManager;

  /**
   * Books Listing Manager
   */
  @Autowired private BooksManagementManager booksManagementManager;

  /** {@inheritDoc} */
  @Override
  public BooksBorrowedListingManager getBooksBorrowedListingManager() {
    return this.booksBorrowedListingManager;
  }

  /** {@inheritDoc} */
  @Override
  public void setBooksBorrowedListingManager(
      final BooksBorrowedListingManager booksBorrowedListingManager) {
    this.booksBorrowedListingManager = booksBorrowedListingManager;
  }

  /** {@inheritDoc} */
  @Override
  public BooksListingManager getBooksListingManager() {
    return booksListingManager;
  }

  /** {@inheritDoc} */
  @Override
  public void setBooksListingManager(final BooksListingManager booksListingManager) {
    this.booksListingManager = booksListingManager;
  }

  /** {@inheritDoc} */
  @Override
  public BooksManagementManager getBooksManagementManager() {
    return booksManagementManager;
  }

  /** {@inheritDoc} */
  @Override
  public void setBooksManagementManager(final BooksManagementManager booksManagementManager) {
    this.booksManagementManager = booksManagementManager;
  }
}
