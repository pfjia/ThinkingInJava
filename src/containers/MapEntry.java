package containers;

import java.util.Map;

public class MapEntry<K, V> implements Map.Entry<K, V> {
	private K key;
	private V value;

	public MapEntry(K key, V value) {
		// TODO Auto-generated constructor stub
		this.key = key;
		this.value = value;
	}

	@Override
	public K getKey() {
		// TODO Auto-generated method stub
		return key;
	}

	@Override
	public V getValue() {
		// TODO Auto-generated method stub
		return value;
	}

	/**
	 * ·µ»Ø¾ÉµÄvalue
	 */
	@Override
	public V setValue(V value) {
		// TODO Auto-generated method stub
		V result = this.value;
		this.value = value;
		return result;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return (key == null ? 0 : key.hashCode())
				^ (value == null ? 0 : value.hashCode());
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (!(obj instanceof MapEntry)) {
			return false;
		}

		MapEntry me = (MapEntry) obj;
		return (key == null ? me.getKey() == null : key.equals(me.getKey()))
				&& (value == null ? me.getValue() == null : value.equals(me
						.getValue()));
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return key + "= " + value;
	}
}
