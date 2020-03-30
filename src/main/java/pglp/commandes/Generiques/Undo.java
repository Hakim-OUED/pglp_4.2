package pglp.commandes.Generiques;

/**
 * @since 17/03/2020
 * Classe de commande Undo
 * @author Hakim OUED
 */

import pglp.Exceptions.DivisionParZeroException;
import pglp.commandes.Commande;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Classe correspondant à la commande quit
 * implemente l'execution de la commande
 * @see Commande
 */
public class Undo implements Commande {
    /**
     * pile contentant la pile des operandes,
     * i,e l'historique des Etats de la pile
     */
    private Stack<Stack<Double>> operandesHistorique = new Stack<>();
    /**
     * pile contenant l'expresssion courante
     */
    private Deque<String> expCourante = new ArrayDeque<>();

    /**
     * accesseur de l'historique
     * @return l'historique des commandes
     */
    public Stack<Stack<Double>> getOperandesHistorique() {
        return operandesHistorique;
    }

    /**
     * Constructeur de Undo
     */
    public Undo() {
         }

    /**
     * Met à jour l'historique des etats opérandes
     *   et l'expression Courante
     * @param pileOperande Etat actuelle de la pile d'opérande
     * @param expCourante Etat actuelle de la pile de
     *                     l'expression Courante
     */
    public void majHitorique(final Stack<Double> pileOperande,
                             final Deque<String> expCourante) {
         this.operandesHistorique.push(pileOperande);
        this.expCourante = expCourante;
    }

    /**
     *
     * @return le dernier etat de la pile d'opérande
     */
    public Stack<Double> getLastOperandes() {
            try {
            return (Stack<Double>) this.operandesHistorique.peek().clone();
        } catch (EmptyStackException e) {
            System.out.println("L'historique est vide!!");
        }
        return null;
    }

    /**
     *
     * @return le dernier Etat de la pile
     *  de l'expression courante
     */
    public Deque<String> getLastExpressions() {
        try {
            if (!operandesHistorique.empty()) {
                return this.expCourante;
            }
        } catch (EmptyStackException e) {
            System.out.println("L'historique est vide!!");
        }
        return null;
    }

    /**
     * execute la commmande
     */
    @Override
    public void execute() {
        this.operandesHistorique.pop();
        this.expCourante.pop();
        System.out.println("Undo effectué");
    }

    @Override
    public double execute(final double op1, final double op2)
            throws DivisionParZeroException {
        return 0;
    }
}
