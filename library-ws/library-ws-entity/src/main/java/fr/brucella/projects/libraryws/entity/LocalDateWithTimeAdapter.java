package fr.brucella.projects.libraryws.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class LocalDateWithTimeAdapter extends XmlAdapter<String, LocalDateTime> {

  private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

  // ===== Methods =====

  @Override
  public LocalDateTime unmarshal(String date) {
    return LocalDateTime.parse(date, formatter);
  }

  @Override
  public String marshal(LocalDateTime date) {
    return formatter.format(date);
  }
}
