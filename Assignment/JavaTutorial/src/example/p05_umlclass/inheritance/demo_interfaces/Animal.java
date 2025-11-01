package example.p05_umlclass.inheritance.demo_interfaces;

public abstract class Animal {
	protected Gender gender;
	protected int age;

	public Animal(){
		this(Gender.MALE, 0);
	}
	
	public Animal(Gender gender, int age) {
		setGender(gender);
		setAge(age);
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		if (gender == null || !(gender instanceof Gender)) {
			throw new IllegalArgumentException("Invalid Gender");
		}
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if (age < 0) {
			throw new IllegalArgumentException("Invalid Age");
		}
		this.age = age;
	}

	public abstract String makeSound();

	public abstract boolean isMammal();

	@Override
	public String toString() {
		return String.format("%s | %s", gender, age);
	}
}
