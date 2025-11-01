package example.p05_umlclass.inheritance.demo_interfaces;

public class Bird extends Animal implements Actionable {
	
	private boolean isFlyable;
	
	public Bird() {
		super();
		setFlyable(true);
	}
	
	public Bird(Gender gender, int age, boolean isFlyable) {
		super(gender, age);
		setFlyable(isFlyable);
	}

	public boolean isFlyable() {
		return isFlyable;
	}

	public void setFlyable(boolean isFlyable) {
		this.isFlyable = isFlyable;
	}

	@Override
	public String makeSound() {
		return "Bird~~~";
	}

	@Override
	public boolean isMammal() {
		return false;
	}
	
	@Override
	public String toString() {
		return String.format("Bird [ %s | %s ]",
				super.toString(),
				isFlyable ? "Can Fly" : "Cannot Fly"
		);
	}

	@Override
	public void fly() {
		System.out.println("This Bird " + (isFlyable ? "Can Fly" : "Cannot Fly"));
	}

	@Override
	public void sleep() {
		System.out.println("This Bird Can Sleep");
	}

	@Override
	public void eat() {
		System.out.println("This Bird Can Eat");		
	}

}
