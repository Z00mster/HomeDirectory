package org.simsoft.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.simsoft.model.LoginModel;
import org.simsoft.security.Principal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLogin(Model model) {
		model.addAttribute("loginModel", new LoginModel());
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String postLogin(@ModelAttribute("loginModel") LoginModel loginModel, HttpServletRequest request) {
		//TODO: Do LDAP
		
		HttpSession session = request.getSession();
		LOG.info("Session: {}", session);
		session.setAttribute("principal", new Principal(true));
		return "redirect:/";
	}
	
}