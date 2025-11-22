import java.text.DecimalFormat;
import java.time.LocalDate;

public class ReferenceBook extends Library {
    private double tax;

    public ReferenceBook(String code, LocalDate entryDate, double price, int quantity, String publisher, double tax) {
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
        return price * quantity * tax;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");

        return String.format("%s | %s",
            super.toString(),
            df.format(tax) + "%"
        );
    }
    
}
