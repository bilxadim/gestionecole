package sn.objis.gestionecole;

import java.util.List;

import sn.objis.gestionecole.IDaoPermanentImpl;
import sn.objis.gestionecole.Permanent;

public class IServicePermanentImpl implements IServicePermanent {
IDaoPermanentImpl dao =new IDaoPermanentImpl();
	public void ajouter(Permanent p) {
		dao.create(p);

	}

	public void modifier(Permanent p) {
		dao.update(p);

	}

	public void supprimer(Permanent p) {
		dao.delete(p);

	}

	public Permanent rechercher(Permanent p) {
		return dao.search(p);
	}

	public List<Permanent> lire() {
		return dao.read();
	}

	public void afficherMenuPermanent() {
		System.out.println("-------------------------------------------------------");
		System.out.println(":::::: PERMANENT ::::::: GESTION PERSONNEL :::::::::::::: ");
		System.out.println("-------------------------------------------------------\n");
		System.out.println("1 : Nouveau permanent \n");
		System.out.println("2 : Liste permanent\n");
		System.out.println("3 : Modifier informations \n");
		System.out.println("4 : Supprimer\n");
		System.out.println("5 : Bulletin Salaire\n");
		System.out.println("0 : Retour\n");
		System.out.println("-------------------------------------------------------\n");
		
	}

}
