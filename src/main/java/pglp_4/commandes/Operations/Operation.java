package pglp_4.commandes.Operations;

import pglp_4.Exceptions.DivisionParZeroException;
import pglp_4.commandes.Commande;

public interface Operation extends Commande {

    double eval(double op1,double op2) throws DivisionParZeroException;
    char getSymbole();
}
