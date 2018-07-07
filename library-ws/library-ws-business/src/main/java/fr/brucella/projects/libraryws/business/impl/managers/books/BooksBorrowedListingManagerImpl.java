package fr.brucella.projects.libraryws.business.impl.managers.books;

import fr.brucella.projects.libraryws.business.contracts.managers.books.BooksBorrowedListingManager;
import fr.brucella.projects.libraryws.business.impl.managers.AbstractManager;
import fr.brucella.projects.libraryws.entity.books.model.Author;
import fr.brucella.projects.libraryws.entity.exceptions.NotFoundException;
import fr.brucella.projects.libraryws.entity.exceptions.TechnicalException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

/**
 * The Books Borrowed Listing Manager.
 *
 * @author BRUCELLA2
 */
@Component
public class BooksBorrowedListingManagerImpl extends AbstractManager
    implements BooksBorrowedListingManager {

  private static final Log LOG = LogFactory.getLog(BooksBorrowedListingManagerImpl.class);

  @Override
  public Author test() {

    try {
      LOG.error("daofactory : " + this.getDaoFactory().toString());
      LOG.error("AUTHORDAO : " + this.getDaoFactory().getAuthorDao().toString());
      return this.getDaoFactory().getAuthorDao().getAuthor(1);
    } catch (TechnicalException e) {
      LOG.error("TECHN EXCEP");
      e.printStackTrace();
      return null;
    } catch (NotFoundException e) {
      e.printStackTrace();
      LOG.error("NOT FOUND EXCEP");
      return null;
    }
  }
}
