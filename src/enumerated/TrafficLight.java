package enumerated;


/**
 * Created by pfjia on 2017/4/24 0024.
 */

// Enums in switch statements

// Define an enum type


public class TrafficLight {
    Signal color = Signal.RED;

    public void change() {
        switch (color) {
            // Note that you don't have to say Signal.Red in the case statement
            case RED:
                color = Signal.GREEN;
                break;
            case GREEN:
                color = Signal.YELLOW;
                break;
            case YELLOW:
                color = Signal.RED;
                break;
        }
    }

    @Override
    public String toString() {
        return "TrafficLight{" +
            "color=" + color +
            '}';
    }

    public static void main(String[] args) {
        TrafficLight t = new TrafficLight();
        for (int i = 0; i < 7; i++) {
            System.out.println(t);
            t.change();
        }
    }
}
