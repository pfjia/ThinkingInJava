package enumerated;

/**
 * Created by pfjia on 2017/4/25 0025.
 */
enum LikeClasses {
    WINKEN {
        @Override
        void behavior() {
            System.out.println("Behavior1");
        }
    }, BLINKEN {
        @Override
        void behavior() {
            System.out.println("Behavior2");
        }
    }, NOD {
        @Override
        void behavior() {
            System.out.println("Behavior3");
        }
    };

    abstract void behavior();
}

public class NotClasses {
//    void f1(LikeClasses.WINKEN instance) {
//
//    }
//
//    public static void main(String[] args) {
//        new NotClasses().f1();
//    }
}
