package cn.hncu.xh.bookStore.in.business.factory;

import cn.hncu.xh.bookStore.in.business.ebi.InMainEbi;
import cn.hncu.xh.bookStore.in.business.ebo.InMainEbo;

/**
 *<p>Title:InMainEbiFctory</p>
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 25, 2015
 */
//π§≥ß¿‡
public class InMainEbiFctory {
	public static InMainEbi getInMainEbi(){
		return new InMainEbo();
	}
}
