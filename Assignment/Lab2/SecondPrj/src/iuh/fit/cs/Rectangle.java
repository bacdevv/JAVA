package iuh.fit.cs;
/**
* @description: Create Rectangle
* @author: Daniel
* @version 1.0
* @created: 02-09-2025 10:29:19 AM
*/
public class Rectangle {
	private double length;
	private double width;
	
	public Rectangle() {
		this(0.0, 0.0);
	}
	
	public Rectangle(double length, double width) {
		setLength(length);
		setWidth(width);
	}
	
	// Getter
	public double getLength() {
		return length;
	}
	
	public double getWidth() {
		return width;
	}
	
	// Setter
	public void setLength(double newVal) {
		this.length = newVal;
	}
	
	public void setWidth(double newVal) {
		this.width = newVal;
	}
	
	// Area
	public double getArea() {
		return width * length;
	}
	
	// Perimeter
	public double getPerimeter() {
		return (width + length) * 2;
	}
	
	// toString
	@Override
	public String toString() {
		return String.format("Width:%.2f\nLength:%.2f\nArea:%.2f\nPerimeter:%.2f",
				getWidth(), getLength(), getArea(), getPerimeter());
	}
}
