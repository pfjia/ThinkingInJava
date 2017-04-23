package typeinfo;

import static net.mindview.util.Print.print;
import static net.mindview.util.Print.printnb;

import java.util.LinkedHashMap;
import java.util.Map;

import net.mindview.util.MapData;
import typeinfo.pets.LiteralPetCreator;
import typeinfo.pets.Pet;
import typeinfo.pets.Pets;

public class PetCount3 {
	// ���map�ļ�ֵ����<Class,Integer>
	static class PetCounter extends
			LinkedHashMap<Class<? extends Pet>, Integer> {
		public PetCounter() {
			// TODO Auto-generated constructor stub
			super(MapData.map(LiteralPetCreator.allTypes, 0));
		}

		// �Ѽ�Ϊpet��map�е�ֵ��1
		public void count(Pet pet) {
			// Class.isInstance() eliminates instanceofs:
			for (Map.Entry<Class<? extends Pet>, Integer> pair : entrySet()) {
				if (pair.getKey().isInstance(pet)) {
					put(pair.getKey(), pair.getValue() + 1);
				}
			}

			// ���pet�ǹ�������������ֻ��¼�˹�+1����û�м�¼pet+1��������Ĵ�����dog��pet��+1
			// put(pet.getClass(), get(pet.getClass()) + 1);
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			StringBuilder result = new StringBuilder("{");
			for (Map.Entry<Class<? extends Pet>, Integer> pair : entrySet()) {
				result.append(pair.getKey().getSimpleName());
				result.append("=");
				result.append(pair.getValue());
				result.append(", ");
			}
			result.delete(result.length() - 1, result.length());
			result.append("}");
			return result.toString();
		}
	}

	public static void main(String[] args) {
		PetCounter petCount = new PetCounter();
		for (Pet pet : Pets.createArray(20)) {
			printnb(pet.getClass().getSimpleName() + " ");
			petCount.count(pet);
		}
		print();
		print("=========================");
		print(petCount);
	}
}
