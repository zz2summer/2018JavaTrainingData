package cn.hncu.xh.bookStore.in.business.ebi;

import java.util.List;
import java.util.Map;

import cn.hncu.xh.bookStore.in.vo.InDetailModel;
import cn.hncu.xh.bookStore.in.vo.InDetailQueryModel;
import cn.hncu.xh.bookStore.in.vo.InMainModel;
import cn.hncu.xh.bookStore.in.vo.InMainQueryModel;

/**
 *<p>Title:InMainEbi</p>
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 25, 2015
 */
public interface InMainEbi {
	public boolean create(InMainModel inMain,List<InDetailModel> list);
	
	public Map<InMainModel,List<InDetailModel>> getAll(); // 返回全部对象接口

	public Map<InMainModel, List<InDetailModel>> getByCondition(InMainQueryModel imqm, InDetailQueryModel idqm);

}
