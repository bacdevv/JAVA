package tuan4;

import java.util.Scanner;

public class BankTester {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank("IUH Bank", 100);

        while (true) {
            printMenu();
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine().trim();
            if (choice.isEmpty()) continue;

            switch (choice) {
                case "1":
                    System.out.println("Add new account");
                    System.out.print("Enter account number: ");
                    String accNo = scanner.nextLine().trim();
                    System.out.print("Enter account name: ");
                    String owner = scanner.nextLine().trim();
                    System.out.print("Enter balance: ");
                    double balance = readDouble(scanner);
                    try {
                        bank.addNew(accNo, owner, balance);
                        System.out.println("Account added.");
                    } catch (IllegalArgumentException ex) {
                        System.out.println("Error: " + ex.getMessage());
                    }
                    break;

                case "2":
                    System.out.println("Deposit");
                    System.out.print("Enter account number: ");
                    accNo = scanner.nextLine().trim();
                    BankAccount accDep = bank.find(accNo);
                    if (accDep == null) {
                        System.out.println("Account not found.");
                        break;
                    }
                    System.out.print("Enter amount to deposit: ");
                    double dep = readDouble(scanner);
                    try {
                        accDep.deposit(dep);
                        System.out.println("Deposit successful. New balance: " + accDep.getBalance());
                    } catch (IllegalArgumentException ex) {
                        System.out.println("Error: " + ex.getMessage());
                    }
                    break;

                case "3":
                    System.out.println("Withdraw");
                    System.out.print("Enter account number: ");
                    accNo = scanner.nextLine().trim();
                    BankAccount accW = bank.find(accNo);
                    if (accW == null) {
                        System.out.println("Account not found.");
                        break;
                    }
                    System.out.print("Enter amount to withdraw: ");
                    double w = readDouble(scanner);
                    try {
                        accW.withdraw(w);
                        System.out.println("Withdraw successful. New balance: " + accW.getBalance());
                    } catch (IllegalArgumentException ex) {
                        System.out.println("Error: " + ex.getMessage());
                    }
                    break;

                case "4":
                    System.out.println("Transfer");
                    System.out.print("Enter source account number: ");
                    String src = scanner.nextLine().trim();
                    System.out.print("Enter destination account number: ");
                    String dest = scanner.nextLine().trim();
                    BankAccount sourceAcc = bank.find(src);
                    BankAccount destAcc = bank.find(dest);
                    if (sourceAcc == null || destAcc == null) {
                        System.out.println("Source or destination account not found.");
                        break;
                    }
                    System.out.print("Enter amount to transfer: ");
                    double amt = readDouble(scanner);
                    try {
                        sourceAcc.transfer(destAcc, amt);
                        System.out.println("Transfer successful.");
                        System.out.println("Source balance: " + sourceAcc.getBalance());
                        System.out.println("Destination balance: " + destAcc.getBalance());
                    } catch (IllegalArgumentException ex) {
                        System.out.println("Error: " + ex.getMessage());
                    }
                    break;

                case "5":
                    System.out.println("Total balance of all bank accounts in the bank: " + bank.getTotalBalance());
                    break;

                case "6":
                    System.out.println("Print all bank accounts");
                    BankAccount[] list = bank.getAccounts();
                    if (list.length == 0) {
                        System.out.println("No accounts.");
                    } else {
                        for (BankAccount a : list) {
                            System.out.println(a);
                        }
                    }
                    break;

                case "7":
                    System.out.println("Exit");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

            System.out.println(); // blank line
        }
    }

    private static void printMenu() {
        System.out.println("Welcome to IUH Bank");
        System.out.println("1. Open new account");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Transfer");
        System.out.println("5. The total balance of all bank accounts in the bank");
        System.out.println("6. Print all bank accounts");
        System.out.println("7. Exit");
    }

    private static double readDouble(Scanner scanner) {
        while (true) {
            String line = scanner.nextLine().trim();
            try {
                return Double.parseDouble(line);
            } catch (NumberFormatException ex) {
                System.out.print("Invalid number. Please enter again: ");
            }
        }
    }
}
