package cn.hncu.xh.bookStore.stock.vo;

/**
 *<p>Title:StockQueryModel</p>
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 27, 2015
 */
public class StockQueryModel extends StockModel {
	private int sumNum2; //为了查询范围的另一个库存数量

	public int getSumNum2() {
		return sumNum2;
	}

	public void setSumNum2(int sumNum2) {
		this.sumNum2 = sumNum2;
	}
	
}
