
public class Card {
	
	private String color;//0-���ң�1-���ģ�2-÷����3-����
	private String num;  //����0-12
	String key;          //keyֵ ӳ����������           ****��Ϊ�����漰���м��ܿ���ת�����ݶ�Ĭ�����η����Է���֮����ܵĲ���*****
//----����--------------------------------------------------------------
	//����
	public Card(){}
	public Card(String color,String num,String key){
		this.color = color;
		this.num = num;
		this.key = key;
	}
	//Card��Ues������ͨ��switch�ж�key��Ӧ��ֵ���������Ӧ�ķ���
	public boolean Use(Player p,Player top){        
		//����n����Ӧhmp��ֵ���е�key��ֵ�������Ӧ��μ�Initial��	
		int n = Integer.valueOf(Initial.hmp.get(new String(key))); 
			
		//�Ȱ����ӽ������ѣ����жϣ�����Ϸ������ˣ����ǲ��Ϸ����ƶ�ɾ�����һ��
		//֮����Ҫ��ô���۵�������Ҫ��Ϊ�˲ܲ��ܹ����ƣ�ͬʱҲΪ��ʵ����ʱ�Խ���
			switch(n){
			case 1:  //����ɱ����������ȡ����ֵ���ٷ��ظ���һ��
				Initial.throwlistCard.add(this);
				if(p.sha(p, top)){
					//�ɹ���ɱ�������ƶ�
					return true;
				}else{
					//�ƶ������һ���Ƴ�
					Initial.throwlistCard.remove(Initial.throwlistCard.size()-1);
					return false; 
				}
			case 2: //������������
				if(p.getType().equals("(���)")){
					System.out.println("������������");
				}
				return false;
			case 3: //Ѫ���������Ѫ��������Ч
				Initial.throwlistCard.add(this);
				if(p.getHp()<p.getCharacter().getmaxHp()){   
					p.tao();
					//�ɹ����ң������ƶ�
				    return true;
				}else {
					//�ƶ������һ���Ƴ�
					Initial.throwlistCard.remove(Initial.throwlistCard.size()-1);
					if(p.getType().equals("(���)")){
						System.out.println("Ѫ��������������");
					}
					return false;
				}
			default://������Ӧ�Ľ��ҷ���
				
				if((n>3 &&  n< 16)){
					Initial.throwlistCard.add(this);
					//System.out.println("������Ӧ�Ľ��ҷ���");
					JinNang jn = new JinNang(n);   //����һ���������ʵ��������Ϊn�������жϵ����ĸ����ҵķ���	
				    boolean b =jn.useJinNang(p,top,this);  //���÷�������ɲ��������棻���򷵻ؼ١�
				    if(b){
				    		//�������������ֲ�˼�񣬲�ֱ���ӵ����Ŷ�����ж�����
				    	if(n==5 || n==10){
				    		//�ƶ������һ���Ƴ�
							Initial.throwlistCard.remove(Initial.throwlistCard.size()-1);
				    	}
				    	p.getCharacter().useJinNang(p);//�ɹ�ʹ�ý�������ô����¼�������Ӣ��
				    }else{
				    	//�ƶ������һ���Ƴ�
						Initial.throwlistCard.remove(Initial.throwlistCard.size()-1);
				    }
					return b;
				    //�����������������ƶѣ�������жϣ��е���ʱ�Խ�����Ҫ�������ǰ��
				}
				if(n>=16 && n<31){//������Ӧ�������ļ����¼�
					this.install(p, top, n);
					//System.out.println("������Ӧ�������¼�");
					return true;
				}
			}
		return false;
	}
	//װ����װ���¼��Ĵ�����
	public void install(Player p,Player top,int index){ 
		//����ø���������������ж�أ�����ж���¼�����װ��
		if(p.getEqiup(0)!= null){
			p.getEqiup(0).uninstall(p, top, index);
		}
			
		    //�����࣬�����ͺ����ӹ�������
			if(index>=16 && index <=23){
				p.setDisAtt(p.getDisAtt()+1);
				p.setEqiup(this, 0);
			}
			//24Ϊ������
			if(index == 24){
				p.setEqiup(this, 1);
			}
			//-1��
			if(index>=25 && index<=27){
				p.setEqiup(this, 2);
				p.setDisAtt(p.getDisAtt()+1);
			}
			//+1��
			if(index>=28 && index<=30){
				p.setEqiup(this, 3);
				p.setDisDef(p.getDisDef()+1);
			}
			System.out.println(p.toString()+"װ����"+this.key );
	}
	 //װ����ж��ʱ��Ĵ�����
	public void uninstall(Player p,Player top,int index){
		//�����࣬�����ͺ����ӹ�������
		if(index>=16 && index <=23){
			p.setDisAtt(p.getDisAtt()-1);
		}
		//-1��
		if(index>=25 && index<=27){
			p.setDisAtt(p.getDisAtt()-1);
		}
		//+1��
		if(index>=28 && index<=30){
			p.setDisDef(p.getDisDef()-1);
		}
		Initial.throwlistCard.add(this);
		//��������װ��ж���¼�
		p.getCharacter().eqiupUnload(p,top);
	}
	//*********************************��set get��*************************************
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	//---------------------------------------------------------------------------------
	public String toString(){       //��дtoString���������س���ɫ+����+����
		return this.color+this.num+"--"+this.key ;
	}
}
