
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
@XmlRegistry
public class ObjectFactory {

    private final static QName _RegistrationVOOutput_QNAME = new QName("http://www.bank.synergy.com/registration/", "registrationVOOutput");
    private final static QName _RegistrationVOInput_QNAME = new QName("http://www.bank.synergy.com/registration/", "registrationVOInput");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.synergy.bank.registration
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RegistrationInputVO }
     * 
     */
    public RegistrationInputVO createRegistrationInputVO() {
        return new RegistrationInputVO();
    }

    /**
     * Create an instance of {@link RegistrationOutputVO }
     * 
     */
    public RegistrationOutputVO createRegistrationOutputVO() {
        return new RegistrationOutputVO();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegistrationOutputVO }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.bank.synergy.com/registration/", name = "registrationVOOutput")
    public JAXBElement<RegistrationOutputVO> createRegistrationVOOutput(RegistrationOutputVO value) {
        return new JAXBElement<RegistrationOutputVO>(_RegistrationVOOutput_QNAME, RegistrationOutputVO.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegistrationInputVO }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.bank.synergy.com/registration/", name = "registrationVOInput")
    public JAXBElement<RegistrationInputVO> createRegistrationVOInput(RegistrationInputVO value) {
        return new JAXBElement<RegistrationInputVO>(_RegistrationVOInput_QNAME, RegistrationInputVO.class, null, value);
    }

}
