
package com.synergy.bank.registration;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.synergy.bank.registration package. 
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
// tytyt
@XmlRegistry
public class ObjectFactory {

    private final static QName _RegistrationInput_QNAME = new QName("http://www.bank.synergy.com/registration/", "registrationInput");
    private final static QName _Registrationres_QNAME = new QName("http://www.bank.synergy.com/registration/", "registrationres");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.synergy.bank.registration
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RegistrationSenderRESVO }
     * 
     */
    public RegistrationSenderRESVO createRegistrationSenderRESVO() {
        return new RegistrationSenderRESVO();
    }

    /**
     * Create an instance of {@link RegistrationSenderVO }
     * 
     */
    public RegistrationSenderVO createRegistrationSenderVO() {
        return new RegistrationSenderVO();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegistrationSenderVO }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.bank.synergy.com/registration/", name = "registrationInput")
    public JAXBElement<RegistrationSenderVO> createRegistrationInput(RegistrationSenderVO value) {
        return new JAXBElement<RegistrationSenderVO>(_RegistrationInput_QNAME, RegistrationSenderVO.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegistrationSenderRESVO }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.bank.synergy.com/registration/", name = "registrationres")
    public JAXBElement<RegistrationSenderRESVO> createRegistrationres(RegistrationSenderRESVO value) {
        return new JAXBElement<RegistrationSenderRESVO>(_Registrationres_QNAME, RegistrationSenderRESVO.class, null, value);
    }

}
