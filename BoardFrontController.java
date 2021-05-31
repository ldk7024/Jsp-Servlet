package kr.smhrd.frontcontroller;


import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.smhrd.model.BoardDAO;
import kr.smhrd.model.BoardVO;
import kr.smhrd.web.BoardListController;


@WebServlet("*.do") //전체 매핑
//FrontController 패턴
public class BoardFrontController extends HttpServlet {   
protected void service(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
   // 1.클라이언트가 어떤요청을 했는지 알아보는 것
   request.setCharacterEncoding("utf-8");
   String reqUrl = request.getRequestURI();
   System.out.println(reqUrl);
   String reqPath = request.getContextPath(); // /MVC02
   System.out.println(reqPath);
   
   String command = reqUrl.substring(reqPath.length()); // 앞에 MVC02 점프하고 뒷부분만 출력
   System.out.println(command);
   // 2.요청에따른 분기작업(if~ else if~)
   BoardDAO dao = new BoardDAO(); //모델 생성
   
   
   if(command.equals("/list.do")) {
    BoardListController controller = new BoardListController();
    String view = controller.requestHandler(request, response);
    RequestDispatcher rd = request.getRequestDispatcher(view);
    rd.forward(request, response);
  
   }else if(command.equals("/register.do")){
      //1. 파라메터 수집(VO)
      String title = request.getParameter("title");
      String contents = request.getParameter("contents");
      String writer = request.getParameter("writer");
      BoardVO vo = new BoardVO(); //객체만들기
      vo.setTitle(title);
      vo.setContents(contents);
      vo.setWriter(writer);
      
      try {
            int cnt=dao.boardInsert(vo);
            if (cnt>0) {
                 //저장성공후 -> 다시 리스트페이지로 가기(/list.do)
                //redirect 기법(서버에서 전화돌리기 ->요청돌리기)
               response.sendRedirect("list.do");
            }else {
               throw new ServletException("error"); //예외처리
            }
         } catch (Exception e) {
            e.printStackTrace();
            
         }
   }else if(command.equals("/registerForm.do")) {
      //글쓰기화면으로 이동
      RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/boardForm.jsp");
      rd.forward(request, response);
   }else if(command.equals("/update.do")) {
      //1. 파라메터 수집(VO)
      String title = request.getParameter("title");
      String contents = request.getParameter("contents");
      int idx = Integer.parseInt(request.getParameter("idx")); //String->int로 받기 위함
      BoardVO vo = new BoardVO();
        vo.setTitle(title);
        vo.setContents(contents);
        vo.setIdx(idx);
            
      try {
         int cnt = dao.boardUpdate(vo);
         if(cnt > 0) {
            response.sendRedirect("list.do");
         }else {
              throw new ServletException("error"); 
         }
      } catch (Exception e) {
         
         e.printStackTrace();
      }   
   }else if(command.equals("/content.do")) {
      int idx = Integer.parseInt(request.getParameter("idx")); // String->int로 받기 위함
      
      try {
         BoardVO vo = dao.boardContent(idx);
         // 상세보기페이지로 이동 :boardContent.jsp
         request.setAttribute("vo", vo);//객체바인딩
         RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/boardContent.jsp");
         rd.forward(request, response);
         
      } catch (Exception e) {
         e.printStackTrace();
      }
   }else if(command.equals("/delete.do")) {
      int idx = Integer.parseInt(request.getParameter("idx")); //String->int로 받기 위함
               
      try {
         int cnt = dao.boardDelete(idx);
         //redirect
         if(cnt > 0) {
            response.sendRedirect("list.do"); // /MVC01/list.do
         }else {
            throw new ServletException("error");//WAS(Tomcat) 에러 던지기
         }
      } catch (Exception e) {      
         e.printStackTrace();
      }
   }
}

}