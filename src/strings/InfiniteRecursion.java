package strings;

import java.util.ArrayList;
import java.util.List;

public class InfiniteRecursion {
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		// �ַ���+this���������ת������thisת��ΪString��������this.toString()���ᷢ���ݹ����
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
