package example.p07_functions;

public class JavaBasicFunctionExample {
	
	static void displayMessage(String msg) {
		System.out.println(msg);
	}
	
	public static void main(String[] args) {
		displayMessage("Greetings from my Function");
		System.out.println(add(2, 3));
		System.out.println(add(2, 3, 4));
		System.out.println(add(2, 3, 4, 5, 6, 7));
		System.out.println(addPlus(2l, 3.5, 4.5f, 5, 0b101));
	}
	
	static int add(int operand1, int operand2) {
		return operand1 + operand2;
	}
	
	static int add(int operand1, int operand2, int operand3) {
		return operand1 + operand2 + operand3;
	}
	
	static int add(int... operands) {
		int sum = 0;
		for (int i : operands) {
			sum += i;
		}
		return sum;
	}

	@SuppressWarnings("unchecked")
	static <T extends Number> double addPlus(T... operands) {
		double sum = 0.0;
		for (T t : operands) {
			sum += t.doubleValue();
		}
		return sum;
	}

}
