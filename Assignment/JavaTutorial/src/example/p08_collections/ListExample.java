package example.p08_collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

@SuppressWarnings("unused")
public class ListExample {
	
	public static void main(String[] args) {

		/* interface List<E>: ordered
		 * ArrayList<E> : unsynchronized 
		 * LinkedList<E> : unsynchronized 
		 * Vector<E> : synchronized
		 * Stack<E> : synchronized
		 */
		
		/* 
		 * boolean add(E e)
		 * boolean addAll(Collection<? extends E> c)
		 * void clear()
		 * boolean contains(Object o)
		 * boolean isEmpty()
		 * int size()
		 * int capacity()
		 * boolean remove(Object o)
		 * Collection<? extends E> clone()
		 *
		 * E get(int index)
		 * E set(int index, E element)
		 * void add(int index, E element)
		 * E remove(int index)
		 * int indexOf(Object o)
		 * int lastIndexOf(Object o)
		 * E pop()
		 * E poll()
		 * E peek()
		 * E element()
		 * 
		 * List<E> subList(int fromIndex, int toIndex)
		 * ListIterator<E> listIterator()
		 */
		
		
		/* ArrayList class
		 * 
		 * Structure: Dynamic Array
		 */
		
		System.out.println("Array " + "-".repeat(30));
		
		ArrayList<String> arrayList1 = new ArrayList<>(); // Empty
		ArrayList<String> arrayList2 = new ArrayList<>(10); // Capacity = 10
		ArrayList<String> arrayList3 = new ArrayList<>(List.of("Hello", "JAVA", "and", "world"));
		ArrayList<String> arrayList4 = new ArrayList<>() {
			{
				add("Hello");
				add("JAVA");
				add("and");
				add("world");
			}
		};
		ArrayList<String> arrayList5 = new ArrayList<>(Collections.nCopies(12, "Java")); // Default value
		
		System.out.println(arrayList3);
		System.out.println(arrayList3.size());
		System.out.println(arrayList3.get(2));
		System.out.println(arrayList3.set(2,"***"));
		arrayList3.add(2, "+++");
		System.out.println(arrayList3);
		
		
		/* Vector class
		 * 
		 * Structure: Dynamic Array 
		 */
		
		System.out.println("\nVector " +  "-".repeat(30));
		
		Vector<String> vector1 = new Vector<>(); // Empty
		Vector<String> vector2 = new Vector<>(15); // Capacity = 15, Default 10
		Vector<String> vector3 = new Vector<>(List.of("Hello", "JAVA", "and", "world"));
		Vector<String> vector4 = new Vector<>() {
			{
				add("Hello");
				add("JAVA");
				add("and");
				add("world");
			}
		};
		
		Vector<String> vector5 = new Vector<>(Collections.nCopies(12, "Java")); // Default value
		System.out.println(vector5);
		System.out.println(vector5.capacity());	
		System.out.println(vector5.size());
		System.out.println(vector5.get(2));
		System.out.println(vector5.set(2,"***"));
		vector5.add(2, "+++"); // Capacity * 2
		System.out.println(vector5.capacity());
		System.out.println(vector5);
		
		
		/* Stack class
		 * extends Vector
		 * 
		 * Structure: LIFO (Last-In-First-Out)
		 */
		
		System.out.println("\nStack" + "-".repeat(30));
		
		Stack<String> stack1 = new Stack<>(); // Empty, Default Capacity = 10
		Stack<String> stack2 = new Stack<>() {
			{
				add("Hello");
				add("JAVA");
				add("and");
				add("world");
			}
		};
		System.out.println(stack1);
		System.out.println(stack2);
		System.out.println(stack1.capacity());		
		System.out.println(stack1.size());
		System.out.println(stack1.push("111"));
		System.out.println(stack1.push("222"));
		System.out.println(stack1.push("333"));
		System.out.println(stack1.size());
		System.out.println(stack1.peek());
		System.out.println(stack1.size());
		System.out.println(stack1.pop());
		System.out.println(stack1.size());
		System.out.println(stack1.search("222"));
		
		
		/* LinkedList class 
		 * 
		 * Structure: Doubly-Linked List 
		 */
		
		System.out.println("\nLinkedList " + "-".repeat(30));
		
		LinkedList<String> linkedList1 = new LinkedList<>(); // Empty
		LinkedList<String> linkedList2 = new LinkedList<>(List.of("Hello", "JAVA", "and", "world"));
		LinkedList<String> linkedList3 = new LinkedList<>() {
			{
				add("Hello");
				add("JAVA");
				add("and");
				add("world");
			}
		};
		LinkedList<String> linkedList4 = new LinkedList<>(Collections.nCopies(12, "Java")); // Default value
		System.out.println(linkedList2);
		linkedList2.addFirst("@");
		System.out.println(linkedList2);
		linkedList2.addLast("=");
		System.out.println(linkedList2);
		System.out.println(linkedList2.size());
		
	}

}
