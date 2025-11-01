package example.p06_enumeration.zodiac;

import java.time.LocalDate;

public class DayMonth {
	
	private int month;
	private int day;
	
	private DayMonth(LocalDate date) {
		this.day = date.getDayOfMonth();
		this.month = date.getMonthValue();
	}
	
	private DayMonth(int day, int month, int year) {
		this(LocalDate.of(year, month, day));
	}
	
	private DayMonth(int day, int month) {
		this(LocalDate.of(1, month, day));
	}
	
	public static DayMonth of(LocalDate date) {
		return new DayMonth(date);
	}
	
	public static DayMonth of(int day, int month, int year) {
		return new DayMonth(day, month, year);
	}
	
	public static DayMonth of(int day, int month) {
		return new DayMonth(day, month);
	}

	public int getMonthValue() {
		return month;
	}

	public int getDayOfMonth() {
		return day;
	}
	
	/**
	 * @param one
	 * @param other
	 * @return =0 equal, <0 one before other, >0 one after other
	 */
	public static int compare(DayMonth one, DayMonth other) {
		if (one.month != other.month) {
            return one.month - other.month;
        }
        return one.day - other.day;
	}
	
	public static boolean isBetween(DayMonth date, DayMonth startDate, DayMonth endDate) {
		if (DayMonth.compare(startDate, endDate) == 0 
				&& DayMonth.compare(date, startDate) == 0) {
			return true;
		} else {
			if (DayMonth.compare(date, startDate) >= 0 
					&& DayMonth.compare(date, endDate) <= 0) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		return String.format("[Day = %d; Month = %d]", day, month);
	}

}
