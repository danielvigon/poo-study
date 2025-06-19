package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Keyboard {

	private static BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

	public static String readStringDataType(String input) {
		try {
			System.out.println(input);
			return keyboard.readLine();
		} catch (IOException e) {
			return null;
		}
	}

	public static int readIntDataType(String input) {
		return Integer.parseInt(readStringDataType(input));
	}

	public static double readDoubleDataType(String input) {
		return Double.parseDouble(readStringDataType(input));
	}

	public static boolean readBooleanDataType(String input) {
		return Boolean.parseBoolean(readStringDataType(input));
	}
}