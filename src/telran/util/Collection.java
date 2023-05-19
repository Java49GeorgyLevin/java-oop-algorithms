package telran.util;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Predicate;

public interface Collection<T> extends Iterable<T> {
	boolean add(T obj);

	int size();

	boolean remove(T pattern);

	boolean removeIf(Predicate<T> predicate);

	boolean contains(T pattern);

	default T[] toArray(T[] ar) {
		int size = size();
		if (ar.length < size) {
			ar = Arrays.copyOf(ar, size);
		}

		int i = 0;
		Iterator<T> it = iterator();
		while (it.hasNext()) {
			ar[i++] = it.next();
		}

		if (ar.length > size) {
			ar[size] = null;
		}

		return ar;
	}

	default boolean isEqual(T object, T pattern) {
		return pattern == null ? object == pattern : pattern.equals(object);
	}
}
