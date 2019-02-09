package generated.authentificationserviceclient;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by the JAX-WS RI. JAX-WS RI 2.2.9-b130926.1035 Generated source version:
 * 2.2
 */
@WebService(
    name = "AuthentificationService",
    targetNamespace = "http://services.libraryws.projects.brucella.fr/")
@XmlSeeAlso({ObjectFactory.class})
public interface AuthentificationService {

  /**
   * @param arg1
   * @param arg0
   * @return returns generated.authentificationserviceclient.FullUserDto
   * @throws LibraryWsException
   */
  @WebMethod
  @WebResult(targetNamespace = "")
  @RequestWrapper(
      localName = "login",
      targetNamespace = "http://services.libraryws.projects.brucella.fr/",
      className = "generated.authentificationserviceclient.Login")
  @ResponseWrapper(
      localName = "loginResponse",
      targetNamespace = "http://services.libraryws.projects.brucella.fr/",
      className = "generated.authentificationserviceclient.LoginResponse")
  public FullUserDto login(
      @WebParam(name = "arg0", targetNamespace = "") String arg0,
      @WebParam(name = "arg1", targetNamespace = "") String arg1)
      throws LibraryWsException;

  /**
   * @param arg0
   * @return returns java.lang.Integer
   * @throws LibraryWsException
   */
  @WebMethod
  @WebResult(targetNamespace = "")
  @RequestWrapper(
      localName = "addUser",
      targetNamespace = "http://services.libraryws.projects.brucella.fr/",
      className = "generated.authentificationserviceclient.AddUser")
  @ResponseWrapper(
      localName = "addUserResponse",
      targetNamespace = "http://services.libraryws.projects.brucella.fr/",
      className = "generated.authentificationserviceclient.AddUserResponse")
  public Integer addUser(@WebParam(name = "arg0", targetNamespace = "") FullUserDto arg0)
      throws LibraryWsException;

  /**
   * @param arg1
   * @param arg0
   * @return returns java.lang.Boolean
   * @throws LibraryWsException
   */
  @WebMethod
  @WebResult(targetNamespace = "")
  @RequestWrapper(
      localName = "addRoleToUser",
      targetNamespace = "http://services.libraryws.projects.brucella.fr/",
      className = "generated.authentificationserviceclient.AddRoleToUser")
  @ResponseWrapper(
      localName = "addRoleToUserResponse",
      targetNamespace = "http://services.libraryws.projects.brucella.fr/",
      className = "generated.authentificationserviceclient.AddRoleToUserResponse")
  public Boolean addRoleToUser(
      @WebParam(name = "arg0", targetNamespace = "") Integer arg0,
      @WebParam(name = "arg1", targetNamespace = "") Integer arg1)
      throws LibraryWsException;

  /**
   * @param arg0
   * @return returns java.lang.Boolean
   * @throws LibraryWsException
   */
  @WebMethod
  @WebResult(targetNamespace = "")
  @RequestWrapper(
      localName = "modifyUser",
      targetNamespace = "http://services.libraryws.projects.brucella.fr/",
      className = "generated.authentificationserviceclient.ModifyUser")
  @ResponseWrapper(
      localName = "modifyUserResponse",
      targetNamespace = "http://services.libraryws.projects.brucella.fr/",
      className = "generated.authentificationserviceclient.ModifyUserResponse")
  public Boolean modifyUser(@WebParam(name = "arg0", targetNamespace = "") FullUserDto arg0)
      throws LibraryWsException;

  /**
   * @param arg0
   * @return returns java.lang.Boolean
   * @throws LibraryWsException
   */
  @WebMethod
  @WebResult(targetNamespace = "")
  @RequestWrapper(
      localName = "loginAvailable",
      targetNamespace = "http://services.libraryws.projects.brucella.fr/",
      className = "generated.authentificationserviceclient.LoginAvailable")
  @ResponseWrapper(
      localName = "loginAvailableResponse",
      targetNamespace = "http://services.libraryws.projects.brucella.fr/",
      className = "generated.authentificationserviceclient.LoginAvailableResponse")
  public Boolean loginAvailable(@WebParam(name = "arg0", targetNamespace = "") String arg0)
      throws LibraryWsException;
}
