package kr.smhrd.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.smhrd.model.BoardDAO;
import kr.smhrd.model.BoardDAOMybatis;
import kr.smhrd.model.BoardVO;


public class BoardUpdateController implements Controller{
	
	public String requestHandler(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		
//		request.setCharacterEncoding("utf-8");
				
		
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		int idx = Integer.parseInt(request.getParameter("idx"));
				
		BoardVO vo = new BoardVO(); 
				
		vo.setTitle(title);
		vo.setContents(contents);
		vo.setIdx(idx);
		String view = null;
		
		BoardDAOMybatis dao = new BoardDAOMybatis();
		try {
			int cnt = dao.boardUpdate(vo);
			if(cnt>0) {
//				response.sendRedirect("list.do");
				view = "redirect:/list.do";
			}else {
				throw new ServletException("error");
			}
		} catch(Exception e){
			e.printStackTrace();
		}
		return view;
		
	}

}
