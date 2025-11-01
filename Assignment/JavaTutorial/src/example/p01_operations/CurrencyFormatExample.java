package example.p01_operations;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyFormatExample {
	
	public static void main(String[] args) {
		// Versions < 19
//		Locale[] regions = {
//			Locale.of("vi", "VN"),
//			Locale.of("th", "TH"),
//			Locale.of("lo", "LA"),
//			Locale.of("km", "KM"),
//			
//			Locale.of("zh", "CN"),
//			Locale.of("zh", "HK"),
//			Locale.of("zh", "TW"),
//			Locale.of("jp", "JP"),
//			Locale.of("kr", "KR"),
//				
//			Locale.of("en", "SG"),
//			Locale.of("en", "GB"),
//			Locale.of("en", "US"),
//			Locale.of("en", "CA"),
//			Locale.of("en", "AU"),
//			Locale.of("fr", "FR"),
//			Locale.of("it", "IT"),
//			Locale.of("ho", "HO"),
//				
//			Locale.CHINA,
//			Locale.TAIWAN,
//			Locale.JAPAN,
//			Locale.UK,
//			Locale.US
//		};
		
		// Versions >= 19
//		Locale[] regions = {
//			Locale.of("vi", "VN"),
//			Locale.of("th", "TH"),
//			Locale.of("lo", "LA"),
//			Locale.of("km", "KM"),
//			
//			Locale.of("zh", "CN"),
//			Locale.of("zh", "HK"),
//			Locale.of("zh", "TW"),
//			Locale.of("jp", "JP"),
//			Locale.of("kr", "KR"),
//				
//			Locale.of("en", "SG"),
//			Locale.of("en", "GB"),
//			Locale.of("en", "US"),
//			Locale.of("en", "CA"),
//			Locale.of("en", "AU"),
//			Locale.of("fr", "FR"),
//			Locale.of("it", "IT"),
//			Locale.of("ho", "HO"),
//				
//			Locale.CHINA,
//			Locale.TAIWAN,
//			Locale.JAPAN,
//			Locale.UK,
//			Locale.US
//		};
		
		//
		Locale[] regions = {
				Locale.forLanguageTag("vi-VN"),
				Locale.forLanguageTag("th-TH"),
				Locale.forLanguageTag("lo-LA"),
				Locale.forLanguageTag("km-KM"),
				
				Locale.forLanguageTag("zh-CN"),
				Locale.forLanguageTag("zh-HK"),
				Locale.forLanguageTag("zh-TW"),
				Locale.forLanguageTag("jp-JP"),
				Locale.forLanguageTag("kr-KR"),
					
				Locale.forLanguageTag("en-SG"),
				Locale.forLanguageTag("en-GB"),
				Locale.forLanguageTag("en-US"),
				Locale.forLanguageTag("en-CA"),
				Locale.forLanguageTag("en-AU"),
				Locale.forLanguageTag("fr-FR"),
				Locale.forLanguageTag("it-IT"),
				Locale.forLanguageTag("ho-HO")
		};
		double value = 12345700.6789;
		
		for (Locale locale : regions) {
			System.out.println(NumberFormat.getCurrencyInstance(locale).format(value));
			System.out.println(DecimalFormat.getCurrencyInstance(locale).format(value));
			System.out.println("---");
		}
	}
}
