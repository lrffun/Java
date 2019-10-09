package PluralNumber;
//程序名称：复数的四则运算；
//程序目的：练习多态的使用；
//编者：大数据11801郎瑞峰；
//时间：2019年10月9日；

//心得体会：1，时间仓促，写的有些简陋，还有些许bug，还有一些情况没有写到；
//			2，在重复了好几遍提取实部和虚部的代码后想到了把他封装成一个函数，果然，效率提升了不少；
//			3，将函数用途的英文单词的前几个字母用作函数名；
//			4，浮点数的除法还是有点搞不清楚，导致最后那个除法运算无法准确算出结果，后续我会补课改进；
//			5，多态大概就是这样吧，将一个函数的参数表进行多次改变封装成几个函数，从而使改函数适用于不同的场景中。

public class Main {
	public Main() {}
	
	static public int[] getComponent(String a)		//提取虚数的实部和虚部存在数组中；
	{
		int[] num = new int[2];					//存放最终结果
		
		int[] num1 = new int[10];				//存放初步提取的单个数字
		int[] num2 = new int[10];
		
		
		int comnt1 = 0,comnt2 = 0;				//存放实部和虚部数的位数
		
		boolean notChun = false;				//判定是否为纯虚数
		
		for(int i = 0;i < a.length();i++)		//判断是不是非纯虚数
		{
			if(a.charAt(i) == '+')
			{
				notChun = true;
			}
		}
		
		if(notChun)								//是非纯虚数；
		{
			int i,j;
			for(i = 0;i < a.length();i++)		//把加号前的数存在数组中
			{
				if(a.charAt(i) != '+')
				{	
					num1[i] = a.charAt(i) - '0';
				}
				else
				{
					break;
				}
				
			}
			comnt1 = i;
			for(j = i + 1;j < a.length();j++)		//把加号后面的数存在零一个数组中
			{
				if(a.charAt(j) != 'i')
				{
					num2[j - i - 1] = a.charAt(j) - '0';
				}
				else
				{
					break;
				}
				
			}
			comnt2 = j - i - 1;
		}
		else									//考虑纯虚数的情况
		{
			for(int i = 0;i < a.length();i++)
			{
				if(a.charAt(i) != 'i')
				{
					num2[i] = a.charAt(i) - '0';
				}
				else
				{
					break;
				}
			}
		}
		
		if(num2[0] == 0)		//防止把没系数曲解为系数为零
		{
			num2[0] = 1;
		}
		
		for(int i = 0;num1[i] != 0;i++)							//将数组中的单个数字合并成一个数
		{
			num[0] += num1[i] * Math.pow(10,comnt1 - (i + 1));
		}
		
		for(int i = 0;num2[i] != 0;i++)
		{
			num[1] += num2[i] * Math.pow(10,comnt2 - (i + 1));
		}
		
		return num;
	}
	
	public int add(int d,int e)		//整数相加；
	{
		return d+e;
	}
	
	public double add(double a,double b)		//浮点数相加；y
	{
		return a+b;
	}
	
	public String add(String a,int b)		//一个虚数和一个实数相加；
	{
		int[] num = Main.getComponent(a);
		
		int fir = num[0] + b;

		return fir+"+"+num[1]+"i"; 
		
	}
	
	public String add(String a,String b)		//两个虚数相加；
	{
		int[] num1 = Main.getComponent(a);
		int[] num2 = Main.getComponent(b);
		
		int fir = num1[0] + num2[0];

		int sec = num1[1] + num2[1];
		
		return fir+"+"+sec+"i"; 
	
	}
	
	public String sub(String a,int b)			//一个虚数减去一个实数 
	{
		
		int[] num = Main.getComponent(a);
		
		int fir = num[0] - b;

		return fir+"+"+num[1]+"i"; 
	}
	
	public String sub(String a,String b)		//两个虚数相减
	{
		int[] num1 = Main.getComponent(a);
		int[] num2 = Main.getComponent(b);
		
		int fir = num1[0] - num2[0];

		int sec = num1[1] - num2[1];
		
		return fir+"+"+sec+"i"; 
	
	}
	
	public String mult(String a,int b)			//一个虚数和一个实数相乘
	{
		int[] num = Main.getComponent(a);
		
		int fir = num[0] * b;
		int sec = num[1] * b;
		
		return fir + "+" + sec + "i";
	}
	
	public String mult(String a,String b) 		//两个虚数相乘
	{
		int[] num1 = Main.getComponent(a);
		int[] num2 = Main.getComponent(b);
		
		int fir = num1[0] * num2[0] - num1[1] * num2[1];
		int sec = num1[0] * num2[1] + num1[1] * num2[0];
		
		return fir + "+" + sec + "i";
	}
	
	public String division(String a,int b)		//一个虚数除以一个实数
	{
		int[] num = Main.getComponent(a);
		
		float fir = num[0] / b;
		float sec = num[1] / b;
		
		return fir + "+" + sec + "i";
	}
	
	public String division(String a,String b)	//两个虚数相除	
	{
		
		int[] num1 = Main.getComponent(a);
		int[] num2 = Main.getComponent(b);
		
		double fir = (num1[0] * num2[0] + num1[1] * num2[1])/(num2[0]*num2[0]+num2[1]*num2[1]);
		double sec = (num1[0] * num2[1] - num1[1] * num2[0])/(num2[0]*num2[0]+num2[1]*num2[1]);
		
		return fir + "+" + sec + "i";
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		
		System.out.println(main.add(1,1));
		
		System.out.println(main.add(0.1,0.1));
		
		System.out.println(main.add("2+3i",3));
		
		System.out.println(main.add("2+3i","3+4i"));
		
		System.out.println(main.sub("2+3i",1));
		
		System.out.println(main.sub("5+6i","2+3i"));
		
		System.out.println(main.mult("2+3i",2));
		
		System.out.println(main.mult("2+3i","5+6i"));
		
		System.out.println(main.division("4+8i", 2));
		
		System.out.println(main.division("3+4i", "2+3i"));
		
		
	}
}
