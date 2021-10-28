package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import commons.DBUtil;
import dao.TodoDao;
import vo.Todo;

public class CalendarService {
	
	private TodoDao todoDao;

	public Map<String, Object> getTargetCalendar(String memberId, String currentYear, String currentMonth, String option) { // option : pre, next
		// 1. 달력 코드
		Map<String, Object> map = new HashMap<>();
		
		// 오늘 날짜의 년도와 월을 가진다 -> 매개값이 모두 null일 때
		Calendar c = Calendar.getInstance();
		
		// 입력한 년도와 월값이 있다 -> 매개값이 null이 아닐 때
	    if(currentYear != null && currentMonth != null) {
	       int y = 0;
		   int m = 0;
	       y = Integer.parseInt(currentYear);
	       m = Integer.parseInt(currentMonth);
	       // 1월 ~ 12월
	       if(option != null && option.equals("pre")) {
	          m = m-1; // ISSUE : 0 일 때
	          if(m == 0) {
	             m = 12;
	             y--;
	          }
	       } else if(option != null && option.equals("next")) {
	          m = m+1; // ISSUE : 13 일 때
	          if(m == 13) {
	             m = 1;
	             y++;
	          }
	       }
	       c.set(Calendar.YEAR, y);
	       // 0월 ~ 11월
	       c.set(Calendar.MONTH, m-1);
	    }

		c.set(Calendar.DATE, 1); // c객체 오늘의 정보 -> 같은 달 1일로 변경
		
		// 달력에 필요한 데이터
		int targetYear = c.get(Calendar.YEAR);
		int targetMonth = c.get(Calendar.MONTH) + 1;
		int endDay = c.getActualMaximum(Calendar.DATE);
		
		// 달력 앞,뒤 공백의 수
		int startBlank = 0; // 현재 타겟이 되는 달의 1일의 요일 -> 일0 월1 화2 수3 목4 금5 토6
		startBlank = c.get(Calendar.DAY_OF_WEEK) - 1;
		
		int endBlank = 0; // 전체 <td>의 개수 = startBlanck + endDay + endBlank <- 이 값이 7로 나누어 떨어지도록
		endBlank = 7 - ((startBlank + endDay) % 7);
		if(endBlank == 7) {
			endBlank = 0;
		}
		
		map.put("targetYear", targetYear);
		map.put("targetMonth", targetMonth);
		map.put("endDay", endDay);
		map.put("startBlank", startBlank);
		map.put("endBlank", endBlank);
		
		// 2. 달력에 추가할 모델(todo)생성 코드
		List<Todo> list = null;
		Connection conn = null;
		
		try {
			conn = DBUtil.getConnection("jdbc:mariadb://127.0.0.1:3307/todo", "root", "wkqk1004");
			todoDao = new TodoDao();
			Todo todo = new Todo();
			// memberId <-- 매개변수로 입력
			// tododate의 년월 <- targetYear와 targetMonth를 사용
			todo.setMemberId(memberId);
			String strYear = ""+targetYear;
			String strMonth = ""+targetMonth;
			if(targetMonth < 10) {
				strMonth = "0"+targetMonth;
			}
			todo.setTodoDate(strYear+"-"+strMonth);
			
			// debug
			System.out.println(todo);
			
			list = todoDao.selectTodoListByMonth(conn, todo);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		map.put("todoList", list);
		
		return map;
	}
}
