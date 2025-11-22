import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public abstract class Library {
    protected final String code;
    protected LocalDate entryDate;
    protected double price;
    protected int quantity;
    protected String publisher;

    public abstract double totalPrice();

    public Library(String code, LocalDate entryDate, double price, int quantity, String publisher) {
        if (code == null || code.trim().isEmpty())
            throw new IllegalArgumentException("Code must not be empty");
        this.code = code;
        setEntryDate(entryDate);
        setPrice(price);
        setQuantity(quantity);
        setPublisher(publisher);
    }

    public String getCode() {
        return code;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDate entryDate) {
        if (entryDate == null)
            throw new IllegalArgumentException("Entry date must not be empty");
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

    @Override
    public String toString() {
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("vi-VN"));
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        return String.format("%s | %-10s | %-15s | %-5s | %-10s",
                code,
                dtf.format(entryDate),
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
        Library other = (Library) obj;
        if (code == null) {
            if (other.code != null)
                return false;
        } else if (!code.equals(other.code))
            return false;
        return true;
    }
}
