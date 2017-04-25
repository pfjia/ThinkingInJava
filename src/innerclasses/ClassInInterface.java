package innerclasses;

/**
 * Created by pfjia on 2017/4/23 0023.
 */
public interface ClassInInterface {
    void howdy();

    class Test implements ClassInInterface {

        @Override
        public void howdy() {
            System.out.println("Howdy");
        }

        public static void main(String[] args) {
            new Test().howdy();
        }
    }
}
