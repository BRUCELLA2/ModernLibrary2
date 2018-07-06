package fr.brucella.projects.libraryws.dao.impl.dao.books;

import fr.brucella.projects.libraryws.dao.contracts.dao.books.AuthorDao;
import fr.brucella.projects.libraryws.dao.impl.dao.AbstractDao;
import fr.brucella.projects.libraryws.dao.impl.rowmapper.books.AuthorRM;
import fr.brucella.projects.libraryws.entity.books.model.Author;
import fr.brucella.projects.libraryws.entity.exceptions.NotFoundException;
import fr.brucella.projects.libraryws.entity.exceptions.TechnicalException;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.PermissionDeniedDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

/**
 * Author Data Access Object.
 *
 * @author BRUCELLA2
 */
@Component
public class AuthorDaoImpl extends AbstractDao implements AuthorDao {

  /**
   * Author DAO logger.
   */
  private static final Log LOG = LogFactory.getLog(AuthorDaoImpl.class);


  @Override
  public Author getAuthor(final Integer authorId) throws TechnicalException, NotFoundException {

    final String sql = "SELECT * FROM author WHERE author_id = :authorId";

    final MapSqlParameterSource parameterSource = new MapSqlParameterSource();
    parameterSource.addValue("authorId", authorId);

    final RowMapper<Author> rowMapper = new AuthorRM();

    try {
      this.getNamedJdbcTemplate().toString();
      return this.getNamedJdbcTemplate().queryForObject(sql, parameterSource, rowMapper);
    } catch (EmptyResultDataAccessException exception) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("SQL : " + sql);
        LOG.debug("authorId = " + authorId);
      }
      LOG.error(exception.getMessage());
      throw new NotFoundException("L'auteur demandé n'a pas été trouvé", exception);
    } catch (PermissionDeniedDataAccessException exception) {
      LOG.error(exception.getMessage());
      throw new TechnicalException(messages.getString("test"));
    }
  }

  @Override
  public List<Author> getBookAuthors(final Integer bookId) throws TechnicalException, NotFoundException {
    return null;
  }

  @Override
  public void updateAuthor(final Author author) throws TechnicalException, NotFoundException {

  }

  @Override
  public int insertAuthor(final Author author) throws TechnicalException {
    return 0;
  }

  @Override
  public void deleteAuthor(final Integer authorId) throws TechnicalException, NotFoundException {

  }
}
