
package generated.administrationserviceclient;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "AdministrationService", targetNamespace = "http://services.libraryws.projects.brucella.fr/", wsdlLocation = "http://0.0.0.0:8080/library-ws-services/services/administrationService?wsdl")
public class AdministrationService_Service
    extends Service
{

    private final static URL ADMINISTRATIONSERVICE_WSDL_LOCATION;
    private final static WebServiceException ADMINISTRATIONSERVICE_EXCEPTION;
    private final static QName ADMINISTRATIONSERVICE_QNAME = new QName("http://services.libraryws.projects.brucella.fr/", "AdministrationService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://0.0.0.0:8080/library-ws-services/services/administrationService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        ADMINISTRATIONSERVICE_WSDL_LOCATION = url;
        ADMINISTRATIONSERVICE_EXCEPTION = e;
    }

    public AdministrationService_Service() {
        super(__getWsdlLocation(), ADMINISTRATIONSERVICE_QNAME);
    }

    public AdministrationService_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), ADMINISTRATIONSERVICE_QNAME, features);
    }

    public AdministrationService_Service(URL wsdlLocation) {
        super(wsdlLocation, ADMINISTRATIONSERVICE_QNAME);
    }

    public AdministrationService_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, ADMINISTRATIONSERVICE_QNAME, features);
    }

    public AdministrationService_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public AdministrationService_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns AdministrationService
     */
    @WebEndpoint(name = "AdministrationServicePort")
    public AdministrationService getAdministrationServicePort() {
        return super.getPort(new QName("http://services.libraryws.projects.brucella.fr/", "AdministrationServicePort"), AdministrationService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns AdministrationService
     */
    @WebEndpoint(name = "AdministrationServicePort")
    public AdministrationService getAdministrationServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://services.libraryws.projects.brucella.fr/", "AdministrationServicePort"), AdministrationService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (ADMINISTRATIONSERVICE_EXCEPTION!= null) {
            throw ADMINISTRATIONSERVICE_EXCEPTION;
        }
        return ADMINISTRATIONSERVICE_WSDL_LOCATION;
    }

}
