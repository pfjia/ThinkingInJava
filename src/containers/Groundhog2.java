package containers;

public class Groundhog2 extends Groundhog {

	public Groundhog2(int n) {
		super(n);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return number;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return obj instanceof Groundhog2
				&& (number == ((Groundhog2) obj).number);
	}

}
