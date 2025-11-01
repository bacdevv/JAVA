package example.p09_handling_exceptions;

@SuppressWarnings("serial")
abstract class AgeException extends Exception {
	
	public AgeException() {
		super();
	}

	public AgeException(String message) {
		super(message);
	}
	
}

@SuppressWarnings("serial")
class TooYoungException extends AgeException {
	
	public TooYoungException() {
		super();
	}
	
	public TooYoungException(String message) {
		super(message);
	}
	
}

@SuppressWarnings("serial")
class TooOldException extends AgeException {
	
	public TooOldException() {
		super();
	}
	
	public TooOldException(String message) {
		super(message);
	}
	
}

class Age {
	
	public static void checkAge(int age) 
			throws TooYoungException, TooOldException {
		if (age < 18) {
			throw new TooYoungException(age + " year(s) old is too young");
		} else if (age > 36) {
			throw new TooOldException(age + " years old is too old");
		}
		System.out.println(age + " years old is OK");
	}
	
	public static AgeException checkAge(int age, boolean throwable)
			throws AgeException {
		AgeException tooYoungException = new TooYoungException(age + " year(s) old is too young");
		AgeException tooOldException = new TooOldException(age + " years old is too old");
		if (age < 18) {
			if (throwable) {
				throw tooYoungException;
			}
			return tooYoungException;
		} else if (age > 36) {
			if (throwable) {
				throw tooOldException;
			}
			return tooOldException;
		}
		System.out.println(age + " years old is OK");
		return null;
	}
	
}

public class AdvancedExceptionExample {
	
	public static void main(String[] args) {
		/* Checked exception extended from Exception class
		 * Unchecked exception extended from RuntimeException class
		 */

		int age = 40;
		useTryCatchByMethod1(age);
		useTryCatchByMethod2(age);
		useTryCatchByMethod3(age);
		
		try {
			AgeException ageException = Age.checkAge(age, false);
			System.out.println(ageException);
		} catch (AgeException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public static void useTryCatchByMethod1(int age) {
		try {
			Age.checkAge(age);
		} catch (TooYoungException e) {
			System.out.println(e.getClass().getName() + " : " + e.getMessage());
		} catch (TooOldException e) {
			System.out.println(e.getClass().getName() + " : " + e.getMessage());
		}
	}

	public static void useTryCatchByMethod2(int age) {
		try {
			Age.checkAge(age);
		} catch (TooYoungException | TooOldException e) {
			System.out.println(e.getClass().getName() + " : " + e.getMessage());
		}
	}
	
	public static void useTryCatchByMethod3(int age) {
		try {
			Age.checkAge(age);
		} catch (AgeException e) {
			System.out.println(e.getClass().getName() + " : " + e.getMessage());
		}
	}
}
