package cn.hncu.bookStore.login.business.ebi;
/**
 * 用户登录模块的逻辑层接口
 * @author 陈浩翔
 *
 * @version 1.0  2016-4-20
 */
public interface LoginEbi {
	/**
	 * 用户登录的方法
	 * @param name 用户名
	 * @param pwd  密码
	 * @return 返回字符串，若登录成功则返回null，如果失败则返回相应的错误信息如用户名不存在或密码不正确
	 */
	public String login(String name,String pwd);	
}
