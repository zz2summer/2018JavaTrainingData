package yy1020;
/**
 * ��ɫ��
 * @author yy
 *
 */
public class Player extends Thread implements gameConfig{
	//��ɫ�е������Ϸ����λ��(����Ϸ���ǲ����)
	static int px = panelX/2;
	static int py = panelY/2;
	//��ɫ�е������ŵ�ͼ�е�λ��(�������ʼ�е��λ��һ��Ҫ��һ��Ԫ�����ĵ�λ�ã�Ҫ��Ȼ�����ƶ��ͻ������ - -��)
	static int x = 25;
	static int y = 25;
	//��ɫ��ƫ������ʵ�����ص��ƶ��ؼ��Ĳ��֣�
	static int mx = 0;
	static int my = 0;
	//��ɫ�Ĳ���
	static int step = 1;
	//��ɫ�Ƿ��ƶ�
	static boolean up = false;
	static boolean down = false;
	static boolean left = false;
	static boolean right = false;
	@Override
	public void run() {
		while(true){
			move();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * ��ɫ�ƶ��ķ���
	 */
	public void move(){
		if(up){
			//�ı��ɫ�ڵ�ͼ�е�λ��
			y=y-step;
			//�ı��ɫ�ƶ�����ڹ̶�Ԫ�ص��ƫ����
			my=my-step;
		}
		if(down){
			y=y+step;
			my=my+step;
		}
		if(left){
			x=x-step;
			mx=mx-step;
		}
		if(right){
			x=x+step;
			mx=mx+step;
		}
	}
	//�õ���ɫ�������е�λ��I
	public static int getI(){
		return (y-(playersize/2))/50;
	}
	//�õ���ɫ�������е�λ��J
	public static int getJ(){
		return (x-(playersize/2))/50;
	}
}
