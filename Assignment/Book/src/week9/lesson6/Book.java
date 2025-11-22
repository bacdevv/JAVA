package week9.lesson6;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public abstract class Book {
	protected final String code;
	protected LocalDate dayImport;
	protected double price;
	protected int quantity;
	protected String publisher;
	
	public abstract double totalPrice();
	
	public Book(String code, LocalDate dayImport, double price, int quantity,
			String publisher) {
		
		if (code == null || code.trim().isEmpty()) {
			throw new IllegalArgumentException("Code is not be empty");
		}
		
		this.code = code;
		setDayImport(dayImport);
        setPrice(price);
        setQuantity(quantity);
        setPublisher(publisher);
	}

	public LocalDate getDayImport() {
		return dayImport;
	}

	public void setDayImport(LocalDate dayImport) {
		this.dayImport = dayImport;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		if (price < 0) {
			throw new IllegalArgumentException("Price must be greater than 0"); 
		}
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		if (quantity < 0) {
			throw new IllegalArgumentException("Quantity must be greater than 0"); 
		}
		this.quantity = quantity;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		if (publisher == null || publisher.trim().isEmpty()) {
			throw new IllegalArgumentException("Publisher is not be empty");
		}
		this.publisher = publisher;
	}

	public String getCode() {
		return code;
	}
	
	@Override
	public String toString() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("vi-VN"));
		
		return String.format("%s | %-10s | %-10s | %-5s | %-10s", 
					code,
					dtf.format(dayImport),
					nf.format(price),
					quantity,
					publisher
				);
	}

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((code == null) ? 0 : code.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Book other = (Book) obj;
        if (code == null) {
            if (other.code != null)
                return false;
        } else if (!code.equals(other.code))
            return false;
        return true;
    }

    
	
}
