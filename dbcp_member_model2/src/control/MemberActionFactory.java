package control;

import action.Action;
import action.CheckIdAction;
import action.JoinAction;
import action.LoginAction;
import action.LogoutAction;
import action.PwdCheckAction;
import action.UpdateAction;

public class MemberActionFactory {
	private static MemberActionFactory maf;
	
	private MemberActionFactory() {}
	public static MemberActionFactory getInstance() {
		if(maf==null)
			maf=new MemberActionFactory();
		return maf;
	}
	
	private Action action=null;
	public Action action(String cmd) {
		
		if(cmd.equals("/login.do")) {
			action=new LoginAction("index.jsp");
		}else if(cmd.equals("/logout.do")) {
			action=new LogoutAction("index.jsp");
		}else if(cmd.equals("/join.do")) {
			action=new JoinAction("index.jsp");
		}else if(cmd.equals("/pwdcheck.do")) {
			action=new PwdCheckAction("view/modify.jsp");
		}else if(cmd.equals("/update.do")) {
			action=new UpdateAction("index.jsp");
		}else if(cmd.equals("/checkId.do")) {
			action=new CheckIdAction("checkIdResult.jsp");
		}
		
		
		return action;
	}
}
