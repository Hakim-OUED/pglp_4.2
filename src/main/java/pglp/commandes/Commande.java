package pglp.commandes;
/**
 * @since 17/03/2020
 * Interface des Commandes
 * @author Hakim OUED
 */

import pglp.Exceptions.DivisionParZeroException;

public interface Commande {
    /**
     * Execute une commande
     */
    void execute();

    /**
     *Execute une Commande opération
     *
     * @param op1
     *          opérande 1
     * @param op2
     *          opéeande 2
     * @return le resultat de de l'operation
     * @throws DivisionParZeroException Si une division par zero
     */
    double execute(double op1, double op2) throws DivisionParZeroException;
}
