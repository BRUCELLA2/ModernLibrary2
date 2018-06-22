package fr.brucella.projects.services.bookservices;

import fr.brucella.projects.libraryws.entity.books.Book;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(serviceName = "BookListing")
public interface BookListing {

  @WebMethod
  List<Book> allBooks();


}
