package example.p02_proccesing_string;

public class StringExample {
	
	public static void main(String[] args) {
		/* Initialize */
		// Immutable String
		String s1 = "hello world";
		String s2 = "hello world";
		String s3 = new String("hello world");

		/* Operators */
		System.out.printf("\"%s\" == \"%s\" : %b %n", s1, s2, s1 == s2);
		System.out.printf("\"%s\" == \"%s\" : %b %n", s1, s3, s1 == s3);
		System.out.printf("\"%s\" + \"%s\" : %s %n", s1, s3, s1 + s3); // concatenation
		
		/* Escape characters */
		/* \\ \n \r \b \t \f \' \" \uFFFF */
		System.out.println("🐱" == "\uD83D\uDC31");
		
		System.out.println("--------------------");
		
		/* Extract */
		String text = "Hello World";
		// Info methods
		System.out.println("Length : " + text.length());
		System.out.println("Get char by index : " + text.charAt(1));
		System.out.println("Get index by first char : " + text.indexOf("l")); // Not found return -1
		System.out.println("Get index by last char : " + text.lastIndexOf("l")); // Not found return -1
		
		// Checking methods
		System.out.println(text.equals("Hello world"));
		System.out.println(text.equalsIgnoreCase("Hello world"));
		System.out.println(text.compareTo("h")); // Equals =0 GreaterThan >0 LessThan <0
		System.out.println(text.compareToIgnoreCase("h"));
		System.out.println(text.contains("ll" ));
		System.out.println(text.endsWith("ld"));
		System.out.println(text.startsWith("he"));
		System.out.println(text.isEmpty());
		
		System.out.println("--------------------");
		
		// Utilities
		String s = "  he   lo  ";
		System.out.printf("Repeat [%s] : [%s] %n", s, s.repeat(2));
		System.out.printf("Trim [%s] : [%s] %n", s, s.trim());
		System.out.printf("Strip Leading [%s] : [%s] %n", s, s.stripLeading());
		System.out.printf("Strip Trailing [%s] : [%s] %n", s, s.stripTrailing());
		System.out.printf("SubString [%s] by [2:4] : [%s] %n", s, s.substring(2, 4));
		
		String t = "John.Smith96@gmail.com";
		System.out.println("\nOriginal string: " + t);
		
		System.out.print("Split by regex \"[.]\" with limit = 0 (all-default) : ");
		for (String string : t.split("[.]")) {
			System.out.printf("[%s]\t", string);
		}
		
		System.out.print("\nSplit by regex \"[.]\" with limit = 2 (exclusive) : ");
		for (String string : t.split("[.]",2)) {
			System.out.printf("[%s]\t", string);
		}
		
		String regex = "m";
		String newStr = "-";
		System.out.printf("\nReplace all \"%s\" by \"%s\" : [%s]\n", regex, newStr, t.replace(regex, newStr));
		System.out.printf("Replace first \"%s\" by \"%s\" : [%s]\n", regex, newStr, t.replaceFirst(regex, newStr));
		
		// Stream
		// t = "john.smith96@gmail.com"
		t.chars().forEach(i -> System.out.print(Character.valueOf((char) i) + " "));
		char[] chars1 = t.toCharArray();
		char[] chars2 = new char[chars1.length];
		//
		System.out.println();
		t.getChars(0, 10, chars2, 5);
		for (char d : chars2) {
			System.out.print(d + " ");
		}
		System.out.println();
		t.chars()
			.distinct()
			.sorted()
			.forEach(i -> System.out.print(Character.valueOf((char) i) + " "));
		
	}

}
