package fr.brucella.projects.libraryclients.webapp.actions.bookslisting;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import generated.authentificationserviceclient.FullUserDto;
import generated.bookserviceclient.BookReservation;
import generated.bookserviceclient.BookService;
import generated.bookserviceclient.BookService_Service;
import generated.bookserviceclient.LibraryWsException;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

public class ReservationsListingAction extends ActionSupport implements SessionAware, ServletRequestAware {

  // ----- Logger
  /**
   * Reservations Listing Action logger.
   */
  private static final Log LOG = LogFactory.getLog(ReservationsListingAction.class);

  /**
   * the user's HTTP session attributes.
   */
  private Map<String, Object> session;

  /**
   * The Http Servlet Request. Used to get session informations.
   */
  private HttpServletRequest servletRequest;

  // ----- Output

  private List<BookReservation> reservationList;


  // ----- Getters and Setters

  /**
   * Give the list of BookReservations.
   *
   * @return the list of BookReservations.
   */
  public List<BookReservation> getReservationList() {
    return reservationList;
  }

  /**
   * Set the list of BookReservations.
   *
   * @param reservationList the list of BookReservations.
   */
  public void setReservationList(final List<BookReservation> reservationList) {
    this.reservationList = reservationList;
  }

  /**
   * Set the Http Servlet Request.
   */
  @Override
  public void setServletRequest(final HttpServletRequest request) {
    this.servletRequest = request;
  }

  /**
   * Set the user's HTTP session attributes.
   */
  @Override
  public void setSession(final Map<String, Object> session) {
    this.session = session;
  }


  // ===== Methods =====

  public String currentlyReservations() {

    BookService_Service bookservice = new BookService_Service();
    BookService bookServicePort = bookservice.getBookServicePort();

    try {
      FullUserDto fullUserDto = (FullUserDto) this.servletRequest.getSession().getAttribute("userLog");
      setReservationList(bookServicePort.userReservations(fullUserDto.getUserId()));
    } catch (LibraryWsException exception) {
      LOG.error(exception.getMessage());
      LOG.error(exception.getFaultInfo().getFaultString());
    }

    return Action.SUCCESS;
  }

  public int position(BookReservation bookReservation) {

    BookService_Service bookService = new BookService_Service();
    BookService bookServicePort = bookService.getBookServicePort();

    List<BookReservation> list;
    FullUserDto fullUserDto;
    try {
      list = bookServicePort.bookReservations(bookReservation.getBookId());
      fullUserDto = (FullUserDto) this.servletRequest.getSession().getAttribute("userLog");
      setReservationList(bookServicePort.userReservations(fullUserDto.getUserId()));
    } catch (LibraryWsException exception) {
      LOG.error(exception.getMessage());
      LOG.error(exception.getFaultInfo().getFaultString());
      return 0;
    }

    int position = 0;
    for(BookReservation reservation : list) {
      position++;
      if(reservation.getUserId().equals(fullUserDto.getUserId())) {
        return position;
      }
    }

    LOG.error("No reservation found for the user");
    return 0;
  }


  public int nbReservations(BookReservation bookReservation) {

    BookService_Service bookService = new BookService_Service();
    BookService bookServicePort = bookService.getBookServicePort();

    List<BookReservation> list;
    try {
      list = bookServicePort.bookReservations(bookReservation.getBookId());
      return list.size();
    } catch (LibraryWsException exception) {
      LOG.error(exception.getMessage());
      LOG.error(exception.getFaultInfo().getFaultString());
      return 0;
    }
  }

}
