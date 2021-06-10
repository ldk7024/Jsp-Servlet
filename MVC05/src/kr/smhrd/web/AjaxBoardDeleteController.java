package kr.smhrd.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.smhrd.model.BoardDAOMybatis;

public class AjaxBoardDeleteController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		BoardDAOMybatis dao = new BoardDAOMybatis();
		int cnt = dao.boardDelete(idx);
		// 응답? 형식상 보내기
		PrintWriter out = response.getWriter();
		out.println(cnt);
		return null;
	}

}
