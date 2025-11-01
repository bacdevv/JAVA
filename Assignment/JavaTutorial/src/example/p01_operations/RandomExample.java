package example.p01_operations;

import java.util.Random;

public class RandomExample {

	public static void main(String[] args) {
		Random random = new Random(); // default seed: System.nanoTime()
		Random randomSeed = new Random(System.currentTimeMillis()); // or SecureRandom class
		randomSeed.setSeed(System.currentTimeMillis());
		
		System.out.println("[-2^31; 2^31-1] ~ " + random.nextInt()); // [MIN; MAX)
		System.out.println("[0; 100) ~ " + random.nextInt(100)); // [0; bound)
		System.out.println("[10; 100) ~ " + random.nextInt(10, 100)); // [origin; bound)
		
		System.out.println("[0.0; 1.0) ~ " + random.nextDouble()); // [0.0; 1.0)
		System.out.println("[0.0; 100.0) ~ " + random.nextDouble(100.0)); // [0.0; bound)
		System.out.println("[10.0; 100.0) ~ " + random.nextDouble(10.0, 100.0)); // [origin; bound)
		
		System.out.println("{false; true} ~ " + random.nextBoolean()); // {false; true}
		
	}

}
