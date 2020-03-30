package pglp.commandes.Operations;


import static org.junit.Assert.*;
import org.junit.Test;

public class PlusTest {
    @Test
    public void testAssition(){
        Plus plus = new Plus();
        assertTrue(plus.execute(1,1) == 2);
    }
}
