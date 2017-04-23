package net.mindview.util;

import java.util.LinkedList;

/**
 * ��װ��һ��LinkedList
 * 
 * @author pfjia
 *
 * @param <T>
 */
public class Deque<T> {
	private LinkedList<T> deque = new LinkedList<T>();

	public void addFirst(T e) {
		deque.addFirst(e);
	}

	public void addLast(T e) {
		deque.addLast(e);
	}

	public T getFirst() {
		return deque.getFirst();
	}

	public T getLast() {
		return deque.getLast();
	}

	public T removeFirst() {
		return deque.removeFirst();
	}

	public T removeLast() {
		return deque.removeLast();
	}

	public int size() {
		return deque.size();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return deque.toString();
	}

	// And other methods as necessary

}
