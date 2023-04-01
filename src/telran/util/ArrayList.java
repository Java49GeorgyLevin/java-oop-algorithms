package telran.util;

import java.util.Arrays;

public class ArrayList<T> implements List<T> {
	private static final int DEFAULT_CAPACITY = 16;
	private T[] array;
	private int size;
	@SuppressWarnings("unchecked")
	public ArrayList(int capacity) {
		array = (T[]) new Object[capacity];
	}
	public ArrayList() {
		this(DEFAULT_CAPACITY);
		
	}

	@Override
	public boolean add(T obj) {
		if(size == array.length) {
			reallocate();
		}
		array[size] = obj;
		size++;
		return true;
	}
	
	private void reallocate() {
		array = Arrays.copyOf(array, array.length * 2);
	}

	@Override
	public void add(int index, T obj) {
		if(size == array.length) {
			reallocate();
		}
		System.arraycopy(array, index, array, index+1, size-index);
		array[index] = obj;
		size++;
	}

	@Override
	public T remove(int index) {
		T removed = array[index];
System.out.println(index);
System.out.println("in" + Arrays.toString(array));
	//System.arraycopy(array, index+1, array, index, size-index-1);
		System.arraycopy(array, index+1, array, index, size-index);
//System.out.println(Arrays.toString(array));
	//array = Arrays.copyOf(array, size-1);
	//array = Arrays.copyOf(array, size-1);
System.out.println("out" + Arrays.toString(array));
		size--;
		return removed;
	}

	@Override
	public T get(int index) {
		return array[index];
	}

	@Override
	public int size() {
		return size;
	}

}
