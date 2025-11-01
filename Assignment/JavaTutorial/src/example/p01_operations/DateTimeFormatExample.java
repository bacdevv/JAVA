package example.p01_operations;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.FormatStyle;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class DateTimeFormatExample {
	
	public static void main(String[] args) {
		/* Initialize */
		// LocalDateTime, LocalDate, LocalTime
		LocalDate date = LocalDate.of(2025, 8, 27);
		LocalTime time = LocalTime.of(17, 15, 30, 512);
		LocalDateTime dateTime = LocalDateTime.of(date, time);
		
		System.out.println("LocalDateTime.of() : " + dateTime);
		System.out.println("LocalDate.of() : " + date);
		System.out.println("LocalTime.of() : " + time);
		System.out.println("LocalDateTime.now() : " + LocalDateTime.now());
		System.out.println("LocalTime.now() : " + LocalDate.now());
		System.out.println("LocalTime.now() : " + LocalTime.now());
		
		System.out.println("--------------------");
		
		/* Extract */
		System.out.println("Get Year : " + dateTime.getYear());
		System.out.println("Get Day of Month : " + dateTime.getDayOfMonth());
		System.out.println("Get Day of Year : " + dateTime.getDayOfYear());
		
		System.out.println("Get Month Value : " + dateTime.getMonthValue());
		System.out.println("Get Month Name : " + dateTime.getMonth());
		System.out.println("Get Month Name by Region : " 
				+ dateTime.getMonth().getDisplayName(TextStyle.FULL, Locale.forLanguageTag("vi-VN")) + " - "
				+ dateTime.getMonth().getDisplayName(TextStyle.FULL, Locale.FRENCH) + " - "
				+ dateTime.getMonth().getDisplayName(TextStyle.FULL, Locale.JAPANESE)
		);
		
		System.out.println("Get Day of Week : " + dateTime.getDayOfWeek());
		System.out.println("Get Value of WeekDay : " + dateTime.getDayOfWeek().getValue()); // MONDAY(1) - SUNDAY(7)
		System.out.println("Get WeekDay by Region : " 
				+ dateTime.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.forLanguageTag("vi-VN")) + " - "
				+ dateTime.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.FRENCH) + " - "
				+ dateTime.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.JAPANESE)
		);
		
		System.out.println("Get Hour : " + dateTime.getHour());
		System.out.println("Get Minute : " + dateTime.getMinute());
		System.out.println("Get Second : " + dateTime.getSecond());
		System.out.println("Get NanoSecond : " + dateTime.getNano());
		
		System.out.println("--------------------");
		
		/* Comparison */
		LocalDate dateA = LocalDate.of(2024, 2, 10);
		LocalDate dateB = LocalDate.of(2023, 3, 15);
		System.out.printf("[%s] is after [%s] : %b %n", dateA, dateB, dateA.isAfter(dateB)); // dateA > dateB
		System.out.printf("[%s] is before [%s] : %b %n", dateA, dateB, dateA.isBefore(dateB)); // dateA < dateB
		System.out.printf("[%s] equals to [%s] : %b %n", dateA, dateB, dateA.equals(dateB)); // dateA == dateB
		System.out.printf("[%s] compareTo [%s] = %s %n", dateA, dateB, dateA.compareTo(dateB));
		
		System.out.println("--------------------");
		
		/* Utility */
		System.out.println("Length of the month : " + dateA.lengthOfMonth()); // 29
		System.out.println("Length of the year : " + dateA.lengthOfYear()); // 366
		System.out.println("CE (Common Era) or BCE (Before Common Era) : " + dateA.getEra()); // CE
		System.out.println("EPOCH of LocalDate : " + LocalDate.EPOCH);
		System.out.println("The minimum supported LocalDate : " + LocalDate.MIN); // -999999999-01-01
		System.out.println("The maximum supported LocalDate : " + LocalDate.MAX); // +999999999-12-31
		System.out.println("Convert the number of seconds into the date : " 
				+ LocalDate.ofEpochDay((long) ((long) System.currentTimeMillis()/(24*3.6e6)))
		);
		int difference = 2;
		System.out.printf("[%s] + %s Week(s) = [%s] %n", dateA, difference, dateA.plusWeeks(difference));
		System.out.printf("[%s] - %s Week(s) = [%s] %n", dateA, difference, dateA.minusWeeks(difference));
		
		System.out.println("Difference by Days : " + ChronoUnit.DAYS.between(dateB, dateA)); // 332
		System.out.println("Difference by Months : " + ChronoUnit.MONTHS.between(dateB, dateA)); // 10
		System.out.println("Difference by Years : " + ChronoUnit.YEARS.between(dateB, dateA)); // 0
		System.out.println("Difference by Weeks : " + ChronoUnit.WEEKS.between(dateB, dateA)); // 47
				
		System.out.println("--------------------");
		
		/* Date and Time Format */
		// M: 1-12, MM: 01-12, MMM:Jan-Dec, MMMM:January-December
		// yyyy: 2025, yy:25
		// d: 1-31, dd: 01-31
		// h, hh: 1-12, 01-12 (12-hour mode) ~ 12:00:00 AM
		// H, HH: 0-23, 00-23 (24-hour mode) ~ 00:00:00
		// m, mm: 0-59, 00-59
		// s, ss: 0-59, 00-59
		// a: AM/PM
		DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("'Short date:' dd/MM/yyyy");
		DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("'Long date:' MMMM d, yyyy");
		DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern("'12-hour mode:' hh:mm:ss");
		DateTimeFormatter dtf4 = DateTimeFormatter.ofPattern("'24-hour mode:' HH:mm:ss a");
		DateTimeFormatter dtf5 = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)
				.localizedBy(Locale.forLanguageTag("vi-VN"));

		System.out.println(dateTime.format(dtf1));
		System.out.println(dateTime.format(dtf2));
		System.out.println(dateTime.format(dtf3));
		System.out.println(dateTime.format(dtf4));
		System.out.println(dateTime.format(dtf5));
		
		/* Parsing date */
		try {
			LocalDate parsedDate = LocalDate.parse("7/12/2024", DateTimeFormatter.ofPattern("d/M/yyyy"));
			System.out.println("Parsed Date : " + parsedDate);
		} catch (DateTimeParseException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
