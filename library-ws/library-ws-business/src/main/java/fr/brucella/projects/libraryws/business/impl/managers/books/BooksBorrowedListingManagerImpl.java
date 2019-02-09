package fr.brucella.projects.libraryws.business.impl.managers.books;

import fr.brucella.projects.libraryws.business.contracts.managers.books.BooksBorrowedListingManager;
import fr.brucella.projects.libraryws.business.impl.managers.AbstractManager;
import fr.brucella.projects.libraryws.entity.books.dto.BorrowDto;
import fr.brucella.projects.libraryws.entity.books.dto.CurrentlyBorrowExpiredDto;
import fr.brucella.projects.libraryws.entity.books.dto.UserCurrentlyBorrowDto;
import fr.brucella.projects.libraryws.entity.exceptions.FunctionalException;
import fr.brucella.projects.libraryws.entity.exceptions.NotFoundException;
import fr.brucella.projects.libraryws.entity.exceptions.TechnicalException;
import java.util.ArrayList;
import java.util.List;
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

  /** Books Borrowed Listing Manager logger */
  private static final Log LOG = LogFactory.getLog(BooksBorrowedListingManagerImpl.class);

  /** Default Constructor */
  public BooksBorrowedListingManagerImpl() {
    super();
  }

  /** {@inheritDoc} */
  @Override
  public List<BorrowDto> currentlyBooksBorrow() throws TechnicalException {

    List<BorrowDto> borrowDtoList = new ArrayList<>();
    try {
      borrowDtoList =
          this.getDaoFactory().getBookBorrowedDao().getBorrowListWithUserLoginAndTitle(true);
    } catch (NotFoundException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug(exception.getMessage());
      }
    }

    return borrowDtoList;
  }

  /** {@inheritDoc} */
  @Override
  public List<BorrowDto> userCurrentlyBorrow(final Integer userId)
      throws TechnicalException, FunctionalException {

    if (userId == null || userId == 0) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("user id = " + userId);
      }
      throw new FunctionalException(messages.getString("booksBorrowedListingManager.userIdNull"));
    }

    List<BorrowDto> borrowDtoList = new ArrayList<>();

    try {
      borrowDtoList = this.getDaoFactory().getBookBorrowedDao().getUserBorrows(userId, true);
    } catch (NotFoundException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug(exception.getMessage());
      }
    }

    return borrowDtoList;
  }

  /** {@inheritDoc} */
  @Override
  public List<BorrowDto> userReturnBorrow(final Integer userId)
      throws TechnicalException, FunctionalException {

    if (userId == null || userId == 0) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("user id = " + userId);
      }
      throw new FunctionalException(messages.getString("booksBorrowedListingManager.userIdNull"));
    }

    List<BorrowDto> borrowDtoList = new ArrayList<>();

    try {
      borrowDtoList = this.getDaoFactory().getBookBorrowedDao().getUserBorrows(userId, false);
    } catch (NotFoundException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug(exception.getMessage());
      }
    }

    return borrowDtoList;
  }

  /** {@inheritDoc} */
  @Override
  public List<CurrentlyBorrowExpiredDto> currentlyBorrowExpired() throws TechnicalException {

    List<CurrentlyBorrowExpiredDto> currentlyBorrowExpiredDtoList = new ArrayList<>();

    try {
      currentlyBorrowExpiredDtoList = this.getDaoFactory().getBookBorrowedDao().getBorrowExpired();
    } catch (NotFoundException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug(exception.getMessage());
      }
    }

    return currentlyBorrowExpiredDtoList;
  }

  /** {@inheritDoc} */
  @Override
  public List<UserCurrentlyBorrowDto> userCurrentlyBorrowExpired(final Integer userId)
      throws TechnicalException, FunctionalException {

    if (userId == null || userId == 0) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("user id = " + userId);
      }
      throw new FunctionalException(messages.getString("booksBorrowedListingManager.userIdNull"));
    }

    List<UserCurrentlyBorrowDto> userCurrentlyBorrowDtoList = new ArrayList<>();

    try {
      userCurrentlyBorrowDtoList =
          this.getDaoFactory().getBookBorrowedDao().getUserBorrowsExpired(userId);
    } catch (NotFoundException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug(exception.getMessage());
      }
    }

    return userCurrentlyBorrowDtoList;
  }
}
