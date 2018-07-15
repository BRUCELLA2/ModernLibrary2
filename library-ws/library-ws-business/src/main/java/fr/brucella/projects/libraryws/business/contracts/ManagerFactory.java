package fr.brucella.projects.libraryws.business.contracts;

import fr.brucella.projects.libraryws.business.contracts.managers.books.BooksBorrowedListingManager;
import fr.brucella.projects.libraryws.business.contracts.managers.books.BooksListingManager;

/**
 * Interface for Manager Factory. Manager Factory allow to get and set business managers.
 *
 * @author BRUCELLA2
 */
public interface ManagerFactory {

  /**
   * Get the Books Borrowed Listing Manager.
   *
   * @return the Books Borrowed Listing Manager.
   */
  BooksBorrowedListingManager getBooksBorrowedListingManager();

  /**
   * Set the Books Borrowed Listing Manager.
   *
   * @param booksBorrowedListingManager the Books Borrowed Listing Manager.
   */
  void setBooksBorrowedListingManager(final BooksBorrowedListingManager booksBorrowedListingManager);

  /**
   * Get the Books Listing Manager.
   *
   * @return the Books Listing Manager.
   */
  BooksListingManager getBooksListingManager();

  /**
   * Set the Books Listing Manager.
   *
   * @param booksListingManager the Books Listing Manager.
   */
  void setBooksListingManager(final BooksListingManager booksListingManager);
}
