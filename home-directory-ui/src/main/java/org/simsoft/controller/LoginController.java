package org.simsoft.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.simsoft.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLogin(Model model) {
		model.addAttribute("password", "");
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String postLogin(HttpServletRequest request) {
		Object object = request.getParameter("password");
		if (object == null) {
			LOG.error("Object empty");
			return "redirect:/login";	
		}
		if (!(object.getClass().isAssignableFrom(String.class))) {
			LOG.error("Object is not string");
			return "redirect:/login";
		}
		String password = (String) object;
		if (!validatePassword(password)) {
			LOG.error("Incorrect password");
			return "redirect:/login";
		}
		LOG.info("Home dir: [{}]", Constants.SESSION_ROOT_DIRECTORY);
		request.getSession().setAttribute(Constants.AUTHORIZED_SESSION_ATTRIBUTE, true);
		request.getSession().setAttribute(Constants.DIRECTORY_SESSION_ATTRIBUTE, Constants.SESSION_ROOT_DIRECTORY);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String postLogout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	private boolean validatePassword(String password) {
		return password.equals("heslokleslo");
	}
	
}