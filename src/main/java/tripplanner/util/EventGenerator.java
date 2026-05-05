package tripplanner.util;

public class EventGenerator {

    private static final String[] EVENTS = {
            "You found a hidden cafe!",
            "You discovered something amazing by getting lost!",
            "You met some locals.",
            "You tried some new food."
    };

    public static String getRandomEvents() {
        int index = (int) (Math.random() * EVENTS.length);
        return EVENTS[index];


    }

}
