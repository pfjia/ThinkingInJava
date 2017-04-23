package generics;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

public class ClassCasting {

	public void f(String[] args) throws Exception {
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(
				args[0]));
		// List<Widget> lw1 = List<Widget>.class.cast(in.readObject());

		// Type safety: The expression of type List needs unchecked conversion
		// to conform to List<Widget>
		List<Widget> lw2 = List.class.cast(in.readObject());
	}
}
