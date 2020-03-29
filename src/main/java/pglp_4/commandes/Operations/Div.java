package pglp_4.commandes.Operations;

import pglp_4.Exceptions.DivisionParZeroException;

public class Div implements Operation {
    @Override
    public double eval(double op1, double op2) throws DivisionParZeroException {
        if(op1==0) throw new DivisionParZeroException();
        return op2 / op1;
    }

    @Override
    public char getSymbole() {
        return '/';
    }
}
