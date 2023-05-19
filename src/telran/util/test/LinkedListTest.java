package telran.util.test;

import telran.util.*;

class LinkedListTest extends ListTest{

	@Override
	protected <T> List<T> getList() {
		
		return new LinkedList<>();
	}

}