package typeinfo;

import static net.mindview.util.Print.print;
import static net.mindview.util.Print.printnb;
import net.mindview.util.TypeCounter;
import typeinfo.pets.Pet;
import typeinfo.pets.Pets;

public class PetCount4 {
	public static void main(String[] args) {
		TypeCounter counter = new TypeCounter(Pet.class);
		for (Pet pet : Pets.createArray(20)) {
			printnb(pet.getClass().getSimpleName() + " ");
			counter.count(pet);
		}
		print();
		print(counter);
	}
}
