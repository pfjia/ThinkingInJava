package net.mindview.util;

import java.util.AbstractList;

public class CountingIntegerList extends AbstractList<Integer> {
	private int size;

	public CountingIntegerList(int size) {
		// TODO Auto-generated constructor stub
		this.size = size;
	}

	@Override
	public Integer get(int index) {
		// TODO Auto-generated method stub
		return Integer.valueOf(index);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	public static void main(String[] args) {
		CountingIntegerList list = new CountingIntegerList(10);
		System.out.println(new CountingIntegerList(30));
		System.out.println(list.get(50));
	}

}
