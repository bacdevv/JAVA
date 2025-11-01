package tuan4;

import java.util.Arrays;

public class Bank {
    private String name;
    private BankAccount[] accounts;
    private int count; // số tài khoản hiện có

    public Bank() {
        this("No name", 100);
    }

    public Bank(String name, int numberOfAccounts) {
        setName(name);
        if (numberOfAccounts <= 0) {
            throw new IllegalArgumentException("Number of accounts must be greater than 0");
        }
        accounts = new BankAccount[numberOfAccounts];
        count = 0;
    }

    public void addNew(String accountNumber, String accountName, double balance) {
        if (accountNumber == null || accountNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("The account number must not be null");
        }
        if (accountName == null || accountName.trim().isEmpty()) {
            throw new IllegalArgumentException("The owner name must not be null");
        }
        if (balance < 0) {
            throw new IllegalArgumentException("Balance must be greater than or equal to 0");
        }
        if (count >= accounts.length) {
            throw new IllegalArgumentException("Bank is full");
        }
        if (find(accountNumber) != null) {
            throw new IllegalArgumentException("Account number already exists");
        }
        BankAccount acc = new BankAccount(accountNumber.trim(), accountName.trim(), balance);
        accounts[count++] = acc;
    }

    public BankAccount find(String accountNumber) {
        if (accountNumber == null) {
            return null;
        }
        for (int i = 0; i < count; i++) {
            if (accounts[i].getAccountNumber().equals(accountNumber)) {
                return accounts[i];
            }
        }
        return null;
    }

    public double getTotalBalance() {
        double total = 0.0;
        for (int i = 0; i < count; i++) {
            total += accounts[i].getBalance();
        }
        return total;
    }

    public int getNumberOfAccounts() {
        return count;
    }

    public BankAccount[] getAccounts() {
        return Arrays.copyOf(accounts, count);
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("The bank name must not be null");
        }
        this.name = name.trim();
    }

}
