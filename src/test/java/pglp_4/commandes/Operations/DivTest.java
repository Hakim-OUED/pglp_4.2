package pglp_4.commandes.Operations;

import org.junit.Test;
import pglp_4.Exceptions.DivisionParZeroException;

import static org.junit.Assert.assertTrue;

public class DivTest {
    @Test
    public void testDiv() throws DivisionParZeroException {
        Div div = new Div();
        assertTrue(div.execute(10.0,2.0) == 5);
    }
}
