package Studying;

public class Studying {
	String[] first = {"����","����","����","����","����"};
	String[] second = {"������","�ڽ���","�ڲ���","������","�ڼ�"};
	String[] third = {"�Է�","���齫","����Ϸ","����","������"};
	
	int a = (int)(Math.random()*first.length),
		b = (int)(Math.random()*second.length),
		c = (int)(Math.random()*third.length);
	
	Studying()
	{
		
	}

	public String print()
	{
		String S = first[a] + second[b] + third[c];
		return S;
	}
	
	public static void main(String[] args){
		
		Studying study = new Studying();
		
		String s = study.print();
		
		System.out.println(s);
	}
}
