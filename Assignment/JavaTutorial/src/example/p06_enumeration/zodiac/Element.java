package example.p06_enumeration.zodiac;

public enum Element {
	FIRE("Fire"),
	EARTH("Earth"),
	AIR("Air"),
	WATER("Water");
	
	private String element;
	
	private Element(String element) {
		this.element = element;
	}
	
	@Override
	public String toString() {
		return element;
	}
}
