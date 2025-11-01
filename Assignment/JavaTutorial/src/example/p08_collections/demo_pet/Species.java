package example.p08_collections.demo_pet;

public enum Species {
	CAT("Mèo"),
    DOG("Chó"),
    FISH("Cá"),
    BIRD("Chim"),
    OTHER("Khác");

    private String description;

    private Species(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
	
}
