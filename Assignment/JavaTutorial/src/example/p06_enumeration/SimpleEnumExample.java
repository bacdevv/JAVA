package example.p06_enumeration;

public class SimpleEnumExample {
	
	public static void main(String[] args) {
		Season season1 = Season.AUTUMN;
		Season season2 = null;
		Season season3 = Season.valueOf("AUTUMN");
		System.out.println("enumConstant.toString() : " + season2);
		System.out.println("enumConstant.toString() : " + season1);
		System.out.println("enumConstant.name() : " + season1.name());
		System.out.println("enumConstant.ordinal() : " + season1.ordinal());
		System.out.println("enumConstant.equals() : " + season1.equals(Season.AUTUMN));
		System.out.println("enumConstant.compareTo() : " + season1.compareTo(Season.SPRING));
		System.out.println("enumConstant.compareTo() : " + season1.compareTo(Season.AUTUMN));
		System.out.println("enumConstant.compareTo() : " + season1.compareTo(Season.WINTER));
		System.out.println("enumConstant.hashCode() : " + season1.hashCode());
		System.out.println("enumConstant.hashCode() : " + Season.AUTUMN.hashCode());
		System.out.println("EnumName.values()");
		
		for (Season enumConstant : Season.values()) {
			System.out.print(enumConstant + "\t");
		}
		
		System.out.println("\nCustom method - EnumName.of() : " + Season.of(3));
		System.out.println("Custom method - EnumName.of() : " + Season.of("秋"));
		
		switch (season3) {
			case SPRING, SUMMER -> {
				System.out.println("Month 1 - 6");
			}
			case AUTUMN, WINTER -> {
				System.out.println("Month 7 - 12");
			}
			default -> {
				System.out.println("Unidentified");
			}
		}
	}
}
