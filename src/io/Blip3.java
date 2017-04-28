package io;

import java.io.*;

/**
 * Created by pfjia on 2017/4/27 0027.
 */
public class Blip3 implements Externalizable {
    private int i;
    private String s;

    public Blip3() {
        System.out.println("Blip3 constructor");
    }

    public Blip3(String s, int i) {
        System.out.println("Blip3(String s,int i)");
        this.i = i;
        this.s = s;
    }

    @Override
    public String toString() {
        return "Blip3{" +
            "i=" + i +
            ", s='" + s + '\'' +
            '}';
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Blip3.writeExternal()");
        out.writeObject(s);
        out.writeInt(i);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Blip3.writeExternal()");
        s = (String) in.readObject();
        i = in.readInt();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Constructing objects");
        Blip3 b3 = new Blip3("A String ", 47);
        System.out.println(b3);
        ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("Blip3.out"));
        System.out.println("Saving Object");
        o.writeObject(b3);
        o.close();

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("Blip3.out"));
        System.out.println("Recovering b3");
        b3 = (Blip3) in.readObject();
        System.out.println(b3);
    }
}
