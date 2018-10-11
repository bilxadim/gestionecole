package sn.objis.gestionecole;

import java.util.List;

import sn.objis.gestionecole.IDaoEmployeImpl;
import sn.objis.gestionecole.Employe;

public class IServiceEmployeImpl implements IServiceEmployes {
	IDaoEmployeImpl dao = new IDaoEmployeImpl();
	public void ajouter(Employe p) {
		dao.create(p);

	}

	public List<Employe> lire() {
		return dao.read();
	}

	public void modifier(Employe p) {
		dao.update(p);

	}

	public void supprimer(Employe p) {
		dao.delete(p);

	}

	public Employe rechercher(Employe p) {
		return dao.search(p);
	}

	public void afficherMenuEmploye() {
		System.out.println("-------------------------------------------------------");
		System.out.println(":::::: EMPLOYE ::::::: GESTION PERSONNEL :::::::::::::: ");
		System.out.println("-------------------------------------------------------\n");
		System.out.println("1 : Nouvel \n");
		System.out.println("2 : Liste employ�s\n");
		System.out.println("3 : Modifier informations \n");
		System.out.println("4 : Supprimer\n");
		System.out.println("5 : Bulletin Salaire\n");
		System.out.println("0 : Retour\n");
		System.out.println("-------------------------------------------------------\n");
		
	}

}
