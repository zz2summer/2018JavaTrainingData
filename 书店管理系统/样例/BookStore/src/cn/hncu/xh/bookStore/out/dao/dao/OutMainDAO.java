package cn.hncu.xh.bookStore.out.dao.dao;

import java.util.List;

import cn.hncu.xh.bookStore.out.vo.OutMainModel;
import cn.hncu.xh.bookStore.out.vo.OutMainQueryModel;

/**
 * <p>
 * Title:OutMainDAO
 * </p>
 * 
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 27, 2015
 */
public interface OutMainDAO {
	public boolean create(OutMainModel OutMain); // 创建销售单

	public boolean update(OutMainModel OutMain); // 修改销售单

	public boolean delete(String uuid); // 删除对应uuid的销售单

	public List<OutMainModel> getAll(); // 获取所有的销售单

	public OutMainModel getSingle(String uuid); // 获取对用uuid的单个销售单

	public List<OutMainModel> getByCondition(OutMainQueryModel omqm); // 查询满足omqm的销售单
}
