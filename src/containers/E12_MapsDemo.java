package containers;

import static net.mindview.util.Print.print;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class E12_MapsDemo {

	private static void test(Map<String, String> map) {
		map.put("sky", "blue");
		map.put("grass", "green");
		map.put("ocean", "dancing");
		map.put("tree", "tall");
		map.put("earth", "brown");
		map.put("earth", "warm");
		try {
			map.put("extra", "object");
		} catch (ArrayIndexOutOfBoundsException e) {
			print("Too many objects");
		}
		print(map);
		print(map.get("ocean"));
	}

	public static void main(String[] args) {
		test(new HashMap<String, String>());
		test(new TreeMap<String, String>());
		test(new LinkedHashMap<String, String>());
	}
}
