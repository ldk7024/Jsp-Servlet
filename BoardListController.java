package kr.smhrd.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.smhrd.model.BoardDAO;
import kr.smhrd.model.BoardVO;


@WebServlet("/list.do")
public class BoardListController extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
            BoardDAO dao = new BoardDAO();
          try { 
        	List<BoardVO> list = dao.boardList();
      	    // 요청한 클라이언트로 게시판 목록을 응답하기 (JSP)
        	// system.out.println(list.toString());
        	response.setContentType("text/html;charset = euc-kr");
        	PrintWriter out = response.getWriter();
			out.println("<html>");
			out.println("<body>");
			out.println("<table border ='1' width = '600px'>");
			out.println("<tr>");
			out.println("<td>번호</td>");
			out.println("<td>제목</td>");
			out.println("<td>조회수</td>");
			out.println("<td>작성자</td>");
			out.println("<td>작성일</td>");
			out.println("<td>삭제</td>");
			out.println("</tr>");
			for (BoardVO vo : list) {
				out.print("<tr>");
				out.print("<td>"+vo.getIdx()+"</td>");	
				out.print("<td>"+vo.getTitle()+"</td>");
				out.print("<td>"+vo.getCount()+"</td>");
	            out.print("<td>"+vo.getWriter()+"</td>");
				out.print("<td>"+vo.getIndate()+"</td>");
				out.print("<td><a href ='/MVC01/delete.do?idx="+vo.getIdx()+"'>삭제</a></td>");
				out.print("</tr>");
			}
			out.println("<tr>");
			out.println("<td colspan ='6'>");
			out.println("<input type='button' onclick=\"location.href='boardForm.html'\" value='글쓰기'>");
			out.println("</td>");
			out.println("</tr>");
			out.println("</table>");
			out.println("</body>");
			out.println("</html>");
		} catch (Exception e) {
			e.printStackTrace();
		}
           
	
	
	}

}
