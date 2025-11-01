package example.p20_multithreading.deadlock;

public class TestThread {

	public static void main(String[] args) {
		final Runner runner = new Runner();
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				runner.Thread1();
			}
		});
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				runner.Thread2();
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
		runner.showResult();
	}

}
