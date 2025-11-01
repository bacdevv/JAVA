package BankAccount;

import java.util.Scanner;

public class AccountTest {
	public static final Scanner SCANNER = new Scanner(System.in);
	
	public static void main(String[] args) {
		AccountList list = new AccountList();
		boolean running = true;
		
		while (running) {
			printMenu();
			System.out.print("Chọn chức năng: ");
			int choice = SCANNER.nextInt();
			
			switch(choice) {
				case 1:
					System.out.print("Nhập số tài khoản: ");
					long accountNumber = SCANNER.nextLong();
					System.out.print("Nhập tên tài khoản: ");
					String accountName = SCANNER.nextLine();
					System.out.print("Nhập số dư ban đầu: ");
					double balance = SCANNER.nextDouble();
					
					Account account = new Account(accountNumber, accountName, balance);
                    System.out.println(account);
					break;

                case 3:
                    list.printAccounts();
                    break;
			}
		}
	}
	
	private static void printMenu() {
		System.out.println("=== MENU ===");
		System.out.println("1. Thêm tài khoản");
		System.out.println("2. Số tài khoản hiện có");
		System.out.println("3. In thông tin tất cả tài khoản");
		System.out.println("4. Nạp tiền vào tài khoản");
		System.out.println("5. Rút tiền");
		System.out.println("6. Chuyển tiền");
		System.out.println("7. Kết thúc");
	}
}
