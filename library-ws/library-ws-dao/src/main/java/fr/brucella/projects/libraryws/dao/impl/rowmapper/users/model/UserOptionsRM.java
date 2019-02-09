package fr.brucella.projects.libraryws.dao.impl.rowmapper.users.model;

import fr.brucella.projects.libraryws.entity.users.model.UserOptions;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 * This class allow to map row of ResultSet to a UserOptions object.
 *
 * @author BRUCELLA2
 */
public class UserOptionsRM implements RowMapper<UserOptions> {

  /** Default Constructor */
  public UserOptionsRM() {
    // This constructor is intentionally empty. Nothing special is needed here.
  }

  /** {@inheritDoc} */
  @Override
  public UserOptions mapRow(final ResultSet resultSet, final int rowNum) throws SQLException {

    final UserOptions userOptions = new UserOptions();

    userOptions.setUserOptionsId(resultSet.getInt("user_options_id"));
    userOptions.setBeforeReminder(resultSet.getBoolean("before_reminder"));

    return userOptions;
  }
}
