package example.p06_enumeration;

import java.time.LocalDate;

import example.p06_enumeration.zodiac.Zodiac;
import example.p06_enumeration.zodiac.ZodiacInfoType;

public class AdvancedEnumExample {

	public static void main(String[] args) {
		Zodiac zodiac1 = Zodiac.VIRGO;
		System.out.println(zodiac1);
		System.out.println((Object) zodiac1.getValue(ZodiacInfoType.VI_NAME));
		System.out.println((Object) zodiac1.getValue(ZodiacInfoType.STARTDATE));
		Zodiac zodiac2 = Zodiac.of(15, 8);
		Zodiac zodiac3 = Zodiac.of(LocalDate.now());
		System.out.println(zodiac2);
		System.out.println(zodiac3);

	}

}
