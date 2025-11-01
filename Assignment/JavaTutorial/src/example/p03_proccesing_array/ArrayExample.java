package example.p03_proccesing_array;

import java.util.Arrays;
import java.util.Comparator;

class DemoClass implements Comparable<Object> {
	
	private double value;

	public DemoClass(double value) {
		this.value = value;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return String.format("%d", (int) (value * 1e6));
	}

	@Override
	public int compareTo(Object o) {
		return Double.compare(this.value, ((DemoClass) o).value);
	}
	
}


public class ArrayExample {
	
	public static void main(String[] args) {
		/* Initialize */
		int[] intArray1 = {10, 20, 30, 40, 50};
		int[] intArray2 = new int[5];
		
		Integer[] integers1 = {10, 20, 30, 40, 50};
		Integer[] integers2 = new Integer[intArray1.length];
		for (int i = 0; i < integers2.length; i++) {
			integers2[i] = intArray1[i];
		}

		/* Browse */
		for (int i = 0; i < intArray1.length; i++) {
			System.out.println(intArray1[i]);
		}
		
		for (int i : intArray2) {
			System.out.println(i);
		}
		
		Arrays.asList(intArray1).forEach(i -> System.out.println(i));
		
		Arrays.asList(integers1).forEach(i -> {
			i++;
			System.out.println(i);
		});
		
		System.out.println(Arrays.toString(intArray1));
		
		/* Clone */
		System.out.println("Resize - Arrays.copyOf() : " 
				+ Arrays.toString(Arrays.copyOf(integers1, 10)));
		System.out.println("Resize - Arrays.copyOf() : "
				+ Arrays.toString(Arrays.copyOf(integers1, 3)));
		System.out.println("Copy - Arrays.copyOfRange() : "
				+ Arrays.toString(Arrays.copyOfRange(integers1, 3, 10)));
		
		Integer[] integers3 = new Integer[5];
		Integer filler = 10;
		Arrays.fill(integers3, filler);
		System.out.println("Fill : " + Arrays.toString(integers3));
		
		Arrays.setAll(integers3, index -> index + 2);
		System.out.println("Range [0+2; 5+2) : " + Arrays.toString(integers3));
		
		Arrays.setAll(integers3, index -> (int) (index + 10 * Math.random()));
		System.out.println("Random Range : " + Arrays.toString(integers3));
		
		System.out.println("--------------------");
		
		/* Sort + Search */
		Integer[] numbers = {64, 25, 12, 22, 11};
		System.out.println("Number array : " + Arrays.toString(numbers));
		Arrays.sort(numbers);
		System.out.println("Quicksort - Arrays.sort() - Ascending : " + Arrays.toString(numbers));
		System.out.println("Key = " + 12 + " at index = " + Arrays.binarySearch(numbers, 12));
		System.out.println("Key = " + 60 + " at index = " + Arrays.binarySearch(numbers, 60));
		
		Arrays.sort(numbers, Comparator.reverseOrder());
		System.out.println("Quicksort - Arrays.sort() - Descending : " + Arrays.toString(numbers));
		System.out.println("Key = " + 12 + " at index = " + Arrays.binarySearch(numbers, 12, Comparator.reverseOrder()));
		System.out.println("Key = " + 60 + " at index = " + Arrays.binarySearch(numbers, 60, Comparator.reverseOrder()));
		
		DemoClass[] list = new DemoClass[10];
		for (int i = 0; i < list.length; i++) {
			list[i] = new DemoClass(Math.random());
		}

		System.out.println(Arrays.toString(list));
		Arrays.stream(list)
			.mapToDouble(DemoClass::getValue)
			.filter(d -> d > 0)
			.findFirst()
			.orElse(0);
	}
}
