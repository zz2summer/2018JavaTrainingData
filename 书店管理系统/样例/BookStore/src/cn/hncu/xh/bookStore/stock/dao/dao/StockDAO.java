package cn.hncu.xh.bookStore.stock.dao.dao;

import java.util.List;

import cn.hncu.xh.bookStore.stock.vo.StockModel;
import cn.hncu.xh.bookStore.stock.vo.StockQueryModel;

/**
 * <p>
 * Title:StockDAO
 * </p>
 * 
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 27, 2015
 */
public interface StockDAO {
	public boolean create(StockModel stock);//�����¿��
 
	public boolean delete(String uuid); //ɾ��ָ��uuid�Ŀ��

	public boolean update(StockModel stock); //�޸Ŀ��

	public List<StockModel> getAll();  //������п��

	public StockModel getSingle(String uuid); //���ָ��uuid�Ŀ��

	public List<StockModel> getBycondition(StockQueryModel sqm); //��ѯ���
}
