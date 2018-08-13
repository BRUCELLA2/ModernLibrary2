package fr.brucella.projects.libraryclients.webapp.actions;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import generated.authentificationserviceclient.AuthentificationService;
import generated.authentificationserviceclient.AuthentificationService_Service;
import generated.authentificationserviceclient.User;
import generated.bookserviceclient.BookDetailsDto;
import generated.bookserviceclient.BookService;
import generated.bookserviceclient.BookService_Service;
import generated.bookserviceclient.LibraryWsException;
import java.util.List;


public class BooksListingAction extends ActionSupport {

  /**
   * Get the list of all Book.
   *
   * @return ERROR if error occurred SUCCESS otherwise
   */
  public String getAllBook() {

    BookService_Service bookservice = new BookService_Service();

    BookService bookServicePort = bookservice.getBookServicePort();

    List<BookDetailsDto> books;
    try {
      books = bookServicePort.allBooks();
    } catch (LibraryWsException e) {
      e.printStackTrace();
      return Action.ERROR;
    }
    for (BookDetailsDto book : books) {
      System.out.println(book.getTitle());
    }

    return Action.SUCCESS;
  }

  public String login(){

    AuthentificationService_Service authentificationService = new AuthentificationService_Service();

    AuthentificationService authentificationServicePort = authentificationService.getAuthentificationServicePort();
    User user;
    user = authentificationServicePort.login("fred", "fredpass");

    System.out.println(user.getEmail());

    return Action.SUCCESS;
  }
}
