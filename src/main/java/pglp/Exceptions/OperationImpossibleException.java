package pglp.Exceptions;

/**
 *  @since 18/03/2019
 * Exception pour les opération non réalisable
 * @author Hakim OUED
 */
public class OperationImpossibleException extends Exception {

    /**
     * Initialise une instance de <code>OperationImpossibleException</code>.
     */
    public OperationImpossibleException() {
        super("<------!!!! Opération Impossible !!!!"
                + " Il y a moins de deux opérandes dans la pile");
    }
}
