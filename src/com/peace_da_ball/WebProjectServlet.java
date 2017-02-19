package com.peace_da_ball;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.*;

@SuppressWarnings("serial")
public class WebProjectServlet extends HttpServlet {	

	Logic codesAndSum = new Logic();
	Multiplication multiplication = new Multiplication();
	NumberSystems numberSystems = new NumberSystems();
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {		
		resp.setContentType("text/html; charset=windows-1251");
        PrintWriter out = resp.getWriter();

        String[] request = req.getQueryString().split("&");
        switch(request[0]) {
        case "0":
        	out.print(codesAndSum.generate(request[1]));
        	break;
        case "1":
        	out.print(multiplication.generate(request[1]));
        	break;
        case "2":
        	out.print(numberSystems.generate(request[1]));
        	break;
        }
	}
}