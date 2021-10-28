package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import commons.DBUtil;
import dao.MemberDao;
import dao.TodoDao;
import vo.Todo;

public class TodoService {
	private TodoDao todoDao;
	
	public List<Todo> getTodoListByDate(Todo todo) {
		List<Todo> list = null;
		Connection conn = null;
		
		try {
			conn = DBUtil.getConnection("jdbc:mariadb://127.0.0.1:3307/todo", "root", "wkqk1004");
			todoDao = new TodoDao();
			list = todoDao.selectTodoListByDate(conn, todo);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;		
	}
	
	public void addTodo(Todo todo) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection("jdbc:mariadb://127.0.0.1:3307/todo", "root", "wkqk1004");
			todoDao = new TodoDao();
			todoDao.insertTodo(conn, todo);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void removeTodoList(Todo todo) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection("jdbc:mariadb://127.0.0.1:3307/todo", "root", "wkqk1004");
			todoDao = new TodoDao();
			todoDao.deleteTodoList(conn, todo);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
   public boolean modifyTodo(Todo todo) {
      boolean result = false;
      Connection conn = null;
      try {
         conn = DBUtil.getConnection("jdbc:mariadb://127.0.0.1:3307/todo", "root", "wkqk1004");
         todoDao = new TodoDao();
         result = todoDao.updateTodo(conn, todo);
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         try {
            conn.close();
         } catch (SQLException e) {
            e.printStackTrace();
         }
      }
      return result;
   }
   
   public Todo getTodoOne(int todoNo) {
      Todo todo = null;
      Connection conn = null;
      try {
         conn = DBUtil.getConnection("jdbc:mariadb://127.0.0.1:3307/todo", "root", "wkqk1004");
         todoDao = new TodoDao();
         todo = todoDao.selectTodoOne(conn, todoNo);
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         try {
            conn.close();
         } catch (SQLException e) {
            e.printStackTrace();
         }
      }
      return todo;
   }
	
}
