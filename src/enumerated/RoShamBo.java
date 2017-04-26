package enumerated;

import net.mindview.util.Enums;

/**
 * Created by pfjia on 2017/4/25 0025.
 */
public class RoShamBo {
    public static <T extends Competitor<T>> void match(T a, T b) {
        System.out.println(a + " VS " + b + " : " + a.compete(b));
    }

    public static <T extends Enum<T> & Competitor<T>> void play(Class<T> roShamBoClass, int size) {
        for (int i = 0; i < size; i++) {
            match(Enums.random(roShamBoClass), Enums.random(roShamBoClass));
        }
    }
}
