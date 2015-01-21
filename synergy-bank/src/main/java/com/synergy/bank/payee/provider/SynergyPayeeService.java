
package com.synergy.bank.payee.provider;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import com.synergy.bank.payee.ObjectFactory;
import com.synergy.bank.payee.PayeeVO;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "SynergyPayeeService", targetNamespace = "http://www.bank.synergy.com/payee/")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface SynergyPayeeService {


    /**
     * 
     * @param payeeInput
     * @return
     *     returns java.lang.String
     */
    @WebMethod(action = "http://www.bank.synergy.com/payee/findPayees")
    @WebResult(name = "payeeResponse", targetNamespace = "http://www.bank.synergy.com/payee/", partName = "payeeResponse")
    @Action(input = "http://www.bank.synergy.com/payee/findPayees", output = "http://www.bank.synergy.com/payee/SynergyPayeeService/findPayeesResponse")
    public String findPayees(
        @WebParam(name = "payeeVOInput", targetNamespace = "http://www.bank.synergy.com/payee/", partName = "payeeInput")
        PayeeVO payeeInput);

}