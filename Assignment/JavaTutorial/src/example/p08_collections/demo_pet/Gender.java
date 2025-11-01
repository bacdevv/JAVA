package example.p08_collections.demo_pet;

public enum Gender {
	MALE("Đực"),
    FEMALE("Cái");

    private String description;

    private Gender(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }

}
