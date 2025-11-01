package example.p07_functions;

interface IRunnable {
	
	double execute(double left, double right);
	
}

interface IExecutable {
	
	void run1();
	
	void run2();
	
	default void display() {
		System.out.println("Display");
	}
	
}

public class AnonymousClassExample {
	
	public static void main(String[] args) {
		IRunnable sum = new IRunnable() {
			
			@Override
			public double execute(double left, double right) {
				return left + right;
			}
		};
		
		System.out.println(sum.execute(1.1, 2.2));
		
		IExecutable iExecutable = new IExecutable() {
			
			@Override
			public void run2() {
				System.out.println("Run 2");
			}
			
			@Override
			public void run1() {
				System.out.println("Run 1");		
			}
			
		};
		
		iExecutable.display();
		iExecutable.run1();
		iExecutable.run2();		
		
	}

}
