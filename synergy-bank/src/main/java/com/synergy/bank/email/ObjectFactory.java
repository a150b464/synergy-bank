
package com.synergy.bank.email;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.synergy.bank.email package. 
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

    private final static QName _EMailSenderVOInput_QNAME = new QName("http://www.bank.synergy.com/email/", "eMailSenderVOInput");
    private final static QName _EmailResponse_QNAME = new QName("http://www.bank.synergy.com/email/", "emailResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.synergy.bank.email
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link EMailSenderVO }
     * 
     */
    public EMailSenderVO createEMailSenderVO() {
        return new EMailSenderVO();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EMailSenderVO }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.bank.synergy.com/email/", name = "eMailSenderVOInput")
    public JAXBElement<EMailSenderVO> createEMailSenderVOInput(EMailSenderVO value) {
        return new JAXBElement<EMailSenderVO>(_EMailSenderVOInput_QNAME, EMailSenderVO.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.bank.synergy.com/email/", name = "emailResponse")
    public JAXBElement<String> createEmailResponse(String value) {
        return new JAXBElement<String>(_EmailResponse_QNAME, String.class, null, value);
    }

}
