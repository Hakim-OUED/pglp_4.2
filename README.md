# Command Pattern
Illustration de l'utilisation du Command Pattern

# Sujet:
Dans cet exercice, on souhaite réaliser une calculatrice fonctionnant en mode RPN (Reverse Polish Notation).
Cette notation post-fixée permet de représenter des formules arithmétiques sans parenthèses. Par
exemple, l’expression « 2 × (3 + 4) » pourra s’écrire « 234 + × ».
Cette calculatrice devra supporter les opérations de base (+, -, *, /) sur des nombres entiers.
L’interface utilisateur utilisera un interpréteur en mode texte. L’utilisateur saisira au clavier soit un nombre,
soit une opération, soit undo pour annuler la saisie précédente, soit exit pour sortir. Chaque saisie se
terminera par entrée.
L’implémentation pourra utiliser une pile de la façon suivante :
— les opérandes sont empilées lors de leur saisie,
— les opérations sont effectuées immédiatement en considérant les opérandes se trouvant au sommet
de la pile,
— le résultat d’une opération est empilé.
Après chaque saisie, l’interpréteur affichera le contenu de la pile.
Pour la conception, vous pourrez consulter Example calculator design.
1. Implémentez un interpréteur générique Interpreteur qui supporte uniquement les commandes
undo et quit. La commande quit stoppe le programme. La commande undo supprime la dernière
commande de l’historique. Vous utiliserez le pattern Command pour implémenter les actions.
2. Dérivez la classe MoteurRPN de l’interpréteur. Elle devra permettre de :
— enregistrer une opérande,
— appliquer une opération sur les opérandes,
— retourner l’ensemble des opérandes stockées.
Vous utiliserez le pattern Command pour implémenter les actions.
3. Implémenter la classe SaisieRPN qui gère les interactions avec l’utilisateur et invoque le moteur
RPN. La classe java.util.Scanner permet de gérer les saisies.
4. Implémenter le programme principal CalculatriceRPN.
