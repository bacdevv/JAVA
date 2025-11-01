package example.p20_multithreading.message;

public class MessageReceiver implements Runnable {
	MessageClass msg;
	
	public MessageReceiver(MessageClass msg) {
		this.msg = msg;
	}

	@Override
	public void run() {
		synchronized (msg) {
			System.out.println("�?ang lấy tin nhắn...");
			try {
				//Ch�? đến khi ngư�?i gửi tin notify
				msg.wait();
				System.out.println("�?ã nhận được tin, nội dung: " + msg.getNoidung());
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

}
