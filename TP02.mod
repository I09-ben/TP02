/*********************************************
 * OPL 22.1.0.0 Model
 * Author: Imane
 * Creation Date: 15 avr. 2022 at 16:51:56
 *********************************************/
int nb=...; //d�clarer le nombre des objets
//d�clarer un intervalle d'entiers de 1 � nb
range objet = 1..nb;
int x1[objet]=...;
// D�clarer les variables de d�cisions
dvar boolean x[objet];
// function objectif
minimize sum(i in objet)  x[i];
// contraintes
subject to
{
  sum (i  in objet ) 
    x1[i] + x[i] >=  1;
}