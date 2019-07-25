
import java.util.Random;
import java.util.Scanner;

public class Test {

//*********************************【main】***********************************************
	public static void main(String[] args) throws Exception {
		Initial.cardInit();                                 //初始化104张牌                                  
		Initial.list();                                     //打印武将列表
		Initial.putCharacter();                             //武将键值对方法赋值
		Initial.setKeyMap();                                //牌面内容赋值，将牌的key对应成int数字，方便之后的操作。
		Scanner sc = new Scanner(System.in);			    //允许输入序号
		Character c1 = Initial.hm.get(Initial.name[sc.nextInt()]);  //根据序列号 new一个武将
		Player p1 = new Player(c1,c1.getmaxHp());           //创建玩家1，为其武将属性赋值
		while(true){
			int i =new Random().nextInt(25);
			Initial.cAI =Initial.hm.get(Initial.name[i]);
			Initial.p2 = new PlayerAI(Initial.cAI,Initial.cAI.getmaxHp());
			if(p1.getCharacter().getName().equals(Initial.p2.getCharacter().getName())==false){
				break;
			}
		}
		System.out.println("玩家选择了："+c1.getName());
		Thread.sleep(999);
		System.out.println("AI选择了："+Initial.p2.getCharacter().getName());
		Initial.line();
		Thread.sleep(1999);
		p1.giveCard(p1);                       //起始4张
		Initial.p2.giveCard(Initial.p2);
		Thread.sleep(999);
		System.out.println("");
		Thread.sleep(999);
		 //回合，轮流执行turn()中的6个阶段
		while(Initial.p2.getHp()>0 && p1.getHp()>0){               
			Player p = Initial.who?p1:Initial.p2;
			Player toP=(!Initial.who)?p1:Initial.p2;
			p.turn(p,toP);
		}	
	}  
}
