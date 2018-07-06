package fr.brucella.projects.libraryws.dao.impl;

import fr.brucella.projects.libraryws.dao.contracts.dao.DaoFactory;
import fr.brucella.projects.libraryws.dao.contracts.dao.books.AuthorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * The Data Access Object Factory.
 *
 * @author BRUCELLA2
 */
@Component
public class DaoFactoryImpl implements DaoFactory {

  /**
   * Author Data Access Object.
   */
  @Autowired
  private AuthorDao authorDao;


  // ===== Getters and Setters =====


  @Override
  public AuthorDao getAuthorDao() {
    return this.authorDao;
  }

  @Override
  public void setAuthorDao(AuthorDao authorDao) {
    this.authorDao = authorDao;
  }


}
