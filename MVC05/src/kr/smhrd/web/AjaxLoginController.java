package kr.smhrd.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.smhrd.model.BoardDAOMybatis;
import kr.smhrd.model.UserVO;

public class AjaxLoginController implements Controller {
	
	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String user_id = request.getParameter("user_id");
		String password = request.getParameter("password");
		
		UserVO vo = new UserVO();
		vo.setUser_id(user_id);
		vo.setpassword(password);
		
		BoardDAOMybatis dao = new BoardDAOMybatis();
		UserVO userVO = dao.loginMember(vo);
		
		PrintWriter out = response.getWriter();
		if(userVO!=null) {
			out.print("YES"); // 인증에 성공(1)
			// 객체바인딩 : 로그인에 성공했다는 사실을 모든 웹페이지가 공유할 수 있도록 해야한다. => 세션바인딩
			// HttpServletRequest, HttpSession
			
			HttpSession session = request.getSession();
			session.setAttribute("userVO", userVO); // -> ${userVO}
		}else {
			out.print("NO"); // 인증에 실패(0)			
		}
		
		return null;
	}

}
