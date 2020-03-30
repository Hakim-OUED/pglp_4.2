package pglp;
/**
 * @since 17/03/2020
 * Classe SaisieRPN gère les saisies et
 * intéractions avec l'utilisateur
 */

import pglp.Exceptions.BorneSupInfException;
import pglp.Exceptions.OperationImpossibleException;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Gere les saisies et Interaction avec les Utilisateurs
 */
public class SaisieRPN {
    /**
     * Receuille les saisies au clavier
     */
   private BufferedReader entree = new BufferedReader(
           new InputStreamReader(System.in));
    /**
     * Intitalise un moteur
     * @see MoteurRPN
     */
   private MoteurRPN moteur = MoteurRPN.init();

    /**
     * Methode permettant la saisie et interactions
     * @throws IOException exception des entree clavier
     * @throws OperationImpossibleException
     *                      execption pas assez d'opérandes pour une operation
     */
    public void saisir() throws IOException,
            OperationImpossibleException {
        System.out.println("\n\t\t\t\t\t ******** "
                + "Entrez au clavier (un nombre, "
                + "un operateur ou une commande) ********");
        String saisie = entree.readLine();
        try {
                double x = Double.parseDouble(saisie);

                moteur.enregistrerOperande(x);
                moteur.getExpCourante();
                moteur.getOperandes();
        } catch (NumberFormatException e) {
            if (moteur.getCommandes().containsKey(saisie)) {
                if (!moteur.operationPossible()) {
                    throw new OperationImpossibleException();
                } else {
                    moteur.operer(saisie);
                    System.out.println(saisie);
                    moteur.getExpCourante();
                    moteur.getOperandes();
                }
            } else if (moteur.getInterpreteurGen().getCommandes()
                    .containsKey(saisie.toLowerCase())) {
                        moteur.getInterpreteurGen().interprete(saisie);
                        moteur.operandes = moteur.getUndo().getLastOperandes();
                        moteur.expCourante = moteur.getUndo()
                                .getLastExpressions();
                        moteur.getExpCourante();
                        moteur.getOperandes();
            }
        } catch (BorneSupInfException e) {
            System.out.println(e.getMessage() + "Min_Val : "
                +  moteur.getMinValue()
                    + " Max_Val : " + moteur.getMaxValue());
        }


    }

    /**
     *
     * @return le moteur initialisé
     */

    public MoteurRPN getMoteur() {
        return moteur;
    }
}
