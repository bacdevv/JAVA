package example.p13_more;

import java.text.DecimalFormat;
import java.util.Objects;

final class Rectangle {
    private final double width;
    private final double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double width()  { 
    	return this.width;
    }
    
    public double height() { 
    	return this.height;
    }

    @Override
	public int hashCode() {
		return Objects.hash(height, width);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rectangle other = (Rectangle) obj;
		return Double.doubleToLongBits(height) == Double.doubleToLongBits(other.height)
				&& Double.doubleToLongBits(width) == Double.doubleToLongBits(other.width);
	}

	@Override
	public String toString() {
    	DecimalFormat df = new DecimalFormat("0.0##############");
    	return String.format("Rectangle[width=%s, height=%s]",
    			df.format(width),
    			df.format(height));
    }
}

record RectangleRecord(double width, double height) { }

record RectangleGeneric<T extends Number>(T width, T height) { }

record RectangleImplementation(double width, double height) implements Comparable<RectangleImplementation> {

	@Override
	public int compareTo(RectangleImplementation o) {
		// TODO Auto-generated method stub
		return 0;
	}
}

record RectangleConstructor(double width, double height) {
	
	public RectangleConstructor() {
		this(1.0, 1.0);
	}
	
	public RectangleConstructor(double width, double height) {
		if (width <= 0 || height <= 0) {
            throw new java.lang.IllegalArgumentException(String.format("Invalid dimensions: %f, %f", width, height));
        }
		this.width = width;
		this.height = height;
	}
	
}

record RectangleMethod(double width, double height) {
	
	private static final double goldenRatio;
	
	static {
		goldenRatio = (1 + Math.sqrt(5)) / 2;
	}
	
	public static RectangleMethod createGoldenRectangle(double shorterSide) {
		return new RectangleMethod(shorterSide * goldenRatio, shorterSide);
	}
	
	public double calculateArea() {
		return width * height;
	}
	
}

public class RecordClassExample {
	public static void main(String[] args) {
		
		// https://docs.oracle.com/en/java/javase/16/language/records.html
	
		RectangleRecord rectangle1 = new RectangleRecord(5, 4);
		RectangleRecord rectangle2 = new RectangleRecord(5, 4);
		System.out.println(rectangle1);
		System.out.println(rectangle1.width() + " x " + rectangle1.height());
		System.out.println(rectangle1.equals(rectangle2));
		System.out.println(rectangle1 == rectangle2);
		
		Rectangle rectangle3 = new Rectangle(5, 4);
		Rectangle rectangle4 = new Rectangle(5, 4);
		System.out.println(rectangle3);
		System.out.println(rectangle3.width() + " x " + rectangle4.height());
		System.out.println(rectangle3.equals(rectangle4));
		System.out.println(rectangle3 == rectangle4);
		
	}
}
