package telran.util.test;

import telran.util.TreeSet;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.util.Set;

public class TreeSetTest extends SortedSetTest {
TreeSet<Integer> treeSet;
@BeforeEach
@Override
void setUp() {
	super.setUp();
	treeSet = (TreeSet<Integer>) set;
}
	@Override
	protected <T> Set<T> getSet() {
		
		return new TreeSet<>();
	}
//	@Override
//	@Test
//	void clearPerformance() {
//		
//	}
	@Test
	void displayTree() {
		treeSet.setInitialLevel(5);
		treeSet.setSpacesPerLevel(3);
		treeSet.displayRotated();
	}
	@Test
	void widthTest() {
		assertEquals(3, treeSet.width());
	}
	@Test
	void heightTest() {
		assertEquals(3, treeSet.height());
	}
	@Test
	void balanceTest() {
		TreeSet<Integer> treeBalanced = new TreeSet<>();
		int [] array = getRandomArray(255);
		fillCollection(treeBalanced, array);
		treeBalanced.balance();
		assertEquals(8, treeBalanced.height());
		assertEquals(128, treeBalanced.width());
	}
	@Test
	void balanceTestFromSorted() {
		int height = 20;
		int nNumbers =  (int) Math.pow(2, height);
		int [] array = new int[nNumbers - 1];
		for(int i = 0; i < array.length; i++) {
			array[i] = i;
		}
		TreeSet<Integer> treeBalanced = new TreeSet<>();
		
		balanceOrder(array);
		fillCollection(treeBalanced, array);
		
		assertEquals(height, treeBalanced.height());
		assertEquals(nNumbers / 2, treeBalanced.width());
		
	}
	
	@Test
	void balanceOrderTest() {
		int[] arrayToBalanceOrder =  {1, 2, 3, 4, 5, 6, 7};
		int[] expected = {4, 2, 1, 3, 6, 5, 7};
		balanceOrder(arrayToBalanceOrder);
		assertArrayEquals(expected, arrayToBalanceOrder);
		
	}
	
	private void balanceOrder(int[] array) {
		// TODO 
		//reorder array such that adding to tree will get a balanced tree
		int[] tmp = Arrays.copyOf(array, array.length);
		int iFirst = 0;
		int iLast = tmp.length - 1;
		balanceRecursionOrder(array, tmp, 0, iFirst, iLast);	
	}
	
	private void balanceRecursionOrder (int[] array, int[] tmp, int index, int left, int right ) {
		int iMiddle = (left + right) / 2;
		if(left <= right) {
			array[index++] = tmp[iMiddle];
			balanceRecursionOrder(array, tmp, index, left, iMiddle - 1 );
			balanceRecursionOrder(array, tmp, index + (right - iMiddle), iMiddle + 1, right );
		}
	}
	
	@Test
	void inversionTreeTest() {
		Integer[] expected = {100, 50, 30, 10, 7, -20};
		treeSet.inversion();
	    assertArrayEquals(expected, treeSet.toArray(new Integer[0]));
	    assertTrue(treeSet.contains(100));
	}

}
