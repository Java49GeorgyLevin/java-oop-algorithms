package telran.util;

public abstract class AbstractMap<K, V> implements Map<K, V> {
	protected Set<Entry<K, V>> set;
	@Override
	public V get(K key) {
		Entry<K, V> entry = set.get(new Entry<>(key, null));
		
		return entry == null ? null : entry.getValue();
	}

	@Override
	public V put(K key, V value) {
		Entry<K, V> entry = set.get(new Entry<>(key, null));
		V res = null;
		if (entry != null) {
			res = entry.getValue();
			entry.setValue(value);
		} else {
			set.add(new Entry<>(key, value));
		}
		return res;
	}

	@Override
	public boolean containsKey(K key) {
		// TODO Auto-generated method stub
		if(key == null) {
			new NullPointerException();
		}
		boolean res = false;
		Entry<K, V> entry = set.get(new Entry<>(key, null));
		if(entry != null) {
			res = true;
		}		
		return res;
	}

	@Override
	public boolean containsValue(V value) {
		// TODO Auto-generated method stub
		if(value == null) {
			new NullPointerException();
		}
		boolean res = false;
		Set<K> setKey = keySet();
		for(K k: setKey) {
				if(res == false && get(k).equals(value)) {
					res = true;
				}
		}
		return res;
	}

	@Override
	public Set<K> keySet() {
		Set<K> res = getKeySet();
		set.stream().map(e -> e.getKey()).forEach(key -> res.add(key));
		return res;
	}

	abstract protected Set<K> getKeySet();

	@Override
	public Collection<V> values() {
		// TODO Auto-generated method stub
		Collection<V> collectionValues = new LinkedList<>();
		set.stream().map(e -> e.getValue()).forEach(value -> collectionValues.add(value));

		return collectionValues;
	}

	@Override
	public Set<Entry<K, V>> entrySet() {
		
		return set;
	}
	@Override
	public V remove(K key) {
		//TODO
		if(key == null) {
			new NullPointerException();
		}
		V valueRemoved = null;
		if(containsKey(key)) {			
			valueRemoved = get(key);
			Entry<K, V> entry = new Entry<>(key, valueRemoved);
			set.remove(entry);			
		}		

		return valueRemoved;
	}

}
