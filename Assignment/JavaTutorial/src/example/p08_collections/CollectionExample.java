package example.p08_collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings("unused")
public class CollectionExample {
	
	public static void main(String[] args) {
		/* Java Collection Framework
		 * + interface Iterable
		 * interface Collection extends Iterable
		 * interface List extends Collection
		 * interface Queue extends Collection
		 * interface Set extends Collection
		 * 
		 * + interface Map
		 */
		
		
		/* Common methods of SubIterable<E> of Collection<E>
		 * 
		 * + Immutable (Unmodifiable) Collections: List, Set, Map
		 * + Mutable Collections: Subclasses of List, Set, Map
		 * 
		 * size(): int
		 * isEmpty(): boolean
		 * contains(Object o): boolean
		 * containsAll(Collection<?> c): boolean
		 * toArray(): Object[]
		 * 
		 * add(E e): boolean
		 * addAll(Collection<? extends E> c): boolean
		 * remove(Object o): boolean
		 * removeAll(Collection<?> c): boolean
		 * retainAll(Collection<?> c): boolean
		 * clear(): void 
		 * removeIf(Predicate<? super E> filter): boolean
		 */
		
		// Immutable Collections
		Collection<String> list = List.of("hello", "Java", "and", "World");
		Collection<String> set = Set.of("hello", "Java", "and", "World");
		Map<String, Integer> map = Map.of("k1", 56, "k2", 23);
		
		list.forEach(e -> System.out.print(e + "\t"));
		System.out.println();
		
		set.forEach(e -> System.out.print(e + "\t"));
		
		map.forEach((k, v) -> System.out.print(k + ": " + v + "\t"));
		System.out.println();
	

		/* Static methods of Collections class
		 * binarySearch() sort() reverse() shuffle() rotate() swap()
		 * reverseOrder()
		 * max() min() frequency() indexOfSubList() lastIndexOfSubList()
		 * copy() fill()
		 * emptyList() emptySet() emptyMap()
		 * singletonList() singleton() singletonMap() 
		 * disjoint() nCopies()
		 * 
		 * unmodifiableCollection()
		 * unmodifiableList() unmodifiableSet() unmodifiableMap() ...
		 * synchronizedCollection()
		 * synchronizedList() synchronizedSet() synchronizedMap() ...
		 */
	
	}
	
}
