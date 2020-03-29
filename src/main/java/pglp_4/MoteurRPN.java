package pglp_4;

import pglp_4.commandes.Commande;
import pglp_4.commandes.Generiques.Undo;
import pglp_4.commandes.Interpreteur;

import java.util.*;

import pglp_4.Exceptions.*;
import pglp_4.commandes.Operations.*;

public class MoteurRPN extends Interpreteur {
    Stack<Double> operandes = new Stack<>();
    Deque<String> expCourante = new ArrayDeque<>();
    //protected Map<String, Operation> commandes;
    Interpreteur interpreteurGen;
    Undo undo = new Undo();

    //La plus petite valeur de la calculatrice quand ne peut pas depassé
    private static final double MIN_VALUE =-10000.0;


    //La plus grande valeur de la calculatrice quand ne peut pas depassé
    private static final double MAX_VALUE = 10000.0;


    public MoteurRPN(){
        this.interpreteurGen=Interpreteur.init(undo);
    }


    public void enregistrerOperande(double x) throws BorneSupInfException {

        if(Math.abs(x)>MAX_VALUE) throw new BorneSupInfException();

        operandes.push(x);
        Stack<Double> d= (Stack<Double>) operandes.clone();
        expCourante.push(String.valueOf(x));

       undo.majHitorique(d,expCourante);
    }

    public Deque<String> getExpCourante() {
        System.out.println("\n Expression Courante: \n");
        for (Iterator<String> it = expCourante.descendingIterator(); it.hasNext(); ) {
            String i = it.next();

            System.out.print(i + ' ');
        }
        return expCourante;
    }

    public Stack<Double> getOperandes() {

        System.out.println("\n\n CONTENUE DE LA PILE des opérandes:\n");
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

    public double operer (String nom)  throws DivisionParZeroException {
        Double resultat = -1.0;
        if (this.commandes.containsKey(nom.toLowerCase())){
            double op1,op2;
            op1=operandes.pop();
            op2=operandes.pop();
            try{

                resultat = commandes.get(nom).execute(op1,op2);
                if (resultat.isInfinite()) {
                    operandes.push(op2);
                    operandes.push(op1);
                } else {
                    operandes.push(resultat);
                    expCourante.push(nom);
                    undo.majHitorique(operandes,expCourante);
                }
            }catch (NoSuchElementException  e) {
                System.out.println("La pile est vide!! Vous de pouvez pas faire d'operation sans operandes");
            }
            catch (DivisionParZeroException e){
                operandes.push(op2);
                operandes.push(op1);
                System.out.println(e.getMessage());

            }catch (Exception e) {System.out.println("L'execution de la commande n'a pas abouti! Veillez réessayé");}

        }else{
            System.out.println("Commande introuvable");

        }
        return resultat;

    }
    public Map getCommandes(){
        return this.commandes;
    }


    public boolean operationPossible(){
        if(operandes.size()>=2) return true;
        else return false;
    }
}
