package example.p10_generics;

import java.util.ArrayList;
import java.util.List;

class GenericClass<T> {
	
	private T type;
	
	public GenericClass(T type) {
		this.type = type;
	}
	
	public T getType() {
		return type;
	}
	
	public void setType(T type) {
		this.type = type;
	}
	
	public <S> String concat(S s) {
		String text = String.valueOf(type);
		text += String.valueOf(s);
		return text;
	}
	
	@Override
	public String toString() {
		return String.valueOf(type);
	}
}


interface IDemo<T, U, R> {
	R get(T t, U u);
}

class GSum implements IDemo<Number, Number, Double> {

	@Override
	public Double get(Number t, Number u) {
		return t.doubleValue() + u.doubleValue();
	}
	
}


public class BasicGenericsExample {
	
	static <T> void print(T t) {
		System.out.println(t);
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		/* Generic
		 * 
		 * Generic Class/Interface/Method:
		 * class Demo<T>
		 * interface Demo<T>
		 * <T> void method(T value)
		 * 
		 * T type, K key, V value, E element, N number, ...
		 * <T> <T, U> <T, U, S> ...
		 * 
		 * <T extends Class & Interface1 & Interface2>
		 */
		
		print("Hello");
		print(2);
		
		GenericClass<Integer> g = new GenericClass<>(10);
		System.out.println(g);
		System.out.println(g.concat(2));
		System.out.println(g.concat("Java"));
		
		GSum gSum = new GSum();
		System.out.println(gSum.get(9.5, 1.5));

		
		/*
		 * Bounded Wildcard is a Parameterized Type
		 * 
		 * Unlimited wildcard: <?>
		 * Upper bounded wildcard - Producer: <? extends Class>
		 * Lower bounded wildcard - Consumer: <? super Class>
		 */
		
		List<?> list = new ArrayList<Integer>();
		list = new ArrayList<String>();		
		
		List<? extends Number> numbers = new ArrayList<Integer>();
		numbers = new ArrayList<Double>();
		
		List<? super Integer> integers = new ArrayList<Number>();
		integers = new ArrayList<Object>();
		
	}
	

}
