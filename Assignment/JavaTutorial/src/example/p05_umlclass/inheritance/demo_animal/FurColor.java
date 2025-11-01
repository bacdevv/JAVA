package example.p05_umlclass.inheritance.demo_animal;

public enum FurColor {
	SOLID("monochrome"),
	PATTERN("striped");

	private String meaning;
	
	private FurColor(String meaning){
		this.meaning = meaning;
	}

	@Override
	public String toString(){
		return meaning;
	}
}