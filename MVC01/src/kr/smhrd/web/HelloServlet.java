package kr.smhrd.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
           // 서블릿 클래스 기본 틀
@WebServlet ("/hs.do")
public class HelloServlet extends HttpServlet {
	// 웹으로 실행할 수 있는 형태로 바꿔주는 것
	// Servlet(서블릿): 100% 자바로 된 웹 프로그래밍
	// 요청, 응답 -> 매개변수가 두개있어야함
	//                                  요청객체                          응답개체
	public void service(HttpServletRequest req, HttpServletResponse res) 
	throws ServletException, IOException{
		// HelloServlet 이라는 문자열을 출력해보자
		PrintWriter out = res.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("HelloServlet");
		out.println("</body>");
	    out.println("</html>");
	
	}
	

}
