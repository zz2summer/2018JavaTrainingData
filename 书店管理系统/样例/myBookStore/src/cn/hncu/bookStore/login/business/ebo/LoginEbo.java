package cn.hncu.bookStore.login.business.ebo;

import cn.hncu.bookStore.login.business.ebi.LoginEbi;
import cn.hncu.bookStore.user.business.ebi.UserEbi;
import cn.hncu.bookStore.user.business.factory.UserEbiFactory;
import cn.hncu.bookStore.user.vo.UserModel;

/**
 * 登录模块的实现类
 * @author 陈浩翔
 *
 * @version 1.0  2016-4-20
 */
public class LoginEbo implements LoginEbi{

	@Override
	public String login(String name, String pwd) {
		UserEbi ebi = UserEbiFactory.getUserEbi();
		UserModel user = ebi.getUserByName(name);
		if(user==null){
			return "对不起，该用户不存在!";
		}
		if(!user.getPwd().equals(pwd)){
			return "您输入的密码不正确!";			
		}
		return null;
	}
 
}
