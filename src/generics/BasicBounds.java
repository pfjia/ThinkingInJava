package generics;

import java.awt.Color;

interface HasColor {
	Color getColor();
}

class Colored<T extends HasColor> {
	T item;

	Colored(T item) {
		this.item = item;
	}

	T getItem() {
		return item;
	}

	Color color() {
		return item.getColor();
	}
}

class Dimension {
	public int x;
	public int y;
	public int z;
}

class ColoredDimension<T extends Dimension & HasColor> {
	T item;

	public ColoredDimension(T item) {
		// TODO Auto-generated constructor stub
		this.item = item;
	}

	T getItem() {
		return item;
	}

	Color color() {
		return item.getColor();
	}

	int getX() {
		return item.x;
	}

	int getY() {
		return item.y;
	}

	int getZ() {
		return item.z;
	}
}

interface Weight {
	int weight();
}

class Solid<T extends Dimension & HasColor & Weight> {
	T item;

	public Solid(T item) {
		// TODO Auto-generated constructor stub
		this.item = item;
	}

	T getItem() {
		return item;
	}

	Color color() {
		return item.getColor();
	}

	int getX() {
		return item.x;
	}

	int getY() {
		return item.y;
	}

	int getZ() {
		return item.z;
	}

	int weight() {
		return item.weight();
	}
}

class Bounded extends Dimension implements HasColor, Weight {

	@Override
	public int weight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return null;
	}

}

public class BasicBounds {
	public static void main(String[] args) {
		Solid<Bounded> solid = new Solid<Bounded>(new Bounded());
		solid.color();
		solid.getY();
		solid.weight();
	}
}
