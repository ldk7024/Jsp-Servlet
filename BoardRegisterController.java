package kr.smhrd.web;

import java.awt.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Catch;

import kr.smhrd.model.BoardDAO;
import kr.smhrd.model.BoardDAOMybatis;
import kr.smhrd.model.BoardVO;


public class BoardRegisterController implements Controller {

	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		     

		// 1. 파라메터 수집 (VO에 수집해야함)
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		String writer = request.getParameter("writer");

		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setContents(contents);
		vo.setWriter(writer);
		String view =null;
		BoardDAOMybatis dao = new BoardDAOMybatis();

		try {
			int cnt = dao.boardInsert(vo);
			if (cnt > 0) {
				// 저장 성공후 -> 다시 리스트 페이지로 가기 (/list.do)
				// redirect 기법 (서버에서 전화돌리기 -> 요청돌리기)
				// response.sendRedirect("list.do");
				view = "redirect:/list.do";
			} else {
				throw new ServletException("error"); // 예외처리
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return view;
	}
}
