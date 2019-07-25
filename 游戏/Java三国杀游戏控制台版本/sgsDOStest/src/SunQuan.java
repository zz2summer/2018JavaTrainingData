import java.util.ArrayList;

//以孙权为首的东吴集团
//孙权
public class SunQuan extends Character {
	public SunQuan() {
		this.setName("孙权");
		this.setmaxHp(4);
		this.setHp(this.getmaxHp());
	}
	//（制衡）重写主动技能，换手牌
	public void useSkill(Player p, Player top){
		//判断是否已经用过，是则直接返回
		if(p.isHasUsedSkill()){
			System.out.println("该技能每回合只能用一次！");
			return;
		}
		System.out.println("（孙权：容我三思...）");
		//建立临时集合，存储丢弃的牌
		ArrayList<Card> tmpCard = new ArrayList<Card>();
		while(true){
			//先选择弃牌
			int r = p.selectCard(p)-1;//传过来之前没有-1，需要-1处理
			if(r == -1){//输入0表示完成弃牌，开始换牌
				break;
			}
			//将丢弃的牌放入临时集合
			tmpCard.add(p.getHandcard().get(r));
			//手牌删除
			p.removeCard(r);
		}
		//打印下
		System.out.println(p.toString()+"舍弃的牌：");
		for (int i = 0; i < tmpCard.size(); i++) {
			System.out.println(" "+tmpCard.get(i).toString());
		}
		//摸相应数量的牌
		if(tmpCard.size()!= 0){
			p.getCharacter().AddCard(p, tmpCard.size(), null);
		}
		//用完后，关闭
		p.setHasUsedSkill(true);
	}
}

// 周瑜
class ZhouYu extends Character {
	public ZhouYu() {
		this.setName("周瑜");
		this.setmaxHp(3);
		this.setHp(this.getmaxHp());
	}

	// 重写摸牌方法
	public void AddCard(Player who, int num, Player towho) {
		System.out.println("（周瑜：呵呵呵哈哈哈......）");
		super.AddCard(who, num + 1, towho);
	}
	//（猜花色）重写主动技能
	public void useSkill(Player p, Player top){
		//判断是否已经用过，是则直接返回
		if(p.isHasUsedSkill()){
			System.out.println("该技能每回合只能用一次！");
			return;
		}
		System.out.println("（周瑜：挣扎吧，在血和暗的深渊！）");
		//定义数组，存放4个花色
		String[] color = {"黑桃","红心","梅花","方块"};
		//目标选择的花色
		String selectColor = color[top.selectCardIndex(4)];
		System.out.println(top.toString()+"猜花色为："+selectColor);
		//目标选的牌
		int index = top.selectCardIndex(p.getHandcard().size());
		Card selectCard = p.getHandcard().get(index);
		System.out.println(top.toString()+"抽到了牌："+selectCard.toString());
		p.removeCard(index);
		//根据花色，判断是否扣血
		if(selectCard.getColor().equals(selectColor)==false){
			System.out.println(top.toString()+"猜错花色，扣血1点");
			top.setHp(top.getHp()-1);
			top.checkHPNull();
		}
		//给牌
		top.addhandCard(selectCard);
		System.out.println(top.toString()+"获得了："+selectCard.toString());
		//用完后，关闭
		p.setHasUsedSkill(true);
	}
}

// 甘宁
class GanNing extends Character {
	public GanNing() {
		this.setName("甘宁");
		this.setmaxHp(4);
		this.setHp(this.getmaxHp());
	}

	// 变牌方法，黑牌等同过河拆桥
	public boolean changeCard(Card c, String key) {
		if (key.equals("过河拆桥")) {
			if (c.getColor().equals("黑桃") || c.getColor().equals("梅花")) {
				return true;
			}
		}
		return false;
	}

	// 重写主动技能
	// 主动技能写着真烦啊！！！！！！
	// 因为玩家可以触发的事件只有控制台输入，再蛋疼也只能硬头皮写
	public void useSkill(Player p, Player top) {
		//无手牌直接退出
		if (p.getHandcard().size() == 0) {
			System.out.println("无手牌，无法发动技能");
			return;
		}
		// 建立一个集合，作为预出的牌，打印显示以供选择
		ArrayList<Card> tmpCard = new ArrayList<Card>();
		// 进入技能出牌循环，直到无手牌，或者选择取消
		while (true) {
			//遍历手牌，将符合条件的牌放入集合，
			for (int i = 0; i < p.getHandcard().size(); i++) {
				if (p.getCharacter().changeCard(p.getHandcard().get(i), "过河拆桥")) {
					// 将符合的牌放入集合
					tmpCard.add(p.getHandcard().get(i));
					// 手牌删除 ，若取消则将临时集合的牌再放回
					p.removeCard(i);
					i--;
				}
			}
			//如果遍历完毕后，没有符合条件的，退出
			if(tmpCard.size() == 0){
				System.out.println("没有可用的牌！");
				return;
			}
			// 将满足条件的牌打印出来
			System.out.print("可以当做过河拆桥使用的牌：");
			for (int i = 0; i < tmpCard.size(); i++) {
				// 打印显示
				System.out.print((i + 1) + "--["+tmpCard.get(i).toString() + "]");
			}
			System.out.println();
			// 接受输入参数 （返回值已做过-1处理，直接可用）
			int r = p.selectCardIndex(tmpCard.size());
			if(r== -1){//即输入的是0
				System.out.println("玩家结束技能");
				//将临时集合的牌放回手牌
				p.getHandcard().addAll(tmpCard);
				return;
			}
			try {
				System.out.println("（甘宁：你的牌太多了！）");
				//删除第r张牌
				tmpCard.remove(r);
				//调用过河拆桥方法
				new JinNang().guohechaiqiao(p, top);
			} catch (Exception e) {
				System.out.println("输入有误，重新输入！");
			}
		}
	}
}

// 吕蒙
class LvMeng extends Character {
	public LvMeng() {
		this.setName("吕蒙");
		this.setmaxHp(4);
		this.setHp(this.getmaxHp());
	}

	// 重写弃牌方法
	public void ThrowCard(Player who) {
		if (who.isSha() == false) {
			System.out.println("（吕蒙：克己！不用弃牌）");
			return;
		} else {
			super.ThrowCard(who);
		}
	}
}

// 黄盖
class HuangGai extends Character {
	public HuangGai() {
		this.setName("黄盖");
		this.setmaxHp(4);
		this.setHp(this.getmaxHp());
	}

	// （苦肉）重写主动技能方法，扣1点血，摸2张牌
	public void useSkill(Player p, Player top) {
		System.out.println("（黄盖：鞭笞我吧，公瑾！）");
		// 扣血
		p.setHp(p.getHp() - 1);
		p.printInfo();
		// 检测血量
		p.checkHPNull();
		// 摸牌2张
		p.getCharacter().AddCard(p, 2, null);
		// 该技能可无限释放，故不用设置主动技能开关
	}
}

// 陆逊
class LuXun extends Character {
	public LuXun() {
		this.setName("陆逊");
		this.setmaxHp(3);
		this.setHp(this.getmaxHp());
	}

	// （连营）重写无牌方法
	public boolean noCard(Player p) {
		System.out.println("（陆逊：牌不是万能的，但没牌是万万不能的！）");
		this.AddCard(p, 1, null);
		return false;
	}
}

// 孙尚香
class SunShangXiang extends Character {
	public SunShangXiang() {
		this.setName("孙尚香");
		this.setmaxHp(3);
		this.setHp(this.getmaxHp());
	}
	//（枭姬）重写装备卸载事件
    public void eqiupUnload(Player p,Player top){
    	System.out.println("（孙尚香：哼！）");
    	//摸牌2张
    	p.getCharacter().AddCard(p, 2, null);
    }
}

// 大乔
class DaQiao extends Character {
	public DaQiao() {
		this.setName("大乔");
		this.setmaxHp(3);
		this.setHp(this.getmaxHp());
	}
	// 变牌方法，方块等同乐不思蜀
	public boolean changeCard(Card c, String key) {
		if (key.equals("乐不思蜀")) {
			if (c.getColor().equals("方块") ) {
				return true;
			}
		}
		return false;
	}
	//（国色） 乐不思蜀
	public void useSkill(Player p, Player top) {
		//无手牌直接退出
		if (p.getHandcard().size() == 0) {
			System.out.println("无手牌，无法发动技能");
			return;
		}
		// 建立一个集合，作为预出的牌，打印显示以供选择
		ArrayList<Card> tmpCard = new ArrayList<Card>();
		// 进入技能出牌循环，直到无手牌，或者选择取消
		while (true) {
			//遍历手牌，将符合条件的牌放入集合，
			for (int i = 0; i < p.getHandcard().size(); i++) {
				if (p.getCharacter().changeCard(p.getHandcard().get(i), "乐不思蜀")) {
					// 将符合的牌放入集合
					tmpCard.add(p.getHandcard().get(i));
					// 手牌删除 ，若取消则将临时集合的牌再放回
					p.removeCard(i);
					i--;
				}
			}
			//如果遍历完毕后，没有符合条件的，退出
			if(tmpCard.size() == 0){
				System.out.println("没有可用的牌！");
				return;
			}
			// 将满足条件的牌打印出来
			System.out.print("可以当做乐不思蜀使用的牌：");
			for (int i = 0; i < tmpCard.size(); i++) {
				// 打印显示
				System.out.print((i + 1) + "--["+tmpCard.get(i).toString() + "]"+"\t");
			}
			System.out.println();
			// 接受输入参数 （返回值已做过-1处理，直接可用）
			int r = p.selectCardIndex(tmpCard.size());
			if(r== -1){//即输入的是0
				System.out.println("玩家结束技能");
				//将临时集合的牌放回手牌
				p.getHandcard().addAll(tmpCard);
				return;
			}
			try {
				//调用乐不思蜀
				System.out.println("（大乔：休息一下！）");
				if(new JinNang(5).useJinNang(p, top, tmpCard.get(r))){
					//删除第r张牌
					tmpCard.remove(r);
				}
				
			} catch (Exception e) {
				System.out.println("输入有误，重新输入！");
			}
		}
	}
}

// 另外3个群雄
// 吕布
class LvBu extends Character {
	public LvBu() {
		this.setName("吕布");
		this.setmaxHp(4);
		this.setHp(this.getmaxHp());
	}

	// 重写杀的额外条件，需要多出一次闪
	public boolean shaWithOtherCheck(Player p, Player top) {
		System.out.println("吕布：谁能挡我！！！");
		return top.requestshan(p,top);
	}
}

// 貂蝉
class DiaoChan extends Character {
	public DiaoChan() {
		this.setName("貂蝉");
		this.setmaxHp(3);
		this.setHp(this.getmaxHp());
	}

	// 重写回合结束方法，摸牌1张
	public void End(Player who, Player towho) {
		System.out.println("（貂蝉：失礼了...）");
		who.getCharacter().AddCard(who, 1, null);
		// 原方法里有交换出牌权的代码，需要调用
		super.End(who, towho);
	}
}

// 华佗
class HuaTuo extends Character {
	public HuaTuo() {
		this.setName("华佗");
		this.setmaxHp(3);
		this.setHp(this.getmaxHp());
	}

	// （青囊）重写主动技能方法
	public void useSkill(Player p, Player top) {
		// 如果没有手牌，或者血量满，则无法发动技能
		if (p.getHandcard().size() == 0
				|| p.getHp() == p.getCharacter().getmaxHp()) {
			System.out.println("无手牌or血量已满，无法发动技能！");
			return;
		} else {
			int r = p.selectCard(p) - 1;// 注意-1操作
			Card tmp = p.getHandcard().get(r);
			System.out.println("（华佗：越老越要补啊！）");
			System.out.println(p.toString() + "发动技能青囊：" + tmp.toString());
			p.removeCard(r);
			Initial.throwlistCard.add(tmp);
			p.tao();
		}
	}
	//（急救）重写变牌方法
	public boolean changeCard(Card c,String key){
		//如果需要的是出桃
    	if(key.equals("桃")){
    		//并且检测的牌为红色
    		if(c.getColor().equals("红心") || c.getColor().equals("方块")){
    			System.out.println("（华佗：救人一命，胜造七级浮屠！）");
    			System.out.println("华佗打出["+c.toString()+"]作桃...");
    			return true;
    		}
    	}
    	return false;
	}
}