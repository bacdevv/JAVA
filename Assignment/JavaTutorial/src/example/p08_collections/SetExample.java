package example.p08_collections;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetExample {
	
	@SuppressWarnings({ "unused", "unchecked" })
	public static void main(String[] args) {
		
		/* interface Set<E>: non-duplicated
		 * HashSet<E>: unordered, based on HashMap
		 * LinkedHashSet<E>: ordered (insertion order), based on LinkedHashMap
		 * 
		 * interface SortedSet<E>: non-duplicated
		 * TreeSet<E>: ordered (natural order or Comparator)
		 * 
		 * ...
		 */
		
		/*
		 * boolean add(E e)
		 * boolean addAll(Collection<? extends E> c)
		 * void clear()
		 * boolean contains(Object o)
		 * boolean containsAll(Collection<?> c)
		 * boolean retainAll(Collection<?> c)
		 * boolean remove(Object o)
		 * boolean removeAll(Collection<?> c)
		 * boolean isEmpty()
		 * int size()
		 */
		
		
		/* HashSet class */
		
		System.out.println("HashSet " + "-".repeat(30));
		
		HashSet<String> hashSet1 = new HashSet<>(); // Default capacity = 16, Default Load factor = 0.75f
		HashSet<String> hashSet2 = new HashSet<>(20); // Set capacity
		HashSet<String> hashSet3 = new HashSet<>(20, 0.5f); // Set capacity and load factor
		HashSet<String> hashSet4 = new HashSet<>(Set.of("Hello", "JAVA", "and", "world"));
		HashSet<String> hashSet5 = new HashSet<>() {
			{
				add("Hello");
				add("JAVA");
				add("and");
				add("world");
			}
		};
		
		System.out.println(hashSet4);
		hashSet4.add("Core");
		hashSet4.add("Clone");
		System.out.println(hashSet4);
		hashSet4.remove("Clone");
		System.out.println("\n\nSet A = " + hashSet4);
		System.out.println("Set B = " + hashSet5);
		Set<String> clone = new HashSet<>();

		// Set Operations
		String element = "Hello";
		System.out.printf("\"%s\" is an element of Set A: %b\n", "Hello", hashSet4.contains("Hello"));
		
		System.out.printf("Set B is a subset of Set A: %b\n", hashSet4.containsAll(hashSet5));
		
		HashSet<String> hashSetClone = (HashSet<String>) hashSet4.clone();
		hashSetClone.addAll(hashSet5);
		System.out.println("Union A ∪ B: " + hashSetClone);
		
		hashSetClone = (HashSet<String>) hashSet4.clone();
		hashSetClone.retainAll(hashSet5);
		System.out.println("Intersection A ∩ B: " + hashSetClone);
		
		hashSetClone = (HashSet<String>) hashSet4.clone();
		hashSetClone.removeAll(hashSet5);
		System.out.println("Difference A − B: " + hashSetClone);
		
		hashSetClone = (HashSet<String>) hashSet4.clone();
		System.out.println("Equality A = B: " + hashSetClone.equals(hashSet5));
				
		/* LinkedHashSet class */
		
		System.out.println("\nLinkedHashSet " + "-".repeat(30));
		
		LinkedHashSet<String> linkedHashSet1 = new LinkedHashSet<>(); // Default capacity = 16, Default Load factor = 0.75f
		LinkedHashSet<String> linkedHashSet2 = new LinkedHashSet<>(20); // Set capacity
		LinkedHashSet<String> linkedHashSet3 = new LinkedHashSet<>(20, 0.5f); // Set capacity and load factor
		LinkedHashSet<String> linkedHashSet4 = new LinkedHashSet<>(Set.of("Hello", "JAVA", "and", "world"));
		LinkedHashSet<String> linkedHashSet5 = new LinkedHashSet<>() {
			{
				add("Hello");
				add("JAVA");
				add("and");
				add("world");
			}
		};
		
		System.out.println(linkedHashSet4);
		linkedHashSet4.add("Core");
		linkedHashSet4.add("Clone");
		System.out.println(linkedHashSet4);
		linkedHashSet4.remove("Clone");
		System.out.println(linkedHashSet4);
		
		
		/* TreeSet class
		 * 
		 * Get: E first() | E last()
		 * Get and remove: E pollFirst() | E pollLast()
		 * Get inclusively: E ceiling(E e) | E floor(E e)
		 * Get exclusively: E higher(E e) | E lower(E e)
		 * Get subset: SortedSet<E> subSet(E from, E to)
		 * 
		 * NavigableSet<E> descendingSet()
		 * Comparator<? super E> comparator()
		 */
		
		System.out.println("\nTreeSet " + "-".repeat(30));
		
		TreeSet<String> treeSet1 = new TreeSet<>(); // Default capacity = 16, Default Load factor = 0.75f
		TreeSet<String> treeSet2 = new TreeSet<>(Set.of("Hello", "java", "And", "world"));
		TreeSet<String> treeSet3 = new TreeSet<>() {
			{
				add("Hello");
				add("java");
				add("And");
				add("world");
			}
		};
		TreeSet<String> treeSet4 = new TreeSet<>(Comparator.reverseOrder());
		TreeSet<String> treeSet5 = (TreeSet<String>) treeSet2.descendingSet();
		
		System.out.println(treeSet2);
		System.out.println(treeSet5);
		treeSet5.addAll(Set.of("Core", "clone", "more"));
		System.out.println(treeSet5);
		System.out.println(treeSet5.first());
		System.out.println(treeSet5.last());
		System.out.println(treeSet5.ceiling("more"));
		System.out.println(treeSet5.floor("more"));
		System.out.println(treeSet5.higher("more"));
		System.out.println(treeSet5.lower("more"));
		System.out.println(treeSet5.subSet("more","Hello"));
		System.out.println(treeSet5.subSet("more",true,"Hello",false));
		System.out.println(treeSet5.subSet("more",false,"Hello",true));
		
	}

}
