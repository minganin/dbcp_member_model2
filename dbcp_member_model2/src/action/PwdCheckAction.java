package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;
import vo.MemberVO;

public class PwdCheckAction implements Action {

	private String path;
	
	
	public PwdCheckAction(String path) {
		super();
		this.path = path;
	}

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		//pwdcheck.jsp에서 id와 password 가져오기
		String id = req.getParameter("userid");
		String pwd = req.getParameter("password");
		//회원 정보를 가져와야 하는지 회원탈퇴를 해야 하는 지 정보 가져오기
		String cmd = req.getParameter("cmd");
		
		//password가 일치하면 해당 사람의 정보를 담아서 가져온다.
		//얻어온 정보를 request에 담고 페이지 이동
		MemberDAO dao = new MemberDAO();
		MemberVO vo = dao.isCorrect(id,pwd);
		
			if(vo!=null && cmd.equals("check")) { //회원 정보 체크
				req.setAttribute("vo", vo);
				return new ActionForward(path, false);
			}else if(vo!=null && cmd.equals("leave")) { //회원 탈퇴
				//탈퇴 작업
				//DAO 메소드 만들기 (delete)
				int result = dao.Delete(vo);
				if(result>0) {
					path="index.jsp?msg=success";
					HttpSession session=req.getSession();
					session.invalidate();
				}else {
					path="view/pwdcheck.jsp?msg=fail";
				}
				//세션 해제 invaildate
				//index.jsp 이동
				return new ActionForward(path, true);
			}else { //비밀번호가 틀린 경우
				path="view/pwdcheck.jsp?msg=fail";
				return new ActionForward(path, true);
			}
	}

}
