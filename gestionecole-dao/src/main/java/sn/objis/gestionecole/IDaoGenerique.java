package sn.objis.gestionecole;

import java.util.List;
/**
 * Cette interface regroupe les methodes communes a tous les service
 * @author Bilal Fall
 * @since 30/07/2018
 *
 * @param <P> : represente la classe � implementer par le service
 */
public interface IDaoGenerique<P> {
	
	public void create(P p);
	
	public List<P> read();
	
	public void update(P p);
	
	public void delete(P p);

	public P search(P p);

}
