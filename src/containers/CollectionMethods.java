package containers;

import static net.mindview.util.Print.print;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import net.mindview.util.Countries;

public class CollectionMethods {
	public static void main(String[] args) {
		Collection<String> c = new ArrayList<String>();
		c.addAll(Countries.names(6));
		c.add("ten");
		c.add("eleven");
		print(c);

		// Make an array from the List
		Object[] array = c.toArray();

		// Make an String array from the List
		String[] str = c.toArray(new String[0]);

		// Find max and min elements: this means different things depending on
		// the way the Comparable interface is implemented
		print("Collections.max(c) = " + Collections.max(c));
		print("Collections.min(c) = " + Collections.min(c));

		// Add a Collection to another Collection
		Collection<String> c2 = new ArrayList<String>();
		c2.addAll(Countries.names(6));
		c.addAll(c2);
		print(c);

		c.remove(Countries.DATA[0][0]);
		print(c);

		c.remove(Countries.DATA[1][0]);
		print(c);

		// Remove all components that are in the argument collection
		c.removeAll(c2);
		print(c);

		c.addAll(c2);
		print(c);

		// Is an element in this Collection?
		String val = Countries.DATA[3][0];
		print("c.contains(" + val + ")=" + c.contains(val));

		// Is a collection in this Collection?
		print("c.containsAll(c2) =" + c.containsAll(c2));

		Collection<String> c3 = ((List<String>) c).subList(3, 5);
		print(c2);
		print(c3);
		// Keep all the elements that are in both c2 and c3 (an intersection of
		// sets)
		c2.retainAll(c3);
		print(c2);

		print("c2.isEmpty()=" + c2.isEmpty());
		c = new ArrayList<String>();
		c.addAll(Countries.names(6));
		print(c);
		c.clear();// Remove all elements
		print("after c.clear() :" + c);

	}
}
