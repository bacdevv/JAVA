package Bank;

import java.text.NumberFormat;
import java.util.Locale;

public class Account {
    private long accountNumber;
    private String accountName;
    private double balance;
    private String status = "";

    public static final double INTEREST_RATE = 0.035;
    public static final long DEFAULT_ACCOUNT = 999999L;
    public static final String DEFAULT_NAME = "chưa xác định";
    public static final double MIN_BALANCE = 50.0;

    public Account() {
        this(DEFAULT_ACCOUNT, DEFAULT_NAME, MIN_BALANCE);
    }

    public Account(long accountNumber, String accountName, double balance) {
        setStatus("");
        setAccountNumber(accountNumber);
        setAccountName(accountName);
        setBalance(balance);
    }

    public Account(long accountNumber, String accountName) {
        this(accountNumber, accountName, MIN_BALANCE);
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        if (accountNumber <= 0 || accountNumber == DEFAULT_ACCOUNT) {
            this.accountNumber = DEFAULT_ACCOUNT;
            status += "Số tài khoản không hợp lệ -> dùng mặc định 999999; ";
        } else {
            this.accountNumber = accountNumber;
        }
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        if (accountName == null || accountName.trim().isEmpty()) {
            this.accountName = DEFAULT_NAME;
            status += "Tên tài khoản trống -> dùng mặc định 'chưa xác định'; ";
        } else {
            this.accountName = accountName.trim();
        }
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance < MIN_BALANCE) {
            this.balance = MIN_BALANCE;
            status += "Số dư quá thấp -> dùng mặc định 50; ";
        } else {
            this.balance = balance;
        }
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = (status == null) ? "" : status;
    }

    public void clearStatus() {
        status = "";
    }

    public boolean deposit(double amount) {
        if (amount <= 0) {
            status += "Nạp tiền thất bại: số tiền không hợp lệ; ";
            return false;
        }
        balance += amount;
        status += "Nạp tiền thành công; ";
        return true;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0 || amount > balance) {
            status += "Rút tiền thất bại: số tiền không hợp lệ; ";
            return false;
        }
        balance -= amount;
        status += "Rút tiền thành công; ";
        return true;
    }

    public boolean transfer(Account destination, double amount) {
        if (destination == null) {
            status += "Chuyển tiền thất bại: tài khoản đích null; ";
            return false;
        }
        if (amount <= 0 || amount > balance) {
            status += "Chuyển tiền thất bại: số tiền không hợp lệ; ";
            return false;
        }
        balance -= amount;
        destination.balance += amount;
        status += "Chuyển tiền thành công; ";
        destination.status += "Nhận chuyển khoản: " + amount + "; ";
        return true;
    }

    public void applyInterest() {
        double interest = balance * INTEREST_RATE;
        balance += interest;
        status += "Đáo hạn: cộng lãi suất; ";
    }

    @Override
    public String toString() {
        Locale locale = new Locale("vi", "VN");
        NumberFormat formatter = NumberFormat.getCurrencyInstance(locale);
        String formattedBalance = formatter.format(balance);
        return String.format("%d %-30s %-18s %s", accountNumber, accountName, formattedBalance, status);
    }
}