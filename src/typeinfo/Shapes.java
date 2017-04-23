package typeinfo;

import java.util.Arrays;
import java.util.List;

abstract class Shape {
	void draw() {
		System.out.println(this + ".draw()");
	}

	@Override
	public abstract String toString();

	public void rotate() {
		if (this instanceof Circle) {
			System.out.println("Don't rotate "
					+ this.getClass().getSimpleName());
		} else {
			System.out.println("Rotete " + this.getClass().getSimpleName());
		}
	}

}

class Circle extends Shape {
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Circle";
	}
}

class Square extends Shape {
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Square";
	}
}

class Triangle extends Shape {
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Triangle";
	}
}

class Rhomboid extends Shape {
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Rhomboid";
	}
}

public class Shapes {
	public static void main(String[] args) throws Exception {
		List<Shape> shapeList = Arrays.asList(new Circle(), new Square(),
				new Triangle());
		for (Shape shape : shapeList) {
			shape.draw();
			shape.rotate();
		}
		System.out.println("===================================");
		Shape s = new Rhomboid();
		s.draw();
		if (s instanceof Rhomboid) {
			Rhomboid r = (Rhomboid) s;
			r.draw();
		}
		if (s instanceof Circle) {
			Circle c = (Circle) s;
			c.draw();
		}

	}
}