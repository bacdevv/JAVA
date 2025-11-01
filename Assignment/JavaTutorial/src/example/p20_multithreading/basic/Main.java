package example.p20_multithreading.basic;

public class Main {
	
	/*
	 * 15. Xử lý đa luồng MultiThreading - Tạo Thread, 3 cách: + extends Thread +
	 * implements Runnable + Trực tiếp - Đồng bộ synchronized - Phương thức join() -
	 * Khai báo số lượng tiến trình ThreadPoolExecutor Tạo: class RunPool implements
	 * Runnable{
	 * 
	 * @Override public void run(){ ... } } + Cách 1: ArrayBlockingQueue<Runnable>
	 * queue = new ArrayBlockingQueue<Runnable>(<Số lượng tiến trình>);
	 * ThreadPoolExecutor(arg1, arg2, arg3, arg4, arg5); arg1: Số tiến trình mặc
	 * định arg2: Số tiến trình tối đa có thể xử lý >= arg2 arg3: Thời gian sống
	 * (thực thi) của 1 tiến trình arg4: Đơn vị của thời gian thực thi
	 * (TimeUnit.SECONDS) arg5: Số tiến trình trong hàng đợi (queue)
	 * pool.execute(new RunPool(i)); // Thực thi pool + Cách 2: ExecutorService pool
	 * = Executors.newFixedThreadPool(<Số tiến trình xử lý tối đa>); pool.submit(new
	 * RunPool()); pool.awaitTermination(<Thời gian sống>,<Đơn vị>);
	 * pool.shutdown(); - CountdownLatch - ProducerConsumer - WaitNotify - Lock -
	 * ReentranLock wait() signalALL() - DeadLock - Semaphore acquire() release() -
	 * Callable và Future
	 */

	public static void main(String[] args) {
		MyThread01 my1 = new MyThread01();
		Thread t = new Thread(my1);
		//
		MyThread02 my2 = new MyThread02();
		
		//
		t.start();
		my2.start();
		
		// G�?i thread trực tiếp
		Thread t3 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=0;i<10;i++) {
					System.out.println("C "+i);
				}
			}
		});
		t3.start();
	}

}
