package pglp_4.commandes.Operations;


import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Test;

public class PlusTest {
    @Test
    public void testAssition(){
        Plus plus = new Plus();
        assertTrue(plus.execute(1,1) == 2);
    }
}
