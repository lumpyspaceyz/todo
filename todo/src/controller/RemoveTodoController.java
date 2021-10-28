package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberService;
import service.TodoService;
import vo.Member;
import vo.Todo;

/**
 * Servlet implementation class RemoveTodoController
 */
@WebServlet("/member/removeTodo")
public class RemoveTodoController extends HttpServlet {
	private TodoService todoService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String memberId = ((Member)(request.getSession().getAttribute("loginMember"))).getMemberId();
		int todoNo = Integer.parseInt(request.getParameter("todoNo"));
		String todoDate = request.getParameter("todoDate");
		
		Todo todo = new Todo();
		todo.setMemberId(memberId);
		todo.setTodoNo(todoNo);
		
		todoService = new TodoService();
		todoService.removeTodoList(todo);
		
		// todoDate 
		String y = todoDate.substring(0,4);
		String m = todoDate.substring(5,7);
		String d = todoDate.substring(8,10);
		
       // debug
       System.out.println(todoNo + " <-- RemoveTodoController.doGet param todo");
       System.out.println(y + " <-- RemoveTodoController.doGet param y");
       System.out.println(m + " <-- RemoveTodoController.doGet param m");
       System.out.println(d + " <-- RemoveTodoController.doGet param d");
		
       // todoDate의 todoList
       response.sendRedirect(request.getContextPath()+"/member/todoList?y="+y+"&m="+m+"&d="+d);
	}

}
