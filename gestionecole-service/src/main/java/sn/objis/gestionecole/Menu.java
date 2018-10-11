package sn.objis.gestionecole;

public class Menu {

	public static void afficheMenu() {
		System.out.println("-------------------------------------------------------");
		System.out.println(":::::: GEPER ::::::::: GESTION PERSONNEL :::::::::::::: ");
		System.out.println("-------------------------------------------------------\n");
		System.out.println("1 : Employes \n");
		System.out.println("2 : Professeur permanent\n");
		System.out.println("3 : Professeur vacataire\n");
		System.out.println("0 : Quitter\n");
		System.out.println("-------------------------------------------------------\n");
	}
	
	public static void sousAfficheSMenu() {
		System.out.println("-------------------------------------------------------");
		System.out.println(":::::: EMPLOYE ::::::: GESTION PERSONNEL :::::::::::::: ");
		System.out.println("-------------------------------------------------------\n");
		System.out.println("1 : Nouveau \n");
		System.out.println("2 : Liste \n");
		System.out.println("3 : Modifier informations \n");
		System.out.println("4 : Recherche\n");
		System.out.println("5 : Supprimer\n");
		System.out.println("0 : Retour\n");
		System.out.println("-------------------------------------------------------\n");
	}
}
