
package com.synergy.bank.registration;

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
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "SynergyRegistrationServiceProvider", targetNamespace = "http://www.bank.synergy.com/registration/", wsdlLocation = "file:/C:/Users/Nani/workspace/synergy-bank/src/main/webapp/xsd/synergy-registration.wsdl")
public class SynergyRegistrationServiceProvider
    extends Service
{

    private final static URL SYNERGYREGISTRATIONSERVICEPROVIDER_WSDL_LOCATION;
    private final static WebServiceException SYNERGYREGISTRATIONSERVICEPROVIDER_EXCEPTION;
    private final static QName SYNERGYREGISTRATIONSERVICEPROVIDER_QNAME = new QName("http://www.bank.synergy.com/registration/", "SynergyRegistrationServiceProvider");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/C:/Users/Nani/workspace/synergy-bank/src/main/webapp/xsd/synergy-registration.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        SYNERGYREGISTRATIONSERVICEPROVIDER_WSDL_LOCATION = url;
        SYNERGYREGISTRATIONSERVICEPROVIDER_EXCEPTION = e;
    }

    public SynergyRegistrationServiceProvider() {
        super(__getWsdlLocation(), SYNERGYREGISTRATIONSERVICEPROVIDER_QNAME);
    }

    public SynergyRegistrationServiceProvider(WebServiceFeature... features) {
        super(__getWsdlLocation(), SYNERGYREGISTRATIONSERVICEPROVIDER_QNAME, features);
    }

    public SynergyRegistrationServiceProvider(URL wsdlLocation) {
        super(wsdlLocation, SYNERGYREGISTRATIONSERVICEPROVIDER_QNAME);
    }

    public SynergyRegistrationServiceProvider(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SYNERGYREGISTRATIONSERVICEPROVIDER_QNAME, features);
    }

    public SynergyRegistrationServiceProvider(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public SynergyRegistrationServiceProvider(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns SynergyRegistrationService
     */
    @WebEndpoint(name = "SynergyRegistrationServicePort")
    public SynergyRegistrationService getSynergyRegistrationServicePort() {
        return super.getPort(new QName("http://www.bank.synergy.com/registration/", "SynergyRegistrationServicePort"), SynergyRegistrationService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns SynergyRegistrationService
     */
    @WebEndpoint(name = "SynergyRegistrationServicePort")
    public SynergyRegistrationService getSynergyRegistrationServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.bank.synergy.com/registration/", "SynergyRegistrationServicePort"), SynergyRegistrationService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (SYNERGYREGISTRATIONSERVICEPROVIDER_EXCEPTION!= null) {
            throw SYNERGYREGISTRATIONSERVICEPROVIDER_EXCEPTION;
        }
        return SYNERGYREGISTRATIONSERVICEPROVIDER_WSDL_LOCATION;
    }

}