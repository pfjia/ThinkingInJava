package io;

import java.io.*;

/**
 * Created by pfjia on 2017/4/27 0027.
 */
public class SerialCtl implements Serializable {
    private String a;
    private transient String b;

    public SerialCtl(String a, String b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return "SerialCtl{" +
            "a='" + a + '\'' +
            ", b='" + b + '\'' +
            '}';
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeObject(b);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        b = (String) in.readObject();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SerialCtl sc = new SerialCtl("Test1", "Test2");
        System.out.println("Before:\n" + sc);
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        ObjectOutputStream o = new ObjectOutputStream(buf);
        o.writeObject(sc);
        ObjectInputStream i = new ObjectInputStream(new ByteArrayInputStream(buf.toByteArray()));
        SerialCtl sct2 = (SerialCtl) i.readObject();
        System.out.println("After:\n" + sct2);
    }
}
