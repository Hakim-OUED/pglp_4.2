package pglp_4.commandes.Operations;

public class Moins implements Operation {
    @Override
    public double eval(double op1, double op2) {
        return op2 - op1;
    }

    @Override
    public char getSymbole() {
        return '-';
    }

    @Override
    public void execute() {

    }
}
