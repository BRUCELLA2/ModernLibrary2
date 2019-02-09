package fr.brucella.projects.libraryws.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * LocalDateTime formatter.
 *
 * @author BRUCELLA2
 */
public class LocalDateWithTimeAdapter extends XmlAdapter<String, LocalDateTime> {

  /** DateTime formatter. */
  private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

  /** Default constructor. */
  public LocalDateWithTimeAdapter() {
    super();
  }

  // ===== Methods =====

  /** {@inheritDoc} */
  @Override
  public LocalDateTime unmarshal(String date) {
    return LocalDateTime.parse(date, formatter);
  }

  /** {@inheritDoc} */
  @Override
  public String marshal(final LocalDateTime date) {
    return formatter.format(date);
  }
}
