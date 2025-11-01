package example.p12_unittest.demo_calculator;

public class Calculator {
	
	private double leftOperand;
	
	public Calculator(double leftOperand) {
		this.leftOperand = leftOperand;
	}
	
	public double add(double rightOperand) {
		return leftOperand + rightOperand;
	}
	
	public double subtract(double rightOperand) {
		return leftOperand - rightOperand;
	}
	
	public double multiple(double rightOperand) {
		return leftOperand * rightOperand;
	}
	
	public double divide(double rightOperand) {
		String msg = "Divisor must be different from 0";
		if (rightOperand == 0) {
			throw new IllegalArgumentException(msg);
		}
		return leftOperand / rightOperand;
	}
	
	public static double sum(double leftOperand, double rightOperand) {
		return leftOperand + rightOperand;
	}
	
	public static double difference(double leftOperand, double rightOperand) {
		return leftOperand - rightOperand;
	}
	
	public static double product(double leftOperand, double rightOperand) {
		return leftOperand * rightOperand;
	}
	
	public static double quotient(double leftOperand, double rightOperand) {
		String msg = "Divisor must be different from 0";
		if (rightOperand == 0) {
			throw new IllegalArgumentException(msg);
		}
		return leftOperand / rightOperand;
	}

}
