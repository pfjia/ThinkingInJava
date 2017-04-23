package containers;

import static net.mindview.util.Print.print;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Random;
import java.util.Vector;

public class Utilities {
	static List<String> list = Arrays.asList("one Two three Four five six one"
			.split(" "));

	public static void main(String[] args) {
		print(list);
		print("'list' disjoint (Four)?:"
				+ Collections.disjoint(list, Collections.singletonList("Four")));
		print("max:" + Collections.max(list));
		print("min:" + Collections.min(list));
		print("max w/ comparator:"
				+ Collections.max(list, String.CASE_INSENSITIVE_ORDER));
		print("min w/ comparator:"
				+ Collections.min(list, String.CASE_INSENSITIVE_ORDER));

		List<String> sublist = Arrays.asList("Four five six".split(" "));
		print("indexOfSublist:" + Collections.indexOfSubList(list, sublist));
		print("lastindexOfSublist:"
				+ Collections.lastIndexOfSubList(list, sublist));

		Collections.replaceAll(list, "one", "Yo");
		print("replaceAll:" + list);

		Collections.reverse(list);
		print("reverse" + list);

		// 向右循环3个位置
		Collections.rotate(list, 3);
		print("rotate:" + list);

		// copy后覆盖原先的值
		List<String> source = Arrays.asList("in the matrix".split(" "));
		Collections.copy(list, source);
		print("copy:" + list);

		Collections.swap(list, 0, list.size() - 1);
		print("swap:" + list);

		Collections.shuffle(list, new Random(47));
		print("shuffled:" + list);

		Collections.fill(list, "pop");
		print("fill:" + list);

		print("frequency of pop:" + Collections.frequency(list, "pop"));

		List<String> dups = Collections.nCopies(3, "snap");
		print("dups:" + dups);

		print("'list' disjoint 'dups':" + Collections.disjoint(list, dups));

		// Getting an old-style Enumeration:
		Enumeration<String> e = Collections.enumeration(dups);
		Vector<String> v = new Vector<String>();
		while (e.hasMoreElements()) {
			v.addElement(e.nextElement());
			// Converting an old-style Vector to a list via an Enumeration:
			ArrayList<String> arrayList = Collections.list(v.elements());
			print("arrayList:" + arrayList);
		}

	}

}
