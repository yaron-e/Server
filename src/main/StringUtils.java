package main;

public class StringUtils {
	
	public static boolean isBlank(String text) {
		return (text == null || text.length() == 0 || text
				.equalsIgnoreCase("null") || "null".equalsIgnoreCase(text));
	}

}
