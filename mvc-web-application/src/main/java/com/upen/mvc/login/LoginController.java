package com.upen.mvc.login;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"name"}) 
public class LoginController {

	@Autowired
	LoginService service;

	protected static Logger log = Logger.getLogger(LoginController.class);

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginPage() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String handleLoginRequest(@RequestParam String name, @RequestParam String password, ModelMap model) {

		if (!service.validateUser(name, password)) {

			model.put("errorMessage", "Invalid login credentials ! Try again ... ");
			log.warn("[LOG] Invalid login credenials : " + name + " " + password);
		
			return "login";

		}

		model.put("name", name); // Setting up the Session Attribute
		log.info ("[LOG] Login Success : " + name);
		
		return "welcome";

	}

}
