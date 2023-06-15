import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import java.time.LocalDate;

public class MCDC {
    @Test
    public void MCDCTest() {
        Checks checks = new Checks();
        Main main = new Main();

        //Modified Condition/Decision Coverage
        //start < eind && klant && medewerker
        Assert.assertTrue(checks.checkProject("2023-01-01", "2023-02-02", main.klanten, 1, main.medewerkers, 4));

        //start > end && klant && medewerker
        Assert.assertFalse(checks.checkProject("2023-02-02", "2023-01-01", main.klanten, 1, main.medewerkers, 4));

        //start < end && !klant && medewerker
        Assert.assertFalse(checks.checkProject("2023-01-01", "2023-02-02", main.klanten, 100, main.medewerkers, 4));

        //start < end && klant && !medewerker
        Assert.assertFalse(checks.checkProject("2023-01-01", "2023-02-02", main.klanten, 1, main.medewerkers, 400));
    }
}