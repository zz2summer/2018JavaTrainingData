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
	private void JPanelUtil() {// //�����࣬��Ĭ�� ���췽��˽�л�
	}
	//���ת��
	public static void changePanel(JFrame jFrame, JPanel jPanel) {
		jFrame.getContentPane().removeAll();  //�ѵ�ǰJFrame��contentPane�еĶ���ȫ���Ƴ���
		jFrame.getContentPane().add(jPanel);  //����Ҫת���������뵽JFrame��contentPane��
		//���»��Ƹ������ʹת����������ʾ��JFrame��
		jFrame.getContentPane().validate();   
		jFrame.getContentPane().repaint();
		 
	}
}
