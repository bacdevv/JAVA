package example.p05_umlclass.inheritance.demo_interfaces;

public interface Actionable extends Flyable, Sleepable, Edible {
	
	public static final String TYPE = "Flyable";
	
	public static void display() {
		System.out.println("Actionable includes Flyable, Sleepable and Edible");
	}
	
	default void print() {
		System.out.println("Default method of Actionable interface");
	}

}
