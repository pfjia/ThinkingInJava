package enumerated;

import java.util.Random;

/**
 * Created by pfjia on 2017/4/25 0025.
 */
interface Item {
    Outcome compete(Item item);

    Outcome eval(Paper paper);

    Outcome eval(Scissors scissors);

    Outcome eval(Rock r);
}

class Paper implements Item {
    @Override
    public Outcome compete(Item item) {
        return item.eval(this);
    }

    @Override
    public Outcome eval(Paper paper) {
        return Outcome.DRAW;
    }

    @Override
    public Outcome eval(Scissors scissors) {
        return Outcome.WIN;
    }

    @Override
    public Outcome eval(Rock r) {
        return Outcome.LOSE;
    }

    @Override
    public String toString() {
        return "Paper{}";
    }
}

class Scissors implements Item {
    @Override
    public Outcome compete(Item item) {
        return item.eval(this);
    }

    @Override
    public Outcome eval(Paper paper) {
        return Outcome.LOSE;
    }

    @Override
    public Outcome eval(Scissors scissors) {
        return Outcome.DRAW;
    }

    @Override
    public Outcome eval(Rock r) {
        return Outcome.WIN;
    }

    @Override
    public String toString() {
        return "Scissors{}";
    }
}


class Rock implements Item {
    @Override
    public Outcome compete(Item item) {
        return item.eval(this);
    }

    @Override
    public Outcome eval(Paper paper) {
        return Outcome.WIN;
    }

    @Override
    public Outcome eval(Scissors scissors) {
        return Outcome.LOSE;
    }

    @Override
    public Outcome eval(Rock r) {
        return Outcome.DRAW;
    }

    @Override
    public String toString() {
        return "Rock{}";
    }
}

public class RoShamBo1 {
    static final int SIZE = 20;
    private static Random rand = new Random(47);

    public static Item newItem() {
        switch (rand.nextInt(3)) {
            default:
            case 0:
                return new Scissors();
            case 1:
                return new Paper();
            case 2:
                return new Rock();
        }
    }

    public static void match(Item a, Item b) {
        System.out.println(a + " VS " + b + " : " + a.compete(b));
    }

    public static void main(String[] args) {
        for (int i = 0; i < SIZE; i++) {
            match(newItem(), newItem());
        }
    }
}
