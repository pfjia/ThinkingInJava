package io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by pfjia on 2017/4/27 0027.
 */
abstract class Shape implements Serializable {
    public static final int RED = 1;
    public static final int BLUE = 2;
    public static final int GREEN = 3;


    private int xPos, yPos, dimension;
    private static Random rand = new Random(47);
    private static int counter = 0;

    public abstract void setColor(int color);

    public abstract int getColor();

    public Shape(int xPos, int yPos, int dimension) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.dimension = dimension;
    }

    @Override
    public String toString() {
        return getClass() + "color[" + getColor() + "] xPos[" + xPos + "] yPos[" + yPos + "] dim[" + dimension + "]\n";
    }

    public static Shape randomFactory() {
        int xVal = rand.nextInt(100);
        int yVal = rand.nextInt(100);
        int dim = rand.nextInt(100);
        switch (counter++ % 3) {
            default:
            case 0:
                return new Circle(xVal, yVal, dim);
            case 1:
                return new Square(xVal, yVal, dim);
            case 2:
                return new Line(xVal, yVal, dim);
        }
    }
}


class Circle extends Shape {

    private static int color = RED;

    public Circle(int xPos, int yPos, int dimension) {
        super(xPos, yPos, dimension);
    }

    @Override
    public void setColor(int color) {
        Circle.color = color;
    }

    @Override
    public int getColor() {
        return color;
    }
}

class Square extends Shape {
    private static int color;

    public Square(int xPos, int yPos, int dimension) {
        super(xPos, yPos, dimension);
        color = RED;
    }

    @Override
    public void setColor(int color) {
        Square.color = color;
    }

    @Override
    public int getColor() {
        return color;
    }
}

class Line extends Shape {
    private static int color = RED;

    public static void serializeStaticState(ObjectOutputStream os) throws IOException {
        os.writeInt(color);
    }

    public static void deserializeStaticState(ObjectInputStream os) throws IOException {
        color = os.readInt();
    }

    public Line(int xPos, int yPos, int dimension) {
        super(xPos, yPos, dimension);
    }

    @Override
    public void setColor(int color) {
        Line.color = color;
    }

    @Override
    public int getColor() {
        return color;
    }
}

public class StoreCADState {


    public static void main(String[] args) throws IOException {
        List<Class<? extends Shape>> shapeTypes = new ArrayList<>();
        shapeTypes.add(Circle.class);
        shapeTypes.add(Square.class);
        shapeTypes.add(Line.class);

        List<Shape> shapes = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            shapes.add(Shape.randomFactory());
        }

        for (int i = 0; i < 10; i++) {
            ((Shape) shapes.get(i)).setColor(Shape.GREEN);
        }

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("CADState.out"));
        out.writeObject(shapeTypes);
        Line.serializeStaticState(out);
        out.writeObject(shapes);

        System.out.println(shapes);
    }
}
