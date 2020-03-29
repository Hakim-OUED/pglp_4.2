package pglp_4;

import pglp_4.commandes.Interpreteur;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

import pglp_4.Exceptions.*;

public class MoteurRPN extends Interpreteur {
    Deque<Double> operandes = new ArrayDeque<>();
    Deque<String> expCourante = new ArrayDeque<>();

    //La plus petite valeur de la calculatrice quand ne peut pas depassé
    private static final double MIN_VALUE =-10000.0;


    //La plus grande valeur de la calculatrice quand ne peut pas depassé

    private static final double MAX_VALUE = 10000.0;

    public void enregistrerOperande(double x) throws BorneSupInfException {

        if(Math.abs(x)>MAX_VALUE) throw new BorneSupInfException();
        operandes.push(x);
        expCourante.push(String.valueOf(x));
    }

    public Deque<String> getExpCourante() {

        System.out.println("\n Expression Courante: \n");
        for (Iterator<String> it = expCourante.descendingIterator(); it.hasNext(); ) {
            String i = it.next();

            System.out.print(i + ' ');
        }
        return expCourante;
    }

    public Deque<Double> getOperandes() {

        System.out.println("\n\n CONTENUE DE LA PILE des op�randes:\n");
        for (double i:operandes
        ) {

            System.out.println("\t" + i);
        }
        return operandes;
    }

}
