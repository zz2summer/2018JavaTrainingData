package cn.hncu.xh.bookStore.in.dao.dao;


import java.util.List;

import cn.hncu.xh.bookStore.in.vo.InDetailModel;
import cn.hncu.xh.bookStore.in.vo.InDetailQueryModel;

/**
 * <p>
 * Title:InDtailDao
 * </p>
 * 
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 25, 2015
 */
//接口类
public interface InDtailDao {
	public boolean create(InDetailModel inDetail); // 创建接口

	public List<InDetailModel> getAll(); // 返回全部对象接口

	public InDetailModel getSingle(String uuid);// 获取编号接口

	public List<InDetailModel> getBycondition(InDetailQueryModel idqm);// 查询接口
}
