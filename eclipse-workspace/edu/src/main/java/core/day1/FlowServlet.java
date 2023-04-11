package core.day1;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/flow")
public class FlowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public FlowServlet() {
        super();
        System.out.println("FlowServlet 객체 생성....");
    }
    //HttpServlet의 method를 overriding
	public void init(ServletConfig config) throws ServletException { 
		// servlet 요청 시 한번만 수행되게 하려면 init 
		System.out.println("init() 메서드 호출....");
	}
	public void destroy() {
		// 서버가 종료될 때 or 자동 reload가 수행됐을 때 destroy 수행
		// 마지막에 한번 처리되게 할려면 destroy에
		System.out.println("destroy() 메서드 호출....");
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// servlet을 요청할때 마다 수행되는게 service
		System.out.println("service() 메서드 호출....");
	}

}
