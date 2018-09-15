package fr.brucella.projects.libraryws.business.impl.managers;

import fr.brucella.projects.libraryws.dao.contracts.dao.DaoFactory;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.ResourceBundle;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Abstract Manager.
 *
 * @author BRUCELLA2
 */
@Component
public abstract class AbstractManager {

  /** The Data Access Object Factory. */
  @Autowired private DaoFactory daoFactory;

  /** ResourceBundle messages */
  protected static ResourceBundle messages =
      ResourceBundle.getBundle("fr/brucella/projects/libraryws/business/messagesManager");

  /** config properties */
  protected static ResourceBundle config = ResourceBundle.getBundle("fr/brucella/projects/libraryws/business/config");

  /**
   * Give the DAO Factory.
   *
   * @return the DAO Factory.
   */
  public DaoFactory getDaoFactory() {
    return this.daoFactory;
  }

  /**
   * Give the constraint Validator.
   *
   * @return the constraint validator.
   */
  protected Validator getConstraintValidator() {
    final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    return factory.getValidator();
  }
}
