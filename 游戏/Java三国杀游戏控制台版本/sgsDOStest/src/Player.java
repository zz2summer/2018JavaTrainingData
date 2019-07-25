import java.util.*;

//************���Player��*******************
public class Player {
	private Character character; // ���ѡ������� ����Ÿ��ַ���
	private String type; // ������ͣ�AI������,�����ڴ�ӡ
	private int hp; // ����ĵ�ǰѪ�������ܳ�������character.maxhp
	private ArrayList<Card> handcard = new ArrayList<Card>();// ���ϣ��洢����
	private Card[] eqiup = new Card[4]; // װ������
	private int disAtt; // ��������
	private int disDef; // ��������
	private boolean isSha; // �ж��Ƿ����ɱ
	private boolean hasUsedSkill;// �ж��Ƿ��ù��������ܣ����ĳЩһ�غϷ�һ�εģ�
	private boolean isLuoYi; // �Ƿ�������״̬
	private boolean isLeBuSiShu;// �Ƿ�����
	private boolean isShanDian;// �Ƿ�������
	private boolean isKongCheng;// �Ƿ�ճ�
	private Card tmpCard; // ��ʱ��  ÿ�γ��ƣ���ʱ������һ��
	private ArrayList<Card> magicCard = new ArrayList<Card>();; // �����ʱ�Խ���
	
	
	public Player() {
	}

	// ���������췽����������ѡ�佫,Ѫ������,��������,����
	public Player(Character character, int hp) {
		this.character = character;
		this.hp = hp;
		this.disAtt = this.getCharacter().getDisAtt();
		this.type = "(���)"; // AI����д
	}

	// �غ��е�6�׶Σ�����1Ϊ�����ߣ�����2ΪĿ�����
	public void turn(Player p, Player toP) throws InterruptedException {
		this.getCharacter().Start(p, toP);
		Thread.sleep(999);
		Initial.line();
		this.getCharacter().Check(p, toP);
		Thread.sleep(999);
		Initial.line();
		this.getCharacter().AddCard(p, 2, toP);
		Thread.sleep(999);
		Initial.line();
		this.getCharacter().UseCard(p, toP);
		Thread.sleep(999);
		Initial.line();
		this.getCharacter().ThrowCard(p);
		Thread.sleep(999);
		Initial.line();
		this.getCharacter().End(p, toP);
		Thread.sleep(999);
	}

	// ɱ ��pSha��ʾ��ɱ�ߣ�p��ʾɱ��Ŀ��******************************************
	public boolean sha(Player pSha, Player p) {
		// �����������ȡ������
		if (pSha.getEqiup(0) != null && pSha.getEqiup(0).key.equals("�������")) {
			this.isSha = false;
		}
		// ����Ѿ�����ɱ������Ч
		if (this.isSha && this.getCharacter().haveYouSha()) {
			if(this.getType().equals("(���)")){
				System.out.println("���Ѿ�����ɱ�������ظ���ɱ");
			}
			return false;
		}
		// ����Է����ߣ��ճǣ�������Ч
		if (p.isKongCheng()) {
			if(this.getType().equals("(���)")){
			System.out.println("�Է��ճǣ��޷�ɱ�����");
			}
			return false;
		}
		// ������벻��������Ч
		if (pSha.disAtt < p.disDef ) {
			if(this.getType().equals("(���)")){
			System.out.println("���벻����ɱ����");
			}
			return false;
		}
		// ���ϳ�ɱ��������ʾ��ҳ�ɱ
		System.out.println(pSha.toString() + "��" + p.toString() + "��ɱ...");
		// �Ƚ���ǿ���˺��ж������͹�ʯ����
		// �ٽ���Է���Ӧ��
		// ����Ƕ������������������
		if (pSha.getCharacter().ignoreShan(pSha, p)
				|| p.requestshan(p, pSha) == false
				|| pSha.getCharacter().shaWithOtherCheck(pSha, p) == false) { // ��������Ľ��requestshan()����Ϊfalse��Ŀ���1��Ѫ
			// ��ɱ��Ч���������Ѫ�׶Σ�������˺��ӳɼ��ܴ���
			int dam = pSha.getCharacter().hurtAdd(pSha, p) + 1;
			p.setHp(p.getHp() - dam);
			// ��ӡ��Ѫ��Ϣ
			System.out.println(p.toString() + "��Ѫ" + dam + "��");
			System.out.print(p.toString() + "��ǰѪ����");
			for (int i = 0; i < p.getHp(); i++) {
				System.out.print("��");
			}
			System.out.println(); // ��ӡ��Ѫ����ʾ
			// check�Է�Ѫ����ע�� ֮����д����Ѫ�ĵط� ������Ѫ�����
			p.checkHPNull();
			// �Է���Ѫ�󴥷�����,��һ�������������ߣ��ڶ������������֣�ע��˳��
			p.getCharacter().afterHurt(p, pSha);
		}

		pSha.isSha = pSha.getCharacter().haveYouSha(); // ���أ����Ƴ�ɱ

		return true;
	}

	// ��ʼ����4����
	public void giveCard(Player who) {
		System.out.println("���Ƹ���" + who.toString());
		for (int i = 0; i < 4; i++) {
			ArrayList<Card> tmpc = new ArrayList<Card>();
			tmpc.addAll(0, this.getHandcard());
			tmpc.add(Initial.listCard.get(0));
			System.out.print("[����" + (i + 1) + "]" + "\t");
			Initial.listCard.remove(0);
			who.setHandcard(tmpc);

		}
		System.out.println();
		// ���ﶼ�ǲ���ʱ���õ� ��������ĺ���S���� 
		//  XXX
		//this.setEqiup(new Card("����", "S", "������"), 1);
		/*
		 * this.addhandCard(new Card("����","S","��и�ɻ�")); this.addhandCard(new
		 * Card("����","S","����")); this.setEqiup(new Card("����","S","������"), 1);
		 * this.magicCard.add(new Card("����","S","�ֲ�˼��"));
		 */
	}

	// ��Ҫ����� �����м��
	public boolean requestshan(Player p, Player top) {
		// ����Ƿ��а���
		if (this.getEqiup(1) != null ) {
			boolean b = this.useBaGua(this, top);
			if (b == true) {
				System.out.println("��������Ч��");
				return b;
			} else {
				System.out.println("��������Ч����Ҫ������");
			}
		}
		// ����Ƿ��м��ܣ�������ü��ܷ������ɹ�����true
		// ����Ƿ��������������ƣ�ѯ���Ƿ����������ֱ��û��
		for (int i = 0; i < this.handcard.size(); i++) {
			if (this.getHandcard().get(i).key.equals("��")
					|| this.getCharacter().changeCard(
							this.getHandcard().get(i), "��")) {// �˴���һ��or
				// �Ƿ��ܱ�����Ч��
				System.out.println(this.getHandcard().get(i).toString());
				System.out.println("�Ƿ�����������������1Ϊȷ����0Ϊȡ����");
				Scanner sc = new Scanner(System.in);
				int r = sc.nextInt();
				if (r == 0) {
					continue;
				}
				if (r == 1) {
					this.setTmpCard(this.getHandcard().get(i));
					System.out.println(this.toString()+"������"+this.getTmpCard().toString());
					Initial.throwlistCard.add(this.getHandcard().get(i));
					this.removeCard(i);
					// ���Ƽ��
					if (this.getHandcard().size() == 0) {
						this.getCharacter().noCard(this);
					}
					return true;
				}
			}
		}
		// �������ޣ�����false
		System.out.println(this.toString() + "������...");
		return false;
	}

	// ��Ҫ���ɱ�����м��
	public boolean requestSha() {
		System.out.println(this.getType() + this.getCharacter().getName()
				+ "��Ҫ��ɱ");
		for (int i = 0; i < this.handcard.size(); i++) {
			if (this.getHandcard().get(i).key.equals("ɱ") // ������keyֵΪ��ɱ��
					|| this.getCharacter().changeCard(
							this.getHandcard().get(i), "ɱ")) {// ����
				// �����б������Ч��
				System.out.println("�Ƿ��������ɱ��"
						+ this.getHandcard().get(i).toString()
						+ "��0��ʾȡ����1��ʾȷ����");
				Scanner sc = new Scanner(System.in);
				int r = sc.nextInt();
				if (r == 0) {
					continue;
				}
				if (r == 1) {
					// ȷ�ϳ��ƣ���Ҫ�����ƣ�������ʱ��
					this.setTmpCard(this.getHandcard().get(i));
					System.out.println(this.toString()+"��ɱ��"+this.getTmpCard().toString());
					Initial.throwlistCard.add(this.getHandcard().get(i));
					this.removeCard(i);
					// ���Ƽ��
					if (this.getHandcard().size() == 0) {
						this.getCharacter().noCard(this);
					}
					return true;
				}
			}
		}
		System.out.println(this.toString() + "����ɱ...");
		return false;
	}

	// ��Ӧ��и�ɻ�������Ϊ�������Ŀ��
	public boolean requestWuXie(Player top) {
		for (int i = 0; i < this.handcard.size(); i++) {
			if (this.getHandcard().get(i).key.equals("��и�ɻ�")) {// �˴���һ��or
																// �Ƿ��ܱ�����Ч��
				System.out.println("�Ƿ��������и�ɻ���"
						+ this.getHandcard().get(i).toString()
						+ "��0��ʾȡ����1��ʾȷ����");
				Scanner sc = new Scanner(System.in);
				int r = sc.nextInt();
				if (r == 0) {
					continue;
				}
				if (r == 1) {
					Initial.throwlistCard.add(this.getHandcard().get(i));
					this.removeCard(i);
					// ���Ƽ��
					if (this.getHandcard().size() == 0) {
						this.getCharacter().noCard(this);
					}
					if (top.requestWuXie(this) == true) {
						System.out.println(this.toString() + "����и�ɻ���"
								+ top.toString() + "����и�ɻ������");
						return false;
					}
					System.out.println(this.toString()+"�������и�ɻ���");
					return true;
				}
			}
		}
		return false;
	}

	// ����,ֻ���Լ������ṩ���ȷ���
	public boolean requestTao() {
		for (int i = 0; i < this.handcard.size(); i++) {
			if (this.getHandcard().get(i).key.equals("��")
					|| this.getCharacter().changeCard(
							this.getHandcard().get(i), "��")) {// �˴���һ��or
																// �Ƿ��ܱ�����Ч��
				// AI����
				if (this.getType().equals("(AI)")) {
					this.tao();
					Initial.throwlistCard.add(this.getHandcard().get(i));
					this.removeCard(i);
					// ���Ƽ��
					if (this.getHandcard().size() == 0) {
						this.getCharacter().noCard(this);
					}
					return true;
				}
				System.out.println("�Ƿ�����������ң�"
						+ this.getHandcard().get(i).toString()
						+ "��0��ʾȡ����1��ʾȷ����");
				// ��Ҵ���
				Scanner sc = new Scanner(System.in);
				int r = sc.nextInt();
				if (r == 0) {
					continue;
				}
				if (r == 1) {
					this.tao();
					Initial.throwlistCard.add(this.getHandcard().get(i));
					this.removeCard(i);
					// ���Ƽ��
					if (this.getHandcard().size() == 0) {
						this.getCharacter().noCard(this);
					}
					return true;
				}
			}
		}
		return false;
	}

	// �� index��ʾ�������
	public void tao() {
		System.out.println(this.toString() + "���ҳɹ�������1��Ѫ����");
		this.setHp(this.getHp() + 1);
		this.printHp();
	}

	// ����ɾ������
	public void removeCard(int index) {
		this.handcard.remove(index); // ɾ��Ҫ��������
		if (this.handcard.size() == 0) {
			this.getCharacter().noCard(this); // ����ɾ����Ϊ0����������Ʒ�������ĳЩ���ϻᴥ������
		}
	}

	// ��ӡ����
	public void printHandCard() {
		System.out.println(this.toString() + "��ǰ���ƣ�");
		for (int i = 0; i < this.getHandcard().size(); i++) {
			System.out.print((i + 1) + "--" + "["
					+ this.getHandcard().toArray()[i] + "]" + " \t ");
		}
		System.out.println();
	}

	// ��ӡѪ������
	public void printHp() {
		System.out.print(this.toString() + "��ǰѪ����");
		for (int i = 0; i < this.getHp(); i++) {
			System.out.print("��");
		}
		System.out.println(); // ��ӡ��Ѫ����ʾ
	}

	// ��ӡ��Ϣ����***************
	public void printInfo() {
		Initial.line();
		// ��ӡѪ��
		this.printHp();
		// ��ӡ����
		this.printHandCard();
		// ��ӡװ��
		for (int i = 0; i < 4; i++) {
			if (this.getEqiup(i) == null) {
				System.out.print("װ��" + (i + 1) + ":��" + "��");
			} else {
				System.out.print("װ��" + (i + 1) + ":"
						+ this.getEqiup(i).toString() + "��");
			}
		}
		System.out.println();
		// ��ӡ�ж���
		if (this.getMagicCard().size() == 0) {
			System.out.println("�ж��ƣ���");
		} else {
			System.out.print("�ж��ƣ�");
			for (int i = 0; i < this.getMagicCard().size(); i++) {
				System.out.print(this.getMagicCard(i).toString() + " ");
			}
			System.out.println();
		}
		Initial.line();
		System.out.println("");
	}

	// Ѫ�����ӷ������޲��������ü�+1
	public void addHp() {
		this.hp = this.hp + 1;
		this.checkHPNull();
	}

	// ��Ѫ��⣬��Ϊ���������Ϸ;��ÿ������˺�������£����ô˷���
	public void checkHPNull() {
		while (this.getHp() <= 0) {
			System.out.println("��Ҫ��" + (Math.abs(this.getHp()) + 1) + "����");
			if (this.requestTao() == false) { // �����ҳɹ�
				System.out.println(this.toString() + "���ң�");
				System.out.println(this.toString() + "����...");
				Initial.line();
				System.out.println("��Ϸ��������л���Ĳ��룡");
				System.exit(0);
			}
		}
	}

	// ѡ��������Ƶķ���������int��AI��д
	public int selectCard(Player top) {
		System.out.println("��ѡ��" + top.toString() + "������ţ�");
		top.printHandCard();
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		return r;
	}

	// Ҫ��ѡ��
	// ���ص������Ѿ�����-1���� ������ֱ����
	public int selectCardIndex(int size) {
		System.out.println("��ѡ������1��" + size + "֮������֣�0��ʾȡ������ȷ�ǲ���ȡ����");
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt() - 1;
		return r;

	}

	// �������ӷ���
	public void addhandCard(Card c) {
		this.handcard.add(c);
		this.reSetKongCheng();
	}
	// ���Ʋ���ʽ���ӷ���
	public void addhandCard(Card c,int index) {
		this.handcard.add(index,c);
		this.reSetKongCheng();
	}
	// ��ɫ�ж�����,������ʾ-->�жϻ�ɫ-->���ؽ����
	// �����ж��ƿ�����Ҫ����һ�ã����Դ˴��Ȳ����ƶ�ɾ�����ӳٵ�����ķ�����ִ��
	public boolean checkColor(Player p, String color, String color2, Player top) {
		// ���ƶ���ȡ����һ�ţ�������ʱ����
		Initial.tmpCheckCard = Initial.listCard.get(0);
		Initial.listCard.remove(0);// ���ƶ����Ƴ���
		// �˴���������Ч����˾��ܲ�� ��tmp����ȥ���� ��˫�����ﶼ����һ��
		Initial.tmpCheckCard = p.getCharacter().insteadCard(p,
				Initial.tmpCheckCard);
		Initial.tmpCheckCard = top.getCharacter().insteadCard(top,
				Initial.tmpCheckCard);
		System.out.println("�ж��ƣ�" + Initial.tmpCheckCard.toString());
		boolean succeed = Initial.tmpCheckCard.getColor().equals(color)
				|| Initial.tmpCheckCard.getColor().equals(color2);
		// ��δ����ж���
		p.getCharacter().doWithCheckCard(p, Initial.tmpCheckCard, succeed);
		return succeed;
	}

	// ���������ж�
	public boolean useBaGua(Player p, Player top) {
		System.out.println(p.toString() + "����������");
		return p.checkColor(p, "����", "����", top);
	}

	// ��дtoString����,����"(���/AI)XXX"
	public String toString() {
		return this.getType() + this.getCharacter().getName();
	}

	// ��������
	public void setHandcard(ArrayList<Card> handcard) {
		this.handcard.clear();
		this.handcard.addAll(handcard);
		//this.handcard.trimToSize();
	}
	//���ÿճ�״̬�����κλ�����Ƶ�����µ���
	public void reSetKongCheng(){
		if(this.getHandcard().size()>0){
			this.setKongCheng(false);
		}
	}
	
	// ***************************************�����ԵĻ�ȡ�����á�************************************************************
	public Character getCharacter() {
		return character;
	}

	public void setCharacter(Character character) {
		this.character = character;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public ArrayList<Card> getHandcard() {
		return handcard;
	}

	public Card getEqiup(int index) {
		return eqiup[index];
	}

	public void setEqiup(Card eqiup, int index) {
		this.eqiup[index] = eqiup;
	}

	public int getDisAtt() {
		return disAtt;
	}

	public void setDisAtt(int disAtt) {
		this.disAtt = disAtt;
	}

	public int getDisDef() {
		return disDef;
	}

	public void setDisDef(int disDef) {
		this.disDef = disDef;
	}

	public boolean isSha() {
		return isSha;
	}

	public void setSha(boolean isSha) {
		this.isSha = isSha;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isHasUsedSkill() {
		return hasUsedSkill;
	}

	public void setHasUsedSkill(boolean hasUsedSkill) {
		this.hasUsedSkill = hasUsedSkill;
	}

	public Card[] getEqiup() {
		return eqiup;
	}

	public void setEqiup(Card[] eqiup) {
		this.eqiup = eqiup;
	}

	public boolean isLuoYi() {
		return isLuoYi;
	}

	public void setLuoYi(boolean isLuoYi) {
		this.isLuoYi = isLuoYi;
	}

	public boolean isLeBuSiShu() {
		return isLeBuSiShu;
	}

	public void setLeBuSiShu(boolean isLeBuSiShu) {
		this.isLeBuSiShu = isLeBuSiShu;
	}

	public boolean isShanDian() {
		return isShanDian;
	}

	public void setShanDian(boolean isShanDian) {
		this.isShanDian = isShanDian;
	}

	public boolean isKongCheng() {
		return isKongCheng;
	}

	public void setKongCheng(boolean isKongCheng) {
		this.isKongCheng = isKongCheng;
	}

	public Card getTmpCard() {
		return tmpCard;
	}

	public void addMagicCard(Card c) {
		this.magicCard.add(c);
	}

	public void setTmpCard(Card tmpCard) {
		this.tmpCard = tmpCard;
	}

	public Card getMagicCard(int index) {
		return magicCard.get(index);
	}

	public void setMagicCard(Card magicCard, int index) {
		this.magicCard.set(index, magicCard);
	}

	public ArrayList<Card> getMagicCard() {
		return magicCard;
	}

	public void setMagicCard(ArrayList<Card> magicCard) {
		this.magicCard = magicCard;
	}

	public void removeMagicCard(int index) {
		this.magicCard.remove(index);
	}

	public void magicCardCls() {
		this.magicCard.clear();
	}

}
