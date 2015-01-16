
package com.synergy.bank.payee;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.synergy.bank.payee package. 
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

    private final static QName _PayeeResponse_QNAME = new QName("http://www.bank.synergy.com/payee/", "payeeResponse");
    private final static QName _PayeeVOInput_QNAME = new QName("http://www.bank.synergy.com/payee/", "payeeVOInput");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.synergy.bank.payee
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PayeeVO }
     * 
     */
    public PayeeVO createPayeeVO() {
        return new PayeeVO();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.bank.synergy.com/payee/", name = "payeeResponse")
    public JAXBElement<String> createPayeeResponse(String value) {
        return new JAXBElement<String>(_PayeeResponse_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PayeeVO }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.bank.synergy.com/payee/", name = "payeeVOInput")
    public JAXBElement<PayeeVO> createPayeeVOInput(PayeeVO value) {
        return new JAXBElement<PayeeVO>(_PayeeVOInput_QNAME, PayeeVO.class, null, value);
    }

}
