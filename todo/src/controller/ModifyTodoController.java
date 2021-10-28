package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.TodoService;
import vo.Todo;

@WebServlet("/member/modifyTodo")
public class ModifyTodoController extends HttpServlet {
   private TodoService todoService;
   
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   
      int todoNo = Integer.parseInt(request.getParameter("todoNo"));
      Todo todo = new Todo();
      todo.setTodoNo(todoNo);
      
      todoService = new TodoService();
      Todo oneTodo = todoService.getTodoOne(todoNo);
      
      // debug
      System.out.println(todo + " <-- ModifyTodoController.doGet param todo");
      System.out.println(oneTodo + " <-- ModifyTodoController.doGet param oneTodo");
      
      request.setAttribute("oneTodo", oneTodo);
      request.getRequestDispatcher("/WEB-INF/view/modifyTodo.jsp").forward(request, response);
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   
      String todoContent = request.getParameter("todoContent");
      int todoNo = Integer.parseInt(request.getParameter("todoNo"));
      String memberId = request.getParameter("memberId");
      String todoDate = request.getParameter("todoDate");
      
      Todo todo = new Todo();
      todo.setTodoContent(todoContent);
      todo.setTodoNo(todoNo);
      todo.setMemberId(memberId);
      todo.setTodoDate(todoDate);
      
      // debug
      System.out.println(todo + " <-- ModifyTodoController.doPost param todo");
      System.out.println(todoDate + " <-- ModifyTodoController.doPost param todoDate");
      
      todoService = new TodoService();
      if(todoService.modifyTodo(todo) == true) {
         System.out.println("todo 수정성공");
      }
      
	  // todoDate 
      String y = todoDate.substring(0,4);
      String m = todoDate.substring(5,7);
      String d = todoDate.substring(8,10);
      
      response.sendRedirect(request.getContextPath()+"/member/todoList?y="+y+"&m="+m+"&d="+d);
   }

}