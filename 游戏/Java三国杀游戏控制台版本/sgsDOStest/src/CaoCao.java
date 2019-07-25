import java.util.Random;
import java.util.Scanner;

//�Բܲ�Ϊ�׵Ĳ�κ����

//�ܲ�
public class CaoCao extends Character {
	public CaoCao() {
		this.setName("�ܲ�");
		this.setmaxHp(4);
		this.setHp(this.getmaxHp());
	}

	// ��д���˴����¼�����ȡ�˺��ƣ���ȡ�����ƶ�������һ�ţ�
	public void afterHurt(Player p, Player pSha) {
		System.out.println("���ܲ٣������Ҹ������ˣ��ݽ������˸��ң���");
		System.out.println(p.toString() + "����ˣ�" + pSha.getTmpCard());
		// ����
		p.addhandCard(pSha.getTmpCard());
		// �ƶ������һ���Ƴ�
		Initial.throwlistCard.remove(Initial.throwlistCard.size() - 1);
	}
}

// ����
class XuChu extends Character {
	public XuChu() {
		this.setName("����");
		this.setmaxHp(4);
		this.setHp(this.getmaxHp());
	}

	// ��д�غϿ�ʼ��ѡ���Ƿ�����
	public void Start(Player who, Player towho) {
		int r = 0;
		// ��AI�����
		if (who.getType().equals("(AI)")) {
			r = new Random().nextInt(2);
		} else {
			// ���ѡ��
			System.out.println("�Ƿ񷢶����£�1Ϊȷ����0Ϊȡ��");
			Scanner sc = new Scanner(System.in);
			r = sc.nextInt();
		}
		//�ж�r
		if (r == 1) {
			who.setLuoYi(true);
			System.out.println("�����ң��ǣ���");
			System.out.println(who.toString() + "��������Ч��");
		} else {
			who.setLuoYi(false);
		}
	}

	// ��д����
	public void AddCard(Player who, int num, Player towho) {
		if (who.isLuoYi()) {
			super.AddCard(who, 1, towho);
		} else {
			super.AddCard(who, 2, towho);
		}
	}

	// �����˺����� ������д
	public int hurtAdd(Player p, Player pHurt) {
		// ���ж����Ƿ񷢶�����Ч����
		if (p.isLuoYi()) {
			System.out.println("��������Ч���������˺��ӳɣ�");
			return 1;
		} else {
			return 0;
		}
	}
}

// ˾��ܲ
class SiMaYi extends Character {
	public SiMaYi() {
		this.setName("˾��ܲ");
		this.setmaxHp(3);
		this.setHp(this.getmaxHp());
	}

	// ��д���˺󴥷��¼�
	public void afterHurt(Player p, Player pSha) {
		System.out.println("��˾��ܲ���´�ע��㣡��");
		int index = p.selectCard(pSha) - 1;// ע��-1������
		p.addhandCard(pSha.getHandcard().get(index));
		System.out.println(p.toString() + "��" + pSha.toString() + "���л���ˣ�"
				+ pSha.getHandcard().get(index).toString());
		pSha.removeCard(index);
	}

	// (����)�����滻�ж���,˾��ܲ��д
	public Card insteadCard(Player p, Card c) {
		// ���û�����ƣ����ø��෽��
		if (p.getHandcard().size() == 0) {
			return c;
		}
		System.out.println("ԭʼ�ж���Ϊ��" + c.toString());
		System.out.println("�Ƿ��滻�ж��ƣ�����������ţ�0Ϊȡ��");

		// ���Լ�������ѡһ��
		int index = p.selectCard(p);
		if (index == 0) {
			System.out.println("������...");
			return c;
		} else {
			Initial.throwlistCard.add(c);
			Card tmp = p.getHandcard().get(index - 1);
			p.removeCard(index - 1);
			System.out.println("��˾��ܲ��������������....��");
			System.out.println("�ж��Ʊ��滻��");
			return tmp;
		}

	}
}

// �ĺ
class XiaHouDun extends Character {
	public XiaHouDun() {
		this.setName("�ĺ");
		this.setmaxHp(4);
		this.setHp(this.getmaxHp());
	}

	// ��д���˺󴥷��¼�
	public void afterHurt(Player p, Player pSha) {
		System.out.println("���ĺ���󱲣��������ң���");
		// ���û�ɫ�ж�����
		if (p.checkColor(p, "����", null, pSha)) {
			System.out.println(pSha.toString() + "��Ѫ1��");
			pSha.setHp(pSha.getHp() - 1);
			pSha.checkHPNull();
		} else {
			System.out.println("������Ч.");
		}
	}
}

// ����
class GuoJia extends Character {
	public GuoJia() {
		this.setName("����");
		this.setmaxHp(3);
		this.setHp(this.getmaxHp());
	}

	// ���żƣ���д���˴����¼�����2����
	public void afterHurt(Player p, Player pSha) {
		System.out.println("�����Σ���������...��");
		System.out.println("�żƴ��������λ��2����");
		p.getCharacter().AddCard(p, 2, pSha);
	}

	// ����ʣ���ȡ�ж��ƣ���д�����ж��Ƶķ���
	public void doWithCheckCard(Player p, Card c, boolean succeed) {
		System.out.println("�����Σ�Ҳ��...��");
		System.out.println("���λ�����ж��ƣ�" + c.toString());
		p.addhandCard(c);
	}
}

// ����
class ZhangLiao extends Character {
	public ZhangLiao() {
		this.setName("����");
		this.setmaxHp(4);
		this.setHp(this.getmaxHp());
	}

	// ��д���Ʒ���
	public void AddCard(Player p, int num, Player top) {
		// �������������ƣ�����ø��෽������������
		if (top.getHandcard().size() == 0) {
			super.AddCard(p, 2, top);
			return;
		}
		System.out.println("�����ɣ�û�뵽�ɣ���");
		int index = p.selectCard(top) - 1;// ע��-1������
		p.addhandCard(top.getHandcard().get(index));
		System.out.println(p.toString() + "��" + top.toString() + "����͵���ˣ�"
				+ top.getHandcard().get(index).toString());
		top.removeCard(index);
	}
}

// �缧
class ZhenJi extends Character {
	public ZhenJi() {
		this.setName("�缧");
		this.setmaxHp(3);
		this.setHp(this.getmaxHp());
	}

	// �����������ж��������缧��д
	public void checkOnAddCard(Player p, Player top) {
		// ��ӡ������Ч��
		System.out.println("���缧���·���������֮���£�ƮƮ��������֮��ѩ...��");
		// ѭ����ֻҪ�ж��ɹ���һֱ�ж�
		while (true) {
			if (p.getCharacter().checkColor(p, "����", "÷��", top)) {
				p.addhandCard(Initial.tmpCheckCard);
				System.out.println(p.toString() + "����ˣ�"
						+ Initial.tmpCheckCard.toString());
			} else {
				System.out.println("�ж�ʧЧ��������ֹ");
				break;
			}
		}
	}

	// ���Ʒ���
	public boolean changeCard(Card c, String key) {
		// �����Ҫ���ǳ���
		if (key.equals("��")) {
			// ���Ҽ�����Ϊ��ɫ
			if (c.getColor().equals("����") || c.getColor().equals("÷��")) {
				System.out.println("���缧���貨΢������������...��");
				return true;
			}
		}
		return false;
	}
}