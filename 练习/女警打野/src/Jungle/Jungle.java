package Jungle;

public class Jungle {
	String name;		//Ӣ������
	
	double hp;    			//Ѫ��
	
	Jungle(String name,double hp)
	{
		this.name = name;
		this.hp = hp;
	}
	
	public double take_medicine(int num)		//�ҩ
	{
		
		for(int i = 0;i < num;i++)
		{
			hp *= 2;
		}
		return hp;
	}
	
	public double fight_dragon(double num)		//����
	{
		hp = 5*num;
		
		return hp;
	}
	
	public static void main(String[] args) {

		double i = 1;
		
		Jungle nvjing = new Jungle("nvjing",i);		//���ٻ�һ��Ů��	
		
		nvjing.hp = nvjing.fight_dragon(1.0) / nvjing.take_medicine(5);	//�������ĳ�ʼѪ��
	
		System.out.println("Ů����ʼ������ʱ���Ѫ����" + nvjing.hp);
	}
	

}
