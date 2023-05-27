package telran.util;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class HashSet<T> implements Set<T> {
	
	private static final int DEFAULT_HASH_TABLE_SIZE = 16;
	private LinkedList<T>[] hashTable;
	private int size;
	private class HashSetIterator implements Iterator<T> {
		Iterator<T> itList;
		boolean flNext = false;
		
		int currentIndex = getCurrentIndex(-1);
		LinkedList<T> currentHashTable = hashTable[currentIndex];		
		Object currentObj = currentHashTable.head;
		
		@Override
		public boolean hasNext() {
			return currentIndex < hashTable.length;
		}

		private int getCurrentIndex(int i) {
			i++;
			int index = -1;
			while(index == -1 && i < hashTable.length) {
				if(hashTable[i] != null) {
					index = i;
				}
				i++;				
			}
			if(index == -1) {
				index = hashTable.length + 1;
			}
			return index;
		}

		@Override
		public T next() {			
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			T resCurrent = itList.next();
			if(currentObj != currentHashTable.tail) {
				currentObj = itList.next();				
			} else { currentIndex = getCurrentIndex(currentIndex);
				currentHashTable = hashTable[currentIndex];
				currentObj = currentHashTable.head;	
			}
			flNext = true;
			return resCurrent;
		}
		@Override
		public void remove() {
			//TODO
			if (!flNext) {
				throw new IllegalStateException();
			}
			itList.remove();
//			HashSet.this.remove(deleteObj.obj);
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
	
//	private static class Node<T> {
//		T obj;
//		Node<T> next;
//		Node<T> prev;
//
//		Node(T obj) {
//			this.obj = obj;
//		}
//	}

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
	@Override
	//FIXME method should be removed after writing iterator
	public T[] toArray(T[] ar) {
		int size = size();
		if (ar.length < size) {
			ar = Arrays.copyOf(ar, size);
		}
		int index = 0;

		for(int i = 0; i < hashTable.length; i++) {
			LinkedList<T> list = hashTable[i];
			if(list != null) {
				for(T obj: list) {
					ar[index++] = obj;
				}
			}
			
		}
		if (ar.length > size) {
			ar[size] = null;
		}

		return ar;
	}

}
