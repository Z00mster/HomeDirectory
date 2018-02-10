package org.simsoft.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.simsoft.Constants;
import org.simsoft.security.StringUtils;
import org.simsoft.security.exception.RequestException;
import org.simsoft.security.file.Folder;
import org.simsoft.security.file.Navigator;
import org.simsoft.security.request.RequestValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GoToController {

	private static final Logger LOG = LoggerFactory.getLogger(IndexController.class);

	@Autowired
	private RequestValidator requestValidator;
	
	@Autowired
	private Navigator navigator;
	
	@RequestMapping(value = "/goto", method = RequestMethod.GET)
	public String getGoTo(HttpServletRequest request, Model model) {
		return "redirect:/";
	}
	
	@RequestMapping(value = "/goto", method = RequestMethod.POST)
	public String postGoTo(HttpServletRequest request) {		
		String content = request.getParameterMap().entrySet().iterator().next().getValue()[0];
		
		LOG.info("Content: " + content);
		String currentDir = (String) request.getSession().getAttribute(Constants.DIRECTORY_SESSION_ATTRIBUTE);
		String destination = currentDir + content + "/";
		LOG.info("Destination: " + destination);
		
		request.getSession().setAttribute(Constants.DIRECTORY_SESSION_ATTRIBUTE, destination);
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/goback", method = RequestMethod.GET)
	public String getGoBack(HttpServletRequest request) {
		String currentDirectory = (String) request.getSession().getAttribute(Constants.DIRECTORY_SESSION_ATTRIBUTE);
		if (!currentDirectory.equals(Constants.SESSION_ROOT_DIRECTORY)) {
			currentDirectory = currentDirectory.substring(0, currentDirectory.length() - 1);
			int index = currentDirectory.lastIndexOf('/');
			LOG.info("Last index of /: " + index);
			LOG.info("Before transformation: " + currentDirectory);
			currentDirectory = currentDirectory.substring(0, index + 1);
		}
		LOG.info("Going to: " + currentDirectory);
		request.getSession().setAttribute(Constants.DIRECTORY_SESSION_ATTRIBUTE, currentDirectory);
		return "redirect:/";
	}
	
}