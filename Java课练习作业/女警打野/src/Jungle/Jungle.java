package Jungle;

public class Jungle {
	String name;		//英雄名字
	
	double hp;    			//血量
	
	Jungle(String name,double hp)
	{
		this.name = name;
		this.hp = hp;
	}
	
	public double take_medicine(int num)		//嗑药
	{
		
		for(int i = 0;i < num;i++)
		{
			hp *= 2;
		}
		return hp;
	}
	
	public double fight_dragon(double num)		//打龙
	{
		hp = 5*num;
		
		return hp;
	}
	
	public static void main(String[] args) {

		double i = 1;
		
		Jungle nvjing = new Jungle("nvjing",i);		//新召唤一个女警	
		
		nvjing.hp = nvjing.fight_dragon(1.0) / nvjing.take_medicine(5);	//计算她的初始血量
	
		System.out.println("女警开始打龙的时候的血量是" + nvjing.hp);
	}
	

}
