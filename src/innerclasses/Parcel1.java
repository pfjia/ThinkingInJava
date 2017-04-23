package innerclasses;

public class Parcel1 {
    public static void main(String[] args) {
        Parcel1 p = new Parcel1();
        p.ship("Tasmania");
    }

    /**
     * Using inner classes looks just like using any other class,within Parcel1
     *
     * @param dest
     */
    public void ship(String dest) {
        Contents c = new Contents();
        Destination d = new Destination(dest);
        System.out.println(d.readLabel());
    }

    class Contents {
        private int i = 11;

        public int value() {
            return i;
        }
    }

    class Destination {
        private String label;

        Destination(String whereTo) {
            // TODO Auto-generated constructor stub
            label = whereTo;
        }

        String readLabel() {
            return label;
        }
    }
}
