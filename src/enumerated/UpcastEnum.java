package enumerated;

/**
 * Created by pfjia on 2017/4/24 0024.
 */
enum Search {
    HITHER, YON
}

public class UpcastEnum {
    public static void main(String[] args) {
        Search[] vals = Search.values();
        Enum e = Search.HITHER;// Upcast
//        e.values(); // No vlues() in Enum
        for (Enum en : e.getClass().getEnumConstants()) {
            System.out.println(en);
        }
    }
}
