package telran.algorithm;

public class MemoryService {
public static int getMaxAvailableSize() {
	int min = 0;
	int max = Integer.MAX_VALUE;
	int middle = (min + max) / 2;
	boolean running = true;
	while (running && Integer.compare(max, min) >= 0) {
		try {
			byte[] array = new byte[middle];
			while (Integer.compare(middle, min) > 0) {
				min = middle;
				middle = (min + max) / 2;
				array = null;
				array = new byte[middle];
				}
			running = false;
			} catch(OutOfMemoryError e) {
			max = middle - 1;
			middle = (min + max) / 2;

		}
	}
	return max;
	
	}
}
