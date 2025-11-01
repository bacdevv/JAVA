package Bank;

import java.util.Scanner;

public class AccountTest {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        AccountList list = new AccountList();
        boolean running = true;
        while (running) {
            printMenu();
            System.out.print("Chọn chức năng: ");
            int choice = readInt();
            switch (choice) {
                case 1:
                    handleAddAccount(list);
                    break;
                case 2:
                    System.out.println("Số tài khoản hiện có: " + list.size());
                    break;
                case 3:
                    list.printAccounts();
                    break;
                case 4:
                    handleDeposit(list);
                    break;
                case 5:
                    handleWithdraw(list);
                    break;
                case 6:
                    handleTransfer(list);
                    break;
                case 7:
                    running = false;
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
                    break;
            }
            System.out.println();
        }
        System.out.println("Kết thúc chương trình.");
    }

    private static void printMenu() {
        System.out.println("===== MENU =====");
        System.out.println("1. Thêm tài khoản");
        System.out.println("2. Số TK hiện có");
        System.out.println("3. In thông tin tất cả TK");
        System.out.println("4. Nạp tiền vào TK");
        System.out.println("5. Rút tiền");
        System.out.println("6. Chuyển tiền");
        System.out.println("7. Kết thúc");
    }

    private static void handleAddAccount(AccountList list) {
        System.out.print("Nhập số tài khoản: ");
        long accountNumber = readLong();
        System.out.print("Nhập tên tài khoản: ");
        String accountName = SCANNER.nextLine();
        System.out.print("Nhập số dư ban đầu: ");
        double balance = readDouble();

        Account account = new Account(accountNumber, accountName, balance);
        if (list.add(account)) {
            System.out.println("Thêm tài khoản thành công.");
        } else {
            System.out.println("Danh sách đã đầy, không thể thêm.");
        }
        System.out.println("Trạng thái: " + account.getStatus());
    }

    private static void handleDeposit(AccountList list) {
        Account account = promptAccount(list, "Nhập số tài khoản cần nạp: ");
        if (account == null) {
            System.out.println("Không tìm thấy tài khoản.");
            return;
        }
        System.out.print("Số tiền nạp: ");
        double amount = readDouble();
        account.clearStatus();
        account.deposit(amount);
        System.out.println("Trạng thái: " + account.getStatus());
    }

    private static void handleWithdraw(AccountList list) {
        Account account = promptAccount(list, "Nhập số tài khoản cần rút: ");
        if (account == null) {
            System.out.println("Không tìm thấy tài khoản.");
            return;
        }
        System.out.print("Số tiền rút: ");
        double amount = readDouble();
        account.clearStatus();
        account.withdraw(amount);
        System.out.println("Trạng thái: " + account.getStatus());
    }

    private static void handleTransfer(AccountList list) {
        System.out.print("Nhập số tài khoản chuyển đi: ");
        Account source = promptAccount(list, null);
        if (source == null) {
            System.out.println("Không tìm thấy tài khoản nguồn.");
            return;
        }
        System.out.print("Nhập số tài khoản nhận: ");
        Account destination = promptAccount(list, null);
        if (destination == null) {
            System.out.println("Không tìm thấy tài khoản đích.");
            return;
        }
        System.out.print("Số tiền chuyển: ");
        double amount = readDouble();
        source.clearStatus();
        destination.clearStatus();
        source.transfer(destination, amount);
        System.out.println("Trạng thái nguồn: " + source.getStatus());
        System.out.println("Trạng thái đích: " + destination.getStatus());
    }

    private static Account promptAccount(AccountList list, String prompt) {
        if (prompt != null) {
            System.out.print(prompt);
        }
        long accountNumber = readLong();
        return list.findByAccountNumber(accountNumber);
    }

    private static int readInt() {
        while (true) {
            try {
                int value = Integer.parseInt(SCANNER.nextLine().trim());
                return value;
            } catch (NumberFormatException ex) {
                System.out.print("Giá trị không hợp lệ, nhập lại: ");
            }
        }
    }

    private static long readLong() {
        while (true) {
            try {
                long value = Long.parseLong(SCANNER.nextLine().trim());
                return value;
            } catch (NumberFormatException ex) {
                System.out.print("Giá trị không hợp lệ, nhập lại: ");
            }
        }
    }

    private static double readDouble() {
        while (true) {
            try {
                double value = Double.parseDouble(SCANNER.nextLine().trim());
                return value;
            } catch (NumberFormatException ex) {
                System.out.print("Giá trị không hợp lệ, nhập lại: ");
            }
        }
    }
}