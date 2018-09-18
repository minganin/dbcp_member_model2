package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;

public class UpdateAction implements Action {

	private String path;
	
	public UpdateAction(String path) {
		super();
		this.path = path;
	}

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// userid, password, email 가져오기
		// 정보 수정 후 페이지 이동
		String id = req.getParameter("userid");
		String pwd = req.getParameter("password");
		String email = req.getParameter("email");
		
		MemberDAO dao = new MemberDAO();
		dao.Modify(id, pwd, email);
		
		HttpSession session=req.getSession();
		session.invalidate();
		
		return new ActionForward(path,true);
	}

}
