
/*
*��ʼ����*
*��ȡ�佫����
*��ȡ��������
*/
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Initial {
	public static String[] name = new String[25];                  //�佫���ֵ�string����
	public static String[] cardKey = new String[104];             //�������ݵ�string����
	public static Card[] card1 = new Card[104];                      //104����
	public static List<Card> listCard = new ArrayList<Card>();      //�ƶѼ���
	public static List<Card> throwlistCard = new ArrayList<Card>(); //�����ƶ�
	public static Card tmpCheckCard;                                //����ж��Ƶ���ʱ����
	public static Character cAI ;                     //AI�½��佫---���� XXX
	public static PlayerAI p2 ;   //AI��ҹ���
	public static boolean who = true;                                      //������������TΪ��ң�FΪAI����ʼΪT
	public static HashMap<String, String> hmp = new HashMap<String, String>();    //�Ƶļ�ֵ��<Card.name,index>
	public static HashMap<String,Character> hm = new HashMap<String,Character>(); //����ļ�ֵ��

	 // ��̬��������ʼ������
	 // �ȸ�104���Ƹ�ֵ��Ȼ��ϴ��
	public static void cardInit() throws Exception {                                    
		Initial.setCardKey();
		for (int i = 0; i < 104; i++) {
			Initial.card1[i] = new Card();
			Initial.card1[i].key=Initial.cardKey[i];
			Initial.listCard.add(Initial.card1[i]);
		}
			int tmp = 0;
			for(int k = 0;k<2;k++){
				for (int i = 0; i < 13; i++) {
					for (int j = 0; j < 4; j++) {
						switch (j) {
						case 0:
							Initial.card1[tmp].setColor("����");
							break;
						case 1:
							Initial.card1[tmp].setColor("����");
							break;
						case 2:
							Initial.card1[tmp].setColor("÷��");
							break;
						case 3:
							Initial.card1[tmp].setColor("����");
							break;
						}
						switch (i) {
						case 0:
							Initial.card1[tmp].setNum("A");
							break;
						case 10:
							Initial.card1[tmp].setNum("J");
							break;
						case 11:
							Initial.card1[tmp].setNum("Q");
							break;
						case 12:
							Initial.card1[tmp].setNum("K");
							break;
						default:
							Initial.card1[tmp].setNum(java.lang.Integer.toString(i + 1));
							break;
						}
						tmp++;
					}
				}
			}
			for (int i = 0; i < Initial.card1.length; i++) {// ����˳��
				Random r = new Random();
				Card cardtmp = Initial.listCard.get(i);
				Initial.listCard.remove(i);
				Initial.listCard.add(r.nextInt(Initial.listCard.size()), cardtmp);
			}
			//��ӡ����,������
			/*for (int i = 0; i < Initial.listCard.size(); i++) {
				
				System.out.println("��" + (i + 1) + "��" + "\t"
						+ Initial.listCard.toArray()[i]);
			}*/
	}
	public static void list(){ //********************************     //��ӡ�佫�б��Թ�ѡ��
		Initial.line();
		System.out.println("=======��ӭ�������װ����̨����ɱ=======");
		Initial.line();
		name[0]= "����";
		name[1]= "�ŷ�";
		name[2]= "����";
		name[3]= "��";
		name[4]= "����";
		name[5]= "�����";
		name[6]= "����Ӣ";
		
		name[7]= "�ܲ�";
		name[8]="����";
		name[9]="˾��ܲ";
		name[10]="�ĺ";
		name[11]="����";
		name[12]="����";
		name[13]="�缧";
		
		name[14]="��Ȩ";
		name[15]="���";
		name[16]="����";
		name[17]="����";
		name[18]="�Ƹ�";
		name[19]="½ѷ";
		name[20]="������";
		name[21]="����";
		
		name[22]="����";
		name[23]="����";
		name[24]="��٢";
		
		System.out.println("���������ѡ���佫...");
		for(int i=0;i<name.length ;i++){
			System.out.println(i+"--"+name[i]);
		}
		System.out.print("=>");
	} 
	public static void setCardKey() throws Exception{                 //��cardkey.cdk�ļ��ж�ȡ��������
		FileInputStream fis = new FileInputStream("./cardkey.cdk");
		byte[] buff = new byte[1024];
		int r = 0;
		String str = new String();
		while((r=fis.read(buff))>0){                                  //����ȡ�����ݴ����str��ʱ�ַ�����
			str=new String(buff,0,r);
		}
		cardKey = str.split("��");                                    //��split�������ָ�str��ֵ����̬����cardkey
	}
	public static void setKeyMap(){//��ֵ��hmp��put���Ƶ�key
		
		hmp.put("ɱ", "1");
		hmp.put("��", "2");
		hmp.put("��", "3");
		hmp.put("����", "4");
		hmp.put("�ֲ�˼��", "5");
		hmp.put("�赶ɱ��", "6");
		hmp.put("��и�ɻ�", "7");
		hmp.put("��԰����", "8");
		hmp.put("����뷢", "9");
		hmp.put("����", "10");
		hmp.put("��������", "11");
		hmp.put("��������", "12");
		hmp.put("��ȷ��", "13");
		hmp.put("���Ӳ���", "14");
		hmp.put("˳��ǣ��", "15");
		
		hmp.put("��ֽ�", "16");
		hmp.put("�������", "17");
		hmp.put("��ʯ��", "18");
		hmp.put("�ɰ���ì", "19");
		hmp.put("����˫�ɽ�", "20");
		hmp.put("���빭", "21");
		hmp.put("���컭�", "22");
		hmp.put("�������µ�", "23");
		hmp.put("������", "24");
		hmp.put("����", "25");//-1
		hmp.put("���U", "26");//-1
		hmp.put("����", "27");//-1
		hmp.put("��Ӱ", "28");//+1
		hmp.put("��¬", "29");//+1
		hmp.put("צ�Ʒɵ�", "30");//+1
	}
	
	//**********Map �佫�Ͷ���ļ�ֵ�����������ѡ��*******************
	public static void putCharacter(){
	hm.put("����", new GuanYu());
	hm.put("�ŷ�", new ZhangFei());
	hm.put("����", new ZhaoYun());
	hm.put("��", new MaChao());
	hm.put("����", new LiuBei());
	hm.put("�����", new ZhuGe());
	hm.put("����Ӣ", new HuangYueYing());
	
	hm.put("�ܲ�", new CaoCao());
	hm.put("����", new XuChu());
	hm.put("˾��ܲ", new SiMaYi());
	hm.put("�ĺ", new XiaHouDun());
	hm.put("����", new GuoJia());
	hm.put("����", new ZhangLiao());
	hm.put("�缧", new ZhenJi());
	
	hm.put("��Ȩ", new SunQuan());
	hm.put("���", new ZhouYu());
	hm.put("����", new GanNing());
	hm.put("����", new LvMeng());
	hm.put("�Ƹ�", new HuangGai());
	hm.put("½ѷ", new LuXun());
	hm.put("������", new SunShangXiang());
	hm.put("����", new DaQiao());
	
	hm.put("����", new LvBu());
	hm.put("����", new DiaoChan());
	hm.put("��٢", new HuaTuo());
	//...
	//...
	//****************************************************************
	}
	//��ӡ�ָ���
	public static void line(){
		System.out.println("========================================");
	}
}
	