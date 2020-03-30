package pglp.commandes.Operations;

public class Moins implements Operation {
    /**
     *
     * @param op1
     *          opérande 1
     * @param op2
     *          opéeande 2
     * @return resultat de la soustraction operande2 - opérande1
     */
    @Override
    public double execute(final double op1, final double op2) {
        return op2 - op1;
    }

    /**
     *
     * @return symbole
     */
    @Override
    public String getSymbole() {
        return "-";
    }

    @Override
    public void execute() {

    }
}
