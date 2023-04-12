package exercise.day2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/reservation")
public class ReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("guestName");
		String pw = request.getParameter("password");
		
		if(name.isBlank()) {
			RequestDispatcher rd = request.getRequestDispatcher("first.html");
			rd.forward(request, response);
			return;
		}
		
		if(pw.isBlank()){
			response.sendRedirect("http://www.daum.net/");
			return;
		}
		
		String room = request.getParameter("room");
		String[] option = request.getParameterValues("option");
		String dateString = request.getParameter("date");
	
		out.print("<h1>" + name + "님의 예약내용</h1><hr><ul>");
		out.print("<li> 룸 : " + room + "</li>");
		out.print("<li> 추가 요청 사항 : ");
		if(option == null) {
			out.print("없음 </li>");
		}
		else {
			for(int i = 0; i < option.length; i++) {
				out.print(option[i]);
				if(i == option.length - 1) {
					out.print("</li>");
				}
				else {
					out.print(", ");
				}
			}
		}
		
		if(dateString == null || dateString.isBlank()) {
			out.print("<li> 예약날짜가 선택되지않았습니다. 다시 선택해주세요.");
		} else {
			out.print("<li> 예약날짜 : ");
			String[] date = dateString.split("-");
			date[0] += "년";
			date[1] += "월";
			date[2] += "일";
			for(String d : date) {
				out.print(d + " ");
			}
		}
		out.print("</li></ul>");
		out.print("<h4><a href = '" + request.getHeader("referer") + "'>예약입력화면으로</h4>");
		out.close();
	}

}
