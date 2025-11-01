package example.p07_functions;

@FunctionalInterface
interface Power {
	double pow(double base, double exponent); // (unique) public abstract
	
	default void runDefaultMethod() {
		System.out.println("Run Default Method");
	}
	
	public static void runStaticMethod() {
		System.out.println("Run Static Method");
	}
}

@FunctionalInterface
interface IFunction<X, Y, Z, R> {
	R run(X x, Y y, Z z);
}

public class LambdaExpressionExample {
	
	public static void main(String[] args) {
		/* Functional Interface
		 * + Is an interface with only one abstract method
		 * + Except default methods and static methods
		 */

		/* Basic Example ~ Anonymous Class (Classic method) */
		Power power = new Power() {
			
			@Override
			public double pow(double base, double exponent) {
				return Math.pow(base, exponent);
			}
		};
		
		System.out.println(power.pow(2,8));
		
		/* Basic Example ~ Lambda Expression (Modern method): () -> {} */
		Power math = (base, exponent) -> Math.pow(base, exponent);
		System.out.println(math.pow(2,8));
		Power.runStaticMethod();
		math.runDefaultMethod();
		
		/* Advanced Example ~ Generic */
		IFunction<Double, Double, Double, String> pointer = (x, y, z) -> {
			return String.format("Point(%.2f; %.2f; %.2f)", x, y, z);
		};
		
		System.out.println(pointer.run(4.0, 5.0, 2.0));
		
		IFunction<String[], String, Integer, String> joiner = (elements, separator, repeat) -> {
			if(repeat <= 0) {
				repeat = 1;
			}
			return String.join(separator, elements).repeat(repeat);
		};		
		
		String[] stringList = {"Basic", "Java"};
		System.out.println(joiner.run(stringList, "+", 2));
		
	}

}
