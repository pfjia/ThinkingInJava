package innerclasses;

/**
 * Created by pfjia on 2017/4/23 0023.
 */
public class E01_Outer {
    public static void main(String[] args) {
        E01_Outer outer = new E01_Outer();
        outer.getInner().printName();
    }

    public Inner getInner() {
        return new Inner("Inner");
    }

    class Inner {
        private String name;

        Inner(String name) {
            this.name = name;
        }

        public void printName() {
            System.out.println(name);
        }
    }


}
