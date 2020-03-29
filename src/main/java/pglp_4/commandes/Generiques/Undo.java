package pglp_4.commandes.Generiques;

import pglp_4.Exceptions.DivisionParZeroException;
import pglp_4.commandes.Commande;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Undo implements Commande {

   Stack<Deque<Double>> operandesHistorique = new Stack<>();
    Deque<String> expCourante = new ArrayDeque<>();

    public Undo(){
         }

    public void majHitorique(Deque<Double> pileOperande, Deque<String> expCourante){
        this.expCourante=expCourante;
        this.operandesHistorique.push(pileOperande);
    }

    public Deque<Double> getLastOperandes(){
        System.out.println(this.operandesHistorique);
        return this.operandesHistorique.lastElement();
    }

    public Deque<String> getLastExpressions(){
        return this.expCourante;
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
