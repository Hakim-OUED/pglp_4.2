package pglp.Exceptions;

/**
 * @since 20/03/2019
 * Exceptions pour la division par zero
 * @author Hakim OUED
 */
public class DivisionParZeroException extends Exception {

    /**
     * Initialise une instance de <code>DivisionParZeroException</code>.
     */
    public DivisionParZeroException() {
        super("<------!!!! Impossible de division par Zéro !!!!----->");
    }
}
