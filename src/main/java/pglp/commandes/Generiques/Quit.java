package pglp.commandes.Generiques;
/**
 * @since 16/03/2020
 * Classe de commande QUIT
 * @author Hakim OUED
 */

import pglp.commandes.Commande;

/**
 * Classe correspondant à la commande quit
 * implemente l'execution de la commande
 * @see Commande
 */
public class Quit implements Commande {

    @Override
    public void execute() {
        System.out.println("Fin de l'execution");
        System.exit(0);
    }

    @Override
    public double execute(double op1, double op2) {
        return 0;
    }
}
