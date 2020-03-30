package pglp.Exceptions;

/**
 * @since 20/03/2019
 * Classe d'exception Bornes Supérieure et Inféfieure
 * @author Hakim OUED
 */
public class BorneSupInfException extends Exception {
    /**
     * Initialise une instance de <code>BorneSupInfException</code>.
     */
    public BorneSupInfException() {
        super("<------!!!! Opérande non située"
                + "entre les bornes de la calculatrice :");
    }
}
