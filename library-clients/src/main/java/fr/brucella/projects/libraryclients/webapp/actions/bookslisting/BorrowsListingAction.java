package fr.brucella.projects.libraryclients.webapp.actions.bookslisting;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import generated.authentificationserviceclient.FullUserDto;
import generated.bookserviceclient.BookService;
import generated.bookserviceclient.BookService_Service;
import generated.bookserviceclient.BorrowDto;
import generated.bookserviceclient.LibraryWsException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

/**
 * Borrows listing action.
 *
 * @author BRUCELLA2
 */
public class BorrowsListingAction extends ActionSupport
    implements SessionAware, ServletRequestAware {

  // ----- Logger
  /** Borrows Listing Action logger. */
  private static final Log LOG = LogFactory.getLog(BorrowsListingAction.class);

  /** the user's HTTP session attributes. */
  private Map<String, Object> session;

  /** The Http Servlet Request. Used to get session informations. */
  private HttpServletRequest servletRequest;

  // ----- Output
  /** A list of Borrow Dto. */
  private List<BorrowDto> borrowsList;

  // ----- Constructors

  /** Default constructor. */
  public BorrowsListingAction() {
    // This constructor is intentionally empty. Nothing special is needed here.
  }

  // ----- Getters and Setters

  /**
   * Give the list of Borrow Dto.
   *
   * @return the list of Borrow Dto.
   */
  public List<BorrowDto> getBorrowsList() {
    return borrowsList;
  }

  /**
   * Set the list of Borrow Dto.
   *
   * @param borrowsList the list of Borrow Dto.
   */
  public void setBorrowsList(final List<BorrowDto> borrowsList) {
    this.borrowsList = borrowsList;
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
   * Action that provide currently borrows for the user.
   *
   * @return Action.SUCCESS or Action.ERROR if errors occurred.
   */
  public String currentlyBorrows() {

    final BookService_Service bookservice = new BookService_Service();
    final BookService bookServicePort = bookservice.getBookServicePort();

    try {
      final FullUserDto fullUserDto =
          (FullUserDto) this.servletRequest.getSession().getAttribute("userLog");
      setBorrowsList(bookServicePort.currentlyBorrowForUser(fullUserDto.getUserId()));
    } catch (LibraryWsException exception) {
      LOG.error(exception.getMessage());
      LOG.error(exception.getFaultInfo().getFaultString());
      this.addActionError(exception.getFaultInfo().getFaultString());
      return Action.ERROR;
    }

    return Action.SUCCESS;
  }

  /**
   * Action that provide history of borrows for the user.
   *
   * @return Action.SUCCESS or Action.ERROR if errors occurred.
   */
  public String borrowsHistory() {

    final BookService_Service bookservice = new BookService_Service();
    final BookService bookServicePort = bookservice.getBookServicePort();

    try {
      final FullUserDto fullUserDto =
          (FullUserDto) this.servletRequest.getSession().getAttribute("userLog");
      setBorrowsList(bookServicePort.returnedBorrowsForUser(fullUserDto.getUserId()));
    } catch (LibraryWsException exception) {
      LOG.error(exception.getMessage());
      LOG.error(exception.getFaultInfo().getFaultString());
      this.addActionError(exception.getFaultInfo().getFaultString());
      return Action.ERROR;
    }

    return Action.SUCCESS;
  }

  /*
   @TICKET #2
   Check if a date is before Now.
   This method is called in the fix solution to the problem of borrowing after the end date of borrows.
  */

  /**
   * Check if the date is before now.
   *
   * @param borrowDto borrowDto that contains the date to check.
   * @return true if the date is before now or false is after or equals to now.
   */
  public String isBeforeToNow(final BorrowDto borrowDto) {
    final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    final LocalDate endDate = LocalDate.parse(borrowDto.getEndDate(), formatter);
    if (endDate.isBefore(LocalDate.now())) {
      return "true";
    } else {
      return "false";
    }
  }
}
