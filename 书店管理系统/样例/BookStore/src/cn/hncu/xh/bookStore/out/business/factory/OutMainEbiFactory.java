package cn.hncu.xh.bookStore.out.business.factory;

import cn.hncu.xh.bookStore.out.business.ebi.OutMainEbi;
import cn.hncu.xh.bookStore.out.business.ebo.OutMainEbo;


/**
 *<p>Title:OutMainEbiFactory</p>
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 27, 2015
 */
public class OutMainEbiFactory {
	public static OutMainEbi getOutMainEbi(){
		return new OutMainEbo();  //通过实现类，获得接口
	}
}
