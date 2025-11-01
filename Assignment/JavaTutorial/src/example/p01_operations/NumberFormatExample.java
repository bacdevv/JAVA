package example.p01_operations;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.NumberFormat.Style;
import java.util.Locale;

public class NumberFormatExample {
	
	public static void main(String[] args) {
		/* Regional Number Format */
		double number = 123456000.789123;
		double negativeNum = -number;
		
		NumberFormat nf1 = NumberFormat.getCompactNumberInstance(Locale.forLanguageTag("vi-VN"), Style.SHORT);
//		NumberFormat nf1a = DecimalFormat.getCompactNumberInstance(Locale.forLanguageTag("vi-VN"), Style.LONG);
		NumberFormat nf2 = NumberFormat.getCompactNumberInstance(Locale.US, Style.LONG);
//		NumberFormat nf2a = DecimalFormat.getCompactNumberInstance(Locale.US, Style.SHORT);
		
		System.out.println("Number Format of Viet Nam: " + nf1.format(number));
		System.out.println("Number Format of the USA: " + nf2.format(number));
		
		/* Custom Number Format */
		// 0 # . , ; '...'
		// E % ‰[\u2030]
		// ¤[\u00A4]  
		DecimalFormat df1 = new DecimalFormat("0000000000");
		DecimalFormat df2 = new DecimalFormat("#,##0 VND");
		DecimalFormat df3 = new DecimalFormat("#,##0.00###");
		DecimalFormat df4 = new DecimalFormat("0\u2030");
		DecimalFormat df5 = new DecimalFormat("0.00E0");
		DecimalFormat df6 = new DecimalFormat("0.00;(0.00)");
		
		System.out.printf("%f%n", number);
		System.out.println(df1.format(number)); // 0123456000
		System.out.println(df2.format(number)); // 123,456,001 VND
		System.out.println(df3.format(number)); // 123,456,000.78912
		System.out.println(df4.format(number)); // 123456000789‰
		System.out.println(df5.format(number)); // 1.23E8
		System.out.println(df6.format(number)); // 123456000.79
		System.out.println(df6.format(negativeNum)); // (123456000.79)
		
	}
}
