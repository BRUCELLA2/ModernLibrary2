package fr.brucella.projects.libraryws.dao.impl.rowmapper.users.dto;

import fr.brucella.projects.libraryws.entity.users.dto.FullUserDto;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 * This class allow to map row of ResultSet to an FullUserDto object. The list of role is set to
 * null. An update of the FullUserDtoRM is necessary after row mapping to set the list of roles.
 *
 * @author BRUCELLA2
 */
public class FullUserDtoRM implements RowMapper<FullUserDto> {

  /** Default Constructor */
  public FullUserDtoRM() {}

  /** {@inheritDoc} */
  @Override
  public FullUserDto mapRow(final ResultSet resultSet, int rowNum) throws SQLException {

    final FullUserDto fullUserDto = new FullUserDto();

    fullUserDto.setAddressId(resultSet.getInt("address_id"));
    fullUserDto.setEmail(resultSet.getString("email"));
    fullUserDto.setLogin(resultSet.getString("login"));
    fullUserDto.setPassword(resultSet.getString("password"));
    if (resultSet.getString("phone") == null) {
      fullUserDto.setPhone(null);
    } else {
      fullUserDto.setPhone(resultSet.getString("phone"));
    }
    fullUserDto.setUserId(resultSet.getInt("user_id"));
    fullUserDto.setCity(resultSet.getString("city"));

    if (resultSet.getString("line1") == null) {
      fullUserDto.setLine1(null);
    } else {
      fullUserDto.setLine1(resultSet.getString("line1"));
    }

    if (resultSet.getString("line2") == null) {
      fullUserDto.setLine2(null);
    } else {
      fullUserDto.setLine2(resultSet.getString("line2"));
    }

    if (resultSet.getString("line3") == null) {
      fullUserDto.setLine3(null);
    } else {
      fullUserDto.setLine3(resultSet.getString("line3"));
    }

    fullUserDto.setZipCode(resultSet.getString("zip_code"));
    fullUserDto.setRoles(null);

    fullUserDto.setUserOptionsId(resultSet.getInt("user_options_id"));
    fullUserDto.setBeforeReminder(resultSet.getBoolean("before_reminder"));

    return fullUserDto;
  }
}
