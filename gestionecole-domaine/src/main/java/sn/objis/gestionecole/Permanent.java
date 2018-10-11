package sn.objis.gestionecole;
/**
 * Cette class permet de creer un professeur permanent
 * @since 14 mars 2018
 * @version 1.0
 * @see Professeur
 * @author Bilal Fall
 *
 */
public class Permanent extends Professeur{
	private double salaire;
	
	/**
	 * Cette methode permet de creer un objet professeur permanent sans l'initialiser
	 */
	public Permanent() {
		
	}

	/**
	 * Cette methode permet de creer un objet professeur permanent en l'initialisant
	 * @param prenom : type String, represente le prenom d'un professeur permanent
	 * @param nom : type String, represente le nom d'un professeur permanent
	 * @param telephone : type String, represente le telephone d'un professeur permanent
	 * @param grade: Type String, represente le grade du professeur permanent
	 * @param salaire :type double, represente le salaire du professeur permanent permanent
	 */
	
	public Permanent(String prenom, String nom, String telephone, String grade,
			double salaire) {
		super(prenom, nom, telephone, grade);
		this.salaire = salaire;
	}
// Getter et Setter pour le salaire
	/**
	 * @return the salaire
	 */
	public double getSalaire() {
		return salaire;
	}

	/**
	 * @param salaire the salaire to set
	 */
	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}
/**
 * Cette m�thode permet de d'afficher l'�tat d'un permanent
 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Informations de l'employe:\nPrenom: "+this.getPrenom()+"\nNom: "+this.getNom()+"\nTelephone: "+this.getTelephone()
		+"\nGrade"+this.getGrade()+"\nSalaire base: "+this.salaire;
	}
	

}
