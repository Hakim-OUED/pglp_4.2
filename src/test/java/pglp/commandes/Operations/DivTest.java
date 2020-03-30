package pglp.commandes.Operations;

import org.junit.Test;
import pglp.Exceptions.DivisionParZeroException;

import static org.junit.Assert.assertTrue;

public class DivTest {
    @Test
    public void testDiv() throws DivisionParZeroException {
        Div div = new Div();
        assertTrue(div.execute(2.0,10.0) == 5);
    }
}
