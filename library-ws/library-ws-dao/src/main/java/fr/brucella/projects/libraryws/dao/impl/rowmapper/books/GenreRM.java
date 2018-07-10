package fr.brucella.projects.libraryws.dao.impl.rowmapper.books;

import fr.brucella.projects.libraryws.entity.books.model.Genre;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 * This class allow to map row of ResultSet to a Genre object.
 *
 * @author BRUCELLA2
 */
public class GenreRM implements RowMapper<Genre> {

  /** Default Constructor */
  public GenreRM() {}

  /** {@inheritDoc} */
  @Override
  public Genre mapRow(final ResultSet resultSet, final int rowNum) throws SQLException {

    final Genre genre = new Genre();

    genre.setGenreId(resultSet.getInt("genre_id"));
    genre.setName(resultSet.getString("name"));

    return genre;
  }
}
