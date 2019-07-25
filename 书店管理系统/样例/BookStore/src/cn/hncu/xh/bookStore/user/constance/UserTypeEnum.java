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
	ADMIN(1, "超级管理员"), BOOK(2, "图书管理员"), IN(3, "进货管理员"), OUT(4, "销售管理员"), STOCK(
			5, "库存管理员");
	private final int type; // 管理权限类型
	private final String name; // 管理权限名

	// 构造函数
	private UserTypeEnum(int type, String name) {
		this.type = type;
		this.name = name;
	}

	// 属性的get方法
	public int getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	// 查询
	// 根据给定的权限类型查询权限名
	public static String getNameByType(int type) {
		for (UserTypeEnum userType : UserTypeEnum.values()) {
			if (userType.getType() == type) {
				return userType.getName();
			}
		}
		throw new IllegalArgumentException("No such type:" + type+ "in UserTypeEnum");
	}

	// 根据给定的权限名查询权限类型
	public static int getTypeByName(String name) {
		for (UserTypeEnum userType : UserTypeEnum.values()) {
			if (userType.getName().equals(name)) {
				return userType.getType();
			}
		}
		throw new IllegalArgumentException("No such name:" + name+ "in UserTypeEnum");

	}
}
