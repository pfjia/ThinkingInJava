package generics;

class Hamster extends ComparablePet implements Comparable<ComparablePet> {
	@Override
	public int compareTo(ComparablePet o) {
		// TODO Auto-generated method stub
		return 0;
	}
}

class Gecko extends ComparablePet {
	@Override
	public int compareTo(ComparablePet o) {
		// TODO Auto-generated method stub
		return 0;
	}
}

public class RestrictedComparablePets {

}
