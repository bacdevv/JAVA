package library;

import java.time.LocalDate;

public class TextBook extends Book{
	private StatusTextBook status;

	public TextBook(String code, LocalDate entryDate, double price,
			int quantity, String publisher, StatusTextBook status) {
		super(code, entryDate, price, quantity, publisher);
		this.status = status;
	}

	public StatusTextBook getStatus() {
		return status;
	}

	public void setStatus(StatusTextBook status) {
		if (status == null)
			throw new IllegalArgumentException("Status must not be empty");
		this.status = status;
	}

	@Override
	public double totalPrice() {
		return status == StatusTextBook.NEW ? price * quantity : price * quantity * 0.5;
	}
	
	@Override
	public String toString() {
		return String.format("%s | %s", super.toString(), status);
	}
}
