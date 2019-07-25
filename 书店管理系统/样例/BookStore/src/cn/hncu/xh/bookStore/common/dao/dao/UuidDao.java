package cn.hncu.xh.bookStore.common.dao.dao;

import cn.hncu.xh.bookStore.common.constance.UuidModelConstance;

/**
 *<p>Title:UuidDao</p>
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 24, 2015
 */
//接口类
public interface UuidDao {
	public String getNextNum(UuidModelConstance model); //获取下一个号码接口
}
