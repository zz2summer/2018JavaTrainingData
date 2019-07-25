package cn.hncu.xh.bookStore.user.constance;

/**
 * <p>
 * Title:UserTypeEnum
 * </p>
 * 
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 22, 2015
 */
public enum UserTypeEnum {
	ADMIN(1, "��������Ա"), BOOK(2, "ͼ�����Ա"), IN(3, "��������Ա"), OUT(4, "���۹���Ա"), STOCK(
			5, "������Ա");
	private final int type; // ����Ȩ������
	private final String name; // ����Ȩ����

	// ���캯��
	private UserTypeEnum(int type, String name) {
		this.type = type;
		this.name = name;
	}

	// ���Ե�get����
	public int getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	// ��ѯ
	// ���ݸ�����Ȩ�����Ͳ�ѯȨ����
	public static String getNameByType(int type) {
		for (UserTypeEnum userType : UserTypeEnum.values()) {
			if (userType.getType() == type) {
				return userType.getName();
			}
		}
		throw new IllegalArgumentException("No such type:" + type+ "in UserTypeEnum");
	}

	// ���ݸ�����Ȩ������ѯȨ������
	public static int getTypeByName(String name) {
		for (UserTypeEnum userType : UserTypeEnum.values()) {
			if (userType.getName().equals(name)) {
				return userType.getType();
			}
		}
		throw new IllegalArgumentException("No such name:" + name+ "in UserTypeEnum");

	}
}
