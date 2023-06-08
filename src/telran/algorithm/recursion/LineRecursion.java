package telran.algorithm.recursion;

public class LineRecursion {
	public static long factorial(int n) {
		if(n < 0) {
			throw new IllegalArgumentException("Cannot be negative value");
		}
		long res = 1;
		if(n > 1) {
			res = n*factorial(n - 1);
		}
		return res;
	}
	public static long pow(int a, int b) {
		//a - any number
		//b - any positive number or zero
		if (b < 0) {
				throw new IllegalArgumentException("Pow cannot be negative value");
		}
		long res = 1;
		if (b > 0) {
				res = likeMultiplication(a, pow(a, b - 1));
			}				
		return res;		
	}
	
	private static long likeMultiplication(int a, long b) {
		long res = 0;
		if(b != 0) {			
			res = b < 0 ? likeMultiplication(-a, -b) : a + likeMultiplication(a, b - 1);
			}
		return res;
	}
	
	public static long square(int x) {
		long res = 0;
		if(x != 0) {
			res = x < 0 ? square(-x) : x + x - 1 + square(x - 1);
		}
		return res;
	}
	
//	public static boolean isSubstringNot(String string, String substr) {
//		boolean res = false;
//		
//		if(substr.length() == 0) {
//			res = true;
//		} else if (string.length() == 0 || string.length() < substr.length() ) {
//			res = false;
//		} else if (string.charAt(0) == substr.charAt(0)) {
//			res = isSubstringNot(string.substring(1), substr.substring(1));
//		} else {
//			res = isSubstringNot(string.substring(1), substr);
//		}		
//		return res;
//	}
	
	public static boolean isSubstring(String string, String substr) {
		boolean res = false;	
		if(string.length() >= substr.length()) {

			if(isConsist(string, substr)) {
				res = true;
			} else {
				res = isSubstring(string.substring(1), substr);	
			}
		}
		return res;
	}
	
	private static boolean isConsist(String string, String substr) {
		boolean res = false;		
		if(substr.length() == 0) {
			res = true;
		} else if (string.charAt(0) == substr.charAt(0)) {
			res = isConsist(string.substring(1), substr.substring(1));
		}		
		return res;
	}
	
	
	public static long sum(int[] array) {
		return sum(0, array);
	}
	private static long sum(int firstIndex, int[] array) {
		long sum = 0;
		if (firstIndex < array.length) {
			sum = array[firstIndex] + sum(firstIndex + 1, array);
		}
		return sum;
	}
	public static int[] reverse(int[] array) {
		return reverse(array, 0, array.length - 1);
	}
	private static int[] reverse(int[] array, int left, int right) {
		
		if(left < right) {
			array[left] = array[left] + array[right];
			array[right] = array[left] - array[right];
			array[left] = array[left] - array[right];
			reverse(array, left + 1, right - 1);
		}
		return array;
	}
	
}
