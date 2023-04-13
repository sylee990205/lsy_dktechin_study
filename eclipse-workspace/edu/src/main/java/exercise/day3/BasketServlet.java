package exercise.day3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/basket")
public class BasketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/JSON; charset=utf-8"); //default 응답 HTML임, json은 application으로 하자! 한글이 없으면 utf-8 생략 가능
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		if(session.getAttribute("product") == null) {
			session.setAttribute("product", new int[10]);
		}
		int[] count = (int[])session.getAttribute("product");
		String id = request.getParameter("id");
		if(id == null) {
			session.invalidate();
			out.print("{ \"msg\" : \"상품이 모두 삭제되었습니다.\" }");
			out.close();
		} else {
			int idIndex = Integer.parseInt(id.substring(1)) - 1;
			count[idIndex]++;
			String jsons = "";
			
			for(int i = 0; i < count.length; i++) {
				if(i == count.length-1) {
					jsons += "\"p0" + (i + 1) + "\" : \"" + count[i] +"\"";
					break;
				}
				else {
					jsons += "\"p00" + (i + 1) + "\" : \"" + count[i] +"\"";
					jsons += ",";
				}
			}
			
			out.print("{" + jsons + "}");
			out.close();
		}
	}

}
