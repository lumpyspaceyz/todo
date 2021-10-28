package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.TodoService;
import vo.Member;
import vo.Todo;

/**
 * Servlet implementation class AddTodoController
 */
@WebServlet("/member/addTodo")
public class AddTodoController extends HttpServlet {
	private TodoService todoService;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String todoDate = request.getParameter("todoDate");
		String todoContent = request.getParameter("todoContent");
		String memberId = ((Member)(request.getSession().getAttribute("loginMember"))).getMemberId();
		
		Todo todo = new Todo();
		todo.setTodoDate(todoDate);
		todo.setTodoContent(todoContent);
		todo.setMemberId(memberId);
		
		todoService = new TodoService();
		todoService.addTodo(todo);
		
		// todoDate 
		String y = todoDate.substring(0,4);
		String m = todoDate.substring(5,7);
		String d = todoDate.substring(8,10);
		
		// todoDate의 todoList
		response.sendRedirect(request.getContextPath()+"/member/todoList?y="+y+"&m="+m+"&d="+d);
	}

}
