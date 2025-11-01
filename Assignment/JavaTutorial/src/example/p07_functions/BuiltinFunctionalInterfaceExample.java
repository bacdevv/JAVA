package example.p07_functions;

import java.util.concurrent.Callable;
import java.util.function.*;

public class BuiltinFunctionalInterfaceExample {
	
	public static void main(String[] args) {
		/* Predicate - receives data, returns boolean
		 * Interface: Predicate<T> BiPredicate<T,U>
		 * Interface: IntPredicate LongPredicate DoublePredicate
		 * Method: test()
		 */
		
		Predicate<Character> predicate = letter -> Character.isUpperCase(letter);
		predicate.test('E');
		BiPredicate<String, String> biPredicate = (one, other) -> one.equals(other);
		biPredicate.test("He", "he");
		IntPredicate intPredicate = number -> number == 0;
		intPredicate.test(3);
		
		/* Supplier - receives nothing, returns data
		 * Interface: Supplier<T>
		 * Interface: IntSupplier LongSupplier DoubleSupplier BooleanSupplier
		 * Method: get()
		 */
		
		Supplier<String> supplier = () -> "\uD83D\uDC31";
		supplier.get();
		IntSupplier intSupplier = () -> (int) (Math.random() * 1000);
		intSupplier.getAsInt();
		
		/* Consumer - receives data, returns nothing
		 * Interface: Consumer<T> BiConsumer<T,U>
		 * Interface: IntConsumer LongConsumer DoubleConsumer
		 * Interface: ObjIntConsumer<T> ObjLongConsumer<T> ObjDoubleConsumer<T>
		 * Method: accept()
		 */
		
		Consumer<String> consumer = string -> {
			System.out.println(string.toUpperCase());			
		};
		consumer.accept("java");
		BiConsumer<String, String> biConsumer = (one, other) -> {
			System.out.println(one + "." + other);
		};
		biConsumer.accept("Hello", "World");
		IntConsumer intConsumer = number -> {
			System.out.println(number + 10);
		};
		intConsumer.accept(20);
		ObjIntConsumer<String> objIntConsumer = (obj, number) -> {
			System.out.println(obj.repeat(number));
		};
		objIntConsumer.accept("Java", 2);
		
		/* Function - receives data, returns data
		 * Interface: Function<T,R> BiFunction<T,U,R>
		 * Interface: IntFunction<R> LongFunction<R> DoubleFunction<R>
		 * Interface: ToIntFunction<T> ToLongFunction<T> ToDoubleFunction<T> ...
		 * Interface: IntToDoubleFunction IntToLongFunction LongToIntFunction ...
		 * Interface: UnaryOperator<T> ~ Function<T,T>
		 * Interface: BinaryOperator<T> ~ BiFunction<T,T,T>
		 * Method: apply()
		 */
		Function<String, String> function = string -> string.repeat(2);
		function.apply("Java");
		BiFunction<Double, Double, Double> biFunction = (base, exponent) -> Math.pow(base, exponent);
		biFunction.apply(2.0, 8.0);
		IntFunction<Double> intFunction = exponent -> Math.pow(2, exponent); 
		intFunction.apply(10);
		ToIntFunction<String> toIntFunction = text -> text.length();
		toIntFunction.applyAsInt("Java");
		UnaryOperator<Double> unaryOperator = exponent -> Math.pow(2, exponent);
		unaryOperator.apply(10.0);
		BinaryOperator<Double> binaryOperator = (base, exponent) -> Math.pow(base, exponent);
		binaryOperator.apply(2.0, 8.0);
		
		/* Runnable and Callable<V> */
		Runnable runnableTask = () -> System.out.println("Execute Runnable Task.");
		runnableTask.run();
		Callable<String> callableTask = () -> "Execute Callable Task.";
		try {
			System.out.println(callableTask.call());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
