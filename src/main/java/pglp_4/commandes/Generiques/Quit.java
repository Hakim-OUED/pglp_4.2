package pglp_4.commandes.Generiques;

import pglp_4.commandes.Commande;

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
