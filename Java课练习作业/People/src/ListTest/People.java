/*程序名称：People
 * 需求：复习集合的用处
 * 编者：郎瑞峰
 * 班级：软工（大数据）11801班
 */
package ListTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class People {
	String name = "";
	int age;
	double stature;
	double weight;
	double vision;
	
	public People(String name,int age,double stature,double weight,double vision)
	{
		this.name = name;
		this.age = age;
		this.stature = stature;
		this.weight = weight;
		this.vision = vision;
	}
	
	public String toMyString()
	{
		return name+"  "+age+"  "+stature+"  "+weight+"  "+vision;
	}
	
	public static void main(String[] args) {
		ArrayList<People> people = new ArrayList<People>();
		List<People> list = new ArrayList<People>(20);
		people.add(new People("张三",20,170,50,4.0));
		people.add(new People("李四",21,165,54,5.0));
		people.add(new People("王五",19,187,51,6.0));
		people.add(new People("马六",10,198,48,5.1));
		people.add(new People("杜七",85,114,65,5.2));
		people.add(new People("范八",31,120,66,4.3));
		people.add(new People("狗十三",13,163,83,2.0));
		Collections.sort(people,new Comparator<People>() {

			@Override
			public int compare(People o1, People o2) {
				// TODO Auto-generated method stub
				return o2.age - o1.age;
			}});
		System.out.println("按年龄排序:");
		for(People p:people)
		{
			System.out.println(p.toMyString());	
		}
		
		
		Collections.sort(people,new Comparator<People>() {		//按身高排序

			@Override
			public int compare(People o1, People o2) {
				// TODO Auto-generated method stub
				return Double.compare(o1.stature, o2.stature);
			}
			
		});
		System.out.println("\n\n\n按身高排序：");
		for(People p:people)
		{
			System.out.println(p.toMyString());	
		}
		
		Collections.sort(people,new Comparator<People>() {		//按体重排序

			@Override
			public int compare(People o1, People o2) {
				// TODO Auto-generated method stub
				return Double.compare(o1.weight,o2.weight);
			}
			
		});
		System.out.println("\n\n\n按体重排序:");
		for(People p:people)
		{
			System.out.println("-"+p.toMyString());
		}
		
		Collections.sort(people,new Comparator<People>() {		//按视力排序

			@Override
			public int compare(People o1, People o2) {
				// TODO Auto-generated method stub
				return Double.compare(o1.vision,o2.vision);
			}
			
		});
		System.out.println("\n\n\n按体重排序:");
		for(People p:people)
		{
			System.out.println("-"+p.toMyString());
		}
	}
	
}
