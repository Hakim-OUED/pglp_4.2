package pglp;
/**
 * @since 17/03/2020
 * Classe Moteur de la caltulatrice
 * @author Hakim OUED
 */

import pglp.commandes.Generiques.Undo;
import pglp.commandes.Interpreteur;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Stack;
import java.util.NoSuchElementException;
import java.util.Map;
import pglp.Exceptions.DivisionParZeroException;
import pglp.Exceptions.BorneSupInfException;
import pglp.commandes.Operations.Div;
import pglp.commandes.Operations.Moins;
import pglp.commandes.Operations.Mult;
import pglp.commandes.Operations.Plus;

/**
 * Moteur de la Calculatrice
 * initialise l'interpreteur et execute les commandes
 */
public class MoteurRPN extends Interpreteur {
    /**
     * l'etat actuel de la pile des opérandes
     */
    protected Stack<Double> operandes = new Stack<>();
    /**
     * l'etat actuel de la pile de l'expression courante
     * ex: 134+/
     */
    protected Deque<String> expCourante = new ArrayDeque<>();

    public Interpreteur getInterpreteurGen() {
        return interpreteurGen;
    }

    public Undo getUndo() {
        return undo;
    }

    /**
     * Interpreteur Generique
     * @see Interpreteur
     */
    private Interpreteur interpreteurGen;
    /**
     * Objet de la commande Undo
     * @see Undo
     */
    private Undo undo = new Undo();

    /**
     * La plus petite valeur de la calculatrice quand ne peut pas depassé
     */
    private static final double MIN_VALUE = -10000.0;


    /**
     * La plus grande valeur de la calculatrice quand ne peut pas depassé
     */
    private static final double MAX_VALUE = 10000.0;

    /**
     * Constructeur de la classe MoteurRPN
     */
    public MoteurRPN() {
        this.interpreteurGen = Interpreteur.init(undo);
    }

    /**
     * Enregistre une saisie d'opérande dans la pile
     * @param x l'opérande saisie
     * @throws BorneSupInfException Exceptions pour s'assurer que
     *                          les bornes sont repectés
     */
    public void enregistrerOperande(final double x)
            throws BorneSupInfException {
        if (Math.abs(x) > MAX_VALUE) {
            throw new BorneSupInfException();
        }
        operandes.push(x);
        Stack<Double> d = (Stack<Double>) operandes.clone();
        expCourante.push(String.valueOf(x));
        undo.majHitorique(d, expCourante);
    }

    /**
     *
     * @return l'expression courante; Ex: 235-*
     */
    public Deque<String> getExpCourante() {
        System.out.println("\n Expression Courante: \n");
        for (Iterator<String> it = expCourante.descendingIterator();
             it.hasNext();) {
            String i = it.next();
            System.out.print(i + ' ');
        }
        return expCourante;
    }

    /**
     *
     * @return la pile actuelle des opérandes
     */
    public Stack<Double> getOperandes() {

        System.out.println("\n\n CONTENUE DE LA PILE des opérandes:\n");
        for (double i:operandes) {
            System.out.println("\t" + i);
        }
        return operandes;
    }

    /**
     *
     * @return Valeur max supportée
     */
    public static double getMaxValue() {
        return MAX_VALUE;
    }

    /**
     *
     * @return Valeur min supportée
     */
    public static double getMinValue() {
        return MIN_VALUE;
    }

    /**
     * Initialise le moteur avec les différentes opérations
     * @see pglp.commandes.Operations.Operation
     * @return un objet MoteurRPPN
     */
    public static MoteurRPN init() {
        MoteurRPN moteur = new MoteurRPN();
        Plus plus = new Plus();
        Moins moins = new Moins();
        Div div = new Div();
        Mult mult = new Mult();
        moteur.addCommand("+", plus);
        moteur.addCommand("-", moins);
        moteur.addCommand("/", div);
        moteur.addCommand("*", mult);

        return moteur;
    }

    /**
     * Interprete et execute une opération
     * @param nom nom de l'opération
     * @return le résultat
     * @throws DivisionParZeroException
     */
    public double operer(final String nom) {
        Double resultat = -1.0;
        if (this.commandes.containsKey(nom.toLowerCase())) {
            double op1, op2;
            op1 = operandes.pop();
            op2 = operandes.pop();
            try {
                resultat = commandes.get(nom).execute(op1, op2);
                if (resultat.isInfinite()) {
                    operandes.push(op2);
                    operandes.push(op1);
                } else {
                    operandes.push(resultat);
                    expCourante.push(nom);
                    undo.majHitorique(operandes, expCourante);
                }
            } catch (NoSuchElementException  e) {
                System.out.println("La pile est vide!! "
                        + "Vous de pouvez pas faire "
                        + "d'operation sans operandes");
            } catch (DivisionParZeroException e) {
                operandes.push(op2);
                operandes.push(op1);
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("L'execution de la commande "
                        + "n'a pas abouti! Veillez réessayé");
            }
        } else {
            System.out.println("Commande introuvable");
        }
        return resultat;
    }

    /**
     *
     * @return la liste des commandes
     */
    public Map getCommandes() {
        return this.commandes;
    }

    /**
     * @return resultat si la pile contient assez
     * d'elemeent pour une opération
     */
    public boolean operationPossible() {
        return operandes.size() >= 2;
    }
}
