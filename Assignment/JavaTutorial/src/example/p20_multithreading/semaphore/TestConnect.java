package example.p20_multithreading.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TestConnect {

	public static void main(String[] args) {
//		int i = 2;	// Số luồng cho phép truy cập
//		Semaphore sp = new Semaphore(i);	
//		try {
//			//Giảm số luồng cho phép truy cập
//			sp.acquire();
//			//Giải phóng luồng
//			sp.release();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("Giá trị cho phép truy cập: " + sp.availablePermits());
		
		//Bắt số luồng truy cập
		ExecutorService pool = Executors.newCachedThreadPool();
		for(int i=0;i<300;i++) {
			pool.submit(new Runnable() {
				
				@Override
				public void run() {
					Connect.openConnect().countAccessThread();				
				}
			});
		}
		pool.shutdown();
		try {
			pool.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
