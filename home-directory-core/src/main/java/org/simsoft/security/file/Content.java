package org.simsoft.security.file;

import java.io.Serializable;
import java.util.UUID;

public class Content implements Serializable, Comparable<Content> {

	private static final long serialVersionUID = 1L;
	
	private final String fullName;
	private final String name;
	private final Boolean isDirectory;
	
	public Content(String name, boolean isDirectory) {
		if (name.length() > 8) {
			this.name = name.substring(0, 8) + "...";
		} else {
			this.name = name;
		}
		this.isDirectory = isDirectory;
		this.fullName = name;
	}
	
	@Override
	public int compareTo(Content other) {
		if (this.isDirectory && !other.isDirectory) {
			return -1;
		} else if (this.isDirectory && other.isDirectory) {
			return 0;
		} else {
			return 1;
		}
	}

	public String getName() {
		return name;
	}
	
	public String getFullName() {
		return fullName;
	}

	public Boolean getIsDirectory() {
		return isDirectory;
	}
	
}