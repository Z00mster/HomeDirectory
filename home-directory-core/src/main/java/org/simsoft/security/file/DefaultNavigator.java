package org.simsoft.security.file;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DefaultNavigator implements Navigator {

	@Override
	public Folder goTo(String path) {
		File file = new File(path);
		if (!file.exists()) {
			//TODO: Change exception
			throw new UnsupportedOperationException();
		}
		if (file.isDirectory()) {
			List<Content> content = new ArrayList<>();
			List<File> files = Arrays.asList(file.listFiles());
			for (File stepFile : files) {
				content.add(new Content(stepFile.getName(), stepFile.isDirectory()));
			}
			Collections.sort(content);
			return new Folder(content);
		} else {
			//TODO: Change exception
			throw new UnsupportedOperationException();
		}
	}	
	
}