package dao;

public class TodoQuery {
	public static final String DELETE_TODO;
	public static final String SELECT_TODO_LIST_BY_DATE;
	public static final String INSERT_TODO;
	public static final String SELECT_TODO_LIST_BY_MONTH;
	public static final String DELETE_TODO_LIST;
	public static final String UPDATE_TODO;
	public static final String SELECT_TODO_ONE;
	
	static {
		DELETE_TODO = "DELETE FROM todo WHERE member_id=?";
		SELECT_TODO_LIST_BY_DATE = "SELECT todo_no todoNo, todo_date todoDate, todo_content todoContent, create_date createDate, update_date updateDate FROM todo WHERE member_id=? AND todo_date=?";
		INSERT_TODO = "INSERT INTO todo (member_id, todo_date, todo_content, create_date, update_date) values (?, ?, ?, NOW(), NOW())";
		SELECT_TODO_LIST_BY_MONTH = "SELECT todo_date todoDate, SUBSTR(todo_content, 1, 5) todoContent5 FROM todo WHERE member_id=? AND SUBSTR(todo_date, 1, 7)=? ORDER BY todo_date ASC";
		DELETE_TODO_LIST = "DELETE FROM todo WHERE member_id=? AND todo_no=?";
		UPDATE_TODO = "UPDATE todo SET todo_content=?, update_date=now() WHERE todo_no=? AND member_id=?";
		SELECT_TODO_ONE = "SELECT todo_no todoNo, todo_date todoDate, todo_content todoContent, create_date createDate, update_date updateDate FROM todo WHERE todo_no=?";
	}
}
