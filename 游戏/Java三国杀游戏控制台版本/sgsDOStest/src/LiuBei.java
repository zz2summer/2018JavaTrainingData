import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

//以刘备为首的蜀汉武将类的集合
//刘备
public class LiuBei extends Character {
	public LiuBei() {
		this.setName("刘备");
		this.setmaxHp(4);
		this.setHp(this.getmaxHp());
	}

	// （仁德）重写主动技能
	public void useSkill(Player p, Player top) {
		// 定义一个计数变量，统计给牌数量
		// 此处可能定义全局变量比较好，暂时不改
		int num = 0;
		// 循环，直到无手牌或者取消
		while (true) {
			// 【需要】异常处理
			// 若手牌存在，则执行给牌
			if (p.getHandcard().size() == 0) {
				System.out.println("无手牌，不能发动人物技能！");
				return;
			} else {
				int r = p.selectCard(p);
				if (r == 0) {
					// 若输入0，先判断是否够加血的条件，再退出方法
					if (p.getHp() < p.getCharacter().getmaxHp() && num >= 2) {
						System.out.println(p.toString() + "增加1点血量");
						p.addHp();
					}
					System.out.println(p.toString() + "结束技能...");
					return;
				}
				// 取得选中的牌，放入临时区
				Card tmp = p.getHandcard().get(r - 1);// 注意-1操作
				// 打印效果
				System.out.println("（刘备：惟贤惟德，仁服于人！）");
				System.out.println(p.toString() + "给" + top.toString() + "送牌："
						+ tmp.toString());
				// 把选中的牌，从手牌中删除
				p.removeCard(r - 1);// 注意-1操作
				// 放入对方手牌中
				top.addhandCard(tmp);
				top.reSetKongCheng();
				// 计数器+1
				num++;
			}

		}
	}
}

// 关羽
class GuanYu extends Character {
	public GuanYu() {
		this.setName("关羽");
		this.setmaxHp(4);
		this.setHp(this.getmaxHp());
	}

	// (武圣)重写变牌，如果要求出杀，并且牌面为红，返回真
	public boolean changeCard(Card c, String key) {
		if (key.equals("杀")) {
			if (c.getColor().equals("红心") || c.getColor().equals("方块")) {
				return true;
			}
		}
		return false;
	}

	// 变牌出杀（与赵云共享）
	public void useSkill(Player p, Player top) {
		// 无手牌直接退出
		if (p.getHandcard().size() == 0) {
			System.out.println("无手牌，无法发动技能");
			return;
		}
		if (p.getCharacter().getName().equals("关羽")) {
			System.out.println("（关羽：观尔乃插标卖首！）");
		}
		// 建立一个集合，作为预出的牌，打印显示以供选择
		ArrayList<Card> tmpCard = new ArrayList<Card>();
		// 进入技能出牌循环，直到无手牌，或者选择取消
		while (true) {
			// 遍历手牌，将符合条件的牌放入集合，
			for (int i = 0; i < p.getHandcard().size(); i++) {
				if (p.getCharacter().changeCard(p.getHandcard().get(i), "杀")) {
					// 将符合的牌放入集合
					tmpCard.add(p.getHandcard().get(i));
					// 手牌删除 ，若取消则将临时集合的牌再放回
					p.removeCard(i);
					i--;
				}
			}
			// 如果遍历完毕后，没有符合条件的，退出
			if (tmpCard.size() == 0) {
				System.out.println("没有可作技能用的牌，结束技能。");
				return;
			}
			// 将满足条件的牌打印出来
			System.out.print("可以当做杀使用的牌：");
			for (int i = 0; i < tmpCard.size(); i++) {
				// 打印显示
				System.out.print((i + 1) + "--[" + tmpCard.get(i).toString()
						+ "]");
			}
			System.out.println();
			// 接受输入参数 （返回值已做过-1处理，直接可用）
			int r = p.selectCardIndex(tmpCard.size());
			if (r == -1) {// 即输入的是0
				System.out.println("玩家结束技能");
				// 将临时集合的牌放回手牌
				p.getHandcard().addAll(tmpCard);
				return;
			}
			try {
				// 调用杀方法
				if (p.sha(p, top)) {
					// 删除第r张牌
					tmpCard.remove(r);
					p.getCharacter().noCard(p);
				}
			} catch (Exception e) {
				System.out.println("输入有误，重新输入！");
			}
		}
	}
}

// 赵云
class ZhaoYun extends Character {
	public ZhaoYun() {
		this.setName("赵云");
		this.setmaxHp(4);
		this.setHp(this.getmaxHp());
	}

	// 变牌方法
	public boolean changeCard(Card c, String key) {
		// 如果需要出杀或者闪
		if (key.equals("杀") || key.equals("闪")) {
			// 如果检测的牌是杀或者闪
			if (c.key.equals("杀") || c.key.equals("闪")) {
				return true;
			}
		}
		return false;
	}

	// 主动技能
	// 偷懒 调用关羽的 （都是变牌出杀）
	public void useSkill(Player p, Player top) {
		System.out.println("（赵云：能进能退，乃真正法器！）");
		new GuanYu().useSkill(p, top);
	}
}

// 张飞，重写杀方法************
class ZhangFei extends Character {
	public ZhangFei() { // 构造方法
		this.setName("张飞");
		this.setmaxHp(4);
		this.setHp(this.getmaxHp());
	}

	// 是否出过杀，在杀之后调用，张飞重写此方法
	public boolean haveYouSha() {
		System.out.println("（张飞：燕人张飞在此！！）");
		return false;
	}
}

// 马超
class MaChao extends Character {
	public MaChao() {
		this.setName("马超");
		this.setmaxHp(4);
		this.setHp(this.getmaxHp());
		this.setDisAtt(2); // 攻击距离+1;
	}

	// 强杀事件，马超重写
	// 返回boolean，是否无视闪，在requestShan里调用
	public boolean ignoreShan(Player p, Player top) {
		// 若花色判定为红心，返回真；上层的杀方法直接执行扣血
		System.out.println("（马超：全军突击！！）");
		if (p.checkColor(p, "红心", "方块", top)) {
			System.out.println("此杀无法闪避！！");
			return true;
		} else {
			System.out.println("铁骑无效，可以出闪");
			return false;
		}
	}
}

// 诸葛
class ZhuGe extends Character {
	public ZhuGe() {
		this.setName("诸葛亮");
		this.setmaxHp(3);
		this.setHp(this.getmaxHp());
	}

	// （空城）重写无牌方法，在任何删除手牌方法后调用
	public boolean noCard(Player p) {
		System.out.println("空城技能触发！");
		p.setKongCheng(true);
		return false;
	}

	// （观星）重写回合开始
	public void Start(Player who, Player towho) {
		super.Start(who, towho);
		System.out.println("（诸葛亮：观今夜天象，知天下大势。）");
		if (who.getType().equals("(AI)")) {
			// AI的观星方法,随机流
			Random r = new Random();
			this.select(r.nextInt(5), who, towho);
		} else {
			System.out.println("牌堆第1张：" + Initial.listCard.get(0));
			System.out.println("牌堆第2张：" + Initial.listCard.get(1));
			System.out.println("请选择操作方式：");
			System.out.println("输入0：维持不变；");
			System.out.println("输入1：交换2张牌的顺序；");
			System.out.println("输入2：将第1张放到牌堆最后；");
			System.out.println("输入3：将第2张放到牌堆最后；");
			System.out.println("输入4：2张牌都放到牌堆最后；");
			// 玩家输入
			Scanner sc = new Scanner(System.in);
			try {
				int r = sc.nextInt();
				this.select(r, who, towho);
			} catch (Exception e) {
				System.out.println("不合法的输入！");
				Start(who, towho);
			}
		}
	}

	// 选择具体的操作方法
	public void select(int r, Player who, Player towho) {
		if (r >= 0 && r < 5) {
			switch (r) {
			case 0:
				break;
			case 1:
				Card tmp = Initial.listCard.get(0);
				Initial.listCard.remove(0);
				Initial.listCard.add(1, tmp);
				break;
			case 2:
				Card tmp1 = Initial.listCard.get(0);
				Initial.listCard.remove(0);
				Initial.listCard.add(tmp1);
				break;
			case 3:
				Card tmp2 = Initial.listCard.get(1);
				Initial.listCard.remove(1);
				Initial.listCard.add(tmp2);
				break;
			case 4:
				Card tmpC1 = Initial.listCard.get(0);
				Card tmpC2 = Initial.listCard.get(1);
				Initial.listCard.remove(0);
				Initial.listCard.remove(0);
				Initial.listCard.add(tmpC1);
				Initial.listCard.add(tmpC2);
				break;
			}
			System.out.println(who.toString() + "完成操作。");
		} else {
			System.out.println("输入有误，重新选择！");
			Start(who, towho);
		}
	}

}

// 黄月英
class HuangYueYing extends Character {
	public HuangYueYing() {
		this.setName("黄月英");
		this.setmaxHp(3);
		this.setHp(this.getmaxHp());
	}

	// 重写使用锦囊，摸一张牌
	// 此处有些缺陷，不能直接摸牌，而是要完成具体锦囊方法后才摸牌，这是整个框架上的缺陷，唉。
	public void useJinNang(Player p) {
		System.out.println("（黄月英：哼！）");
		p.getCharacter().AddCard(p, 1, null);
	}
}