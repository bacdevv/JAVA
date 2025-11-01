package example.p01_operations;

public class WrapperClassExample {

	public static void main(String[] args) {
		/* Primitive types */
		byte byteValue = 0; 
		short shortValue = 0;
		int intValue = 0;
		long longValue = 0l;
		float floatValue = 0.0f;
		double doubleValue = 0.0;
		char charValue = '\0';
		boolean boolValue = false;
		
		/* Autoboxing */
		Byte byteObject = byteValue;
		Short shortObject = shortValue;
		Integer intObject = intValue;
		Long longObject = longValue;
		Float floatObject = floatValue;
		Double doubleObject = doubleValue;
		Character charObject = charValue;
		Boolean boolObject = boolValue;
		
		/* Unboxing */
		byteValue = byteObject; 
		shortValue = shortObject;
		intValue = intObject;
		longValue = longObject;
		floatValue = floatObject;
		doubleValue = doubleObject;
		charValue = charObject;
		boolValue = boolObject;
		
		/* More */
		// Integer.parseInt()
		try {
			String s = "123";
			int parsedNumber = Integer.parseInt(s);
			System.out.println("Integer.parseInt() : " + parsedNumber);
		} catch (NumberFormatException e) {
			System.out.println("Integer.parseInt() ~ NumberFormatException");
		}
		
		// Integer.valueOf()
		try {
			String s = "123.456";
			System.out.println("Integer.valueOf() : " + Integer.valueOf(s));
		} catch (NumberFormatException e) {
			System.out.println("Integer.valueOf() ~ NumberFormatException");
		}
		
		// Integer.decode()
		try {
			String dec = "99";
			String hex1 = "0xFF";
			String hex2 = "#FF";
			String oct = "077";
			System.out.printf("Integer.decode(\"%s\") = %d %n", dec, Integer.decode(dec));
			System.out.printf("Integer.decode(\"%s\") = %d %n", hex1, Integer.decode(hex1));
			System.out.printf("Integer.decode(\"%s\") = %d %n", hex2, Integer.decode(hex2));
			System.out.printf("Integer.decode(\"%s\") = %d %n", oct, Integer.decode(oct));
		} catch (NumberFormatException e) {
			System.out.println("Integer.decode() ~ NumberFormatException");
		}
		
		// Integer.compare(): EqualTo =0 GreaterThan >0 LessThan <0
		System.out.println("1 compare 2 = " + Integer.compare(1, 2));
		System.out.println("2 compare 2 = " + Integer.compare(2, 2));
		System.out.println("2 compare 1 = " + Integer.compare(2, 1));
		
		// Methods of Character
		int codePoint = 0x00A4;
		char currencySign = '¤';
		System.out.printf("0x%04X == %c : %b %n", codePoint, currencySign, codePoint == currencySign);
		System.out.println("Unicode name : " + Character.getName(codePoint));
		System.out.println("Type : " + Character.getType(codePoint));
		
		char[] letters = {'A', 'á', 'λ', '天'};
		char[] digits = { '9', '٩'};
		
		for (char c : digits) {
			System.out.printf("%c is a digit : %s %n", c, Character.isDigit(c));
		}
		
		for (char c : letters) {
			System.out.printf("%c is a letter : %s %n", c, Character.isLetter(c));
		}
		
		System.out.printf("%c is a lower letter : %s %n", 'á', Character.isLowerCase('á'));
		
	}

}
