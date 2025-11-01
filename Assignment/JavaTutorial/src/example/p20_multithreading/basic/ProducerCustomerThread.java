package example.p20_multithreading.basic;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerCustomerThread {

	/*--- C�ch 1 ------------------------------------*/
	static int value;
	static BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<Integer>(10);
	public static void ProducerThread() {
		Random rd = new Random();
		while(true) {
			try {
				blockingQueue.put(rd.nextInt(10));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}
	
	public static void ConsumerThread() {
		Random rd = new Random();
		while(true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(rd.nextInt(10)==0) {
				try {
					value = blockingQueue.take();
					System.out.println("Value: " + value + " || BlockingQueue Size: " + blockingQueue.size());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	/*--- C�ch 2 ------------------------------------*/
	
	
	/*--- MAIN ---*/
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				ProducerThread();
			}
		});
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				ConsumerThread();
			}
		});
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
