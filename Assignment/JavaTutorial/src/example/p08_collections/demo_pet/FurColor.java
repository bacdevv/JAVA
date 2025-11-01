package example.p08_collections.demo_pet;

public enum FurColor {
	BLACK("Đen"),
    WHITE("Trắng"),
    GRAY("Xám"),
    BROWN("Nâu"),
    ORANGE("Cam"),
    CREAM("Kem"),
    NONE("Không lông");

    private String description;

    private FurColor(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }

}
