package fr.brucella.projects.libraryws.business.impl;

import fr.brucella.projects.libraryws.business.contracts.ManagerFactory;
import fr.brucella.projects.libraryws.business.contracts.managers.books.BooksBorrowedListingManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ManagerFactoryImpl implements ManagerFactory {

  @Autowired
  private BooksBorrowedListingManager booksBorrowedListingManager;

  @Override
  public BooksBorrowedListingManager getBooksBorrowedListingManager() {
    return this.booksBorrowedListingManager;
  }

  @Override
  public void setBooksBorrowedListingManager(BooksBorrowedListingManager booksBorrowedListingManager) {
    this.booksBorrowedListingManager = booksBorrowedListingManager;
  }
}
