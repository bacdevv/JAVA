package example.p06_enumeration;

public enum Season {
	SPRING(1, "春"),
	SUMMER(2, "夏"),
	AUTUMN(3, "秋"),
	WINTER(4, "冬");
	
	private String alias;
	private int order;
	
	private Season(int order, String alias) {
		this.order = order;
		this.alias = alias;
	}
	
	public int getOrder() {
		return order;
	}
	
	public String getAlias() {
		return alias;
	}
	
	public static Season of(int order) {
		for (Season season : Season.values()) {
			if (season.getOrder() == order) {
				return season;
			}
		}
		return null;
	}
	
	public static Season of(String alias) {
		for (Season season : Season.values()) {
			if (season.getAlias().equals(alias)) {
				return season;
			}
		}
		return null;
	}
	
	@Override
	public String toString() {
		return String.format("[%s %s]", alias, order);
	}
}
