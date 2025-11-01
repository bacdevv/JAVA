package example.p01_operations;

public class ArithmeticExample {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		/* Primitive types */
		byte b = 0; // 1 Byte
		short s = 0; // 2 Byte
		int i = 0; // 4 Byte
		long l = 0l; // 8 Byte
		float f = 0.0f; // 4 Byte
		double d = 0.0; // 8 Byte
		char c = '\0'; // 2 Byte Unicode ~ UTF-16, example: '\u00A4'
		boolean bool = false; // 1 bit: true false
		
		/* Format string */
		int integer = 127;
		float realNumber = 123.456f;
		System.out.printf("%%d Decimal Integer: %d \n", integer);
		System.out.printf("%%x Hexadecimal Integer: %x \n", integer);
		System.out.printf("%%X Hexadecimal Integer: %X \n", integer);
		System.out.printf("%%o Octal Integer: %o \n", integer);
		System.out.printf("%%f Floating-point Number: %f \n", realNumber);
		System.out.printf("%%c Character: %c \n", '\u00A4');
		System.out.printf("%%b Boolean: %b \n", bool);
		System.out.printf("%%s String (Any type): %s \n", "Hello Java");
		System.out.printf("%%e Scientific Notation: %e \n", realNumber);
		System.out.printf("%%E Scientific Notation: %E \n", 1.23456e2);
		System.out.printf("%%n Line Feed (New Line)%n");
		
		System.out.println("--------------------");
		
		/* Format string - Custom */
		double number = 1234567.67890123;
		System.out.printf("[%.3f]%n", number);
		System.out.printf("[%20.3f]%n", number);
		System.out.printf("[%020.3f]%n", number);
		System.out.printf("[%+20.3f]%n", number);
		System.out.printf("[%+020.3f]%n", number);
		System.out.printf("[%-20.3f]%n", number);
		System.out.printf("[%-+20.3f]%n", number);
		
		System.out.println("--------------------");
		
		/* Basic Operation */	
		int numA = 7; 
		int numB = 3;
		
		// Arithmetic
		System.out.printf("Addtiton: %s + %s = %s %n", numA, numB, numA + numB);
		System.out.printf("Subtraction: %s - %s = %s %n", numA, numB, numA - numB);
		System.out.printf("Multiplication: %s * %s = %s %n", numA, numB, numA * numB);
		System.out.printf("Integer division: %s / %s = %s %n", numA, numB, numA / numB);
		System.out.printf("(True) Division: (float) %s / %s = %s %n", numA, numB, (float) numA / numB);
		System.out.printf("(True) Division: 1.0f * %s / %s = %s %n", numA, numB, 1.0f * numA / numB);
		// Division with signed remainder from dividend
		System.out.printf("Division with remainder: %s %% %s = %s %n", numA, numB, numA % numB);
		System.out.printf("Division with remainder: %s %% %s = %s %n", -numA, -numB, -numA % -numB);
		System.out.printf("Division with remainder: %s %% %s = %s %n", -numA, numB, -numA % numB);
		System.out.printf("Division with remainder: %s %% %s = %s %n", numA, -numB, numA % -numB);
		
		// ++ --
		// Assignment operator =
		// Augmented assignment operators += -= *= /= %= >>= <<= &= |= ^=
		
		// Logical
		boolean boolA = true;
		boolean boolB = false;
		System.out.printf("Logical and: %b && %b = %b %n", boolA, boolB, boolA && boolB);
		System.out.printf("Logical or: %b || %b = %b %n", boolA, boolB, boolA || boolB);
		System.out.printf("Logical not: !%b = %b %n", boolA, !boolA);
		
		// Ternary operator
		System.out.printf("Ternary: %s %n", true ? "Yes" : "No");
		
		// Comparsion: > < >= <= == !=
		boolean comparingResult = 6 > 7;
		
		System.out.println("--------------------");
		
		// Bitwise
		int num1 = 0b101; // 5 0x5 05
		int num2 = 0b100; // 4 0x4 04
		String binOfNum1 = Integer.toBinaryString(num1);
		String binOfNum2 = Integer.toBinaryString(num2);
		System.out.printf("Bitwise AND: %s & %s = %s %n",
				binOfNum1, binOfNum2, Integer.toBinaryString(num1 & num2));
		System.out.printf("Bitwise OR: %s | %s = %s %n",
				binOfNum1, binOfNum2, Integer.toBinaryString(num1 | num2));
		System.out.printf("Bitwise XOR: %s ^ %s = %s %n",
				binOfNum1, binOfNum2, Integer.toBinaryString(num1 ^ num2));
		System.out.printf("Bitwise NOT (Invert or Complement): ~%s = %s %n",
				binOfNum1, Integer.toBinaryString(~num1));
		System.out.printf("Left-shift: %s<<2 = %s %n",
				binOfNum1, Integer.toBinaryString(num1<<2)); // multiple (2^2)	
		System.out.printf("Right-shift: %s>>2 = %s %n",
				binOfNum1, Integer.toBinaryString(num1>>2)); // divide (2^2)	
		System.out.printf("Right-shift: %32s>>2  = %32s %n",
				Integer.toBinaryString(-num1), Integer.toBinaryString(-num1>>2));	
		System.out.printf("Right-shift: %32s>>>2 = %32s %n",
				Integer.toBinaryString(-num1), Integer.toBinaryString(-num1>>>2));	
		
	}

}
