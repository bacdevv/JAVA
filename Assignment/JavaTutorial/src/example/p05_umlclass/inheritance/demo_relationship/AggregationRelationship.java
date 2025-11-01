package example.p05_umlclass.inheritance.demo_relationship;

import java.util.Arrays;

public class AggregationRelationship {
	private ObjectClass[] list;  // Association
	private int size = 0;
	
	public AggregationRelationship() {
		this(10);
	}
	
	public AggregationRelationship(int capacity) {
		this.list = new ObjectClass[capacity];
	}
	
	public int getSize() {
		return size;
	}
	
	public ObjectClass[] getList() {
		return Arrays.copyOf(list, size);
	}
	
	public ObjectClass add(ObjectClass obj) {  // Aggregation
		if(obj == null) {
			return obj;
		}
		if (list.length == size) {
			list = Arrays.copyOf(list, size * 2);
		}
		list[size++] = obj;
		return obj;
	}

}
