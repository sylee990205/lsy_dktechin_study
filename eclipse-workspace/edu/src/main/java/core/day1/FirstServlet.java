package core.day1;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("FirstServlet 실행.....");
		//ContentType을 지정, 생략 시 html 태그는 html 태그로 처리되나 charset은 utf-8이 아님. 한글이 깨짐
		response.setContentType("text/html; charset=utf-8");
		//getWriter로 사용자에게 전달 가능
		PrintWriter out = response.getWriter(); 
		out.print("<h1>안녕? Servlet!</h1>");
		out.close();
	}
}