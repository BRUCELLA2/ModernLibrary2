package fr.brucella.projects.services.bookservices;

import fr.brucella.projects.libraryws.entity.books.Book;
import java.util.ArrayList;
import java.util.List;

public class BookListingImpl implements BookListing {

  List<Book> bookList;

  public List<Book> allBooks() {
    bookList = new ArrayList<>();
    return bookList;
  }
}
