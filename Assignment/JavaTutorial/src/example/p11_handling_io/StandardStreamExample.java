package example.p11_handling_io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class StandardStreamExample {
	
	public static void main(String[] args) {
		try (
				InputStream inputStream = new FileInputStream("data/output/log/in.txt");
				PrintStream outPrintStream = new PrintStream("data/output/log/out.txt", "UTF-8");
				PrintStream errPrintStream = new PrintStream("data/output/log/err.txt", "UTF-8");
				){
			System.setIn(inputStream);			
			System.setOut(outPrintStream);			
			System.setErr(errPrintStream);
			
			try (Scanner scanner = new Scanner(System.in, "UTF-8")) {
				while (scanner.hasNextLine()) {
					System.out.println(scanner.nextLine());
					System.err.println("Error Stream.");
				}
			}
			
			try {
				System.out.println(1/0);
			} catch (ArithmeticException e) {
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
