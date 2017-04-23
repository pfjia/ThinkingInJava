package containers;

import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.mindview.util.Countries;

class SlowSet<E> extends AbstractSet<E> {
	private List<E> set = new ArrayList<E>();

	@Override
	public boolean add(E e) {
		// TODO Auto-generated method stub
		if (set.contains(e)) {// set中已经有了相同元素
			return false;
		} else {
			return set.add(e);
		}
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return set.iterator();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return set.size();
	}
}

public class E18_SlowSet {
	public static void main(String[] args) {
		SlowSet<String> slowSet = new SlowSet<String>();
		slowSet.addAll(Countries.names(10));
		System.out.println(slowSet);
		slowSet.addAll(Countries.names(10));
		System.out.println(slowSet);
	}
}
