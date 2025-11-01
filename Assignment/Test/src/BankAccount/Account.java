package BankAccount;

import java.text.NumberFormat;
import java.util.Locale;

public class Account {
    private long accountNumber;
    private String accountName;
    private double balance;
    private String status = "";

    public static final double INTEREST_RATE = 0.035;
    public static final String DEFAULT_NAME = "chưa xác định";
    public static final double DEFAULT_BALANCE = 50.0;
    public static final long DEFAULT_ACCOUNT_NUMBER = 999999l;

    public Account() {
        this(DEFAULT_ACCOUNT_NUMBER, DEFAULT_NAME, DEFAULT_BALANCE);
    }

    public Account(long accountNumber, String accountName, double balance) {
        setAccountName(accountName);
        setAccountNumber(accountNumber);
        setBalance(balance);
        this.status = "";
    }

    public Account(long accountNumber, String accountName) {
        this(accountNumber, accountName, DEFAULT_BALANCE);
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        if (accountNumber <= 0 || accountNumber == DEFAULT_ACCOUNT_NUMBER) {
            this.status += "INVALID Account Number!!!";
            this.accountNumber = DEFAULT_ACCOUNT_NUMBER;
        }
        else {
            this.accountNumber = accountNumber;
        }
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        if (accountName == null || accountName.trim().isEmpty()) {
            this.status += "INVALID Account Name must not be empty";
            this.accountName = DEFAULT_NAME;
        }
        else {
            this.accountName = accountName;
        }
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance < 50) {
            this.status += "INVALID Amount must be greater than or equal to 50";
            this.balance = DEFAULT_BALANCE;
        }
        else {
            this.balance = balance;
        }
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public boolean deposit(double amount) {
    	if (amount > 0) {
    		balance += amount;
    		return true;
    	}
    	else {
    		status += "Invalid amount";
    		return false;
    	}
    }
    
    public boolean withdraw(double amount) {
    	if (amount > 0 && amount <= balance) {
    		balance -= amount;
    		return true;
    	}
    	else {
    		status += "Invalid amount";
    		return false;
    	}
    }
    
    public boolean transfer(Account destiAccount, double amount) {
    	if (amount <= 0 || amount > balance) {
    		this.status += "INVALID AMOUNT";
    		return false;
    	}
    	else {
    		balance -= amount;
    		destiAccount.balance += amount;
    		return true;
    	}


    }
    
    public double interestBalance() {
    	double interest = balance * INTEREST_RATE;
    	return balance += interest;
    }
    
    
    @Override
    public String toString() {
    	Locale local = new Locale("vi", "vn");
    	NumberFormat formatter = NumberFormat.getCurrencyInstance(local);
    	String balanceFormatter = formatter.format(balance);
    	
    	return String.format("%d %-35s %-25s %s", accountNumber, accountName, balanceFormatter, status);
    }
}
