package innerclasses;

class Parcel4 {
    public Destination destination(String s) {
        return new PDestination(s);
    }

    public Contents contents() {
        return new PContents();
    }

    private class PContents implements Contents {
        private int i = 11;

        @Override
        public int value() {
            // TODO Auto-generated method stub
            return i;
        }
    }

    protected class PDestination implements Destination {
        private String label;

        private PDestination(String whereTo) {
            // TODO Auto-generated constructor stub
            label = whereTo;
        }

        @Override
        public String readLabel() {
            // TODO Auto-generated method stub
            return label;
        }

    }
}

class TestParcel {
    public static void main(String[] args) {
        Parcel4 p = new Parcel4();
        Contents c = p.contents();
        Destination d = p.destination("Tasmania");
        System.out.println(c.value());

    }

}
