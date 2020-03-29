package pglp_4.Exceptions;
/*
 * 1 : Exception pour la division par zero
 */
public class DivisionParZeroException extends Exception {

    /**
     * Initialise une instance de <code>DivisionParZeroException</code>.
     */
    public DivisionParZeroException() {
        super("<------!!!! Impossible de divis� par Z�ro !!!!----->");
    }
}
