package tripplanner.tests;

import org.junit.Test;
import tripplanner.model.*;

import static org.junit.Assert.*;

public class CountryTests {

    @Test
    public void testFunFactNotNull() {
        Country c = new Italy();
        assertNotNull(c.getFunFact());
    }

    @Test
    public void testEquals() {
        Country a = new France();
        Country b = new France();

        assertEquals(a, b);
    }

    @Test
    public void testToString() {
        Country c = new Bosnia();
        String result = c.toString();

        assertTrue(result.contains("Bosnia"));
    }
}
