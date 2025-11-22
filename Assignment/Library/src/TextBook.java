import java.time.LocalDate;

public class TextBook extends Library {
    private Status status;

    public TextBook(String code, LocalDate entryDate, double price, int quantity, String publisher, Status status) {
        super(code, entryDate, price, quantity, publisher);
        setStatus(status);
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        if (status == null)
            throw new IllegalArgumentException("Status must not be empty");
        this.status = status;
    }
    
    @Override
    public double totalPrice() {
        return status == Status.OLD ?  price * quantity * 0.5 : price * quantity ;
    }   

    @Override
    public String toString() {
        return String.format("%s | %s",
            super.toString(),
            status
        );
    }

}
