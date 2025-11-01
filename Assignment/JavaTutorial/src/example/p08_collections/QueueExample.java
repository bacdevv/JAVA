package example.p08_collections;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

@SuppressWarnings("unused")
public class QueueExample {
	
	public static void main(String[] args) {
		/* interface Queue<E>: ordered
		 * class PriorityQueue<E>
		 * + Mechanism: FIFO, Natural order (Ascending) or Comparator, Not contain null
		 * 
		 * class LinkedList<E>
		 * + Mechanism: FIFO, Insertion order
		 * 
		 * interface Deque<E>
		 * class ArrayDeque<E>
		 * + Mechanism: Double-Ended Queue, Insertion order, Not contain null
		 */		
		
		/* 
		 * boolean offer(E e): Add an element, if failure return false.
		 * E poll(): Get and remove the first element, if failure return null.
		 * E peek(): Get the first element, if failure return null.
		 * 
		 * offerFirst() offerLast()
		 * pollFirst() pollLast()
		 * peekFirst() peekLast()
		 */
		
		/* PriorityQueue class */
		Queue<String> queue1 = new PriorityQueue<>();
		Queue<String> queue2 = new PriorityQueue<>(11); // Default capacity = 11
		Queue<String> queue3 = new PriorityQueue<>(List.of("Hello", "java", "And", "world"));
		Queue<String> queue4 = new PriorityQueue<>() {
			{
				add("Hello");
				add("java");
				add("And");
				add("world");
			}
		};
		Queue<String> queue5 = new PriorityQueue<>(Collections.nCopies(12, "Java")); // Default value
		Queue<String> queue6 = new PriorityQueue<>(Comparator.reverseOrder()); // Redefine the priority order through the Comparator interface
		
		System.out.println(queue3);
		queue6.addAll(queue3);
		System.out.println(queue6);
		
		queue3.offer("Core");
		System.out.println(queue3);
		System.out.println(queue3.size());
		System.out.println(queue3.element());
		System.out.println(queue3.size());
		System.out.println(queue3.poll());
		System.out.println(queue3.size());
		
		System.out.println("-".repeat(30));
		
		/* ArrayDeque class */
		Deque<String> deque1 = new ArrayDeque<>();
		Deque<String> deque2 = new ArrayDeque<>(16); // Default capacity = 16
		Deque<String> deque3 = new ArrayDeque<>(List.of("Hello", "java", "And", "world"));
		Deque<String> deque4 = new ArrayDeque<>() {
			{
				add("Hello");
				add("java");
				add("And");
				add("world");
			}
		};
		Deque<String> deque5 = new ArrayDeque<>(Collections.nCopies(12, "Java"));

		System.out.println(deque3);
		
		deque3.offer("Core");
		System.out.println(deque3);
		System.out.println(deque3.size());
		System.out.println(deque3.element());
		System.out.println(deque3.size());
		System.out.println(deque3.poll());
		System.out.println(deque3.size());
		
		
	}
	
}
