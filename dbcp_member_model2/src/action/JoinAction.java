package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import vo.MemberVO;

public class JoinAction implements Action {

	private String path;

	public JoinAction(String path) {
		super();
		this.path = path;
	} 

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		//register.jsp에서 사용자가 입력한 값 가져오기
		String id = req.getParameter("id");
		String pwd = req.getParameter("password");
		String name = req.getParameter("name");
		String gender = req.getParameter("gender");
		String email = req.getParameter("email");
		//db 회원가입 실행
		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();
		vo.setUserid(id);
		vo.setPassword(pwd);
		vo.setName(name);
		vo.setGender(gender);
		vo.setEmail(email);
		
		int result = dao.Join(vo);
		
		if(result>0) {
			path+="?msg=success";
			
		}else {
			path="view/register.jsp?msg=fail";
		}
		
		return new ActionForward(path,true);
	}
	
	
}
