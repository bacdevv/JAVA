package tuan4;

public class BankAccount {
    private String accountNumber;
    private String ownerName;
    private double balance;


    public BankAccount() {
        this("0000-0000-0000", "No name", 0.0);
    }

    public BankAccount(String accountNumber, String ownerName, double balance) {
        setAccountNumber(accountNumber);
        setOwnerName(ownerName);
        if (balance < 0) {
            throw new IllegalArgumentException("Balance must be greater than or equal to 0");
        }
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0");
        }
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0 || amount > balance) {
            throw new IllegalArgumentException("Amount must be greater than 0 and less than or equal to balance");
        }
        balance -= amount;
    }

    public void transfer(BankAccount other, double amount) {
        if (other == null) {
            throw new IllegalArgumentException("The other account must not be null");
        }
        // withdraw sẽ kiểm tra amount
        this.withdraw(amount);
        other.deposit(amount);
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        if (accountNumber == null || accountNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("The account number must not be null");
        }
        this.accountNumber = accountNumber.trim();
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        if (ownerName == null || ownerName.trim().isEmpty()) {
            throw new IllegalArgumentException("The owner name must not be null");
        }
        this.ownerName = ownerName.trim();
    }

    @Override
    public String toString() {
        return String.format("AccountNumber: %s | Owner: %s | Balance: %.2f",
                accountNumber, ownerName, balance);
    }
}
