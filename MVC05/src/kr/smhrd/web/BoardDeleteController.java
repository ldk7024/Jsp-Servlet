package kr.smhrd.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.smhrd.model.BoardDAO;
import kr.smhrd.model.BoardDAOMybatis;



public class BoardDeleteController implements Controller{	        
	public String requestHandler(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		BoardDAOMybatis dao = new BoardDAOMybatis();
		String view = null;
		try {
			int cnt = dao.boardDelete(idx);
			// redirect
			if(cnt>0) {
//				response.sendRedirect("list.do");
				view = "redirect:/list.do";
			}else {
				throw new ServletException("error"); // WAS(Tomcat)
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return view;
	}

}
