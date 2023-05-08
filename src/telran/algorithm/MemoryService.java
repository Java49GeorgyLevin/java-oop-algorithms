package telran.algorithm;

public class MemoryService {
public static int getMaxAvailableSize() {
	int min = 0;
	int max = Integer.MAX_VALUE;
	int middle = max / 2;
	int maxSize = 0;
	while (max >= min) {
		try {			
			byte[] array = new byte[middle];
			maxSize = middle;	
			min = middle + 1;
		} catch(OutOfMemoryError e) {
			max = middle - 1;
			}
		middle = min / 2 + max / 2;
	}
	return maxSize;
	
	}
}
