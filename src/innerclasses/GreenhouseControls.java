package innerclasses;

import innerclasses.controller.Controller;
import innerclasses.controller.Event;

import java.util.Arrays;

/**
 * Created by pfjia on 2017/4/24 0024.
 */
public class GreenhouseControls extends Controller {
    private boolean light = false;

    public class LightOn extends Event {
        @Override
        public String toString() {
            return "LightOn{}";
        }

        public LightOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            light = true;
        }
    }

    public class LightOff extends Event {
        @Override
        public String toString() {
            return "LightOff{}";
        }

        @Override
        public void action() {
            light = false;
        }

        public LightOff(long delayTime) {
            super(delayTime);
        }
    }

    private boolean water = false;

    public class WaterOn extends Event {
        @Override
        public String toString() {
            return "WaterOn{}";
        }

        @Override
        public void action() {
            water = true;
        }

        public WaterOn(long delayTime) {
            super(delayTime);
        }
    }

    public class WaterOff extends Event {
        @Override
        public void action() {
            water = false;
        }

        @Override
        public String toString() {
            return "WaterOff{}";
        }

        public WaterOff(long delayTime) {
            super(delayTime);
        }
    }

    private String thermostat = "Day";

    public class ThermostatNight extends Event {
        @Override
        public String toString() {
            return "ThermostatNight{}";
        }

        public ThermostatNight(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            thermostat = "Night";
        }
    }

    public class ThermostatDay extends Event {
        @Override
        public void action() {
            thermostat = "Day";
        }

        @Override
        public String toString() {
            return "ThermostatDay{}";
        }

        public ThermostatDay(long delayTime) {
            super(delayTime);
        }
    }

    public class Bell extends Event {

        public Bell(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            addEvent(new Bell(delayTime));
        }

        @Override
        public String toString() {
            return "Bell{}";
        }
    }

    public class Restart extends Event {
        private Event[] eventList;

        public Restart(long delayTime, Event[] eventList) {
            super(delayTime);
            this.eventList = eventList;
            for (Event e : eventList) {
                addEvent(e);
            }
        }

        @Override
        public void action() {
            for (Event e : eventList) {
                e.start();
                addEvent(e);
            }
            start();
            addEvent(this);
        }

        @Override
        public String toString() {
            return "Restart{" +
                "eventList=" + Arrays.toString(eventList) +
                '}';
        }
    }

    public static class Terminate extends Event {
        @Override
        public String toString() {
            return "Terminate{}";
        }

        @Override
        public void action() {
            System.exit(0);
        }

        public Terminate(long delayTime) {
            super(delayTime);
        }
    }
}
