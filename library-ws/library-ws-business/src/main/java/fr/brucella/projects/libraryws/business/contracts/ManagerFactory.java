package fr.brucella.projects.libraryws.business.contracts;

import fr.brucella.projects.libraryws.business.contracts.managers.books.BooksBorrowedListingManager;

public interface ManagerFactory {

  BooksBorrowedListingManager getBooksBorrowedListingManager();

  void setBooksBorrowedListingManager(BooksBorrowedListingManager booksBorrowedListingManager);
}
