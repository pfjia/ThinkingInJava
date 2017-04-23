package containers;

import java.util.List;

import net.mindview.util.TextFile;

public class E19_WordCounter3 {

	public static void main(String[] args) {
		List<String> words = new TextFile("src/containers/"
				+ "E19_WordCounter3.java", "\\W+");
		SimpleHashMap<String, Integer> shm = new SimpleHashMap<String, Integer>();
		for (String word : words) {
			shm.put(word, shm.get(word) == null ? 1 : shm.get(word) + 1);
		}
		System.out.println(shm);
	}
}
