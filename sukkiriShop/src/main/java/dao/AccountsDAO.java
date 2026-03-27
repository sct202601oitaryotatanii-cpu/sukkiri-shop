package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Account;

public class AccountsDAO {
	private final String JDBC_URL =
		"jdbc:h2:tcp://localhost/~/sukkiriShop";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";
	
	
	
	
	public Account findByUserId(String userId) {
	    Account account = null;
	    
	    try {
	        Class.forName("org.h2.Driver");
	        System.out.println("H2ドライバOK");
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    }
	    
	    try {
	        Class.forName("org.h2.Driver");
	    } catch (ClassNotFoundException e) {
	        throw new IllegalStateException("JDBCドライバを読み込めませんでした");
	    }

	    try (Connection conn = DriverManager.getConnection(
	            JDBC_URL, DB_USER, DB_PASS)) {

	        String sql = "SELECT * FROM ACCOUNTS WHERE USER_ID = ?";
	        PreparedStatement pStmt = conn.prepareStatement(sql);
	        pStmt.setString(1, userId);

	        ResultSet rs = pStmt.executeQuery();

	        if (rs.next()) {
	            account = new Account(
	                rs.getString("USER_ID"),
	                rs.getString("PASS"),
	                rs.getString("MAIL"),
	                rs.getString("NAME"),
	                rs.getInt("AGE"),
	                rs.getString("ROLE")
	            );
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return account;
	}
		
		public boolean create(Account account) {
		    try (Connection conn = DriverManager.getConnection(
		            JDBC_URL, DB_USER, DB_PASS)) {

		        String sql = "INSERT INTO ACCOUNTS(USER_ID, PASS, MAIL, NAME, AGE) VALUES(?,?,?,?,?)";
		        PreparedStatement pStmt = conn.prepareStatement(sql);

		        pStmt.setString(1, account.getUserId());
		        pStmt.setString(2, account.getPass());
		        pStmt.setString(3, account.getMail());
		        pStmt.setString(4, account.getName());
		        pStmt.setInt(5, account.getAge());

		        int result = pStmt.executeUpdate();

		        return result == 1;

		    } catch (SQLException e) {
		        e.printStackTrace();
		        return false;
		 }
		    
	}
		
}
