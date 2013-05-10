package br.com.exemplo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory {

	private static Connection conn;
	
	public static Connection getConnection(){
			
		//MYSQL
		
		try {

	        String driverName = "com.mysql.jdbc.Driver";
	        String url = "jdbc:mysql://localhost:3306/seubanco";
	        String username = "seuLogin";
	        String password = "suaSenha";
	    
	        // Load the JDBC driver
	        Class.forName(driverName);
	        // Create a connection to the database
	        conn = DriverManager.getConnection(url, username, password);

	    } catch (ClassNotFoundException e) {
	        // Could not find the database driver
	    } catch (SQLException f) {
	        // Could not connect to the database
	    }
	    return conn;
	}
		


	
	
	
	// FECHA AS CONEXOES JAVA
	
    public static void closeConnection(Connection conn, PreparedStatement pstm, ResultSet rs) throws Exception {
        close(conn, pstm, rs);
    }

    public static void closeConnection(Connection conn, PreparedStatement pstm) throws Exception {
        close(conn, pstm, null);
    }

    public static void closeConnection(Connection conn) throws Exception {
        close(conn, null, null);
    }

    private static void close(Connection conn, PreparedStatement pstm, ResultSet rs) throws Exception {
        try {
            if (rs != null) rs.close( );
            if (pstm != null)pstm.close( );
            if (conn != null)conn.close( );
        } catch (Exception e) {
            throw new Exception(e.getMessage( ));
        }
    }		
	
	
	
	
	
	
}
