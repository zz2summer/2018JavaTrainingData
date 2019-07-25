package cn.hncu.xh.bookStore.common.constance;

/**
 *<p>Title:UuidModelConstance</p>
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 24, 2015
 */
//√∂æŸ¿‡
public enum UuidModelConstance {
	USER("UserModel"),
	BOOK("BookModel"),
	IN_MAIN("InMainModel"),
	IN_DETAIL("InDetailModel"),
	OUT_MAIN("OutMainModel"),
	OUT_DETAIL("OutDetailModel"),
	STOCK("StockModel");
	private final String name;
	private UuidModelConstance(String name){
		this.name=name;
	}
	public String getName() {
		return name;
	}
	
}
