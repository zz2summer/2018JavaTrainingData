package yy1020;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * ��Ϸ������
 * @author yy
 *
 */
public class mainFrame extends JFrame implements gameConfig{
	//��Ϸ���
	JPanel panel;
	
	public mainFrame() {
		init();
		
	}
	/**
	 * ���ô���
	 */
	public void init(){
		this.setTitle(title);
		this.setSize(frameX, frameY);
		this.setLayout(new FlowLayout());
		this.setDefaultCloseOperation(3);
		//������Ϸ���
		panel = setpanel();
		
		this.add(panel);
		this.setVisible(true);
		//��װ���̼�����
		PanelListenner plis = new PanelListenner();
		this.addKeyListener(plis);
		
		//���������ƶ��߳�
		Player player = new Player();
		player.start();
		
		//����ˢ������߳�
		UpdateThread ut = new UpdateThread(panel);
		ut.start();
	}
	
	/**
	 * ������Ϸ���
	 */
	public JPanel setpanel(){
		JPanel panel = new MyPanel();
		panel.setPreferredSize(new Dimension(panelX, panelY));
		panel.setLayout(null);
		panel.setBackground(Color.black);
		
		return panel;
	}
	
	/**
	 * �ڲ���Ϸ����������
	 * @author yy
	 *
	 */
	class PanelListenner extends KeyAdapter{
		//����������
		public void keyPressed(KeyEvent e){
			int code = e.getKeyCode();
			switch (code) {
			case KeyEvent.VK_UP:
				Player.up = true;
				break;
			case KeyEvent.VK_DOWN:
				Player.down = true;
				break;
			case KeyEvent.VK_LEFT:
				Player.left = true;
				break;
			case KeyEvent.VK_RIGHT:
				Player.right = true;
				break;

			default:
				break;
			}
		}
		//�������ͷ�
		public void keyReleased(KeyEvent e){
			int code = e.getKeyCode();
			switch (code) {
			case KeyEvent.VK_UP:
				Player.up = false;
				break;
			case KeyEvent.VK_DOWN:
				Player.down = false;
				break;
			case KeyEvent.VK_LEFT:
				Player.left = false;
				break;
			case KeyEvent.VK_RIGHT:
				Player.right = false;
				break;

			default:
				break;
			}
		}
	}
	/**
	 * �Զ����ڲ���Ϸ�����
	 * @author yy
	 *
	 */
	class MyPanel extends JPanel{
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			//�ҵ���ɫ�Աߵ��زģ��������Ҹ�5��
			for(int i=Player.getI()-6;i<=Player.getI()+6;i++){
				for(int j=Player.getJ()-6;j<=Player.getJ()+6;j++){
					//�����һ��û�г��磨���ڻ�û������ײ����һ����ʱû��  = =����
					if(i>=0&&j>=0&&i<ReadMapFile.map1.length&&j<ReadMapFile.map1[0].length){
						//����һ��Ԫ��
						ImageIcon icon = GetMap.int2icon(ReadMapFile.map1[i][j]);
						g.drawImage(icon.getImage(), (Player.px-elesize/2)+((j-Player.getJ())*elesize)-(Player.mx%elesize), (Player.py-elesize/2)+((i-Player.getI())*elesize)-(Player.my%elesize), elesize, elesize, null);
						//�ڶ���
						ImageIcon icon2 = GetMap.int2icon(ReadMapFile.map2[i][j]);
						g.drawImage(icon2.getImage(), (Player.px-elesize/2)+((j-Player.getJ())*elesize)-(Player.mx%elesize), (Player.py-elesize/2)+((i-Player.getI())*elesize)-(Player.my%elesize), elesize, elesize, null);
						//������
						ImageIcon icon3 = GetMap.int2icon(ReadMapFile.map3[i][j]);
						g.drawImage(icon3.getImage(), (Player.px-elesize/2)+((j-Player.getJ())*elesize)-(Player.mx%elesize), (Player.py-elesize/2)+((i-Player.getI())*elesize)-(Player.my%elesize), elesize, elesize, null);
					}
				}
			}
//			g.setColor(Color.black);
//			g.fillRect(0, 0, 50, 650);
//			g.fillRect(0, 0, 650, 50);
//			g.fillRect(600, 0, 50, 650);
//			g.fillRect(0, 600, 650, 50);
			
			//������ʱ��ûŪ����Ϸ��ɫ���ƶ�ͼ�����Խ�ɫ����һ����ɫ��С�����һ��....  = =��
			g.fillOval(Player.px-elesize/2, Player.py-elesize/2, elesize, elesize);
			//���˵�һ��С�뷨����һ����ɫ��ͼƬ��Ȼ���м��ڿ�һ��Բ������ģ��Ч������ģ���˵���Ұ
			g.drawImage(shadow2.getImage(), 0, 0, 650, 650, null);
		}
	}
}
