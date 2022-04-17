/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Zine dine
 */
import ilog.concert.*;
import ilog.cplex.*;
public class Problem03 {
public static void main(String[] args) {
calcul ();
}
public static void calcul (){
try {
IloCplex simplexe = new IloCplex ();
// déclaration des Variables de décision de type reel
IloNumVar var_decis [][] = new IloNumVar [2][1];
for (int i=0;i<2;i++){
var_decis[i][0]= simplexe.numVar(0, Double.MAX_VALUE);
}
// declaration de la fonction objectif
IloLinearNumExpr objectif = simplexe.linearNumExpr();
// Définition des coefficients de la fonction objectif
objectif.addTerm(60, var_decis[0][0]);
objectif.addTerm(40, var_decis[1][0]);
// Définir le type d'otimisation de la fonction (max ou min )
simplexe.addMaximize(objectif);
// contrainte 1 : 1*X1 + 2*X2 <= 70
IloLinearNumExpr contrainte_1 = simplexe.linearNumExpr();
contrainte_1.addTerm(1, var_decis[0][0]);
contrainte_1.addTerm(2, var_decis[1][0]);
simplexe.addLe(contrainte_1,10);
// la meme chose pour les autres contraintes
//deuxième contrainte
IloLinearNumExpr contrainte_2 = simplexe.linearNumExpr();
contrainte_2.addTerm(1, var_decis[0][0]);
contrainte_2.addTerm(1, var_decis[1][0]);
simplexe.addLe(contrainte_2, 4);
//troisième contrainte
IloLinearNumExpr contrainte_3 = simplexe.linearNumExpr();
contrainte_3.addTerm(3, var_decis[0][0]);
contrainte_3.addTerm(1, var_decis[1][0]);
simplexe.addLe(contrainte_3, 9);
simplexe.solve(); // lancer la resolution
// Afficher des résultat
System.out.println(+ simplexe.getObjValue());
System.out.println(" Voici les valeurs des variables de décision: ") ;
for (int i=0;i<2;i++)
System.out.println( "X"+i+ " = "+ simplexe.getValue(var_decis[i][0]));
} catch (IloException e){
System.out.print("Exception levée " + e);
}
}
}