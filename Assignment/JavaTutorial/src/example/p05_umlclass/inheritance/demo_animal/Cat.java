package example.p05_umlclass.inheritance.demo_animal;

public class Cat extends Animal {

	private FurColor furColor;

	public Cat() {
		super();
		this.furColor = FurColor.SOLID;
	}

	public Cat(Gender gender, int age, FurColor furColor) {
		super(gender, age);
		this.furColor = furColor;
	}

	public FurColor getFurColor() {
		return furColor;
	}

	public void setFurColor(FurColor furColor) {
		if (furColor == null || furColor instanceof FurColor) {
			throw new IllegalArgumentException();
		}
		this.furColor = furColor;
	}

	@Override
	public String toString(){
		return String.format("Cat [ %s | %s ]", super.toString(), furColor);
	}

	@Override
	public String makeSound() {
		return "Meow~!";
	}

	@Override
	public String move() {
		return "Walk!";
	}

	@Override
	public boolean isMammal() {
		return true;
	}
	
}