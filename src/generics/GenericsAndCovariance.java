package generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsAndCovariance {
	public static void main(String[] args) {
		List<? extends Fruit> flist = new ArrayList<Fruit>();

		/**
		 * boolean add(E e); add()�����Ĳ���ʱE����flist�Ĳ���������<? extends
		 * Fruit>����ʾ��ĳ�ּ̳���Fruit�ض����ͣ�������һ����֪����ʲô���ض����ͣ���������������ʲô������
		 */
		// flist.add(new Apple());
		// flist.add(new Fruit());
	}
}
