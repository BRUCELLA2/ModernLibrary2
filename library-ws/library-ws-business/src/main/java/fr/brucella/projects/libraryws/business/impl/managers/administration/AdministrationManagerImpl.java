package fr.brucella.projects.libraryws.business.impl.managers.administration;

import fr.brucella.projects.libraryws.business.contracts.managers.administration.AdministrationManager;
import fr.brucella.projects.libraryws.business.impl.managers.AbstractManager;
import fr.brucella.projects.libraryws.entity.books.model.Author;
import fr.brucella.projects.libraryws.entity.books.model.Book;
import fr.brucella.projects.libraryws.entity.books.model.Genre;
import fr.brucella.projects.libraryws.entity.books.model.Publisher;
import fr.brucella.projects.libraryws.entity.exceptions.FunctionalException;
import fr.brucella.projects.libraryws.entity.exceptions.NotFoundException;
import fr.brucella.projects.libraryws.entity.exceptions.TechnicalException;
import fr.brucella.projects.libraryws.entity.users.model.Role;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

/**
 * The Administration Manager.
 *
 * @author BRUCELLA2
 */
@Component
public class AdministrationManagerImpl extends AbstractManager implements AdministrationManager {

  /** Administration Manager Logger */
  private static final Log LOG = LogFactory.getLog(AdministrationManagerImpl.class);

  /** Default Constructor. */
  public AdministrationManagerImpl() {
    super();
  }

  /** {@inheritDoc} */
  @Override
  public Integer addBook(final Book book) throws TechnicalException, FunctionalException {

    if (book == null) {
      LOG.error(messages.getString("administrationManager.addBook.bookNull"));
      throw new FunctionalException(messages.getString("administrationManager.addBook.bookNull"));
    }

    final Set<ConstraintViolation<Book>> violations = this.getConstraintValidator().validate(book);
    if (!violations.isEmpty()) {
      if (LOG.isDebugEnabled()) {
        for (final ConstraintViolation<Book> violation : violations) {
          LOG.debug(violation.getMessage());
        }
      }
      LOG.error(messages.getString("administrationManager.addBook.constraints"));
      throw new FunctionalException(
          messages.getString("administrationManager.addBook.constraints"),
          new ConstraintViolationException(violations));
    }

    return this.getDaoFactory().getBookDao().insertBook(book);
  }

  /** {@inheritDoc} */
  @Override
  public Integer addAuthor(final Author author) throws TechnicalException, FunctionalException {

    if (author == null) {
      LOG.error(messages.getString("administrationManager.addAuthor.authorNull"));
      throw new FunctionalException(
          messages.getString("administrationManager.addAuthor.authorNull"));
    }

    final Set<ConstraintViolation<Author>> violations =
        this.getConstraintValidator().validate(author);
    if (!violations.isEmpty()) {
      if (LOG.isDebugEnabled()) {
        for (final ConstraintViolation<Author> violation : violations) {
          LOG.debug(violation.getMessage());
        }
      }
      LOG.error(messages.getString("administrationManager.addAuthor.constraints"));
      throw new FunctionalException(
          messages.getString("administrationManager.addAuthor.constraints"),
          new ConstraintViolationException(violations));
    }

    return this.getDaoFactory().getAuthorDao().insertAuthor(author);
  }

  /** {@inheritDoc} */
  @Override
  public Integer addGenre(final Genre genre) throws TechnicalException, FunctionalException {

    if (genre == null) {
      LOG.error(messages.getString("administrationManager.addGenre.genreNull"));
      throw new FunctionalException(messages.getString("administrationManager.addGenre.genreNull"));
    }

    final Set<ConstraintViolation<Genre>> violations =
        this.getConstraintValidator().validate(genre);
    if (!violations.isEmpty()) {
      if (LOG.isDebugEnabled()) {
        for (final ConstraintViolation<Genre> violation : violations) {
          LOG.debug(violation.getMessage());
        }
      }
      LOG.error(messages.getString("administrationManager.addGenre.constraints"));
      throw new FunctionalException(
          messages.getString("administrationManager.addGenre.constraints"),
          new ConstraintViolationException(violations));
    }

    return this.getDaoFactory().getGenreDao().insertGenre(genre);
  }

  /** {@inheritDoc} */
  @Override
  public Integer addPublisher(final Publisher publisher)
      throws TechnicalException, FunctionalException {

    if (publisher == null) {
      LOG.error(messages.getString("administrationManager.addPublisher.publisherNull"));
      throw new FunctionalException(
          messages.getString("administrationManager.addPublisher.publisherNull"));
    }

    final Set<ConstraintViolation<Publisher>> violations =
        this.getConstraintValidator().validate(publisher);
    if (!violations.isEmpty()) {
      if (LOG.isDebugEnabled()) {
        for (final ConstraintViolation<Publisher> violation : violations) {
          LOG.debug(violation.getMessage());
        }
      }
      LOG.error(messages.getString("administrationManager.addPublisher.constraints"));
      throw new FunctionalException(
          messages.getString("administrationManager.addPublisher.constraints"),
          new ConstraintViolationException(violations));
    }

    return this.getDaoFactory().getPublisherDao().insertPublisher(publisher);
  }

  /** {@inheritDoc} */
  @Override
  public Integer addRole(final Role role) throws TechnicalException, FunctionalException {

    if (role == null) {
      LOG.error(messages.getString("administrationManager.addRole.roleNull"));
      throw new FunctionalException(messages.getString("administrationManager.addRole.roleNull"));
    }

    final Set<ConstraintViolation<Role>> violations = this.getConstraintValidator().validate(role);
    if (!violations.isEmpty()) {
      if (LOG.isDebugEnabled()) {
        for (final ConstraintViolation<Role> violation : violations) {
          LOG.debug(violation.getMessage());
        }
      }
      LOG.error(messages.getString("administrationManager.addRole.constraints"));
      throw new FunctionalException(
          messages.getString("administrationManager.addRole.constraints"),
          new ConstraintViolationException(violations));
    }

    return this.getDaoFactory().getRoleDao().insertRole(role);
  }

  /** {@inheritDoc} */
  @Override
  public Boolean modifyBook(final Book book) throws TechnicalException, FunctionalException {

    if (book == null) {
      LOG.error(messages.getString("administrationManager.modifyBook.bookNull"));
      throw new FunctionalException(
          messages.getString("administrationManager.modifyBook.bookNull"));
    }

    final Set<ConstraintViolation<Book>> violations = this.getConstraintValidator().validate(book);
    if (!violations.isEmpty()) {
      if (LOG.isDebugEnabled()) {
        for (final ConstraintViolation<Book> violation : violations) {
          LOG.debug(violation.getMessage());
        }
      }
      LOG.error(messages.getString("administrationManager.modifyBook.constraints"));
      throw new FunctionalException(
          messages.getString("administrationManager.modifyBook.constraints"),
          new ConstraintViolationException(violations));
    }

    try {
      this.getDaoFactory().getBookDao().updateBook(book);
      return true;
    } catch (NotFoundException exception) {
      LOG.error((exception.getMessage()));
      throw new FunctionalException(exception.getMessage(), exception);
    }
  }

  /** {@inheritDoc} */
  @Override
  public Boolean modifyAuthor(final Author author) throws TechnicalException, FunctionalException {

    if (author == null) {
      LOG.error(messages.getString("administrationManager.modifyAuthor.authorNull"));
      throw new FunctionalException(
          messages.getString("administrationManager.modifyAuthor.authorNull"));
    }

    final Set<ConstraintViolation<Author>> violations =
        this.getConstraintValidator().validate(author);
    if (!violations.isEmpty()) {
      if (LOG.isDebugEnabled()) {
        for (final ConstraintViolation<Author> violation : violations) {
          LOG.debug(violation.getMessage());
        }
      }
      LOG.error(messages.getString("administrationManager.modifyAuthor.constraints"));
      throw new FunctionalException(
          messages.getString("administrationManager.modifyAuthor.constraints"),
          new ConstraintViolationException(violations));
    }

    try {
      this.getDaoFactory().getAuthorDao().updateAuthor(author);
      return true;
    } catch (NotFoundException exception) {
      LOG.error((exception.getMessage()));
      throw new FunctionalException(exception.getMessage(), exception);
    }
  }

  /** {@inheritDoc} */
  @Override
  public Boolean modifyGenre(final Genre genre) throws TechnicalException, FunctionalException {

    if (genre == null) {
      LOG.error(messages.getString("administrationManager.modifyGenre.genreNull"));
      throw new FunctionalException(
          messages.getString("administrationManager.modifyGenre.genreNull"));
    }

    final Set<ConstraintViolation<Genre>> violations =
        this.getConstraintValidator().validate(genre);
    if (!violations.isEmpty()) {
      if (LOG.isDebugEnabled()) {
        for (final ConstraintViolation<Genre> violation : violations) {
          LOG.debug(violation.getMessage());
        }
      }
      LOG.error(messages.getString("administrationManager.modifyGenre.constraints"));
      throw new FunctionalException(
          messages.getString("administrationManager.modifyGenre.constraints"),
          new ConstraintViolationException(violations));
    }

    try {
      this.getDaoFactory().getGenreDao().updateGenre(genre);
      return true;
    } catch (NotFoundException exception) {
      LOG.error((exception.getMessage()));
      throw new FunctionalException(exception.getMessage(), exception);
    }
  }

  /** {@inheritDoc} */
  @Override
  public Boolean modifyPublisher(final Publisher publisher)
      throws TechnicalException, FunctionalException {

    if (publisher == null) {
      LOG.error(messages.getString("administrationManager.modifyPublisher.publisherNull"));
      throw new FunctionalException(
          messages.getString("administrationManager.modifyPublisher.publisherNull"));
    }

    final Set<ConstraintViolation<Publisher>> violations =
        this.getConstraintValidator().validate(publisher);
    if (!violations.isEmpty()) {
      if (LOG.isDebugEnabled()) {
        for (final ConstraintViolation<Publisher> violation : violations) {
          LOG.debug(violation.getMessage());
        }
      }
      LOG.error(messages.getString("administrationManager.modifyPublisher.constraints"));
      throw new FunctionalException(
          messages.getString("administrationManager.modifyPublisher.constraints"),
          new ConstraintViolationException(violations));
    }

    try {
      this.getDaoFactory().getPublisherDao().updatePublisher(publisher);
      return true;
    } catch (NotFoundException exception) {
      LOG.error((exception.getMessage()));
      throw new FunctionalException(exception.getMessage(), exception);
    }
  }

  /** {@inheritDoc} */
  @Override
  public Boolean modifyRole(final Role role) throws TechnicalException, FunctionalException {

    if (role == null) {
      LOG.error(messages.getString("administrationManager.modifyRole.roleNull"));
      throw new FunctionalException(
          messages.getString("administrationManager.modifyRole.roleNull"));
    }

    final Set<ConstraintViolation<Role>> violations = this.getConstraintValidator().validate(role);
    if (!violations.isEmpty()) {
      if (LOG.isDebugEnabled()) {
        for (final ConstraintViolation<Role> violation : violations) {
          LOG.debug(violation.getMessage());
        }
      }
      LOG.error(messages.getString("administrationManager.modifyRole.constraints"));
      throw new FunctionalException(
          messages.getString("administrationManager.modifyRole.constraints"),
          new ConstraintViolationException(violations));
    }

    try {
      this.getDaoFactory().getRoleDao().updateRole(role);
      return true;
    } catch (NotFoundException exception) {
      LOG.error(exception.getMessage());
      throw new FunctionalException(exception.getMessage(), exception);
    }
  }
}
