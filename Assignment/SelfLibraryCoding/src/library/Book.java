package library;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public abstract class Book {
	protected final String code;
	protected LocalDate entryDate;
	protected double price;
	protected int quantity;
	protected String publisher;
	
	public abstract double totalPrice();

	public Book(String code, LocalDate entryDate, double price, int quantity,
			String publisher) {
		
		if (code == null || code.trim().isEmpty())
			throw new IllegalArgumentException("Code must not be empty");
		
		this.code = code;
		setEntryDate(entryDate);
		setPrice(price);
		setQuantity(quantity);
		setPublisher(publisher);
	}

	public LocalDate getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(LocalDate entryDate) {
		if (entryDate == null)
			throw new IllegalArgumentException("Date must not be empty");
		this.entryDate = entryDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		if (price < 0)
			throw new IllegalArgumentException("Price must be greater than or equal to 0");
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		if (quantity < 0)
			throw new IllegalArgumentException("Quantity must be greater than or equal to 0");
		this.quantity = quantity;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		if (publisher == null || publisher.trim().isEmpty())
			throw new IllegalArgumentException("Publisher must not be empty");
		this.publisher = publisher;
	}

	public String getCode() {
		return code;
	}
	
	@Override
	public String toString() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		NumberFormat nb = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("vi-VN"));
		
		return String.format("%s | %-10s | %-10s | %-5s | %-10s | %-15s",
					code,
					dtf.format(entryDate),
					nb.format(price),
					quantity,
					publisher,
					nb.format(totalPrice())
				);
	}
	
}
