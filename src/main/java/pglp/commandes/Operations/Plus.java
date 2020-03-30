package pglp.commandes.Operations;

public class Plus implements Operation {
    /**
     *
     * @param op1
     *          opérande 1
     * @param op2
     *          opéeande 2
     * @return resultat de la division operande2 + opérande1
     */
    @Override
    public double execute(final double op1, final double op2) {
        return op1 + op2;
    }

    /**
     *
     * @return le symbole
     */
    @Override
    public String getSymbole() {
        return "+";
    }


    @Override
    public void execute() {

    }
}
