import java.util.ArrayList;

//����ȨΪ�׵Ķ��⼯��
//��Ȩ
public class SunQuan extends Character {
	public SunQuan() {
		this.setName("��Ȩ");
		this.setmaxHp(4);
		this.setHp(this.getmaxHp());
	}
	//���ƺ⣩��д�������ܣ�������
	public void useSkill(Player p, Player top){
		//�ж��Ƿ��Ѿ��ù�������ֱ�ӷ���
		if(p.isHasUsedSkill()){
			System.out.println("�ü���ÿ�غ�ֻ����һ�Σ�");
			return;
		}
		System.out.println("����Ȩ��������˼...��");
		//������ʱ���ϣ��洢��������
		ArrayList<Card> tmpCard = new ArrayList<Card>();
		while(true){
			//��ѡ������
			int r = p.selectCard(p)-1;//������֮ǰû��-1����Ҫ-1����
			if(r == -1){//����0��ʾ������ƣ���ʼ����
				break;
			}
			//���������Ʒ�����ʱ����
			tmpCard.add(p.getHandcard().get(r));
			//����ɾ��
			p.removeCard(r);
		}
		//��ӡ��
		System.out.println(p.toString()+"�������ƣ�");
		for (int i = 0; i < tmpCard.size(); i++) {
			System.out.println(" "+tmpCard.get(i).toString());
		}
		//����Ӧ��������
		if(tmpCard.size()!= 0){
			p.getCharacter().AddCard(p, tmpCard.size(), null);
		}
		//����󣬹ر�
		p.setHasUsedSkill(true);
	}
}

// ���
class ZhouYu extends Character {
	public ZhouYu() {
		this.setName("���");
		this.setmaxHp(3);
		this.setHp(this.getmaxHp());
	}

	// ��д���Ʒ���
	public void AddCard(Player who, int num, Player towho) {
		System.out.println("����褣��ǺǺǹ�����......��");
		super.AddCard(who, num + 1, towho);
	}
	//���»�ɫ����д��������
	public void useSkill(Player p, Player top){
		//�ж��Ƿ��Ѿ��ù�������ֱ�ӷ���
		if(p.isHasUsedSkill()){
			System.out.println("�ü���ÿ�غ�ֻ����һ�Σ�");
			return;
		}
		System.out.println("����褣������ɣ���Ѫ�Ͱ�����Ԩ����");
		//�������飬���4����ɫ
		String[] color = {"����","����","÷��","����"};
		//Ŀ��ѡ��Ļ�ɫ
		String selectColor = color[top.selectCardIndex(4)];
		System.out.println(top.toString()+"�»�ɫΪ��"+selectColor);
		//Ŀ��ѡ����
		int index = top.selectCardIndex(p.getHandcard().size());
		Card selectCard = p.getHandcard().get(index);
		System.out.println(top.toString()+"�鵽���ƣ�"+selectCard.toString());
		p.removeCard(index);
		//���ݻ�ɫ���ж��Ƿ��Ѫ
		if(selectCard.getColor().equals(selectColor)==false){
			System.out.println(top.toString()+"�´�ɫ����Ѫ1��");
			top.setHp(top.getHp()-1);
			top.checkHPNull();
		}
		//����
		top.addhandCard(selectCard);
		System.out.println(top.toString()+"����ˣ�"+selectCard.toString());
		//����󣬹ر�
		p.setHasUsedSkill(true);
	}
}

// ����
class GanNing extends Character {
	public GanNing() {
		this.setName("����");
		this.setmaxHp(4);
		this.setHp(this.getmaxHp());
	}

	// ���Ʒ��������Ƶ�ͬ���Ӳ���
	public boolean changeCard(Card c, String key) {
		if (key.equals("���Ӳ���")) {
			if (c.getColor().equals("����") || c.getColor().equals("÷��")) {
				return true;
			}
		}
		return false;
	}

	// ��д��������
	// ��������д���淳��������������
	// ��Ϊ��ҿ��Դ������¼�ֻ�п���̨���룬�ٵ���Ҳֻ��ӲͷƤд
	public void useSkill(Player p, Player top) {
		//������ֱ���˳�
		if (p.getHandcard().size() == 0) {
			System.out.println("�����ƣ��޷���������");
			return;
		}
		// ����һ�����ϣ���ΪԤ�����ƣ���ӡ��ʾ�Թ�ѡ��
		ArrayList<Card> tmpCard = new ArrayList<Card>();
		// ���뼼�ܳ���ѭ����ֱ�������ƣ�����ѡ��ȡ��
		while (true) {
			//�������ƣ��������������Ʒ��뼯�ϣ�
			for (int i = 0; i < p.getHandcard().size(); i++) {
				if (p.getCharacter().changeCard(p.getHandcard().get(i), "���Ӳ���")) {
					// �����ϵ��Ʒ��뼯��
					tmpCard.add(p.getHandcard().get(i));
					// ����ɾ�� ����ȡ������ʱ���ϵ����ٷŻ�
					p.removeCard(i);
					i--;
				}
			}
			//���������Ϻ�û�з��������ģ��˳�
			if(tmpCard.size() == 0){
				System.out.println("û�п��õ��ƣ�");
				return;
			}
			// �������������ƴ�ӡ����
			System.out.print("���Ե������Ӳ���ʹ�õ��ƣ�");
			for (int i = 0; i < tmpCard.size(); i++) {
				// ��ӡ��ʾ
				System.out.print((i + 1) + "--["+tmpCard.get(i).toString() + "]");
			}
			System.out.println();
			// ����������� ������ֵ������-1����ֱ�ӿ��ã�
			int r = p.selectCardIndex(tmpCard.size());
			if(r== -1){//���������0
				System.out.println("��ҽ�������");
				//����ʱ���ϵ��ƷŻ�����
				p.getHandcard().addAll(tmpCard);
				return;
			}
			try {
				System.out.println("�������������̫���ˣ���");
				//ɾ����r����
				tmpCard.remove(r);
				//���ù��Ӳ��ŷ���
				new JinNang().guohechaiqiao(p, top);
			} catch (Exception e) {
				System.out.println("���������������룡");
			}
		}
	}
}

// ����
class LvMeng extends Character {
	public LvMeng() {
		this.setName("����");
		this.setmaxHp(4);
		this.setHp(this.getmaxHp());
	}

	// ��д���Ʒ���
	public void ThrowCard(Player who) {
		if (who.isSha() == false) {
			System.out.println("�����ɣ��˼����������ƣ�");
			return;
		} else {
			super.ThrowCard(who);
		}
	}
}

// �Ƹ�
class HuangGai extends Character {
	public HuangGai() {
		this.setName("�Ƹ�");
		this.setmaxHp(4);
		this.setHp(this.getmaxHp());
	}

	// �����⣩��д�������ܷ�������1��Ѫ����2����
	public void useSkill(Player p, Player top) {
		System.out.println("���Ƹǣ������Ұɣ���誣���");
		// ��Ѫ
		p.setHp(p.getHp() - 1);
		p.printInfo();
		// ���Ѫ��
		p.checkHPNull();
		// ����2��
		p.getCharacter().AddCard(p, 2, null);
		// �ü��ܿ������ͷţ��ʲ��������������ܿ���
	}
}

// ½ѷ
class LuXun extends Character {
	public LuXun() {
		this.setName("½ѷ");
		this.setmaxHp(3);
		this.setHp(this.getmaxHp());
	}

	// ����Ӫ����д���Ʒ���
	public boolean noCard(Player p) {
		System.out.println("��½ѷ���Ʋ������ܵģ���û���������ܵģ���");
		this.AddCard(p, 1, null);
		return false;
	}
}

// ������
class SunShangXiang extends Character {
	public SunShangXiang() {
		this.setName("������");
		this.setmaxHp(3);
		this.setHp(this.getmaxHp());
	}
	//���ɼ�����дװ��ж���¼�
    public void eqiupUnload(Player p,Player top){
    	System.out.println("�������㣺�ߣ���");
    	//����2��
    	p.getCharacter().AddCard(p, 2, null);
    }
}

// ����
class DaQiao extends Character {
	public DaQiao() {
		this.setName("����");
		this.setmaxHp(3);
		this.setHp(this.getmaxHp());
	}
	// ���Ʒ����������ͬ�ֲ�˼��
	public boolean changeCard(Card c, String key) {
		if (key.equals("�ֲ�˼��")) {
			if (c.getColor().equals("����") ) {
				return true;
			}
		}
		return false;
	}
	//����ɫ�� �ֲ�˼��
	public void useSkill(Player p, Player top) {
		//������ֱ���˳�
		if (p.getHandcard().size() == 0) {
			System.out.println("�����ƣ��޷���������");
			return;
		}
		// ����һ�����ϣ���ΪԤ�����ƣ���ӡ��ʾ�Թ�ѡ��
		ArrayList<Card> tmpCard = new ArrayList<Card>();
		// ���뼼�ܳ���ѭ����ֱ�������ƣ�����ѡ��ȡ��
		while (true) {
			//�������ƣ��������������Ʒ��뼯�ϣ�
			for (int i = 0; i < p.getHandcard().size(); i++) {
				if (p.getCharacter().changeCard(p.getHandcard().get(i), "�ֲ�˼��")) {
					// �����ϵ��Ʒ��뼯��
					tmpCard.add(p.getHandcard().get(i));
					// ����ɾ�� ����ȡ������ʱ���ϵ����ٷŻ�
					p.removeCard(i);
					i--;
				}
			}
			//���������Ϻ�û�з��������ģ��˳�
			if(tmpCard.size() == 0){
				System.out.println("û�п��õ��ƣ�");
				return;
			}
			// �������������ƴ�ӡ����
			System.out.print("���Ե����ֲ�˼��ʹ�õ��ƣ�");
			for (int i = 0; i < tmpCard.size(); i++) {
				// ��ӡ��ʾ
				System.out.print((i + 1) + "--["+tmpCard.get(i).toString() + "]"+"\t");
			}
			System.out.println();
			// ����������� ������ֵ������-1����ֱ�ӿ��ã�
			int r = p.selectCardIndex(tmpCard.size());
			if(r== -1){//���������0
				System.out.println("��ҽ�������");
				//����ʱ���ϵ��ƷŻ�����
				p.getHandcard().addAll(tmpCard);
				return;
			}
			try {
				//�����ֲ�˼��
				System.out.println("�����ǣ���Ϣһ�£���");
				if(new JinNang(5).useJinNang(p, top, tmpCard.get(r))){
					//ɾ����r����
					tmpCard.remove(r);
				}
				
			} catch (Exception e) {
				System.out.println("���������������룡");
			}
		}
	}
}

// ����3��Ⱥ��
// ����
class LvBu extends Character {
	public LvBu() {
		this.setName("����");
		this.setmaxHp(4);
		this.setHp(this.getmaxHp());
	}

	// ��дɱ�Ķ�����������Ҫ���һ����
	public boolean shaWithOtherCheck(Player p, Player top) {
		System.out.println("������˭�ܵ��ң�����");
		return top.requestshan(p,top);
	}
}

// ����
class DiaoChan extends Character {
	public DiaoChan() {
		this.setName("����");
		this.setmaxHp(3);
		this.setHp(this.getmaxHp());
	}

	// ��д�غϽ�������������1��
	public void End(Player who, Player towho) {
		System.out.println("��������ʧ����...��");
		who.getCharacter().AddCard(who, 1, null);
		// ԭ�������н�������Ȩ�Ĵ��룬��Ҫ����
		super.End(who, towho);
	}
}

// ��٢
class HuaTuo extends Character {
	public HuaTuo() {
		this.setName("��٢");
		this.setmaxHp(3);
		this.setHp(this.getmaxHp());
	}

	// �����ң���д�������ܷ���
	public void useSkill(Player p, Player top) {
		// ���û�����ƣ�����Ѫ���������޷���������
		if (p.getHandcard().size() == 0
				|| p.getHp() == p.getCharacter().getmaxHp()) {
			System.out.println("������orѪ���������޷��������ܣ�");
			return;
		} else {
			int r = p.selectCard(p) - 1;// ע��-1����
			Card tmp = p.getHandcard().get(r);
			System.out.println("����٢��Խ��ԽҪ��������");
			System.out.println(p.toString() + "�����������ң�" + tmp.toString());
			p.removeCard(r);
			Initial.throwlistCard.add(tmp);
			p.tao();
		}
	}
	//�����ȣ���д���Ʒ���
	public boolean changeCard(Card c,String key){
		//�����Ҫ���ǳ���
    	if(key.equals("��")){
    		//���Ҽ�����Ϊ��ɫ
    		if(c.getColor().equals("����") || c.getColor().equals("����")){
    			System.out.println("����٢������һ����ʤ���߼���������");
    			System.out.println("��٢���["+c.toString()+"]����...");
    			return true;
    		}
    	}
    	return false;
	}
}