package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Created by pfjia on 2017/4/27 0027.
 */
public class ThawAlien {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File("X.file")));

        Object mystery = in.readObject();
        System.out.println(mystery.getClass());
    }
}
