package org.simsoft.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.simsoft.Constants;
import org.simsoft.security.exception.RequestException;
import org.simsoft.security.file.Content;
import org.simsoft.security.file.Folder;
import org.simsoft.security.file.Navigator;
import org.simsoft.security.request.RequestValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController extends AbstractController {

	private static final Logger LOG = LoggerFactory.getLogger(IndexController.class);

	@Autowired
	private RequestValidator requestValidator;
	
	@Autowired
	private Navigator navigator;
		
	@RequestMapping(value = "/")
	public String getIndex(HttpServletRequest request, Model model) {
		try {
			requestValidator.validate(request);
		} catch (RequestException ex) { 
			LOG.info(ex.getMessage());
			return "redirect:/login";
		}
	
		Folder folder = navigator.goTo((String) request.getSession().getAttribute(Constants.DIRECTORY_SESSION_ATTRIBUTE));
		model.addAttribute("folder", folder);
		
		return "dir-view";
	}
	
}