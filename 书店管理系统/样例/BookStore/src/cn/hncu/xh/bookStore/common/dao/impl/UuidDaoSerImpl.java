package cn.hncu.xh.bookStore.common.dao.impl;

import java.util.ArrayList;
import java.util.List;

import cn.hncu.xh.bookStore.common.constance.UuidModelConstance;
import cn.hncu.xh.bookStore.common.dao.dao.UuidDao;
import cn.hncu.xh.bookStore.common.vo.UuidModel;
import cn.hncu.xh.bookStore.util.FileIOUtil;

/**
 * <p>
 * Title:UuidDaoSerImpl
 * </p>
 * 
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 24, 2015
 */
// 实现类
public class UuidDaoSerImpl implements UuidDao { // 实现UuidDao接口
	private static final String FILE_NAME = "Uuid.txt";

	public String getNextNum(UuidModelConstance model) {
		String modelName = model.getName();
		// 1.从文件中读取已有的编号
		// 用HashMap性能更好，但需要重新写一个FileIOUtil工具，因为原来的只能读写List,这里，因为功能简单，所以直接用List处理数据
		List<UuidModel> list = FileIOUtil.readFromFile(FILE_NAME);
		// 2.如果存在编号：加一，存储，返回新值
		// 先遍历list，找到对应得模块名字的位置
		if (list == null) {
			list = new ArrayList<UuidModel>();
		} else {
			for (UuidModel uuid : list) {
				if (uuid.getModelName().equals(modelName)) {
					final int result = uuid.getCurrentNum();// 这里，result代表的是新号（之前没有用过的，下一个马上使用）
					uuid.setCurrentNum(uuid.getCurrentNum() + 1);
					FileIOUtil.writeToFile(FILE_NAME, list);
					return String.valueOf(result);
				}
			}
		}
		// 3.如果不存在编号：赋1，存储，返回1
		final int result = 1;// 这里，resule代表的是新号（之前没有用过的，下一个马上使用）
		UuidModel uuid = new UuidModel();
		uuid.setModelName(modelName);
		uuid.setCurrentNum(2);
		list.add(uuid);
		FileIOUtil.writeToFile(FILE_NAME, list);
		return String.valueOf(result);
	}

}
