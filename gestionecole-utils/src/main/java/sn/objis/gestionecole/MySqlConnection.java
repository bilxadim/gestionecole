package sn.objis.gestionecole;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection {
	private static String url="jdbc:mysql://localhost/gestionpersonnel?useSSL=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private static String userDb="bilal";
	private static String motDePasse="fbfall";
	private static Connection connect=null;
	
	private  MySqlConnection() {
		
	}
	
	public static Connection getInstanceDeConnection(){
		try {
			if(connect==null) {
				connect=DriverManager.getConnection(url, userDb, motDePasse);
				System.out.println("CONNEXION ETABLIE AVEC SUCCES");
			}
		} catch (SQLException e) {
			System.out.println("PROBLEME DE CONNEXION\n"+e);
			e.printStackTrace();
		}
		return connect;
	}
}
