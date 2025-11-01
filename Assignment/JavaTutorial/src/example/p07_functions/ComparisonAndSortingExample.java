package example.p07_functions;

import java.util.Arrays;
import java.util.Comparator;

class DisplayResolution implements Comparable<DisplayResolution> {
	
	private int width;
	private int height;
	
	public DisplayResolution(int width, int height) {
		setHeight(height);
		setWidth(width);;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	@Override
	public String toString() {
		return String.format("%d x %d", width, height);
	}

	@Override
	public int compareTo(DisplayResolution other) {
		return Integer.compare(width * height, other.width * other.height); // Ascending
	}
	
}

class VideoFile implements Comparable<VideoFile> {
	
	private int code;
	private String name;
	private double sizeInBytes;
	private DisplayResolution resolution;
	
	public VideoFile(int code, String name,
			double sizeInBytes, DisplayResolution resolution) {
		setCode(code);
		setName(name);
		setSizeInBytes(sizeInBytes);
		setResolution(resolution);
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSizeInBytes() {
		return sizeInBytes;
	}

	public void setSizeInBytes(double sizeInBytes) {
		this.sizeInBytes = sizeInBytes;
	}

	public DisplayResolution getResolution() {
		return resolution;
	}

	public void setResolution(DisplayResolution resolution) {
		this.resolution = resolution;
	}
	
	@Override
	public String toString() {
		return String.format("{code: %s, name: %s, size: %.1f byte%s, resolution: %s}",
				code,
				name,
				sizeInBytes,
				sizeInBytes > 1 ? "s" : "",
				resolution);
	}

	@Override
	public int compareTo(VideoFile o) {
		return this.name.compareTo(o.name); // By Name in Ascending
	}
	
}

public class ComparisonAndSortingExample {
	
	public static void main(String[] args) {
		/* 1. Implementing the Comparable interface
		 * Defines (@Override) a compareTo() method for the class to determine the order of instances of that class
		 * instance.compareTo(other)
		 * if equal to 0: instance == other
		 * if greater than 0: instance > other
		 * if less than 0: instance < other
		 */
		
		DisplayResolution displayResolution1 = new DisplayResolution(1920, 1080); // 2073600
		DisplayResolution displayResolution2 = new DisplayResolution(2000, 1000); // 2000000
		System.out.println("1. Implementing the Comparable interface: "  + displayResolution2.compareTo(displayResolution1));
		
		VideoFile[] list = generateSampleData();
		System.out.println("\n#Original");
		printVideoList(list);
		
		/* Exchange Sort */
		for (int i = 0; i < list.length - 1; i++) {
			for (int j = i + 1; j < list.length; j++) {
				/* Inverse when sorting ascending: array[i] > array[j] */
				// By DisplayResolution in Descending
				// By Size in Ascending
				boolean byDisResDesc = list[i].getResolution().compareTo(list[j].getResolution()) < 0;
				boolean bySizeAsc = list[i].getResolution().compareTo(list[j].getResolution()) == 0
						&& Double.compare(list[i].getSizeInBytes(), list[j].getSizeInBytes()) > 0;
				if(byDisResDesc || bySizeAsc) { 
					VideoFile tmp = list[i];
					list[i] = list[j];
					list[j] = tmp;
				}
			}
		}
		System.out.println("\n#Exchange sort");
		printVideoList(list);
		
		/* Selection Sort */
		for (int i = 0; i < list.length - 1; i++) {
			int selectedIndex = i;
			for (int j = i + 1; j < list.length; j++) {
				/* Inverse when sorting ascending: array[i] > array[j] */
				// By DisplayResolution in Descending
				// By Size in Ascending
				boolean byDisResDesc = list[selectedIndex].getResolution().compareTo(list[j].getResolution()) < 0;
				boolean bySizeAsc = list[selectedIndex].getResolution().compareTo(list[j].getResolution()) == 0
						&& Double.compare(list[selectedIndex].getSizeInBytes(), list[j].getSizeInBytes()) > 0;
				if(byDisResDesc || bySizeAsc) { 
					selectedIndex = j;
				}
			}
			if (selectedIndex != i) {
				VideoFile tmp = list[i];
				list[i] = list[selectedIndex];
				list[selectedIndex] = tmp;
			}
		}
		System.out.println("\n#Selection sort");
		printVideoList(list);
		
		/* Bubble Sort */
		for (int i = 0; i < list.length - 1; i++) {
			for (int j = 0; j < list.length - 1 - i; j++) {
				/* Inverse when sorting ascending: array[j] > array[j + 1] */
				// By DisplayResolution in Descending
				// By Size in Ascending
				boolean byDisResDesc = list[j].getResolution().compareTo(list[j + 1].getResolution()) < 0;
				boolean bySizeAsc = list[j].getResolution().compareTo(list[j + 1].getResolution()) == 0
						&& Double.compare(list[j].getSizeInBytes(), list[j + 1].getSizeInBytes()) > 0;
				if(byDisResDesc || bySizeAsc) { 
					VideoFile tmp = list[j];
					list[j] = list[j + 1];
					list[j + 1] = tmp;
				}
			}
		}
		System.out.println("\n#Bubble sort");
		printVideoList(list);
		
		/* 2. Using Anonymous class: new Comparator<T>() */
		
		Arrays.sort(list, new Comparator<VideoFile>() {

			@Override
			public int compare(VideoFile o1, VideoFile o2) {
				return o2.getResolution().compareTo(o1.getResolution()); // By DisplayResolution in Descending
			}
		
		});
		
		System.out.println("\n#By DisplayResolution in Descending");
		printVideoList(list);
		
		/* 3. Using Comparator.comparing */
		Arrays.sort(list, Comparator.reverseOrder()); // By Name in Descending
		System.out.println("\n#By Name in Descending");
		printVideoList(list);
		
		Arrays.sort(list, Comparator.comparing(VideoFile::getCode).reversed()); // By Code in Descending
		System.out.println("\n#By Code in Descending");
		printVideoList(list);
		
		Arrays.sort(list, Comparator
				.comparing(VideoFile::getResolution).reversed() // By DisplayResolution in Descending
				.thenComparing(VideoFile::getSizeInBytes) // By Size in Ascending
		); 
		System.out.println("\n#By DisplayResolution in Descending, By Size in Ascending");
		printVideoList(list);
		
		/* 4. Using Lambda Expression */ 
		Arrays.sort(list, (v1, v2) -> v1.getName().compareTo(v2.getName())); // By Name in Ascending 
		System.out.println("\n#By Name in Ascending");
		printVideoList(list);
		
		Arrays.sort(list, (v1, v2) -> {
			int cmp = v2.getResolution().compareTo(v1.getResolution()); // By DisplayResolution in Descending
			if(cmp == 0) {
				cmp = Double.compare(v1.getSizeInBytes(), v2.getSizeInBytes()) ; // By Size in Ascending 
			}			
			return cmp;
		}); 
		System.out.println("\n#By DisplayResolution in Descending, By Size in Ascending");
		printVideoList(list);
		
	}
	
	/*******************************************************/
	
	private static void printVideoList(VideoFile[] list) {
		String s;
		VideoFile video;
		String headerLine = String.format("%3s | %6s | %-25s | %8s | %15s",
				"No", "Code", "Name", "Size", "Display");
		System.out.println(headerLine + "\n" + "+".repeat(73));
		for (int i = 0; i < list.length; i++) {
			video = list[i];
			s = String.format("%3d | %6d | %-25s | %8.1f | %15s",
					i + 1,
					video.getCode(),
					video.getName(),
					video.getSizeInBytes(),
					video.getResolution()
			);
			System.out.println(s);
		}
	}
	
	private static VideoFile[] generateSampleData() {
		VideoFile[] videos = {
				new VideoFile(2031, "Für Elise", 5120.0, new DisplayResolution(1920, 1080)),
				new VideoFile(2045, "Swan Lake", 8432.0, new DisplayResolution(2560, 1440)),
				new VideoFile(2023, "The Four Seasons", 1024.0, new DisplayResolution(1920, 1080)),
				new VideoFile(2050, "Clair de Lune", 9780.0, new DisplayResolution(3840, 2160)),
				new VideoFile(2027, "Moonlight Sonata", 6500.0, new DisplayResolution(2560, 1440)),
				new VideoFile(2024, "Nocturne Op.9 No.2", 3200.0, new DisplayResolution(1920, 1080)),
				new VideoFile(2037, "Canon in D", 7450.0, new DisplayResolution(2560, 1440)),
				new VideoFile(2048, "Boléro", 10200.0, new DisplayResolution(3840, 2160)),
				new VideoFile(2029, "Ride of the Valkyries", 5800.0, new DisplayResolution(2560, 1440)),
				new VideoFile(2033, "Hungarian Rhapsody No.2", 4300.0, new DisplayResolution(1920, 1080))
		};
		return videos;
	}

}
