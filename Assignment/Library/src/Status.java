public enum Status {
    NEW("New"),
    OLD("Old");

    private String text;

    private Status(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
