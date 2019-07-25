import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

//������Ϊ�׵����佫��ļ���
//����
public class LiuBei extends Character {
	public LiuBei() {
		this.setName("����");
		this.setmaxHp(4);
		this.setHp(this.getmaxHp());
	}

	// ���ʵ£���д��������
	public void useSkill(Player p, Player top) {
		// ����һ������������ͳ�Ƹ�������
		// �˴����ܶ���ȫ�ֱ����ȽϺã���ʱ����
		int num = 0;
		// ѭ����ֱ�������ƻ���ȡ��
		while (true) {
			// ����Ҫ���쳣����
			// �����ƴ��ڣ���ִ�и���
			if (p.getHandcard().size() == 0) {
				System.out.println("�����ƣ����ܷ������＼�ܣ�");
				return;
			} else {
				int r = p.selectCard(p);
				if (r == 0) {
					// ������0�����ж��Ƿ񹻼�Ѫ�����������˳�����
					if (p.getHp() < p.getCharacter().getmaxHp() && num >= 2) {
						System.out.println(p.toString() + "����1��Ѫ��");
						p.addHp();
					}
					System.out.println(p.toString() + "��������...");
					return;
				}
				// ȡ��ѡ�е��ƣ�������ʱ��
				Card tmp = p.getHandcard().get(r - 1);// ע��-1����
				// ��ӡЧ��
				System.out.println("��������Ω��Ω�£��ʷ����ˣ���");
				System.out.println(p.toString() + "��" + top.toString() + "���ƣ�"
						+ tmp.toString());
				// ��ѡ�е��ƣ���������ɾ��
				p.removeCard(r - 1);// ע��-1����
				// ����Է�������
				top.addhandCard(tmp);
				top.reSetKongCheng();
				// ������+1
				num++;
			}

		}
	}
}

// ����
class GuanYu extends Character {
	public GuanYu() {
		this.setName("����");
		this.setmaxHp(4);
		this.setHp(this.getmaxHp());
	}

	// (��ʥ)��д���ƣ����Ҫ���ɱ����������Ϊ�죬������
	public boolean changeCard(Card c, String key) {
		if (key.equals("ɱ")) {
			if (c.getColor().equals("����") || c.getColor().equals("����")) {
				return true;
			}
		}
		return false;
	}

	// ���Ƴ�ɱ�������ƹ���
	public void useSkill(Player p, Player top) {
		// ������ֱ���˳�
		if (p.getHandcard().size() == 0) {
			System.out.println("�����ƣ��޷���������");
			return;
		}
		if (p.getCharacter().getName().equals("����")) {
			System.out.println("�����𣺹۶��˲�����ף���");
		}
		// ����һ�����ϣ���ΪԤ�����ƣ���ӡ��ʾ�Թ�ѡ��
		ArrayList<Card> tmpCard = new ArrayList<Card>();
		// ���뼼�ܳ���ѭ����ֱ�������ƣ�����ѡ��ȡ��
		while (true) {
			// �������ƣ��������������Ʒ��뼯�ϣ�
			for (int i = 0; i < p.getHandcard().size(); i++) {
				if (p.getCharacter().changeCard(p.getHandcard().get(i), "ɱ")) {
					// �����ϵ��Ʒ��뼯��
					tmpCard.add(p.getHandcard().get(i));
					// ����ɾ�� ����ȡ������ʱ���ϵ����ٷŻ�
					p.removeCard(i);
					i--;
				}
			}
			// ���������Ϻ�û�з��������ģ��˳�
			if (tmpCard.size() == 0) {
				System.out.println("û�п��������õ��ƣ��������ܡ�");
				return;
			}
			// �������������ƴ�ӡ����
			System.out.print("���Ե���ɱʹ�õ��ƣ�");
			for (int i = 0; i < tmpCard.size(); i++) {
				// ��ӡ��ʾ
				System.out.print((i + 1) + "--[" + tmpCard.get(i).toString()
						+ "]");
			}
			System.out.println();
			// ����������� ������ֵ������-1����ֱ�ӿ��ã�
			int r = p.selectCardIndex(tmpCard.size());
			if (r == -1) {// ���������0
				System.out.println("��ҽ�������");
				// ����ʱ���ϵ��ƷŻ�����
				p.getHandcard().addAll(tmpCard);
				return;
			}
			try {
				// ����ɱ����
				if (p.sha(p, top)) {
					// ɾ����r����
					tmpCard.remove(r);
					p.getCharacter().noCard(p);
				}
			} catch (Exception e) {
				System.out.println("���������������룡");
			}
		}
	}
}

// ����
class ZhaoYun extends Character {
	public ZhaoYun() {
		this.setName("����");
		this.setmaxHp(4);
		this.setHp(this.getmaxHp());
	}

	// ���Ʒ���
	public boolean changeCard(Card c, String key) {
		// �����Ҫ��ɱ������
		if (key.equals("ɱ") || key.equals("��")) {
			// �����������ɱ������
			if (c.key.equals("ɱ") || c.key.equals("��")) {
				return true;
			}
		}
		return false;
	}

	// ��������
	// ͵�� ���ù���� �����Ǳ��Ƴ�ɱ��
	public void useSkill(Player p, Player top) {
		System.out.println("�����ƣ��ܽ����ˣ���������������");
		new GuanYu().useSkill(p, top);
	}
}

// �ŷɣ���дɱ����************
class ZhangFei extends Character {
	public ZhangFei() { // ���췽��
		this.setName("�ŷ�");
		this.setmaxHp(4);
		this.setHp(this.getmaxHp());
	}

	// �Ƿ����ɱ����ɱ֮����ã��ŷ���д�˷���
	public boolean haveYouSha() {
		System.out.println("���ŷɣ������ŷ��ڴˣ�����");
		return false;
	}
}

// ��
class MaChao extends Character {
	public MaChao() {
		this.setName("��");
		this.setmaxHp(4);
		this.setHp(this.getmaxHp());
		this.setDisAtt(2); // ��������+1;
	}

	// ǿɱ�¼�������д
	// ����boolean���Ƿ�����������requestShan�����
	public boolean ignoreShan(Player p, Player top) {
		// ����ɫ�ж�Ϊ���ģ������棻�ϲ��ɱ����ֱ��ִ�п�Ѫ
		System.out.println("������ȫ��ͻ��������");
		if (p.checkColor(p, "����", "����", top)) {
			System.out.println("��ɱ�޷����ܣ���");
			return true;
		} else {
			System.out.println("������Ч�����Գ���");
			return false;
		}
	}
}

// ���
class ZhuGe extends Character {
	public ZhuGe() {
		this.setName("�����");
		this.setmaxHp(3);
		this.setHp(this.getmaxHp());
	}

	// ���ճǣ���д���Ʒ��������κ�ɾ�����Ʒ��������
	public boolean noCard(Player p) {
		System.out.println("�ճǼ��ܴ�����");
		p.setKongCheng(true);
		return false;
	}

	// �����ǣ���д�غϿ�ʼ
	public void Start(Player who, Player towho) {
		super.Start(who, towho);
		System.out.println("����������۽�ҹ����֪���´��ơ���");
		if (who.getType().equals("(AI)")) {
			// AI�Ĺ��Ƿ���,�����
			Random r = new Random();
			this.select(r.nextInt(5), who, towho);
		} else {
			System.out.println("�ƶѵ�1�ţ�" + Initial.listCard.get(0));
			System.out.println("�ƶѵ�2�ţ�" + Initial.listCard.get(1));
			System.out.println("��ѡ�������ʽ��");
			System.out.println("����0��ά�ֲ��䣻");
			System.out.println("����1������2���Ƶ�˳��");
			System.out.println("����2������1�ŷŵ��ƶ����");
			System.out.println("����3������2�ŷŵ��ƶ����");
			System.out.println("����4��2���ƶ��ŵ��ƶ����");
			// �������
			Scanner sc = new Scanner(System.in);
			try {
				int r = sc.nextInt();
				this.select(r, who, towho);
			} catch (Exception e) {
				System.out.println("���Ϸ������룡");
				Start(who, towho);
			}
		}
	}

	// ѡ�����Ĳ�������
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
			System.out.println(who.toString() + "��ɲ�����");
		} else {
			System.out.println("������������ѡ��");
			Start(who, towho);
		}
	}

}

// ����Ӣ
class HuangYueYing extends Character {
	public HuangYueYing() {
		this.setName("����Ӣ");
		this.setmaxHp(3);
		this.setHp(this.getmaxHp());
	}

	// ��дʹ�ý��ң���һ����
	// �˴���Щȱ�ݣ�����ֱ�����ƣ�����Ҫ��ɾ�����ҷ���������ƣ�������������ϵ�ȱ�ݣ�����
	public void useJinNang(Player p) {
		System.out.println("������Ӣ���ߣ���");
		p.getCharacter().AddCard(p, 1, null);
	}
}