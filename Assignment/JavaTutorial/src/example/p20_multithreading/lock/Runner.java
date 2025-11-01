package example.p20_multithreading.lock;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {
	int index = 0;
	
	Lock lock = new ReentrantLock();
	Condition cond = lock.newCondition();
	
	public void incrementIndex() {
		for(int i=0; i<10000;i++) {
			index++;			
		}
	}
	
	public void thread1() {
		System.out.println("Thread 1 đang ch�? xử lý ...");
		
		//
		lock.lock();
		try {
			cond.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		incrementIndex();
		lock.unlock();
	}
	public void thread2() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//
		lock.lock();
		incrementIndex();
		System.out.println("Nhập ENTER để chạy Thread 1");
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
		cond.signalAll();
		sc.close();
		lock.unlock();

	}
	public void showResult() {
		System.out.println("�?ây là kết qua sau khi đếm được: " + index);
	}
}

