package generated.bookserviceclient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * This object contains factory methods for each Java content interface and Java element interface
 * generated in the generated.bookserviceclient package.
 *
 * <p>An ObjectFactory allows you to programatically construct new instances of the Java
 * representation for XML content. The Java representation of XML content can consist of schema
 * derived interfaces and classes representing the binding of schema type definitions, element
 * declarations and model groups. Factory methods for each of these are provided in this class.
 */
@XmlRegistry
public class ObjectFactory {

  private static final QName _UserReservationsResponse_QNAME =
      new QName("http://services.libraryws.projects.brucella.fr/", "userReservationsResponse");
  private static final QName _CheckReservationNotPickedUpResponse_QNAME =
      new QName(
          "http://services.libraryws.projects.brucella.fr/", "checkReservationNotPickedUpResponse");
  private static final QName _CurrentlyDeadLineExpiredForUserResponse_QNAME =
      new QName(
          "http://services.libraryws.projects.brucella.fr/",
          "currentlyDeadLineExpiredForUserResponse");
  private static final QName _NbBorrowingByBooks_QNAME =
      new QName("http://services.libraryws.projects.brucella.fr/", "nbBorrowingByBooks");
  private static final QName _ReturnedBorrowsForUserResponse_QNAME =
      new QName(
          "http://services.libraryws.projects.brucella.fr/", "returnedBorrowsForUserResponse");
  private static final QName _AvailableBooksListResponse_QNAME =
      new QName("http://services.libraryws.projects.brucella.fr/", "availableBooksListResponse");
  private static final QName _BookBorrow_QNAME =
      new QName("http://services.libraryws.projects.brucella.fr/", "bookBorrow");
  private static final QName _BookDetails_QNAME =
      new QName("http://services.libraryws.projects.brucella.fr/", "bookDetails");
  private static final QName _SendReminderBeforeExpirationToUsers_QNAME =
      new QName(
          "http://services.libraryws.projects.brucella.fr/", "sendReminderBeforeExpirationToUsers");
  private static final QName _CheckReservationNotPickedUp_QNAME =
      new QName("http://services.libraryws.projects.brucella.fr/", "checkReservationNotPickedUp");
  private static final QName _UserReservations_QNAME =
      new QName("http://services.libraryws.projects.brucella.fr/", "userReservations");
  private static final QName _LibraryWsException_QNAME =
      new QName("http://services.libraryws.projects.brucella.fr/", "LibraryWsException");
  private static final QName _CurrentlyBooksBorrowedList_QNAME =
      new QName("http://services.libraryws.projects.brucella.fr/", "currentlyBooksBorrowedList");
  private static final QName _CancelAreservation_QNAME =
      new QName("http://services.libraryws.projects.brucella.fr/", "cancelAreservation");
  private static final QName _CurrentlyDeadlineExpiredUsersResponse_QNAME =
      new QName(
          "http://services.libraryws.projects.brucella.fr/",
          "currentlyDeadlineExpiredUsersResponse");
  private static final QName _ReturnedBorrowsForUser_QNAME =
      new QName("http://services.libraryws.projects.brucella.fr/", "returnedBorrowsForUser");
  private static final QName _SendReminderToUsersResponse_QNAME =
      new QName("http://services.libraryws.projects.brucella.fr/", "sendReminderToUsersResponse");
  private static final QName _BooksSearchedList_QNAME =
      new QName("http://services.libraryws.projects.brucella.fr/", "booksSearchedList");
  private static final QName _BookStocksListResponse_QNAME =
      new QName("http://services.libraryws.projects.brucella.fr/", "bookStocksListResponse");
  private static final QName _BookReservations_QNAME =
      new QName("http://services.libraryws.projects.brucella.fr/", "bookReservations");
  private static final QName _MakeReservation_QNAME =
      new QName("http://services.libraryws.projects.brucella.fr/", "makeReservation");
  private static final QName _AvailableBooksList_QNAME =
      new QName("http://services.libraryws.projects.brucella.fr/", "availableBooksList");
  private static final QName _ExtendBorrowingResponse_QNAME =
      new QName("http://services.libraryws.projects.brucella.fr/", "extendBorrowingResponse");
  private static final QName _CurrentlyBooksBorrowedListResponse_QNAME =
      new QName(
          "http://services.libraryws.projects.brucella.fr/", "currentlyBooksBorrowedListResponse");
  private static final QName _CurrentlyBorrowForUserResponse_QNAME =
      new QName(
          "http://services.libraryws.projects.brucella.fr/", "currentlyBorrowForUserResponse");
  private static final QName _SendReminderBeforeExpirationToUsersResponse_QNAME =
      new QName(
          "http://services.libraryws.projects.brucella.fr/",
          "sendReminderBeforeExpirationToUsersResponse");
  private static final QName _BorrowingReturn_QNAME =
      new QName("http://services.libraryws.projects.brucella.fr/", "borrowingReturn");
  private static final QName _ExtendBorrowing_QNAME =
      new QName("http://services.libraryws.projects.brucella.fr/", "extendBorrowing");
  private static final QName _NbBorrowingByBooksResponse_QNAME =
      new QName("http://services.libraryws.projects.brucella.fr/", "nbBorrowingByBooksResponse");
  private static final QName _BorrowingHistoryList_QNAME =
      new QName("http://services.libraryws.projects.brucella.fr/", "borrowingHistoryList");
  private static final QName _CancelAreservationResponse_QNAME =
      new QName("http://services.libraryws.projects.brucella.fr/", "cancelAreservationResponse");
  private static final QName _AllBooksResponse_QNAME =
      new QName("http://services.libraryws.projects.brucella.fr/", "allBooksResponse");
  private static final QName _BooksSearchedListResponse_QNAME =
      new QName("http://services.libraryws.projects.brucella.fr/", "booksSearchedListResponse");
  private static final QName _BookStocksList_QNAME =
      new QName("http://services.libraryws.projects.brucella.fr/", "bookStocksList");
  private static final QName _CurrentlyDeadlineExpiredResponse_QNAME =
      new QName(
          "http://services.libraryws.projects.brucella.fr/", "currentlyDeadlineExpiredResponse");
  private static final QName _CurrentlyDeadlineExpiredUsers_QNAME =
      new QName("http://services.libraryws.projects.brucella.fr/", "currentlyDeadlineExpiredUsers");
  private static final QName _SendReminderToUsers_QNAME =
      new QName("http://services.libraryws.projects.brucella.fr/", "sendReminderToUsers");
  private static final QName _BookBorrowResponse_QNAME =
      new QName("http://services.libraryws.projects.brucella.fr/", "bookBorrowResponse");
  private static final QName _CurrentlyBorrowForUser_QNAME =
      new QName("http://services.libraryws.projects.brucella.fr/", "currentlyBorrowForUser");
  private static final QName _AllBooks_QNAME =
      new QName("http://services.libraryws.projects.brucella.fr/", "allBooks");
  private static final QName _MakeReservationResponse_QNAME =
      new QName("http://services.libraryws.projects.brucella.fr/", "makeReservationResponse");
  private static final QName _BorrowingHistoryListResponse_QNAME =
      new QName("http://services.libraryws.projects.brucella.fr/", "borrowingHistoryListResponse");
  private static final QName _BorrowingReturnResponse_QNAME =
      new QName("http://services.libraryws.projects.brucella.fr/", "borrowingReturnResponse");
  private static final QName _BookReservationsResponse_QNAME =
      new QName("http://services.libraryws.projects.brucella.fr/", "bookReservationsResponse");
  private static final QName _CurrentlyDeadLineExpiredForUser_QNAME =
      new QName(
          "http://services.libraryws.projects.brucella.fr/", "currentlyDeadLineExpiredForUser");
  private static final QName _CurrentlyDeadlineExpired_QNAME =
      new QName("http://services.libraryws.projects.brucella.fr/", "currentlyDeadlineExpired");
  private static final QName _BookDetailsResponse_QNAME =
      new QName("http://services.libraryws.projects.brucella.fr/", "bookDetailsResponse");

  /**
   * Create a new ObjectFactory that can be used to create new instances of schema derived classes
   * for package: generated.bookserviceclient
   */
  public ObjectFactory() {}

  /** Create an instance of {@link CurrentlyDeadlineExpiredUsers } */
  public CurrentlyDeadlineExpiredUsers createCurrentlyDeadlineExpiredUsers() {
    return new CurrentlyDeadlineExpiredUsers();
  }

  /** Create an instance of {@link SendReminderToUsers } */
  public SendReminderToUsers createSendReminderToUsers() {
    return new SendReminderToUsers();
  }

  /** Create an instance of {@link BookBorrowResponse } */
  public BookBorrowResponse createBookBorrowResponse() {
    return new BookBorrowResponse();
  }

  /** Create an instance of {@link CurrentlyBorrowForUser } */
  public CurrentlyBorrowForUser createCurrentlyBorrowForUser() {
    return new CurrentlyBorrowForUser();
  }

  /** Create an instance of {@link BookStocksList } */
  public BookStocksList createBookStocksList() {
    return new BookStocksList();
  }

  /** Create an instance of {@link CurrentlyDeadlineExpiredResponse } */
  public CurrentlyDeadlineExpiredResponse createCurrentlyDeadlineExpiredResponse() {
    return new CurrentlyDeadlineExpiredResponse();
  }

  /** Create an instance of {@link ExtendBorrowing } */
  public ExtendBorrowing createExtendBorrowing() {
    return new ExtendBorrowing();
  }

  /** Create an instance of {@link NbBorrowingByBooksResponse } */
  public NbBorrowingByBooksResponse createNbBorrowingByBooksResponse() {
    return new NbBorrowingByBooksResponse();
  }

  /** Create an instance of {@link BorrowingHistoryList } */
  public BorrowingHistoryList createBorrowingHistoryList() {
    return new BorrowingHistoryList();
  }

  /** Create an instance of {@link CancelAreservationResponse } */
  public CancelAreservationResponse createCancelAreservationResponse() {
    return new CancelAreservationResponse();
  }

  /** Create an instance of {@link AllBooksResponse } */
  public AllBooksResponse createAllBooksResponse() {
    return new AllBooksResponse();
  }

  /** Create an instance of {@link BooksSearchedListResponse } */
  public BooksSearchedListResponse createBooksSearchedListResponse() {
    return new BooksSearchedListResponse();
  }

  /** Create an instance of {@link ExtendBorrowingResponse } */
  public ExtendBorrowingResponse createExtendBorrowingResponse() {
    return new ExtendBorrowingResponse();
  }

  /** Create an instance of {@link CurrentlyBooksBorrowedListResponse } */
  public CurrentlyBooksBorrowedListResponse createCurrentlyBooksBorrowedListResponse() {
    return new CurrentlyBooksBorrowedListResponse();
  }

  /** Create an instance of {@link CurrentlyBorrowForUserResponse } */
  public CurrentlyBorrowForUserResponse createCurrentlyBorrowForUserResponse() {
    return new CurrentlyBorrowForUserResponse();
  }

  /** Create an instance of {@link SendReminderBeforeExpirationToUsersResponse } */
  public SendReminderBeforeExpirationToUsersResponse
      createSendReminderBeforeExpirationToUsersResponse() {
    return new SendReminderBeforeExpirationToUsersResponse();
  }

  /** Create an instance of {@link BorrowingReturn } */
  public BorrowingReturn createBorrowingReturn() {
    return new BorrowingReturn();
  }

  /** Create an instance of {@link BookDetailsResponse } */
  public BookDetailsResponse createBookDetailsResponse() {
    return new BookDetailsResponse();
  }

  /** Create an instance of {@link BookReservationsResponse } */
  public BookReservationsResponse createBookReservationsResponse() {
    return new BookReservationsResponse();
  }

  /** Create an instance of {@link CurrentlyDeadLineExpiredForUser } */
  public CurrentlyDeadLineExpiredForUser createCurrentlyDeadLineExpiredForUser() {
    return new CurrentlyDeadLineExpiredForUser();
  }

  /** Create an instance of {@link CurrentlyDeadlineExpired } */
  public CurrentlyDeadlineExpired createCurrentlyDeadlineExpired() {
    return new CurrentlyDeadlineExpired();
  }

  /** Create an instance of {@link BorrowingReturnResponse } */
  public BorrowingReturnResponse createBorrowingReturnResponse() {
    return new BorrowingReturnResponse();
  }

  /** Create an instance of {@link AllBooks } */
  public AllBooks createAllBooks() {
    return new AllBooks();
  }

  /** Create an instance of {@link MakeReservationResponse } */
  public MakeReservationResponse createMakeReservationResponse() {
    return new MakeReservationResponse();
  }

  /** Create an instance of {@link BorrowingHistoryListResponse } */
  public BorrowingHistoryListResponse createBorrowingHistoryListResponse() {
    return new BorrowingHistoryListResponse();
  }

  /** Create an instance of {@link CheckReservationNotPickedUp } */
  public CheckReservationNotPickedUp createCheckReservationNotPickedUp() {
    return new CheckReservationNotPickedUp();
  }

  /** Create an instance of {@link UserReservations } */
  public UserReservations createUserReservations() {
    return new UserReservations();
  }

  /** Create an instance of {@link LibraryWsFault } */
  public LibraryWsFault createLibraryWsFault() {
    return new LibraryWsFault();
  }

  /** Create an instance of {@link CurrentlyBooksBorrowedList } */
  public CurrentlyBooksBorrowedList createCurrentlyBooksBorrowedList() {
    return new CurrentlyBooksBorrowedList();
  }

  /** Create an instance of {@link CancelAreservation } */
  public CancelAreservation createCancelAreservation() {
    return new CancelAreservation();
  }

  /** Create an instance of {@link AvailableBooksListResponse } */
  public AvailableBooksListResponse createAvailableBooksListResponse() {
    return new AvailableBooksListResponse();
  }

  /** Create an instance of {@link BookBorrow } */
  public BookBorrow createBookBorrow() {
    return new BookBorrow();
  }

  /** Create an instance of {@link BookDetails } */
  public BookDetails createBookDetails() {
    return new BookDetails();
  }

  /** Create an instance of {@link SendReminderBeforeExpirationToUsers } */
  public SendReminderBeforeExpirationToUsers createSendReminderBeforeExpirationToUsers() {
    return new SendReminderBeforeExpirationToUsers();
  }

  /** Create an instance of {@link CheckReservationNotPickedUpResponse } */
  public CheckReservationNotPickedUpResponse createCheckReservationNotPickedUpResponse() {
    return new CheckReservationNotPickedUpResponse();
  }

  /** Create an instance of {@link CurrentlyDeadLineExpiredForUserResponse } */
  public CurrentlyDeadLineExpiredForUserResponse createCurrentlyDeadLineExpiredForUserResponse() {
    return new CurrentlyDeadLineExpiredForUserResponse();
  }

  /** Create an instance of {@link NbBorrowingByBooks } */
  public NbBorrowingByBooks createNbBorrowingByBooks() {
    return new NbBorrowingByBooks();
  }

  /** Create an instance of {@link ReturnedBorrowsForUserResponse } */
  public ReturnedBorrowsForUserResponse createReturnedBorrowsForUserResponse() {
    return new ReturnedBorrowsForUserResponse();
  }

  /** Create an instance of {@link UserReservationsResponse } */
  public UserReservationsResponse createUserReservationsResponse() {
    return new UserReservationsResponse();
  }

  /** Create an instance of {@link MakeReservation } */
  public MakeReservation createMakeReservation() {
    return new MakeReservation();
  }

  /** Create an instance of {@link AvailableBooksList } */
  public AvailableBooksList createAvailableBooksList() {
    return new AvailableBooksList();
  }

  /** Create an instance of {@link BookStocksListResponse } */
  public BookStocksListResponse createBookStocksListResponse() {
    return new BookStocksListResponse();
  }

  /** Create an instance of {@link BookReservations } */
  public BookReservations createBookReservations() {
    return new BookReservations();
  }

  /** Create an instance of {@link ReturnedBorrowsForUser } */
  public ReturnedBorrowsForUser createReturnedBorrowsForUser() {
    return new ReturnedBorrowsForUser();
  }

  /** Create an instance of {@link SendReminderToUsersResponse } */
  public SendReminderToUsersResponse createSendReminderToUsersResponse() {
    return new SendReminderToUsersResponse();
  }

  /** Create an instance of {@link BooksSearchedList } */
  public BooksSearchedList createBooksSearchedList() {
    return new BooksSearchedList();
  }

  /** Create an instance of {@link CurrentlyDeadlineExpiredUsersResponse } */
  public CurrentlyDeadlineExpiredUsersResponse createCurrentlyDeadlineExpiredUsersResponse() {
    return new CurrentlyDeadlineExpiredUsersResponse();
  }

  /** Create an instance of {@link UserCurrentlyBorrowDto } */
  public UserCurrentlyBorrowDto createUserCurrentlyBorrowDto() {
    return new UserCurrentlyBorrowDto();
  }

  /** Create an instance of {@link CurrentlyBorrowExpiredDto } */
  public CurrentlyBorrowExpiredDto createCurrentlyBorrowExpiredDto() {
    return new CurrentlyBorrowExpiredDto();
  }

  /** Create an instance of {@link Stock } */
  public Stock createStock() {
    return new Stock();
  }

  /** Create an instance of {@link BorrowDto } */
  public BorrowDto createBorrowDto() {
    return new BorrowDto();
  }

  /** Create an instance of {@link ReservationDetailsDto } */
  public ReservationDetailsDto createReservationDetailsDto() {
    return new ReservationDetailsDto();
  }

  /** Create an instance of {@link Author } */
  public Author createAuthor() {
    return new Author();
  }

  /** Create an instance of {@link Book } */
  public Book createBook() {
    return new Book();
  }

  /** Create an instance of {@link BookReservation } */
  public BookReservation createBookReservation() {
    return new BookReservation();
  }

  /** Create an instance of {@link BookBorrowed } */
  public BookBorrowed createBookBorrowed() {
    return new BookBorrowed();
  }

  /** Create an instance of {@link BookBorrowsCountDto } */
  public BookBorrowsCountDto createBookBorrowsCountDto() {
    return new BookBorrowsCountDto();
  }

  /** Create an instance of {@link BookDetailsDto } */
  public BookDetailsDto createBookDetailsDto() {
    return new BookDetailsDto();
  }

  /** Create an instance of {@link BookStockDto } */
  public BookStockDto createBookStockDto() {
    return new BookStockDto();
  }

  /** Create an instance of {@link BooksSearchClientCriteriaDto } */
  public BooksSearchClientCriteriaDto createBooksSearchClientCriteriaDto() {
    return new BooksSearchClientCriteriaDto();
  }

  /** Create an instance of {@link User } */
  public User createUser() {
    return new User();
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link UserReservationsResponse }{@code >}}
   */
  @XmlElementDecl(
      namespace = "http://services.libraryws.projects.brucella.fr/",
      name = "userReservationsResponse")
  public JAXBElement<UserReservationsResponse> createUserReservationsResponse(
      UserReservationsResponse value) {
    return new JAXBElement<UserReservationsResponse>(
        _UserReservationsResponse_QNAME, UserReservationsResponse.class, null, value);
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link CheckReservationNotPickedUpResponse
   * }{@code >}}
   */
  @XmlElementDecl(
      namespace = "http://services.libraryws.projects.brucella.fr/",
      name = "checkReservationNotPickedUpResponse")
  public JAXBElement<CheckReservationNotPickedUpResponse> createCheckReservationNotPickedUpResponse(
      CheckReservationNotPickedUpResponse value) {
    return new JAXBElement<CheckReservationNotPickedUpResponse>(
        _CheckReservationNotPickedUpResponse_QNAME,
        CheckReservationNotPickedUpResponse.class,
        null,
        value);
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link
   * CurrentlyDeadLineExpiredForUserResponse }{@code >}}
   */
  @XmlElementDecl(
      namespace = "http://services.libraryws.projects.brucella.fr/",
      name = "currentlyDeadLineExpiredForUserResponse")
  public JAXBElement<CurrentlyDeadLineExpiredForUserResponse>
      createCurrentlyDeadLineExpiredForUserResponse(CurrentlyDeadLineExpiredForUserResponse value) {
    return new JAXBElement<CurrentlyDeadLineExpiredForUserResponse>(
        _CurrentlyDeadLineExpiredForUserResponse_QNAME,
        CurrentlyDeadLineExpiredForUserResponse.class,
        null,
        value);
  }

  /** Create an instance of {@link JAXBElement }{@code <}{@link NbBorrowingByBooks }{@code >}} */
  @XmlElementDecl(
      namespace = "http://services.libraryws.projects.brucella.fr/",
      name = "nbBorrowingByBooks")
  public JAXBElement<NbBorrowingByBooks> createNbBorrowingByBooks(NbBorrowingByBooks value) {
    return new JAXBElement<NbBorrowingByBooks>(
        _NbBorrowingByBooks_QNAME, NbBorrowingByBooks.class, null, value);
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link ReturnedBorrowsForUserResponse
   * }{@code >}}
   */
  @XmlElementDecl(
      namespace = "http://services.libraryws.projects.brucella.fr/",
      name = "returnedBorrowsForUserResponse")
  public JAXBElement<ReturnedBorrowsForUserResponse> createReturnedBorrowsForUserResponse(
      ReturnedBorrowsForUserResponse value) {
    return new JAXBElement<ReturnedBorrowsForUserResponse>(
        _ReturnedBorrowsForUserResponse_QNAME, ReturnedBorrowsForUserResponse.class, null, value);
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link AvailableBooksListResponse }{@code
   * >}}
   */
  @XmlElementDecl(
      namespace = "http://services.libraryws.projects.brucella.fr/",
      name = "availableBooksListResponse")
  public JAXBElement<AvailableBooksListResponse> createAvailableBooksListResponse(
      AvailableBooksListResponse value) {
    return new JAXBElement<AvailableBooksListResponse>(
        _AvailableBooksListResponse_QNAME, AvailableBooksListResponse.class, null, value);
  }

  /** Create an instance of {@link JAXBElement }{@code <}{@link BookBorrow }{@code >}} */
  @XmlElementDecl(
      namespace = "http://services.libraryws.projects.brucella.fr/",
      name = "bookBorrow")
  public JAXBElement<BookBorrow> createBookBorrow(BookBorrow value) {
    return new JAXBElement<BookBorrow>(_BookBorrow_QNAME, BookBorrow.class, null, value);
  }

  /** Create an instance of {@link JAXBElement }{@code <}{@link BookDetails }{@code >}} */
  @XmlElementDecl(
      namespace = "http://services.libraryws.projects.brucella.fr/",
      name = "bookDetails")
  public JAXBElement<BookDetails> createBookDetails(BookDetails value) {
    return new JAXBElement<BookDetails>(_BookDetails_QNAME, BookDetails.class, null, value);
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SendReminderBeforeExpirationToUsers
   * }{@code >}}
   */
  @XmlElementDecl(
      namespace = "http://services.libraryws.projects.brucella.fr/",
      name = "sendReminderBeforeExpirationToUsers")
  public JAXBElement<SendReminderBeforeExpirationToUsers> createSendReminderBeforeExpirationToUsers(
      SendReminderBeforeExpirationToUsers value) {
    return new JAXBElement<SendReminderBeforeExpirationToUsers>(
        _SendReminderBeforeExpirationToUsers_QNAME,
        SendReminderBeforeExpirationToUsers.class,
        null,
        value);
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link CheckReservationNotPickedUp }{@code
   * >}}
   */
  @XmlElementDecl(
      namespace = "http://services.libraryws.projects.brucella.fr/",
      name = "checkReservationNotPickedUp")
  public JAXBElement<CheckReservationNotPickedUp> createCheckReservationNotPickedUp(
      CheckReservationNotPickedUp value) {
    return new JAXBElement<CheckReservationNotPickedUp>(
        _CheckReservationNotPickedUp_QNAME, CheckReservationNotPickedUp.class, null, value);
  }

  /** Create an instance of {@link JAXBElement }{@code <}{@link UserReservations }{@code >}} */
  @XmlElementDecl(
      namespace = "http://services.libraryws.projects.brucella.fr/",
      name = "userReservations")
  public JAXBElement<UserReservations> createUserReservations(UserReservations value) {
    return new JAXBElement<UserReservations>(
        _UserReservations_QNAME, UserReservations.class, null, value);
  }

  /** Create an instance of {@link JAXBElement }{@code <}{@link LibraryWsFault }{@code >}} */
  @XmlElementDecl(
      namespace = "http://services.libraryws.projects.brucella.fr/",
      name = "LibraryWsException")
  public JAXBElement<LibraryWsFault> createLibraryWsException(LibraryWsFault value) {
    return new JAXBElement<LibraryWsFault>(
        _LibraryWsException_QNAME, LibraryWsFault.class, null, value);
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link CurrentlyBooksBorrowedList }{@code
   * >}}
   */
  @XmlElementDecl(
      namespace = "http://services.libraryws.projects.brucella.fr/",
      name = "currentlyBooksBorrowedList")
  public JAXBElement<CurrentlyBooksBorrowedList> createCurrentlyBooksBorrowedList(
      CurrentlyBooksBorrowedList value) {
    return new JAXBElement<CurrentlyBooksBorrowedList>(
        _CurrentlyBooksBorrowedList_QNAME, CurrentlyBooksBorrowedList.class, null, value);
  }

  /** Create an instance of {@link JAXBElement }{@code <}{@link CancelAreservation }{@code >}} */
  @XmlElementDecl(
      namespace = "http://services.libraryws.projects.brucella.fr/",
      name = "cancelAreservation")
  public JAXBElement<CancelAreservation> createCancelAreservation(CancelAreservation value) {
    return new JAXBElement<CancelAreservation>(
        _CancelAreservation_QNAME, CancelAreservation.class, null, value);
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link CurrentlyDeadlineExpiredUsersResponse
   * }{@code >}}
   */
  @XmlElementDecl(
      namespace = "http://services.libraryws.projects.brucella.fr/",
      name = "currentlyDeadlineExpiredUsersResponse")
  public JAXBElement<CurrentlyDeadlineExpiredUsersResponse>
      createCurrentlyDeadlineExpiredUsersResponse(CurrentlyDeadlineExpiredUsersResponse value) {
    return new JAXBElement<CurrentlyDeadlineExpiredUsersResponse>(
        _CurrentlyDeadlineExpiredUsersResponse_QNAME,
        CurrentlyDeadlineExpiredUsersResponse.class,
        null,
        value);
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link ReturnedBorrowsForUser }{@code >}}
   */
  @XmlElementDecl(
      namespace = "http://services.libraryws.projects.brucella.fr/",
      name = "returnedBorrowsForUser")
  public JAXBElement<ReturnedBorrowsForUser> createReturnedBorrowsForUser(
      ReturnedBorrowsForUser value) {
    return new JAXBElement<ReturnedBorrowsForUser>(
        _ReturnedBorrowsForUser_QNAME, ReturnedBorrowsForUser.class, null, value);
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link SendReminderToUsersResponse }{@code
   * >}}
   */
  @XmlElementDecl(
      namespace = "http://services.libraryws.projects.brucella.fr/",
      name = "sendReminderToUsersResponse")
  public JAXBElement<SendReminderToUsersResponse> createSendReminderToUsersResponse(
      SendReminderToUsersResponse value) {
    return new JAXBElement<SendReminderToUsersResponse>(
        _SendReminderToUsersResponse_QNAME, SendReminderToUsersResponse.class, null, value);
  }

  /** Create an instance of {@link JAXBElement }{@code <}{@link BooksSearchedList }{@code >}} */
  @XmlElementDecl(
      namespace = "http://services.libraryws.projects.brucella.fr/",
      name = "booksSearchedList")
  public JAXBElement<BooksSearchedList> createBooksSearchedList(BooksSearchedList value) {
    return new JAXBElement<BooksSearchedList>(
        _BooksSearchedList_QNAME, BooksSearchedList.class, null, value);
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link BookStocksListResponse }{@code >}}
   */
  @XmlElementDecl(
      namespace = "http://services.libraryws.projects.brucella.fr/",
      name = "bookStocksListResponse")
  public JAXBElement<BookStocksListResponse> createBookStocksListResponse(
      BookStocksListResponse value) {
    return new JAXBElement<BookStocksListResponse>(
        _BookStocksListResponse_QNAME, BookStocksListResponse.class, null, value);
  }

  /** Create an instance of {@link JAXBElement }{@code <}{@link BookReservations }{@code >}} */
  @XmlElementDecl(
      namespace = "http://services.libraryws.projects.brucella.fr/",
      name = "bookReservations")
  public JAXBElement<BookReservations> createBookReservations(BookReservations value) {
    return new JAXBElement<BookReservations>(
        _BookReservations_QNAME, BookReservations.class, null, value);
  }

  /** Create an instance of {@link JAXBElement }{@code <}{@link MakeReservation }{@code >}} */
  @XmlElementDecl(
      namespace = "http://services.libraryws.projects.brucella.fr/",
      name = "makeReservation")
  public JAXBElement<MakeReservation> createMakeReservation(MakeReservation value) {
    return new JAXBElement<MakeReservation>(
        _MakeReservation_QNAME, MakeReservation.class, null, value);
  }

  /** Create an instance of {@link JAXBElement }{@code <}{@link AvailableBooksList }{@code >}} */
  @XmlElementDecl(
      namespace = "http://services.libraryws.projects.brucella.fr/",
      name = "availableBooksList")
  public JAXBElement<AvailableBooksList> createAvailableBooksList(AvailableBooksList value) {
    return new JAXBElement<AvailableBooksList>(
        _AvailableBooksList_QNAME, AvailableBooksList.class, null, value);
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link ExtendBorrowingResponse }{@code >}}
   */
  @XmlElementDecl(
      namespace = "http://services.libraryws.projects.brucella.fr/",
      name = "extendBorrowingResponse")
  public JAXBElement<ExtendBorrowingResponse> createExtendBorrowingResponse(
      ExtendBorrowingResponse value) {
    return new JAXBElement<ExtendBorrowingResponse>(
        _ExtendBorrowingResponse_QNAME, ExtendBorrowingResponse.class, null, value);
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link CurrentlyBooksBorrowedListResponse
   * }{@code >}}
   */
  @XmlElementDecl(
      namespace = "http://services.libraryws.projects.brucella.fr/",
      name = "currentlyBooksBorrowedListResponse")
  public JAXBElement<CurrentlyBooksBorrowedListResponse> createCurrentlyBooksBorrowedListResponse(
      CurrentlyBooksBorrowedListResponse value) {
    return new JAXBElement<CurrentlyBooksBorrowedListResponse>(
        _CurrentlyBooksBorrowedListResponse_QNAME,
        CurrentlyBooksBorrowedListResponse.class,
        null,
        value);
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link CurrentlyBorrowForUserResponse
   * }{@code >}}
   */
  @XmlElementDecl(
      namespace = "http://services.libraryws.projects.brucella.fr/",
      name = "currentlyBorrowForUserResponse")
  public JAXBElement<CurrentlyBorrowForUserResponse> createCurrentlyBorrowForUserResponse(
      CurrentlyBorrowForUserResponse value) {
    return new JAXBElement<CurrentlyBorrowForUserResponse>(
        _CurrentlyBorrowForUserResponse_QNAME, CurrentlyBorrowForUserResponse.class, null, value);
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link
   * SendReminderBeforeExpirationToUsersResponse }{@code >}}
   */
  @XmlElementDecl(
      namespace = "http://services.libraryws.projects.brucella.fr/",
      name = "sendReminderBeforeExpirationToUsersResponse")
  public JAXBElement<SendReminderBeforeExpirationToUsersResponse>
      createSendReminderBeforeExpirationToUsersResponse(
          SendReminderBeforeExpirationToUsersResponse value) {
    return new JAXBElement<SendReminderBeforeExpirationToUsersResponse>(
        _SendReminderBeforeExpirationToUsersResponse_QNAME,
        SendReminderBeforeExpirationToUsersResponse.class,
        null,
        value);
  }

  /** Create an instance of {@link JAXBElement }{@code <}{@link BorrowingReturn }{@code >}} */
  @XmlElementDecl(
      namespace = "http://services.libraryws.projects.brucella.fr/",
      name = "borrowingReturn")
  public JAXBElement<BorrowingReturn> createBorrowingReturn(BorrowingReturn value) {
    return new JAXBElement<BorrowingReturn>(
        _BorrowingReturn_QNAME, BorrowingReturn.class, null, value);
  }

  /** Create an instance of {@link JAXBElement }{@code <}{@link ExtendBorrowing }{@code >}} */
  @XmlElementDecl(
      namespace = "http://services.libraryws.projects.brucella.fr/",
      name = "extendBorrowing")
  public JAXBElement<ExtendBorrowing> createExtendBorrowing(ExtendBorrowing value) {
    return new JAXBElement<ExtendBorrowing>(
        _ExtendBorrowing_QNAME, ExtendBorrowing.class, null, value);
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link NbBorrowingByBooksResponse }{@code
   * >}}
   */
  @XmlElementDecl(
      namespace = "http://services.libraryws.projects.brucella.fr/",
      name = "nbBorrowingByBooksResponse")
  public JAXBElement<NbBorrowingByBooksResponse> createNbBorrowingByBooksResponse(
      NbBorrowingByBooksResponse value) {
    return new JAXBElement<NbBorrowingByBooksResponse>(
        _NbBorrowingByBooksResponse_QNAME, NbBorrowingByBooksResponse.class, null, value);
  }

  /** Create an instance of {@link JAXBElement }{@code <}{@link BorrowingHistoryList }{@code >}} */
  @XmlElementDecl(
      namespace = "http://services.libraryws.projects.brucella.fr/",
      name = "borrowingHistoryList")
  public JAXBElement<BorrowingHistoryList> createBorrowingHistoryList(BorrowingHistoryList value) {
    return new JAXBElement<BorrowingHistoryList>(
        _BorrowingHistoryList_QNAME, BorrowingHistoryList.class, null, value);
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link CancelAreservationResponse }{@code
   * >}}
   */
  @XmlElementDecl(
      namespace = "http://services.libraryws.projects.brucella.fr/",
      name = "cancelAreservationResponse")
  public JAXBElement<CancelAreservationResponse> createCancelAreservationResponse(
      CancelAreservationResponse value) {
    return new JAXBElement<CancelAreservationResponse>(
        _CancelAreservationResponse_QNAME, CancelAreservationResponse.class, null, value);
  }

  /** Create an instance of {@link JAXBElement }{@code <}{@link AllBooksResponse }{@code >}} */
  @XmlElementDecl(
      namespace = "http://services.libraryws.projects.brucella.fr/",
      name = "allBooksResponse")
  public JAXBElement<AllBooksResponse> createAllBooksResponse(AllBooksResponse value) {
    return new JAXBElement<AllBooksResponse>(
        _AllBooksResponse_QNAME, AllBooksResponse.class, null, value);
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link BooksSearchedListResponse }{@code >}}
   */
  @XmlElementDecl(
      namespace = "http://services.libraryws.projects.brucella.fr/",
      name = "booksSearchedListResponse")
  public JAXBElement<BooksSearchedListResponse> createBooksSearchedListResponse(
      BooksSearchedListResponse value) {
    return new JAXBElement<BooksSearchedListResponse>(
        _BooksSearchedListResponse_QNAME, BooksSearchedListResponse.class, null, value);
  }

  /** Create an instance of {@link JAXBElement }{@code <}{@link BookStocksList }{@code >}} */
  @XmlElementDecl(
      namespace = "http://services.libraryws.projects.brucella.fr/",
      name = "bookStocksList")
  public JAXBElement<BookStocksList> createBookStocksList(BookStocksList value) {
    return new JAXBElement<BookStocksList>(
        _BookStocksList_QNAME, BookStocksList.class, null, value);
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link CurrentlyDeadlineExpiredResponse
   * }{@code >}}
   */
  @XmlElementDecl(
      namespace = "http://services.libraryws.projects.brucella.fr/",
      name = "currentlyDeadlineExpiredResponse")
  public JAXBElement<CurrentlyDeadlineExpiredResponse> createCurrentlyDeadlineExpiredResponse(
      CurrentlyDeadlineExpiredResponse value) {
    return new JAXBElement<CurrentlyDeadlineExpiredResponse>(
        _CurrentlyDeadlineExpiredResponse_QNAME,
        CurrentlyDeadlineExpiredResponse.class,
        null,
        value);
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link CurrentlyDeadlineExpiredUsers }{@code
   * >}}
   */
  @XmlElementDecl(
      namespace = "http://services.libraryws.projects.brucella.fr/",
      name = "currentlyDeadlineExpiredUsers")
  public JAXBElement<CurrentlyDeadlineExpiredUsers> createCurrentlyDeadlineExpiredUsers(
      CurrentlyDeadlineExpiredUsers value) {
    return new JAXBElement<CurrentlyDeadlineExpiredUsers>(
        _CurrentlyDeadlineExpiredUsers_QNAME, CurrentlyDeadlineExpiredUsers.class, null, value);
  }

  /** Create an instance of {@link JAXBElement }{@code <}{@link SendReminderToUsers }{@code >}} */
  @XmlElementDecl(
      namespace = "http://services.libraryws.projects.brucella.fr/",
      name = "sendReminderToUsers")
  public JAXBElement<SendReminderToUsers> createSendReminderToUsers(SendReminderToUsers value) {
    return new JAXBElement<SendReminderToUsers>(
        _SendReminderToUsers_QNAME, SendReminderToUsers.class, null, value);
  }

  /** Create an instance of {@link JAXBElement }{@code <}{@link BookBorrowResponse }{@code >}} */
  @XmlElementDecl(
      namespace = "http://services.libraryws.projects.brucella.fr/",
      name = "bookBorrowResponse")
  public JAXBElement<BookBorrowResponse> createBookBorrowResponse(BookBorrowResponse value) {
    return new JAXBElement<BookBorrowResponse>(
        _BookBorrowResponse_QNAME, BookBorrowResponse.class, null, value);
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link CurrentlyBorrowForUser }{@code >}}
   */
  @XmlElementDecl(
      namespace = "http://services.libraryws.projects.brucella.fr/",
      name = "currentlyBorrowForUser")
  public JAXBElement<CurrentlyBorrowForUser> createCurrentlyBorrowForUser(
      CurrentlyBorrowForUser value) {
    return new JAXBElement<CurrentlyBorrowForUser>(
        _CurrentlyBorrowForUser_QNAME, CurrentlyBorrowForUser.class, null, value);
  }

  /** Create an instance of {@link JAXBElement }{@code <}{@link AllBooks }{@code >}} */
  @XmlElementDecl(namespace = "http://services.libraryws.projects.brucella.fr/", name = "allBooks")
  public JAXBElement<AllBooks> createAllBooks(AllBooks value) {
    return new JAXBElement<AllBooks>(_AllBooks_QNAME, AllBooks.class, null, value);
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link MakeReservationResponse }{@code >}}
   */
  @XmlElementDecl(
      namespace = "http://services.libraryws.projects.brucella.fr/",
      name = "makeReservationResponse")
  public JAXBElement<MakeReservationResponse> createMakeReservationResponse(
      MakeReservationResponse value) {
    return new JAXBElement<MakeReservationResponse>(
        _MakeReservationResponse_QNAME, MakeReservationResponse.class, null, value);
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link BorrowingHistoryListResponse }{@code
   * >}}
   */
  @XmlElementDecl(
      namespace = "http://services.libraryws.projects.brucella.fr/",
      name = "borrowingHistoryListResponse")
  public JAXBElement<BorrowingHistoryListResponse> createBorrowingHistoryListResponse(
      BorrowingHistoryListResponse value) {
    return new JAXBElement<BorrowingHistoryListResponse>(
        _BorrowingHistoryListResponse_QNAME, BorrowingHistoryListResponse.class, null, value);
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link BorrowingReturnResponse }{@code >}}
   */
  @XmlElementDecl(
      namespace = "http://services.libraryws.projects.brucella.fr/",
      name = "borrowingReturnResponse")
  public JAXBElement<BorrowingReturnResponse> createBorrowingReturnResponse(
      BorrowingReturnResponse value) {
    return new JAXBElement<BorrowingReturnResponse>(
        _BorrowingReturnResponse_QNAME, BorrowingReturnResponse.class, null, value);
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link BookReservationsResponse }{@code >}}
   */
  @XmlElementDecl(
      namespace = "http://services.libraryws.projects.brucella.fr/",
      name = "bookReservationsResponse")
  public JAXBElement<BookReservationsResponse> createBookReservationsResponse(
      BookReservationsResponse value) {
    return new JAXBElement<BookReservationsResponse>(
        _BookReservationsResponse_QNAME, BookReservationsResponse.class, null, value);
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link CurrentlyDeadLineExpiredForUser
   * }{@code >}}
   */
  @XmlElementDecl(
      namespace = "http://services.libraryws.projects.brucella.fr/",
      name = "currentlyDeadLineExpiredForUser")
  public JAXBElement<CurrentlyDeadLineExpiredForUser> createCurrentlyDeadLineExpiredForUser(
      CurrentlyDeadLineExpiredForUser value) {
    return new JAXBElement<CurrentlyDeadLineExpiredForUser>(
        _CurrentlyDeadLineExpiredForUser_QNAME, CurrentlyDeadLineExpiredForUser.class, null, value);
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link CurrentlyDeadlineExpired }{@code >}}
   */
  @XmlElementDecl(
      namespace = "http://services.libraryws.projects.brucella.fr/",
      name = "currentlyDeadlineExpired")
  public JAXBElement<CurrentlyDeadlineExpired> createCurrentlyDeadlineExpired(
      CurrentlyDeadlineExpired value) {
    return new JAXBElement<CurrentlyDeadlineExpired>(
        _CurrentlyDeadlineExpired_QNAME, CurrentlyDeadlineExpired.class, null, value);
  }

  /** Create an instance of {@link JAXBElement }{@code <}{@link BookDetailsResponse }{@code >}} */
  @XmlElementDecl(
      namespace = "http://services.libraryws.projects.brucella.fr/",
      name = "bookDetailsResponse")
  public JAXBElement<BookDetailsResponse> createBookDetailsResponse(BookDetailsResponse value) {
    return new JAXBElement<BookDetailsResponse>(
        _BookDetailsResponse_QNAME, BookDetailsResponse.class, null, value);
  }
}
