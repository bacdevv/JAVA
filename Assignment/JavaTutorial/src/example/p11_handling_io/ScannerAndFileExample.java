package example.p11_handling_io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerAndFileExample {
	
	public static void main(String[] args) {
		try (
				Scanner scanner = new Scanner(new File("data/input/text1.txt"));
				){
			while (scanner.hasNextLine()) {
				System.out.println(scanner.nextLine());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
