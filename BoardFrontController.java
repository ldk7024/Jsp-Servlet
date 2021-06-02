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
import kr.smhrd.web.BoardContentController;
import kr.smhrd.web.BoardDeleteController;
import kr.smhrd.web.BoardListController;
import kr.smhrd.web.BoardRegisterController;
import kr.smhrd.web.BoardRegisterFormController;
import kr.smhrd.web.BoardUpdateController;
import kr.smhrd.web.Controller;

@WebServlet("*.do") // 전체 매핑
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
		BoardDAO dao = new BoardDAO(); // 모델 생성
		Controller controller = null;
		String view = null;
		// HandlerMapping (핸들러매핑)
	       HandlerMapping mappings = new HandlerMapping();
	       controller = mappings.getController(command);
		// --------------------------------------------------------------
		view = controller.requestHandler(request, response);
		if (view != null) {
			if (view.indexOf("redirect:/") != -1) {
				response.sendRedirect(view.split(":/")[1]); // view = redirect:/list.do
			}

			else {
				RequestDispatcher rd = request.getRequestDispatcher(viewResolver.makeurl(view)); // boardList
				rd.forward(request, response);

			}

		}
	}

}