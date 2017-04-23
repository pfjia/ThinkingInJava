package generics;

public class NotSelfBounded<T> {
	T element;

	// 下面的T不是泛型方法中的类型参数，只是返回值的泛型对象的类型参数
	NotSelfBounded<T> set(T arg) {
		element = arg;
		return this;
	}

	T get() {
		return element;
	}

}

class A2 extends NotSelfBounded<A2> {

}

class B2 extends NotSelfBounded<A2> {

}

class C2 extends NotSelfBounded<C2> {
	C2 setAndGet(C2 arg) {
		set(arg);
		return get();
	}
}

class D2 {

}

class E2 extends NotSelfBounded<D2> {

}
