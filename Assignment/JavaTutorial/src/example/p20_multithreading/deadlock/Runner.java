package example.p20_multithreading.deadlock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {
	TaiKhoan tk1 = new TaiKhoan();
	TaiKhoan tk2 = new TaiKhoan();
	
	Lock lock1 = new ReentrantLock();
	Lock lock2 = new ReentrantLock();
	
	private void avoidDeadLock(Lock lk1, Lock lk2) {
		while(true) {
			boolean getStatusLock1 = false;
			boolean getStatusLock2 = false;
			try {
				getStatusLock1 = lk1.tryLock();
				getStatusLock2 = lk2.tryLock();
			} finally {
				if(getStatusLock1 && getStatusLock2) {
					return;
				}
				if(getStatusLock1) {
					lk1.unlock();
				}
				if(getStatusLock2) {
					lk2.unlock();
				}
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}
	
	public void Thread1() {
		Random  rd = new Random();
		for(int i=0;i<10000;i++) {
			avoidDeadLock(lock1, lock2);
			tk1.doGiaoDich(tk1, tk2, rd.nextInt(100));
			lock1.unlock();
			lock2.unlock();
		}
	}
	public void Thread2() {
		Random  rd = new Random();
		for(int i=0;i<10000;i++) {
			avoidDeadLock(lock1, lock2);
			tk1.doGiaoDich(tk2, tk1, rd.nextInt(100));
			lock1.unlock();
			lock2.unlock();
		}
	}
	public void showResult() {
		System.out.println("Số tài khoản 1: " + tk1.getTongTien());
		System.out.println("Số tài khoản 2: " + tk2.getTongTien());
		System.out.println("Tổng: " + (tk1.getTongTien()+tk2.getTongTien()) );
	}
}
