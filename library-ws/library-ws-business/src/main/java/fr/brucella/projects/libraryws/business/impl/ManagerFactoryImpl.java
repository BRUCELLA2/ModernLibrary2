package fr.brucella.projects.libraryws.business.impl;

import fr.brucella.projects.libraryws.business.contracts.ManagerFactory;
import fr.brucella.projects.libraryws.business.contracts.managers.books.BooksBorrowedListingManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Manager Factory allow to get and set business managers.
 *
 * @author BRUCELLA2
 */
@Component
public class ManagerFactoryImpl implements ManagerFactory {

  /**
   * Books Borrowed Listing Manager
   */
  @Autowired private BooksBorrowedListingManager booksBorrowedListingManager;

  /**
   * {@inheritDoc}
   */
  @Override
  public BooksBorrowedListingManager getBooksBorrowedListingManager() {
    return this.booksBorrowedListingManager;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setBooksBorrowedListingManager(final BooksBorrowedListingManager booksBorrowedListingManager) {
    this.booksBorrowedListingManager = booksBorrowedListingManager;
  }
}
