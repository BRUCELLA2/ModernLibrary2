
package generated.authentificationserviceclient;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "LibraryWsException", targetNamespace = "http://services.libraryws.projects.brucella.fr/")
public class LibraryWsException
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private LibraryWsFault faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public LibraryWsException(String message, LibraryWsFault faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public LibraryWsException(String message, LibraryWsFault faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: generated.authentificationserviceclient.LibraryWsFault
     */
    public LibraryWsFault getFaultInfo() {
        return faultInfo;
    }

}
