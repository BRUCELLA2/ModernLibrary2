package fr.brucella.projects.libraryws.dao.impl.rowmapper.books.model;

import fr.brucella.projects.libraryws.entity.books.model.Publisher;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 * This class allow to map row of ResultSet to an Publisher object.
 *
 * @author BRUCELLA2
 */
public class PublisherRM implements RowMapper<Publisher> {

  /** Default Constructor. */
  public PublisherRM() {}

  /** {@inheritDoc} */
  @Override
  public Publisher mapRow(final ResultSet resultSet, final int rowNum) throws SQLException {

    final Publisher publisher = new Publisher();

    publisher.setPublisherId(resultSet.getInt("publisher_id"));
    publisher.setName(resultSet.getString("name"));

    return publisher;
  }
}
