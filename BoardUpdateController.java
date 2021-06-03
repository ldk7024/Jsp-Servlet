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

public class BoardUpdateController implements Controller{   //인터페이스 상속
   public String requestHandler(HttpServletRequest request, HttpServletResponse response) 
              throws ServletException, IOException {
      //0. 요청객체에 한글을 인코딩처리(한글 안깨지게 해주기 위함)
       request.setCharacterEncoding("utf-8");
      //1. 파라메터 수집(VO)
      String title = request.getParameter("title");
      String contents = request.getParameter("contents");
      int idx = Integer.parseInt(request.getParameter("idx")); //String->int로 받기 위함
      BoardVO vo = new BoardVO();
        vo.setTitle(title);
        vo.setContents(contents);
        vo.setIdx(idx);
        
        String view = null;
      //BoardDAO dao = new BoardDAO();
        BoardDAOMybatis dao = new BoardDAOMybatis();
      try {
         int cnt = dao.boardUpdate(vo);
         if(cnt > 0) {
            //response.sendRedirect("list.do");
            view = "redirect:/list.do";
         }else {
              throw new ServletException("error"); 
         }
      } catch (Exception e) {
         
         e.printStackTrace();
      }
      return view;
   }

}