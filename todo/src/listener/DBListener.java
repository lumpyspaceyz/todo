package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener // @WebListener 이 빠지면 드라이버 로딩이 안 됨
public class DBListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce)  { 
        try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    }
}
