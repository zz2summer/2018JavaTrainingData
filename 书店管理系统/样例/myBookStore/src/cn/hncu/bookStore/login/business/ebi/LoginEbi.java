package cn.hncu.bookStore.login.business.ebi;
/**
 * �û���¼ģ����߼���ӿ�
 * @author �º���
 *
 * @version 1.0  2016-4-20
 */
public interface LoginEbi {
	/**
	 * �û���¼�ķ���
	 * @param name �û���
	 * @param pwd  ����
	 * @return �����ַ���������¼�ɹ��򷵻�null�����ʧ���򷵻���Ӧ�Ĵ�����Ϣ���û��������ڻ����벻��ȷ
	 */
	public String login(String name,String pwd);	
}
