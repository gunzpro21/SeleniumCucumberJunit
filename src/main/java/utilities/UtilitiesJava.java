package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;

public class UtilitiesJava {
	public static String getDate() {
		Date date = new Date();
		SimpleDateFormat DateFor = new SimpleDateFormat("yyyyMMdd");
		String stringDate = DateFor.format(date);
		return stringDate;
	}
	
	public static String generatingRandomAlphanumeric(int length) {
	    String generatedString = RandomStringUtils.randomAlphanumeric(length);
	    return generatedString;
	}

}
