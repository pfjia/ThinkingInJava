package enumerated;

/**
 * Created by pfjia on 2017/4/24 0024.
 */
public class NonEnum {
    public static void main(String[] args) {
        Class<Integer> intClass = Integer.class;
        try {
            for (Object en : intClass.getEnumConstants()) {
                System.out.println(en);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
