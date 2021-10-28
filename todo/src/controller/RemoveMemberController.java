package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberService;
import vo.Member;

/**
 * Servlet implementation class RemoveMemberController
 */
@WebServlet("/member/removeMember")
public class RemoveMemberController extends HttpServlet {
   private MemberService memberService;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 회원탈퇴 form
		request.getRequestDispatcher("/WEB-INF/view/removeMember.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 회원탈퇴 action
		
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		
		// debug
		System.out.println("RemoveMemberController memberId --> " + memberId);
		System.out.println("RemoveMemberController memberPw --> " + memberPw);
		
	    memberService = new MemberService();
	    
	    if(memberService.removeMember(memberId, memberPw)) { // memberService.removeMember == true
	    	System.out.println("RemoveMemberController 회원탈퇴 성공");
			response.sendRedirect(request.getContextPath()+"/member/logout"); // 세션 정보 삭제
	        return;
	    } else {
	    	System.out.println("RemoveMemberController 회원탈퇴 실패");
	    	response.sendRedirect(request.getContextPath()+"/member/removeMember");
	    }
	}

}
