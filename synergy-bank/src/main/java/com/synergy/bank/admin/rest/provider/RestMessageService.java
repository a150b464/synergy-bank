package com.synergy.bank.admin.rest.provider;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

//This is my rest web service
@Controller
public class RestMessageService {
	@RequestMapping(value = "greet", method = RequestMethod.GET)
	public @ResponseBody
	String greetings() {
		return "I like to take rest."; // view resolver
	}

	// Idempotent
	@RequestMapping(value = "frog", method = RequestMethod.GET, headers = "Accept=application/xml")
	public @ResponseBody
	Frog showFrogXML() {
		Frog frog = new Frog();
		frog.setAge(12);
		frog.setCategory("bad");
		frog.setColor("green");
		frog.setName("XML");
		return frog;
	}

	// Idempotent
	@RequestMapping(value = "frog", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody
	Frog showFrogJSON() {
		Frog frog = new Frog();
		frog.setAge(123);
		frog.setCategory("good");
		frog.setColor("yellow");
		frog.setName("JSON");
		return frog;
	}

	// Idempotent
	@RequestMapping(value = "frog", method = RequestMethod.GET, 
			headers = "Accept=text/html", consumes = "application/xml")
	public @ResponseBody
	String showFrogJSON(@RequestBody Frog frog) {
		System.out.println(" frog= " + frog);
		return "Added into db";
	}

}
