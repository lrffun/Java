package Studying;

public class Studying {
	String[] first = {"张三","李四","王五","马六","蔡七"};
	String[] second = {"在寝室","在教室","在厕所","在澡堂","在家"};
	String[] third = {"吃饭","打麻将","打游戏","唱歌","搞事情"};
	
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
