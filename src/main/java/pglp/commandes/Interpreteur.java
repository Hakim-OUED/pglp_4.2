package pglp.commandes;
/**
 * @since 17/03/2020
 * interpreteur generique;
 * ne supporte que Undo et Quit
 * @author Hakim OUED
 */

import pglp.commandes.Generiques.Quit;
import pglp.commandes.Generiques.Undo;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class Interpreteur {

    /**
     * @since 17/03/2020
     * @return retourne l'ensemble des commandes
     */
    public Map<String, Commande> getCommandes() {
        return commandes;
    }

    /**
     * Attribut contenant les commandes
     */
    protected Map<String, Commande> commandes;

    /**
     * Constructeur
     */
    public Interpreteur() {
        commandes = new HashMap<String, Commande>();
    }

    /**
     * Ajoute une commande à l'interpreteur
     * @param nom le nom de la commande
     * @param commande la commande en question
     * @see Commande
     */
    public void addCommand(final String nom, final Commande commande) {
        commandes.put(nom.toLowerCase(), commande);
    }

    /**
     * Interprete la commande et l'execute
     * @param nom le nom de la commande
     */
    public void interprete(final String nom) {
        if (commandes.containsKey(nom.toLowerCase())) {
            try {
                commandes.get(nom.toLowerCase()).execute();
            } catch (Exception e) {
                System.out.println("L'execution de la commande"
                        + " n'a pas abouti! Veillez réessayé");
            }
        } else {
            System.out.println("Commande introuvable");
        }
    }

    /**
     * Intinitalise l'interpreteur generique
     * @param undo objet type Undo
     * @see Undo
     * @return un objet Interpreteur
     */
    public static Interpreteur init(final Undo undo) {
        Interpreteur interpreteur = new Interpreteur();
        Quit quit = new Quit();
        interpreteur.addCommand("undo", undo);
        interpreteur.addCommand("quit", quit);
        return interpreteur;
    }

}
