package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;
import vo.MemberVO;

public class LoginAction implements Action {
	private String path;	

	public LoginAction(String path) {
		super();
		this.path = path;
	}

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		//index.jsp에서 id,pwd 랑 가져오기
		String id=req.getParameter("id");
		String pwd=req.getParameter("current_pass");
		//가져온 정보가 db에 있는지 확인
		//있는 사용자라면 세션에 값을 담고 이동
		//없는 사용자라면 로그인정보를 확인하세요 창 띄워주고 로그인 폼 보여주기
		MemberDAO dao=new MemberDAO();
		MemberVO vo=dao.isLogin(id, pwd);
		
		if(vo!=null) {
			HttpSession session=req.getSession();
			session.setAttribute("vo", vo);
		}else {
			path+="?msg=fail";
		}
		
		return new ActionForward(path,true);
	}
}






