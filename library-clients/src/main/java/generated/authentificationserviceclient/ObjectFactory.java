
package generated.authentificationserviceclient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the generated.authentificationserviceclient package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AddUserResponse_QNAME = new QName("http://services.libraryws.projects.brucella.fr/", "addUserResponse");
    private final static QName _Login_QNAME = new QName("http://services.libraryws.projects.brucella.fr/", "login");
    private final static QName _AddRoleToUser_QNAME = new QName("http://services.libraryws.projects.brucella.fr/", "addRoleToUser");
    private final static QName _AddUser_QNAME = new QName("http://services.libraryws.projects.brucella.fr/", "addUser");
    private final static QName _AddRoleToUserResponse_QNAME = new QName("http://services.libraryws.projects.brucella.fr/", "addRoleToUserResponse");
    private final static QName _ModifyUserResponse_QNAME = new QName("http://services.libraryws.projects.brucella.fr/", "modifyUserResponse");
    private final static QName _ModifyUser_QNAME = new QName("http://services.libraryws.projects.brucella.fr/", "modifyUser");
    private final static QName _LoginResponse_QNAME = new QName("http://services.libraryws.projects.brucella.fr/", "loginResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: generated.authentificationserviceclient
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ModifyUserResponse }
     * 
     */
    public ModifyUserResponse createModifyUserResponse() {
        return new ModifyUserResponse();
    }

    /**
     * Create an instance of {@link ModifyUser }
     * 
     */
    public ModifyUser createModifyUser() {
        return new ModifyUser();
    }

    /**
     * Create an instance of {@link LoginResponse }
     * 
     */
    public LoginResponse createLoginResponse() {
        return new LoginResponse();
    }

    /**
     * Create an instance of {@link AddUser }
     * 
     */
    public AddUser createAddUser() {
        return new AddUser();
    }

    /**
     * Create an instance of {@link AddRoleToUserResponse }
     * 
     */
    public AddRoleToUserResponse createAddRoleToUserResponse() {
        return new AddRoleToUserResponse();
    }

    /**
     * Create an instance of {@link AddUserResponse }
     * 
     */
    public AddUserResponse createAddUserResponse() {
        return new AddUserResponse();
    }

    /**
     * Create an instance of {@link Login }
     * 
     */
    public Login createLogin() {
        return new Login();
    }

    /**
     * Create an instance of {@link AddRoleToUser }
     * 
     */
    public AddRoleToUser createAddRoleToUser() {
        return new AddRoleToUser();
    }

    /**
     * Create an instance of {@link Role }
     * 
     */
    public Role createRole() {
        return new Role();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.libraryws.projects.brucella.fr/", name = "addUserResponse")
    public JAXBElement<AddUserResponse> createAddUserResponse(AddUserResponse value) {
        return new JAXBElement<AddUserResponse>(_AddUserResponse_QNAME, AddUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Login }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.libraryws.projects.brucella.fr/", name = "login")
    public JAXBElement<Login> createLogin(Login value) {
        return new JAXBElement<Login>(_Login_QNAME, Login.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddRoleToUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.libraryws.projects.brucella.fr/", name = "addRoleToUser")
    public JAXBElement<AddRoleToUser> createAddRoleToUser(AddRoleToUser value) {
        return new JAXBElement<AddRoleToUser>(_AddRoleToUser_QNAME, AddRoleToUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.libraryws.projects.brucella.fr/", name = "addUser")
    public JAXBElement<AddUser> createAddUser(AddUser value) {
        return new JAXBElement<AddUser>(_AddUser_QNAME, AddUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddRoleToUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.libraryws.projects.brucella.fr/", name = "addRoleToUserResponse")
    public JAXBElement<AddRoleToUserResponse> createAddRoleToUserResponse(AddRoleToUserResponse value) {
        return new JAXBElement<AddRoleToUserResponse>(_AddRoleToUserResponse_QNAME, AddRoleToUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModifyUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.libraryws.projects.brucella.fr/", name = "modifyUserResponse")
    public JAXBElement<ModifyUserResponse> createModifyUserResponse(ModifyUserResponse value) {
        return new JAXBElement<ModifyUserResponse>(_ModifyUserResponse_QNAME, ModifyUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModifyUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.libraryws.projects.brucella.fr/", name = "modifyUser")
    public JAXBElement<ModifyUser> createModifyUser(ModifyUser value) {
        return new JAXBElement<ModifyUser>(_ModifyUser_QNAME, ModifyUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.libraryws.projects.brucella.fr/", name = "loginResponse")
    public JAXBElement<LoginResponse> createLoginResponse(LoginResponse value) {
        return new JAXBElement<LoginResponse>(_LoginResponse_QNAME, LoginResponse.class, null, value);
    }

}
