package cn.hncu.bookStore.common;

/**
 * 
 * @author ³ÂºÆÏè
 * 
 * @version 1.0
 */
public enum UuidModelConstance {
	USER("UserModel"), 
	BOOK("BookModel"), 
	IN_MAIN("InMainModel"), 
	IN_DETAIL("InDetailModel"), 
	OUT_MAIN("outMainModel"), 
	OUT_DETAIL("OutDetailModel"), 
	STOCK("StockModel");

	private final String name;

	private UuidModelConstance(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
