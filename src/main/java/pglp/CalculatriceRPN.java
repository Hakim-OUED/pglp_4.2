package pglp;
/**
 * @since 17/03/2020
 *  Classe principale du programme
 * @author Hakim OUED
 */

import pglp.Exceptions.DivisionParZeroException;
import pglp.Exceptions.OperationImpossibleException;

import java.io.IOException;

/**
 * Classe principale contient la methode main
 */
public enum CalculatriceRPN {
    CALCULATRICE;

    /**
     * Execute le programme
     * @param args ensemble d'arguments
     * @throws IOException Exception des saisies
     */
    public static void run(final String args[]) throws IOException {

        SaisieRPN saisi = new SaisieRPN();
        while (true) {
            try {
                saisi.saisir();
            } catch (OperationImpossibleException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Lance l'execution
     * @param args arguments
     * @throws IOException erreur de saisie
     */
    public static void main(final String[] args) throws IOException {
        CALCULATRICE.run(args);
    }
}


