
public class Chapter36_01_nestedLoops {

	// Problem: print a pyramid like this:
	// 1
	// 2 3
	// 4 5 6
	// 7 8 9 10  OR
	
	// 3
	// 6  9
	// 12 15 18

	public static void main(String[] args) {
		int k = 1;
		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= i; j++) {
				// Add your logic here
				System.out.print(3*k + "  ");
				k++;
			}
			System.out.println("");
		}
	}
}