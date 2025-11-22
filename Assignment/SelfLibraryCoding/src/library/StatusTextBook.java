package library;

public enum StatusTextBook {
	NEW("New"),
	OLD("Old");
	
	private String text;
	
	private StatusTextBook(String text) {
		this.text = text;
	}
	
	@Override
	public String toString() {
		return text;
	}
}
