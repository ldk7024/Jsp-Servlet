package kr.smhrd.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.smhrd.model.BoardDAO;
import kr.smhrd.model.BoardVO;


@WebServlet("/list.do") // 서블릿 맵핑
public class BoardListController extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
            
		  // 1. model을 시켜먹어야한다.
		  BoardDAO dao = new BoardDAO();
          try { 
        	  
        	  
        	  
        	List<BoardVO> list = dao.boardList();
      	    // 요청한 클라이언트로 게시판 목록을 응답하기 (JSP)
        	// system.out.println(list.toString());
            // boardList.jsp: 요청을 의뢰하자!
        	request.setAttribute("list", list);
        	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/boardList.jsp");
        	rd.forward(request, response);
        	
		} catch (Exception e) {
			e.printStackTrace();
		}
           
	
	
	}

}
