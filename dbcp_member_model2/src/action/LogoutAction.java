package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutAction implements Action {
	
	private String path;
	

	public LogoutAction(String path) {
		super();
		this.path = path;
	}

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		//세션 해제		
		//다시 index.jsp로 돌아오기
		HttpSession session=req.getSession(false);
		if(session!=null)
			session.invalidate();
		return new ActionForward(path,true);
	}
}










