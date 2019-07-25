import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

//����佫���࣬�̳����Player�࣬ͬʱ����Player������ԣ���������ƿ����в�����
//ֻҪ�������������⣬���ȼ�������Ľṹ

public class Character extends Player {
	private String name;// ����
	private int maxhp; // ����Ѫ�������ޣ���3��4
	private boolean skipUseCard; // �Ƿ���������

	// *****************************��6���׶Σ���ͬ�����ཫ���ݼ���ԭ��ֱ���д���е�ĳЩ��****************************************
	// �غϿ�ʼ�׶�
	public void Start(Player who, Player towho) {
		System.out.println("   ****** �ֵ�" + who.toString() + "���� ******");
		Initial.line();
		System.out.println("�غϿ�ʼ�׶�..." + "\n");
		// �����ɱ
		who.setSha(false);
		// ����ʹ����������
		who.setHasUsedSkill(false);
		// �������Ч��
		who.setLuoYi(false);
	}

	// �ж��׶�
	public void Check(Player who, Player towho) {
		System.out.println("�ж��׶�...");
		System.out.println();
		// �����ж�
		who.getCharacter().checkOnAddCard(who, towho);
		// ��ʱ�����ж�
		for (int i = 0; i < who.getMagicCard().size(); i++) {
			// ����
			if (who.getMagicCard(i).key.equals("����")) {
				System.out.println("�ж����磺");
				// ���ƶ��з�����һ�ţ�������ʱ����
				Initial.tmpCheckCard = Initial.listCard.get(0);
				Initial.listCard.remove(0);// ���ƶ����Ƴ���
				// �˴���������Ч����˾��ܲ�� ��tmp����ȥ���� ��˫�����ﶼ����һ��
				Initial.tmpCheckCard = who.getCharacter().insteadCard(who,
						Initial.tmpCheckCard);
				Initial.tmpCheckCard = towho.getCharacter().insteadCard(towho,
						Initial.tmpCheckCard);
				System.out.println("������ж��ƣ�" + Initial.tmpCheckCard.toString());
				// ��ɫ+���ֵ��ж�
				boolean succeed;
				try {
					int numOfCard = Integer.parseInt(Initial.tmpCheckCard
							.getNum());
					succeed = Initial.tmpCheckCard.getColor().equals("����")
							&& numOfCard >= 2 && numOfCard <= 9;
					if (succeed == true) {
						System.out.println("�ж���Ч��" + who.toString() + "��3��Ѫ��");
						who.setHp(who.getHp() - 3);
						who.checkHPNull();
						who.printHp();
					} else {
						System.out.println("�ж���Ч�������ƽ���" + towho.toString());
						towho.addMagicCard(who.getMagicCard(i));
					}
					// ����֮����д��catch������Ϊ�������JQKA��ת������ʱ�����쳣
					// ���һ�������쳣����ζ��JQKA���֣����������ж���2-9��
				} catch (Exception e) {
					System.out.println("�ж���Ч�������ƽ���" + towho.toString());
					towho.addMagicCard(who.getMagicCard(i));
					towho.setShanDian(true);
				}
				// ��δ����ж���
				who.getCharacter().doWithCheckCard(who, Initial.tmpCheckCard,
						true);

			}
			// �ֲ�˼��
			if (who.getMagicCard(i).key.equals("�ֲ�˼��")
					|| who.isLeBuSiShu() == true) {
				System.out.println("�ж��ֲ�˼��");
				if (who.requestWuXie(towho) == true) {
					System.out.println("�ֲ�˼�񱻷����");
					this.setSkipUseCard(false);
					continue;
				} else if (who.checkColor(who, "����", null, towho) == true) {
					System.out.println("�ֲ�˼����Ч�����Գ��ƣ�");
					this.setSkipUseCard(false);
				} else {
					this.setSkipUseCard(true);
					System.out.println("�ֲ�˼����Ч���������ƣ�");
				}
			}
		}
		// ���
		who.setLeBuSiShu(false);
		who.setShanDian(false);
		who.magicCardCls();
	}

	// ���ƽ׶�
	public void AddCard(Player who, int num, Player towho) {
		// System.out.println("���ƽ׶�...");
		System.out.print(who.toString() + "���ƣ�");
		for (int i = 0; i < num; i++) {
			ArrayList<Card> tmpc = new ArrayList<Card>();// ������ʱ����tmpc
			tmpc.addAll(0, who.getHandcard()); // ������ȫ���ŵ���ʱ������
			// �ƶѼ�⣬���û���ˣ��������ƶ��е���add��ȥ
			if (Initial.listCard.size() == 0) {
				Initial.listCard.addAll(Initial.throwlistCard);
				Initial.throwlistCard.clear();
			}
			tmpc.add(Initial.listCard.get(0)); // ��ȡ�ƶ��еĵ�һ�ţ��Ž���ʱ����
			System.out.print("[" + Initial.listCard.get(0) + "]"); // ��ʾ��������
			Initial.listCard.remove(0); // �ƶ��Ƴ���������
			who.setHandcard(tmpc); // ����ʱ����tmpc����Ϊ��ǰ����
			who.reSetKongCheng();
		}

		System.out.println("\n");
	}

	// ���ƽ׶�
	public void UseCard(Player who, Player towho) {
		System.out.println("���ƽ׶�...");
		// �ֲ�˼���ж�
		if (who.getCharacter().isSkipUseCard() == true) {
			who.getCharacter().setSkipUseCard(false);
			return;
		}
		// ��ʾ�����б�
		// �����������
		// ����Ƿ���Ч����Ч�򷵻�
		// ִ������Ӧ�ķ��� switch
		// ѭ����ֱ��ѡ�����ƣ�
		if (who.getType() == "(AI)") {
			// ****����ֵ�AI���˴�����AI�ķ�����****
			int n = who.getHandcard().size();
			for (int i = 0; i < n; i++) {
				if (n == 0) {
					return;
				}
				// Ԥ����ƣ���ʱ������tmpCard���洢������ƣ���Ч��Ż�
				int r = new Random().nextInt(who.getHandcard().size());
				who.setTmpCard(who.getHandcard().get(r));
				// ������˸��ӣ�����Ϊֱ�ӵ�������ɾ�������ᴥ��ĳЩ����
				ArrayList<Card> tmp = new ArrayList<Card>();
				tmp.addAll(who.getHandcard());
				tmp.remove(r);
				who.setHandcard(tmp);
				// ����Card��use����
				System.out.println(who.toString() + "���ƣ�"
						+ who.getTmpCard().toString());
				if (who.getTmpCard().Use(who, towho)) {
					// �ɹ������
					System.out.println();
					try {
						Thread.sleep(999);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					continue;
				} else {
					// �����ܴ򣬽�Ԥ������ƷŻ�
					System.out.println("��Ч���� - -��");
					who.addhandCard(who.getTmpCard());
				}
				try {
					Thread.sleep(999);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			return;
		}
		while (true) { // ��ҳ��ƹ��̣�һֱ���Գ��ƣ�ֱ��ѡ�����ƻ�������

			System.out.println(who.toString() + "����..." + "\n");
			who.printHandCard();
			System.out
					.println("\n"+"�������������"+"\n"+"0Ϊ������pass��-1Ϊ�����������ܣ�-2Ϊ���������������ܣ�10086��ѯ˫��״̬");
			System.out.print("=>");
			Scanner sc = new Scanner(System.in);
			try { // �������������쳣����
				int r = sc.nextInt();
				// int��������ʾ��������к�[����������ʾ����ʱ��0��Ϊ���ƣ�������Ŷ�+1��ʾ���ڴ���ʱҪ-1]
				if (r == 0) { // ����0Ϊ������
					return;
				}
				if (r == -1) {
					System.out.println("Ŀǰû�п��õ���������");
				} else if (r == -2) {
					who.getCharacter().useSkill(who, towho);
				} else if (r == 10086) {
					who.printInfo();
					towho.printInfo();
				} else {
					System.out.println(who.toString() + "���ƣ�"
							+ who.getHandcard().get(r - 1).toString());
					// Ԥ����ƣ���ʱ������tmpCard���洢������ƣ���Ч��Ż�
					who.setTmpCard(who.getHandcard().get(r - 1));
					// ������˸��ӣ�����Ϊֱ�ӵ�������ɾ�������ᴥ��ĳЩ����
					ArrayList<Card> tmp = new ArrayList<Card>();
					tmp.addAll(who.getHandcard());
					tmp.remove(r - 1);
					who.setHandcard(tmp);
					// ����Card��use����
					if (who.getTmpCard().Use(who, towho)) {
						// �ɹ���������
						System.out.println();
					} else {
						// �����ܴ򣬽�Ԥ������ƷŻ�
						who.addhandCard(who.getTmpCard());
						System.out.println("�������ڲ��ܳ���");
					}
				}

			} catch (Exception e) {// ��������쳣����Ч����
				System.out.println("��������룬���������룡");
				e.printStackTrace();
			}
			// ���Ƶ�ʱ�򣬴������Ƶļ��ܣ���û�д���Ч��������true����ʾȷʵ���ƣ��˳�
			if (who.getHandcard().size() <= 0
					&& who.getCharacter().noCard(who) == true) {
				System.out.println("���ƣ��غϽ���...");
				return;
			}
		}

	}

	// *********���ƽ׶�
	public void ThrowCard(Player who) {
		// Ѫ������������飬�Ϸ���������
		if (who.getHp() >= who.getHandcard().size()) {
			System.out.println("����Ҫ����");
			return;
		}
		// ��ʾ��Ҫ���� (this.getHandcard().size()-this.hp)�����ƣ�
		int n = who.getHandcard().size() - who.getHp();
		System.out.println(who.toString() + "���ƽ׶�..." + "��Ҫ����" + n + "������");
		// ��ʼһ��������
		for (int i = 0; i < n; i++) {
			// --AI�Զ��������---
			if (who.getType().equals("(AI)")) {
				int r = new Random().nextInt(who.getHandcard().size() - 1);// ���������0~��������
				System.out.println(who.getCharacter().getName() + "���ƣ�"
						+ who.getHandcard().get(r));
				Card ctmp = new Card(); // �½�һ����ʱcard
				ctmp = who.getHandcard().get(r); // ��ʱcard���Ҫ�Ƴ�������
				// ɾ��Ҫ��������
				who.removeCard(r);
				Initial.throwlistCard.add(ctmp); // �����������Ʒ�������ƶ�
				continue;
			}
			// ------����ֶ�����ѡ�����ƣ�һ��һ�Ŷ���------------
			Scanner sc = new Scanner(System.in);
			try {
				System.out.println("����Ҫ������������ţ�");
				who.printHandCard(); // �����ƴ�ӡ��������ʾ��ţ��Է������룬�����ʾ��+1����
				int r = sc.nextInt();
				System.out.println(who.toString() + "���ƣ�"
						+ who.getHandcard().get(r - 1));
				Initial.throwlistCard.add(who.getHandcard().get(r - 1)); // �����������Ʒ�������ƶ�
				who.removeCard(r - 1); // ��ʾ�����+1�����Դ���ʱ�����Ҫ-1
			} catch (Exception e) {
				i--;
				System.out.println("��������������룡");
				e.printStackTrace();
			}
		}
	}

	// �غϽ���
	public void End(Player who, Player towho) {
		Initial.who = !(Initial.who);
		System.out.println(this.name + "�ĻغϽ���");
		System.out.println();
	}

	// �����������ܣ�Ĭ��Ϊ�գ�ĳЩ������д
	public void useSkill(Player who, Player towho) {
		System.out.println("Ŀǰû�п��õ���������");
	}

	// ĳЩ���Ա��Ƶı������ܷ�����Ĭ��Ϊ�գ�������������д���������ø���������
	public boolean changeCard(Card c, String key) {
		return false;
	}

	// ���Ʒ��������ڸ��������½ѷ������д����Ϊ������
	public boolean noCard(Player p) {
		return false; // ������д��������Ч����᷵��false
	}

	// �Ƿ����ɱ��Ĭ��Ϊtrue,��ɱ֮����ã��ŷ���д�˷���
	public boolean haveYouSha() {
		return true;
	}

	// ������֮��Ķ�����������Ҫ������������д
	public boolean shaWithOtherCheck(Player p, Player top) {
		return true;
	}

	// �����˺�����,���ؼӳ���ֵ�� ������д
	public int hurtAdd(Player p, Player pHurt) {
		return 0;
	}

	// ǿɱ�¼�������д
	public boolean ignoreShan(Player p, Player top) {
		return false;
	}

	// �ɹ�ʹ�ý��Һ�Ĵ���������Ӣ��д
	public void useJinNang(Player p) {

	}

	// ���˺󴥷��¼�����һ������Ϊ�����ߣ��ڶ���Ϊ����˺���Դ
	public void afterHurt(Player p, Player pSha) {

	}

	// �����ж��������缧��д
	public void checkOnAddCard(Player p, Player top) {

	}

	// �����ж��ƣ�Ĭ�Ͽգ���Щ������Ի��
	// ����1 �ж��� ������2 �ж��� ������3 �Ƿ��ж��ɹ� Ĭ�϶���������
	public void doWithCheckCard(Player p, Card c, boolean succeed) {
		Initial.throwlistCard.add(c);
	}

	// �����滻�ж���,˾��ܲ��д
	// ���ж�����Ϊ������������Ĭ�ϲ����κθı䴫��ȥ
	public Card insteadCard(Player p, Card c) {
		return c;
	}

	// װ��ж���¼�
	public void eqiupUnload(Player p, Player top) {

	}

	// ***********************************�����Ե�get��set��*******************************************************
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getmaxHp() {
		return maxhp;
	}

	public void setmaxHp(int hp) {
		this.maxhp = hp;
	}

	public boolean isSkipUseCard() {
		return skipUseCard;
	}

	public void setSkipUseCard(boolean skipUseCard) {
		this.skipUseCard = skipUseCard;
	}
}
