package example.p04_modifiers.nonaccess;

public class StaticExample {
	private String field;
	private static String msg;
	private static int count = 0;

	static {
		System.out.println("Run static block");
		msg = "Message from static block";
	}
	
	public StaticExample(String field) {
		StaticExample.count++;
		this.field = field;
		System.out.println("Field of instance = " + this.field);
	}
	
	private static void runStaticMethod() {
		System.out.println("Run code at static method");
	}
	
	private String getField() {
		return this.field;
	}
	
	public static void main(String[] args) {
		System.out.println("Run main method");
		System.out.println(msg);
		runStaticMethod();
		StaticExample.runStaticMethod();
		StaticExample sd1 = new StaticExample("Field +1");
		StaticExample sd2 = new StaticExample("Field +1");
		StaticExample sd3 = new StaticExample("Field +1");
		System.out.println(sd1.getField());
		System.out.println(sd2.getField());
		System.out.println(sd3.getField());
//		System.out.println("Get value from instance: " + sd1.count); // Warning
		System.out.println("Get value from class: " + StaticExample.count);
		System.out.println("Access inner class: " + StaticExample.Inner.getInfo());
		System.out.println("Access inner class: " + (new StaticExample.Inner()).getValue());
	}
	
	public static class Inner {
		private int value;
		
		public Inner() {
			this.value = 5;
		}
		
		public int getValue() {
			return value;
		}

		public static String getInfo() {
			return "Inner Class here";
		}
	}
}
