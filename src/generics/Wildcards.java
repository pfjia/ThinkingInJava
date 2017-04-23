package generics;

public class Wildcards {

	static void rawArgs(Holder holder, Object arg) {
		// Type safety: The method setValue(Object) belongs to the raw type
		// Holder. References to generic type Holder<T> should be parameterized
		holder.setValue(arg);

		holder.setValue(new Wildcards());

		// T t=holder.getValue();

		// Ok,but type information has been lost:
		Object obj = holder.getValue();
	}

	// Simalar to rawArgs(), but errors instead of warnings
	static void unboundedArg(Holder<?> holder, Object arg) {
		// The method setValue(capture#1-of ?) in the type Holder<capture#1-of
		// ?> is not applicable for the arguments (Wildcards)
		// holder.setValue(arg);
		// holder.setValue(new Wildcards());

		// T t=holder.getValue();

		Object obj = holder.getValue();
	}

	static <T> T exact1(Holder<T> holder) {
		T t = holder.getValue();
		return t;
	}

	static <T> T exact2(Holder<T> holder, T arg) {
		holder.setValue(arg);
		T t = holder.getValue();
		return t;
	}

	static <T> T wildSubtype(Holder<? extends T> holder, T arg) {
		// holder.setValue(arg);

		T t = holder.getValue();
		return t;
	}

	static <T> void wildSupertype(Holder<? super T> holder, T arg) {
		// Type mismatch: cannot convert from capture#3-of ? super T to T
		// T t = holder.getValue();

		Object obj = holder.getValue();

	}

	public static void main(String[] args) {
		Holder raw = new Holder<Long>();

		raw = new Holder();

		Holder<Long> qualified = new Holder<Long>();
		Holder<?> unbounded = new Holder<Long>();
		Holder<? extends Long> bounded = new Holder<Long>();

		Long lng = 1L;

		rawArgs(raw, lng);
		rawArgs(qualified, lng);
		rawArgs(unbounded, lng);
		rawArgs(bounded, lng);

		unboundedArg(raw, lng);
		unboundedArg(qualified, lng);
		unboundedArg(unbounded, lng);
		unboundedArg(bounded, lng);

		Object r1 = exact1(raw);

		Long r2 = exact1(qualified);
		Object r3 = exact1(unbounded);
		Long r4 = exact1(bounded);

		Long r5 = exact2(raw, lng);

		Long r6 = exact2(qualified, lng);
		// Long r7 = exact2(unbounded, lng);
		// Long r8 = exact2(bounded, lng);

		Long r9 = wildSubtype(raw, lng);

	}

}
