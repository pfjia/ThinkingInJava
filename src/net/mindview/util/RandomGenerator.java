package net.mindview.util;

import java.util.Random;

public class RandomGenerator {
	private static Random r = new Random(47);

	public static class Boolean implements Generator<java.lang.Boolean> {

		@Override
		public java.lang.Boolean next() {
			// TODO Auto-generated method stub
			return r.nextBoolean();
		}
	}

	public static class Byte implements Generator<java.lang.Byte> {
		@Override
		public java.lang.Byte next() {
			// TODO Auto-generated method stub
			return (byte) r.nextInt();
		}
	}

	public static class Character implements Generator<java.lang.Character> {
		@Override
		public java.lang.Character next() {
			// TODO Auto-generated method stub

			return CountingGenerator.chars[r
					.nextInt(CountingGenerator.chars.length)];
		}
	}

	public static class String extends CountingGenerator.String {
		// Plug in the random Character generator:
		{
			cg = new Character();// Instance initializer
		}

		public String() {
			// TODO Auto-generated constructor stub
		}

		public String(int length) {
			super(length);
		}
	}

	public static class Short implements Generator<java.lang.Short> {

		@Override
		public java.lang.Short next() {
			// TODO Auto-generated method stub
			return (short) r.nextInt();
		}
	}

	public static class Integer implements Generator<java.lang.Integer> {
		private int mod = 10000;

		public Integer() {
			// TODO Auto-generated constructor stub
		}

		public Integer(int modulo) {
			mod = modulo;
		}

		@Override
		public java.lang.Integer next() {
			// TODO Auto-generated method stub
			return r.nextInt(mod);
		}
	}

	public static class Long implements Generator<java.lang.Long> {
		private int mod = 10000;

		public Long() {
			// TODO Auto-generated constructor stub
		}

		public Long(int modulo) {
			mod = modulo;
		}

		@Override
		public java.lang.Long next() {
			// TODO Auto-generated method stub
			return (long) r.nextInt(mod);
		}
	}

	public static class Float implements Generator<java.lang.Float> {

		@Override
		public java.lang.Float next() {
			// TODO Auto-generated method stub
			int trimmed = Math.round(r.nextFloat() * 100);
			return ((float) trimmed) / 100;
		}
	}

	public static class Double implements Generator<java.lang.Double> {
		private double value = 0;

		@Override
		public java.lang.Double next() {
			// TODO Auto-generated method stub
			int trimmed = Math.round(r.nextFloat() * 100);
			return ((double) trimmed) / 100;
		}
	}

}
