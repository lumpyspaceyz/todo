package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.Todo;

public class TodoDao {
	public void deleteTodo(Connection conn, String memberId) throws SQLException {
		String sql = TodoQuery.DELETE_TODO;
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, memberId);
		stmt.executeUpdate();
		stmt.close();
	}
	
	public List<Todo> selectTodoListByDate(Connection conn, Todo todo) throws SQLException {
		List<Todo> list = new ArrayList<Todo>();
		String sql = TodoQuery.SELECT_TODO_LIST_BY_DATE;
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, todo.getMemberId());
		stmt.setString(2, todo.getTodoDate());
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			Todo t = new Todo();
			t.setTodoNo(rs.getInt("todoNo"));
			t.setTodoDate(rs.getString("todoDate"));
			t.setTodoContent(rs.getString("todoContent"));
			t.setCreateDate(rs.getString("createDate"));
			t.setUpdateDate(rs.getString("updateDate"));
			list.add(t);
		}
		return list;
	}
	
	public void insertTodo(Connection conn, Todo todo) throws SQLException {
		// debug
		System.out.println(todo);
		
		String sql = TodoQuery.INSERT_TODO;
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, todo.getMemberId());
		stmt.setString(2, todo.getTodoDate());
		stmt.setString(3, todo.getTodoContent());
		stmt.executeUpdate();
		stmt.close();
	}
	
	public List<Todo> selectTodoListByMonth(Connection conn, Todo todo) throws SQLException {
		List<Todo> list = new ArrayList<Todo>();
		String sql = TodoQuery.SELECT_TODO_LIST_BY_MONTH;
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, todo.getMemberId());
		stmt.setString(2, todo.getTodoDate().substring(0, 7));
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			Todo t = new Todo();
			t.setTodoDate(rs.getString("todoDate"));
			t.setTodoContent(rs.getString("todoContent5"));
			list.add(t);
		}
		return list;
	}
	
	public void deleteTodoList(Connection conn, Todo todo) throws SQLException {
		// debug
		System.out.println(todo + " <-- TodoDao.deleteTodoList param todo");
		
		String sql = TodoQuery.DELETE_TODO_LIST;
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, todo.getMemberId());
		stmt.setInt(2, todo.getTodoNo());
		stmt.executeUpdate();
		stmt.close();
	}
	
   public boolean updateTodo(Connection conn, Todo todo) throws SQLException {
	  boolean result = false;
	      
	  // debug
	  System.out.println(todo + " <-- TodoDao.updateTodo param todo");
      
      String sql = TodoQuery.UPDATE_TODO;
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setString(1, todo.getTodoContent());
      stmt.setInt(2, todo.getTodoNo());
      stmt.setString(3, todo.getMemberId());
      int row = stmt.executeUpdate();
      if(row == 1) {
         result = true;
      }
      System.out.println(stmt);
      stmt.close();
      return result;
   }
   
   public Todo selectTodoOne(Connection conn, int todoNo) throws SQLException {
      Todo todo = null;
      
      // debug
      System.out.println(todoNo + " <-- TodoDao.selectTodoOne param todoNo");
      
      String sql = TodoQuery.SELECT_TODO_ONE;
      PreparedStatement stmt = conn.prepareStatement(sql);
      stmt.setInt(1, todoNo);

      ResultSet rs = stmt.executeQuery();
      while(rs.next()) {
         todo = new Todo();
         todo.setTodoNo(todoNo);
         todo.setTodoDate(rs.getString("todoDate"));
         todo.setTodoContent(rs.getString("todoContent"));
      }
      stmt.close();
      
      return todo;
   }

}
