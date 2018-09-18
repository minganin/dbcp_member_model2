package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;

public class CheckIdAction implements Action {
	private String path;
	
	public CheckIdAction(String path) {
		super();
		this.path = path;
	}

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// TODO Auto-generated method stub
		String userid =req.getParameter("userid");
		
		 
		//db확인
		MemberDAO dao = new MemberDAO();
		boolean result = dao.checkId(userid);
		if(result) {
			req.setAttribute("result", "false");
			
		}else {
			req.setAttribute("result", "true");
		}
		
		return new ActionForward(path, false);
	}

}
