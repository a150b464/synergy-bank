
package com.synergy.bank.email;

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
@WebServiceClient(name = "SynergyEMailServiceProvider", targetNamespace = "http://www.bank.synergy.com/email/", wsdlLocation = "file:/C:/Users/Nani/workspace/synergy-bank/src/main/webapp/xsd/synergy-email.wsdl")
public class SynergyEMailServiceProvider
    extends Service
{

    private final static URL SYNERGYEMAILSERVICEPROVIDER_WSDL_LOCATION;
    private final static WebServiceException SYNERGYEMAILSERVICEPROVIDER_EXCEPTION;
    private final static QName SYNERGYEMAILSERVICEPROVIDER_QNAME = new QName("http://www.bank.synergy.com/email/", "SynergyEMailServiceProvider");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/C:/Users/Nani/workspace/synergy-bank/src/main/webapp/xsd/synergy-email.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        SYNERGYEMAILSERVICEPROVIDER_WSDL_LOCATION = url;
        SYNERGYEMAILSERVICEPROVIDER_EXCEPTION = e;
    }

    public SynergyEMailServiceProvider() {
        super(__getWsdlLocation(), SYNERGYEMAILSERVICEPROVIDER_QNAME);
    }

    public SynergyEMailServiceProvider(WebServiceFeature... features) {
        super(__getWsdlLocation(), SYNERGYEMAILSERVICEPROVIDER_QNAME, features);
    }

    public SynergyEMailServiceProvider(URL wsdlLocation) {
        super(wsdlLocation, SYNERGYEMAILSERVICEPROVIDER_QNAME);
    }

    public SynergyEMailServiceProvider(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, SYNERGYEMAILSERVICEPROVIDER_QNAME, features);
    }

    public SynergyEMailServiceProvider(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public SynergyEMailServiceProvider(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns SynergyEMailService
     */
    @WebEndpoint(name = "SynergyEMailServicePort")
    public SynergyEMailService getSynergyEMailServicePort() {
        return super.getPort(new QName("http://www.bank.synergy.com/email/", "SynergyEMailServicePort"), SynergyEMailService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns SynergyEMailService
     */
    @WebEndpoint(name = "SynergyEMailServicePort")
    public SynergyEMailService getSynergyEMailServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.bank.synergy.com/email/", "SynergyEMailServicePort"), SynergyEMailService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (SYNERGYEMAILSERVICEPROVIDER_EXCEPTION!= null) {
            throw SYNERGYEMAILSERVICEPROVIDER_EXCEPTION;
        }
        return SYNERGYEMAILSERVICEPROVIDER_WSDL_LOCATION;
    }

}
