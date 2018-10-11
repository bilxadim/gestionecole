package sn.objis.gestionecole;
/**
 * Cette class permet de creer un professeur
 * @since 14 mars 2018
 * @version 1.0
 * @see Personne
 * @author Bilal Fall
 *
 */
public class Professeur extends Personne{
	private String grade;
	
	public Professeur(){
		
	}

	/**
	 * Cette methode permet de creer un objet professeur en l'initialisant
	 * @param prenom : type String, represente le prenom d'un professeur
	 * @param nom : type String, represente le nom d'un professeur
	 * @param telephone : type String, represente le telephone d'un professeur
	 * @param grade: Type String, represente le grade du professeur
	 */
	public Professeur(String prenom, String nom, String telephone, String grade) {
		super(prenom, nom, telephone);
		this.grade = grade;
	}

	//Getters pour la variable grade
	/**
	 * @return the grade
	 */
	public String getGrade() {
		return grade;
	}

	//setters pour la variable grade
	/**
	 * @param grade the grade to set
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	

}
