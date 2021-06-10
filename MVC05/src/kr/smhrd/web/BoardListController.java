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
import kr.smhrd.model.BoardDAOMybatis;
import kr.smhrd.model.BoardVO;



public class BoardListController  implements Controller{   
   public String requestHandler(HttpServletRequest request, HttpServletResponse response) 
                                         throws ServletException, IOException {
       // 1. Model을 시켜먹어야 함.
      // BoardDAO dao = new BoardDAO();
      BoardDAOMybatis dao = new BoardDAOMybatis();
      try {
         List<BoardVO> list = dao.boardList();
         // 요청한 클라이언트로 게시판 목록을 응답하기(JSP)
         //System.out.println(list.toString());
         //Boardlist.jsp : 요청의뢰
         request.setAttribute("list", list);//객체바인딩
//         RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/Boardlist.jsp");//요청의뢰
//         rd.forward(request, response);//포워드(foward)
      } catch (Exception e) {         
         e.printStackTrace();
      }
      
      return "boardList";
   }

}