package telran.algorithm.tests;
import static telran.algorithm.InitialAlgorithms.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class testsAlgorithm {
	
	short [] sortShortPos = {1600, 2500, 3600, 4900, 6400, 9100, 0, 1, 4, 9, 16, 25, 36, 49, 64, 91};	
	short [] sortShortPosSort = {0, 1, 4, 9, 16, 25, 36, 49, 64, 91, 1600, 2500, 3600, 4900, 6400, 9100};
	short [] sortShort = {1600, 2500, -100, 3600, 4900, 6400, 9100, 0, 1, 4, 9, 16, 25, 36, 49, 64, 91};


	@Test
	void testSortShortPositive() {
		sortShortPositive(sortShortPos);
		assertArrayEquals(sortShortPosSort, sortShortPos);

	}
	
	@Test
	void testIsSum2 ( ) {
		short short49 = 49;
		short short4949 = 4949;
		short short4800 = 4800;
		assertTrue(isSum2(sortShortPos, short49));
		assertTrue(isSum2(sortShortPos, short4949));
		assertFalse(isSum2(sortShortPos, (short)0));
		assertTrue(isSum2(sortShort, short4800));
		sortShort = Arrays.copyOf(sortShort, sortShort.length+1);
		sortShort[sortShort.length-1] = -4900;
		assertTrue(isSum2(sortShort, (short)0));
		assertFalse(isSum2(sortShortPos, (short)-2500));
	}

}
