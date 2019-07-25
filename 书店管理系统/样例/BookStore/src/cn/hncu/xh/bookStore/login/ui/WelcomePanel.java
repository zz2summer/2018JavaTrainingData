package cn.hncu.xh.bookStore.login.ui;

import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.Rectangle;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;

/**
 *<p>Title:WelcomePanel</p>
 * @author <a href="mailto:1225268923@qq.com">xionghui</a>
 * @date Aug 27, 2015
 */
public class WelcomePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;

	/**
	 * This is the default constructor
	 */
	public WelcomePanel() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		jLabel1 = new JLabel();
		jLabel1.setBounds(new Rectangle(135, 46, 223, 56));
		jLabel1.setFont(new Font("Dialog", Font.BOLD, 36));
		jLabel1.setForeground(new Color(51, 67, 16));
		jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel1.setText("WELCOME");
		jLabel = new JLabel();
		jLabel.setBounds(new Rectangle(29, 128, 449, 85));
		jLabel.setFont(new Font("\u6977\u4f53", Font.BOLD, 14));
		jLabel.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel.setForeground(new Color(255, 12, 18));
		jLabel.setText("永远不要停止你的脚步，就想心脏的跳动，直至死亡！");
		this.setLayout(null);
		this.setBounds(new Rectangle(0, 0, 500, 370));
		this.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 36));
		this.add(jLabel, null);
		this.add(jLabel1, null);
	}

}  //  @jve:decl-index=0:visual-constraint="161,20"
