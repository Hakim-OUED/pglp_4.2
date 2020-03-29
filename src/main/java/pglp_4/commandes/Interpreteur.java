package pglp_4.commandes;

import pglp_4.commandes.Generiques.Quit;
import pglp_4.commandes.Generiques.Undo;

import java.util.HashMap;
import java.util.Map;

public class Interpreteur {

    private Map<String, Commande> commandes;

    public Interpreteur() {
        commandes = new HashMap<String, Commande>();
    }

    public void addCommand (String nom, Commande commande){
        this.commandes.put(nom.toLowerCase(),commande);
    }

    public void interprete(String nom){
        if (this.commandes.containsKey(nom.toLowerCase())){
            try{
                commandes.get(nom).execute();
            }catch (Exception e) {System.out.println("L'execution de la commande n'a pas abouti! Veillez réessayé");}
        }else{
            System.out.println("Commande introuvable");
        }
    }

    public static Interpreteur init(Undo undo){
        Interpreteur interpreteur = new Interpreteur();
        Quit quit = new Quit();
        interpreteur.addCommand("undo",undo);
        interpreteur.addCommand("quit",quit);
        return interpreteur;
    }

}
