package telran.algorithm.tests;
import static telran.algorithm.InitialAlgorithms.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class testsAlgorithm {
	
	short [] sortShortPos = {1600, 2500, 3600, 4900, 6400, 9100, 0, 1, 4, 9, 16, 25, 36, 49, 64, 91};	
	short [] sortShortPosSort = {0, 1, 4, 9, 16, 25, 36, 49, 64, 91, 1600, 2500, 3600, 4900, 6400, 9100};
	short [] sortShort = {1600, 2500, -100, 3600, 4900, 6400, 9100, 0, 1, 4, 9, 16, 25, 36, 49, 64, 91};
	short [] shortReflect = {1600, 2500, -100, -1600, 3600, 4900, 6400, 9100, 0, 1, 4, 9, 16, 25, 36, 49, 64, 91, -2500};


	@Test
	void testSortShortPositive() {
		sortShortPositive(sortShortPos);
		assertArrayEquals(sortShortPosSort, sortShortPos);
		short [] ar100th =  new short [100000];
		randomArPos(ar100th);
		short [] ar100rnd = Arrays.copyOf(ar100th, ar100th.length);
		sortShortPositive(ar100th);
		short [] ar100positive = Arrays.copyOf(ar100th, ar100th.length);
		bubbleSort(ar100th);
		short [] ar100bubble = Arrays.copyOf(ar100th, ar100th.length);
		assertArrayEquals(ar100positive, ar100bubble);
		System.out.println("end");

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
	
	@Test
	void testGetMaxPositiveWithNegativeReflect() {
		assertEquals(2500, getMaxPositiveWithNegativeReflect(shortReflect));
		shortReflect[1] = -9100;
		assertEquals(9100, getMaxPositiveWithNegativeReflect(shortReflect));
		assertEquals(-1, getMaxPositiveWithNegativeReflect(sortShort));
		
	}
	@Test
	void testBubbleSort() {
		bubbleSort(sortShortPos);
		assertArrayEquals(sortShortPosSort, sortShortPos);
		short [] ar100th =  new short [100000];
		randomAr(ar100th);
		bubbleSort(ar100th);
		System.out.println("end");
		short [] ar1mln =  new short [1000001];
		randomAr(ar1mln);
		bubbleSort(ar1mln);
		System.out.println(ar1mln[0]);
		System.out.println(ar1mln[1000000]);
		
	}
	
	void randomArPos (short [] ar) {
		for(int i = 0; i < ar.length; i++) {
			ar[i] = (short)(Math.random()* Short.MAX_VALUE);
		}
	}
	
	void randomAr (short [] ar) {
		for(int i = 0; i < ar.length; i++) {
			ar[i] = (short)((Math.random() - 0.5)* Short.MAX_VALUE);
		}
	}

}
