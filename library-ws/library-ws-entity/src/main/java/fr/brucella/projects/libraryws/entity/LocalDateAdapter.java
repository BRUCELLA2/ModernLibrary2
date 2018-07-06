package fr.brucella.projects.libraryws.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {

  private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");

  @Override
  public LocalDate unmarshal(String date) throws Exception {

    return LocalDate.parse(date, formatter);
  }

  @Override
  public String marshal(LocalDate date) throws Exception {

    return formatter.format(date);
  }
}
