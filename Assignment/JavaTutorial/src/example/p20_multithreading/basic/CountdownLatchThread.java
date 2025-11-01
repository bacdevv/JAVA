package example.p20_multithreading.basic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Runner implements Runnable{
	
	CountDownLatch cdl;
	
	public Runner(CountDownLatch i) {
		this.cdl = i;
	}
	
	@Override
	public void run() {
		System.out.println("�?ang xử lý ... ");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("�?ã xử lý xong.");
		
		//�?ếm số cổng
		cdl.countDown();
	}
}

public class CountdownLatchThread {

	public static void main(String[] args) {
		
		//Số cổng vào tối đa được đếm
		CountDownLatch latch = new CountDownLatch(4);
		
		//Số thread tối đa được xử lý đồng th�?i
		ExecutorService pool = Executors.newFixedThreadPool(3);
		
		for(int i=0;i<6;i++) {
			pool.submit(new Runner(latch));	
		}
		
		//Ch�? đến khi đếm đủ số cổng tối đa
		try {
			latch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("�?ã hoàn thành!!!");
	}

}
