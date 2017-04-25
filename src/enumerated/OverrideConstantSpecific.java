package enumerated;

/**
 * Created by pfjia on 2017/4/25 0025.
 */


public enum OverrideConstantSpecific {

    NUT, BOLT, WASHER {
        @Override
        void f() {
            System.out.println("Overriden method");
        }
    };

    void f() {
        System.out.println("default behavior");
    }

    public static void main(String[] args) {
        for (OverrideConstantSpecific ocs : values()) {
            System.out.println(ocs + ": ");
            ocs.f();
        }
    }
}
