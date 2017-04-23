package generics;

import java.util.List;
import java.util.Map;

import typeinfo.pets.Person;
import typeinfo.pets.Pet;

public class LimitsOfInference {
	static void f(Map<Person, List<? extends Pet>> petPerson) {

	}

	public static void main(String[] args) {
		// f(New.map());
		// The method f(Map<Person,List<? extends Pet>>) in the type
		// LimitsOfInference is not applicable for the arguments
		// (Map<Object,Object>)
	}

}
