package week9.lesson6;

public enum Status {
	OLD("Old"),
	NEW("New");
	
	private String text;

	private Status(String text) {
		this.text = text;
	}
	
	@Override
	public String toString() {
		return text;
	}
}
