package kr.smhrd.frontcontroller;

import java.util.HashMap;

import org.apache.catalina.mapper.MappingData;

import kr.smhrd.web.AjaxBoardContentController;
import kr.smhrd.web.AjaxBoardDeleteController;
import kr.smhrd.web.AjaxBoardListController;
import kr.smhrd.web.AjaxBoardRegisterController;
import kr.smhrd.web.BoardContentController;
import kr.smhrd.web.BoardDeleteController;
import kr.smhrd.web.BoardListController;
import kr.smhrd.web.BoardRegisterController;
import kr.smhrd.web.BoardRegisterFormController;
import kr.smhrd.web.BoardUpdateController;
import kr.smhrd.web.CalcController;
import kr.smhrd.web.Controller;

public class HandlerMapping {
	 private HashMap<String, Controller> mappings;
	 	public HandlerMapping() {
	 		mappings = new HashMap<String, Controller>();
			mappings.put("/list.do", new BoardListController());
			mappings.put("/ajaxlist.do", new AjaxBoardListController());
			mappings.put("/register.do", new BoardRegisterController());
			mappings.put("/ajaxregister.do", new AjaxBoardRegisterController());
			mappings.put("/registerForm.do", new BoardRegisterFormController());
			mappings.put("/update.do", new BoardUpdateController());
			mappings.put("/content.do", new BoardContentController());
			mappings.put("/ajaxcontent.do", new AjaxBoardContentController());
			mappings.put("/delete.do", new BoardDeleteController());
			mappings.put("/ajaxdelete.do", new AjaxBoardDeleteController());
			mappings.put("/calc.do", new CalcController());
			
		}
	 	public Controller getController(String command) {
			return mappings.get(command);
		}
}
