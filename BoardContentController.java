package kr.smhrd.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.smhrd.model.BoardDAO;
import kr.smhrd.model.BoardVO;

@WebServlet("/content.do")
public class BoardContentController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		BoardDAO dao = new BoardDAO();
		try {
			BoardVO vo = dao.boardContent(idx);
			// 클라이언트에게 상세보기 페이지를 만들어서 응답
			response.setContentType("text/html; charset=euc-kr");
			PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<body>");
			out.println("<form action =/MVC01/update.do method ='post'>");
			out.println("<input type ='hidden' name ='idx' value ='"+vo.getIdx()+"'>");
			out.println("<table border ='1' width ='600px'>");
			out.println("<tr>");
			out.println("<td width ='100px'>번호</td>");
			out.println("<td>"+vo.getIdx() +"</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td width = '100px'>제목</td>");
			out.println("<td><input type = 'text' name ='title' value = '"+vo.getTitle()+"' size ='50'></td>");
		    out.println("</tr>");
		    out.println("<tr>");
			out.println("<td width = '100px'>내용</td>");
			out.println("<td><textarea rows ='8' cols = '80' name ='contents'>"+vo.getContents()+"</textarea></td>");
		    out.println("</tr>");
		    out.println("<tr>");
			out.println("<td width = '100px'>작성자</td>");
			out.println("<td>"+vo.getWriter()+"</td>");
		    out.println("</tr>");
		    out.println("<tr>");
			out.println("<td width = '100px'>작성일</td>");
			out.println("<td>"+vo.getIndate()+"</td>");
			out.println("</tr>");
		    out.println("<tr>");
		    out.println("<td colspan = '2'>");
		    out.println("<input type='submit' value='수정'>");
		    out.println("<input type='reset' value='취소'>");
		    out.println("<input type='button' onclick = \"location.href ='list.do' \" value='목록'>");
		    out.println("</td>");
		    out.println("</tr>");
		    out.println("</table>");
			out.println("</form>");
			out.println("</body>");
			out.println("</html>");
		} catch (Exception e) {
			
			e.printStackTrace();
		
		}
	
	
	
	}

}
