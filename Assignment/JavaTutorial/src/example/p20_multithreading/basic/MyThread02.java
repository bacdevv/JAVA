package example.p20_multithreading.basic;

public class MyThread02 extends Thread {
	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println("B "+i);
		}
	}
}
