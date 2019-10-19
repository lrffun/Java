package com.triangle.Areaandperimeter;

import java.util.Scanner;

public class Triangle {
	double bian1 = 0;			//三角形的三条边长
	double bian2 = 0;
	double bian3 = 0;
	
	public Triangle(double bian1,double bian2,double bian3)		//构造函数
	{
		this.bian1 = bian1;
		this.bian2 = bian2;
		this.bian3 = bian3;
	}
	
	public double Area()			//求三角形的面积
	{	
		double Area;
		Area = Math.sqrt((bian1+bian2+bian3)*(bian1+bian2-bian3)*(bian1+bian3-bian2)*(bian2+bian3-bian1))/4;
		//√((a+b+c)*(a+b-c)*(a+c-b)*(b+c-a))/4。
		return Area;
	}
	
	public double Perimeter()			//求三角形的周长
	{
		return bian1+bian2+bian3;
	}
	
	public static void main(String[] args) throws Exception{
		boolean No = true;			//定义布尔值储存是否构成三角形
		double a,b,c;
		Scanner in = new Scanner(System.in);
		do {			
			System.out.println("请输入三角形的三边长:");		
			a = in.nextDouble();
			b = in.nextDouble();
			c = in.nextDouble();		
			Exception e = new Exception();
			try
			{
				if(a+b>c&&b+c>a&&a+c>b)
				{
					No = false;
				}
				else
				{
					throw e;			//不构成三角形则抛出异常
				}
			}catch(Exception ex)			//捕捉到异常并处理
			{
				System.out.println("您输入的三边无法构成三角形，请重新输入：");
			}
		}while(No);
		Triangle tri = new Triangle(a,b,c);
		System.out.println("三角形的面积为"+tri.Area());
		System.out.println("三角形的周长为"+tri.Perimeter());
		in.close();
	}
}
