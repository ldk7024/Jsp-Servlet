package kr.smhrd.web;

import java.awt.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.smhrd.model.BoardVO;

@WebServlet("/register.do")
public class BoardRegisterController extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	       // 0. 요청객체에  한글을 인코딩 처리 
	        request.setCharacterEncoding("utf-8");
		   
		
		   // 1. 파라메터 수집 (VO에 수집해야함)
		   String title =request.getParameter("title");
		   String contents =request.getParameter("contents");  
		   String writer =request.getParameter("writer");
		   BoardVO vo = new BoardVO();
		   vo.setTitle(title);
		   vo.setContents(contents);
		   vo.setWriter(writer);
		   
		    ArrayList<BoardVO>list = new ArrayList<BoardVO>();
		    list.add(vo);
		    list.add(vo);
		    list.add(vo);
		   System.out.println(vo.toString()); //vo.toString()
		   
		   // 받은 데이터를 클라이언트에 응답
	       response.setContentType("text/html;charset = euc-kr");
	       PrintWriter out =response.getWriter();
	       out.println("<table border ='1'>");
	       out.println("<thead>");
	             out.println("<tr>");
	             out.println("<th>제목</th>");
	             out.println("<th>내용</th>");
	             out.println("<th>작성자</th>");
	             out.println("</tr>");
	             out.println("</thead>");
	             out.println("<tbody>");
	             for(int i =0;i<list.size();i++) {
	            	 out.println("<tr>");
	 	             out.println("<td>"+vo.getTitle()+"</td>");
	 	             out.println("<td>"+vo.getContents().replaceAll("\n", "<br>")+"</td>");
	 	             out.println("<td>"+vo.getWriter()+"</td>");
	 	             out.println("</tr>"); 
	             };
	             out.println("</tbody>");
	             out.println("</table>");
	}

}
