package example.p20_multithreading.semaphore;

import java.util.concurrent.Semaphore;

public class Connect {
	public static Connect newConnect = new Connect();
	int count =0;
	Semaphore se = new Semaphore(20);
	public Connect() {
		
	}
	public static Connect openConnect() {
		return newConnect;
	}
	public void countAccessThread() {
		synchronized(this) {
			try {
				se.acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			count++;
			System.out.println("Access Threads : " + count);
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		synchronized(this) {
			count--;
			se.release();
		}
	}
}
