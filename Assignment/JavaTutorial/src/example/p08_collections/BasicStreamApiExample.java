package example.p08_collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

@SuppressWarnings("unused")
public class BasicStreamApiExample {
	
	public static void main(String[] args) {
		
		/* Stream API
		 * A stream is a stream of data elements that supports aggregate functions.
		 * Stream does not store data and does not change the original data.
		 * 
		 * In streams, there are two main types of operations: intermediate and terminal operations.
		 * + Intermediate operation: Returns a new stream with LAZY mechanism.
		 * map() 
		 * filter()
		 * sorted()
		 * distinct()
		 * limit()
		 * skip()
		 * ...
		 * 
		 * + Terminal operation: Terminates the stream of processing and executes all intermediate operations.
		 * reduce()
		 * forEach()
		 * toArray()
		 * count()
		 * sum()
		 * average()
		 * max()
		 * min()
		 * findFirst() orElse() 
		 * collect()
		 * ...
		 * 
		 * Stream also supports processing data through parallel streams.
		 * .stream()
		 * .parallel() .parallelStream()
		 */
		
		/* Interface: Stream<T> IntStream LongStream DoubleStream
		 * + Static methods: 
		 * of(T… values)
		 * empty()
		 * ofNullable(T t)
		 * generate(Supplier<T> s): Create an infinite stream
		 * iterate(T seed, UnaryOperator<T> f): Create an infinite stream
		 * iterate(T seed, Predicate<T> hasNext, UnaryOperator<T> next): Create a finite stream
		 * concat(Stream a, Stream b)
		 * builder() add() build()
		 * 
		 * + Primitive streams: IntStream LongStream
		 * range(int startInclusive, int endExclusive)
		 * rangeClosed(int startInclusive, int endInclusive)
		 * 
		 * + Primitive streams: IntStream LongStream DoubleStream
		 * boxed(): Converts into Stream<Integer> Stream<Long> Stream<Double>
		 */
		
		// Create Streams
		int[] arr = {1, 4, 7, 3, 2, 4};
		IntStream intStream1 = IntStream.of(1, 4, 7, 3, 2, 4);
		IntStream intStream2 = Arrays.stream(arr);
		IntStream intStream3 = IntStream.range(0, 10);
		IntStream intStream4 = IntStream.generate((new Random())::nextInt).limit(5);
		IntStream intStream5 = IntStream.iterate(0, i -> i + 2).limit(5);
		IntStream intStream6 = IntStream.iterate(0, i -> i < 2 * 5, i -> i + 2);	
		
		System.out.println(intStream1.boxed().collect(Collectors.toList()));
		System.out.println(intStream2.boxed().collect(Collectors.toList()));
		System.out.println(intStream3.boxed().collect(Collectors.toList()));
		System.out.println(intStream4.boxed().collect(Collectors.toList()));
		System.out.println(intStream5.boxed().collect(Collectors.toList()));
		System.out.println(intStream6.boxed().collect(Collectors.toList()));
		
		Stream<Integer> stream1 = Stream.of(1, 4, 7, 3, 2, 4);
		Stream<Integer> stream2 = Stream.of(1, 4, 7, 3, 2, 4);
		Stream<Integer> stream3 = Stream.of(1, 4, 7, 3, 2, 4);
		Stream<Integer> stream4 = Stream.of(1, 4, 7, 3, 2, 4);
		Stream<Integer> stream5 = Stream.of(1, 4, 7, 3, 2, 4);
		Stream<Integer> stream6 = Stream.of(1, 4, 7, 3, 2, 4);
		Stream<Integer> stream7 = Stream.of(1, 4, 7, 3, 2, 4);
		Stream<Integer> stream8 = Stream.of(1, 4, 7, 3, 2, 4);
		Stream<Integer> stream9 = Stream.of(1, 4, 7, 3, 2, 4);
		Stream<Integer> stream10 = Stream.of(1, 4, 7, 3, 2, 4);
		Stream<Integer> stream11 = Stream.of(1, 4, 7, 3, 2, 4);

		System.out.print("\nMap:\t");
		stream1.map(n -> n * 2).forEach(n -> System.out.printf("%s\t", n));
		
		System.out.print("\nFilter:\t");
		stream2.filter(n -> n % 2 == 0).forEach(n -> System.out.printf("%s\t", n));
		
		System.out.print("\nDistinct:\t");
		stream3.distinct().forEach(n -> System.out.printf("%s\t", n));
		
		System.out.print("\nSorted Ascending:\t");
		stream4.sorted((n1, n2) -> n1 - n2).forEach(n -> System.out.printf("%s\t", n));
		
		System.out.print("\nSorted Descending:\t");
		stream5.sorted((n1, n2) -> n2 - n1).forEach(n -> System.out.printf("%s\t", n));
		
		System.out.println("\nCount: " + stream6.count());
		
		System.out.println("Reduce - Sum: " + stream7.reduce(0, (n1, n2) -> n1 + n2)); 
		
		System.out.println("Average: " + stream8.mapToInt(n -> n).average().getAsDouble());
		
		System.out.println("Min: " + stream9.min((o1, o2) -> o1 - o2).get());
		
		System.out.println("Max: " + stream10.max((o1, o2) -> o1 - o2).get());
		
		System.out.println("To Array: " + Arrays.toString(stream11.toArray(Integer[]::new)));
		
		// flatMap
		
		List<List<Integer>> list = Arrays.asList(
				Arrays.asList(1, 2),
				Arrays.asList(3, 4),
				Arrays.asList(5, 6),
				Arrays.asList(7, 8),
				Arrays.asList(9, 10)
				);
		
		Stream<List<Integer>> listStream1 = list.stream();
		System.out.print("\nStream of Lists: ");
		listStream1.forEach(i -> System.out.printf("%s ", i));
		
		Stream<List<Integer>> listStream2 = list.stream();
		System.out.print("\nStream of Streams - Map: ");
		listStream2.map(l -> l.stream()).forEach(i -> System.out.printf("%s ", i));
		
		Stream<List<Integer>> listStream3 = list.stream();
		System.out.print("\nStream of Integers - FlatMap: ");
		listStream3.flatMap(l -> l.stream()).forEach(i -> System.out.printf("%s ", i));
		
		
	}

}
