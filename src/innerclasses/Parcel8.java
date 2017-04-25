package innerclasses;

/**
 * Created by pfjia on 2017/4/23 0023.
 */
public class Parcel8 {
    public Wrapping wrapping(int x) {
        // Base constructor call
        return new Wrapping(x) {
            // Pass constructor argument

            @Override
            public int value() {
                return super.value() * 47;
            }
        }; // Semicolon required
    }

    public static void main(String[] args) {
        Parcel8 p = new Parcel8();
        Wrapping w = p.wrapping(10);
    }
}
