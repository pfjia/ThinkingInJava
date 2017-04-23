package containers;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

import net.mindview.util.TextFile;

class SimpleHashMap3<K, V> extends AbstractMap<K, V> {
	// Choose a prime number for the hash table size, to achieve a uniform
	// distribution
	static final int SIZE = 997;

	// You cna't have a physical array of generics,but you can upcast to one
	LinkedList<MapEntry<K, V>>[] buckets = new LinkedList[SIZE];

	@Override
	public V put(K key, V value) {
		// TODO Auto-generated method stub
		V oldValue = null;
		int index = Math.abs(key.hashCode() % SIZE);
		MapEntry<K, V> pair = new MapEntry<K, V>(key, value);
		if (buckets[index] == null) {
			buckets[index] = new LinkedList<MapEntry<K, V>>();
		}
		LinkedList<MapEntry<K, V>> bucket = buckets[index];

		boolean found = false;
		ListIterator<MapEntry<K, V>> it = bucket.listIterator();
		int inqueryNum = 0;
		while (it.hasNext()) {
			inqueryNum++;
			MapEntry<K, V> iPair = it.next();
			if (iPair.getKey().equals(key)) {
				oldValue = iPair.getValue();
				it.set(pair);// Replace old with new
				found = true;
				break;
			}
		}
		if (!found) {
			buckets[index].add(pair);
		} else {
			System.out.println("ÃΩ≤‚ " + inqueryNum + "¥Œ∑¢œ÷≥ÂÕª");
		}
		return oldValue;
	}

	@Override
	public V get(Object key) {
		// TODO Auto-generated method stub
		int index = Math.abs(key.hashCode()) % SIZE;
		if (buckets[index] == null) {
			return null;
		}
		for (MapEntry<K, V> iPair : buckets[index]) {
			if (iPair.getKey().equals(key)) {
				return iPair.getValue();
			}
		}
		return null;
	}

	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		Set<Map.Entry<K, V>> set = new HashSet<Map.Entry<K, V>>();
		for (LinkedList<MapEntry<K, V>> bucket : buckets) {
			if (bucket == null) {
				continue;
			}
			for (MapEntry<K, V> mpair : bucket) {
				set.add(mpair);
			}
		}
		return set;
	}
}

public class E21_LeftToReader {
	public static void main(String[] args) {
		List<String> words = new TextFile("src/containers/"
				+ "E19_WordCounter3.java", "\\W+");
		SimpleHashMap3<String, Integer> shm = new SimpleHashMap3<String, Integer>();
		for (String word : words) {
			shm.put(word, shm.get(word) == null ? 1 : shm.get(word) + 1);
		}
		System.out.println(shm);

	}
}
