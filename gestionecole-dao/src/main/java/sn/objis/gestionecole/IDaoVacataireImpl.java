package sn.objis.gestionecole;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sn.objis.gestionecole.Vacataire;
import sn.objis.gestionecole.MySqlConnection;
/**
 * Cette classe implemente toutes les methodes generique definies dans
 * l'interface generique et permet de redefinir toutes les methodes pour manipuler 
 * la table employe
 * @author Bilal Fall
 * @since 30/07/2018
 *
 */
public class IDaoVacataireImpl implements IDaoVacataire{
	Connection conn = MySqlConnection.getInstanceDeConnection();
	public void create(Vacataire p) {
		try {
			// Etape 1: Cr�ation de la zone de requete
			String sql="INSERT INTO vacataire(prenom,nom,telephone,grade,taux) VALUES(?,?,?,?,?)";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, p.getPrenom());
			preparedStatement.setString(2, p.getNom());
			preparedStatement.setString(3, p.getTelephone());
			preparedStatement.setString(4,p.getGrade());
			preparedStatement.setDouble(5, p.getTauxHoraire());
			// Etape 2: Ex�cution de la requete
			preparedStatement.executeUpdate();
			System.out.println("Vacataire ajout� avec succ�");
		} catch (SQLException e) {
			System.out.println("Erreur d'insertion\n"+e);
			e.printStackTrace();
		}
	}
	// Cette methode permet de lister les enregistrements de la table vacataire
	public List<Vacataire> read() {
		List<Vacataire> listVac = new ArrayList<Vacataire>();
		try {
			// Etape 1: Cr�ation de la zone de requete
			String sql="SELECT * FROM vacataire";
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery(sql);

			while(rs.next()) {
				Vacataire p=new Vacataire();
				p.setId(rs.getInt("id"));
				p.setPrenom(rs.getString("prenom"));
				p.setNom(rs.getString("nom"));
				p.setTelephone(rs.getString("telephone"));
				p.setGrade(rs.getString("grade"));
				p.setTauxHoraire(rs.getDouble("taux"));
				listVac.add(p);
			}
		} catch (SQLException e) {
			System.out.println("Erreur sur la requ�te de s�lection\n"+e);
			e.printStackTrace();
		}
		return null;
	}
	// Cette methode permet de mettre � jour un  enregistrement de la table vacataire
	public void update(Vacataire p) {
		try {
			// Etape 1 : Cr�ation de la zone de requete
			String sql ="UPDATE vacataire SET prenom=?, nom=?,telephone=?,grade=?,taux=? WHERE id=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			//Etape 2 : transmission des valeurs aux parametres de la requ�te
			ps.setString(1, p.getPrenom());
			ps.setString(2, p.getNom());
			ps.setString(3, p.getTelephone());
			ps.setString(4, p.getGrade());
			ps.setDouble(5, p.getTauxHoraire());
			ps.setInt(6, p.getId());
			//Etape 3 : Ex�cution de la requete
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Erreur lors de la modification\n"+e);
			e.printStackTrace();
		}

	}
	// Cette methode permet de supprimer un enregistrement de la table vacataire
	public void delete(Vacataire p) {
		try {
			// Etape 1: Cr�ation de la zone de requete
			String sql = "DELETE FrOM vacataire WHERE id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			// Etape 2: Transmission de s valeurs � la requete
			ps.setInt(1, p.getId());
			// Etape 3: EXecution de la arequete
			ps.executeUpdate();
			System.out.println("Suppression effectu�e avec succ�");
		} catch (SQLException e) {
			System.out.println("Erreur sur la suppression"+e);
			e.printStackTrace();
		}

	}
	// Cette methode permet de rechercher un enregistrement de la table vacataire
	public Vacataire search(Vacataire p) {
		Vacataire vac = new Vacataire();
		try {
			// Etape 1 : Cr�ation de la zone de requete
			String sql ="SELECT * FROM vacataire WHERE id=?";
			PreparedStatement preparedPerm=conn.prepareStatement(sql);
			preparedPerm.setInt(1, p.getId());
			// Etape 2 : ex�cution de a requete
			ResultSet rs=preparedPerm.executeQuery();
			// Etape 3: Traitement du resultat
			while(rs.next()) {
				vac.setId(rs.getInt("id"));
				vac.setPrenom(rs.getString("prenom"));
				vac.setNom(rs.getString("nom"));
				vac.setTelephone(rs.getString("telephone"));
				vac.setGrade(rs.getString("grade"));
				vac.setTauxHoraire(rs.getDouble("salaire"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vac;
	}


}
