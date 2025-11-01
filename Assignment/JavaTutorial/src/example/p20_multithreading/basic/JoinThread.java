package example.p20_multithreading.basic;

public class JoinThread extends Thread{
	@Override
	public void run() {
		for(int i=0;i<5;i++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println(this.getName() + " " + i);
		}
	}
	public static void main(String[] args) {
		JoinThread t1 = new JoinThread();
		t1.setName("Thread1");
		
		JoinThread t2 = new JoinThread();
		t2.setName("Thread2");
		
		JoinThread t3 = new JoinThread();
		t3.setName("Thread3");
		
		t1.start();
		try {
			t1.join(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t2.start();
		t3.start();
	}
}
