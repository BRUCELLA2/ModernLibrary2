package fr.brucella.projects.libraryws.dao.impl.rowmapper.users.model;

import fr.brucella.projects.libraryws.entity.users.model.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 * This class allow to map row of ResultSet to an User Object.
 *
 * @author BRUCELLA2
 */
public class UserRM implements RowMapper<User> {

  /** Default Constructor */
  public UserRM() {}

  /** {@inheritDoc} */
  @Override
  public User mapRow(final ResultSet resultSet, final int rowNum) throws SQLException {

    final User user = new User();

    user.setAddressId(resultSet.getInt("address_id"));
    user.setEmail(resultSet.getString("email"));
    user.setLogin(resultSet.getString("login"));
    user.setPassword(resultSet.getString("password"));
    if (resultSet.getString("phone") == null) {
      user.setPhone(null);
    } else {
      user.setPhone(resultSet.getString("phone"));
    }
    user.setUserId(resultSet.getInt("user_id"));
    user.setUserOptionsId(resultSet.getInt("user_options_id"));

    return user;
  }
}
