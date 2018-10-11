package sn.objis.gestionecole;

import java.util.List;

import sn.objis.gestionecole.IDaoVacataireImpl;
import sn.objis.gestionecole.Vacataire;

public class IServiceVacataireImpl implements IServiceVacataire {
IDaoVacataireImpl dao = new IDaoVacataireImpl();
	public void ajouter(Vacataire p) {
		dao.create(p);

	}

	public List<Vacataire> lire() {
		return dao.read();
	}

	public void modifier(Vacataire p) {
		dao.update(p);
	}

	public void supprimer(Vacataire p) {
		dao.delete(p);
	}

	public Vacataire rechercher(Vacataire p) {
		return dao.search(p);
	}

	public void afficherMenuVacataire() {
		System.out.println("-------------------------------------------------------");
		System.out.println(":::::: VACATAIRE ::::::: GESTION PERSONNEL ::::::::::::: ");
		System.out.println("-------------------------------------------------------\n");
		System.out.println("1 : Nouveau vacataire \n");
		System.out.println("2 : Liste vacataire\n");
		System.out.println("3 : Modifier informations \n");
		System.out.println("4 : Supprimer\n");
		System.out.println("5 : Bulletin Salaire\n");
		System.out.println("0 : Retour\n");
		System.out.println("-------------------------------------------------------\n");
		
	}

}
