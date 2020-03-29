package pglp_4.commandes.Operations;

public class Plus implements Operation{

    @Override
    public double eval(double op1, double op2) {
        return op1 + op2;
    }

    @Override
    public char getSymbole() {
        return '+';
    }
}
