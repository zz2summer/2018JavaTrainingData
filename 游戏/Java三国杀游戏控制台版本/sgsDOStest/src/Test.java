
import java.util.Random;
import java.util.Scanner;

public class Test {

//*********************************��main��***********************************************
	public static void main(String[] args) throws Exception {
		Initial.cardInit();                                 //��ʼ��104����                                  
		Initial.list();                                     //��ӡ�佫�б�
		Initial.putCharacter();                             //�佫��ֵ�Է�����ֵ
		Initial.setKeyMap();                                //�������ݸ�ֵ�����Ƶ�key��Ӧ��int���֣�����֮��Ĳ�����
		Scanner sc = new Scanner(System.in);			    //�����������
		Character c1 = Initial.hm.get(Initial.name[sc.nextInt()]);  //�������к� newһ���佫
		Player p1 = new Player(c1,c1.getmaxHp());           //�������1��Ϊ���佫���Ը�ֵ
		while(true){
			int i =new Random().nextInt(25);
			Initial.cAI =Initial.hm.get(Initial.name[i]);
			Initial.p2 = new PlayerAI(Initial.cAI,Initial.cAI.getmaxHp());
			if(p1.getCharacter().getName().equals(Initial.p2.getCharacter().getName())==false){
				break;
			}
		}
		System.out.println("���ѡ���ˣ�"+c1.getName());
		Thread.sleep(999);
		System.out.println("AIѡ���ˣ�"+Initial.p2.getCharacter().getName());
		Initial.line();
		Thread.sleep(1999);
		p1.giveCard(p1);                       //��ʼ4��
		Initial.p2.giveCard(Initial.p2);
		Thread.sleep(999);
		System.out.println("");
		Thread.sleep(999);
		 //�غϣ�����ִ��turn()�е�6���׶�
		while(Initial.p2.getHp()>0 && p1.getHp()>0){               
			Player p = Initial.who?p1:Initial.p2;
			Player toP=(!Initial.who)?p1:Initial.p2;
			p.turn(p,toP);
		}	
	}  
}
