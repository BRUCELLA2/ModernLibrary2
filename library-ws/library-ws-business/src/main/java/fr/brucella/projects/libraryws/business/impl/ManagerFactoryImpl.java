package fr.brucella.projects.libraryws.business.impl;

import fr.brucella.projects.libraryws.business.contracts.ManagerFactory;
import fr.brucella.projects.libraryws.business.contracts.managers.administration.AdministrationManager;
import fr.brucella.projects.libraryws.business.contracts.managers.authentification.AuthentificationManager;
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

  /** Administration Manager */
  @Autowired private AdministrationManager administrationManager;

  /** Authentification Manager */
  @Autowired private AuthentificationManager authentificationManager;

  /** Books Borrowed Listing Manager */
  @Autowired private BooksBorrowedListingManager booksBorrowedListingManager;

  /** Books Listing Manager */
  @Autowired private BooksListingManager booksListingManager;

  /** Books Listing Manager */
  @Autowired private BooksManagementManager booksManagementManager;

  // ===== Constructor =====
  /** Defaut constructor */
  public ManagerFactoryImpl() {
    // This constructor is intentionally empty. Nothing special is needed here.
  }

  // ===== Getters and Setters =====

  /** {@inheritDoc} */
  @Override
  public AdministrationManager getAdministrationManager() {
    return administrationManager;
  }

  /** {@inheritDoc} */
  @Override
  public void setAdministrationManager(final AdministrationManager administrationManager) {
    this.administrationManager = administrationManager;
  }

  /** {@inheritDoc} */
  @Override
  public AuthentificationManager getAuthentificationManager() {
    return authentificationManager;
  }

  /** {@inheritDoc} */
  @Override
  public void setAuthentificationManager(final AuthentificationManager authentificationManager) {
    this.authentificationManager = authentificationManager;
  }

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
