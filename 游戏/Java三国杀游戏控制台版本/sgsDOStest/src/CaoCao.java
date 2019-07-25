import java.util.Random;
import java.util.Scanner;

//以曹操为首的曹魏集合

//曹操
public class CaoCao extends Character {
	public CaoCao() {
		this.setName("曹操");
		this.setmaxHp(4);
		this.setHp(this.getmaxHp());
	}

	// 重写受伤触发事件，获取伤害牌，获取废弃牌堆里的最后一张？
	public void afterHurt(Player p, Player pSha) {
		System.out.println("（曹操：宁教我负天下人，休教天下人负我！）");
		System.out.println(p.toString() + "获得了：" + pSha.getTmpCard());
		// 收牌
		p.addhandCard(pSha.getTmpCard());
		// 牌堆中最后一张移除
		Initial.throwlistCard.remove(Initial.throwlistCard.size() - 1);
	}
}

// 许褚
class XuChu extends Character {
	public XuChu() {
		this.setName("许褚");
		this.setmaxHp(4);
		this.setHp(this.getmaxHp());
	}

	// 重写回合开始，选择是否裸衣
	public void Start(Player who, Player towho) {
		int r = 0;
		// 若AI则随机
		if (who.getType().equals("(AI)")) {
			r = new Random().nextInt(2);
		} else {
			// 玩家选择
			System.out.println("是否发动裸衣？1为确定，0为取消");
			Scanner sc = new Scanner(System.in);
			r = sc.nextInt();
		}
		//判断r
		if (r == 1) {
			who.setLuoYi(true);
			System.out.println("（许褚：呵！）");
			System.out.println(who.toString() + "发动裸衣效果");
		} else {
			who.setLuoYi(false);
		}
	}

	// 重写摸牌
	public void AddCard(Player who, int num, Player towho) {
		if (who.isLuoYi()) {
			super.AddCard(who, 1, towho);
		} else {
			super.AddCard(who, 2, towho);
		}
	}

	// 额外伤害方法 许褚重写
	public int hurtAdd(Player p, Player pHurt) {
		// 先判断下是否发动裸衣效果；
		if (p.isLuoYi()) {
			System.out.println("许褚裸衣效果触发，伤害加成！");
			return 1;
		} else {
			return 0;
		}
	}
}

// 司马懿
class SiMaYi extends Character {
	public SiMaYi() {
		this.setName("司马懿");
		this.setmaxHp(3);
		this.setHp(this.getmaxHp());
	}

	// 重写受伤后触发事件
	public void afterHurt(Player p, Player pSha) {
		System.out.println("（司马懿：下次注意点！）");
		int index = p.selectCard(pSha) - 1;// 注意-1操作；
		p.addhandCard(pSha.getHandcard().get(index));
		System.out.println(p.toString() + "从" + pSha.toString() + "手中获得了："
				+ pSha.getHandcard().get(index).toString());
		pSha.removeCard(index);
	}

	// (天命)人物替换判定牌,司马懿重写
	public Card insteadCard(Player p, Card c) {
		// 如果没有手牌，调用父类方法
		if (p.getHandcard().size() == 0) {
			return c;
		}
		System.out.println("原始判定牌为：" + c.toString());
		System.out.println("是否替换判定牌，输入手牌序号，0为取消");

		// 从自己手牌里选一张
		int index = p.selectCard(p);
		if (index == 0) {
			System.out.println("不换牌...");
			return c;
		} else {
			Initial.throwlistCard.add(c);
			Card tmp = p.getHandcard().get(index - 1);
			p.removeCard(index - 1);
			System.out.println("（司马懿：天命！哈哈哈....）");
			System.out.println("判定牌被替换！");
			return tmp;
		}

	}
}

// 夏侯惇
class XiaHouDun extends Character {
	public XiaHouDun() {
		this.setName("夏侯惇");
		this.setmaxHp(4);
		this.setHp(this.getmaxHp());
	}

	// 重写受伤后触发事件
	public void afterHurt(Player p, Player pSha) {
		System.out.println("（夏侯惇：鼠辈，竟敢伤我！）");
		// 调用花色判定方法
		if (p.checkColor(p, "红心", null, pSha)) {
			System.out.println(pSha.toString() + "扣血1点");
			pSha.setHp(pSha.getHp() - 1);
			pSha.checkHPNull();
		} else {
			System.out.println("刚烈无效.");
		}
	}
}

// 郭嘉
class GuoJia extends Character {
	public GuoJia() {
		this.setName("郭嘉");
		this.setmaxHp(3);
		this.setHp(this.getmaxHp());
	}

	// （遗计）重写受伤触发事件，摸2张牌
	public void afterHurt(Player p, Player pSha) {
		System.out.println("（郭嘉：就这样吧...）");
		System.out.println("遗计触发，郭嘉获得2张牌");
		p.getCharacter().AddCard(p, 2, pSha);
	}

	// （天妒）获取判定牌，重写处理判定牌的方法
	public void doWithCheckCard(Player p, Card c, boolean succeed) {
		System.out.println("（郭嘉：也好...）");
		System.out.println("郭嘉获得了判定牌：" + c.toString());
		p.addhandCard(c);
	}
}

// 张辽
class ZhangLiao extends Character {
	public ZhangLiao() {
		this.setName("张辽");
		this.setmaxHp(4);
		this.setHp(this.getmaxHp());
	}

	// 重写摸牌方法
	public void AddCard(Player p, int num, Player top) {
		// 若对面手中无牌，则调用父类方法，常规摸牌
		if (top.getHandcard().size() == 0) {
			super.AddCard(p, 2, top);
			return;
		}
		System.out.println("（张辽：没想到吧！）");
		int index = p.selectCard(top) - 1;// 注意-1操作；
		p.addhandCard(top.getHandcard().get(index));
		System.out.println(p.toString() + "从" + top.toString() + "手中偷到了："
				+ top.getHandcard().get(index).toString());
		top.removeCard(index);
	}
}

// 甄姬
class ZhenJi extends Character {
	public ZhenJi() {
		this.setName("甄姬");
		this.setmaxHp(3);
		this.setHp(this.getmaxHp());
	}

	// （洛神）摸牌判定方法，甄姬重写
	public void checkOnAddCard(Player p, Player top) {
		// 打印发动的效果
		System.out.println("（甄姬：仿佛兮若轻云之蔽月，飘飘兮若流风之回雪...）");
		// 循环，只要判定成功就一直判定
		while (true) {
			if (p.getCharacter().checkColor(p, "黑桃", "梅花", top)) {
				p.addhandCard(Initial.tmpCheckCard);
				System.out.println(p.toString() + "获得了："
						+ Initial.tmpCheckCard.toString());
			} else {
				System.out.println("判定失效，洛神终止");
				break;
			}
		}
	}

	// 变牌方法
	public boolean changeCard(Card c, String key) {
		// 如果需要的是出闪
		if (key.equals("闪")) {
			// 并且检测的牌为黑色
			if (c.getColor().equals("黑桃") || c.getColor().equals("梅花")) {
				System.out.println("（甄姬：凌波微步，罗袜生尘...）");
				return true;
			}
		}
		return false;
	}
}