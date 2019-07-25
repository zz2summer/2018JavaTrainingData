package cn.hncu.xh.bookStore.util;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * <p>
 * Title:JPanleUtil
 * </p>
 * 
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 22, 2015
 */
public class JPanleUtil {
	@SuppressWarnings("unused")
	private void JPanelUtil() {// //工具类，把默认 构造方法私有化
	}
	//面板转换
	public static void changePanel(JFrame jFrame, JPanel jPanel) {
		jFrame.getContentPane().removeAll();  //把当前JFrame的contentPane中的东西全部移除掉
		jFrame.getContentPane().add(jPanel);  //把需要转换的面板加入到JFrame的contentPane中
		//重新绘制该组件，使转换后的组件显示在JFrame中
		jFrame.getContentPane().validate();   
		jFrame.getContentPane().repaint();
		 
	}
}
