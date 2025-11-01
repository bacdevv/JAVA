package example.p20_multithreading.message;

public class TestMessageThread {

	public static void main(String[] args) {
		MessageClass msg = new MessageClass("Xử lý");
		Thread t1 = new Thread(new MessageSender(msg));
		Thread t2 = new Thread(new MessageReceiver(msg));
		
		t1.start();
		t2.start();
	}

}
