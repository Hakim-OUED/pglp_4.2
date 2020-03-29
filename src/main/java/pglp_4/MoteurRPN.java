package pglp_4;

import pglp_4.commandes.Generiques.Undo;
import pglp_4.commandes.Interpreteur;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

import pglp_4.Exceptions.*;
import pglp_4.commandes.Operations.Div;
import pglp_4.commandes.Operations.Moins;
import pglp_4.commandes.Operations.Mult;
import pglp_4.commandes.Operations.Plus;

public class MoteurRPN extends Interpreteur {
    Deque<Double> operandes = new ArrayDeque<>();
    Deque<String> expCourante = new ArrayDeque<>();
    Undo undo = new Undo();
    //La plus petite valeur de la calculatrice quand ne peut pas depassé
    private static final double MIN_VALUE =-10000.0;


    //La plus grande valeur de la calculatrice quand ne peut pas depassé

    private static final double MAX_VALUE = 10000.0;


    public MoteurRPN(){
        Interpreteur.init(undo);
    }


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

    public static double getMaxValue() {
        return MAX_VALUE;
    }

    public static double getMinValue() {
        return MIN_VALUE;
    }

    public static MoteurRPN init(){
        MoteurRPN moteur = new MoteurRPN();
        Plus plus = new Plus();
        Moins moins = new Moins();
        Div div = new Div();
        Mult mult = new Mult();
        moteur.addCommand("+",plus);
        moteur.addCommand("-",moins);
        moteur.addCommand("/",div);
        moteur.addCommand("*",mult);
        return moteur;
    }
}
