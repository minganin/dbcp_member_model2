package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionForward;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("*.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		String reqUri=req.getRequestURI();
		String contextPath=req.getContextPath();
		String cmd=reqUri.substring(contextPath.length());
		
		MemberActionFactory maf=MemberActionFactory.getInstance();
		Action action=maf.action(cmd);
		
		ActionForward af=null;
		try {
			af=action.execute(req, res);
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
		if(af.isRedirect()) {
			res.sendRedirect(af.getPath());
		}else {
			RequestDispatcher rd=req.getRequestDispatcher(af.getPath());
			rd.forward(req, res);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
