package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;

import telran.util.*;

import org.junit.jupiter.api.Test;

class ArrayListTest {

	@Test
	void testAdd() {
		ArrayList<Integer> numbers = new ArrayList<>();
		ArrayList<String> strings = new ArrayList<>();
		numbers.add(5);
		numbers.add(10);
		strings.add("ABC");
		strings.add("DEF");
		assertEquals(2, numbers.size());
		assertEquals(2, strings.size());
	}
	
	@Test
		void testAddIndex() {
		ArrayList<Integer> num =  new ArrayList<>();
		for(int i = 0; i < 5; i++) {
		num.add(i * 2);
		}
		assertEquals(5, num.size());
		num.add(5, 5);
		assertEquals(5, num.get(5));
		assertEquals(6, num.size());
		num.add(3, 3);
		assertEquals(3, num.get(3));
		assertEquals(7, num.size());
		num.add(0, 0);
		assertEquals(8, num.size());
		assertEquals(0, num.get(0));
		assertEquals(5, num.get(7));
		assertEquals(3, num.get(4));		
	}
	
	@Test
		void testRemoveIndex() {
		ArrayList<Integer> num = new ArrayList<>();
		for(int i = 0; i < 5; i++) {
		num.add(i * 3);
		}
		assertEquals(12, num.get(4));
		assertEquals(5, num.size());
		assertEquals(12, num.remove(4));
		assertEquals(6, num.get(2));
		assertEquals(4, num.size());
		assertEquals(6, num.remove(2));
		assertEquals(0, num.get(0));
		assertEquals(3, num.size());
		assertEquals(0, num.remove(0));
		assertEquals(2, num.size());


		
	}
}
