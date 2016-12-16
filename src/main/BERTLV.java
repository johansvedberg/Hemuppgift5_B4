package main;

import java.math.BigInteger;
import java.util.Arrays;

import javax.xml.bind.DatatypeConverter;

public class BERTLV {

	public BERTLV() {

	}

	public String encode(String Integer) {

		String input = new BigInteger(Integer).toString(16);

		if (input.length() % 2 == 1) {
			input = "0" + input;
		}

		byte[] integerArray = toByteArray(input);
		String first = toHex(integerArray).substring(0, 1);

		String[] a = { "8", "9", "A", "B", "C", "D", "E", "F" };

		boolean padding = false;

		if (Arrays.asList(a).contains(first)) {
			padding = true;

		}

		if (integerArray.length < 127) {

			if (padding) {
				return ("02" + String.format("%02X", integerArray.length + 1) + "00" + toHex(integerArray));

			} else {
				return ("02" + String.format("%02X", integerArray.length) + toHex(integerArray));

			}

		} else if (integerArray.length < 255) {

			if (padding) {
				return ("02" + "81" + String.format("%02X", integerArray.length + 1) + "00" + toHex(integerArray));

			} else {
				return ("02" + "81" + String.format("%02X", integerArray.length) + toHex(integerArray));

			}

		} else if (integerArray.length < 65535) {
			if (padding) {
				return ("02" + "82" + String.format("%04X", integerArray.length + 1) + "00" + toHex(integerArray));

			} else {
				return ("02" + "82" + String.format("%04X", integerArray.length) + toHex(integerArray));

			}

		} else {
			return ("Number not supported");
		}

	}

	private String toHex(byte[] array) {
		return DatatypeConverter.printHexBinary(array);
	}

	private byte[] toByteArray(String s) {
		return DatatypeConverter.parseHexBinary(s);
	}

}
