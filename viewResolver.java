package kr.smhrd.frontcontroller;

public class viewResolver {
	public static String makeurl(String view) {
		return "WEB-INF/views/"+view+".jsp";
	}
}
/*
  /WEB-INF/views/"+view+".jsp
*/