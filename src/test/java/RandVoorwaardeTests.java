import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class RandVoorwaardeTests {
    @Test
    public void TestBudgetTag() {
        // Budget tot 1001
        Assert.assertEquals("klein", Checks.projectTag(0));
        Assert.assertEquals("klein", Checks.projectTag(1));
        Assert.assertEquals("klein", Checks.projectTag(2));
        Assert.assertEquals("klein", Checks.projectTag(999));
        Assert.assertEquals("klein", Checks.projectTag(1000));

        // Budget 1001 tot 5000
        Assert.assertEquals("normaal", Checks.projectTag(1001));
        Assert.assertEquals("normaal", Checks.projectTag(1002));
        Assert.assertEquals("normaal", Checks.projectTag(4999));

        // Vanaf 5000
        Assert.assertEquals("groot", Checks.projectTag(5000));
        Assert.assertEquals("groot", Checks.projectTag(5001));
    }
}