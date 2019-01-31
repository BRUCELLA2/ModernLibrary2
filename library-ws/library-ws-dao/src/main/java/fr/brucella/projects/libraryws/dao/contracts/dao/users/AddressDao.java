package fr.brucella.projects.libraryws.dao.contracts.dao.users;

import fr.brucella.projects.libraryws.entity.exceptions.NotFoundException;
import fr.brucella.projects.libraryws.entity.exceptions.TechnicalException;
import fr.brucella.projects.libraryws.entity.users.model.Address;

/**
 * Interface for Address Data Access Object.
 *
 * @author BRUCELLA2
 */
public interface AddressDao {

  /**
   * Give the address with the specified id from datastore.
   *
   * @param addressId id of the address.
   * @return the address with the specified id.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and the
   *     address is not found.
   */
  Address getAddress(final Integer addressId) throws TechnicalException, NotFoundException;

  /**
   * Update an existing address in the datastore.
   *
   * @param address the address with the updated informations to save in datastore.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and the
   *     address is not found.
   */
  void updateAddress(final Address address) throws TechnicalException, NotFoundException;

  /**
   * Insert a new address in the datastore.
   *
   * @param address the address to insert in datastore.
   * @return the id of the new address.
   * @throws TechnicalException - wraps technical exception caused during data access.
   */
  int insertAddress(final Address address) throws TechnicalException;

  /**
   * Delete the address with the specified id in the datastore.
   *
   * @param addressId id of the address.
   * @throws TechnicalException - wraps technical exception caused during data access.
   * @throws NotFoundException - This exception is throws if there is no technical exception and the
   *     address is not found.
   */
  void deleteAddress(final Integer addressId) throws TechnicalException, NotFoundException;
}
