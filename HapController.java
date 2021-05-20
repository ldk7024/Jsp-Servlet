package kr.smhrd.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.smhrd.util.MyUtil;



@WebServlet("/web.do") // mapping -> Tomcat
public class HapController extends HttpServlet{
   
   //                                요청객체                              응답객체   
   public void service(HttpServletRequest req,HttpServletResponse res) 
      throws ServletException, IOException{ 
	   // 1. 클라이언트로부터 넘어온 폼파라메터 (su1, su2)를 가져오기 (파라메터수집)
	   int su1 = Integer.parseInt(req.getParameter("su1"));
	   int su2 = Integer.parseInt(req.getParameter("su2"));
	   // string -> int
      // 2. Model과 연동하자 (비즈니스로직을 밖으로 빼자)
	  MyUtil my = new MyUtil();
      int hap = my.hap(su1, su2);
     
      //3. 요청한 클라이언트로 응답하기
      PrintWriter out = res.getWriter();
      
      out.println("<html>");
      out.println("<body>");
      out.println(hap);
      out.println("</body>");
      out.println("</html>");
   }
      
}
   

