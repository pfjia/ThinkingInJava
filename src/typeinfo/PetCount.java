package typeinfo;

import static net.mindview.util.Print.print;
import static net.mindview.util.Print.printnb;

import java.util.HashMap;

import typeinfo.pets.Cat;
import typeinfo.pets.Cymric;
import typeinfo.pets.Dog;
import typeinfo.pets.EgyptianMau;
import typeinfo.pets.ForNameCreator;
import typeinfo.pets.Gerbil;
import typeinfo.pets.Hamster;
import typeinfo.pets.Manx;
import typeinfo.pets.Mouse;
import typeinfo.pets.Mutt;
import typeinfo.pets.Pet;
import typeinfo.pets.PetCreator;
import typeinfo.pets.Pug;
import typeinfo.pets.Rat;
import typeinfo.pets.Rodent;

public class PetCount {
	// map��ֵ����<String,Integer>
	static class PetCounter extends HashMap<String, Integer> {
		// ��pet��dog����dog+1��pet��+1
		public void count(Pet pet) {
			String type = pet.getClass().getSimpleName();
			Integer quantity = get(type);
			if (quantity == null) {
				put(type, 1);
			} else {
				put(type, quantity + 1);
			}
		}

		public void count(String type) {
			Integer quantity = get(type);
			if (quantity == null) {
				put(type, 1);
			} else {
				put(type, quantity + 1);
			}
		}
	}

	public static void countPets(PetCreator creator) {
		PetCounter counter = new PetCounter();
		for (Pet pet : creator.createArray(20)) {
			printnb(pet.getClass().getSimpleName() + " ");
			if (pet instanceof Pet) {
				counter.count("Pet");
			}
			if (pet instanceof Dog) {
				counter.count("Dog");
			}
			if (pet instanceof Mutt) {
				counter.count("Mutt");
			}
			if (pet instanceof Pug) {
				counter.count("Pug");
			}
			if (pet instanceof Cat) {
				counter.count("Cat");
			}
			if (pet instanceof EgyptianMau) {
				counter.count("EgyptianMau");
			}
			if (pet instanceof Manx) {
				counter.count("Manx");
			}
			if (pet instanceof Cymric) {
				counter.count("Cymric");
			}
			if (pet instanceof Rodent) {
				counter.count("Rodent");
			}
			if (pet instanceof Rat) {
				counter.count("Rat");
			}
			if (pet instanceof Mouse) {
				counter.count("Mouse");
			}
			if (pet instanceof Hamster) {
				counter.count("Hamster");
			}
			if (pet instanceof Gerbil) {
				counter.count("Gerbil");
			}
			// �����жϿ��Է���PetCounter.count()��
			// counter.count(pet);
		}
		print();
		System.out.println("==========================================");
		print(counter);
	}

	public static void main(String[] args) {
		countPets(new ForNameCreator());
	}
}
