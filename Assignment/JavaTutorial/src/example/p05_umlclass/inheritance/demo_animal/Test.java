package example.p05_umlclass.inheritance.demo_animal;

public class Test {

	public static void main(String[] args) {
		Animal cat1 = new Cat();
		Animal cat2 = new Cat(Gender.FEMALE, 10, FurColor.PATTERN);
		Animal fish1 = new Fish();
		Animal fish2 = new Fish(Gender.MALE, 1, HabitedWater.BRACKISHWATER);
		
		System.out.println(cat1);
		System.out.println(cat2);
		System.out.println(fish1);
		System.out.println(fish2);
		
	}

}
