package containers;

import java.util.List;

import net.mindview.util.TextFile;

public class E13_WordCounter {
	public static void main(String[] args) {
		List<String> words = new TextFile("src/containers/"
				+ "E13_WordCounter.java", "\\W+");
		AssociativeArray<String, Integer> counters = new AssociativeArray<String, Integer>(
				words.size());
		for (String word : words) {
			counters.put(word,
					counters.get(word) == null ? 1 : counters.get(word) + 1);
		}
		System.out.println(counters);
	}

}
