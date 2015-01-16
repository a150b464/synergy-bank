package com.synergy.bank.admin.rest.provider;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


//This is my rest web service
@Controller
public class RestMessageService {
	@RequestMapping(value="greet",method=RequestMethod.GET)
	public @ResponseBody String greetings() {
		return "I like to take rest."; //view resolver
	}
	
	//Idempotent
	@RequestMapping(value="frog",method=RequestMethod.GET,
			headers = "Accept=application/xml, application/json")
	public @ResponseBody Frog showFrog() {
		Frog frog=new Frog();
		frog.setAge(12);
		frog.setCategory("bad");
		frog.setColor("green");
		frog.setName("rocky");
		return frog;
	}

}
