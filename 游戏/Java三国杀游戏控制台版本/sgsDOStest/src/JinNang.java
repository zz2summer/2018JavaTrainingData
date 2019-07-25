import java.util.ArrayList;

//�����࣬�洢�������ҵķ�����
//����һ��������index��ʵ��������index,������Ӧ�Ľ��ҷ���
public class JinNang {
	private int index;

	public JinNang() {
	}

	public JinNang(int index) {
		this.index = index;
	}

	public boolean useJinNang(Player p, Player top,Card card) {
		switch (this.index) { // index �Ǵ���һ�㷽�������Ĳ�����ֵ��Ϊ4-15
		case 4: //����
			this.juedou(p, top);
			break;
		case 5://�ֲ�˼��
			if(top.isLeBuSiShu()==true){
				System.out.println("Ŀ���Ѿ������ֲ�˼��");
				return false;
			}
			if(top.getCharacter().getName().equals("½ѷ")){
				System.out.println("���ܶ�½ѷʹ���ֲ�˼��");
				return false;
			}else{
				this.lebusishu(p, top,card);
				break;
			}
		case 6: //�赶ɱ��
			if(top.getEqiup(0)==null){
				System.out.println("Ŀ��û�����������ܽ赶��");
				return false;
			}else{
				this.jiedaosharen(p, top);
				break;
			}
		case 7://��и�ɻ�
			this.wuxxiekeji(p, top);
			break;
		case 8://��԰����
			this.taoyuanjieyi(p, top);
			break;
		case 9: // ����뷢
			this.wanjianqifa(p, top);
			break;
		case 10://����
			if(top.isShanDian()==true){
				System.out.println("Ŀ���Ѿ���������");
				return false;
			}
			this.shandian(p, top,card);
			break;
		case 11: // ��������
			this.nanmanruqin(p, top);
			break;
		case 12: // ��������
			this.wuzhongshengyou(p, top);
			break;
		case 13: //��ȷ��
			this.wugufengdeng(p, top);
			break;
		case 14: // ���Ӳ���
			//Ŀ��û������
			if(top.getHandcard().size()==0){
				if(p.getType().equals("(���)")){
					System.out.println("Ŀ�������ƣ�����ʹ�ã�");
				}
				return false;
			}
			this.guohechaiqiao(p, top);
			break;
		case 15: // ˳��ǣ��
			if(top.getHandcard().size()==0){
				if(p.getType().equals("(���)")){
					System.out.println("Ŀ�������ƣ�����ʹ�ã�");
				}
				return false;
			}
			if(top.getCharacter().getName().equals("½ѷ")){
				System.out.println("���ܶ�½ѷʹ��˳��ǣ��");
				return false;
			}else{
				this.shunshouqianyang(p, top);
				break;
			}
		}
		return true;
	}

	// ---------------------------------------------------------------------------------------------------------
	// �������Ҽ��ܵľ��巽��
	// ---------------------------------------------------------------------------------------------------------
	// ����
	public void juedou(Player p, Player top) {
		System.out.println("");
		//ѯ�ʶ����Ƿ����и
		if(top.requestWuXie(p)==true){
			System.out.println("�����������");
			return;
		}
		Player pTurn = top;//������������ȳ�ɱ
		boolean b = false;
		while(pTurn.requestSha()==true){
			b=!b;
			pTurn = b?p:top;
		}
		System.out.println(pTurn.toString()+"��Ѫ1��...");
		pTurn.setHp(pTurn.getHp()-1);
		pTurn.printHp();
		pTurn.checkHPNull();
		//��������
		Player tmpPlayer = new Player();
		if(pTurn == p){
			tmpPlayer = top;
		}else{
			tmpPlayer = p;
		}
		pTurn.getCharacter().afterHurt(pTurn, tmpPlayer);
	}

	// �ֲ�˼��
	public void lebusishu(Player p, Player top,Card c) {
		top.addMagicCard(c);
		System.out.println(p.toString()+"��"+top.toString()+"ʩ�ţ�"+c.toString());
		top.setLeBuSiShu(true);
	}

	// �赶ɱ��
	public void jiedaosharen(Player p, Player top) {
		//ѯ�ʶ����Ƿ����и
		if(top.requestWuXie(p)==true){
			System.out.println("�赶ɱ�˱������");
			return;
		}
		if(top.requestSha()){
			top.sha(top	, p);
		}else{
			p.addhandCard(top.getEqiup(0));
			System.out.println(p.toString()+"����ˣ�"+top.getEqiup(0).toString());
			top.setEqiup(null, 0);
		}
	}

	// ��и�ɻ�
	public void wuxxiekeji(Player p, Player top) {

	}

	// ��԰����
	public void taoyuanjieyi(Player p, Player top) {
		//ѯ�ʶ����Ƿ����и
		if(top.requestWuXie(p)==true){
			System.out.println("��԰���屻�����");
			return;
		}
		System.out.println("��԰���壬�����˼�Ѫ...");
		if (p.getHp() < p.getCharacter().getmaxHp()) {
			p.addHp();
			p.printHp();
		}
		if (top.getHp() < top.getCharacter().getmaxHp()) {
			top.addHp();
			top.printHp();
		}
	}

	// ����뷢
	public void wanjianqifa(Player p, Player top) {
		System.out.println(top.getType() + top.getCharacter().getName()
				+ "��Ҫ����...");
		//ѯ�ʶ����Ƿ����и
		if(top.requestWuXie(p)==true){
			System.out.println("����뷢�������");
			return;
		}
		if (top.requestshan(p,top) == false) {
			top.setHp(top.getHp() - 1);
			System.out.println(top.getType() + top.getCharacter().getName()
					+ "��Ѫ...");
			top.printHp();
			top.checkHPNull();
			top.getCharacter().afterHurt(top, p);
		}
	}

	// ����
	public void shandian(Player p, Player top,Card c) {
		p.addMagicCard(c);
		System.out.println(p.toString()+"ʩ�ţ�"+c.toString());
		p.setShanDian(true);
	}

	// ��������
	public void nanmanruqin(Player p, Player top) {
		//ѯ�ʶ����Ƿ����и
		if(top.requestWuXie(p)==true){
			System.out.println("�������ֱ������");
			return;
		}
		if (top.requestSha() == false) {
			top.setHp(top.getHp() - 1);
			System.out.println(top.getType() + top.getCharacter().getName()
					+ "��Ѫ...");
			top.printHp();
			top.checkHPNull();
			top.getCharacter().afterHurt(top, p);
		}
	}

	// ��������
	public void wuzhongshengyou(Player p, Player top) {
		//ѯ�ʶ����Ƿ����и
		if(top.requestWuXie(p)==true){
			System.out.println("�������б������");
			return;
		}
		p.getCharacter().AddCard(p, 2, top);
		System.out.println(p.getType() + p.getCharacter().getName() + "���2����");
	}

	// ��ȷ��
	public void wugufengdeng(Player p, Player top) {
		//ѯ�ʶ����Ƿ����и
		if(top.requestWuXie(p)==true){
			System.out.println("��ȷ�Ǳ������");
			return;
		}
		//����2��
		//ѡ�񣬷���
		System.out.println("��ȷ�ǣ�ÿ�˿ɻ��һ����");
		ArrayList<Card> tmp = new ArrayList<Card>();
		for (int i = 0; i <2; i++) {
			tmp.add(Initial.listCard.get(i));
			Initial.listCard.remove(i);
			System.out.println("��"+(i+1)+"���ƣ�"+tmp.get(i).toString());
		}
		int r =p.selectCardIndex(2);
		if(r!=0&&r!=1){
			System.out.println("��������");
			wugufengdeng(p, top);
			return;
		}
		p.addhandCard(tmp.get(r));
		System.out.println(p.toString()+"�����"+tmp.get(r));
		tmp.remove(r);
		top.addhandCard(tmp.get(0));
		System.out.println(top.toString()+"�����"+tmp.get(0));
	}

	// ���Ӳ���
	public void guohechaiqiao(Player p, Player top) {
		//ѯ�ʶ����Ƿ����и
		if(top.requestWuXie(p)==true){
			System.out.println("���Ӳ��ű������");
			return;
		}
		int index = p.selectCard(top)-1 ;
		System.out.println(top.toString()+"�ģ�["+top.getHandcard().get(index).toString() + "]������...");
		top.removeCard(index);
		//���Ƽ��
		if(top.getHandcard().size() == 0){
			top.getCharacter().noCard(top);
		}
	}

	// ˳��ǣ��
	public void shunshouqianyang(Player p, Player top) {
		//ѯ�ʶ����Ƿ����и
		if(top.requestWuXie(p)==true){
			System.out.println("˳��ǣ�򱻷����");
			return;
		}
		int index = p.selectCard(top) - 1;// ע��-1������
		p.addhandCard(top.getHandcard().get(index));
		System.out.println(p.getType() + p.getCharacter().getName() + "��"
				+ top.getType() + top.getCharacter().getName() + "���л���ˣ�"
				+ top.getHandcard().get(index).toString());
		top.removeCard(index);
		//���Ƽ��
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
