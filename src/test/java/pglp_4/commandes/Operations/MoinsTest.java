package pglp_4.commandes.Operations;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class MoinsTest {
    @Test
    public void testMoins(){
        Moins moins = new Moins();
        assertTrue(moins.execute(2,5) == 3);
    }
}
