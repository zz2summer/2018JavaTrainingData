package cn.hncu.bookStore.util;

/**
 * ������
 * �ַ����Ƚ�
 * @author �º���
 *
 * @version 1.0
 */
public class StringComparison {
	
	/**
	 * str1��str2��ȫ(��ȷ����)ƥ��
	 * �����ȷƥ������str2��Ϊnull��str2ȥ��2�˿ո������±Ƚϵģ�����
	 * @param str1---���Ƚϵ��ַ���
	 * @param str2---�Ƚϵ��ַ���
	 * @return---���2���ַ�����ͬ����str2ȫ���ǿո����str2==null���ͷ���true�����2���ַ�����ͬ���ͷ���false
	 */
	public static boolean stringEquals(String str1,String str2){
		if(str2==null || str2.trim().length()<=0){
			return true;
		}
		if(!str1.equals(str2.trim())){
			return false;
		}
		return true;
	}
	
	/**
	 * str1��str2ģ��ƥ��
	 * ���ģ��ƥ��Ҳ����str2��Ϊnull��str2ȥ��2�˿ո������±Ƚϵģ�����
	 * @param str1---���Ƚϵ��ַ���
	 * @param str2---�Ƚϵ��ַ���
	 * @return---���str2��str1���Ӵ�����str2ȫ���ǿո��str2==null���ͷ���true�����str2����str1���ִ����ͷ���false
	 */
	public static boolean stringIndexOf(String str1,String str2){
		if(str2==null || str2.trim().length()<=0){
			return true;
		}
		
		if(str1.indexOf(str2.trim())==-1){
			return false;
		}
		return true;
	}
	
}
