package kr.smhrd.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalcController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int su = Integer.parseInt(request.getParameter("su"));
		int sum = 0;
		for(int i=1;i<=su;i++) {
			sum+=i;
			
		}
		
		PrintWriter out = response.getWriter();
		out.println(sum); // 응답
		
		return null;
	}
	
}
