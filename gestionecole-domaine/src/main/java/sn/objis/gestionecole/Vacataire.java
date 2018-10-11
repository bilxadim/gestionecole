package sn.objis.gestionecole;
/**
 * Cette class permet de creer un professeur vacataire
 * @since 14 mars 2018
 * @version 1.0
 * @see Professeur
 * @author Bilal Fall
 *
 */
public class Vacataire extends Professeur{
	private double tauxHoraire;
	
	/**
	 * Cette methode permet de creer un objet Professeur vacataire sans l'initialiser
	 */
	public Vacataire(){
		
	}

	/**
	 * Cette methode permet de creer un objet professeur vacataire en l'initialisant
	 * @param prenom : type String, represente le prenom d'un professeur vacataire
	 * @param nom : type String, represente le nom d'un professeur vacataire
	 * @param telephone : type String, represente le telephone d'un professeur vacataire
	 * @param grade: Type String, represente le grade du professeur vacataire
	 * @param tauxHoraire : type double, represente le taux horaire du professeur vacataire
	 * @param nombreHeure : type int, represente le nombre d'heure effectue par semaine par le professeur vacataire
	 */
	
	public Vacataire(String prenom, String nom, String telephone, String grade,
			double tauxHoraire) {
		super(prenom, nom, telephone, grade);
		this.tauxHoraire = tauxHoraire;
	}
	
	// Getter pour les variables : tauxHoraire et nombreHeure
	/**
	 * @return the tauxHoraire
	 */
	public double getTauxHoraire() {
		return tauxHoraire;
	}
	
	// Setter pour les variables : tauxHoraire et nombreHeure
	/**
	 * @param tauxHoraire the tauxHoraire to set
	 */
	public void setTauxHoraire(double tauxHoraire) {
		this.tauxHoraire = tauxHoraire;
	}

	/**
	 * Cette m�thode permet de d'afficher l'�tat d'un vacataire
	 */
@Override
public String toString() {
	// TODO Auto-generated method stub
	return "Informations de l'employe:\nPrenom: "+this.getPrenom()+"\nNom: "+this.getNom()+"\nTelephone: "+this.getTelephone()
	+"\nTaux horaire:"+this.tauxHoraire;
}
}
