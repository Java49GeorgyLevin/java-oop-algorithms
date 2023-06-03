package telran.util.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import org.junit.jupiter.api.Test;

import telran.util.Set;
import telran.util.SortedSet;

public abstract class SortedSetTest extends SetTest {

	@Override
	protected Integer[] getActual(Integer[] array, int size) {
		//System.out.println("Sorted test");
		return array;
	}
	@Test
	void firstTest() {
		SortedSet<Integer> sortedSet = (SortedSet<Integer>)set;
		assertEquals(-20, sortedSet.first());
	}
	@Test
	void lastTest() {
		SortedSet<Integer> sortedSet = (SortedSet<Integer>)set;
		assertEquals(100, sortedSet.last());
	}
	@Test
	void ceilingTest() {
		SortedSet<Integer> sortedSet = (SortedSet<Integer>)set;
		assertEquals(-20, sortedSet.ceiling(-40));
		assertEquals(50, sortedSet.ceiling(40));
		assertEquals(100, sortedSet.ceiling(50));
		assertEquals(100, sortedSet.ceiling(60));
		assertEquals(null, sortedSet.ceiling(100));
		assertThrowsExactly(NullPointerException.class, () -> sortedSet.ceiling(null));

	}
	@Test
	void floorTest() {
		SortedSet<Integer> sortedSet = (SortedSet<Integer>)set;
		assertEquals(10, sortedSet.floor(20));
		assertEquals(30, sortedSet.floor(40));
		assertEquals(10, sortedSet.floor(30));
		assertEquals(100, sortedSet.floor(120));
		assertEquals(null, sortedSet.floor(-40));
		assertThrowsExactly(NullPointerException.class, () -> sortedSet.floor(null));
	}

}
