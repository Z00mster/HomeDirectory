package org.simsoft.security.file;

import java.io.Serializable;
import java.util.List;

public class Folder implements Serializable {

	 private static final long serialVersionUID = 1L;
	
	 private List<Content> content;
	 
	 public Folder(List<Content> content) {
		 this.content = content;
	 }

	public List<Content> getContent() {
		return content;
	}
	
}