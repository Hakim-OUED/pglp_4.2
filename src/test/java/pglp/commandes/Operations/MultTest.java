package pglp.commandes.Operations;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class MultTest {
    @Test
    public void testMult() {
        Mult mult = new Mult();
        assertTrue(mult.execute(2,2) == 4);
    }
}
