package telran.algorithm;

public class MemoryService {
public static int getMaxAvailableSize() {
	int min = 0;
	int max = Integer.MAX_VALUE;
	int middle = 1;
	while (max > min) {
		try {
			middle = min / 2 + max / 2;
			byte[] array = new byte[middle];
			min = middle;
//			System.out.println("max_" + max);
//			System.out.println("min_" + min);
			array = null;
			} catch(OutOfMemoryError e) {
			max = middle - 1;
			
		}
	}
	return max;
	
	}
}
