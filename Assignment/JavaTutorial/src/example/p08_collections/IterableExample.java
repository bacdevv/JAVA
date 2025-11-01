package example.p08_collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class IterableExample {
	
	public static void main(String[] args) {
		
		/* interface Iterable<E>
		 * 
		 * iterator()
		 * forEach(Consumer<? super T> action)
		 * spliterator()
		 */
		
		String[] array = {"Hello", "Java", "and", "World"};

		// Iterable
		Iterable<String> iterable = Arrays.asList(array);
		for (String item : iterable) {
			System.out.print(item + " ");
		}
		System.out.println();
		
		iterable.forEach(item -> System.out.print(item + " "));
		System.out.println();
		
		// Iterator
		Iterator<String> iterator = iterable.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		
		try {
			System.out.println();
			System.out.println(iterator.next());
		} catch (NoSuchElementException e) {
			System.out.println(e.getMessage());
		}

	}

}
