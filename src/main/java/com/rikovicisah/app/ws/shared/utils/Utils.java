package com.rikovicisah.app.ws.shared.utils;

import java.security.SecureRandom;
import org.springframework.stereotype.Component;

/**
 * @author Faik
 * Generate the characters of defined length
 * @param length of the string, min and max value of charachters
 * @version v.1.0.0.
 */

@Component
public class Utils {
	
	private final String USED_CHARS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPKRSTUVWXYZ";

	/**
	 * <p>Generate the characters of specified length, min and max value of characters
	 * @param length of the string, min and max value of charachters
	 * @return the random generated string of size specified by length value
	 */
	public String generateUserId(int length) {
		return generateRandomString(length);
	}
	public String generateAddressId(int length) {
		return generateRandomString(length);
	}
	private String generateRandomString(int length) {
		StringBuilder returnValue = new StringBuilder(length);
		
		for (int i = 0; i < length; i++) {
			returnValue.append(USED_CHARS.charAt(new SecureRandom().nextInt(USED_CHARS.length())));
		}
		return returnValue.toString();
	}
}
