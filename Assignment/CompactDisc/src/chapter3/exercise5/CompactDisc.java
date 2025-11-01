package chapter3.exercise5;

import java.time.LocalDate;

public class CompactDisc {
    private String code;
    private String title;
    private int numSong;
    private double price;
    private LocalDate publishedDate;
    private State state;

    public CompactDisc(String code, String title, int numSong, double price, LocalDate publishedDate, State state) {
        this.code = code;
        this.title = title;
        this.numSong = numSong;
        this.price = price;
        this.publishedDate = publishedDate;
        this.state = state;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumSong() {
        return numSong;
    }

    public void setNumSong(int numSong) {
        this.numSong = numSong;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    
    
}
