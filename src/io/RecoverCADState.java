package io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

/**
 * Created by pfjia on 2017/4/27 0027.
 */
public class RecoverCADState {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("CADState.out"));
        // Read in the same order the were written
        List<Class<? extends Shape>> shapeTypes = (List<Class<? extends Shape>>) in.readObject();

        Line.deserializeStaticState(in);

        List<Shape> shapes = (List<Shape>) in.readObject();
        System.out.println(shapes);
    }
}
