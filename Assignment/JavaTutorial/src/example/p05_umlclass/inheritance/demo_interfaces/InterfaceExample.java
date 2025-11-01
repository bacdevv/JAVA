package example.p05_umlclass.inheritance.demo_interfaces;

public class InterfaceExample {

	public static void main(String[] args) {
		Bird b1 = new Bird();
		Animal b2 = new Bird(Gender.FEMALE, 5, false);
		Airplane a1 = new Airplane();
		Transport a2 = new Airplane();
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(a1);
		System.out.println(a2);
		
		System.out.println(b1.isMammal());
		System.out.println(b1.makeSound());
		b1.fly();
		b1.print();
		System.out.println(Actionable.TYPE);
		Actionable.display();
		
		a1.fly();	
	}

}
