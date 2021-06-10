package kr.smhrd.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.smhrd.model.BoardDAOMybatis;
import kr.smhrd.model.BoardVO;

public class AjaxBoardListController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		BoardDAOMybatis dao = new BoardDAOMybatis();
		List<BoardVO> list = dao.boardList();
		// Gson API
		Gson g= new Gson();
		String bList = g.toJson(list); // [{    }, {    }, {    }]
		//System.out.println(bList);
		response.setContentType("text/json;charset=euc-kr");
		PrintWriter out = response.getWriter();
		out.println(bList);
		
		return null;
	}

}
