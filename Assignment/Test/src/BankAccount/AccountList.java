package BankAccount;

import java.util.Arrays;

public class AccountList {
	private Account[] accList;
	private int count;
	
	public AccountList() {
		accList = new Account[10];
		count = 0;
	}
	
	public AccountList(int n) {
		accList = new Account[(n > 0) ? n : 10];
		count = 0;
	}
	
	public boolean addAccount(Account newAccount) {
		if (newAccount == null || count >= accList.length) {
			return false;
		}
		accList[count++] = newAccount;
		return true;
	}
	
	public Account findAccount(long accountNumber) {
		for (int i = 0; i < count; i++) {
			if (accList[i].getAccountNumber() == accountNumber)
				return accList[i];
		}
		return null;
	}
	
	public boolean removeAccount(long accountNumber) {
		for (int i = 0; i < count; i++) {
			if (accList[i].getAccountNumber() == accountNumber) {
				int elementsToMove = count - i - 1;
				if (elementsToMove > 0) {
					System.arraycopy(accList, i + 1, accList, i, elementsToMove);
				}
				accList[--count] = null;
				return true;
			}
		}
		return false;
	}
	
	public int size() {
		return count;
	}
	
	
	public Account[] toArray() {
		return Arrays.copyOf(accList, count);
	}
	
	public void printAccounts() {
		for (int i = 0; i < count; i++) {
			System.out.println(accList[i]);
		}
	}	
	
}
