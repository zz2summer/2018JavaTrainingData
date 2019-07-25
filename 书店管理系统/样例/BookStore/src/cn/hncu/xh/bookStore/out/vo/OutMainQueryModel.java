package cn.hncu.xh.bookStore.out.vo;

/**
 *<p>Title:OutMainQueryModel</p>
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 27, 2015
 */
public class OutMainQueryModel extends OutMainModel {
	private long outDate2;//为了查询范围，补的一个变量

	public long getOutDate2() {
		return outDate2;
	}

	public void setOutDate2(long outDate2) {
		this.outDate2 = outDate2;
	}
	
}
