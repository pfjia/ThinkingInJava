package containers;

import java.util.List;
import java.util.TreeMap;

import net.mindview.util.TextFile;

public class E15_WordCounter2 {
	public static void main(String[] args) {
		List<String> words = new TextFile("src/containers/"
				+ "E15_WordCounter2.java", "\\W+");
		SlowMap<String, Integer> sm = new SlowMap<String, Integer>();
		for (String word : words) {
			sm.put(word, sm.get(word) == null ? 1 : sm.get(word) + 1);
		}
		TreeMap<String, Integer> tm = new TreeMap<String, Integer>(sm);
		System.out.println(tm);
	}

}
