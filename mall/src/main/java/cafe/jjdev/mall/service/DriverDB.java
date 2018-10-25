package cafe.jjdev.mall.service;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class DriverDB {
	public Connection driverDbConnection() throws ClassNotFoundException, SQLException {
		System.out.println("드라이버로딩 & DB연결 DriverDB.java");
		Class.forName("com.mysql.jdbc.Driver");
		String jdbcDriver = "jdbc:mysql://localhost:3306/mall?useUnicode=true&characterEncoding=UTF-8";
		String dbUser = "root";
		String dbPass = "java0000";
		Connection return_connection = null;
		return_connection = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
		System.out.println(return_connection + "<- return_connection");
		return return_connection;
	}
}