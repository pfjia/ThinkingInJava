package strings;

import java.util.ArrayList;
import java.util.List;

public class InfiniteRecursion {
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		// 字符串+this会进行类型转换，将this转换为String，即调用this.toString()，会发生递归调用
		// return "InfiniteRecursion address: " + this + "\n";
		return "InfiniteRecursion address: " + super.toString() + "\n";
	}

	public static void main(String[] args) {
		List<InfiniteRecursion> v = new ArrayList<InfiniteRecursion>();
		for (int i = 0; i < 10; i++) {
			v.add(new InfiniteRecursion());
		}
		System.out.println(v);
	}
}
