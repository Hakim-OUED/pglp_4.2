package pglp.commandes.Operations;

import pglp.Exceptions.DivisionParZeroException;

public class Div implements Operation {
    /**
     *
     * @param op1
     *          opérande 1
     * @param op2
     *          opéeande 2
     * @return resultat de la division operande2 / opérande1
     * @throws DivisionParZeroException
     */
    @Override
    public double execute(final double op1, final double op2)
            throws DivisionParZeroException {
        if(op1 == 0) {
            throw new DivisionParZeroException();
        }
        return op2 / op1;
    }

    /**
     *
     * @return le symbole
     */
    @Override
    public String getSymbole() {
        return "/";
    }

    @Override
    public void execute() {

    }
}
