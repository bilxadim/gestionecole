package sn.objis.gestionecole;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import sn.objis.gestionecole.Permanent;
import sn.objis.gestionecole.Vacataire;
import sn.objis.gestionecole.IServiceEmployeImpl;
import sn.objis.gestionecole.IServicePermanentImpl;
import sn.objis.gestionecole.IServiceVacataireImpl;
import sn.objis.gestionecole.Menu;
import sn.objis.gestionecole.Employe;

public class MainApplication {

	private static Scanner sc;

	/**
	 * Cette methode represente le point d'entree de l'apllication
	 * 
	 * @param args:String,
	 *            peur être passé à l'application lors du démarrage
	 */
	public static void main(String[] args) {
		// Declaration de variable
		String prenom;
		String nom;
		String telephone;
		String fonction;
		String grade;
		double salaire;
		double taux;

		boolean isPasser = false;
		sc = new Scanner(System.in);

		// Création de référence : employe, permanent et vacataire
		Employe employe = null;
		Permanent permanent = null;
		Vacataire vacataire = null;

		// Déclaration de variable pour récupérer le choix de l'utilisateur
		String choix;
		boolean isChoix = false;
		// Déclaration de variable pour vérifier si une saisie est numérique
		boolean isNumeric = true;
		char ch = 0;
		char chsm = 0;
		String reponse;
		IServiceEmployeImpl iserviceEmpl = new IServiceEmployeImpl();
		IServicePermanentImpl iservicePer = new IServicePermanentImpl();
		IServiceVacataireImpl iserviceVac = new IServiceVacataireImpl();
		do {
			Menu.afficheMenu();
			// Saisie et Controle du choix de l'utilisateur
			do {
				System.out.println("Choix :");
				choix = sc.nextLine();
				if (choix.matches("^[012345]+$")) {
					ch = choix.charAt(0);
					if (ch != '1' && ch != '2' && ch != '3' && ch != '4' && ch != '5' && ch != '0') {
						isChoix = false;
						System.out.println("ERREUR -- CHOIX NON DISPONIBLE");
					} else {
						isChoix = true;

					}
				} else {
					isChoix = false;
					System.out.println("ERREUR -- CARACTERE NON AUTORISE");
				}

			} while (isChoix == false);

			switch (ch) {
			case '1':// Cas du Menu Permanent
				do {
					iserviceEmpl.afficherMenuEmploye();
					// Gestion du sous Menu Employe

					do {
						System.out.println("Choix :");
						choix = sc.nextLine();
						if (choix.matches("^[012345]+$")) {
							chsm = choix.charAt(0);
							if (chsm != '1' && chsm != '2' && chsm != '3' && chsm != '4' && chsm != '5'
									&& chsm != '0') {
								isChoix = false;
								System.out.println("ERREUR -- CHOIX NON DISPONIBLE");
							} else {
								isChoix = true;

							}
						} else {
							isChoix = false;
							System.out.println("ERREUR -- CARACTERE NON AUTORISE");
						}

					} while (isChoix == false);

					switch (chsm) {
					case '1':
						System.out.println("Saisie des informations d'un employe : \n");
						System.out.println("Prenom:");
						prenom = sc.nextLine();
						System.out.println("Nom:");
						nom = sc.nextLine();
						telephone = null;
						// Saisie et controle du telephone
						do {
							System.out.println("Telephone");
							telephone = sc.nextLine();
							if (telephone.matches("^[0-9]+$")) {
								if (telephone.length() == 9) {
									isNumeric = true;
								} else {
									isNumeric = false;
									System.out.println("Non trop court, minimum  neuf(9) caracteres");
								}

							} else {
								isNumeric = false;
								System.out.println("Caractere non autorise");
							}

						} while (isNumeric == false);
						System.out.println("Fonction");
						fonction = sc.nextLine();
						System.out.println("Salaire de base");
						salaire = sc.nextDouble();
						employe = new Employe(prenom, nom, telephone, fonction, salaire);
						iserviceEmpl.ajouter(employe);
						break;
					case '2':
						List<Employe> list = iserviceEmpl.lire();
						Stream<Employe> st = list.stream();
						st.forEach(System.out::println);
						break;
					case '3':
						Employe emp = new Employe();
						System.out.println("Veuillez entrer un identifiant");
						emp.setId(sc.nextInt());
						sc.nextLine();
						emp = iserviceEmpl.rechercher(emp);
						System.out.println("Taper nouvelle fonction");
						emp.setFonction(sc.nextLine());
						System.out.println("Taper nouveau salaire");
						emp.setSalaireBase(sc.nextDouble());
						iserviceEmpl.modifier(emp);
						break;
					case '4':
						Employe e = new Employe();
						System.out.println("Veuillez entrer un identifiant");
						e.setId(sc.nextInt());
						iserviceEmpl.supprimer(e);
						break;
					case '5':
						Employe b = new Employe();
						System.out.println("Taper l'identifiant de l'amploye");
						b.setId(sc.nextInt());
						b = iserviceEmpl.rechercher(b);
						System.out.println(b);
						break;
					case '0':
						Menu.afficheMenu();
						break;
					}
					do {
						System.out.println("Choix :");
						choix = sc.nextLine();
						if (choix.matches("^[012345]+$")) {
							chsm = choix.charAt(0);
							if (chsm != '1' && chsm != '2' && chsm != '3' && chsm != '4' && chsm != '5'
									&& chsm != '0') {
								isChoix = false;
								System.out.println("ERREUR -- CHOIX NON DISPONIBLE");
							} else {
								isChoix = true;

							}
						} else {
							isChoix = false;
							System.out.println("ERREUR -- CARACTERE NON AUTORISE");
						}

					} while (isChoix == false);
				} while (isChoix == false);

				break;

			case '2':// Cette partie permet de traiter les permanents
				do {
					iserviceEmpl.afficherMenuEmploye();
					// Gestion du sous Menu Employe

					do {
						System.out.println("Choix :");
						choix = sc.nextLine();
						if (choix.matches("^[012345]+$")) {
							chsm = choix.charAt(0);
							if (chsm != '1' && chsm != '2' && chsm != '3' && chsm != '4' && chsm != '5'
									&& chsm != '0') {
								isChoix = false;
								System.out.println("ERREUR -- CHOIX NON DISPONIBLE");
							} else {
								isChoix = true;

							}
						} else {
							isChoix = false;
							System.out.println("ERREUR -- CARACTERE NON AUTORISE");
						}

					} while (isChoix == false);

					switch (chsm) {
					case '1':
						System.out.println("Saisie des informations d'un permanent : \n");
						System.out.println("Prenom:");
						prenom = sc.nextLine();
						System.out.println("Nom:");
						nom = sc.nextLine();
						telephone = null;
						// Saisie et controle du telephone
						do {
							System.out.println("Telephone");
							telephone = sc.nextLine();
							if (telephone.matches("^[0-9]+$")) {
								if (telephone.length() == 9) {
									isNumeric = true;
								} else {
									isNumeric = false;
									System.out.println("Non trop court, minimum  neuf(9) caracteres");
								}

							} else {
								isNumeric = false;
								System.out.println("Caractere non autorise");
							}

						} while (isNumeric == false);
						System.out.println("Grade");
						grade = sc.nextLine();
						System.out.println("Salaire de base");
						salaire = sc.nextDouble();
						permanent = new Permanent(prenom, nom, telephone, grade, salaire);
						iservicePer.ajouter(permanent);
						break;
					case '2':
						List<Permanent> list = iservicePer.lire();
						Stream<Permanent> st = list.stream();
						st.forEach(System.out::println);
						break;
					case '3':
						Permanent per = new Permanent();
						System.out.println("Veuillez entrer un identifiant");
						per.setId(sc.nextInt());
						sc.nextLine();
						per = iservicePer.rechercher(per);
						System.out.println("Taper nouvelle fonction");
						per.setGrade(sc.nextLine());
						System.out.println("Taper nouveau salaire");
						per.setSalaire(sc.nextDouble());
						iservicePer.modifier(per);
						break;
					case '4':
						Permanent e = new Permanent();
						System.out.println("Veuillez entrer un identifiant");
						e.setId(sc.nextInt());
						iservicePer.supprimer(e);
						break;
					case '5':
						Permanent b = new Permanent();
						System.out.println("Taper l'identifiant de l'amploye");
						b.setId(sc.nextInt());
						b = iservicePer.rechercher(b);
						System.out.println(b);
						break;
					case '0':
						Menu.afficheMenu();
						break;
					}
					do {
						System.out.println("Choix :");
						choix = sc.nextLine();
						if (choix.matches("^[012345]+$")) {
							chsm = choix.charAt(0);
							if (chsm != '1' && chsm != '2' && chsm != '3' && chsm != '4' && chsm != '5'
									&& chsm != '0') {
								isChoix = false;
								System.out.println("ERREUR -- CHOIX NON DISPONIBLE");
							} else {
								isChoix = true;

							}
						} else {
							isChoix = false;
							System.out.println("ERREUR -- CARACTERE NON AUTORISE");
						}

					} while (isChoix == false);
				} while (isChoix == false);
				break;

			case '3': // Cette partie permet de traiter des vacataires
				do {
					iserviceVac.afficherMenuVacataire();
					// Gestion du sous Menu Vacataire

					do {
						System.out.println("Choix :");
						choix = sc.nextLine();
						if (choix.matches("^[012345]+$")) {
							chsm = choix.charAt(0);
							if (chsm != '1' && chsm != '2' && chsm != '3' && chsm != '4' && chsm != '5'
									&& chsm != '0') {
								isChoix = false;
								System.out.println("ERREUR -- CHOIX NON DISPONIBLE");
							} else {
								isChoix = true;

							}
						} else {
							isChoix = false;
							System.out.println("ERREUR -- CARACTERE NON AUTORISE");
						}

					} while (isChoix == false);

					switch (chsm) {
					case '1':
						System.out.println("Saisie des informations d'un vacatire : \n");
						System.out.println("Prenom:");
						prenom = sc.nextLine();
						System.out.println("Nom:");
						nom = sc.nextLine();
						telephone = null;
						// Saisie et controle du telephone
						do {
							System.out.println("Telephone");
							telephone = sc.nextLine();
							if (telephone.matches("^[0-9]+$")) {
								if (telephone.length() == 9) {
									isNumeric = true;
								} else {
									isNumeric = false;
									System.out.println("Non trop court, minimum  neuf(9) caracteres");
								}

							} else {
								isNumeric = false;
								System.out.println("Caractere non autorise");
							}

						} while (isNumeric == false);
						System.out.println("Grade");
						grade = sc.nextLine();
						System.out.println("Taux horaire");
						taux = sc.nextDouble();
						vacataire = new Vacataire(prenom, nom, telephone, grade, taux);
						iserviceVac.ajouter(vacataire);
						break;
					case '2':
						List<Vacataire> list = iserviceVac.lire();
						Stream<Vacataire> st = list.stream();
						st.forEach(System.out::println);
						break;
					case '3':
						Vacataire vac = new Vacataire();
						System.out.println("Veuillez entrer un identifiant");
						vac.setId(sc.nextInt());
						sc.nextLine();
						vac = iserviceVac.rechercher(vac);
						System.out.println("Taper nouvelle fonction");
						vac.setGrade(sc.nextLine());
						System.out.println("Taper nouveau salaire");
						vac.setTauxHoraire(sc.nextDouble());
						iserviceVac.modifier(vac);
						break;
					case '4':
						Vacataire e = new Vacataire();
						System.out.println("Veuillez entrer un identifiant");
						e.setId(sc.nextInt());
						iserviceVac.supprimer(e);
						break;
					case '5':
						Vacataire b = new Vacataire();
						System.out.println("Taper l'identifiant de l'amploye");
						b.setId(sc.nextInt());
						b = iserviceVac.rechercher(b);
						System.out.println(b);
						break;
					case '0':
						Menu.afficheMenu();
						break;
						
					default:System.out.println("Continuer");
						do {
							System.out.println("Choix :");
							choix = sc.nextLine();
							if (choix.matches("^[012345]+$")) {
								chsm = choix.charAt(0);
								if (chsm != '1' && chsm != '2' && chsm != '3' && chsm != '4' && chsm != '5'
										&& chsm != '0') {
									isChoix = false;
									System.out.println("ERREUR -- CHOIX NON DISPONIBLE");
								} else {
									isChoix = true;

								}
							} else {
								isChoix = false;
								System.out.println("ERREUR -- CARACTERE NON AUTORISE");
							}

						} while (isChoix == false);
						break;
					}
					
				} while (isChoix == false);
				break;
			case '0':
				System.out.println("Merci d'avoir utiliser l'application.");
				System.exit(0);
				break;
			}
			// Cette partie permet de faire revenir le Menu principal ou de
			// quitter l'application
			sc.nextLine();
			System.out.println("-------------------------------------------------------\n");
			do {
				System.out.println("---- Voulez vous continuer O/N ----");

				reponse = sc.nextLine();

				if (reponse.matches("^[oOnN]+$")) {
					char rep = reponse.charAt(0);
					if (rep == 'o' || rep == 'O') {
						isPasser = true;
					} else {
						System.out.println("Merci d'avoir utiliser l'application.");
						System.exit(0);
					}
				} else {
					System.out.println("ERREUR, Caractere non autorise.");
				}
			} while (isPasser == false);

		} while (isPasser == true);

	}

}
