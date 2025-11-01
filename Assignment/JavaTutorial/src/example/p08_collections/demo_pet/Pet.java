package example.p08_collections.demo_pet;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Pet {
	private final String id;
    private String name;
    private Species species;
    private Gender gender;
    private LocalDate birthDate;
    private List<FurColor> furColors;
    private double weight;
    
	public Pet(String id, String name, Species species,
			Gender gender, LocalDate birthDate,
			List<FurColor> furColors, double weight) {
		if (id == null || id.trim().isEmpty()) {
			id = "-unidentified-";
		}
		this.id = id;
		setName(name);
		setGender(gender);
		setBirthDate(birthDate);
		setSpecies(species);
		setFurColors(furColors);
		setWeight(weight);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(name == null || name.trim().isEmpty()) {
			name = "-unidentified-";
		}
		this.name = name;
	}

	public Species getSpecies() {
		return species;
	}

	public void setSpecies(Species species) {
		this.species = species;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public List<FurColor> getFurColors() {
		return furColors;
	}

	public void setFurColors(List<FurColor> furColors) {
		this.furColors = furColors;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getId() {
		return id;
	}
	
	@Override
	public String toString() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("0.00Kg");
		return String.format("Pet {%15s, %-10s, %-5s, %-5s, %10s, %7s, %s}",
				id,
				name,
				species,
				gender,
				dtf.format(birthDate),
				df.format(weight),
				furColors
		);
	}
    
    
}
