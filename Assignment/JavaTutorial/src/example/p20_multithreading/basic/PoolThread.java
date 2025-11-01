package example.p20_multithreading.basic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class RunPool implements Runnable{
	
	int id;
	@Override
	public void run() {
		System.out.println("�?ang xử lý tiến trình " + id);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("�?ã xử lý tiến trình " + id);
	}
	
	public RunPool(int id) {
		this.id = id;
	}
}

public class PoolThread {

	public static void main(String[] args) {
//		ArrayBlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<Runnable>(100);
//		/*
//		 * ThreadPoolExecutor(arg1, arg2, arg3, arg4, arg5);
//		 * arg1: Số tiến trình mặc định
//		 * arg2: Số tiến trình tối đa có thể xử lý >= arg2
//		 * arg3: Th�?i gian sống (thực thi) của 1 tiến trình
//		 * arg4: �?ơn vị của th�?i gian thực thi (TimeUnit.SECONDS)
//		 * arg5: Số tiến trình trong hàng đợi (queue)
//		 */
//		ThreadPoolExecutor pool = new ThreadPoolExecutor(5, 5, 1, TimeUnit.SECONDS, workQueue);
//		
//		for(int i=0;i<20;i++) {
//			pool.execute(new RunPool(i));			
//		}
		ExecutorService pool = Executors.newFixedThreadPool(5);
		for(int i=0;i<20;i++) {
			pool.submit(new RunPool(i));	
		}
		
		try {
			pool.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pool.shutdown(); //�?óng pool
	}

}
