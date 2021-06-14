package Model;

import java.util.HashMap;

import Web.LoginCheckController;
import Web.LogoutCheckController;
import kr.smhrd.web.AjaxBoardContentController;
import kr.smhrd.web.AjaxBoardDeleteController;
import kr.smhrd.web.AjaxBoardListController;
import kr.smhrd.web.AjaxBoardRegisterController;
import kr.smhrd.web.AjaxBoardUpdateController;
import kr.smhrd.web.AjaxLoginController;
import kr.smhrd.web.AjaxLogoutController;
import kr.smhrd.web.BoardContentController;
import kr.smhrd.web.BoardDeleteController;
import kr.smhrd.web.BoardListController;
import kr.smhrd.web.BoardLoginController;
import kr.smhrd.web.BoardLogoutController;
import kr.smhrd.web.BoardRegisterController;
import kr.smhrd.web.BoardRegisterFormController;
import kr.smhrd.web.BoardUpdateController;
import kr.smhrd.web.CalcController;
import kr.smhrd.web.Controller;

public class HandlerMapping {
	private HashMap<String, Web.Controller> mappings;
	
	public HandlerMapping() {
		mappings = new HashMap<String, Web.Controller>();
		mappings.put("/logincheck.go", new LoginCheckController());
		mappings.put("/logoutCheck.go", new LogoutCheckController());
	

		
		
	}
	public Web.Controller getController(String command) {
		return mappings.get(command);
	}
}	
	
//	if (command.equals("/list.do")) {
//		controller = new BoardListController();			
//				
//	} else if (command.equals("/register.do")) {
//		controller = new BoardRegisterController();
//								
//	} else if (command.equals("/registerForm.do")) {
//		controller = new BoardRegisterFormController();
//					
//	} else if (command.equals("/update.do")) {
//		controller = new BoardUpdateController();
//								
//	} else if (command.equals("/content.do")) {
//		controller = new BoardContentController();
//							
//	} else if (command.equals("/delete.do")) {
//		controller = new BoardDeleteController();
//					
//	}
	

