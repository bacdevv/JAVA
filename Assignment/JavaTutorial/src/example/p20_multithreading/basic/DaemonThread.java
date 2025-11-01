package example.p20_multithreading.basic;

public class DaemonThread extends Thread{
	@Override
	public void run() {
		for(int i=0;i<5;i++) {
//			try {
//				Thread.sleep(500);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			
			System.out.println(this.getName() + " " + i);
		}
	}
	public static void main(String[] args) {
		DaemonThread t1 = new DaemonThread();
		DaemonThread t2 = new DaemonThread();
		DaemonThread t3 = new DaemonThread();
		t1.setName("A");
		t2.setName("B");
		t3.setName("C");
		
		t1.setPriority(1);
		t2.setPriority(10);
		t3.setPriority(5);
		
//		t1.start();
//		t2.start();
//		t3.start();
		//Daemon: chạy ngầm
		t1.setDaemon(true);
		System.out.println(t1.isDaemon());
	}
}
