package innerclasses;

/**
 * Created by pfjia on 2017/4/23 0023.
 */

interface A {

}

interface B {

}

class X implements A, B {

}

class Y implements A {
    B makeB() {
        return new B() {
        };
    }
}

public class MultiInterfaces {
    static void takesA(A a) {

    }

    static void takesB(B b) {

    }

    public static void main(String[] args) {
        X x = new X();
        Y y = new Y();
        takesA(x);
        takesA(y);
        takesB(x);
        takesB(y.makeB());
    }


}
