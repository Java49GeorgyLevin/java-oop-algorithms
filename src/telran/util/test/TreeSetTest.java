package telran.util.test;

import telran.util.*;

public class TreeSetTest extends SetTest {

	@Override
	protected <T> Set<T> getSet() {
		
		return new TreeSet<>();
	}

}
