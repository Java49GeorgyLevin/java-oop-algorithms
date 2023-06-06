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
//		long res = 1;
//		if (b > 0) {
//			res = a * pow(a, b - 1); // a^b = a * a^(b - 1)
//		}
//		return res;
		//TODO HW #18
		//Limitations:
		// 1. no cycles
		// 2. only + or - for arithmetic operations
		long res = 1;
		int sign = (a - Math.abs(a) < 0)  && (b % 2 != 0) ? -1 : 1;
		if(b == 1) {
			res = a;
		} else if (b > 1) {
			a = Math.abs(a);
				res = likeMultiplication(a, b, a);
			}				
		return res * sign;		
	}
	
	private static long likeMultiplication(int a, int b, int count) {
		long res = a;
		if(b > 1) {			
			while(count > 1) {
				res += a;
				--count;
			}
			res = likeMultiplication((int)res, b-1, a);
		}
		return res;
	}
	
	public static long square(int x) {
//		x = Math.abs(x);
//		int res = x;
//			if(x > 0) {
//				int count = x;
//				while(count > 1) {
//					res += x;
//					count--;
//				}
//				
//			}
		return pow(x, 2);
	}
	
	public static boolean isSubstring(String string, String substr) {
		
//		chrAt(int ind);
//		substring(int ind);
//		length();
		if(substr.length() == 0 || string.length() == 0) {
			throw new IllegalArgumentException("Both string and substring must be not empty");
		} else if(substr.length() > string.length()) {
			throw new IllegalArgumentException("Subst cannot be longest than string");
		}
		
		boolean res = false;
		int subL = substr.length();
		int strL = string.length();
		
		for(int i = 0; i < strL; i++) {
			if(string.charAt(i) == substr.charAt(0)) {
				res = true;
				int j = 0;
				while(j < subL && res == true) {
					if(string.charAt(i + j) == substr.charAt(j)) {
						res = true;
						j++;
					} else {
						res = false;
					}
				}
//				for(int j = 0; j < subL; j++) {	}
			}
//			string.substring(i);
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
