package example.p05_umlclass.inheritance.demo_interfaces;

public class Airplane extends Transport implements Flyable {

	@Override
	public void fly() {
		System.out.println("This Airplane Can Fly");
	}

	@Override
	public void move() {
		System.out.println("This Airplane Can Move Around");
	}
	
	@Override
	public String toString() {
		return "Airplane instance";
	}

}
