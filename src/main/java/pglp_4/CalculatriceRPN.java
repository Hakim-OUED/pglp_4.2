package pglp_4;

import pglp_4.Exceptions.DivisionParZeroException;
import pglp_4.Exceptions.OperationImpossibleException;

import java.io.IOException;

public enum CalculatriceRPN {
    CALCULATRICE;


    public static void run(String args[]) throws IOException {

        SaisieRPN saisi = new SaisieRPN();
        while (true) {
            try {
                saisi.saisir();
            } catch (DivisionParZeroException e) {
                System.out.println(e.getMessage());
            } catch (OperationImpossibleException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) throws IOException {
        CALCULATRICE.run(args);
    }
}


