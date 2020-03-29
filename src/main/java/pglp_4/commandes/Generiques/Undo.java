package pglp_4.commandes.Generiques;

import pglp_4.Exceptions.DivisionParZeroException;
import pglp_4.commandes.Commande;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.EmptyStackException;
import java.util.Stack;

public class Undo implements Commande {

   Stack<Stack<Double>> operandesHistorique = new Stack<>();

    Deque<Double> pile = new ArrayDeque<>();
    Deque<String> expCourante = new ArrayDeque<>();

    public Undo(){
         }

    public void majHitorique(Stack<Double> pileOperande, Deque<String> expCourante){

        //if (!operandesHistorique.empty()) System.out.println("historique actuel: " +operandesHistorique);

        this.operandesHistorique.push(pileOperande);
        this.expCourante=expCourante;

    }

    public Stack<Double> getLastOperandes(){
        //System.out.println(this.operandesHistorique);
        try {
            return (Stack<Double>) this.operandesHistorique.peek().clone();
        }catch (EmptyStackException e){System.out.println("L'historique est vide!!");}
        return null;
    }

    public Deque<String> getLastExpressions(){
        try {
            if (!operandesHistorique.empty()) return this.expCourante;
        }catch (EmptyStackException e){System.out.println("L'historique est vide!!"); }
        return null;
    }

    @Override
    public void execute() {
        this.operandesHistorique.pop();
        this.expCourante.pop();
        System.out.println("Undo effectué");

    }

    @Override
    public double execute(double op1, double op2) throws DivisionParZeroException {
        return 0;
    }
}
