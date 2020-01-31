import java.util.Arrays;

/**
 * 
 */

/**
 * @author Prabu
 *
 */
public class RecursionDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = {3, 2, 3, 4, 5};
		System.out.println("is sorted - " + isArraySorted(a, a.length - 1));
		
		binary(b.length);
	}

	public static boolean isArraySorted(int[] a, int index) {
		if (index == 0) {
			return true;
		}
		
		return (a[index - 1] > a[index])? false: isArraySorted(a, index - 1);
	}
	
	private static byte[] b = new byte[3];
	
	/**
	 * Generate all the strings of n bits.
	 * 
	 * @param n
	 */
	public static void binary(int n) {
		if (n < 1) {
			System.out.println(Arrays.toString(b));
			return;
		}
		
		n--;
		b[n] = 0;
		binary(n);
		b[n] = 1;
		binary(n);
	}
}
