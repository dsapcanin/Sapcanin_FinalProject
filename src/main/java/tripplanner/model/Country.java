package tripplanner.model;

    public abstract class Country {

        protected String name;
        protected double costPerDay;
        protected String[] funFacts;

        public Country(String name, double costPerDay, String[] funFacts) {
            this.name = name;
            this.costPerDay = costPerDay;
            this.funFacts = funFacts;
        }

        public String getName() {
            return name;
        }

        public double getCostPerDay() {
            return costPerDay;
        }

        public String getFunFact() {
            int index = (int) (Math.random() * funFacts.length);
            return funFacts[index];
        }

        @Override
        public String toString() {
            return name + " ($" + costPerDay + "/day)";
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Country)) return false;
            Country other = (Country) obj;
            return this.name.equalsIgnoreCase(other.name);
        }

        @Override
        public int hashCode() {
            return name.toLowerCase().hashCode();
        }
    }




