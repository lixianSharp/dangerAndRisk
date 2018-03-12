package danger.utils;


import java.io.File;

public class ValidateCheck {

	public static void checkFile(String filePath) {
		File target = new File(filePath);
		if (target.exists()) {
			target.delete();
		}
	}
	
	public static boolean isNotNull(String string) {
		return  string!=null && !("").equals(string.trim()) && !("null").equals(string);
	}
	
	public static boolean NotNvl(String str) {
		return (str != null) && (!("").equals(str.trim()));
	}
	
	public static boolean isNull(String string) {
		
		return  string==null || ("").equals(string.trim()) || ("null").equals(string);
	 
	}
}
