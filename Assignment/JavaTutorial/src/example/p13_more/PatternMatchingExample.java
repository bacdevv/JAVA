package example.p13_more;

sealed interface Shape permits CircleShape, RectangleShape {}
record CircleShape(double radius) implements Shape {}
record RectangleShape(double width, double height) implements Shape {}

class Heo{}

public class PatternMatchingExample {

	static double area1(Object obj) {
		double area = 0.0;
	    if(obj instanceof CircleShape c) {
	    		area = Math.PI * Math.pow(c.radius(), 2);
	    } else if (obj instanceof RectangleShape r) {
			area = r.width() * r.height();
		}
	    return area;
	}

	static double area2(Shape shape) {
		return switch (shape) {
	        case CircleShape c -> Math.PI * Math.pow(c.radius(), 2);
	        case RectangleShape r -> r.width() * r.height();
		}; 
	}
	
	static String test1(Object obj) {
	    return switch (obj) {
	        case String s when s.length() > 5 -> "Long string";
	        case String s -> "Short string";
	        case null -> "Null!";
	        default -> "Other";
	    };
	}
	
	static String test2(Object obj) {
		String result = switch (obj) {
	        case String s when s.length() > 5 -> {
	        		yield "Long string";
	        }
	        case String s -> {
	        		yield "Short string";
	        }
	        case null -> {
	        		yield "Null!";
	        }
	        default -> {
	        		yield "Other";
	        }
	    };
	    return result;
	}
	
	public static void main(String[] args) {
		System.out.println(test1(6));
		System.out.println(test1("Hello Java"));
		System.out.println(test2("Core"));
		System.out.println(test2(null));
		System.out.println(area1(new CircleShape(5)));
		System.out.println(area2(new RectangleShape(5, 4)));
	}

}
