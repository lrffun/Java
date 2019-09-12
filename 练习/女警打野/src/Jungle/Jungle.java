package Jungle;

import java.util.Scanner;

public class Jungle {
	String name;		//英雄名字
	
	int hp;    			//血量
	
	Jungle(String name,int hp)
	{
		name = this.name;
		hp = this.hp;
	}
	
	public int take_medicine(int num)
	{
		for(int i = 0;i < num;i++)
		{
			hp *= 2;
		}
		return hp;
	}
	
	public int fight_dragon(int num)
	{
		hp = hp - 5*num;
		
		return hp;
	}
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("请输入龙的伤害：");
		
		int num = in.nextInt();
		
		int i;
		
		for(i = 1;i < 100;i++)
		{
			Jungle nvjing = new Jungle("nvjing",i);		//新召唤一个女警	
			
			nvjing.hp = nvjing.take_medicine(5);		//女警嗑药;
			
			if(0 == nvjing.fight_dragon(num))
			{
				break;
			};
		}
		
		System.out.println("女警开始打龙的时候的血量是" + i);
	}
}
