package io;

import java.nio.ByteBuffer;

/**
 * Getting different representations from a ByteBuffer
 * 
 * @author pfjia
 *
 */
public class GetData {
	private static final int BSIZE = 1024;

	public static void main(String[] args) {
		ByteBuffer bb = ByteBuffer.allocate(BSIZE);
		// Allocation automatically zeros the ByteBuffer
		int i = 0;
		while (++i < bb.limit()) {
			if (bb.get() != 0) {
				System.out.println("nonzero");
			}
		}
		System.out.println("i=" + i);
		bb.rewind();

		// Store and read a char array:
		bb.asCharBuffer().put("Howdy!");
		char c;
		while ((c = bb.getChar()) != 0) {
			System.out.print(c + " ");
		}
		System.out.println();
		bb.rewind();

		// Store and read a short
		bb.asShortBuffer().put((short) 471142);
		System.out.println(bb.getShort());
		bb.rewind();

		// Store and read an int
		bb.asIntBuffer().put(10086);
		System.out.println(bb.getInt());
		bb.rewind();

		// Store and read a long
		bb.asLongBuffer().put(84564671);
		System.out.println(bb.getLong());
		bb.rewind();

		// Store and read a float
		bb.asFloatBuffer().put(9782.54f);
		System.out.println(bb.getFloat());
		bb.rewind();

		// Store and read a double
		bb.asDoubleBuffer().put(485674.544);
		System.out.println(bb.getDouble());
		bb.rewind();

	}

}
