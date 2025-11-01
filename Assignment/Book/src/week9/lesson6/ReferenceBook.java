package week9.lesson6;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class ReferenceBook extends Book {
	private double tax;

	public ReferenceBook(String code, LocalDate dayImport, double price,
			int quantity, String publisher, double tax) {
		super(code, dayImport, price, quantity, publisher);
		setTax(tax);
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		if (tax < 0) {
			throw new IllegalArgumentException("Tax must be greater than 0");
		}
		this.tax = tax;
	}

	@Override
	public double totalPrice() {
		return price * quantity * tax;
	}
	
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("0.0");
		
		return String.format("%s | %s", 
				super.toString(),
				df.format(tax) + "%"
			);
	}
}
