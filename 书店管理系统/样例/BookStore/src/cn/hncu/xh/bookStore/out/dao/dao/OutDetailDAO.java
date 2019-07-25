package cn.hncu.xh.bookStore.out.dao.dao;

import java.util.List;

import cn.hncu.xh.bookStore.out.vo.OutDetailModel;
import cn.hncu.xh.bookStore.out.vo.OutDetailQueryModel;


/**
 *<p>Title:OutDetailDAO</p>
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 27, 2015
 */
public interface OutDetailDAO {
	public boolean create(OutDetailModel OutDetail); // 创建销售明细

	public boolean update(OutDetailModel OutDetail); // 修改销售明细

	public boolean delete(String uuid); // 删除对应uuid的销售明细

	public List<OutDetailModel> getAll(); // 获取所有的销售明细

	public OutDetailModel getSingle(String uuid); // 获取对用uuid的单个销售明细

	public List<OutDetailModel> getByCondition(OutDetailQueryModel odqm); // 查询满足omqm的销售明细
}
