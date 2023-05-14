import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import java.time.LocalDate;

public class ProjectTest {
    @Test
    public void MCDCTest() {
        Main main = new Main();

        //Modified Condition/Decision Coverage
        //eind > start && klant && medewerker
        Assert.assertTrue(Checks.checkProject("2023-01-01", "2023-02-02", main.klanten, 1, main.medewerkers, 4));

        //start > end && klant && medewerker
        Assert.assertFalse(Checks.checkProject("2023-02-02", "2023-01-01", main.klanten, 1, main.medewerkers, 4));

        //start > end && klant && !medewerker
        Assert.assertFalse(Checks.checkProject("2023-02-02", "2023-01-01", main.klanten, 1, main.medewerkers, 400));

        //start > end && !klant && medewerker
        Assert.assertFalse(Checks.checkProject("2023-02-02", "2023-01-01", main.klanten, 1, main.medewerkers, 400));
    }
}