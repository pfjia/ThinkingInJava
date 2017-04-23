package generics;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ByteSet {
	Byte[] possibles = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	Set<Byte> mySet = new HashSet<Byte>(Arrays.asList(possibles));

	Set<Byte> mySet2 = new HashSet<Byte>(Arrays.<Byte> asList((byte) 1,
			(byte) 2, (byte) 3, (byte) 4, (byte) 5));

}
