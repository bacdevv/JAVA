package example.p07_functions;

import java.util.Arrays;
import java.util.stream.Stream;

class Utility {
	
	private String text;
	
	public Utility(String text) {
		this.text = text;
	}
	
	public String addLeading(String text) {
		return this.text + text;
	}
	
	public static String toTitleCase(String text) {
		if (text == null || text.isEmpty()) {
			return text;
		}
		String[] words = text.trim().split("\\s+");
		StringBuilder builder = new StringBuilder();
		for (String word : words) {
			if (word.length() > 1) {
				builder.append(Character.toUpperCase(word.charAt(0)));
				builder.append(word.substring(1).toLowerCase());
			} else {
				builder.append(word.toUpperCase());
			}
			builder.append(" ");
		}
		return builder.toString().trim();
	}
	
	@Override
	public String toString() {
		return "Object [" + text + "]";
	}
	
	
}

public class MethodReferenceExample {
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		/* Method References
		 * Is a shortened syntax of lambda expression
		 * When lambda expression just calls an existing method
		 * Method reference operator in Java is double colon ::
		 */
		
		String[] list = {"hello  world", "java core", "jSon gson javascript"};
		Utility utility = new Utility("#");
		//
		Stream<Utility> constructor1 = Arrays.stream(list).map(o -> new Utility(o));
		Stream<Utility> constructor2 = Arrays.stream(list).map(Utility::new);
		//
		Utility[] utilities1 = Arrays.stream(list).map(Utility::new).toArray(size -> new Utility[size]);
		Utility[] utilities2 = Arrays.stream(list).map(Utility::new).toArray(Utility[]::new);
		//
		Stream<String> staticMethod1 = Arrays.stream(list).map(o -> Utility.toTitleCase(o));
		Stream<String> staticMethod2 = Arrays.stream(list).map(Utility::toTitleCase);
		//
		Stream<Integer> instanceMethodFromClass1 = Arrays.stream(list).map(o -> o.length());
		Stream<Integer> instanceMethodFromClass2 = Arrays.stream(list).map(String::length);
		//
		Stream<String> instanceMethodFromObject1 = Arrays.stream(list).map(o -> utility.addLeading(o));
		Stream<String> instanceMethodFromObject2 = Arrays.stream(list).map(utility::addLeading);

	}
}
