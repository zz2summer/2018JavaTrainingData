
import java.util.Random;


//****************AI�����*********************
public class PlayerAI extends Player{ 
	
	public PlayerAI(){}
	public PlayerAI(Character character,int hp){
		super(character,hp);
		this.setType("(AI)");
	}
//---��������д�ķ�����---------------------------------------------------------------
	public void printHandCard(){  //��д��ӡ���ƣ�����������ʾ��ֻ��������ж�������
		System.out.print(this.toString() + "��ǰ���ƣ�");
		for (int i = 0; i < this.getHandcard().size(); i++) {
			System.out.print("[����" + (i+1) + "]");
		}
		System.out.println();
	}
	//AI��дѡ��Է����Ƶķ�����������������ѡ1��
	public int selectCard(Player top){
		Random r = new Random();
		return r.nextInt(top.getHandcard().size());
	}
	//AI��дѡ��  ����ֵ��Ϊ0-size
	public int selectCardIndex(int size) {
		Random r=new Random();
		return r.nextInt(size);

	}
	//--------------AI��дҪ���ɱ��Ҫ������ķ���
	//��Ҫ����� 
	public boolean requestshan(Player p,Player top){    
    	//����Ƿ��а��ԣ�������ð������ܷ������ɹ�����true
		if (this.getEqiup(1) != null) {
			boolean b = this.useBaGua(this, top);
			if(b==true){
				System.out.println("��������Ч��");
				return b;
			}else{
				System.out.println("��������Ч����Ҫ������");
			}
		}
    	//����Ƿ�����������������ɹ�����true
		//�����������ƣ��з��������ľͳ�
		for (int i = 0; i < this.getHandcard().size(); i++) {
			if (this.getHandcard().get(i).key.equals("��")|| this.getCharacter().changeCard(
					this.getHandcard().get(i), "��")) {// �˴���һ��or �Ƿ��ܱ�����Ч��
				System.out.println("AI������"+this.getHandcard().get(i).toString());
				this.setTmpCard(this.getHandcard().get(i));
				Initial.throwlistCard.add(this.getHandcard().get(i));
				this.removeCard(i);
				return true;
			}
		}
		// �������ޣ�����false
		System.out.println(this.toString()+"������...");
		return false;
    }
	 //��Ҫ���ɱ�����м��
    public boolean requestSha(){    
    	System.out.println(this.toString()+"��Ҫ��ɱ");
    	//�����������ƣ��з��������ľͳ�
    	for (int i = 0; i < this.getHandcard().size(); i++) {
			if (this.getHandcard().get(i).key.equals("ɱ")|| this.getCharacter().changeCard(
					this.getHandcard().get(i), "ɱ")) {// �˴���һ��or �Ƿ��ܱ�����Ч��
				System.out.println("AI��ɱ��"+this.getHandcard().get(i).toString());
				this.setTmpCard(this.getHandcard().get(i));
				Initial.throwlistCard.add(this.getHandcard().get(i));
				this.removeCard(i);
				return true;
			}
		}
    	System.out.println(this.toString()+"����ɱ...");
    	return false;
    }
    //��Ӧ��и�ɻ�
    public boolean requestWuXie(Player top){    
    	for (int i = 0; i < this.getHandcard().size(); i++) {
			if (this.getHandcard().get(i).key.equals("��и�ɻ�")) {// �˴���һ��or �Ƿ��ܱ�����Ч��
				System.out.println("��AI�����ƣ�"+this.getHandcard().get(i).toString());
				Initial.throwlistCard.add(this.getHandcard().get(i));
				this.removeCard(i);
				if(top.requestWuXie(this)==true){
					System.out.println(this.toString()+"����и�ɻ���"+top.toString()+"����и�ɻ������");
					return false;
				}
				return true;
			}
		}
    	return false;
    }
    //----------------------------------------------------------------------------
}
