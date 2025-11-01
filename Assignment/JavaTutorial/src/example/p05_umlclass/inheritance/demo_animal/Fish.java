package example.p05_umlclass.inheritance.demo_animal;

public class Fish extends Animal {
	
	private HabitedWater habitedWater;

	public Fish() {
		super();
		this.habitedWater = HabitedWater.FRESHWATER;
	}
	
	public Fish(Gender gender, int age, HabitedWater habitedWater) {
		super(gender, age);
		this.habitedWater = habitedWater;
	}

	public HabitedWater getHabitedWater() {
		return habitedWater;
	}

	public void setHabitedWater(HabitedWater habitedWater) {
		if (habitedWater == null || habitedWater instanceof HabitedWater) {
			throw new IllegalArgumentException();
		}
		this.habitedWater = habitedWater;
	}

	@Override
	public String toString(){
		return String.format("Fish [ %s | %s ]", super.toString(), habitedWater);
	}

	@Override
	public String makeSound() {
		return "~~~!";
	}

	@Override
	public String move() {
		return "Swim!";
	}

	@Override
	public boolean isMammal() {
		return false;
	}
	
}
