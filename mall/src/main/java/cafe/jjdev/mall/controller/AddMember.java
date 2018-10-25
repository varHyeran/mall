package cafe.jjdev.mall.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cafe.jjdev.mall.service.Member;
import cafe.jjdev.mall.service.MemberDao;

@WebServlet("/addMember")
public class AddMember extends HttpServlet{
	MemberDao memberDao;
	// 회원가입 폼
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/addMember.jsp").forward(request, response);
	}
	// 회원가입 액션
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Member member = new Member();
		memberDao = new MemberDao();
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		System.out.println(id + "<-- id");
		System.out.println(pw + "<-- pw");
		
		member.setMemberId(id);
		member.setMemberPw(pw);
		
		try {
			memberDao.insertMember(member);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect(request.getContextPath() + "/login");
	}
}