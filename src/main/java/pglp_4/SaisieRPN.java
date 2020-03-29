package pglp_4;

import pglp_4.Exceptions.BorneSupInfException;
import pglp_4.Exceptions.DivisionParZeroException;
import pglp_4.Exceptions.OperationImpossibleException;
import pglp_4.commandes.Interpreteur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class SaisieRPN {
    Scanner sc = new Scanner(System.in);
    BufferedReader entree = new BufferedReader(new InputStreamReader(System.in));
    MoteurRPN moteur = MoteurRPN.init();



    public void saisir() throws IOException, DivisionParZeroException, OperationImpossibleException {
        System.out.println("\n\t\t\t\t\t ******** Entrez au clavier (un nombre, un operateur ou exit) ********");
        String saisie = entree.readLine();
        try {
                double x = Double.parseDouble(saisie);

                moteur.enregistrerOperande(x);
                moteur.getExpCourante();
                moteur.getOperandes();
        }catch (NumberFormatException e){
            if (moteur.getCommandes().containsKey(saisie)){
                if (moteur.operandes.size()<2) throw new OperationImpossibleException();
                else {
                    moteur.operer(saisie);
                    System.out.println(saisie);
                    moteur.getExpCourante();
                    moteur.getOperandes();
                }
            }else if (moteur.interpreteurGen.getCommandes().containsKey(saisie.toLowerCase())){
                moteur.interpreteurGen.interprete(saisie);
                moteur.operandes=moteur.undo.getLastOperandes();
                moteur.expCourante=moteur.undo.getLastExpressions();
                moteur.getExpCourante();
                moteur.getOperandes();
            }
        } catch (BorneSupInfException e) {System.out.println(e.getMessage() + "Min_Val : "
                +  moteur.getMinValue() + " Max_Val : " + moteur.getMaxValue() );}


    }
}
