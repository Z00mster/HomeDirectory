package org.simsoft.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.simsoft.security.Principal;
import org.simsoft.validator.RequestValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	private static final Logger LOG = LoggerFactory.getLogger(IndexController.class);

	@Autowired
	private RequestValidator requestValidator;
	
	@RequestMapping(value = "/")
	public String getIndex(HttpServletRequest request, Model model) {
		Principal principal = requestValidator.validateAndReturn(request);
		if (principal == null) {
			LOG.info("Not logged in, redirecting...");
			return "redirect:/login";
		}
		
		File rootDirectory = new File("C:/Users/zoom/.m2");
		List<File> content = Arrays.asList(rootDirectory.listFiles());
		
		List<FileView> fileViews = new ArrayList<>();
		content.forEach(con -> {
			if (con.isDirectory()) {
				fileViews.add(new FileView(con.getName(), "folder.jpg"));
			} else {
				fileViews.add(new FileView(con.getName(), "file.png"));
			}
		});		
		
		model.addAttribute("files", fileViews);
		return "dir-view";
	}
	
	public static class FileView {
		
		private final String name;
		private final String imageSource;
		
		private FileView(String name, String imageSource) {
			this.name = name;
			this.imageSource = imageSource;
		}
		
		public String getName() {
			return name;
		}
		
		public String getImageSource() {
			return imageSource;
		}
		
	}
	
}