package kr.smhrd.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.smhrd.model.BoardDAOMybatis;
import kr.smhrd.model.BoardVO;

public class AjaxBoardContentController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		BoardDAOMybatis dao = new BoardDAOMybatis();
		
		BoardVO vo = dao.boardContent(idx);
		// vo => json : {}
		Gson g = new Gson();
		String data = g.toJson(vo);
		
		response.setContentType("text/json;charset=euc-kr");
		PrintWriter out = response.getWriter();
		out.println(data);
		
		return null;
	}

}
