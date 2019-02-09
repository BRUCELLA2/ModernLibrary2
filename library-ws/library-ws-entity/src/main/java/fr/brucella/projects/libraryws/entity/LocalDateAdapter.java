package fr.brucella.projects.libraryws.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * LocalDate formatter.
 *
 * @author BRUCELLA2
 */
public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {

  /** Date Time Formatter. */
  private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

  // ===== Constructor =====

  /** Default constuctor. */
  public LocalDateAdapter() {
    super();
  }

  // ===== Methods =====

  /** {@inheritDoc} */
  @Override
  public LocalDate unmarshal(final String date) {

    return LocalDate.parse(date, formatter);
  }

  /** {@inheritDoc} */
  @Override
  public String marshal(final LocalDate date) {

    return formatter.format(date);
  }
}
