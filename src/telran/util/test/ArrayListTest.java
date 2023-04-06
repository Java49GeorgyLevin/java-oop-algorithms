package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;

import telran.util.*;

import org.junit.jupiter.api.Test;



class ArrayListTest {
List<Integer> list;
Integer[] numbers = {10, -20, 7, 50, 100, 30};
@BeforeEach
void setUp() {
	list = new ArrayList<>(1);
	for( int i = 0; i < numbers.length; i++) {
		list.add(numbers[i]);
	}
}
	@Test
	void testAdd() {
	assertTrue(list.add(numbers[0]));
	assertEquals(numbers.length + 1, list.size());
	}
	@Test
	void testAddIndex() {
		Integer [] expected0_500 = {500, 10, -20, 7, 50, 100, 30};
		Integer [] expected0_500_3_700 = {500, 10, -20, 700, 7, 50, 100, 30};
		Integer [] expected0_500_3_700_8_300 = {500, 10, -20, 700, 7, 50, 100, 30, 300};
		list.add(0, 500);
		runTest(expected0_500);
		list.add(3, 700);
		runTest(expected0_500_3_700);
		list.add(8, 300);
		runTest(expected0_500_3_700_8_300);
		
	}
	@Test
	void testRemoveIndex() {
		Integer [] expectedNo10 = { -20, 7, 50, 100, 30};
		Integer [] expectedNo10_50 = { -20, 7,  100, 30};
		Integer [] expectedNo10_50_30 = { -20, 7,  100};
		assertEquals(10, list.remove(0));
		runTest(expectedNo10);
		assertEquals(50, list.remove(2));
		runTest(expectedNo10_50);
		assertEquals(30, list.remove(3));
		runTest(expectedNo10_50_30);
		
	}
	@Test
	void testGetIndex() {
		assertEquals(10, list.get(0));
	}	
	@Test
	void testIndexOf() {
		list.add(3, 10);
		assertEquals(0, list.indexOf(10));
		assertEquals(-1, list.indexOf(null));
	}
	@Test
	void testLastIndexOf() {
		assertEquals(0, list.lastIndexOf(10));
		list.add(5, 10);
		assertEquals(5, list.lastIndexOf(10));
		assertEquals(-1, list.lastIndexOf(314));
	}
	@Test
	void testRemovePattern() {
		list.add(100);
		list.add(30);
		list.add(100);
		Integer r10 = 10;
		Integer r30 = 30;
		Integer r100 = 100;
		Integer r314 = 314;
		assertFalse(list.remove(r314));
		assertTrue(list.remove(r10));
		assertTrue(list.remove(r100));
		assertTrue(list.remove(r30));
	}
	@Test
	void testToArray() {
		Integer[] toAr = {};
		Object[] arList = list.toArray(toAr);
		Integer[] arExpected = Arrays.copyOf(arList, arList.length, Integer[].class);
		runTest(arExpected);
		Integer[] toAr10 = new Integer[10];
		for(int i = 0; i <10; i++) {
			toAr10[i] = 22;  
		}
		assertArrayEquals(toAr10, list.toArray(toAr10));
	}
	private void runTest(Integer[] expected) {
		int size = list.size() ;
		Integer [] actual = new Integer[expected.length];
		
		for(int i = 0; i < size; i++) {
			actual[i] = list.get(i);
		}
		assertArrayEquals(expected, actual);
		
	}

}
