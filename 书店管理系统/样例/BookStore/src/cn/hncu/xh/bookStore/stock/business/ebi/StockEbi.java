package cn.hncu.xh.bookStore.stock.business.ebi;

import java.util.List;

import cn.hncu.xh.bookStore.stock.vo.StockModel;
import cn.hncu.xh.bookStore.stock.vo.StockQueryModel;

/**
 *<p>Title:StockEbi</p>
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 27, 2015
 */
public interface StockEbi {
	 public List<StockModel> getAll(); //������п������
	   public List<StockModel> getByCondition(StockQueryModel sqm);//��ѯ
}
