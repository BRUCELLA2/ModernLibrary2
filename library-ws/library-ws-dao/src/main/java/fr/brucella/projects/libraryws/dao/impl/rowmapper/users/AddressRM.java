package fr.brucella.projects.libraryws.dao.impl.rowmapper.users;

import fr.brucella.projects.libraryws.entity.users.model.Address;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 * This class allow to map row of ResultSet to an Address object.
 *
 * @author BRUCELLA2
 */
public class AddressRM implements RowMapper<Address> {

  /** Default Constructor. */
  public AddressRM() {}

  /** {@inheritDoc} */
  @Override
  public Address mapRow(ResultSet resultSet, int rowNum) throws SQLException {

    final Address address = new Address();

    address.setAddressId(resultSet.getInt("address_id"));
    address.setCity(resultSet.getString("city"));
    address.setLine1(resultSet.getString("line1"));
    address.setLine2(resultSet.getString("line2"));
    address.setLine3(resultSet.getString("line3"));
    address.setZipCode(resultSet.getString("zip_code"));

    return address;
  }
}
