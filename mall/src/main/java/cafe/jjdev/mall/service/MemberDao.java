package cafe.jjdev.mall.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.websocket.Session;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDao {
	public void insertMember(Member member) throws ClassNotFoundException, SQLException {
		DriverDB driverDB = new DriverDB();
		Connection connection = null;
		PreparedStatement statement = null;
		
		connection = driverDB.driverDbConnection();
		String sql = "INSERT INTO member(id, pw, level) VALUES (?, ?, ?)";
		statement = connection.prepareStatement(sql);
		statement.setString(1, member.getMemberId());
		statement.setString(2, member.getMemberPw());
		statement.setInt(3, 0);
		
		statement.executeUpdate();
		statement.close();
		connection.close();
	}
	
	public Member loginMember(Member member) throws ClassNotFoundException, SQLException {
		DriverDB driverDB = new DriverDB();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultset = null;
		
		connection = driverDB.driverDbConnection();
		String sql = "SELECT id, pw FROM member WHERE id=? AND pw=?";
		statement = connection.prepareStatement(sql);
		statement.setString(1, member.getMemberPw());
		statement.setString(2, member.getMemberPw());
		System.out.println(sql + "<--- sql");
		
		resultset = statement.executeQuery();
		if(resultset.next()) {
			member.setLogin(true);
		} else {
			member.setLogin(false);
		}
		
		statement.close();
		connection.close();
		return member;
	}
}