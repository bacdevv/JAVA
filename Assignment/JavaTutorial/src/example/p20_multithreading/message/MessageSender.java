package example.p20_multithreading.message;

public class MessageSender implements Runnable{
	MessageClass msg;
	
	public MessageSender(MessageClass msg) {
		this.msg = msg;
	}
	@Override
	public void run() {
		try {
			Thread.sleep(1000);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		synchronized (msg) {
			msg.setNoidung("Xin chao");
			/*
			 * Dùng notify() sẽ g�?i ngẫu nhiên 1 tiến trình đang ở chế độ ch�?
			 * Dùng notifyAll sẽ g�?i tất cả các tiến trình đang ở chế độ ch�?
			 */
			msg.notifyAll();
		}
	}
}
