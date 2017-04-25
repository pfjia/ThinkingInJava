package innerclasses;

/**
 * Created by pfjia on 2017/4/24 0024.
 */

class WithInner {

    public WithInner() {
    }

    class Inner {
        public Inner() {
        }
    }
}

public class InheritInner extends WithInner.Inner {
    public InheritInner(WithInner withInner) {
        withInner.super();
    }

    public static void main(String[] args) {
        WithInner wi = new WithInner();
        InheritInner ii = new InheritInner(wi);
    }
}
