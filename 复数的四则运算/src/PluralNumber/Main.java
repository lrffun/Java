package PluralNumber;
//�������ƣ��������������㣻
//����Ŀ�ģ���ϰ��̬��ʹ�ã�
//���ߣ�������11801����壻
//ʱ�䣺2019��10��9�գ�

//�ĵ���᣺1��ʱ��ִ٣�д����Щ��ª������Щ��bug������һЩ���û��д����
//			2�����ظ��˺ü�����ȡʵ�����鲿�Ĵ�����뵽�˰�����װ��һ����������Ȼ��Ч�������˲��٣�
//			3����������;��Ӣ�ĵ��ʵ�ǰ������ĸ������������
//			4���������ĳ��������е�㲻�������������Ǹ����������޷�׼ȷ�������������һᲹ�θĽ���
//			5����̬��ž��������ɣ���һ�������Ĳ�������ж�θı��װ�ɼ����������Ӷ�ʹ�ĺ��������ڲ�ͬ�ĳ����С�

public class Main {
	public Main() {}
	
	static public int[] getComponent(String a)		//��ȡ������ʵ�����鲿���������У�
	{
		int[] num = new int[2];					//������ս��
		
		int[] num1 = new int[10];				//��ų�����ȡ�ĵ�������
		int[] num2 = new int[10];
		
		
		int comnt1 = 0,comnt2 = 0;				//���ʵ�����鲿����λ��
		
		boolean notChun = false;				//�ж��Ƿ�Ϊ������
		
		for(int i = 0;i < a.length();i++)		//�ж��ǲ��ǷǴ�����
		{
			if(a.charAt(i) == '+')
			{
				notChun = true;
			}
		}
		
		if(notChun)								//�ǷǴ�������
		{
			int i,j;
			for(i = 0;i < a.length();i++)		//�ѼӺ�ǰ��������������
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
			for(j = i + 1;j < a.length();j++)		//�ѼӺź������������һ��������
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
		else									//���Ǵ����������
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
		
		if(num2[0] == 0)		//��ֹ��ûϵ������Ϊϵ��Ϊ��
		{
			num2[0] = 1;
		}
		
		for(int i = 0;num1[i] != 0;i++)							//�������еĵ������ֺϲ���һ����
		{
			num[0] += num1[i] * Math.pow(10,comnt1 - (i + 1));
		}
		
		for(int i = 0;num2[i] != 0;i++)
		{
			num[1] += num2[i] * Math.pow(10,comnt2 - (i + 1));
		}
		
		return num;
	}
	
	public int add(int d,int e)		//������ӣ�
	{
		return d+e;
	}
	
	public double add(double a,double b)		//��������ӣ�y
	{
		return a+b;
	}
	
	public String add(String a,int b)		//һ��������һ��ʵ����ӣ�
	{
		int[] num = Main.getComponent(a);
		
		int fir = num[0] + b;

		return fir+"+"+num[1]+"i"; 
		
	}
	
	public String add(String a,String b)		//����������ӣ�
	{
		int[] num1 = Main.getComponent(a);
		int[] num2 = Main.getComponent(b);
		
		int fir = num1[0] + num2[0];

		int sec = num1[1] + num2[1];
		
		return fir+"+"+sec+"i"; 
	
	}
	
	public String sub(String a,int b)			//һ��������ȥһ��ʵ�� 
	{
		
		int[] num = Main.getComponent(a);
		
		int fir = num[0] - b;

		return fir+"+"+num[1]+"i"; 
	}
	
	public String sub(String a,String b)		//�����������
	{
		int[] num1 = Main.getComponent(a);
		int[] num2 = Main.getComponent(b);
		
		int fir = num1[0] - num2[0];

		int sec = num1[1] - num2[1];
		
		return fir+"+"+sec+"i"; 
	
	}
	
	public String mult(String a,int b)			//һ��������һ��ʵ�����
	{
		int[] num = Main.getComponent(a);
		
		int fir = num[0] * b;
		int sec = num[1] * b;
		
		return fir + "+" + sec + "i";
	}
	
	public String mult(String a,String b) 		//�����������
	{
		int[] num1 = Main.getComponent(a);
		int[] num2 = Main.getComponent(b);
		
		int fir = num1[0] * num2[0] - num1[1] * num2[1];
		int sec = num1[0] * num2[1] + num1[1] * num2[0];
		
		return fir + "+" + sec + "i";
	}
	
	public String division(String a,int b)		//һ����������һ��ʵ��
	{
		int[] num = Main.getComponent(a);
		
		float fir = num[0] / b;
		float sec = num[1] / b;
		
		return fir + "+" + sec + "i";
	}
	
	public String division(String a,String b)	//�����������	
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
