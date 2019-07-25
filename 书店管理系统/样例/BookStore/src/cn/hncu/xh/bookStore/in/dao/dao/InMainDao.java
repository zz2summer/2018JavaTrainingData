package cn.hncu.xh.bookStore.in.dao.dao;

import java.util.List;

import cn.hncu.xh.bookStore.in.vo.InMainModel;
import cn.hncu.xh.bookStore.in.vo.InMainQueryModel;



/**
 *<p>Title:InMainDao</p>
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 25, 2015
 */
//接口类
public interface InMainDao {
	public boolean create(InMainModel inMain); // 创建接口

	public boolean delete(String uuid); // 删除接口

	public boolean update(InMainModel inMain); // 修改接口

	public List<InMainModel> getAll(); // 返回全部对象接口

	public InMainModel getSingle(String uuid);// 获取编号接口

	public List<InMainModel> getBycondition(InMainQueryModel imqm);// 查询接口
}
