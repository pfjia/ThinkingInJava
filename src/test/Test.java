package test;

/**
 * Created by pfjia on 2017/4/29 0029.
 */
public class Test {
    public void f(int a) {
        int b;
        class Inner {
            void f() {
                System.out.println(a);
            }
        }
        new Inner().f();
    }

    public static void main(String[] args) {
        new Test().f(6);
    }
}
