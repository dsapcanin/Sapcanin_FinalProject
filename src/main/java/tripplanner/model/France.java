package tripplanner.model;

 public class France extends Country {

     private static final String[] FACTS = {
             "France is the most visited country in the world.",
             "The Eiffel Tower was built in 1889.",
             "France is famous for its cuisine."
        };

        public France() {
            super("France", 180, FACTS);
        }
    }


