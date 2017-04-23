package containers;

import static net.mindview.util.Print.print;

import java.util.Iterator;

import net.mindview.util.CountingGenerator;
import net.mindview.util.Generator;
import net.mindview.util.MapData;
import net.mindview.util.Pair;
import net.mindview.util.RandomGenerator;

class Letters implements Generator<Pair<Integer, String>>, Iterable<Integer> {

	private int size = 9;
	private int number = 1;
	private char letter = 'A';

	@Override
	public Pair<Integer, String> next() {
		// TODO Auto-generated method stub
		return new Pair<Integer, String>(number++, "" + letter++);
	}

	@Override
	public Iterator<Integer> iterator() {
		// TODO Auto-generated method stub
		return new Iterator<Integer>() {

			@Override
			public void remove() {
				// TODO Auto-generated method stub
				throw new UnsupportedOperationException();
			}

			@Override
			public Integer next() {
				// TODO Auto-generated method stub
				return number++;
			}

			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				return number < size;
			}
		};
	}

}

public class MapDataTest {
	public static void main(String[] args) {

		// ���ͷ����״�ƥ�䲻��ʹ���Զ���װ
		// һ��Pair��Generator��Ԫ�ظ���
		print(MapData.map(new Letters(), 11));

		print(MapData.map(new CountingGenerator.Character(),
				new RandomGenerator.String(), 8));

		print(MapData.map(new CountingGenerator.Character(), "Value", 6));

		print(MapData.map(new Letters(), new RandomGenerator.String(3)));

		print(MapData.map(new Letters(), "Pop"));
	}
}
