package library;

import java.time.LocalDate;

public class ReferenceBook extends Book{
	private double tax;

	public ReferenceBook(String code, LocalDate entryDate, double price,
			int quantity, String publisher, double tax) {
		super(code, entryDate, price, quantity, publisher);
		setTax(tax);
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		if (tax < 0)
			throw new IllegalArgumentException("Tax must be greater than or equal to 0");
		this.tax = tax;
	}

	@Override
	public double totalPrice() {
		double amountTax = tax * price;
		return quantity * price + amountTax;
	}
	
	@Override
	public String toString() {
		return String.format("%s | %s", super.toString(), tax);
	}
}
