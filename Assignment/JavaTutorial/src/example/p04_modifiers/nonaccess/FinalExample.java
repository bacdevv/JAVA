package example.p04_modifiers.nonaccess;

public class FinalExample {
	// Constant in class scope
	final int cc1 = 1;
	final int cc2;	// ***initialization in constructors
	// Constant of class
	static final int cs1 = 1;
	static final int cs2;
	static {
		cs2 = 2;
	}
	
	public FinalExample() {
		this.cc2 = 5;
	}
	
	public static void main(String[] args) {
		// Constant in method scope (local)
		final int cm1 = 10;
		final int cm2;
//		cm1 = 50; // Error
		cm2 = 20;
		
		System.out.println("Declare and initialize in local scope: " 
				+ cm1);
		System.out.println("Declare, then initialize in local scope: "
				+ cm2);
		System.out.println("Declare and initialize constant in class scope, "
				+ "attribute of the instance: "
				+ (new FinalExample().cc1));
		System.out.println("Declare in class scope, "
				+ "then initialize in Constructors: "
				+ (new FinalExample().cc2));
		System.out.println("Declare and initialize in class scope, "
				+ "attribute of the class: "
				+ FinalExample.cs1);
		System.out.println("Declare in class scope, " 
				+ "then initialize in static block, "
				+ "attribute of the class: "
				+ FinalExample.cs2);
	
	}
}
