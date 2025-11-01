package example.p05_umlclass.inheritance.demo_animal;

public enum Gender {
	MALE("male"),
	FEMALE("female");
	
	private String gender;
	
	private Gender(String gender){
		this.gender = gender;
	}

	@Override
	public String toString(){
		return gender;
	}
}