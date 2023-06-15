import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class RandVoorwaardeTests {
    @Test
    public void TestBudgetTag() {
        Checks checks = new Checks();


        // Budget tot 1001
        Assert.assertEquals("klein", checks.projectTag(0));
        Assert.assertEquals("klein", checks.projectTag(1));
        Assert.assertEquals("klein", checks.projectTag(2));
        Assert.assertEquals("klein", checks.projectTag(999));
        Assert.assertEquals("klein", checks.projectTag(1000));

        // Budget 1001 tot 5000
        Assert.assertEquals("normaal", checks.projectTag(1001));
        Assert.assertEquals("normaal", checks.projectTag(1002));
        Assert.assertEquals("normaal", checks.projectTag(4999));

        // Vanaf 5000
        Assert.assertEquals("groot", checks.projectTag(5000));
        Assert.assertEquals("groot", checks.projectTag(5001));
    }
}