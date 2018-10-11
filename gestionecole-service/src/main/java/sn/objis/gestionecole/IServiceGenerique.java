package sn.objis.gestionecole;

import java.util.List;

public interface IServiceGenerique<P> {
	public void ajouter(P p);
	
	public List<P> lire();
	
	public void modifier(P p);
	
	public void supprimer(P p);
	
	public P rechercher(P p);

	
}
