package fr.brucella.projects.libraryws.dao.contracts.dao;

import fr.brucella.projects.libraryws.dao.contracts.dao.books.AuthorDao;

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

  // ===== Setters =====

  /**
   * Set the Author Data Access Object.
   *
   * @param authorDao the Author Data Access Object.
   */
  void setAuthorDao(final AuthorDao authorDao);
}
