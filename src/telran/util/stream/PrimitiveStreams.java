package telran.util.stream;

import java.util.Arrays;
import java.util.Random;
import java.util.function.IntConsumer;

import telran.util.ArrayList;
import telran.util.Collection;
import telran.util.List;

public class PrimitiveStreams {
	static public int[] randomUnique(int nNumbers, int minInclusive,
			int maxExclusive) {
		if (maxExclusive - minInclusive < nNumbers) {
			throw new IllegalArgumentException("impossible to get the given amount of unique random numbers");
		}
		return new Random().ints(minInclusive, maxExclusive)
				.distinct().limit(nNumbers).toArray();
	}
	
	static public int[] shuffle(int[] array) {
		int[] arShuffle = new int[array.length];
//		List<Integer> list = new ArrayList<>();
		
		int[] index = {0};

		new Random().ints(0, array.length)
			.distinct().limit(array.length)
			.forEach(i -> arShuffle[index[0]++] = array[i]);
//		arShuffle = list.stream().mapToInt(n -> n).toArray();

		return arShuffle;
	}

}
