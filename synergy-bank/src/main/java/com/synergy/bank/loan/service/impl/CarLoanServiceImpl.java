package com.synergy.bank.loan.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.synergy.bank.loan.mdb.dto.CarVO;
import com.synergy.bank.loan.service.CarLoanService;
import com.synergy.bank.loan.web.action.form.CarForm;

@Service("CarLoanServiceImpl")
@Scope("singleton")
public class CarLoanServiceImpl implements CarLoanService {
	
	/*@Autowired
	@Qualifier("jmsTemplate")
	private JmsTemplate jmsTemplate;*/

	@Override
	public String applyforCarLoan(CarForm carForm) {	
		//He we have to send message to whom??? mom
		final CarVO carVO=new CarVO();
		BeanUtils.copyProperties(carForm, carVO);
		System.out.println(carVO);
		
		/*jmsTemplate.send(new MessageCreator(){
			public Message createMessage(Session session) throws JMSException	{
					ObjectMessage message = session.createObjectMessage();
					message.setObject(carVO);
					return message;
			}
		});*/
		return "done";
	}
	
}
