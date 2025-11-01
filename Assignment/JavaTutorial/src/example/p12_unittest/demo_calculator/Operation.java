package example.p12_unittest.demo_calculator;

public enum Operation {
	
	SUM("+"),
	DIFFERENCE("-"),
	PRODUCT("*"),
	QUOTIENT("/");
	
	private String sign;
	
	private Operation(String sign) {
		this.sign = sign;
	}
	
	public double execute(double leftOperand, double rightOperand) {
		double result = 0.0;
		switch (sign) {
			case "+" -> { result = Calculator.sum(leftOperand, rightOperand); }
			case "-" -> { result = Calculator.difference(leftOperand, rightOperand); }
			case "*" -> { result = Calculator.product(leftOperand, rightOperand); }
			case "/" -> { result = Calculator.quotient(leftOperand, rightOperand); }
		}
		return result;
	}

	@Override
	public String toString() {
		return this.name() + " " + sign;
	}
}
