package org.simsoft.security;

import java.util.Arrays;
import java.util.List;

public class StringUtils {

	public static String goUpOneDirectory(String currentDirectory) {
		String[] split = currentDirectory.split("/");
		String[] newSplit = new String[split.length - 1];
		for (int i = 0; i < split.length - 1; i++) {
			newSplit[i] = split[i];
		}
		return concatenate(newSplit);
	}
	
	public static String concatenate(String[] string) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < string.length; i++) {
			builder.append(string[i]);
		}
		return builder.toString();
	}
	
}