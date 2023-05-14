import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class PairwiseTests {

    @Test
    public void PairwiseTests() {
        Main main  = new Main();
        // Geen project - Kleiner dan 0, geldige datum, bestaat, bestaat
        Assert.assertFalse(Checks.projectCheck(-1, "2023-05-13", "2023-05-20", 4, main.medewerkers, 1, main.klanten));

        // Geen project - Kleiner dan 0, ongeldige datum, bestaat niet, bestaat niet
        Assert.assertFalse(Checks.projectCheck(-1, "2023-05-30", "2023-05-20", 4, main.medewerkers, 1, main.klanten));

        // Geen project - Gelijk aan 0, geldige datum, bestaat niet, bestaat niet
        Assert.assertFalse(Checks.projectCheck(0, "2023-05-13", "2023-05-20", 10, main.medewerkers, 5, main.klanten));

        // Geen project - Gelijk aan 0, ongeldige datum, bestaat, bestaat
        Assert.assertFalse(Checks.projectCheck(0, "2023-05-30", "2023-05-20", 4, main.medewerkers, 1, main.klanten));

        // Project aanmaken - Groter dan 0, geldige datum, bestaat, bestaat
        Assert.assertTrue(Checks.projectCheck(1000, "2023-05-13", "2023-05-20", 4, main.medewerkers, 1, main.klanten));

        // Geen project - Groter dan 0, ongeldige datum, bestaat niet, bestaat niet
        Assert.assertFalse(Checks.projectCheck(1000, "2023-05-30", "2023-05-20", 10, main.medewerkers, 5, main.klanten));
    }
}
