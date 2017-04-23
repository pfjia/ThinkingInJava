package containers;

import static net.mindview.util.Print.print;
import static net.mindview.util.Print.printnb;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.mindview.util.CountingMapData;

class SlowMap2<K, V> extends AbstractMap<K, V> {
	private List<K> keys = new ArrayList<K>();
	private List<V> values = new ArrayList<V>();
	private Set<Map.Entry<K, V>> entrySet = new EntrySet();

	@Override
	public V put(K key, V value) {
		// TODO Auto-generated method stub
		V oldValue = get(key);// The old value or null
		if (!keys.contains(key)) {// 插入值无冲突
			keys.add(key);
			values.add(value);
		} else {// 插入值有冲突
			values.set(keys.indexOf(key), value);
		}
		return oldValue;
	}

	@Override
	public V get(Object key) {// Key is type Object,not K
		// TODO Auto-generated method stub
		if (!keys.contains(key)) {
			return null;
		}
		return values.get(keys.indexOf(key));
	}

	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		return entrySet;
	}

	private class EntrySet extends AbstractSet<Map.Entry<K, V>> {

		@Override
		public Iterator<java.util.Map.Entry<K, V>> iterator() {
			// TODO Auto-generated method stub
			return new Iterator<Map.Entry<K, V>>() {
				private int index = -1;
				boolean canRemove;

				@Override
				public boolean hasNext() {
					// TODO Auto-generated method stub
					return index < keys.size() - 1;
				}

				@Override
				public java.util.Map.Entry<K, V> next() {
					// TODO Auto-generated method stub
					canRemove = true;
					++index;
					return new MapEntry<K, V>(keys.get(index),
							values.get(index));
				}

				@Override
				public void remove() {
					// TODO Auto-generated method stub
					if (!canRemove) {
						throw new IllegalStateException();
					}
					canRemove = false;
					keys.remove(index);
					values.remove(index--);
				}
			};
		}

		@Override
		public int size() {
			// TODO Auto-generated method stub
			return keys.size();
		}

	}

}

public class E16_SlowMapTest {

	public static void printKeys(Map<Integer, String> map) {
		printnb("Size=" + map.size() + ", ");
		printnb("Keys: ");
		print(map.keySet());// Produce a set of the keys
	}

	public static void test(Map<Integer, String> map) {
		print("--------------------" + map.getClass().getSimpleName()
				+ "--------------------");
		map.putAll(new CountingMapData(25));
		// Map has 'Set' behavior for keys
		map.putAll(new CountingMapData(25));
		printKeys(map);

		// Producing a Collection of the values
		printnb("Values: ");
		print(map.values());
		print(map);
		print("map.containsKey(11): " + map.containsKey(11));
		print("map.get(11): " + map.get(11));
		print("map.containsValue(\"F0\"): " + map.containsValue("F0"));
		Integer key = map.keySet().iterator().next();
		print("First key in map:" + key);
		map.remove(key);
		printKeys(map);
		map.clear();
		print("map.isEmpty(): " + map.isEmpty());
		map.putAll(new CountingMapData(25));
		// Operations on the Set change the Map:
		map.keySet().removeAll(map.keySet());
		print("map.isEmpty(): " + map.isEmpty());
	}

	public static void main(String[] args) {
		test(new SlowMap2<Integer, String>());
	}

}
