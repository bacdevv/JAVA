package example.p11_handling_io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.stream.Stream;

public class FileHandlerExample {
	
	public static void main(String[] args) {
		String mainPath = "data";
		String inputLocation = String.join("/", new String[]{mainPath, "input"});
		String outputLocation = String.join("/", new String[]{mainPath, "output"});
		
		/* 1. Read/write small text files */
		try (
				FileReader fileReader = new FileReader(inputLocation + "/text1.txt");
				FileWriter fileWriter = new FileWriter(outputLocation + "/copy1.txt");
				) {
			StringBuilder content = new StringBuilder();
			System.out.print("1. Chars:");
			int character = fileReader.read();
			while (character != -1) {
				// Write
				fileWriter.write(character);
				
				// Read
				System.out.print(" " + character);
				content.append((char) character);
				character = fileReader.read();
			}
			System.out.println("\n1. Number of characters/bytes: " + content.length());
			System.out.printf("1. Content:\n%s\n", content);
		} catch (FileNotFoundException e) {
			System.out.println("1. File do not exist.");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/* 2. Read/write large text files */

		try (
				BufferedReader bufferedReader = new BufferedReader(new FileReader(inputLocation + "/sample/plain-text-2mb.txt"));
				BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputLocation + "/sample/copy2.1-plain-text-2mb.txt"));
				) {
			StringBuilder content = new StringBuilder();
			String line = bufferedReader.readLine(); // Exclusive line-termination characters
			int count = 0;
			while (line != null) {
				// Write
				bufferedWriter.write(line);
				bufferedWriter.newLine();
				
				// Read
				count++;
				content.append(line);
				line = bufferedReader.readLine();
			}
			System.out.println("\n2.1 Number of Lines: " + count);
		} catch (FileNotFoundException e) {
			System.out.println("2.1 File do not exist.");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//
		
		try (
				BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(inputLocation + "/sample/plain-text-2mb.txt"), StandardCharsets.UTF_8);
				BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get(outputLocation + "/sample/copy2.2-plain-text-2mb.txt"), StandardCharsets.UTF_8);
				) {
			StringBuilder content = new StringBuilder();
			String line = bufferedReader.readLine(); // Exclusive line-termination characters
			int count = 0;
			while (line != null) {
				// Write
				bufferedWriter.write(line);
				bufferedWriter.newLine();
				
				// Read
				count++;
				content.append(line);
				line = bufferedReader.readLine();
			}
			System.out.println("\n2.2. Number of Lines: " + count);
		} catch (FileNotFoundException e) {
			System.out.println("2.2. File do not exist.");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//
		
		try (
				Stream<String> lines1 = Files.lines(Paths.get(inputLocation + "/sample/plain-text-2mb.txt"), StandardCharsets.UTF_8);
				Stream<String> lines2 = Files.lines(Paths.get(inputLocation + "/sample/plain-text-2mb.txt"), StandardCharsets.UTF_8)
				) {
		    long numLines = lines1.count();
		    long numNonEmptyLines = lines2.filter(line -> !line.isEmpty()).count();
		    System.out.println("\n2.3. Number of Lines: " + numLines);
		    System.out.println("2.3. Number of Non-Empty Lines: " + numNonEmptyLines);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//
		
		try (
				Stream<String> lines = Files.lines(Paths.get(inputLocation + "/sample/plain-text-2mb.txt"), StandardCharsets.UTF_8);
				BufferedWriter bufferedWriter = Files.newBufferedWriter(Paths.get(outputLocation + "/sample/copy2.4-plain-text-2mb.txt"), StandardCharsets.UTF_8);
				) {

		    System.out.println("\n2.4. Write  a Stream");
		    lines.filter(line -> !line.isEmpty())
		    	.forEach(line -> {
			    	try {
						bufferedWriter.write(String.valueOf(line.length()));
						bufferedWriter.write("\t");
						bufferedWriter.write(line);
						bufferedWriter.newLine();
					} catch (IOException e) {
						e.printStackTrace();
					}		    	
		    });
		    
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/* 3. Read/write small or large binary files */
		
		try {
			byte[] dataOfBinanyFile = Files.readAllBytes(Paths.get(inputLocation + "/sample/image-4mb.png"));
			Files.write(Paths.get(outputLocation + "/sample/copy3.1-image-4mb.png"),
					dataOfBinanyFile,
					StandardOpenOption.CREATE,
					StandardOpenOption.TRUNCATE_EXISTING);
			System.out.println("\n3.1. Number of Bytes: " + dataOfBinanyFile.length);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//
		
		try (
				InputStream inputStream = new BufferedInputStream(Files.newInputStream(Paths.get(inputLocation + "/sample/image-13mb.png")));
				OutputStream outputStream = new BufferedOutputStream(Files.newOutputStream(Paths.get(outputLocation + "/sample/copy3.2-image-13mb.png"),
						StandardOpenOption.CREATE,
						StandardOpenOption.TRUNCATE_EXISTING));
				) {
			int numBytes = 0;
			byte[] buffer = new byte[64 * 1024]; // 64 KB buffer (8KB – 128KB)
			int chunk = inputStream.read(buffer);
			while (chunk != -1) {
				// Write
				outputStream.write(buffer, 0, chunk);
				
				// Read
				numBytes += chunk;
				chunk = inputStream.read(buffer);
			}
			outputStream.flush();
			System.out.println("\n3.2. Number of Bytes: " + numBytes);
		} catch (IOException e) {
			e.printStackTrace();
		}

		/* 4. Read/write very large binary files */
		
		
		
		/* 5. Read/write files with primitive types */
		
		try (
				DataOutputStream dos = new DataOutputStream(new FileOutputStream("data/data.bin"));
				) {
			// Write
			dos.writeBoolean(true);
			dos.writeChar('J');
			dos.writeByte(10);
			dos.writeShort(10);
			dos.writeInt(10);
			dos.writeLong(10);
			dos.writeFloat(10.5f);
			dos.writeDouble(10.5);
			dos.writeUTF("🐱🐱");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		try (
				DataInputStream dis = new DataInputStream(new FileInputStream("data/data.bin"));
				) {
			// Read
			boolean v1 = dis.readBoolean();
			char v2 = dis.readChar();			
			byte v3 = dis.readByte();			
			short v4 = dis.readShort();
			int v5 = dis.readInt();
			long v6 = dis.readLong();
			float v7 = dis.readFloat();
			double v8 = dis.readDouble();
			String v9 = dis.readUTF();
			
			System.out.println("\n5. Print Data:" + Arrays.asList(v1, v2, v3, v4, v5, v6, v7, v8, v9).toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		/* 6. Read/write files with object types */
		
		try (
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("data/object-data.bin"));
				){
			Cat cat1 = new Cat(12, 56.5);
			Cat cat2 = new Cat(15, 40.5);
			// Write
			objectOutputStream.writeObject(cat1);
			objectOutputStream.writeObject(cat2);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//
		
		try (
				ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("data/object-data.bin"));
				){
			// Read
			Cat cat1 = (Cat) objectInputStream.readObject();
			Cat cat2 = (Cat) objectInputStream.readObject();
			System.out.println("\n6. Print Object:");
			System.out.println("\t" + cat1);
			System.out.println("\t" + cat2);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}		

	}

}

class Cat implements Serializable {
	
	private static final long serialVersionUID = 7117745977636629608L;
	
	private int age;
	private double weight;
	
	public Cat(int age, double weight) {
		this.age = age;
		this.weight = weight;
	}
	
	
	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public double getWeight() {
		return weight;
	}



	public void setWeight(double weight) {
		this.weight = weight;
	}



	@Override
	public String toString() {
		return String.format("Cat{%d,%.2f}", age, weight);
	}
	
}
