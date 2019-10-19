package com.triangle.Areaandperimeter;

import java.util.Scanner;

public class Triangle {
	double bian1 = 0;			//�����ε������߳�
	double bian2 = 0;
	double bian3 = 0;
	
	public Triangle(double bian1,double bian2,double bian3)		//���캯��
	{
		this.bian1 = bian1;
		this.bian2 = bian2;
		this.bian3 = bian3;
	}
	
	public double Area()			//�������ε����
	{	
		double Area;
		Area = Math.sqrt((bian1+bian2+bian3)*(bian1+bian2-bian3)*(bian1+bian3-bian2)*(bian2+bian3-bian1))/4;
		//��((a+b+c)*(a+b-c)*(a+c-b)*(b+c-a))/4��
		return Area;
	}
	
	public double Perimeter()			//�������ε��ܳ�
	{
		return bian1+bian2+bian3;
	}
	
	public static void main(String[] args) throws Exception{
		boolean No = true;			//���岼��ֵ�����Ƿ񹹳�������
		double a,b,c;
		Scanner in = new Scanner(System.in);
		do {			
			System.out.println("�����������ε����߳�:");		
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
					throw e;			//���������������׳��쳣
				}
			}catch(Exception ex)			//��׽���쳣������
			{
				System.out.println("������������޷����������Σ����������룺");
			}
		}while(No);
		Triangle tri = new Triangle(a,b,c);
		System.out.println("�����ε����Ϊ"+tri.Area());
		System.out.println("�����ε��ܳ�Ϊ"+tri.Perimeter());
		in.close();
	}
}
