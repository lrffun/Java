package Main;

//本程序的目的是计算函数f(x) =2x^2 + x + 3;在一定区间内的定积分。
//											——程序作者：软工（大数据）   郎瑞峰

import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float 	a = 0,				//积分上限
				b = 0,				//积分下限			
				c = 0,				//分割段长
				d = 0,				//中间变量
				result = 0;			//运算结果
		int 	n = 0;				//分割段数
		
		System.out.println("本程序的目的是计算函数f(x) = 3x^2 + 2x + 3;在一定区间内的定积分。");
		
		Scanner in = new Scanner(System.in);
				
		System.out.println("请输入积分下限b");
		b = in.nextFloat();
		
		System.out.println("请输入积分上限a");
		a = in.nextFloat();
		
		System.out.println("请输入分割的段数n");
		n = in.nextInt();
		
		c = (a - b)/n;
		
		for (float i = 0; i < a - b;i+=c)
		{
			d = 3 * (b + i) * (b + i) + 2 * (b + i) + 3;
			result = d * c + result;
		}
		
		System.out.println("函数f(x) = 3x^2 + 2x + 3;从" + a + "积到" + b + "的结果为" + result);
	}

}
