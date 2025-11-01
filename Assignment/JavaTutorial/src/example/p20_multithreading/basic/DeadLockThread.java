package example.p20_multithreading.basic;

public class DeadLockThread implements Runnable{
	
	public synchronized void test1() {
		System.out.println("test 1");
		test2();
	}
	
	public synchronized void test2() {
		System.out.println("test 2");
		test1();
	}
	
	@Override
	public void run() {
		test1();
	}
	
	public static void main(String[] args) {
		DeadLockThread dbt = new DeadLockThread();
		Thread t1 = new Thread(dbt);
		Thread t2 = new Thread(dbt);
		t1.start();
		t2.start();
	}
}
