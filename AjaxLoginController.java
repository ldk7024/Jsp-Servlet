package kr.smhrd.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.smhrd.model.BoardDAOMybatis;
import kr.smhrd.model.UserVO;

public class AjaxLoginController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String user_id = request.getParameter("user_id");
		String password = request.getParameter("password");
		
		UserVO vo = new UserVO();
		vo.setUser_id(user_id);
		vo.setPassword(password);
		
		BoardDAOMybatis dao = new BoardDAOMybatis();
		UserVO userVO=dao.loginMember(vo);
		
		PrintWriter out = response.getWriter();
		if(userVO!=null) {
			out.print("YES"); //인증성공
		}
		else {
			out.print("NO"); //인증실패
		}
		
		
		
		return null;
	}

}
