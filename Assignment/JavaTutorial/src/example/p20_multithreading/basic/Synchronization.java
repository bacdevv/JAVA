package example.p20_multithreading.basic;

/*synchronized*/

public class Synchronization implements Runnable{
	
	public int tong;
	
	public Synchronization() {
		this.tong = 1000;
	}
	
	public synchronized void rutTien() throws InterruptedException {
		if(tong>0) {
			Thread.sleep(1000);
			tong = tong - 1000;
			System.out.println(tong);
		}else {
			System.out.println("Không còn ti�?n");
		}
		
	}

	@Override
	public void run() {
		try {
			rutTien();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Synchronization t = new Synchronization();
		
		Thread t1 = new Thread(t);
		Thread t2 = new Thread(t);
		
		t1.start();
		t2.start();
	}

}
