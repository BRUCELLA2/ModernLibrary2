package fr.brucella.projects.libraryws.dao.impl.rowmapper.books.model;

import fr.brucella.projects.libraryws.entity.books.model.Author;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 * This class allow to map row of ResultSet to an Author object.
 *
 * @author BRUCELLA2
 */
public class AuthorRM implements RowMapper<Author> {

  /** Default Constructor */
  public AuthorRM() {
    // This constructor is intentionally empty. Nothing special is needed here.
  }

  /** {@inheritDoc} */
  @Override
  public Author mapRow(final ResultSet resultSet, final int rowNum) throws SQLException {

    final Author author = new Author();

    author.setAuthorId(resultSet.getInt("author_id"));
    author.setFirstName(resultSet.getString("first_name"));
    author.setLastName(resultSet.getString("last_name"));

    return author;
  }
}
