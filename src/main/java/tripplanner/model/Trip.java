package tripplanner.model;
import java.util.ArrayList;


public class Trip {

    private ArrayList<Country> countries = new ArrayList<>();
    private String travelStyle;

    public Trip(String travelStyle) {
        this.travelStyle = travelStyle;
    }

    public void addCountry(Country c) {
        countries.add(c);
    }

    public void removeCountry(String name) {
        countries.removeIf(c -> c.getName().equalsIgnoreCase(name));
    }

    public ArrayList<Country> getCountries() {
        return countries;
    }

    public void clearCountries() {
        countries.clear();
    }

    public double calculateTotalCost(int daysPerCountry) {
        double multiplier = switch (travelStyle) {
            case "budget" -> 0.8;
            case "luxury" -> 1.5;
            default -> 1.0;
        };

            double total = 0;
            for (Country c : countries) {
                total += c.getCostPerDay() * daysPerCountry * multiplier;
            }
            return total;
        }

        @Override
        public String toString() {
            return "Trip with " + countries.size() + " countries, style: " + travelStyle;
        }
    }


