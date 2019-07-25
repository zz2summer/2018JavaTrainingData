package cn.hncu.xh.bookStore.login.business.ebo;

import cn.hncu.xh.bookStore.login.business.ebi.LoginEbi;
import cn.hncu.xh.bookStore.user.business.factory.UserEbiFactory;
import cn.hncu.xh.bookStore.user.vo.UserModel;

/**
 *<p>Title:LoginEbo</p>
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 27, 2015
 */
public class LoginEbo implements LoginEbi {

	public String login(String name, String pwd) {
		UserModel user = UserEbiFactory.getUserEbi().getsingle(name);
		if(user==null){
			return "��Ǹ�����û��������ڣ�";
		}else if(!user.getPwd().equals(pwd)){
			return "�������";
		}else{
			return null;
		}
	}

}
