package enumerated;

/**
 * Created by pfjia on 2017/4/24 0024.
 */

enum Shrubery {
    GROUND, CRAWLING, HANGING
}

public class EnumClass {
    public static void main(String[] args) {
        for (Shrubery s : Shrubery.values()) {
            System.out.println(s + " ordinal: " + s.ordinal());
            System.out.print(s.compareTo(Shrubery.CRAWLING) + " ");
            System.out.print(s.equals(Shrubery.CRAWLING) + " ");
            System.out.println(s == Shrubery.CRAWLING);
            System.out.println(s.getDeclaringClass());
            System.out.println(s.name());
            System.out.println("-------------------");
        }

        for (String s : "HANGING CRAWLING GROUND".split(" ")) {
            Shrubery shrubery = Enum.valueOf(Shrubery.class, s);
            System.out.println(shrubery);
        }
    }
}
