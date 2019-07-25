package yy1020;
/**
 * 角色类
 * @author yy
 *
 */
public class Player extends Thread implements gameConfig{
	//角色中点相对游戏面板的位置(在游戏中是不变的)
	static int px = panelX/2;
	static int py = panelY/2;
	//角色中点在整张地图中的位置(设置人最开始中点的位置一定要是一个元素中心的位置，要不然这种移动就会出问题 - -！)
	static int x = 25;
	static int y = 25;
	//角色的偏移量（实现像素点移动关键的部分）
	static int mx = 0;
	static int my = 0;
	//角色的步长
	static int step = 1;
	//角色是否移动
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
	 * 角色移动的方法
	 */
	public void move(){
		if(up){
			//改变角色在地图中的位置
			y=y-step;
			//改变角色移动相对于固定元素点的偏移量
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
	//得到角色在数组中的位置I
	public static int getI(){
		return (y-(playersize/2))/50;
	}
	//得到角色在数组中的位置J
	public static int getJ(){
		return (x-(playersize/2))/50;
	}
}
