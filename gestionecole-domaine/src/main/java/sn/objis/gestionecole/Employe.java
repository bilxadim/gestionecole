package sn.objis.gestionecole;
/**
 * Cette class permet de creer un employe faisant parti du personnel
 * @since 14 mars 2018
 * @version 1.0
 * @see Employe
 * @author Bilal Fall
 *
 */
public class Employe extends Personne{
	private String fonction;
	private double salaireBase;
	
	/**
	 * Cette methode permet sans parametre, permet de creer des objet Employe sans les initialiser
	 */
	public Employe(){
		
	}

	/**
	 * Cette methode prend 8 parametre, permet de creer un objet Employe en l'initialisant
	 * @param prenom : type String, represente le prenom de l'employe
	 * @param nom : type String, represente le nom de l'employe
	 * @param telephone : type String, represente le telephone de l'employe
	 * @param fonction : type String, represente la fonction qu'occupe l'employe
	 * @param salaireBase : type double, represente le salaire de base de l'employe
	 */
	public Employe(String prenom, String nom, String telephone, String fonction,
			double salaireBase) {
		super(prenom, nom, telephone);
		this.fonction = fonction;
		this.salaireBase = salaireBase;
	}
	
	//Getters pour toutes les variables

	/**
	 * @return the fonction
	 */
	public String getFonction() {
		return fonction;
	}

	/**
	 * @return the salaireBase
	 */
	public double getSalaireBase() {
		return salaireBase;
	}

	
	// Setters pour toutes les variables

	/**
	 * @param fonction the fonction to set
	 */
	public void setFonction(String fonction) {
		this.fonction = fonction;
	}

	/**
	 * @param salaireBase the salaireBase to set
	 */
	public void setSalaireBase(double salaireBase) {
		this.salaireBase = salaireBase;
	}
	
	/**
	 * Cette m�thode permet de d'afficher l'�tat d'un employ�
	 */
	@Override
	public String toString() {
		return "Informations de l'employe:\nIdentifiant: " + this.getId() + "\nPrenom: " + this.getPrenom() + "\nNom: "
				+ this.getNom() + "\nTelephone: " + this.getTelephone() + "\nFonction : " + this.fonction
				+ "\nSalaire base: " + this.salaireBase + "\n-----------------------";
	}
}
