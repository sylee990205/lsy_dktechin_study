package controller;

import java.io.IOException;
import java.time.LocalTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.domain.TimeVO;


@WebServlet("/lotto1")
public class LottoServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int inputNum = Integer.parseInt(request.getParameter("inputNum"));
		int lottoNum = (int) ( (Math.random() * 6) + 1);
		System.out.printf("전달된 값 : %d, 추출된 값 : %d\n",inputNum,lottoNum);
		LocalTime time = LocalTime.now();
		TimeVO currentTime = new TimeVO(time.getHour(), time.getMinute());
		request.setAttribute("time", currentTime);
		RequestDispatcher rd;
		if(inputNum == lottoNum) {
			rd = request.getRequestDispatcher("/jspexam/success.jsp");
			rd.forward(request, response);
		} else {
			rd = request.getRequestDispatcher("/jspexam/fail.jsp");
			rd.forward(request, response);
		}
		
	}

}
