package fr.brucella.projects.libraryclients.webapp.actions;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import generated.bookserviceclient.BookDetailsDto;
import generated.bookserviceclient.BookService;
import generated.bookserviceclient.BookService_Service;
import generated.bookserviceclient.BooksSearchClientCriteriaDto;
import generated.bookserviceclient.LibraryWsException;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class BooksListingAction extends ActionSupport {

  // ----- Logger
  /**
   * Book Listing Action logger.
   */
  private static final Log LOG = LogFactory.getLog(BooksListingAction.class);

  // ----- Input

  /**
   * Last name of the author. Can be empty. Max size = 50
   */
  private String authorLastName;

  /**
   * String indicating if the book need to be available for a borrow. "true" or "false"
   */
  private String bookAvailable;

  /**
   * ean13 of the book. Can be empty. Max size = 13. If not empty, size need to be 13
   */
  private String ean13;

  /**
   * Name of the genre. Can be empty. Max size = 50
   */
  private String genreName;

  /**
   * Name of the publisher. Can be empty. Max size = 100
   */
  private String publisherName;

  /**
   * Title of the book. Can be empty. Max size = 150
   */
  private String title;

  // ----- Output
  /**
   * A list of BookDetailsDto
   */
  private List<BookDetailsDto> booksList;

  // ----- Getters and Setters

  /**
   * Give the last name of the author.
   *
   * @return the last name of the author.
   */
  public String getAuthorLastName() {
    return authorLastName;
  }

  /**
   * Set the last name of the author.
   *
   * @param authorLastName
   *     the last name of the author.
   */
  public void setAuthorLastName(final String authorLastName) {
    LOG.error("Author : " + this.authorLastName);
    this.authorLastName = authorLastName;
  }


  /**
   * Indicate if the book need to be available for a borrow.
   *
   * @return the string "true" if the book need to be available, "false" otherwise.
   */
  public String getBookAvailable() {
    return bookAvailable;
  }


  /**
   * Indicate if the book need to be available for a borrow.
   *
   * @param bookAvailable
   *     "true" if the book need to be available, "false" otherwise.
   */
  public void setBookAvailable(final String bookAvailable) {
    this.bookAvailable = bookAvailable;
  }


  /**
   * Give the EAN13 of the book.
   *
   * @return the EAN13 of the book.
   */
  public String getEan13() {
    return ean13;
  }

  /**
   * Set the EAN13 of the book.
   *
   * @param ean13
   *     the EAN13 of the book.
   */
  public void setEan13(final String ean13) {
    this.ean13 = ean13;
  }

  /**
   * Give the name of the genre.
   *
   * @return name of the genre.
   */
  public String getGenreName() {
    return genreName;
  }

  /**
   * Set the name of the genre.
   *
   * @param genreName
   *     name of the genre.
   */
  public void setGenreName(final String genreName) {
    this.genreName = genreName;
  }

  /**
   * Give the name of the publisher.
   *
   * @return the name of the publisher.
   */
  public String getPublisherName() {
    return publisherName;
  }

  /**
   * Set the name of the publisher.
   *
   * @param publisherName
   *     the name of the publisher.
   */
  public void setPublisherName(final String publisherName) {
    this.publisherName = publisherName;
  }

  /**
   * Give the title of the book.
   *
   * @return the title of the book.
   */
  public String getTitle() {
    return title;
  }

  /**
   * Set the title of the book.
   *
   * @param title
   *     the title of the book.
   */
  public void setTitle(final String title) {
    this.title = title;
  }

  /**
   * Give the list of Book Details Dto
   *
   * @return the list of Book Details Dto
   */
  public List<BookDetailsDto> getBooksList() {
    return booksList;
  }

  /**
   * Set the list of Book Details Dto
   *
   * @param booksList
   *     the list of Book Details Dto
   */
  public void setBooksList(List<BookDetailsDto> booksList) {
    this.booksList = booksList;
  }

  // ===== Methods =====

  public String SearchBooks() {

    BooksSearchClientCriteriaDto booksSearchClientCriteriaDto = new BooksSearchClientCriteriaDto();
    if (StringUtils.isAllEmpty(this.authorLastName, this.bookAvailable, this.ean13, this.genreName, this.publisherName,
        this.title)) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("author name, book available, ean13, genre name, publisher name and title = null");
      }
      booksSearchClientCriteriaDto = null;
    } else {
      booksSearchClientCriteriaDto.setAuthorLastName(this.authorLastName);
      if (StringUtils.equals(this.bookAvailable, "true")) {
        booksSearchClientCriteriaDto.setBookAvailable(true);
      } else {
        booksSearchClientCriteriaDto.setBookAvailable(false);
      }
      booksSearchClientCriteriaDto.setEan13(this.ean13);
      booksSearchClientCriteriaDto.setGenreName(this.genreName);
      booksSearchClientCriteriaDto.setPublisherName(this.publisherName);
      booksSearchClientCriteriaDto.setTitle(this.title);
    }
    BookService_Service bookservice = new BookService_Service();
    BookService bookServicePort = bookservice.getBookServicePort();

    try {
      this.setBooksList(bookServicePort.booksSearchedList(booksSearchClientCriteriaDto));
    } catch (LibraryWsException exception) {
      LOG.error(exception.getMessage());
      LOG.error(exception.getFaultInfo().getFaultString());
      this.addActionError(exception.getMessage());
      return Action.ERROR;
    }

    return Action.SUCCESS;
  }

/**
 public String getAllBook() {

 BookService_Service bookservice = new BookService_Service();

 BookService bookServicePort = bookservice.getBookServicePort();

 List<BookDetailsDto> books = new ArrayList<>();
 try {
 books = bookServicePort.allBooks();
 } catch (generated.bookserviceclient.LibraryWsException e) {
 e.printStackTrace();
 }
 for (BookDetailsDto book : books) {
 System.out.println(book.getTitle());
 }

 return Action.SUCCESS;
 }

 public String login(){

 AuthentificationService_Service authentificationService = new AuthentificationService_Service();
 AuthentificationService authentificationServicePort = authentificationService.getAuthentificationServicePort();

 FullUserDto user;
 try{
 user = authentificationServicePort.login("fred", "fred");
 } catch (generated.authentificationserviceclient.LibraryWsException exception){
 exception.printStackTrace();
 return Action.ERROR;
 }

 System.out.println(user.getUserId());

 return Action.SUCCESS;

 }
 */

}
