package sn.objis.gestionecole;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import sn.objis.gestionecole.Employe;
import sn.objis.gestionecole.MySqlConnection;
/**
 * Cette classe implemente toutes les methodes generique definies dans
 * l'interface generique et permet de redefinir toutes les methodes pour manipuler 
 * la table employe
 * @author Bilal Fall
 * @since 30/07/2018
 *
 */
public class IDaoEmployeImpl implements IDaoEmploye {
	//Cr�ation de la seule instance de connexion avec la base de donn�es
	Connection conn=MySqlConnection.getInstanceDeConnection();
	
	// Method 	ajout d'un employe
	public void create(Employe e) {
		try {
			// Etape 1: Cr�ation de la zone de requete
			String sql="INSERT INTO employes(prenom,nom,telephone,fonction,salaire) VALUES(?,?,?,?,?)";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, e.getPrenom());
			preparedStatement.setString(2, e.getNom());
			preparedStatement.setString(3, e.getTelephone());
			preparedStatement.setString(4,e.getFonction());
			preparedStatement.setDouble(5, e.getSalaireBase());
			// Etape 2: Ex�cution de la requete
			preparedStatement.executeUpdate();
			System.out.println("Personne ajout�e avec succ�");
		} catch (SQLException ex) {
			System.out.println("Erreur d'insertion\n"+ex);
			ex.printStackTrace();
		}
	}

	// Cette methode permet de lister les enregistrements de la table Employe
	public List<Employe> read() {
		List<Employe> list = new ArrayList<Employe>();
		try {
			// Etape 1: Cr�ation de la zone de requete
			String sql="SELECT * FROM employes";
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery(sql);

			while(rs.next()) {
				Employe e=new Employe();
				e.setId(rs.getInt("id"));
				e.setPrenom(rs.getString("prenom"));
				e.setNom(rs.getString("nom"));
				e.setTelephone(rs.getString("telephone"));
				e.setFonction(rs.getString("fonction"));
				e.setSalaireBase(rs.getDouble("salaire"));
				list.add(e);
			}
		} catch (SQLException ex) {
			System.out.println("Erreur de s�lection\n"+ex);
			ex.printStackTrace();
		}
		return list;
	}
	// Cette methode permet de mettre � jour un  enregistrement de la table Employe
	public void update(Employe p) {
		try {
			// Etape 1 : Cr�ation de la zone de requete
			String sql ="UPDATE employes SET prenom=?, nom=?,telephone=?,fonction=?,salaire=? WHERE id=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			//Etape 2 : transmission des valeurs aux parametres de la requ�te
			ps.setString(1, p.getPrenom());
			ps.setString(2, p.getNom());
			ps.setString(3, p.getTelephone());
			ps.setString(4, p.getFonction());
			ps.setDouble(5, p.getSalaireBase());
			ps.setInt(6, p.getId());
			//Etape 3 : Ex�cution de la requete
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Erreur lors de la modification\n"+e);
			e.printStackTrace();
		}
		

	}
	// Cette methode permet de supprimer un enregistrement de la table Employe
	public void delete(Employe p) {
		try {
			// Etape 1: Cr�ation de la zone de requete
			String sql = "DELETE FrOM employes WHERE id=?";
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
	// Cette methode permet de rechercher un enregistrement de la table Employe
	public Employe search(Employe p) {
		Employe emp = new Employe();
		try {
			// Etape 1 : Cr�ation de la zone de requete
			String sql ="SELECT * FROM employes WHERE id=?";
			PreparedStatement preparedEmpl=conn.prepareStatement(sql);
			preparedEmpl.setInt(1, p.getId());
			// Etape 2 : ex�cution de a requete
			ResultSet rs=preparedEmpl.executeQuery();
			// Etape 3: Traitement du resultat
			while(rs.next()) {
				emp.setId(rs.getInt("id"));
				emp.setPrenom(rs.getString("prenom"));
				emp.setNom(rs.getString("nom"));
				emp.setTelephone(rs.getString("telephone"));
				emp.setFonction(rs.getString("fonction"));
				emp.setSalaireBase(rs.getDouble("salaire"));
			}
		} catch (SQLException e) {
			System.out.println("Probl�me de recherche\n"+e);
			e.printStackTrace();
		}
		return emp;
	}

}
