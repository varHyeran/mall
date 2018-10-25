package cafe.jjdev.mall.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cafe.jjdev.mall.service.Member;
import cafe.jjdev.mall.service.MemberDao;

@WebServlet("/login")
public class Login extends HttpServlet {
	private MemberDao memberDao;
	// 로그인 폼
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("loginMember") == null) {
			request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		} else {
			System.out.println("로그인 중입니다...");
			response.sendRedirect("/index");
		}
	}
	// 로그인 액션
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// boolean MemberDao.login(Member) 호출
		String id = request.getParameter("loginId");
		String pw = request.getParameter("loginPw");
		System.out.println(id + "<-- id Login.java");
		System.out.println(pw + "<-- pw Login.java");
		
		Member loginMember = new Member();
		loginMember.setMemberId(id);
		loginMember.setMemberPw(pw);
		
		MemberDao memberDao = new MemberDao();
		try {
			loginMember = memberDao.loginMember(loginMember);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(loginMember.isLogin()) {
			HttpSession session = request.getSession();
			session.setAttribute("loginMember", loginMember);
			response.sendRedirect(request.getContextPath() + "/index");
			System.out.println("로그인 성공");
		} else {
			response.sendRedirect(request.getContextPath() + "/login");
			System.out.println("로그인 실패");
		}
	}

}
