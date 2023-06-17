package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

import telran.util.*;

import org.junit.jupiter.api.Test;

abstract class MapTest {
String[] keys = {"lmn", "abc", "ab", "a"};
Integer[] values = {3, 2, 2, 1};
protected Map<String, Integer> map;
    @BeforeEach
    void setUp() {
    	for(int i = 0; i < keys.length; i++) {
    		map.put(keys[i], values[i]);
    	}
    }
	@Test
	void getTest() {
		for(int i = 0; i < keys.length; i++) {
			assertEquals(values[i], map.get(keys[i]));
		}
	}
	@Test
	void containsKeyTest() {
		assertTrue(map.containsKey("abc"));
		assertFalse(map.containsKey("bc"));
	}
	@Test
	void containsValueTest() {
		assertTrue(map.containsValue(2));
		assertFalse(map.containsValue(4));
	}
	@Test
	void keySetTest() {
		Collection<String> colKeys = map.keySet();
		for(String key: keys) {
			assertTrue(colKeys.contains(key));
		}
	}
	@Test
	void valuesTest() {
		Collection<Integer> colValues = map.values();
		for(Integer val: values) {
			assertTrue(colValues.contains(val));			
		}
	}
	@Test
	void removeTest() {
		assertEquals(1, map.remove("a"));
		assertEquals(3, map.values().size());
	}

}
