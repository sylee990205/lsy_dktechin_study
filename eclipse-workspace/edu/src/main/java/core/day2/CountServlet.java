package core.day2;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/CountServlet")
public class CountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		if(session.getAttribute("cnt") == null) { // session 객체는 한번만 만들면 되기에 체크하는 것
			session.setAttribute("cnt", new int[1]); // 계속 만들면 마지막에 만든 값으로 저장됨
		}
		int[] count = (int[])session.getAttribute("cnt"); // 한번 만든 이후엔 꺼내쓰기 이 때 return 값은 Object 강제 형변환해야함
		count[0]++;
		out.print("<h3>당신은 "+ count[0] + 
				                       "번째 방문입니다.</h3>");		
		out.close();
	}
}



