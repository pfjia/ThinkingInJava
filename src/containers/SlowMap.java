package containers;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.mindview.util.Countries;

public class SlowMap<K, V> extends AbstractMap<K, V> {
	private List<K> keys = new ArrayList<K>();
	private List<V> values = new ArrayList<V>();

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
		// TODO Auto-generated method stub
		Set<Map.Entry<K, V>> set = new HashSet<Map.Entry<K, V>>();
		Iterator<K> ki = keys.iterator();
		Iterator<V> vi = values.iterator();
		while (ki.hasNext()) {
			set.add(new MapEntry<K, V>(ki.next(), vi.next()));
		}
		return set;
	}

	public static void main(String[] args) {
		SlowMap<String, String> m = new SlowMap<String, String>();
		m.putAll(Countries.capitals(15));
		System.out.println(m);
		System.out.println(m.get("BULGARIA"));
		System.out.println(m.entrySet());
	}

}
