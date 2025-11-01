package example.p12_unittest.demo_calculator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class CalculatorTest {
	
	@BeforeAll
	static void setUpBeforeClass() {
		System.out.println("#Begin# Run before all tests");
	}
	
	@AfterAll
	static void tearDownAfterClass() {
		System.out.println("#End# Run after all tests");
	}
	
	@BeforeEach
	void setUp() {
		System.out.println("+ Run before each test");
	}
	
	@AfterEach
	void tearDown() {
		System.out.println("+ Run after each test");
	}
	
	@Test
	void firstTest() {
		assertEquals("", "");
	}
	
	@Test
	@DisplayName("Skipped test: @Disabled")
	@Disabled
	void skippedTest() {
		assertEquals("", "");
	}

	@Test
	@DisplayName("Equals test: assertEquals(expected, actual)")
	void equalsTest() {
		double actual = Calculator.sum(1.0, 0.5);
		double expected = 1.5;
		assertEquals(expected, actual);
	}
	
	@Test
	@DisplayName("Approximates test: assertEquals(expected, actual, delta)")
	void approximatesTest() {
		/* Handle floating point numbers with approximation
		 * + Default precision of format specifier %f is 6 decimal places
		 * + Precision of double type is 15 decimal places
		 * + Precision of float type is 6 decimal places
		 */
		double actual = Calculator.sum(1.1, 2.2);
		double expected = 3.3;
		double delta = 1e-15;
		assertEquals(expected, actual, delta);
 	}
	
	@Test
	@DisplayName("Not equals test: assertNotEquals(unexpected, actual)")
	void notEqualsTest() {
		double actual = Calculator.sum(1.1, 2.2);
		double unexpected = 3.3;
		assertNotEquals(unexpected, actual);
	}
	
	@Test
	@DisplayName("True test: assertTrue(condition)")
	void trueTest() {
		boolean condition = 1.1 + 2.2 != 3.3;	
		assertTrue(condition);		
	}
	
	@Test
	@DisplayName("False test: assertFalse(condition)")
	void falseTest() {
		boolean condition = 1.1 + 2.2 == 3.3;	
		assertFalse(condition);
	}
	
	@Test
	@DisplayName("*** Assume True test: Assumptions.assumeTrue(condition)")
	void assumeTrueTest() {
		boolean condition = 1.1 + 2.2 == 3.3;
		Assumptions.assumeTrue(condition); // Skipped if test fails
	}
	
	
	@Test
	@DisplayName("Same object test: assertSame(expected, actual)")
	void sameObjectTest() {
		String actual = "Hello";
		String expected = "Hello";
		assertSame(expected, actual);
	}
	
	@Test
	@DisplayName("Not same object test: assertNotSame(expected, actual)")
	void notSameObjectTest() {
		String actual = "Hello";
		String expected = new String("Hello");
		assertNotSame(expected, actual);
	}
	
	@Test
	@DisplayName("Null test: assertNull(actual)")
	void nullTest() {
		String actual = null;
		assertNull(actual);
	}
	
	@Test
	@DisplayName("Not null test: assertNotNull(actual)")
	void notNullTest() {
		String actual = "";
		assertNotNull(actual);
	}
	
	@Test
	@DisplayName("Array equality test: assertArrayEquals(expected, actual)")
	void arrayEqualityTest() {
		String[] actual = {"Hello", "World"};
		String[] expected = {new String("Hello"), "World"};
		assertArrayEquals(expected, actual);
	}
	
	@Test
	@DisplayName("Exception test 1: assertThrows(expectedType, executable)")
	void exceptionTest1() {
		/* Test throws correct exception class */
		Class<? extends Throwable> expectedType = IllegalArgumentException.class;
		Executable executable = () -> Calculator.quotient(1, 0);
		assertThrows(expectedType, executable);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	@DisplayName("Exception test 2: Class.forName() + assertThrows()")
	void exceptionTest2() {
		/* Test throws correct exception name (String type) */
		try {
			String className = "java.lang.IllegalArgumentException";
			Class<? extends Throwable> expectedType = (Class<? extends Throwable>) Class.forName(className);
			Executable executable = () -> Calculator.quotient(1, 0);
			assertThrows(expectedType, executable);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	@DisplayName("Exception test 3: assertThrows() + assertEquals()")
	void exceptionTest3() {
		/* Test throws correct exception class with message */
		Class<? extends Throwable> expectedType = IllegalArgumentException.class;
		Executable executable = () -> Calculator.quotient(1, 0);
		String actualMessage = "Divisor must be different from 0";
		Exception exception = (Exception) assertThrows(expectedType, executable);
		assertEquals(exception.getMessage(), actualMessage);
	}
	
	@Test
	@DisplayName("Exception test 4: assertDoesNotThrow(executable)")
	void exceptionTest4() {
		/* Test does not throw exception class */
		Executable executable = () -> Calculator.quotient(1, 0.1);
		assertDoesNotThrow(executable);
	}
	
	/***************************************************************/
	
	@ParameterizedTest
	@DisplayName("Parameterized test: @ValueSource")
	@ValueSource(strings = {"Hello", "world", "and", "Java"})
	void parameterizedTest_ValueSource(String input) {
		/* chars booleans bytes shorts ints longs floats doubles strings  */
		
		// the starting character is capitalized
		boolean test = Character.isUpperCase(input.charAt(0));
		assertTrue(test);
	}
	
	@ParameterizedTest
	@DisplayName("Parameterized test: @EnumSource")
	@EnumSource(value = Operation.class, names = {"SUM", "PRODUCT"})
	void parameterizedTest_EnumSource(Operation operation) {
		double leftOperand = 5;
		double rightOperand = 2;
		
		double actual = operation.execute(leftOperand, rightOperand);
		double expected = 0.0;
		switch (operation) {
			case SUM -> {expected = leftOperand + rightOperand;}
			case DIFFERENCE -> {expected = leftOperand - rightOperand;}
			case PRODUCT -> {expected = leftOperand * rightOperand;}
			case QUOTIENT -> {expected = leftOperand / rightOperand;}
		}
		assertEquals(actual, expected);
	}
	
	@ParameterizedTest
	@DisplayName("Parameterized test: @CsvSource")
	@CsvSource({
		// left, right, expected(sum)
		"1.5, 1.5, 3",
		"1.5, 1, 2.5",
		"1.5, 1, 2"
	})
	void parameterizedTest_CsvSource(double left, double right, double expected) {
		double actual = Calculator.sum(left, right);
		assertEquals(expected, actual);
	}
	
	@ParameterizedTest
	@DisplayName("Parameterized test: @CsvSource + ArgumentKey")
	@CsvSource(value = {
		"1;true;Hello",
		"2;false;",
		"3;true;''",
		"4;false;NULL"
	}, 
		delimiter = ';',	// Default comma character
		nullValues = {"NULL","null","NUL","Null"},	// Default (omitted) + "NULL" -> null
		emptyValue = "EMPTY_STRING"	// (empty string '') -> "EMPTY_STRING"
	)
	void parameterizedTest_CsvSourceArgmentKey(int order, boolean checked, String text) {
		System.out.printf("%02d. [%s] %s\n",
				order,
				checked,
				text == null ? text : ("\"" + text + "\""));
	}
	
	@ParameterizedTest
	@DisplayName("Parameterized test: @CsvFileSource")
	@CsvFileSource(resources = "testcases.csv", delimiter = '|', numLinesToSkip = 1)
	void parameterizedTest_CsvFileSource(double left, double right, double expected) {
		assertEquals(expected, Calculator.sum(left, right));
	}
	
	/***************************************************************/
	
	static Stream<Arguments> provider() {
	    return Stream.of(
	        Arguments.of(1.5, 1.5, 3),
	        Arguments.of(1.5, 1, 5),
	        Arguments.of(1.5, 1, 2.5)
	    );
	}
	
	@ParameterizedTest
	@DisplayName("Parameterized test: @MethodSource") 
	@MethodSource("provider")
	void parameterizedTest_MethodSource(double left, double right, double expected) {
		assertEquals(expected, Calculator.sum(left, right));
	}

}
