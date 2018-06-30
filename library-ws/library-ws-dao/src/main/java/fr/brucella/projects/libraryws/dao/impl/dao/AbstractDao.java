package fr.brucella.projects.libraryws.dao.impl.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * Abstract class inherited by all Data Access Object implementations.
 *
 * @author BRUCELLA
 */
@Component
public abstract class AbstractDao {

  /**
   * jdbc template.
   *
   * @see #getJdbcTemplate()
   * @see #setJdbcTemplate(JdbcTemplate)
   */
  @Autowired private JdbcTemplate jdbcTemplate;

  /**
   * jdbc template with named parameter template.
   *
   * @see #getNamedJdbcTemplate()
   * @see #setNamedJdbcTemplate(NamedParameterJdbcTemplate)
   */
  @Autowired private NamedParameterJdbcTemplate namedJdbcTemplate;

  // ----- Getters -----

  /**
   * Get the JdbcTemplate.
   *
   * @return the JdbcTemplate
   * @see #jdbcTemplate
   * @see #setJdbcTemplate(JdbcTemplate)
   */
  public JdbcTemplate getJdbcTemplate() {
    return this.jdbcTemplate;
  }

  /**
   * Get the NamedJdbcTemplate.
   *
   * @return the NamedJdbcTemplate
   * @see #namedJdbcTemplate
   * @see #setNamedJdbcTemplate(NamedParameterJdbcTemplate)
   */
  public NamedParameterJdbcTemplate getNamedJdbcTemplate() {
    return this.namedJdbcTemplate;
  }

  // ----- Setters -----

  /**
   * Set the JdbcTemplate.
   *
   * @param jdbcTemplate the JdbcTemplate.
   * @see #jdbcTemplate
   * @see #getJdbcTemplate()
   */
  public void setJdbcTemplate(final JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  /**
   * Set the NamedJdbcTemplate.
   *
   * @param namedJdbcTemplate the NamedJdbcTemplate.
   * @see #namedJdbcTemplate
   * @see #getNamedJdbcTemplate()
   */
  public void setNamedJdbcTemplate(final NamedParameterJdbcTemplate namedJdbcTemplate) {
    this.namedJdbcTemplate = namedJdbcTemplate;
  }
}
