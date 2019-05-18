package 冒泡排序;
import java.util.Scanner;

public class main {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int[] a=new int[10];
		int b;
		for(int i=0;i<10;i++)
		{
			System.out.println("请输入一个整数：");
			a[i]=in.nextInt();
		}
		for(int j=9;j>0;j--)
		{
			for(int i=0;i<9;i++)
			{
				if(a[i]<a[i+1])
				{
					b=a[i];
					a[i]=a[i+1];
					a[i+1]=b;
				}
			}
		}
		for(int k:a)
		{
			System.out.println(k);
		}
	}

}
