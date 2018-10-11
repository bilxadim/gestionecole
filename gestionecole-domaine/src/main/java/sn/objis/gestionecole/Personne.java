package sn.objis.gestionecole;

/**
 * Cette class permet de cr�er une personne
 * @since 09 mars 2018
 * @version 1.0
 * @author Bilal Fall
 *
 */
public class Personne {
	private int id;
	private String prenom;
	private String nom;
	private String telephone;
	
	/**
	 * Cette m�thode sans parametre permet de creer un objet personne sans l'initialiser
	 */
	public Personne(){
		
	}

	/**
	 * Cette methode permet de creer un objet personne en l'initialisant
	 * @param prenom : type String, represente le prenom d'une personne
	 * @param nom : type String, represente le nom d'une personne
	 * @param telephone : type String, represente le telephone d'une personne
	 */
	public Personne(int id,String prenom, String nom, String telephone) {
		this.id=id;
		this.prenom = prenom;
		this.nom = nom;
		this.telephone = telephone;
		}
	
	
	public Personne(String prenom, String nom, String telephone) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.telephone = telephone;
	}

	// Getters ou Acesseurs pour toutes les variables
	
	/**
	 * @return the prenom
	 */
	public int getId() {
		return id;
	}
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	

	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	
	// Setters ou modificateurs pour toutes les variables
	
	/**
	 * @param prenom the prenom to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	
	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	
	/**
	 * Cette m�thode permet d'afficher l'�tat d'un objet
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Informations de l'employe:\nIdentifiant: " + this.getId() + "\nPrenom: " + this.getPrenom() + "\nNom: "
				+ this.getNom() + "\nTelephone: " + this.getTelephone()+"\n----------------------------";
	}
	
}
