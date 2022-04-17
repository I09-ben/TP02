/*********************************************
 * OPL 22.1.0.0 Model
 * Author: Imane
 * Creation Date: 15 avr. 2022 at 16:51:56
 *********************************************/
int nb=...; //déclarer le nombre des objets
//déclarer un intervalle d'entiers de 1 à nb
range objet = 1..nb;
int x1[objet]=...;
// Déclarer les variables de décisions
dvar boolean x[objet];
// function objectif
minimize sum(i in objet)  x[i];
// contraintes
subject to
{
  sum (i  in objet ) 
    x1[i] + x[i] >=  1;
}