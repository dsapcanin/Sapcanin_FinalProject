package tripplanner.tests;

import org.junit.Test;
import tripplanner.model.*;

import static org.junit.Assert.*;

public class TripTests {

    @Test
    public void testCostCalculation() {
        Trip t = new Trip("standard");
        t.addCountry(new Bosnia());
        t.addCountry(new Italy());

        double cost = t.calculateTotalCost(2);

        assertTrue(cost > 0);
    }

    @Test
    public void testAddCountry() {
        Trip t = new Trip("standard");
        t.addCountry(new France());

        assertEquals(1, t.getCountries().size());
    }

    @Test
    public void testRemoveCountry() {
        Trip t = new Trip("standard");
        t.addCountry(new Bosnia());
        t.removeCountry("Bosnia");

        assertEquals(0, t.getCountries().size());
    }
}
