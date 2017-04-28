package io;

import java.io.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by pfjia on 2017/4/27 0027.
 */
public class Login implements Serializable {
    private Date date = new Date();
    private String username;
    private transient String password;

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Login{" +
            "date=" + date +
            ", username='" + username + '\'' +
            ", password='" + password + '\'' +
            '}';
    }

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        Login a = new Login("Hulk", "mylittlePony");
        System.out.println("Login a=" + a);
        ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("login.out"));
        o.writeObject(a);
        o.close();

        TimeUnit.MILLISECONDS.sleep(1000);

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("login.out"));
        System.out.println("Recovering object at" + new Date());
        a = (Login) in.readObject();
        System.out.println("login a=" + a);
    }
}
