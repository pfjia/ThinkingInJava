package net.mindview.util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class ContainerMethodDifferences {
	static Set<String> methodSet(Class<?> type) {
		Set<String> result = new TreeSet<String>();
		for (Method m : type.getMethods()) {
			result.add(m.getName());
		}
		return result;
	}

	static void interfaces(Class<?> type) {
		System.out.println("Interfaces in " + type.getSimpleName() + ": ");
		List<String> result = new ArrayList<String>();
		for (Class<?> c : type.getInterfaces()) {
			result.add(c.getSimpleName());
		}
		System.out.println(result);
	}

	static Set<String> object = methodSet(Object.class);
	static {
		object.add("clone");
	}

	static void difference(Class<?> superset, Class<?> subset) {
		System.out.print(superset.getSimpleName() + " extends "
				+ subset.getSimpleName() + ", adds: ");
		Set<String> comp = Sets.difference(methodSet(superset),
				methodSet(subset));
		// 可能是一个类和接口比较，类中都有Object的方法，把多出来属于Object的方法去掉
		comp.removeAll(object);
		System.out.println(comp);
		interfaces(superset);
	}

	public static void main(String[] args) {
		System.out.println("Collection: " + methodSet(Collection.class));
		interfaces(Collection.class);
		// Set接口虽然继承了Collection接口，但没有增加一个方法
		System.out.println("Set: " + methodSet(Set.class));
		difference(Set.class, Collection.class);
		// HashSet除了Set接口中方法外，只增加了Object类的方法
		difference(HashSet.class, Set.class);
		// LinkedHashSet除了HashSet接口中方法外，只增加了Object类的方法
		difference(LinkedHashSet.class, HashSet.class);
		// TreeSet增加了比较的方法
		difference(TreeSet.class, Set.class);

		difference(SortedSet.class, Set.class);
		// List
		difference(List.class, Collection.class);

		difference(ArrayList.class, List.class);

		difference(LinkedList.class, List.class);

		difference(Queue.class, Collection.class);

		difference(PriorityQueue.class, Queue.class);

		System.out.println("Map: " + methodSet(Map.class));
		difference(HashMap.class, Map.class);

		difference(LinkedHashMap.class, HashMap.class);

		difference(SortedMap.class, Map.class);

		difference(TreeMap.class, Map.class);

		difference(Queue.class, Collection.class);
	}

}
