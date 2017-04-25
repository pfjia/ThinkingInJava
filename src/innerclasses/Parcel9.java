package innerclasses;

/**
 * Created by pfjia on 2017/4/23 0023.
 */

/**
 * An anonymous inner class that performs initialization. A briefer version of Parcel5.java
 */
public class Parcel9 {

    public Destination destination(final String dest) {
        return new Destination() {
            private String label = dest;

            @Override
            public String readLabel() {
                return label;
            }
        };
    }

    public static void main(String[] args) {
        Parcel9 p = new Parcel9();
        Destination d = p.destination("Tasmania");
    }

}
