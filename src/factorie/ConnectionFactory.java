package factorie;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	// public Connection getConnection() throws Exeception{
	// Class.forName("org.postgresql.Driver");
	// return
	// DriverManager.getConnection("jbdc:postgresql://localhost:542/bd_java_projeto03"
	// , "postgres", "coti");
	// método para abrir conexão com um banco de dados do PostGreSQL
	public Connection getConnection() throws Exception {

		// parâmetros de conexão
		String driver = "org.postgresql.Driver";
		String host = "jdbc:postgresql://localhost:5432/bd_java_projeto03";
		String user = "postgres";
		String password = "coti";

		Class.forName(driver);
		return DriverManager.getConnection(host, user, password);
	}

}
