package example.p06_enumeration.zodiac;

import java.time.LocalDate;

public enum Zodiac {
	ARIES("Aries", "Bạch Dương", "♈", Element.FIRE, DayMonth.of(21, 3), DayMonth.of(20, 4)),
	TAURUS("Taurus", "Kim Ngưu", "♉", Element.EARTH, DayMonth.of(21, 4), DayMonth.of(21, 5)),
	GEMINI("Gemini", "Song Tử", "♊", Element.AIR, DayMonth.of(22, 5), DayMonth.of(21, 6)),
	CANCER("Cancer", "Cự Giải", "♋", Element.WATER, DayMonth.of(22, 6), DayMonth.of(23, 7)),
	LEO("Leo", "Sư Tử", "♌", Element.FIRE, DayMonth.of(24, 7), DayMonth.of(23, 8)),
	VIRGO("Virgo", "Xử Nữ", "♍", Element.EARTH, DayMonth.of(24, 8), DayMonth.of(23, 9)),
	LIBRA("Libra", "Thiên Bình", "♎", Element.AIR, DayMonth.of(24, 9), DayMonth.of(23, 10)),
	SCORPIO("Scorpio", "Thiên Yết", "♏", Element.WATER, DayMonth.of(24, 10), DayMonth.of(22, 11)),
	SAGITTARIUS("Sagittarius", "Nhân Mã", "♐", Element.FIRE, DayMonth.of(23, 11), DayMonth.of(21, 12)),
	CAPRICORN("Capricorn", "Ma Kết", "♑", Element.EARTH, DayMonth.of(22, 12), DayMonth.of(20, 1)),
	AQUARIUS("Aquarius", "Bảo Bình", "♒", Element.AIR, DayMonth.of(21, 1), DayMonth.of(19, 2)),
	PISCES("Pisces", "Song Ngư", "♓", Element.WATER, DayMonth.of(20, 2), DayMonth.of(20, 3));
	
	private String enName;
	private String viName;
	private String symbol;
	private Element elementalTriplicity;
	private DayMonth startDate;
	private DayMonth endDate;

	private Zodiac(String enName, String viName, String symbol, Element elementalTriplicity, DayMonth startDate,
			DayMonth endDate) {
		this.enName = enName;
		this.viName = viName;
		this.symbol = symbol;
		this.elementalTriplicity = elementalTriplicity;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public static Zodiac of(LocalDate date) {
		for (Zodiac zodiac : Zodiac.values()) {
			if (DayMonth.isBetween(DayMonth.of(date), zodiac.getStartDate(), zodiac.getEndDate())) {
				return zodiac;
			}
		}
		return null;
	}
	
	public static Zodiac of(int day, int month) {
		LocalDate date = LocalDate.of(1, month, day);
		for (Zodiac zodiac : Zodiac.values()) {
			if (DayMonth.isBetween(DayMonth.of(date), zodiac.getStartDate(), zodiac.getEndDate())) {
				return zodiac;
			}
		}
		return null;
	}
	
	@Override
	public String toString() {
		String period = String.format("%02d/%02d - %02d/%02d", 
				startDate.getDayOfMonth(),
				startDate.getMonthValue(),
				endDate.getDayOfMonth(),
				endDate.getMonthValue()
		);
		return String.format("[ %s | %s | %s | %s | %s ]",
				enName,
				viName,
				symbol,
				elementalTriplicity,
				period
		);
	}

	private String getEnName() {
		return enName;
	}

	private String getViName() {
		return viName;
	}

	private String getSymbol() {
		return symbol;
	}

	private Element getElementalTriplicity() {
		return elementalTriplicity;
	}

	private DayMonth getStartDate() {
		return startDate;
	}

	private DayMonth getEndDate() {
		return endDate;
	}
	
	@SuppressWarnings({ "unchecked" })
	public <T> T getValue(ZodiacInfoType infoType) {
		return switch (infoType) {
			case EN_NAME -> (T) getEnName();
			case VI_NAME -> (T) getViName();
			case SYMBOL -> (T) getSymbol();
			case ELEMENT -> (T) getElementalTriplicity();
			case STARTDATE -> (T) getStartDate();
			case ENDDATE -> (T) getEndDate();		
			default -> null;
		};
	}
	
	
}
