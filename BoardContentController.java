package kr.smhrd.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.smhrd.model.BoardDAO;
import kr.smhrd.model.BoardDAOMybatis;
import kr.smhrd.model.BoardVO;


public class BoardContentController implements Controller {
	public String requestHandler(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		BoardDAOMybatis dao = new BoardDAOMybatis();
		try {
			BoardVO vo = dao.boardContent(idx);
			// 상세보기 페이지로 이동: boardContent.jsp
			 request.setAttribute("vo", vo);
	         // RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/boardContent.jsp");
	         // rd.forward(request, response);
        	
		} catch (Exception e) {
			
			e.printStackTrace();
		
		}
	
	   return "boardContent"; //ViewName 논리적인 뷰의 이름 -> /WEB-INF/views/boardContent.jsp (물리적인 경로) -> 물리적인 경로를 논리적인 뷰로 바꾸기 위해서 ViewResolver로 바꿔줌 -> 유지보수가 쉬워짐
	
	}

}
