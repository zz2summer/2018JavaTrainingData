import java.util.ArrayList;

//锦囊类，存储各个锦囊的方法；
//创造一个带参数index的实例，根据index,调用相应的锦囊方法
public class JinNang {
	private int index;

	public JinNang() {
	}

	public JinNang(int index) {
		this.index = index;
	}

	public boolean useJinNang(Player p, Player top,Card card) {
		switch (this.index) { // index 是从上一层方法传来的参数，值域为4-15
		case 4: //决斗
			this.juedou(p, top);
			break;
		case 5://乐不思蜀
			if(top.isLeBuSiShu()==true){
				System.out.println("目标已经中了乐不思蜀");
				return false;
			}
			if(top.getCharacter().getName().equals("陆逊")){
				System.out.println("不能对陆逊使用乐不思蜀！");
				return false;
			}else{
				this.lebusishu(p, top,card);
				break;
			}
		case 6: //借刀杀人
			if(top.getEqiup(0)==null){
				System.out.println("目标没有武器，不能借刀！");
				return false;
			}else{
				this.jiedaosharen(p, top);
				break;
			}
		case 7://无懈可击
			this.wuxxiekeji(p, top);
			break;
		case 8://桃园结义
			this.taoyuanjieyi(p, top);
			break;
		case 9: // 万箭齐发
			this.wanjianqifa(p, top);
			break;
		case 10://闪电
			if(top.isShanDian()==true){
				System.out.println("目标已经中了闪电");
				return false;
			}
			this.shandian(p, top,card);
			break;
		case 11: // 南蛮入侵
			this.nanmanruqin(p, top);
			break;
		case 12: // 无中生有
			this.wuzhongshengyou(p, top);
			break;
		case 13: //五谷丰登
			this.wugufengdeng(p, top);
			break;
		case 14: // 过河拆桥
			//目标没有手牌
			if(top.getHandcard().size()==0){
				if(p.getType().equals("(玩家)")){
					System.out.println("目标无手牌，不能使用！");
				}
				return false;
			}
			this.guohechaiqiao(p, top);
			break;
		case 15: // 顺手牵羊
			if(top.getHandcard().size()==0){
				if(p.getType().equals("(玩家)")){
					System.out.println("目标无手牌，不能使用！");
				}
				return false;
			}
			if(top.getCharacter().getName().equals("陆逊")){
				System.out.println("不能对陆逊使用顺手牵羊！");
				return false;
			}else{
				this.shunshouqianyang(p, top);
				break;
			}
		}
		return true;
	}

	// ---------------------------------------------------------------------------------------------------------
	// 各个锦囊技能的具体方法
	// ---------------------------------------------------------------------------------------------------------
	// 决斗
	public void juedou(Player p, Player top) {
		System.out.println("");
		//询问对手是否出无懈
		if(top.requestWuXie(p)==true){
			System.out.println("决斗被否决！");
			return;
		}
		Player pTurn = top;//被决斗的玩家先出杀
		boolean b = false;
		while(pTurn.requestSha()==true){
			b=!b;
			pTurn = b?p:top;
		}
		System.out.println(pTurn.toString()+"扣血1点...");
		pTurn.setHp(pTurn.getHp()-1);
		pTurn.printHp();
		pTurn.checkHPNull();
		//交换出牌
		Player tmpPlayer = new Player();
		if(pTurn == p){
			tmpPlayer = top;
		}else{
			tmpPlayer = p;
		}
		pTurn.getCharacter().afterHurt(pTurn, tmpPlayer);
	}

	// 乐不思蜀
	public void lebusishu(Player p, Player top,Card c) {
		top.addMagicCard(c);
		System.out.println(p.toString()+"对"+top.toString()+"施放："+c.toString());
		top.setLeBuSiShu(true);
	}

	// 借刀杀人
	public void jiedaosharen(Player p, Player top) {
		//询问对手是否出无懈
		if(top.requestWuXie(p)==true){
			System.out.println("借刀杀人被否决！");
			return;
		}
		if(top.requestSha()){
			top.sha(top	, p);
		}else{
			p.addhandCard(top.getEqiup(0));
			System.out.println(p.toString()+"获得了："+top.getEqiup(0).toString());
			top.setEqiup(null, 0);
		}
	}

	// 无懈可击
	public void wuxxiekeji(Player p, Player top) {

	}

	// 桃园结义
	public void taoyuanjieyi(Player p, Player top) {
		//询问对手是否出无懈
		if(top.requestWuXie(p)==true){
			System.out.println("桃园结义被否决！");
			return;
		}
		System.out.println("桃园结义，所有人加血...");
		if (p.getHp() < p.getCharacter().getmaxHp()) {
			p.addHp();
			p.printHp();
		}
		if (top.getHp() < top.getCharacter().getmaxHp()) {
			top.addHp();
			top.printHp();
		}
	}

	// 万箭齐发
	public void wanjianqifa(Player p, Player top) {
		System.out.println(top.getType() + top.getCharacter().getName()
				+ "需要出闪...");
		//询问对手是否出无懈
		if(top.requestWuXie(p)==true){
			System.out.println("万箭齐发被否决！");
			return;
		}
		if (top.requestshan(p,top) == false) {
			top.setHp(top.getHp() - 1);
			System.out.println(top.getType() + top.getCharacter().getName()
					+ "扣血...");
			top.printHp();
			top.checkHPNull();
			top.getCharacter().afterHurt(top, p);
		}
	}

	// 闪电
	public void shandian(Player p, Player top,Card c) {
		p.addMagicCard(c);
		System.out.println(p.toString()+"施放："+c.toString());
		p.setShanDian(true);
	}

	// 南蛮入侵
	public void nanmanruqin(Player p, Player top) {
		//询问对手是否出无懈
		if(top.requestWuXie(p)==true){
			System.out.println("南蛮入侵被否决！");
			return;
		}
		if (top.requestSha() == false) {
			top.setHp(top.getHp() - 1);
			System.out.println(top.getType() + top.getCharacter().getName()
					+ "扣血...");
			top.printHp();
			top.checkHPNull();
			top.getCharacter().afterHurt(top, p);
		}
	}

	// 无中生有
	public void wuzhongshengyou(Player p, Player top) {
		//询问对手是否出无懈
		if(top.requestWuXie(p)==true){
			System.out.println("无中生有被否决！");
			return;
		}
		p.getCharacter().AddCard(p, 2, top);
		System.out.println(p.getType() + p.getCharacter().getName() + "获得2张牌");
	}

	// 五谷丰登
	public void wugufengdeng(Player p, Player top) {
		//询问对手是否出无懈
		if(top.requestWuXie(p)==true){
			System.out.println("五谷丰登被否决！");
			return;
		}
		//翻牌2张
		//选择，发牌
		System.out.println("五谷丰登，每人可获得一张牌");
		ArrayList<Card> tmp = new ArrayList<Card>();
		for (int i = 0; i <2; i++) {
			tmp.add(Initial.listCard.get(i));
			Initial.listCard.remove(i);
			System.out.println("第"+(i+1)+"张牌："+tmp.get(i).toString());
		}
		int r =p.selectCardIndex(2);
		if(r!=0&&r!=1){
			System.out.println("输入有误！");
			wugufengdeng(p, top);
			return;
		}
		p.addhandCard(tmp.get(r));
		System.out.println(p.toString()+"获得了"+tmp.get(r));
		tmp.remove(r);
		top.addhandCard(tmp.get(0));
		System.out.println(top.toString()+"获得了"+tmp.get(0));
	}

	// 过河拆桥
	public void guohechaiqiao(Player p, Player top) {
		//询问对手是否出无懈
		if(top.requestWuXie(p)==true){
			System.out.println("过河拆桥被否决！");
			return;
		}
		int index = p.selectCard(top)-1 ;
		System.out.println(top.toString()+"的：["+top.getHandcard().get(index).toString() + "]被丢弃...");
		top.removeCard(index);
		//无牌检测
		if(top.getHandcard().size() == 0){
			top.getCharacter().noCard(top);
		}
	}

	// 顺手牵羊
	public void shunshouqianyang(Player p, Player top) {
		//询问对手是否出无懈
		if(top.requestWuXie(p)==true){
			System.out.println("顺手牵羊被否决！");
			return;
		}
		int index = p.selectCard(top) - 1;// 注意-1操作；
		p.addhandCard(top.getHandcard().get(index));
		System.out.println(p.getType() + p.getCharacter().getName() + "从"
				+ top.getType() + top.getCharacter().getName() + "手中获得了："
				+ top.getHandcard().get(index).toString());
		top.removeCard(index);
		//无牌检测
		if(top.getHandcard().size() == 0){
			top.getCharacter().noCard(top);
		}
	}
	// -----------get set-----------------------------
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
}
