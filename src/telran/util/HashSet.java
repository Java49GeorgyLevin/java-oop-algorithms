package telran.util;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class HashSet<T> implements Set<T> {
	
	private static final int DEFAULT_HASH_TABLE_SIZE = 16;
	private LinkedList<T>[] hashTable;
	private int size;
	private class HashSetIterator implements Iterator<T> {
		Iterator<T> currentItList;
		Iterator<T> prevItList;
		int currentItIndex;
		boolean flNext = false;
		
		public HashSetIterator() {
			initialState();
		}
		
		private void initialState() {
			currentItIndex = getCurrentIndex(-1);
			if(currentItIndex >= 0) {
				currentItList = hashTable[currentItIndex].iterator();	
			}			
		}
		
		@Override
		public boolean hasNext() {
			return currentItIndex >= 0;
		}

		private int getCurrentIndex(int currentIndex) {
			currentIndex++;
			while(currentIndex < hashTable.length && 
					(hashTable[currentIndex] == null ||
					hashTable[currentIndex].size() == 0)
					) {
				currentIndex++;				
			}
			return currentIndex < hashTable.length ? currentIndex : -1;
		}

		@Override
		public T next() {			
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			T resCurrent = currentItList.next();
			prevItList = currentItList;
			updateItList();
			flNext = true;
			return resCurrent;
		}
		
		private void updateItList() {
			if(!currentItList.hasNext()) {
				currentItIndex = getCurrentIndex(currentItIndex);
				if(currentItIndex >= 0) {
				currentItList = hashTable[currentItIndex].iterator();		
				}
			}
		}

		@Override
		public void remove() {
			if (!flNext) {
				throw new IllegalStateException();
			}
			prevItList.remove();
			size--;
			flNext = false;
		}
		
	}
	@SuppressWarnings("unchecked")
	public HashSet(int hashTableSize) {
		hashTable = new LinkedList[hashTableSize];
	}
	public HashSet() {
		this(DEFAULT_HASH_TABLE_SIZE);
	}
	@Override
	public Iterator<T> iterator() {		
		return new HashSetIterator();
	}

	@Override
	public boolean add(T obj) {
		boolean res = false;
		if(size >= 0.75 * hashTable.length) {
			recreation();
		}
		int index = getHashTableIndex(obj);
		if(hashTable[index] == null) {
			hashTable[index] = new LinkedList<>();
		}
		if(!hashTable[index].contains(obj)) {
			hashTable[index].add(obj);
			size++;
			res = true;
		}
		
		return res;
	}

	private int getHashTableIndex(T obj) {
		
		return Math.abs(obj.hashCode()) % hashTable.length;
	}
	private void recreation() {
		HashSet<T> tmp = new HashSet<>(hashTable.length * 2);
		for (int i = 0; i < hashTable.length; i++) {
			if (hashTable[i] != null) {
				for (T obj : hashTable[i]) {
					tmp.add(obj);
				} 
			}
		}
		this.hashTable = tmp.hashTable;
		
	}
	@Override
	public int size() {
		
		return size;
	}

	@Override
	public boolean remove(T pattern) {
		boolean res = false;
		int index = getHashTableIndex(pattern);
		if (hashTable[index] != null) {
			res = hashTable[index].remove(pattern);
			if (res) {
				size--;
			}
		}
		return res;
	}

	@Override
	public boolean contains(T pattern) {
		int index = getHashTableIndex(pattern);
		return hashTable[index] != null && hashTable[index].contains(pattern);
	}

}
