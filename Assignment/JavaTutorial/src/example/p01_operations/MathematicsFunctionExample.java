package example.p01_operations;

public class MathematicsFunctionExample {
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		double PI = Math.PI;
		double E = Math.E;
		double power = Math.pow(2, 8); // 256
		double base2 = Math.sqrt(4); // square root
		double base3 = Math.cbrt(27); // cube root
		double max = Math.max(base2, base3);
		double min = Math.min(base2, base3);
		double random = Math.random(); // [0.0;1.0)
		double absValue = Math.abs(-4.5); // 4.5
		
		long rLong = Math.round(27.653); // 28l
		double rDouble = Math.rint(27.653); // 28.0
		double cDouble = Math.ceil(27.001); // 28.0
		double fDouble = Math.floor(27.999); // 27.0
		
		double log10 = Math.log10(1e4); // 4.0
		double ln = Math.log(Math.pow(Math.E, 4.0)); // 4.0
		
		// Get Integer
		int fdPP = Math.floorDiv(7, 3); // 2
		int fdNN = Math.floorDiv(-7, -3); // 2
		int fdNP = Math.floorDiv(-7, 3); // -3
		int fdPN = Math.floorDiv(7, -3); // -3
		
		// Modulo: Division with signed remainder from divisor
		int fmPP = Math.floorMod(7, 3); // 1
		int fmNN = Math.floorMod(-7, -3); // -1
		int fmNP = Math.floorMod(-7, 3); // 2
		int fmPN = Math.floorMod(7, -3); // -2
	}
}
