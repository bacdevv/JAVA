package example.p20_multithreading.basic;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestCallableFuture {

	public static void main(String[] args) {
		/*
		 * Dùng Future để lấy giá trị return của Callable
		 */
		ExecutorService pool = Executors.newCachedThreadPool();
		Future<Integer> future = pool.submit(new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				int tong = 0;
				Random rd1 = new Random();
				Random rd2 = new Random();
				int a = rd1.nextInt(400);
				int b = rd2.nextInt(400);
				System.out.println("Random 1: " + a);
				System.out.println("Random 2: " + b);
				tong = a + b;			
				return tong;
			}
		});
		pool.shutdown();
		try {
			System.out.println("Tong: " + future.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
