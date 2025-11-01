package example.p09_handling_exceptions;


public class SimpleExceptionExample {
	public static void main(String[] args) {
		/* Throwable includes Error and Exception
		 * Checked ~ All except Unchecked class ~ must use try/catch or throws
		 * Unchecked ~ Error and RuntimeException
		 * Keyword throw: throw an exception
		 * Keyword throws: require checking for exceptions, using try/catch
		 */
		
		try {
			int a = 1 / 0;
			System.out.println(a);
		} catch (ArithmeticException e) {
			System.out.println("Exception Name: " + e.getClass().getName());
			System.out.println("Message: " + e.getMessage());
		} finally {
			System.out.println("Finally: Always execute at the end of the try block");
		}
		
		
	}
}
