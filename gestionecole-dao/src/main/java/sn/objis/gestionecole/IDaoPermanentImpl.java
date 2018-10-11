package sn.objis.gestionecole;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sn.objis.gestionecole.Permanent;
import sn.objis.gestionecole.MySqlConnection;
/**
 * Cette classe implemente toutes les methodes generique definies dans
 * l'interface generique et permet de redefinir toutes les methodes pour manipuler 
 * la table permanent
 * @author Bilal Fall
 * @since 30/07/2018
 *
 */
public class IDaoPermanentImpl implements IDaoPermanent {
	Connection conn = MySqlConnection.getInstanceDeConnection();
	// Method 	ajout d'un permanent
	public void create(Permanent p){
		try {
			// Etape 1: Cr�ation de la zone de requete
			String sql="INSERT INTO permanent(prenom,nom,telephone,grade,salaire) VALUES(?,?,?,?,?)";
			PreparedStatement preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, p.getPrenom());
			preparedStatement.setString(2, p.getNom());
			preparedStatement.setString(3, p.getTelephone());
			preparedStatement.setString(4,p.getGrade());
			preparedStatement.setDouble(5, p.getSalaire());
			// Etape 2: Ex�cution de la requete
			preparedStatement.executeUpdate();
			System.out.println("Permanent ajout�e avec succ�");
		} catch (SQLException e) {
			System.out.println("Erreur d'insertion\n"+e);
			e.printStackTrace();
		}

	}
	// Cette methode permet de lister les enregistrements de la table permanent
	public List<Permanent> read() {
		List<Permanent> listPerm = new ArrayList<Permanent>();
		try {
			// Etape 1: Cr�ation de la zone de requete
			String sql="SELECT * FROM permanent";
			Statement st = conn.createStatement();
			
			ResultSet rs = st.executeQuery(sql);

			while(rs.next()) {
				Permanent p=new Permanent();
				p.setId(rs.getInt("id"));
				p.setPrenom(rs.getString("prenom"));
				p.setNom(rs.getString("nom"));
				p.setTelephone(rs.getString("telephone"));
				p.setGrade(rs.getString("grade"));
				p.setSalaire(rs.getDouble("salaire"));
				listPerm.add(p);
			}
		} catch (SQLException e) {
			System.out.println("Erreur sur la requ�te de s�lection\n"+e);
			e.printStackTrace();
		}
		return listPerm;
	}
	// Cette methode permet de mettre � jour un  enregistrement de la table permanent
	public void update(Permanent p) {
		try {
			// Etape 1 : Cr�ation de la zone de requete
			String sql ="UPDATE permanent SET prenom=?, nom=?,telephone=?,grade=?,salaire=? WHERE id=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			//Etape 2 : transmission des valeurs aux parametres de la requ�te
			ps.setString(1, p.getPrenom());
			ps.setString(2, p.getNom());
			ps.setString(3, p.getTelephone());
			ps.setString(4, p.getGrade());
			ps.setDouble(5, p.getSalaire());
			ps.setInt(6, p.getId());
			//Etape 3 : Ex�cution de la requete
			ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Erreur lors de la modification\n"+e);
			e.printStackTrace();
		}

	}
	// Cette methode permet de supprimer un enregistrement de la table permanent
	public void delete(Permanent p) {
		try {
			// Etape 1: Cr�ation de la zone de requete
			String sql = "DELETE FrOM permanent WHERE id=?";
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
	// Cette methode permet de rechercher un enregistrement de la table permanent
	public Permanent search(Permanent p) {
		Permanent perm = new Permanent();
		try {
			// Etape 1 : Cr�ation de la zone de requete
			String sql ="SELECT * FROM permanent WHERE id=?";
			PreparedStatement preparedPerm=conn.prepareStatement(sql);
			preparedPerm.setInt(1, p.getId());
			// Etape 2 : ex�cution de a requete
			ResultSet rs=preparedPerm.executeQuery();
			// Etape 3: Traitement du resultat
			while(rs.next()) {
				perm.setId(rs.getInt("id"));
				perm.setPrenom(rs.getString("prenom"));
				perm.setNom(rs.getString("nom"));
				perm.setTelephone(rs.getString("telephone"));
				perm.setGrade(rs.getString("grade"));
				perm.setSalaire(rs.getDouble("salaire"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return perm;
	}

}
