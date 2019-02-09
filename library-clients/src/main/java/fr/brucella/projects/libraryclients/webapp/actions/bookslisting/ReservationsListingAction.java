package fr.brucella.projects.libraryclients.webapp.actions.bookslisting;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import generated.authentificationserviceclient.FullUserDto;
import generated.bookserviceclient.BookReservation;
import generated.bookserviceclient.BookService;
import generated.bookserviceclient.BookService_Service;
import generated.bookserviceclient.LibraryWsException;
import generated.bookserviceclient.ReservationDetailsDto;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

/**
 * Reservations listing actions.
 *
 * @author BRUCELLA2
 */
public class ReservationsListingAction extends ActionSupport
    implements SessionAware, ServletRequestAware {

  // ----- Logger
  /** Reservations Listing Action logger. */
  private static final Log LOG = LogFactory.getLog(ReservationsListingAction.class);

  /** the user's HTTP session attributes. */
  private Map<String, Object> session;

  /** The Http Servlet Request. Used to get session informations. */
  private HttpServletRequest servletRequest;

  // ----- Output

  /** The list of ReservationDetailsDto. */
  private List<ReservationDetailsDto> reservationList;

  // ----- Constructors

  /** Default constructor. */
  public ReservationsListingAction() {
    // This constructor is intentionally empty. Nothing special is needed here.
  }

  // ----- Getters and Setters

  /**
   * Give the list of BookReservations.
   *
   * @return the list of BookReservations.
   */
  public List<ReservationDetailsDto> getReservationList() {
    return reservationList;
  }

  /**
   * Set the list of BookReservations.
   *
   * @param reservationList the list of BookReservations.
   */
  public void setReservationList(final List<ReservationDetailsDto> reservationList) {
    this.reservationList = reservationList;
  }

  /** Set the Http Servlet Request. */
  @Override
  public void setServletRequest(final HttpServletRequest request) {
    this.servletRequest = request;
  }

  /** Set the user's HTTP session attributes. */
  @Override
  public void setSession(final Map<String, Object> session) {
    this.session = session;
  }

  // ===== Methods =====

  /**
   * Action that provides the currently reservations for the user.
   *
   * @return Action.SUCCESS
   */
  public String currentlyReservations() {

    final BookService_Service bookservice = new BookService_Service();
    final BookService bookServicePort = bookservice.getBookServicePort();

    try {
      final FullUserDto fullUserDto =
          (FullUserDto) this.servletRequest.getSession().getAttribute("userLog");
      setReservationList(bookServicePort.userReservations(fullUserDto.getUserId()));
    } catch (LibraryWsException exception) {
      LOG.error(exception.getMessage());
      LOG.error(exception.getFaultInfo().getFaultString());
    }

    return Action.SUCCESS;
  }

  /**
   * Give the position of the user's reservation into the list of the reservations for a book.
   *
   * @param bookReservation ReservationDetailsDto.
   * @return the position of the user's reservation or 0 if there is an error.
   */
  public int position(final ReservationDetailsDto bookReservation) {

    final BookService_Service bookService = new BookService_Service();
    final BookService bookServicePort = bookService.getBookServicePort();

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
    for (final BookReservation reservation : list) {
      position++;
      if (reservation.getUserId().equals(fullUserDto.getUserId())) {
        return position;
      }
    }

    LOG.error("No reservation found for the user");
    return 0;
  }

  /**
   * Give the number of reservations for a book.
   *
   * @param bookReservation Book reservation containing the book id.
   * @return the number of reservations for a book.
   */
  public int nbReservations(final BookReservation bookReservation) {

    final BookService_Service bookService = new BookService_Service();
    final BookService bookServicePort = bookService.getBookServicePort();

    List<BookReservation> list = new ArrayList<>();
    try {
      list = bookServicePort.bookReservations(bookReservation.getBookId());
    } catch (LibraryWsException exception) {
      LOG.error(exception.getMessage());
      LOG.error(exception.getFaultInfo().getFaultString());
    }

    return list.size();
  }
}
