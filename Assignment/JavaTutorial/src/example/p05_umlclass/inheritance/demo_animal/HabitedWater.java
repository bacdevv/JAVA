package example.p05_umlclass.inheritance.demo_animal;

public enum HabitedWater {
	SALTWATER("salt water"),
	FRESHWATER("fresh water"),
	BRACKISHWATER("brackish water");

	private String waterType;
	
	private HabitedWater(String waterType){
		this.waterType = waterType;
	}

	@Override
	public String toString(){
		return waterType;
	}

}
