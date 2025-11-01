package example.p02_proccesing_string;

public class MutableStringExample {

	public static void main(String[] args) {
		/*StringBuilder class - Asynchronous */
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Hello");
		stringBuilder.append(" ");
		stringBuilder.append("World");
		stringBuilder.insert(5, "++");
		stringBuilder.delete(0, 2); // [0;2)
		
		System.out.println(stringBuilder);
		
		/* StringBuffer class- Synchronous */
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("Hello");
		stringBuffer.append(" ");
		stringBuffer.append("World");
		stringBuffer.insert(5, "--");
		stringBuffer.delete(stringBuffer.length() - 2, stringBuffer.length() - 0); // [n-2;n-0)
		
		System.out.println(stringBuffer);
		
	}

}
