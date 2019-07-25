package cn.hncu.bookStore.common;

/**
 * ����:�û����͵�ö�٣�<br/>
 * �����ڹ���ģ�顣<br/>
 * ������<br/>
 *  ADMIN(1,"��������Ա"),<br/>
 *	BOOK(2,"ͼ�����Ա"),<br/>
 *	IN(3,"��������Ա"),<br/>
 *	OUT(4,"���۹���Ա"),<br/>
 *  STOCK(5,"������Ա");<br/>
 * @author chx
 * @version 1.0
 */
public enum UserTypeEnum {
	ADMIN(1,"��������Ա"),
	BOOK(2,"ͼ�����Ա"),
	IN(3,"��������Ա"),
	OUT(4,"���۹���Ա"),
	STOCK(5,"������Ա");
	
	private final int type;
	private final String name;
	
	/**
	 * ��ʼ��ö�ٱ�������
	 * @param type---ö�ٱ�����Ӧ����������
	 * @param name---ö�ٱ�����Ӧ��String������
	 */
	private UserTypeEnum(int type, String name) {
		this.type=type;
		this.name=name;
	}
	
	/**
	 * �õ���ǰö�ٱ���������
	 * @return---type-���
	 */
	public int getType() {
		return type;
	}
	
	/**
	 * �õ���ǰö�ٱ�������������
	 * @return---name-��������
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * ����ö�ٱ�����int���ֵõ����ֶ�Ӧ��ö�ٱ�������������
	 * @param type---��Ҫ�����int�Ͳ���
	 * @return ---����������������ֶ�Ӧ��ö�ٱ������ͷ������ö�ٱ������������֡�
	 *    <br/>---������������������ֶ�Ӧ��ö�ٱ��������׳�һ���쳣��Ϣ��
	 */
	public static String getNameByType(int type){
		for(UserTypeEnum userType:UserTypeEnum.values()){
			if(userType.getType()==type){
				return userType.getName();
			}
		}
		throw new IllegalArgumentException("ö����û�ж�Ӧ���û�����:"+type);
	}
	
	/**
	 * ����ö�ٱ�����name�������ֵõ�name��Ӧ��ö�ٱ�����int��type
	 * @param name---��Ҫ�����String������
	 * @return ---����������������ֶ�Ӧ��ö�ٱ������ͷ������ö�ٱ�����Ӧ��type-int
	 *   <br/> ---������������������ֶ�Ӧ��ö�ٱ��������׳�һ���쳣��Ϣ
	 */ 
	public static int getTypeByName(String name){
		for(UserTypeEnum userType:UserTypeEnum.values()){
			if(userType.getName().equals(name)){
				return userType.getType();
			}
		}
		throw new IllegalArgumentException("ö����û�ж�Ӧ���û�����:"+name);
	}
}
