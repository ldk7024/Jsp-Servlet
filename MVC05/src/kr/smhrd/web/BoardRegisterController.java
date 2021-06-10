package kr.smhrd.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.smhrd.model.BoardDAO;
import kr.smhrd.model.BoardDAOMybatis;
import kr.smhrd.model.BoardVO;


public class BoardRegisterController implements Controller{
	public String requestHandler(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		
		// 0. 요청객체에 한글을 인코딩처리하기
		
		// 1. 파라미터 수집(VO)
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		String writer = request.getParameter("writer");
		
		BoardVO vo = new BoardVO(); // 객체 만들기
		
		vo.setTitle(title);
		vo.setContents(contents);
		vo.setWriter(writer);
		String view = null;
		BoardDAOMybatis dao = new BoardDAOMybatis();
		try {
			int cnt = dao.boardInsert(vo);
			if(cnt>0) {
				//저장 성공 후 -> 다시 리스트 페이지로 가기(/list.do)
				// redirect 기법 (서버에서 전화돌리기 -> 요청 돌리기)
//				response.sendRedirect("list.do");
				view = "redirect:/list.do";
			}else {
				throw new ServletException("error");
			}	
		} catch(Exception e) {
			e.printStackTrace();
		}
		return view;
		
//		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
//		list.add(vo);
//		list.add(vo);
//		list.add(vo);
//		
//		
//		System.out.println(vo.toString());
//		
//		// 받은 데이터를 클라이언트에 응답
//		response.setContentType("text/html;charset=euc-kr");
//		
//		PrintWriter out = response.getWriter();
//		
//		out.println("<table border='1'>");
//	    out.println("<thead>");
//	    out.println("<tr>");
//	    out.println("<th>제목</th>");
//	    out.println("<th>내용</th>");
//	    out.println("<th>작성자</th>");
//	    out.println("</tr>");
//	    out.println("</thead>");
//	    out.println("<tbody>");
//	    for(int i=0;i<list.size();i++) {
//	    	vo = list.get(i);
//	    	out.println("<tr>");
//	    	out.println("<td>"+vo.getTitle()+"</td>");
//	    	out.println("<td>"+vo.getContents().replaceAll("\n", "<br>")+"</td>");
//	    	out.println("<td>"+vo.getWriter()+"</td>");
//	    	out.println("</tr>");
//	    }
//	    out.println("</tbody>");
//	    out.println("</table>");
	}

}
