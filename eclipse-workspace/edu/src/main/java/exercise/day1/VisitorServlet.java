package exercise.day1;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/visitor")
public class VisitorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("name");
		String comment = request.getParameter("comment");
		LocalDate date = LocalDate.now(); // 날짜 계산은 언제나 그때그때 계산해야함 user가 언제 했는지
		
		out.print("<h2>" + userName + "님이 " + date.getYear() + "년 " + date.getMonthValue() + "월 " + 
				date.getDayOfMonth() +"일에 남긴 글입니다. </h2><hr>");
		out.println(comment);
		out.print("<h4><a href='"+request.getHeader("referer")+"'> 입력화면으로</h4>");
		out.close();
	}

}
