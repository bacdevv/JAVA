package example.p11_handling_io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;

public class BasicFileExample {
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		// Windows Path: "C:\\eclipse-workspace\\JavaTutorial"
		// Linux Path: "home/eclipse-workspace/JavaTutorial"
		
		/* class java.io.File */
		
		// Create a new file
		File textFile = new File("info/data/Text3.txt");
		try {
			System.out.println(textFile.createNewFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Create a new directory
		File directory = new File("info/data", "sub1");
		System.out.println(directory.mkdir());
		
		// Create directory with sub-directories recursively
		File directories = new File("info/data", "sub2/child");
		System.out.println(directories.mkdirs());
		
		// Rename or Move a file or directory
		System.out.println(directories.renameTo(new File("info/data/sub1/child")));
		
		
		/* Instance Methods of class java.io.File to get Information */

		System.out.println();
		System.out.println("Working directory: " + System.getProperty("user.dir"));  
		
		File[] files = {
				new File("Text0.txt"),
				new File("src/example/p11_handling_io/Text1.txt"),
				new File("info/data/Text2.txt"),
				new File("info")
		};
		
		for (File file : files) {
			System.out.println("\nFilename: " + file.getName());
			System.out.println("Path: " + file.getPath());
			System.out.println("Parent Path: " + file.getParent());
			System.out.println("Absolute Path: " + file.getAbsolutePath());
			try {
				System.out.println("Canonical Path: " + file.getCanonicalPath());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Check is absolute path: " + file.isAbsolute());
			System.out.println("Check is directory: " + file.isDirectory());
			System.out.println("Check is file: " + file.isFile());
			System.out.println("Check is hidden: " + file.isHidden());
			System.out.println("Check exists: " + file.exists());
			System.out.println("Check is readable: " + file.canRead());
			System.out.println("Check is writable: " + file.canWrite());
			System.out.println("Check is executable: " + file.canExecute());
			System.out.println("Size: " + file.length() + " byte(s)");
			
			System.out.println("Last Modified: " + Instant
					.ofEpochMilli(file.lastModified())
					.atZone(ZoneId.systemDefault())
					.toLocalDateTime()
					.format(DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy")));
			
			System.out.println("Array of names of files and directories: " + Arrays.toString(file.list()));
			System.out.println("Array of paths of files and directories: " + Arrays.toString(file.listFiles()));
		}
		
		/* class java.nio.file.Paths
		 * interface java.nio.file.Path
		 */
		
		String path = "info/data/Text3.txt";
		Path p1 = Paths.get(path);
		Path p1c = Paths.get("info", "data", "Text3.txt");
		Path p2 = Path.of(path);
		Path p2c = Path.of("info", "data", "Text3.txt");
		
		System.out.println(p1.getParent());
		
		
		/* class java.nio.Files */
		try {
			Path p3 = Files.createFile(Path.of("info/data/Text4.txt"));
			Path p4 = Files.createDirectory(Path.of("info/data/sub4"));
			Path p5 = Files.createDirectories(Path.of("info/data/sub5/sub6"));
			Files.copy(p4, p5, StandardCopyOption.REPLACE_EXISTING);
			Files.move(p3, Path.of("info/data/NewText4.txt")); // Move or rename
			Files.delete(p5);
			// ***Recursive delete
			Files.walk(p5)
				.sorted(Comparator.reverseOrder())
				.map(Path::toFile)
				.forEach(File::delete);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
