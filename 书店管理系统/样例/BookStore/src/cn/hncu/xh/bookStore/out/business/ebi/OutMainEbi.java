package cn.hncu.xh.bookStore.out.business.ebi;

import java.util.List;
import java.util.Map;

import cn.hncu.xh.bookStore.out.vo.OutDetailModel;
import cn.hncu.xh.bookStore.out.vo.OutDetailQueryModel;
import cn.hncu.xh.bookStore.out.vo.OutMainModel;
import cn.hncu.xh.bookStore.out.vo.OutMainQueryModel;

/**
 * <p>
 * Title:OutMainEbi
 * </p>
 * 
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 27, 2015
 */
public interface OutMainEbi {
	public abstract boolean create(OutMainModel OutMain,List<OutDetailModel> details); //新增

	public Map<OutMainModel, List<OutDetailModel>> getAll();//获取全部

	public Map<OutMainModel, List<OutDetailModel>> getByCondition(OutMainQueryModel omqm, OutDetailQueryModel odqm); //查询
}
