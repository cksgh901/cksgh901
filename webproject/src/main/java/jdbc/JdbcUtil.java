package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcUtil {
	public static Connection getConnection() throws Exception {
		Class.forName("org.mariadb.jdbc.Driver");
		// 2. DB접속
		
		return  DriverManager.getConnection(
				"jdbc:mariadb://127.0.0.1:3306/webproject", 
				"root", 
			"1234");
	}
	public static void close(ResultSet rs) {
		try {
			rs.close();
		} catch (Exception e) {}
	}
	public static void close(Statement stmt) {
		try {
			stmt.close();
		} catch (Exception e) {}
	}
	public static void close(PreparedStatement pstmt) {
		try {
			pstmt.close();
		} catch (Exception e) {}
	}
}
