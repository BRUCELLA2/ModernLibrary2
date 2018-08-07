package fr.brucella.projects.libraryws.business.impl.managers.books;

import fr.brucella.projects.libraryws.business.contracts.managers.books.BooksListingManager;
import fr.brucella.projects.libraryws.business.impl.managers.AbstractManager;
import fr.brucella.projects.libraryws.entity.books.dto.BookDetailsDto;
import fr.brucella.projects.libraryws.entity.exceptions.FunctionalException;
import fr.brucella.projects.libraryws.entity.exceptions.NotFoundException;
import fr.brucella.projects.libraryws.entity.exceptions.TechnicalException;
import fr.brucella.projects.libraryws.entity.searchcriteria.dto.BooksSearchClientCriteriaDto;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

/**
 * The Books Listing Manager.
 *
 * @author BRUCELLA2
 */
@Component
public class BooksListingManagerImpl extends AbstractManager implements BooksListingManager {

  /** Books Listing Manager logger */
  private static final Log LOG = LogFactory.getLog(BooksListingManagerImpl.class);

  /** {@inheritDoc} */
  @Override
  public List<BookDetailsDto> getAllBooks() throws TechnicalException {

    try {
      return this.getDaoFactory().getBookDao().getBookDetailsList();
    } catch (NotFoundException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug(exception.getMessage());
      }
      return new ArrayList<>();
    }
  }

  /** {@inheritDoc} */
  @Override
  public List<BookDetailsDto> getSearchBooks(
      BooksSearchClientCriteriaDto booksSearchClientCriteriaDto)
      throws TechnicalException, FunctionalException {

    if (booksSearchClientCriteriaDto == null) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("booksSearchClientCriteriaDto is NULL");
      }
      return this.getAllBooks();
    }

    final Set<ConstraintViolation<BooksSearchClientCriteriaDto>> violations =
        this.getConstraintValidator().validate(booksSearchClientCriteriaDto);
    if (!violations.isEmpty()) {
      if (LOG.isDebugEnabled()) {
        for (final ConstraintViolation<BooksSearchClientCriteriaDto> violation : violations) {
          LOG.debug(violation.getMessage());
        }
        LOG.debug("Book Search Client Criteria DTO = " + booksSearchClientCriteriaDto.toString());
      }
      throw new FunctionalException(
          messages.getString("booksListingManager.getSearchBooks.integrityViolation"),
          new ConstraintViolationException(violations));
    }

    try {
      return this.getDaoFactory()
          .getBookDao()
          .getSearchBookDetailsList(booksSearchClientCriteriaDto);
    } catch (NotFoundException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug(exception.getMessage());
      }
      return new ArrayList<>();
    }
  }

  @Override
  public List<BookDetailsDto> getBooksAvailable() throws TechnicalException {

    BooksSearchClientCriteriaDto searchClientCriteriaDto = new BooksSearchClientCriteriaDto();
    searchClientCriteriaDto.setBookAvailable(true);

    try {
      return this.getDaoFactory().getBookDao().getSearchBookDetailsList(searchClientCriteriaDto);
    } catch (NotFoundException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug(exception.getMessage());
      }
      return new ArrayList<>();
    }
  }
}
