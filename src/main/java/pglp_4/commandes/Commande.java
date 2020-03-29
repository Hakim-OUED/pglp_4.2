package pglp_4.commandes;

import pglp_4.Exceptions.DivisionParZeroException;

public interface Commande {
    void execute();
    double execute(double op1,double op2) throws DivisionParZeroException;

}
