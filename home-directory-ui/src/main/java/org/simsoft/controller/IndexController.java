package org.simsoft.controller;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.simsoft.security.Principal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	private static final Logger LOG = LoggerFactory.getLogger(IndexController.class);
	
	@RequestMapping(value = "/")
	public String getIndex(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Object principalObj = session.getAttribute("principal");
		
		if (principalObj == null) {
			LOG.info("Not logged in [principal null] - redirecting...");
			return "redirect:/login";
		}
		
		Principal principal = (Principal) principalObj;
		if (!principal.isAuthenticated()) {
			LOG.info("Not logged in [not authenticated] - redirecting...");
			return "redirect:/login";
		}
		
		LOG.info("Authenticated - ready to go");
		File rootDirectory = new File("C:/Users/zoom/.m2");
		List<String> content = Arrays.asList(rootDirectory.list());
		content.forEach(con -> LOG.info("File with path [{}]", con));
		return "index";
	}
	
}