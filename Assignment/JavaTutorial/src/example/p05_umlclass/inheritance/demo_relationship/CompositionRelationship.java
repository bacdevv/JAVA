package example.p05_umlclass.inheritance.demo_relationship;

import java.util.Arrays;

public class CompositionRelationship {
	@SuppressWarnings("unused")
	private ObjectClass object;
	private ObjectClass[] list;  // Association
	private int size = 0;
	
	public CompositionRelationship() {
		this(10);
	}
	
	public CompositionRelationship(int capacity) {
		this.object = new ObjectClass(capacity);	// Composition
		this.list = new ObjectClass[capacity];
	}
	
	public int getSize() {
		return size;
	}
	
	public ObjectClass[] getList() {
		return Arrays.copyOf(list, size);
	}
	
	public ObjectClass add(int value) {
		ObjectClass obj = new ObjectClass(value);	// Composition

		if (list.length == size) {
			list = Arrays.copyOf(list, size * 2);
		}
		
		list[size++] = obj;
		
		return obj;
	}
}
