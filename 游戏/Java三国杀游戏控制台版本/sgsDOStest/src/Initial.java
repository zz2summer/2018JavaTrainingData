
/*
*初始化类*
*读取武将名称
*读取牌面内容
*/
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Initial {
	public static String[] name = new String[25];                  //武将名字的string数组
	public static String[] cardKey = new String[104];             //牌面内容的string数组
	public static Card[] card1 = new Card[104];                      //104张牌
	public static List<Card> listCard = new ArrayList<Card>();      //牌堆集合
	public static List<Card> throwlistCard = new ArrayList<Card>(); //废弃牌堆
	public static Card tmpCheckCard;                                //存放判定牌的临时变量
	public static Character cAI ;                     //AI新建武将---测试 XXX
	public static PlayerAI p2 ;   //AI玩家构造
	public static boolean who = true;                                      //决定轮流次序，T为玩家，F为AI；初始为T
	public static HashMap<String, String> hmp = new HashMap<String, String>();    //牌的键值对<Card.name,index>
	public static HashMap<String,Character> hm = new HashMap<String,Character>(); //人物的键值对

	 // 静态方法，初始化牌组
	 // 先给104张牌赋值，然后洗牌
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
							Initial.card1[tmp].setColor("黑桃");
							break;
						case 1:
							Initial.card1[tmp].setColor("红心");
							break;
						case 2:
							Initial.card1[tmp].setColor("梅花");
							break;
						case 3:
							Initial.card1[tmp].setColor("方块");
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
			for (int i = 0; i < Initial.card1.length; i++) {// 打乱顺序
				Random r = new Random();
				Card cardtmp = Initial.listCard.get(i);
				Initial.listCard.remove(i);
				Initial.listCard.add(r.nextInt(Initial.listCard.size()), cardtmp);
			}
			//打印出来,测试用
			/*for (int i = 0; i < Initial.listCard.size(); i++) {
				
				System.out.println("第" + (i + 1) + "张" + "\t"
						+ Initial.listCard.toArray()[i]);
			}*/
	}
	public static void list(){ //********************************     //打印武将列表以供选择
		Initial.line();
		System.out.println("=======欢迎来到简易版控制台三国杀=======");
		Initial.line();
		name[0]= "关羽";
		name[1]= "张飞";
		name[2]= "赵云";
		name[3]= "马超";
		name[4]= "刘备";
		name[5]= "诸葛亮";
		name[6]= "黄月英";
		
		name[7]= "曹操";
		name[8]="许褚";
		name[9]="司马懿";
		name[10]="夏侯惇";
		name[11]="郭嘉";
		name[12]="张辽";
		name[13]="甄姬";
		
		name[14]="孙权";
		name[15]="周瑜";
		name[16]="甘宁";
		name[17]="吕蒙";
		name[18]="黄盖";
		name[19]="陆逊";
		name[20]="孙尚香";
		name[21]="大乔";
		
		name[22]="吕布";
		name[23]="貂蝉";
		name[24]="华佗";
		
		System.out.println("请输入序号选择武将...");
		for(int i=0;i<name.length ;i++){
			System.out.println(i+"--"+name[i]);
		}
		System.out.print("=>");
	} 
	public static void setCardKey() throws Exception{                 //从cardkey.cdk文件中读取牌面内容
		FileInputStream fis = new FileInputStream("./cardkey.cdk");
		byte[] buff = new byte[1024];
		int r = 0;
		String str = new String();
		while((r=fis.read(buff))>0){                                  //将读取的内容存放在str临时字符串里
			str=new String(buff,0,r);
		}
		cardKey = str.split("，");                                    //用split方法，分割str赋值给静态数组cardkey
	}
	public static void setKeyMap(){//键值对hmp中put进牌的key
		
		hmp.put("杀", "1");
		hmp.put("闪", "2");
		hmp.put("桃", "3");
		hmp.put("决斗", "4");
		hmp.put("乐不思蜀", "5");
		hmp.put("借刀杀人", "6");
		hmp.put("无懈可击", "7");
		hmp.put("桃园结义", "8");
		hmp.put("万箭齐发", "9");
		hmp.put("闪电", "10");
		hmp.put("南蛮入侵", "11");
		hmp.put("无中生有", "12");
		hmp.put("五谷丰登", "13");
		hmp.put("过河拆桥", "14");
		hmp.put("顺手牵羊", "15");
		
		hmp.put("青钢剑", "16");
		hmp.put("诸葛连弩", "17");
		hmp.put("贯石斧", "18");
		hmp.put("丈八蛇矛", "19");
		hmp.put("雌雄双股剑", "20");
		hmp.put("麒麟弓", "21");
		hmp.put("方天画戟", "22");
		hmp.put("青龙偃月刀", "23");
		hmp.put("八卦阵", "24");
		hmp.put("赤兔", "25");//-1
		hmp.put("紫骍", "26");//-1
		hmp.put("大宛", "27");//-1
		hmp.put("绝影", "28");//+1
		hmp.put("的卢", "29");//+1
		hmp.put("爪黄飞电", "30");//+1
	}
	
	//**********Map 武将和对象的键值表，供玩家用来选择*******************
	public static void putCharacter(){
	hm.put("关羽", new GuanYu());
	hm.put("张飞", new ZhangFei());
	hm.put("赵云", new ZhaoYun());
	hm.put("马超", new MaChao());
	hm.put("刘备", new LiuBei());
	hm.put("诸葛亮", new ZhuGe());
	hm.put("黄月英", new HuangYueYing());
	
	hm.put("曹操", new CaoCao());
	hm.put("许褚", new XuChu());
	hm.put("司马懿", new SiMaYi());
	hm.put("夏侯惇", new XiaHouDun());
	hm.put("郭嘉", new GuoJia());
	hm.put("张辽", new ZhangLiao());
	hm.put("甄姬", new ZhenJi());
	
	hm.put("孙权", new SunQuan());
	hm.put("周瑜", new ZhouYu());
	hm.put("甘宁", new GanNing());
	hm.put("吕蒙", new LvMeng());
	hm.put("黄盖", new HuangGai());
	hm.put("陆逊", new LuXun());
	hm.put("孙尚香", new SunShangXiang());
	hm.put("大乔", new DaQiao());
	
	hm.put("吕布", new LvBu());
	hm.put("貂蝉", new DiaoChan());
	hm.put("华佗", new HuaTuo());
	//...
	//...
	//****************************************************************
	}
	//打印分割线
	public static void line(){
		System.out.println("========================================");
	}
}
	