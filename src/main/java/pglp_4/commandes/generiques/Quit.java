package pglp_4.commandes.generiques;

public class Quit implements CommandeGenerique {

    @Override
    public void execute() {
        System.out.println("Fin de l'execution");
        System.exit(0);
    }
}
