package tripplanner.model;


public class Italy extends Country {

    private static final String[] FACTS = {
            "Italy is home to the Colosseum.",
            "Pizza originated in Naples.",
            "Italy has more UNESCO sites than any country."
        };

    public Italy() {
            super("Italy", 150, FACTS);
    }
}

